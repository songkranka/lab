/**
 * AT_GetLupeMaxTypeResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AT_GetLupeMaxTypeResponse  implements java.io.Serializable {
    private java.lang.String AT_GetLupeMaxTypeResult;

    public AT_GetLupeMaxTypeResponse() {
    }

    public AT_GetLupeMaxTypeResponse(
           java.lang.String AT_GetLupeMaxTypeResult) {
           this.AT_GetLupeMaxTypeResult = AT_GetLupeMaxTypeResult;
    }


    /**
     * Gets the AT_GetLupeMaxTypeResult value for this AT_GetLupeMaxTypeResponse.
     * 
     * @return AT_GetLupeMaxTypeResult
     */
    public java.lang.String getAT_GetLupeMaxTypeResult() {
        return AT_GetLupeMaxTypeResult;
    }


    /**
     * Sets the AT_GetLupeMaxTypeResult value for this AT_GetLupeMaxTypeResponse.
     * 
     * @param AT_GetLupeMaxTypeResult
     */
    public void setAT_GetLupeMaxTypeResult(java.lang.String AT_GetLupeMaxTypeResult) {
        this.AT_GetLupeMaxTypeResult = AT_GetLupeMaxTypeResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AT_GetLupeMaxTypeResponse)) return false;
        AT_GetLupeMaxTypeResponse other = (AT_GetLupeMaxTypeResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.AT_GetLupeMaxTypeResult==null && other.getAT_GetLupeMaxTypeResult()==null) || 
             (this.AT_GetLupeMaxTypeResult!=null &&
              this.AT_GetLupeMaxTypeResult.equals(other.getAT_GetLupeMaxTypeResult())));
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
        if (getAT_GetLupeMaxTypeResult() != null) {
            _hashCode += getAT_GetLupeMaxTypeResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AT_GetLupeMaxTypeResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AT_GetLupeMaxTypeResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AT_GetLupeMaxTypeResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "AT_GetLupeMaxTypeResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
