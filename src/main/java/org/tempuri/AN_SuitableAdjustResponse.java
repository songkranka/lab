/**
 * AN_SuitableAdjustResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AN_SuitableAdjustResponse  implements java.io.Serializable {
    private boolean AN_SuitableAdjustResult;

    public AN_SuitableAdjustResponse() {
    }

    public AN_SuitableAdjustResponse(
           boolean AN_SuitableAdjustResult) {
           this.AN_SuitableAdjustResult = AN_SuitableAdjustResult;
    }


    /**
     * Gets the AN_SuitableAdjustResult value for this AN_SuitableAdjustResponse.
     * 
     * @return AN_SuitableAdjustResult
     */
    public boolean isAN_SuitableAdjustResult() {
        return AN_SuitableAdjustResult;
    }


    /**
     * Sets the AN_SuitableAdjustResult value for this AN_SuitableAdjustResponse.
     * 
     * @param AN_SuitableAdjustResult
     */
    public void setAN_SuitableAdjustResult(boolean AN_SuitableAdjustResult) {
        this.AN_SuitableAdjustResult = AN_SuitableAdjustResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AN_SuitableAdjustResponse)) return false;
        AN_SuitableAdjustResponse other = (AN_SuitableAdjustResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.AN_SuitableAdjustResult == other.isAN_SuitableAdjustResult();
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
        _hashCode += (isAN_SuitableAdjustResult() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AN_SuitableAdjustResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AN_SuitableAdjustResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AN_SuitableAdjustResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "AN_SuitableAdjustResult"));
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
