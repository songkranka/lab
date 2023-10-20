/**
 * AT_SetlupeLPGResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AT_SetlupeLPGResponse  implements java.io.Serializable {
    private java.lang.String AT_SetlupeLPGResult;

    public AT_SetlupeLPGResponse() {
    }

    public AT_SetlupeLPGResponse(
           java.lang.String AT_SetlupeLPGResult) {
           this.AT_SetlupeLPGResult = AT_SetlupeLPGResult;
    }


    /**
     * Gets the AT_SetlupeLPGResult value for this AT_SetlupeLPGResponse.
     * 
     * @return AT_SetlupeLPGResult
     */
    public java.lang.String getAT_SetlupeLPGResult() {
        return AT_SetlupeLPGResult;
    }


    /**
     * Sets the AT_SetlupeLPGResult value for this AT_SetlupeLPGResponse.
     * 
     * @param AT_SetlupeLPGResult
     */
    public void setAT_SetlupeLPGResult(java.lang.String AT_SetlupeLPGResult) {
        this.AT_SetlupeLPGResult = AT_SetlupeLPGResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AT_SetlupeLPGResponse)) return false;
        AT_SetlupeLPGResponse other = (AT_SetlupeLPGResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.AT_SetlupeLPGResult==null && other.getAT_SetlupeLPGResult()==null) || 
             (this.AT_SetlupeLPGResult!=null &&
              this.AT_SetlupeLPGResult.equals(other.getAT_SetlupeLPGResult())));
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
        if (getAT_SetlupeLPGResult() != null) {
            _hashCode += getAT_SetlupeLPGResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AT_SetlupeLPGResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AT_SetlupeLPGResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AT_SetlupeLPGResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "AT_SetlupeLPGResult"));
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
