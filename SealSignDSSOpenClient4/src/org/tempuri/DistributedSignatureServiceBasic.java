
package org.tempuri;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "DistributedSignatureServiceBasic", targetNamespace = "http://tempuri.org/", wsdlLocation = "http://10.0.1.171:8733/SealSignDSSService/DistributedSignatureServiceBasic.svc?wsdl")
public class DistributedSignatureServiceBasic
    extends Service
{

    private static URL DISTRIBUTEDSIGNATURESERVICEBASIC_WSDL_LOCATION;
    private static WebServiceException DISTRIBUTEDSIGNATURESERVICEBASIC_EXCEPTION;
    private final static QName DISTRIBUTEDSIGNATURESERVICEBASIC_QNAME = new QName("http://tempuri.org/", "DistributedSignatureServiceBasic");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://10.0.1.171:8733/SealSignDSSService/DistributedSignatureServiceBasic.svc?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        DISTRIBUTEDSIGNATURESERVICEBASIC_WSDL_LOCATION = url;
        DISTRIBUTEDSIGNATURESERVICEBASIC_EXCEPTION = e;
    }

    public DistributedSignatureServiceBasic(String wsdlLocation) throws MalformedURLException {
        super(new URL(wsdlLocation), DISTRIBUTEDSIGNATURESERVICEBASIC_QNAME);
        
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL(wsdlLocation);
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        DISTRIBUTEDSIGNATURESERVICEBASIC_WSDL_LOCATION = url;
        DISTRIBUTEDSIGNATURESERVICEBASIC_EXCEPTION = e;
    }
    
    public DistributedSignatureServiceBasic() {
        super(__getWsdlLocation(), DISTRIBUTEDSIGNATURESERVICEBASIC_QNAME);
    }

    public DistributedSignatureServiceBasic(WebServiceFeature... features) {
        super(__getWsdlLocation(), DISTRIBUTEDSIGNATURESERVICEBASIC_QNAME, features);
    }

    public DistributedSignatureServiceBasic(URL wsdlLocation) {
        super(wsdlLocation, DISTRIBUTEDSIGNATURESERVICEBASIC_QNAME);
    }

    public DistributedSignatureServiceBasic(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, DISTRIBUTEDSIGNATURESERVICEBASIC_QNAME, features);
    }

    public DistributedSignatureServiceBasic(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public DistributedSignatureServiceBasic(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns IDistributedSignatureServiceBasic
     */
    @WebEndpoint(name = "WSHttpBinding_IDistributedSignatureServiceBasic")
    public IDistributedSignatureServiceBasic getWSHttpBindingIDistributedSignatureServiceBasic() {
        return super.getPort(new QName("http://tempuri.org/", "WSHttpBinding_IDistributedSignatureServiceBasic"), IDistributedSignatureServiceBasic.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IDistributedSignatureServiceBasic
     */
    @WebEndpoint(name = "WSHttpBinding_IDistributedSignatureServiceBasic")
    public IDistributedSignatureServiceBasic getWSHttpBindingIDistributedSignatureServiceBasic(WebServiceFeature... features) {
        return super.getPort(new QName("http://tempuri.org/", "WSHttpBinding_IDistributedSignatureServiceBasic"), IDistributedSignatureServiceBasic.class, features);
    }

    /**
     * 
     * @return
     *     returns IDistributedSignatureServiceBasic
     */
    @WebEndpoint(name = "WSHttpBinding_IDistributedSignatureServiceBasic1")
    public IDistributedSignatureServiceBasic getWSHttpBindingIDistributedSignatureServiceBasic1() {
        return super.getPort(new QName("http://tempuri.org/", "WSHttpBinding_IDistributedSignatureServiceBasic1"), IDistributedSignatureServiceBasic.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IDistributedSignatureServiceBasic
     */
    @WebEndpoint(name = "WSHttpBinding_IDistributedSignatureServiceBasic1")
    public IDistributedSignatureServiceBasic getWSHttpBindingIDistributedSignatureServiceBasic1(WebServiceFeature... features) {
        return super.getPort(new QName("http://tempuri.org/", "WSHttpBinding_IDistributedSignatureServiceBasic1"), IDistributedSignatureServiceBasic.class, features);
    }

    /**
     * 
     * @return
     *     returns IDistributedSignatureServiceBasic
     */
    @WebEndpoint(name = "WSHttpBinding_IDistributedSignatureServiceBasic2")
    public IDistributedSignatureServiceBasic getWSHttpBindingIDistributedSignatureServiceBasic2() {
        return super.getPort(new QName("http://tempuri.org/", "WSHttpBinding_IDistributedSignatureServiceBasic2"), IDistributedSignatureServiceBasic.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IDistributedSignatureServiceBasic
     */
    @WebEndpoint(name = "WSHttpBinding_IDistributedSignatureServiceBasic2")
    public IDistributedSignatureServiceBasic getWSHttpBindingIDistributedSignatureServiceBasic2(WebServiceFeature... features) {
        return super.getPort(new QName("http://tempuri.org/", "WSHttpBinding_IDistributedSignatureServiceBasic2"), IDistributedSignatureServiceBasic.class, features);
    }

    /**
     * 
     * @return
     *     returns IDistributedSignatureServiceBasic
     */
    @WebEndpoint(name = "BasicHttpBinding_IDistributedSignatureServiceBasic")
    public IDistributedSignatureServiceBasic getBasicHttpBindingIDistributedSignatureServiceBasic() {
        return super.getPort(new QName("http://tempuri.org/", "BasicHttpBinding_IDistributedSignatureServiceBasic"), IDistributedSignatureServiceBasic.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IDistributedSignatureServiceBasic
     */
    @WebEndpoint(name = "BasicHttpBinding_IDistributedSignatureServiceBasic")
    public IDistributedSignatureServiceBasic getBasicHttpBindingIDistributedSignatureServiceBasic(WebServiceFeature... features) {
        return super.getPort(new QName("http://tempuri.org/", "BasicHttpBinding_IDistributedSignatureServiceBasic"), IDistributedSignatureServiceBasic.class, features);
    }

    /**
     * 
     * @return
     *     returns IDistributedSignatureServiceBasic
     */
    @WebEndpoint(name = "BasicHttpBinding_IDistributedSignatureServiceBasic1")
    public IDistributedSignatureServiceBasic getBasicHttpBindingIDistributedSignatureServiceBasic1() {
        return super.getPort(new QName("http://tempuri.org/", "BasicHttpBinding_IDistributedSignatureServiceBasic1"), IDistributedSignatureServiceBasic.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IDistributedSignatureServiceBasic
     */
    @WebEndpoint(name = "BasicHttpBinding_IDistributedSignatureServiceBasic1")
    public IDistributedSignatureServiceBasic getBasicHttpBindingIDistributedSignatureServiceBasic1(WebServiceFeature... features) {
        return super.getPort(new QName("http://tempuri.org/", "BasicHttpBinding_IDistributedSignatureServiceBasic1"), IDistributedSignatureServiceBasic.class, features);
    }

    /**
     * 
     * @return
     *     returns IDistributedSignatureServiceBasic
     */
    @WebEndpoint(name = "BasicHttpBinding_IDistributedSignatureServiceBasic2")
    public IDistributedSignatureServiceBasic getBasicHttpBindingIDistributedSignatureServiceBasic2() {
        return super.getPort(new QName("http://tempuri.org/", "BasicHttpBinding_IDistributedSignatureServiceBasic2"), IDistributedSignatureServiceBasic.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IDistributedSignatureServiceBasic
     */
    @WebEndpoint(name = "BasicHttpBinding_IDistributedSignatureServiceBasic2")
    public IDistributedSignatureServiceBasic getBasicHttpBindingIDistributedSignatureServiceBasic2(WebServiceFeature... features) {
        return super.getPort(new QName("http://tempuri.org/", "BasicHttpBinding_IDistributedSignatureServiceBasic2"), IDistributedSignatureServiceBasic.class, features);
    }

    private static URL __getWsdlLocation() {
        if (DISTRIBUTEDSIGNATURESERVICEBASIC_EXCEPTION!= null) {
            throw DISTRIBUTEDSIGNATURESERVICEBASIC_EXCEPTION;
        }
        return DISTRIBUTEDSIGNATURESERVICEBASIC_WSDL_LOCATION;
    }

}
