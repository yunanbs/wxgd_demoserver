/**
 * Message.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package serverNoticeInterface;

public class Message  implements java.io.Serializable {
    private java.lang.String job_code;

    private java.lang.String org_code;

    private java.lang.String psid;

    private java.lang.String pstatus;

    private java.lang.String syscode;

    private java.lang.String userId;

    public Message() {
    }

    public Message(
           java.lang.String job_code,
           java.lang.String org_code,
           java.lang.String psid,
           java.lang.String pstatus,
           java.lang.String syscode,
           java.lang.String userId) {
           this.job_code = job_code;
           this.org_code = org_code;
           this.psid = psid;
           this.pstatus = pstatus;
           this.syscode = syscode;
           this.userId = userId;
    }


    /**
     * Gets the job_code value for this Message.
     * 
     * @return job_code
     */
    public java.lang.String getJob_code() {
        return job_code;
    }


    /**
     * Sets the job_code value for this Message.
     * 
     * @param job_code
     */
    public void setJob_code(java.lang.String job_code) {
        this.job_code = job_code;
    }


    /**
     * Gets the org_code value for this Message.
     * 
     * @return org_code
     */
    public java.lang.String getOrg_code() {
        return org_code;
    }


    /**
     * Sets the org_code value for this Message.
     * 
     * @param org_code
     */
    public void setOrg_code(java.lang.String org_code) {
        this.org_code = org_code;
    }


    /**
     * Gets the psid value for this Message.
     * 
     * @return psid
     */
    public java.lang.String getPsid() {
        return psid;
    }


    /**
     * Sets the psid value for this Message.
     * 
     * @param psid
     */
    public void setPsid(java.lang.String psid) {
        this.psid = psid;
    }


    /**
     * Gets the pstatus value for this Message.
     * 
     * @return pstatus
     */
    public java.lang.String getPstatus() {
        return pstatus;
    }


    /**
     * Sets the pstatus value for this Message.
     * 
     * @param pstatus
     */
    public void setPstatus(java.lang.String pstatus) {
        this.pstatus = pstatus;
    }


    /**
     * Gets the syscode value for this Message.
     * 
     * @return syscode
     */
    public java.lang.String getSyscode() {
        return syscode;
    }


    /**
     * Sets the syscode value for this Message.
     * 
     * @param syscode
     */
    public void setSyscode(java.lang.String syscode) {
        this.syscode = syscode;
    }


    /**
     * Gets the userId value for this Message.
     * 
     * @return userId
     */
    public java.lang.String getUserId() {
        return userId;
    }


    /**
     * Sets the userId value for this Message.
     * 
     * @param userId
     */
    public void setUserId(java.lang.String userId) {
        this.userId = userId;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Message)) return false;
        Message other = (Message) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.job_code==null && other.getJob_code()==null) || 
             (this.job_code!=null &&
              this.job_code.equals(other.getJob_code()))) &&
            ((this.org_code==null && other.getOrg_code()==null) || 
             (this.org_code!=null &&
              this.org_code.equals(other.getOrg_code()))) &&
            ((this.psid==null && other.getPsid()==null) || 
             (this.psid!=null &&
              this.psid.equals(other.getPsid()))) &&
            ((this.pstatus==null && other.getPstatus()==null) || 
             (this.pstatus!=null &&
              this.pstatus.equals(other.getPstatus()))) &&
            ((this.syscode==null && other.getSyscode()==null) || 
             (this.syscode!=null &&
              this.syscode.equals(other.getSyscode()))) &&
            ((this.userId==null && other.getUserId()==null) || 
             (this.userId!=null &&
              this.userId.equals(other.getUserId())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getJob_code() != null) {
            _hashCode += getJob_code().hashCode();
        }
        if (getOrg_code() != null) {
            _hashCode += getOrg_code().hashCode();
        }
        if (getPsid() != null) {
            _hashCode += getPsid().hashCode();
        }
        if (getPstatus() != null) {
            _hashCode += getPstatus().hashCode();
        }
        if (getSyscode() != null) {
            _hashCode += getSyscode().hashCode();
        }
        if (getUserId() != null) {
            _hashCode += getUserId().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Message.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://localhost:8080/services/NoticeService", "Message"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("job_code");
        elemField.setXmlName(new javax.xml.namespace.QName("", "job_code"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("org_code");
        elemField.setXmlName(new javax.xml.namespace.QName("", "org_code"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("psid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "psid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pstatus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pstatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("syscode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "syscode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "userId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
