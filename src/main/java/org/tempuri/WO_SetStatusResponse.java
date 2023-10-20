/**
 * WO_SetStatusResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class WO_SetStatusResponse  implements java.io.Serializable {
    private boolean WO_SetStatusResult;

    public WO_SetStatusResponse() {
    }

    public WO_SetStatusResponse(
           boolean WO_SetStatusResult) {
           this.WO_SetStatusResult = WO_SetStatusResult;
    }


    /**
     * Gets the WO_SetStatusResult value for this WO_SetStatusResponse.
     * 
     * @return WO_SetStatusResult
     */
    public boolean isWO_SetStatusResult() {
        return WO_SetStatusResult;
    }


    /**
     * Sets the WO_SetStatusResult value for this WO_SetStatusResponse.
     * 
     * @param WO_SetStatusResult
     */
    public void setWO_SetStatusResult(boolean WO_SetStatusResult) {
        this.WO_SetStatusResult = WO_SetStatusResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WO_SetStatusResponse)) return false;
        WO_SetStatusResponse other = (WO_SetStatusResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.WO_SetStatusResult == other.isWO_SetStatusResult();
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
        _hashCode += (isWO_SetStatusResult() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WO_SetStatusResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">WO_SetStatusResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("WO_SetStatusResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "WO_SetStatusResult"));
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
