/**
 * WO_CheckLimitWebOrderResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class WO_CheckLimitWebOrderResponse  implements java.io.Serializable {
    private double WO_CheckLimitWebOrderResult;

    public WO_CheckLimitWebOrderResponse() {
    }

    public WO_CheckLimitWebOrderResponse(
           double WO_CheckLimitWebOrderResult) {
           this.WO_CheckLimitWebOrderResult = WO_CheckLimitWebOrderResult;
    }


    /**
     * Gets the WO_CheckLimitWebOrderResult value for this WO_CheckLimitWebOrderResponse.
     * 
     * @return WO_CheckLimitWebOrderResult
     */
    public double getWO_CheckLimitWebOrderResult() {
        return WO_CheckLimitWebOrderResult;
    }


    /**
     * Sets the WO_CheckLimitWebOrderResult value for this WO_CheckLimitWebOrderResponse.
     * 
     * @param WO_CheckLimitWebOrderResult
     */
    public void setWO_CheckLimitWebOrderResult(double WO_CheckLimitWebOrderResult) {
        this.WO_CheckLimitWebOrderResult = WO_CheckLimitWebOrderResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WO_CheckLimitWebOrderResponse)) return false;
        WO_CheckLimitWebOrderResponse other = (WO_CheckLimitWebOrderResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.WO_CheckLimitWebOrderResult == other.getWO_CheckLimitWebOrderResult();
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
        _hashCode += new Double(getWO_CheckLimitWebOrderResult()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WO_CheckLimitWebOrderResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">WO_CheckLimitWebOrderResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("WO_CheckLimitWebOrderResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "WO_CheckLimitWebOrderResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
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
