/**
 * IGetData.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package picserver;

public interface IGetData extends java.rmi.Remote {
    public picserver.ResponseMessage getDataById(picserver.RequestMessage arg0) throws java.rmi.RemoteException;
    public picserver.ResponseMessage getData(picserver.RequestMessage arg0) throws java.rmi.RemoteException;
}
