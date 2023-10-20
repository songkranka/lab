/**
 * WO_AutoAllowCheckResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class WO_AutoAllowCheckResponse  implements java.io.Serializable {
    private int WO_AutoAllowCheckResult;

    public WO_AutoAllowCheckResponse() {
    }

    public WO_AutoAllowCheckResponse(
           int WO_AutoAllowCheckResult) {
           this.WO_AutoAllowCheckResult = WO_AutoAllowCheckResult;
    }


    /**
     * Gets the WO_AutoAllowCheckResult value for this WO_AutoAllowCheckResponse.
     * 
     * @return WO_AutoAllowCheckResult
     */
    public int getWO_AutoAllowCheckResult() {
        return WO_AutoAllowCheckResult;
    }


    /**
     * Sets the WO_AutoAllowCheckResult value for this WO_AutoAllowCheckResponse.
     * 
     * @param WO_AutoAllowCheckResult
     */
    public void setWO_AutoAllowCheckResult(int WO_AutoAllowCheckResult) {
        this.WO_AutoAllowCheckResult = WO_AutoAllowCheckResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WO_AutoAllowCheckResponse)) return false;
        WO_AutoAllowCheckResponse other = (WO_AutoAllowCheckResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.WO_AutoAllowCheckResult == other.getWO_AutoAllowCheckResult();
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
        _hashCode += getWO_AutoAllowCheckResult();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WO_AutoAllowCheckResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">WO_AutoAllowCheckResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("WO_AutoAllowCheckResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "WO_AutoAllowCheckResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
