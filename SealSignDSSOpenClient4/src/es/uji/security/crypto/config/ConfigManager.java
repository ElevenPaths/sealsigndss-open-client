package es.uji.security.crypto.config;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ConfigManager
{
    private Logger log = Logger.getLogger(ConfigManager.class);

    private static Properties props = new Properties();
    private static ConfigManager configManager = null;

    private static String DEFAULT_CONFIG_FILE = "ujiCrypto.conf";

    public static ConfigManager getInstance()
    {
        if (configManager == null)
        {
            configManager = new ConfigManager(null);
        }

        return configManager;
    }

    public static ConfigManager getInstance(Properties properties)
    {
        if (configManager == null)
        {
            configManager = new ConfigManager(properties);
        }

        return configManager;
    }

    public Properties getDefaultProperties()
    {
        Properties prop = new Properties();

        return prop;
    }

    private ConfigManager(Properties properties)
    {
        // Try to load system properties

        if (properties != null)
        {
            props.putAll(properties);
        }
        else
        {
            try
            {
                props.load(ConfigManager.class.getClassLoader().getResourceAsStream(
                        DEFAULT_CONFIG_FILE));
            }
            catch (IOException e)
            {
                log.error("Cant not load ujiCrypto.conf file", e);
            }
        }

        props.putAll(getDefaultProperties());
    }

    public String getProperty(String key)
    {
        return props.getProperty(key);
    }

    public void setProperty(String key, String value)
    {
        props.setProperty(key, value);
    }

    public String getStringProperty(String key, String def)
    {
        return props.getProperty(key, def);
    }

    public int getIntProperty(String key, int def)
    {
        int rc = def;

        try
        {
            rc = Integer.parseInt(props.getProperty(key));
        }
        catch (NumberFormatException ex)
        {
            log.error("Error parsing number: " + key, ex);
        }

        return rc;
    }

    public ArrayList<Device> getDeviceConfig()
    {
        String deviceList = getProperty("cryptoapplet.devices");
        ArrayList<Device> result = new ArrayList<Device>();

        if (deviceList != null)
        {
            for (String device : deviceList.split(","))
            {
                String deviceName = getProperty("cryptoapplet.devices." + device + ".name");
                String deviceSlot = getProperty("cryptoapplet.devices." + device + ".slot");

                String deviceLibrariesList = "";

                if (OS.isLinux())
                {
                    deviceLibrariesList = getProperty("cryptoapplet.devices." + device
                            + ".libraries.linux");
                }
                else if (OS.isWindowsUpperEqualToNT())
                {
                    deviceLibrariesList = getProperty("cryptoapplet.devices." + device
                            + ".libraries.windows");
                }else {
                		deviceLibrariesList = getProperty("cryptoapplet.devices." + device
                            + ".libraries.mac");
                		log.debug("Nadal:cryptoapplet.devices." + device
                            + ".libraries.mac");
                		log.debug(deviceLibrariesList);
                }
                
                log.debug("New Applet 27/9/2017");

                String deviceLibrary = null;

                for (String library : deviceLibrariesList.split(","))
                {
                    File f = new File(library);

                    if (f.exists())
                    {
                        deviceLibrary = library;
                        break;
                    }
                    else
                    {
                    	log.error("Library " + library + " not found");
                    }
                }

                if (deviceLibrary != null)
                {
                    Device newDevice = new Device(deviceName, deviceLibrary, deviceSlot);
                    
                    try
                    {           	
                        Provider provider = new sun.security.pkcs11.SunPKCS11(
                                new ByteArrayInputStream(newDevice.toString().getBytes()));
                        Security.addProvider(provider);

                        KeyStore.getInstance("PKCS11", provider);

                        result.add(newDevice);
                    }
                    catch (Exception e)
                    {
                        log.error("Could not initialize " + newDevice.getName() + " in slot "
                                + newDevice.getSlot() + " loading " + newDevice.getLibrary());
                        continue;
                    }
                }
            }
        }

        return result;
    }

    public static X509Certificate readCertificate(String certLocation) throws KeyStoreException,
            IOException, CertificateException, NoSuchAlgorithmException
    {
        ConfigManager conf = ConfigManager.getInstance();

        InputStream certificateStream = null;

        if (certLocation.startsWith("http"))
        {
            URL url = new URL(certLocation);
            certificateStream = url.openStream();
        }
        else if (certLocation.startsWith("jar://"))
        {
            ClassLoader classLoader = ConfigManager.class.getClassLoader();
            certificateStream = classLoader.getResourceAsStream(certLocation.substring(6));
        }
        else if (certLocation.startsWith("keystore://"))
        {
            ClassLoader classLoader = ConfigManager.class.getClassLoader();
            certificateStream = classLoader.getResourceAsStream(conf
                    .getProperty("DEFAULT_KEYSTORE"));

            String str_cert = certLocation.substring(11);
            KeyStore keystore = KeyStore.getInstance("JKS");

            keystore.load(certificateStream, conf.getProperty("DEFAULT_KEYSTORE_PASSWORD")
                    .toCharArray());

            return (X509Certificate) keystore.getCertificate(str_cert);
        }
        else
        {
            certificateStream = new FileInputStream(certLocation);
        }

        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
        X509Certificate certificate = (X509Certificate) certificateFactory
                .generateCertificate(certificateStream);
        certificateStream.close();

        return certificate;
    }
}