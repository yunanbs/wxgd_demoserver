/**
 * RequestMessage.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package userserver;

public class RequestMessage  implements java.io.Serializable {
    public userserver.Message message;

    public java.lang.String noun;

    public userserver.User user;

    public java.lang.String verb;

    public RequestMessage() {
    }

    public RequestMessage(
           userserver.Message message,
           java.lang.String noun,
           userserver.User user,
           java.lang.String verb) {
           this.message = message;
           this.noun = noun;
           this.user = user;
           this.verb = verb;
    }


    /**
     * Gets the message value for this RequestMessage.
     * 
     * @return message
     */
    public userserver.Message getMessage() {
        return message;
    }


    /**
     * Sets the message value for this RequestMessage.
     * 
     * @param message
     */
    public void setMessage(userserver.Message message) {
        this.message = message;
    }


    /**
     * Gets the noun value for this RequestMessage.
     * 
     * @return noun
     */
    public java.lang.String getNoun() {
        return noun;
    }


    /**
     * Sets the noun value for this RequestMessage.
     * 
     * @param noun
     */
    public void setNoun(java.lang.String noun) {
        this.noun = noun;
    }


    /**
     * Gets the user value for this RequestMessage.
     * 
     * @return user
     */
    public userserver.User getUser() {
        return user;
    }


    /**
     * Sets the user value for this RequestMessage.
     * 
     * @param user
     */
    public void setUser(userserver.User user) {
        this.user = user;
    }


    /**
     * Gets the verb value for this RequestMessage.
     * 
     * @return verb
     */
    public java.lang.String getVerb() {
        return verb;
    }


    /**
     * Sets the verb value for this RequestMessage.
     * 
     * @param verb
     */
    public void setVerb(java.lang.String verb) {
        this.verb = verb;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RequestMessage)) return false;
        RequestMessage other = (RequestMessage) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.message==null && other.getMessage()==null) || 
             (this.message!=null &&
              this.message.equals(other.getMessage()))) &&
            ((this.noun==null && other.getNoun()==null) || 
             (this.noun!=null &&
              this.noun.equals(other.getNoun()))) &&
            ((this.user==null && other.getUser()==null) || 
             (this.user!=null &&
              this.user.equals(other.getUser()))) &&
            ((this.verb==null && other.getVerb()==null) || 
             (this.verb!=null &&
              this.verb.equals(other.getVerb())));
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
        if (getMessage() != null) {
            _hashCode += getMessage().hashCode();
        }
        if (getNoun() != null) {
            _hashCode += getNoun().hashCode();
        }
        if (getUser() != null) {
            _hashCode += getUser().hashCode();
        }
        if (getVerb() != null) {
            _hashCode += getVerb().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RequestMessage.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://impl.service.userquery.mdms.soft.com/", "requestMessage"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("message");
        elemField.setXmlName(new javax.xml.namespace.QName("", "message"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://impl.service.userquery.mdms.soft.com/", "message"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("noun");
        elemField.setXmlName(new javax.xml.namespace.QName("", "noun"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("user");
        elemField.setXmlName(new javax.xml.namespace.QName("", "user"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://impl.service.userquery.mdms.soft.com/", "user"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("verb");
        elemField.setXmlName(new javax.xml.namespace.QName("", "verb"));
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
