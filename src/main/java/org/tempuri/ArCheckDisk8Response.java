/**
 * ArCheckDisk8Response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class ArCheckDisk8Response  implements java.io.Serializable {
    private boolean arCheckDisk8Result;

    public ArCheckDisk8Response() {
    }

    public ArCheckDisk8Response(
           boolean arCheckDisk8Result) {
           this.arCheckDisk8Result = arCheckDisk8Result;
    }


    /**
     * Gets the arCheckDisk8Result value for this ArCheckDisk8Response.
     * 
     * @return arCheckDisk8Result
     */
    public boolean isArCheckDisk8Result() {
        return arCheckDisk8Result;
    }


    /**
     * Sets the arCheckDisk8Result value for this ArCheckDisk8Response.
     * 
     * @param arCheckDisk8Result
     */
    public void setArCheckDisk8Result(boolean arCheckDisk8Result) {
        this.arCheckDisk8Result = arCheckDisk8Result;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ArCheckDisk8Response)) return false;
        ArCheckDisk8Response other = (ArCheckDisk8Response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.arCheckDisk8Result == other.isArCheckDisk8Result();
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
        _hashCode += (isArCheckDisk8Result() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ArCheckDisk8Response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">arCheckDisk8Response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("arCheckDisk8Result");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "arCheckDisk8Result"));
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
