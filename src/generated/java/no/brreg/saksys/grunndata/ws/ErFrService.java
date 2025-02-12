package no.brreg.saksys.grunndata.ws;

import java.net.URL;
import javax.xml.namespace.QName;
import jakarta.xml.ws.WebEndpoint;
import jakarta.xml.ws.WebServiceClient;
import jakarta.xml.ws.WebServiceFeature;
import jakarta.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.4.5
 * 2021-11-16T12:05:45.916+01:00
 * Generated source version: 3.4.5
 *
 */
@WebServiceClient(name = "ErFrService",
                  wsdlLocation = "wsdl/Grunndata.wsdl",
                  targetNamespace = "http://no/brreg/saksys/grunndata/ws")
public class ErFrService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://no/brreg/saksys/grunndata/ws", "ErFrService");
    public final static QName ErFrSoapPort = new QName("http://no/brreg/saksys/grunndata/ws", "ErFrSoapPort");
    static {
        URL url = ErFrService.class.getResource("wsdl/Grunndata.wsdl");
        if (url == null) {
            url = ErFrService.class.getClassLoader().getResource("wsdl/Grunndata.wsdl");
        }
        if (url == null) {
            java.util.logging.Logger.getLogger(ErFrService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "wsdl/Grunndata.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public ErFrService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public ErFrService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ErFrService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public ErFrService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public ErFrService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public ErFrService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns ErFr
     */
    @WebEndpoint(name = "ErFrSoapPort")
    public ErFr getErFrSoapPort() {
        return super.getPort(ErFrSoapPort, ErFr.class);
    }

    /**
     *
     * @param features
     *     A list of {@link jakarta.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ErFr
     */
    @WebEndpoint(name = "ErFrSoapPort")
    public ErFr getErFrSoapPort(WebServiceFeature... features) {
        return super.getPort(ErFrSoapPort, ErFr.class, features);
    }

}
