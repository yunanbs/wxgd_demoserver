/**
 * NoticeInterfaceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package serverNoticeInterface;

public class NoticeInterfaceServiceLocator extends org.apache.axis.client.Service implements serverNoticeInterface.NoticeInterfaceService {

    public NoticeInterfaceServiceLocator() {
    }


    public NoticeInterfaceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public NoticeInterfaceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for NoticeService
    private java.lang.String NoticeService_address = "http://10.1.14.52:7002/demoserver/services/NoticeService";

    public java.lang.String getNoticeServiceAddress() {
        return NoticeService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String NoticeServiceWSDDServiceName = "NoticeService";

    public java.lang.String getNoticeServiceWSDDServiceName() {
        return NoticeServiceWSDDServiceName;
    }

    public void setNoticeServiceWSDDServiceName(java.lang.String name) {
        NoticeServiceWSDDServiceName = name;
    }

    public serverNoticeInterface.NoticeInterface getNoticeService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(NoticeService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getNoticeService(endpoint);
    }

    public serverNoticeInterface.NoticeInterface getNoticeService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            serverNoticeInterface.NoticeServiceSoapBindingStub _stub = new serverNoticeInterface.NoticeServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getNoticeServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setNoticeServiceEndpointAddress(java.lang.String address) {
        NoticeService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (serverNoticeInterface.NoticeInterface.class.isAssignableFrom(serviceEndpointInterface)) {
                serverNoticeInterface.NoticeServiceSoapBindingStub _stub = new serverNoticeInterface.NoticeServiceSoapBindingStub(new java.net.URL(NoticeService_address), this);
                _stub.setPortName(getNoticeServiceWSDDServiceName());
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
        if ("NoticeService".equals(inputPortName)) {
            return getNoticeService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://10.1.14.52:7002/demoserver/services/NoticeService", "NoticeInterfaceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://10.1.14.52:7002/demoserver/services/NoticeService", "NoticeService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("NoticeService".equals(portName)) {
            setNoticeServiceEndpointAddress(address);
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
