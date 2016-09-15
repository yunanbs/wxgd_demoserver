/**
 * Result.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package orgserver;

public class Result  implements java.io.Serializable {
    public java.lang.String old_org_code;

    public java.lang.String org_code;

    public java.lang.String org_level;

    public java.lang.String org_name;

    public java.lang.String parent_org_code;

    public java.lang.String remark1;

    public java.lang.String remark2;

    public java.lang.String responsetime;

    public java.lang.String status_date;

    public java.lang.String use_status;

    public Result() {
    }

    public Result(
           java.lang.String old_org_code,
           java.lang.String org_code,
           java.lang.String org_level,
           java.lang.String org_name,
           java.lang.String parent_org_code,
           java.lang.String remark1,
           java.lang.String remark2,
           java.lang.String responsetime,
           java.lang.String status_date,
           java.lang.String use_status) {
           this.old_org_code = old_org_code;
           this.org_code = org_code;
           this.org_level = org_level;
           this.org_name = org_name;
           this.parent_org_code = parent_org_code;
           this.remark1 = remark1;
           this.remark2 = remark2;
           this.responsetime = responsetime;
           this.status_date = status_date;
           this.use_status = use_status;
    }


    /**
     * Gets the old_org_code value for this Result.
     * 
     * @return old_org_code
     */
    public java.lang.String getOld_org_code() {
        return old_org_code;
    }


    /**
     * Sets the old_org_code value for this Result.
     * 
     * @param old_org_code
     */
    public void setOld_org_code(java.lang.String old_org_code) {
        this.old_org_code = old_org_code;
    }


    /**
     * Gets the org_code value for this Result.
     * 
     * @return org_code
     */
    public java.lang.String getOrg_code() {
        return org_code;
    }


    /**
     * Sets the org_code value for this Result.
     * 
     * @param org_code
     */
    public void setOrg_code(java.lang.String org_code) {
        this.org_code = org_code;
    }


    /**
     * Gets the org_level value for this Result.
     * 
     * @return org_level
     */
    public java.lang.String getOrg_level() {
        return org_level;
    }


    /**
     * Sets the org_level value for this Result.
     * 
     * @param org_level
     */
    public void setOrg_level(java.lang.String org_level) {
        this.org_level = org_level;
    }


    /**
     * Gets the org_name value for this Result.
     * 
     * @return org_name
     */
    public java.lang.String getOrg_name() {
        return org_name;
    }


    /**
     * Sets the org_name value for this Result.
     * 
     * @param org_name
     */
    public void setOrg_name(java.lang.String org_name) {
        this.org_name = org_name;
    }


    /**
     * Gets the parent_org_code value for this Result.
     * 
     * @return parent_org_code
     */
    public java.lang.String getParent_org_code() {
        return parent_org_code;
    }


    /**
     * Sets the parent_org_code value for this Result.
     * 
     * @param parent_org_code
     */
    public void setParent_org_code(java.lang.String parent_org_code) {
        this.parent_org_code = parent_org_code;
    }


    /**
     * Gets the remark1 value for this Result.
     * 
     * @return remark1
     */
    public java.lang.String getRemark1() {
        return remark1;
    }


    /**
     * Sets the remark1 value for this Result.
     * 
     * @param remark1
     */
    public void setRemark1(java.lang.String remark1) {
        this.remark1 = remark1;
    }


    /**
     * Gets the remark2 value for this Result.
     * 
     * @return remark2
     */
    public java.lang.String getRemark2() {
        return remark2;
    }


    /**
     * Sets the remark2 value for this Result.
     * 
     * @param remark2
     */
    public void setRemark2(java.lang.String remark2) {
        this.remark2 = remark2;
    }


    /**
     * Gets the responsetime value for this Result.
     * 
     * @return responsetime
     */
    public java.lang.String getResponsetime() {
        return responsetime;
    }


    /**
     * Sets the responsetime value for this Result.
     * 
     * @param responsetime
     */
    public void setResponsetime(java.lang.String responsetime) {
        this.responsetime = responsetime;
    }


    /**
     * Gets the status_date value for this Result.
     * 
     * @return status_date
     */
    public java.lang.String getStatus_date() {
        return status_date;
    }


    /**
     * Sets the status_date value for this Result.
     * 
     * @param status_date
     */
    public void setStatus_date(java.lang.String status_date) {
        this.status_date = status_date;
    }


    /**
     * Gets the use_status value for this Result.
     * 
     * @return use_status
     */
    public java.lang.String getUse_status() {
        return use_status;
    }


    /**
     * Sets the use_status value for this Result.
     * 
     * @param use_status
     */
    public void setUse_status(java.lang.String use_status) {
        this.use_status = use_status;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Result)) return false;
        Result other = (Result) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.old_org_code==null && other.getOld_org_code()==null) || 
             (this.old_org_code!=null &&
              this.old_org_code.equals(other.getOld_org_code()))) &&
            ((this.org_code==null && other.getOrg_code()==null) || 
             (this.org_code!=null &&
              this.org_code.equals(other.getOrg_code()))) &&
            ((this.org_level==null && other.getOrg_level()==null) || 
             (this.org_level!=null &&
              this.org_level.equals(other.getOrg_level()))) &&
            ((this.org_name==null && other.getOrg_name()==null) || 
             (this.org_name!=null &&
              this.org_name.equals(other.getOrg_name()))) &&
            ((this.parent_org_code==null && other.getParent_org_code()==null) || 
             (this.parent_org_code!=null &&
              this.parent_org_code.equals(other.getParent_org_code()))) &&
            ((this.remark1==null && other.getRemark1()==null) || 
             (this.remark1!=null &&
              this.remark1.equals(other.getRemark1()))) &&
            ((this.remark2==null && other.getRemark2()==null) || 
             (this.remark2!=null &&
              this.remark2.equals(other.getRemark2()))) &&
            ((this.responsetime==null && other.getResponsetime()==null) || 
             (this.responsetime!=null &&
              this.responsetime.equals(other.getResponsetime()))) &&
            ((this.status_date==null && other.getStatus_date()==null) || 
             (this.status_date!=null &&
              this.status_date.equals(other.getStatus_date()))) &&
            ((this.use_status==null && other.getUse_status()==null) || 
             (this.use_status!=null &&
              this.use_status.equals(other.getUse_status())));
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
        if (getOld_org_code() != null) {
            _hashCode += getOld_org_code().hashCode();
        }
        if (getOrg_code() != null) {
            _hashCode += getOrg_code().hashCode();
        }
        if (getOrg_level() != null) {
            _hashCode += getOrg_level().hashCode();
        }
        if (getOrg_name() != null) {
            _hashCode += getOrg_name().hashCode();
        }
        if (getParent_org_code() != null) {
            _hashCode += getParent_org_code().hashCode();
        }
        if (getRemark1() != null) {
            _hashCode += getRemark1().hashCode();
        }
        if (getRemark2() != null) {
            _hashCode += getRemark2().hashCode();
        }
        if (getResponsetime() != null) {
            _hashCode += getResponsetime().hashCode();
        }
        if (getStatus_date() != null) {
            _hashCode += getStatus_date().hashCode();
        }
        if (getUse_status() != null) {
            _hashCode += getUse_status().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Result.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://impl.service.orgquery.mdms.soft.com/", "result"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("old_org_code");
        elemField.setXmlName(new javax.xml.namespace.QName("", "old_org_code"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
        elemField.setFieldName("org_level");
        elemField.setXmlName(new javax.xml.namespace.QName("", "org_level"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("org_name");
        elemField.setXmlName(new javax.xml.namespace.QName("", "org_name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("parent_org_code");
        elemField.setXmlName(new javax.xml.namespace.QName("", "parent_org_code"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("remark1");
        elemField.setXmlName(new javax.xml.namespace.QName("", "remark1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("remark2");
        elemField.setXmlName(new javax.xml.namespace.QName("", "remark2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("responsetime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "responsetime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status_date");
        elemField.setXmlName(new javax.xml.namespace.QName("", "status_date"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("use_status");
        elemField.setXmlName(new javax.xml.namespace.QName("", "use_status"));
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
