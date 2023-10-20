/**
 * AT_VersionUpdateCompleteResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AT_VersionUpdateCompleteResponse  implements java.io.Serializable {
    private boolean AT_VersionUpdateCompleteResult;

    public AT_VersionUpdateCompleteResponse() {
    }

    public AT_VersionUpdateCompleteResponse(
           boolean AT_VersionUpdateCompleteResult) {
           this.AT_VersionUpdateCompleteResult = AT_VersionUpdateCompleteResult;
    }


    /**
     * Gets the AT_VersionUpdateCompleteResult value for this AT_VersionUpdateCompleteResponse.
     * 
     * @return AT_VersionUpdateCompleteResult
     */
    public boolean isAT_VersionUpdateCompleteResult() {
        return AT_VersionUpdateCompleteResult;
    }


    /**
     * Sets the AT_VersionUpdateCompleteResult value for this AT_VersionUpdateCompleteResponse.
     * 
     * @param AT_VersionUpdateCompleteResult
     */
    public void setAT_VersionUpdateCompleteResult(boolean AT_VersionUpdateCompleteResult) {
        this.AT_VersionUpdateCompleteResult = AT_VersionUpdateCompleteResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AT_VersionUpdateCompleteResponse)) return false;
        AT_VersionUpdateCompleteResponse other = (AT_VersionUpdateCompleteResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.AT_VersionUpdateCompleteResult == other.isAT_VersionUpdateCompleteResult();
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
        _hashCode += (isAT_VersionUpdateCompleteResult() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AT_VersionUpdateCompleteResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AT_VersionUpdateCompleteResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AT_VersionUpdateCompleteResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "AT_VersionUpdateCompleteResult"));
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
