/**
 * AT_InsertAutoLupeResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AT_InsertAutoLupeResponse  implements java.io.Serializable {
    private java.lang.String AT_InsertAutoLupeResult;

    public AT_InsertAutoLupeResponse() {
    }

    public AT_InsertAutoLupeResponse(
           java.lang.String AT_InsertAutoLupeResult) {
           this.AT_InsertAutoLupeResult = AT_InsertAutoLupeResult;
    }


    /**
     * Gets the AT_InsertAutoLupeResult value for this AT_InsertAutoLupeResponse.
     * 
     * @return AT_InsertAutoLupeResult
     */
    public java.lang.String getAT_InsertAutoLupeResult() {
        return AT_InsertAutoLupeResult;
    }


    /**
     * Sets the AT_InsertAutoLupeResult value for this AT_InsertAutoLupeResponse.
     * 
     * @param AT_InsertAutoLupeResult
     */
    public void setAT_InsertAutoLupeResult(java.lang.String AT_InsertAutoLupeResult) {
        this.AT_InsertAutoLupeResult = AT_InsertAutoLupeResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AT_InsertAutoLupeResponse)) return false;
        AT_InsertAutoLupeResponse other = (AT_InsertAutoLupeResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.AT_InsertAutoLupeResult==null && other.getAT_InsertAutoLupeResult()==null) || 
             (this.AT_InsertAutoLupeResult!=null &&
              this.AT_InsertAutoLupeResult.equals(other.getAT_InsertAutoLupeResult())));
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
        if (getAT_InsertAutoLupeResult() != null) {
            _hashCode += getAT_InsertAutoLupeResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AT_InsertAutoLupeResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AT_InsertAutoLupeResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AT_InsertAutoLupeResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "AT_InsertAutoLupeResult"));
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
