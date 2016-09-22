/**
 * GetDataImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package userserver;

public class GetDataImplServiceLocator extends org.apache.axis.client.Service implements userserver.GetDataImplService {

    public GetDataImplServiceLocator() {
    }


    public GetDataImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public GetDataImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for GetDataImplPort
    private java.lang.String GetDataImplPort_address = "http://10.1.13.26:7001/SyncServiceWX/MDM/PS/MDMUserServicePS";

    public java.lang.String getGetDataImplPortAddress() {
        return GetDataImplPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String GetDataImplPortWSDDServiceName = "GetDataImplPort";

    public java.lang.String getGetDataImplPortWSDDServiceName() {
        return GetDataImplPortWSDDServiceName;
    }

    public void setGetDataImplPortWSDDServiceName(java.lang.String name) {
        GetDataImplPortWSDDServiceName = name;
    }

    public userserver.IGetData getGetDataImplPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(GetDataImplPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getGetDataImplPort(endpoint);
    }

    public userserver.IGetData getGetDataImplPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            userserver.GetDataImplServiceSoapBindingStub _stub = new userserver.GetDataImplServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getGetDataImplPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setGetDataImplPortEndpointAddress(java.lang.String address) {
        GetDataImplPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (userserver.IGetData.class.isAssignableFrom(serviceEndpointInterface)) {
                userserver.GetDataImplServiceSoapBindingStub _stub = new userserver.GetDataImplServiceSoapBindingStub(new java.net.URL(GetDataImplPort_address), this);
                _stub.setPortName(getGetDataImplPortWSDDServiceName());
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
        if ("GetDataImplPort".equals(inputPortName)) {
            return getGetDataImplPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://impl.service.userquery.mdms.soft.com/", "GetDataImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://impl.service.userquery.mdms.soft.com/", "GetDataImplPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("GetDataImplPort".equals(portName)) {
            setGetDataImplPortEndpointAddress(address);
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
