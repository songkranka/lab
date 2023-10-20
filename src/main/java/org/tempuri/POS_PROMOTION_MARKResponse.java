/**
 * POS_PROMOTION_MARKResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class POS_PROMOTION_MARKResponse  implements java.io.Serializable {
    private boolean POS_PROMOTION_MARKResult;

    public POS_PROMOTION_MARKResponse() {
    }

    public POS_PROMOTION_MARKResponse(
           boolean POS_PROMOTION_MARKResult) {
           this.POS_PROMOTION_MARKResult = POS_PROMOTION_MARKResult;
    }


    /**
     * Gets the POS_PROMOTION_MARKResult value for this POS_PROMOTION_MARKResponse.
     * 
     * @return POS_PROMOTION_MARKResult
     */
    public boolean isPOS_PROMOTION_MARKResult() {
        return POS_PROMOTION_MARKResult;
    }


    /**
     * Sets the POS_PROMOTION_MARKResult value for this POS_PROMOTION_MARKResponse.
     * 
     * @param POS_PROMOTION_MARKResult
     */
    public void setPOS_PROMOTION_MARKResult(boolean POS_PROMOTION_MARKResult) {
        this.POS_PROMOTION_MARKResult = POS_PROMOTION_MARKResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof POS_PROMOTION_MARKResponse)) return false;
        POS_PROMOTION_MARKResponse other = (POS_PROMOTION_MARKResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.POS_PROMOTION_MARKResult == other.isPOS_PROMOTION_MARKResult();
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
        _hashCode += (isPOS_PROMOTION_MARKResult() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(POS_PROMOTION_MARKResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">POS_PROMOTION_MARKResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("POS_PROMOTION_MARKResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "POS_PROMOTION_MARKResult"));
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
