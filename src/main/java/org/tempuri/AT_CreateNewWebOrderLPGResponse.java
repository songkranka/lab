/**
 * AT_CreateNewWebOrderLPGResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AT_CreateNewWebOrderLPGResponse  implements java.io.Serializable {
    private boolean AT_CreateNewWebOrderLPGResult;

    public AT_CreateNewWebOrderLPGResponse() {
    }

    public AT_CreateNewWebOrderLPGResponse(
           boolean AT_CreateNewWebOrderLPGResult) {
           this.AT_CreateNewWebOrderLPGResult = AT_CreateNewWebOrderLPGResult;
    }


    /**
     * Gets the AT_CreateNewWebOrderLPGResult value for this AT_CreateNewWebOrderLPGResponse.
     * 
     * @return AT_CreateNewWebOrderLPGResult
     */
    public boolean isAT_CreateNewWebOrderLPGResult() {
        return AT_CreateNewWebOrderLPGResult;
    }


    /**
     * Sets the AT_CreateNewWebOrderLPGResult value for this AT_CreateNewWebOrderLPGResponse.
     * 
     * @param AT_CreateNewWebOrderLPGResult
     */
    public void setAT_CreateNewWebOrderLPGResult(boolean AT_CreateNewWebOrderLPGResult) {
        this.AT_CreateNewWebOrderLPGResult = AT_CreateNewWebOrderLPGResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AT_CreateNewWebOrderLPGResponse)) return false;
        AT_CreateNewWebOrderLPGResponse other = (AT_CreateNewWebOrderLPGResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.AT_CreateNewWebOrderLPGResult == other.isAT_CreateNewWebOrderLPGResult();
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
        _hashCode += (isAT_CreateNewWebOrderLPGResult() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AT_CreateNewWebOrderLPGResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AT_CreateNewWebOrderLPGResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AT_CreateNewWebOrderLPGResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "AT_CreateNewWebOrderLPGResult"));
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
