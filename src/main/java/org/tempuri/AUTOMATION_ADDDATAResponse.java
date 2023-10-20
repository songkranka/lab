/**
 * AUTOMATION_ADDDATAResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AUTOMATION_ADDDATAResponse  implements java.io.Serializable {
    private boolean AUTOMATION_ADDDATAResult;

    public AUTOMATION_ADDDATAResponse() {
    }

    public AUTOMATION_ADDDATAResponse(
           boolean AUTOMATION_ADDDATAResult) {
           this.AUTOMATION_ADDDATAResult = AUTOMATION_ADDDATAResult;
    }


    /**
     * Gets the AUTOMATION_ADDDATAResult value for this AUTOMATION_ADDDATAResponse.
     * 
     * @return AUTOMATION_ADDDATAResult
     */
    public boolean isAUTOMATION_ADDDATAResult() {
        return AUTOMATION_ADDDATAResult;
    }


    /**
     * Sets the AUTOMATION_ADDDATAResult value for this AUTOMATION_ADDDATAResponse.
     * 
     * @param AUTOMATION_ADDDATAResult
     */
    public void setAUTOMATION_ADDDATAResult(boolean AUTOMATION_ADDDATAResult) {
        this.AUTOMATION_ADDDATAResult = AUTOMATION_ADDDATAResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AUTOMATION_ADDDATAResponse)) return false;
        AUTOMATION_ADDDATAResponse other = (AUTOMATION_ADDDATAResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.AUTOMATION_ADDDATAResult == other.isAUTOMATION_ADDDATAResult();
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
        _hashCode += (isAUTOMATION_ADDDATAResult() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AUTOMATION_ADDDATAResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AUTOMATION_ADDDATAResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AUTOMATION_ADDDATAResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "AUTOMATION_ADDDATAResult"));
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
