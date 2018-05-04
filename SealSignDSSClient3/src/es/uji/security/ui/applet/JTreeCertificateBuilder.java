package es.uji.security.ui.applet;

//import java.lang.reflect.Array;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
//import java.util.Arrays;
import java.util.Hashtable;
import java.util.Vector;

import javax.swing.tree.DefaultMutableTreeNode;

import org.apache.log4j.Logger;

import es.uji.security.crypto.SupportedKeystore;
import es.uji.security.keystore.IKeyStore;
import es.uji.security.keystore.X509CertificateHandler;
import es.uji.security.util.i18n.LabelManager;

public class JTreeCertificateBuilder
{
    private Logger log = Logger.getLogger(JTreeCertificateBuilder.class);
    
    public JTreeCertificateBuilder()
    {
    }

    public DefaultMutableTreeNode build(AppHandler aph, String acceptedIssuers[], String certificateHashFilter, String certificateSerialFilter, Hashtable<SupportedKeystore, IKeyStore> ksh) throws Exception
    {
        log.debug("Building certificate tree");
        
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(LabelManager.get("LABEL_TREE_ROOT"));

        if (ksh == null)
        {
            throw new IllegalArgumentException("Keystore hastable can't be null");
        }

        X509Certificate xcert;
        X509CertificateHandler certHandle;
        
        boolean found = false;
        boolean accepted = false;

        Vector<String> caStrs = new Vector<String>();
        Vector<DefaultMutableTreeNode> caNodes = new Vector<DefaultMutableTreeNode>();

        for (IKeyStore keystore : ksh.values())
        {
            try
            {             
            	Certificate[] certs = keystore.getUserCertificates();
                
                if (certs != null)
                {
                    for (Certificate cer : certs)
                    {
                        found = false;
                        accepted = false;
                        xcert = (X509Certificate)cer;

                        if (xcert != null)
                        {
                        	certHandle = new X509CertificateHandler(xcert, "none", keystore);
                            
                            if (acceptedIssuers == null)
                            {
                            	accepted = true;
                            }
                            else
                            {
                            	for (String acceptedIssuer : acceptedIssuers) 
                            	{
									if (certHandle.getCertificate().getIssuerDN().getName().contains(acceptedIssuer))
									{
										accepted = true;
										break;
									}
								}
                            }
                            
                            if (accepted && certificateSerialFilter != null && certificateSerialFilter.length() > 0)
                            {
                            	String serialHex = certHandle.getCertificate().getSerialNumber().toString(16);
                            	if (serialHex.toLowerCase().equals(certificateSerialFilter.toLowerCase()))
                            	{
                            		accepted = true;
                            	}
                            	else
                            	{
                            		accepted = false;
                            	}
                            }
                            
                            if (accepted)
                            {
	                            for (int j = 0; j < caStrs.size(); j++)
	                            {
	                                if (((String) caStrs.get(j)).equals(certHandle.getIssuerOrganization()))
	                                {
	                                    ((DefaultMutableTreeNode)caNodes.get(j)).add(new DefaultMutableTreeNode(certHandle));
	                                    found = true;
	                                }
	                            }
	
	                            if (!found)
	                            {
	                                String issuerOrg = certHandle.getIssuerOrganization();
	                                DefaultMutableTreeNode nodeAux = new DefaultMutableTreeNode(issuerOrg);
	                                nodeAux.add(new DefaultMutableTreeNode(certHandle));
	                                caStrs.add(issuerOrg);
	                                root.add(nodeAux);
	                                caNodes.add(nodeAux);
	                            }
                            }
                        }
                    }
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        
        return root;
    }
}
