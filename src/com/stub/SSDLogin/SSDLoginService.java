package com.stub.SSDLogin;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;

/**
 * This class was generated by the JAX-WS RI. JAX-WS RI 2.1.3-hudson-390-
 * Generated source version: 2.0
 * <p>
 * An example of how this class may be used:
 * 
 * <pre>
 * SSDLoginService service = new SSDLoginService();
 * SSDLoginDelegate portType = service.getSSDLoginPort();
 * portType.getEKPUserFullName(...);
 * </pre>
 * 
 * </p>
 * 
 */
@WebServiceClient(name = "SSDLoginService", targetNamespace = "http://dao/", wsdlLocation = "http://192.168.10.27:8088/SSDLogin/SSDLoginPort?wsdl")
public class SSDLoginService extends Service {

	private final static URL SSDLOGINSERVICE_WSDL_LOCATION;
	private final static Logger logger = Logger
			.getLogger(com.stub.SSDLogin.SSDLoginService.class.getName());

	static {
		URL url = null;
		try {
			URL baseUrl;
			baseUrl = com.stub.SSDLogin.SSDLoginService.class.getResource(".");
			url = new URL(baseUrl,
					"http://192.168.10.27:8088/SSDLogin/SSDLoginPort?wsdl");
		} catch (MalformedURLException e) {
			logger.warning("Failed to create URL for the wsdl Location: 'http://192.168.10.27:8088/SSDLogin/SSDLoginPort?wsdl', retrying as a local file");
			logger.warning(e.getMessage());
		}
		SSDLOGINSERVICE_WSDL_LOCATION = url;
	}

	public SSDLoginService(URL wsdlLocation, QName serviceName) {
		super(wsdlLocation, serviceName);
	}

	public SSDLoginService() {
		super(SSDLOGINSERVICE_WSDL_LOCATION, new QName("http://dao/",
				"SSDLoginService"));
	}

	/**
	 * 
	 * @return returns SSDLoginDelegate
	 */
	@WebEndpoint(name = "SSDLoginPort")
	public SSDLoginDelegate getSSDLoginPort() {
		return super.getPort(new QName("http://dao/", "SSDLoginPort"),
				SSDLoginDelegate.class);
	}

}
