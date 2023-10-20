/**
 * AN_SuitableCalcResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AN_SuitableCalcResponse  implements java.io.Serializable {
    private boolean AN_SuitableCalcResult;

    public AN_SuitableCalcResponse() {
    }

    public AN_SuitableCalcResponse(
           boolean AN_SuitableCalcResult) {
           this.AN_SuitableCalcResult = AN_SuitableCalcResult;
    }


    /**
     * Gets the AN_SuitableCalcResult value for this AN_SuitableCalcResponse.
     * 
     * @return AN_SuitableCalcResult
     */
    public boolean isAN_SuitableCalcResult() {
        return AN_SuitableCalcResult;
    }


    /**
     * Sets the AN_SuitableCalcResult value for this AN_SuitableCalcResponse.
     * 
     * @param AN_SuitableCalcResult
     */
    public void setAN_SuitableCalcResult(boolean AN_SuitableCalcResult) {
        this.AN_SuitableCalcResult = AN_SuitableCalcResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AN_SuitableCalcResponse)) return false;
        AN_SuitableCalcResponse other = (AN_SuitableCalcResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.AN_SuitableCalcResult == other.isAN_SuitableCalcResult();
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
        _hashCode += (isAN_SuitableCalcResult() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AN_SuitableCalcResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AN_SuitableCalcResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AN_SuitableCalcResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "AN_SuitableCalcResult"));
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
