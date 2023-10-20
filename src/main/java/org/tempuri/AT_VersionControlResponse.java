/**
 * AT_VersionControlResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AT_VersionControlResponse  implements java.io.Serializable {
    private boolean AT_VersionControlResult;

    public AT_VersionControlResponse() {
    }

    public AT_VersionControlResponse(
           boolean AT_VersionControlResult) {
           this.AT_VersionControlResult = AT_VersionControlResult;
    }


    /**
     * Gets the AT_VersionControlResult value for this AT_VersionControlResponse.
     * 
     * @return AT_VersionControlResult
     */
    public boolean isAT_VersionControlResult() {
        return AT_VersionControlResult;
    }


    /**
     * Sets the AT_VersionControlResult value for this AT_VersionControlResponse.
     * 
     * @param AT_VersionControlResult
     */
    public void setAT_VersionControlResult(boolean AT_VersionControlResult) {
        this.AT_VersionControlResult = AT_VersionControlResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AT_VersionControlResponse)) return false;
        AT_VersionControlResponse other = (AT_VersionControlResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.AT_VersionControlResult == other.isAT_VersionControlResult();
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
        _hashCode += (isAT_VersionControlResult() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AT_VersionControlResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AT_VersionControlResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AT_VersionControlResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "AT_VersionControlResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
