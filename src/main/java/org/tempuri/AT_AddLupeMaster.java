/**
 * AT_AddLupeMaster.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AT_AddLupeMaster  implements java.io.Serializable {
    private java.lang.String sLupeCode;

    private java.lang.String sLupeName;

    private java.lang.String sCode;

    private java.lang.String sName;

    public AT_AddLupeMaster() {
    }

    public AT_AddLupeMaster(
           java.lang.String sLupeCode,
           java.lang.String sLupeName,
           java.lang.String sCode,
           java.lang.String sName) {
           this.sLupeCode = sLupeCode;
           this.sLupeName = sLupeName;
           this.sCode = sCode;
           this.sName = sName;
    }


    /**
     * Gets the sLupeCode value for this AT_AddLupeMaster.
     * 
     * @return sLupeCode
     */
    public java.lang.String getSLupeCode() {
        return sLupeCode;
    }


    /**
     * Sets the sLupeCode value for this AT_AddLupeMaster.
     * 
     * @param sLupeCode
     */
    public void setSLupeCode(java.lang.String sLupeCode) {
        this.sLupeCode = sLupeCode;
    }


    /**
     * Gets the sLupeName value for this AT_AddLupeMaster.
     * 
     * @return sLupeName
     */
    public java.lang.String getSLupeName() {
        return sLupeName;
    }


    /**
     * Sets the sLupeName value for this AT_AddLupeMaster.
     * 
     * @param sLupeName
     */
    public void setSLupeName(java.lang.String sLupeName) {
        this.sLupeName = sLupeName;
    }


    /**
     * Gets the sCode value for this AT_AddLupeMaster.
     * 
     * @return sCode
     */
    public java.lang.String getSCode() {
        return sCode;
    }


    /**
     * Sets the sCode value for this AT_AddLupeMaster.
     * 
     * @param sCode
     */
    public void setSCode(java.lang.String sCode) {
        this.sCode = sCode;
    }


    /**
     * Gets the sName value for this AT_AddLupeMaster.
     * 
     * @return sName
     */
    public java.lang.String getSName() {
        return sName;
    }


    /**
     * Sets the sName value for this AT_AddLupeMaster.
     * 
     * @param sName
     */
    public void setSName(java.lang.String sName) {
        this.sName = sName;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AT_AddLupeMaster)) return false;
        AT_AddLupeMaster other = (AT_AddLupeMaster) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.sLupeCode==null && other.getSLupeCode()==null) || 
             (this.sLupeCode!=null &&
              this.sLupeCode.equals(other.getSLupeCode()))) &&
            ((this.sLupeName==null && other.getSLupeName()==null) || 
             (this.sLupeName!=null &&
              this.sLupeName.equals(other.getSLupeName()))) &&
            ((this.sCode==null && other.getSCode()==null) || 
             (this.sCode!=null &&
              this.sCode.equals(other.getSCode()))) &&
            ((this.sName==null && other.getSName()==null) || 
             (this.sName!=null &&
              this.sName.equals(other.getSName())));
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
        if (getSLupeCode() != null) {
            _hashCode += getSLupeCode().hashCode();
        }
        if (getSLupeName() != null) {
            _hashCode += getSLupeName().hashCode();
        }
        if (getSCode() != null) {
            _hashCode += getSCode().hashCode();
        }
        if (getSName() != null) {
            _hashCode += getSName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AT_AddLupeMaster.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AT_AddLupeMaster"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SLupeCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "sLupeCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SLupeName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "sLupeName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "sCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "sName"));
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
