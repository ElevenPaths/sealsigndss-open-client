/**
 * auto-gen
 */

package org.tempuri;


/**
 * Class to configure remote host.
 *
 */
public final class Configuration {

    /**
     * Prohibits instantiation.
     */
    private Configuration(){
    }

    /**
     * URL.
     */
    private static String wsUrl = null;
    private static boolean useNativeTransport = false;

    /**
     * Configures address of web service, for example
     * <tt>http://localhost:8080/Ws2Ksoap/services/HelloWorld</tt>.
     *
     * @param wsUrl
     *              The address to access to web service.
     */
    public static void setConfiguration(final String wsUrl) {
        if (wsUrl != null) {
            Configuration.wsUrl = wsUrl;
        }
    }
    
    public static void setUseNativeTransport(final boolean useNative) {
        Configuration.useNativeTransport = useNative;
    }

    public static boolean getUseNativeTransport() {
        return useNativeTransport;
    }
    
    /**
     *
     * @return The address which the web service is deployed.
     */
    public static String getWsUrl() {
        return wsUrl;
    }
}
