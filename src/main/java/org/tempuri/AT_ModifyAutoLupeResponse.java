/**
 * AT_ModifyAutoLupeResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AT_ModifyAutoLupeResponse  implements java.io.Serializable {
    private java.lang.String AT_ModifyAutoLupeResult;

    public AT_ModifyAutoLupeResponse() {
    }

    public AT_ModifyAutoLupeResponse(
           java.lang.String AT_ModifyAutoLupeResult) {
           this.AT_ModifyAutoLupeResult = AT_ModifyAutoLupeResult;
    }


    /**
     * Gets the AT_ModifyAutoLupeResult value for this AT_ModifyAutoLupeResponse.
     * 
     * @return AT_ModifyAutoLupeResult
     */
    public java.lang.String getAT_ModifyAutoLupeResult() {
        return AT_ModifyAutoLupeResult;
    }


    /**
     * Sets the AT_ModifyAutoLupeResult value for this AT_ModifyAutoLupeResponse.
     * 
     * @param AT_ModifyAutoLupeResult
     */
    public void setAT_ModifyAutoLupeResult(java.lang.String AT_ModifyAutoLupeResult) {
        this.AT_ModifyAutoLupeResult = AT_ModifyAutoLupeResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AT_ModifyAutoLupeResponse)) return false;
        AT_ModifyAutoLupeResponse other = (AT_ModifyAutoLupeResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.AT_ModifyAutoLupeResult==null && other.getAT_ModifyAutoLupeResult()==null) || 
             (this.AT_ModifyAutoLupeResult!=null &&
              this.AT_ModifyAutoLupeResult.equals(other.getAT_ModifyAutoLupeResult())));
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
        if (getAT_ModifyAutoLupeResult() != null) {
            _hashCode += getAT_ModifyAutoLupeResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AT_ModifyAutoLupeResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AT_ModifyAutoLupeResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AT_ModifyAutoLupeResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "AT_ModifyAutoLupeResult"));
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
