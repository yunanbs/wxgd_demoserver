/**
 * BasicDataImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package sgddbasedataserver;

public class BasicDataImplServiceLocator extends org.apache.axis.client.Service implements sgddbasedataserver.BasicDataImplService {

    public BasicDataImplServiceLocator() {
    }


    public BasicDataImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public BasicDataImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for BasicDataImplPort
    private java.lang.String BasicDataImplPort_address = "http://wxcdms.wxmetro.net:80/wxcms/webservice/basicdata";

    public java.lang.String getBasicDataImplPortAddress() {
        return BasicDataImplPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String BasicDataImplPortWSDDServiceName = "BasicDataImplPort";

    public java.lang.String getBasicDataImplPortWSDDServiceName() {
        return BasicDataImplPortWSDDServiceName;
    }

    public void setBasicDataImplPortWSDDServiceName(java.lang.String name) {
        BasicDataImplPortWSDDServiceName = name;
    }

    public sgddbasedataserver.IbasicData getBasicDataImplPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(BasicDataImplPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getBasicDataImplPort(endpoint);
    }

    public sgddbasedataserver.IbasicData getBasicDataImplPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            sgddbasedataserver.BasicDataImplServiceSoapBindingStub _stub = new sgddbasedataserver.BasicDataImplServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getBasicDataImplPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setBasicDataImplPortEndpointAddress(java.lang.String address) {
        BasicDataImplPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (sgddbasedataserver.IbasicData.class.isAssignableFrom(serviceEndpointInterface)) {
                sgddbasedataserver.BasicDataImplServiceSoapBindingStub _stub = new sgddbasedataserver.BasicDataImplServiceSoapBindingStub(new java.net.URL(BasicDataImplPort_address), this);
                _stub.setPortName(getBasicDataImplPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("BasicDataImplPort".equals(inputPortName)) {
            return getBasicDataImplPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://impl.basicdata.webservice.wx.eap.hgsoft.com/", "BasicDataImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://impl.basicdata.webservice.wx.eap.hgsoft.com/", "BasicDataImplPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("BasicDataImplPort".equals(portName)) {
            setBasicDataImplPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
