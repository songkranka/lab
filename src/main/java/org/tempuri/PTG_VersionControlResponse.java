/**
 * PTG_VersionControlResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class PTG_VersionControlResponse  implements java.io.Serializable {
    private boolean PTG_VersionControlResult;

    public PTG_VersionControlResponse() {
    }

    public PTG_VersionControlResponse(
           boolean PTG_VersionControlResult) {
           this.PTG_VersionControlResult = PTG_VersionControlResult;
    }


    /**
     * Gets the PTG_VersionControlResult value for this PTG_VersionControlResponse.
     * 
     * @return PTG_VersionControlResult
     */
    public boolean isPTG_VersionControlResult() {
        return PTG_VersionControlResult;
    }


    /**
     * Sets the PTG_VersionControlResult value for this PTG_VersionControlResponse.
     * 
     * @param PTG_VersionControlResult
     */
    public void setPTG_VersionControlResult(boolean PTG_VersionControlResult) {
        this.PTG_VersionControlResult = PTG_VersionControlResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PTG_VersionControlResponse)) return false;
        PTG_VersionControlResponse other = (PTG_VersionControlResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.PTG_VersionControlResult == other.isPTG_VersionControlResult();
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
        _hashCode += (isPTG_VersionControlResult() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PTG_VersionControlResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">PTG_VersionControlResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PTG_VersionControlResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "PTG_VersionControlResult"));
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
