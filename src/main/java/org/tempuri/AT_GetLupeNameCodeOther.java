/**
 * AT_GetLupeNameCodeOther.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AT_GetLupeNameCodeOther  implements java.io.Serializable {
    private java.lang.String sCode;

    public AT_GetLupeNameCodeOther() {
    }

    public AT_GetLupeNameCodeOther(
           java.lang.String sCode) {
           this.sCode = sCode;
    }


    /**
     * Gets the sCode value for this AT_GetLupeNameCodeOther.
     * 
     * @return sCode
     */
    public java.lang.String getSCode() {
        return sCode;
    }


    /**
     * Sets the sCode value for this AT_GetLupeNameCodeOther.
     * 
     * @param sCode
     */
    public void setSCode(java.lang.String sCode) {
        this.sCode = sCode;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AT_GetLupeNameCodeOther)) return false;
        AT_GetLupeNameCodeOther other = (AT_GetLupeNameCodeOther) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.sCode==null && other.getSCode()==null) || 
             (this.sCode!=null &&
              this.sCode.equals(other.getSCode())));
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
        if (getSCode() != null) {
            _hashCode += getSCode().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AT_GetLupeNameCodeOther.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AT_GetLupeNameCodeOther"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "sCode"));
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
