/**
 * POS_PROMOTION_SETResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class POS_PROMOTION_SETResponse  implements java.io.Serializable {
    private boolean POS_PROMOTION_SETResult;

    public POS_PROMOTION_SETResponse() {
    }

    public POS_PROMOTION_SETResponse(
           boolean POS_PROMOTION_SETResult) {
           this.POS_PROMOTION_SETResult = POS_PROMOTION_SETResult;
    }


    /**
     * Gets the POS_PROMOTION_SETResult value for this POS_PROMOTION_SETResponse.
     * 
     * @return POS_PROMOTION_SETResult
     */
    public boolean isPOS_PROMOTION_SETResult() {
        return POS_PROMOTION_SETResult;
    }


    /**
     * Sets the POS_PROMOTION_SETResult value for this POS_PROMOTION_SETResponse.
     * 
     * @param POS_PROMOTION_SETResult
     */
    public void setPOS_PROMOTION_SETResult(boolean POS_PROMOTION_SETResult) {
        this.POS_PROMOTION_SETResult = POS_PROMOTION_SETResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof POS_PROMOTION_SETResponse)) return false;
        POS_PROMOTION_SETResponse other = (POS_PROMOTION_SETResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.POS_PROMOTION_SETResult == other.isPOS_PROMOTION_SETResult();
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
        _hashCode += (isPOS_PROMOTION_SETResult() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(POS_PROMOTION_SETResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">POS_PROMOTION_SETResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("POS_PROMOTION_SETResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "POS_PROMOTION_SETResult"));
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
