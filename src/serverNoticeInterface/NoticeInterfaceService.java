/**
 * NoticeInterfaceService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package serverNoticeInterface;

public interface NoticeInterfaceService extends javax.xml.rpc.Service {
    public java.lang.String getNoticeServiceAddress();

    public serverNoticeInterface.NoticeInterface getNoticeService() throws javax.xml.rpc.ServiceException;

    public serverNoticeInterface.NoticeInterface getNoticeService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
