/**
 * NoticeInterface.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package serverNoticeInterface;

public interface NoticeInterface extends java.rmi.Remote {
    public java.lang.String huaInterface(java.lang.String sysflag, java.lang.String datastr, java.lang.String objtype, java.lang.String opflag) throws java.rmi.RemoteException;
    public java.lang.String getobjstr(java.lang.String id, java.lang.String tablename, java.lang.String pkname) throws java.rmi.RemoteException;
    public java.lang.String testmd5(java.lang.String accountid) throws java.rmi.RemoteException;
    public serverNoticeInterface.ResponseMessage setData(serverNoticeInterface.RequestMessage input) throws java.rmi.RemoteException;
}
