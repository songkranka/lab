/**
 * Supply_UpdateAdjustResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class Supply_UpdateAdjustResponse  implements java.io.Serializable {
    private boolean supply_UpdateAdjustResult;

    public Supply_UpdateAdjustResponse() {
    }

    public Supply_UpdateAdjustResponse(
           boolean supply_UpdateAdjustResult) {
           this.supply_UpdateAdjustResult = supply_UpdateAdjustResult;
    }


    /**
     * Gets the supply_UpdateAdjustResult value for this Supply_UpdateAdjustResponse.
     * 
     * @return supply_UpdateAdjustResult
     */
    public boolean isSupply_UpdateAdjustResult() {
        return supply_UpdateAdjustResult;
    }


    /**
     * Sets the supply_UpdateAdjustResult value for this Supply_UpdateAdjustResponse.
     * 
     * @param supply_UpdateAdjustResult
     */
    public void setSupply_UpdateAdjustResult(boolean supply_UpdateAdjustResult) {
        this.supply_UpdateAdjustResult = supply_UpdateAdjustResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Supply_UpdateAdjustResponse)) return false;
        Supply_UpdateAdjustResponse other = (Supply_UpdateAdjustResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.supply_UpdateAdjustResult == other.isSupply_UpdateAdjustResult();
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
        _hashCode += (isSupply_UpdateAdjustResult() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Supply_UpdateAdjustResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">Supply_UpdateAdjustResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("supply_UpdateAdjustResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Supply_UpdateAdjustResult"));
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
