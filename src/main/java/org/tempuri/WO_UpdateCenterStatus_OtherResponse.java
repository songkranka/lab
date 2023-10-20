/**
 * WO_UpdateCenterStatus_OtherResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class WO_UpdateCenterStatus_OtherResponse  implements java.io.Serializable {
    private boolean WO_UpdateCenterStatus_OtherResult;

    public WO_UpdateCenterStatus_OtherResponse() {
    }

    public WO_UpdateCenterStatus_OtherResponse(
           boolean WO_UpdateCenterStatus_OtherResult) {
           this.WO_UpdateCenterStatus_OtherResult = WO_UpdateCenterStatus_OtherResult;
    }


    /**
     * Gets the WO_UpdateCenterStatus_OtherResult value for this WO_UpdateCenterStatus_OtherResponse.
     * 
     * @return WO_UpdateCenterStatus_OtherResult
     */
    public boolean isWO_UpdateCenterStatus_OtherResult() {
        return WO_UpdateCenterStatus_OtherResult;
    }


    /**
     * Sets the WO_UpdateCenterStatus_OtherResult value for this WO_UpdateCenterStatus_OtherResponse.
     * 
     * @param WO_UpdateCenterStatus_OtherResult
     */
    public void setWO_UpdateCenterStatus_OtherResult(boolean WO_UpdateCenterStatus_OtherResult) {
        this.WO_UpdateCenterStatus_OtherResult = WO_UpdateCenterStatus_OtherResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WO_UpdateCenterStatus_OtherResponse)) return false;
        WO_UpdateCenterStatus_OtherResponse other = (WO_UpdateCenterStatus_OtherResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.WO_UpdateCenterStatus_OtherResult == other.isWO_UpdateCenterStatus_OtherResult();
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
        _hashCode += (isWO_UpdateCenterStatus_OtherResult() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WO_UpdateCenterStatus_OtherResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">WO_UpdateCenterStatus_OtherResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("WO_UpdateCenterStatus_OtherResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "WO_UpdateCenterStatus_OtherResult"));
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
