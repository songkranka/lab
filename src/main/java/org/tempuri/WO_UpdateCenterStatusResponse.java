/**
 * WO_UpdateCenterStatusResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class WO_UpdateCenterStatusResponse  implements java.io.Serializable {
    private boolean WO_UpdateCenterStatusResult;

    public WO_UpdateCenterStatusResponse() {
    }

    public WO_UpdateCenterStatusResponse(
           boolean WO_UpdateCenterStatusResult) {
           this.WO_UpdateCenterStatusResult = WO_UpdateCenterStatusResult;
    }


    /**
     * Gets the WO_UpdateCenterStatusResult value for this WO_UpdateCenterStatusResponse.
     * 
     * @return WO_UpdateCenterStatusResult
     */
    public boolean isWO_UpdateCenterStatusResult() {
        return WO_UpdateCenterStatusResult;
    }


    /**
     * Sets the WO_UpdateCenterStatusResult value for this WO_UpdateCenterStatusResponse.
     * 
     * @param WO_UpdateCenterStatusResult
     */
    public void setWO_UpdateCenterStatusResult(boolean WO_UpdateCenterStatusResult) {
        this.WO_UpdateCenterStatusResult = WO_UpdateCenterStatusResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WO_UpdateCenterStatusResponse)) return false;
        WO_UpdateCenterStatusResponse other = (WO_UpdateCenterStatusResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.WO_UpdateCenterStatusResult == other.isWO_UpdateCenterStatusResult();
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
        _hashCode += (isWO_UpdateCenterStatusResult() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WO_UpdateCenterStatusResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">WO_UpdateCenterStatusResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("WO_UpdateCenterStatusResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "WO_UpdateCenterStatusResult"));
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
