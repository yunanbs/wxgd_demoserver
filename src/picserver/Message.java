/**
 * Message.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package picserver;

public class Message  implements java.io.Serializable {
    public java.lang.String module_type;

    public java.lang.Integer oper_type;

    public java.lang.String psnstr;

    public java.lang.String sysCode;

    public Message() {
    }

    public Message(
           java.lang.String module_type,
           java.lang.Integer oper_type,
           java.lang.String psnstr,
           java.lang.String sysCode) {
           this.module_type = module_type;
           this.oper_type = oper_type;
           this.psnstr = psnstr;
           this.sysCode = sysCode;
    }


    /**
     * Gets the module_type value for this Message.
     * 
     * @return module_type
     */
    public java.lang.String getModule_type() {
        return module_type;
    }


    /**
     * Sets the module_type value for this Message.
     * 
     * @param module_type
     */
    public void setModule_type(java.lang.String module_type) {
        this.module_type = module_type;
    }


    /**
     * Gets the oper_type value for this Message.
     * 
     * @return oper_type
     */
    public java.lang.Integer getOper_type() {
        return oper_type;
    }


    /**
     * Sets the oper_type value for this Message.
     * 
     * @param oper_type
     */
    public void setOper_type(java.lang.Integer oper_type) {
        this.oper_type = oper_type;
    }


    /**
     * Gets the psnstr value for this Message.
     * 
     * @return psnstr
     */
    public java.lang.String getPsnstr() {
        return psnstr;
    }


    /**
     * Sets the psnstr value for this Message.
     * 
     * @param psnstr
     */
    public void setPsnstr(java.lang.String psnstr) {
        this.psnstr = psnstr;
    }


    /**
     * Gets the sysCode value for this Message.
     * 
     * @return sysCode
     */
    public java.lang.String getSysCode() {
        return sysCode;
    }


    /**
     * Sets the sysCode value for this Message.
     * 
     * @param sysCode
     */
    public void setSysCode(java.lang.String sysCode) {
        this.sysCode = sysCode;
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
            ((this.module_type==null && other.getModule_type()==null) || 
             (this.module_type!=null &&
              this.module_type.equals(other.getModule_type()))) &&
            ((this.oper_type==null && other.getOper_type()==null) || 
             (this.oper_type!=null &&
              this.oper_type.equals(other.getOper_type()))) &&
            ((this.psnstr==null && other.getPsnstr()==null) || 
             (this.psnstr!=null &&
              this.psnstr.equals(other.getPsnstr()))) &&
            ((this.sysCode==null && other.getSysCode()==null) || 
             (this.sysCode!=null &&
              this.sysCode.equals(other.getSysCode())));
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
        if (getModule_type() != null) {
            _hashCode += getModule_type().hashCode();
        }
        if (getOper_type() != null) {
            _hashCode += getOper_type().hashCode();
        }
        if (getPsnstr() != null) {
            _hashCode += getPsnstr().hashCode();
        }
        if (getSysCode() != null) {
            _hashCode += getSysCode().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Message.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://impl.service.userInfoquery.mdms.soft.com/", "message"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("module_type");
        elemField.setXmlName(new javax.xml.namespace.QName("", "module_type"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("oper_type");
        elemField.setXmlName(new javax.xml.namespace.QName("", "oper_type"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("psnstr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "psnstr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sysCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sysCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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
