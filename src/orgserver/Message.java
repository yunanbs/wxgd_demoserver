/**
 * Message.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package orgserver;

public class Message  implements java.io.Serializable {
    public java.lang.Integer oper_type;

    public java.lang.String org_code;

    public java.lang.String syscode;

    public Message() {
    }

    public Message(
           java.lang.Integer oper_type,
           java.lang.String org_code,
           java.lang.String syscode) {
           this.oper_type = oper_type;
           this.org_code = org_code;
           this.syscode = syscode;
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
            ((this.oper_type==null && other.getOper_type()==null) || 
             (this.oper_type!=null &&
              this.oper_type.equals(other.getOper_type()))) &&
            ((this.org_code==null && other.getOrg_code()==null) || 
             (this.org_code!=null &&
              this.org_code.equals(other.getOrg_code()))) &&
            ((this.syscode==null && other.getSyscode()==null) || 
             (this.syscode!=null &&
              this.syscode.equals(other.getSyscode())));
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
        if (getOper_type() != null) {
            _hashCode += getOper_type().hashCode();
        }
        if (getOrg_code() != null) {
            _hashCode += getOrg_code().hashCode();
        }
        if (getSyscode() != null) {
            _hashCode += getSyscode().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Message.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://impl.service.orgquery.mdms.soft.com/", "message"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("oper_type");
        elemField.setXmlName(new javax.xml.namespace.QName("", "oper_type"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("org_code");
        elemField.setXmlName(new javax.xml.namespace.QName("", "org_code"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("syscode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "syscode"));
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
