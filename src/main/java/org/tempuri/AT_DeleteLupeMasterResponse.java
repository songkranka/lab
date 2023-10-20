/**
 * AT_DeleteLupeMasterResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AT_DeleteLupeMasterResponse  implements java.io.Serializable {
    private java.lang.String AT_DeleteLupeMasterResult;

    public AT_DeleteLupeMasterResponse() {
    }

    public AT_DeleteLupeMasterResponse(
           java.lang.String AT_DeleteLupeMasterResult) {
           this.AT_DeleteLupeMasterResult = AT_DeleteLupeMasterResult;
    }


    /**
     * Gets the AT_DeleteLupeMasterResult value for this AT_DeleteLupeMasterResponse.
     * 
     * @return AT_DeleteLupeMasterResult
     */
    public java.lang.String getAT_DeleteLupeMasterResult() {
        return AT_DeleteLupeMasterResult;
    }


    /**
     * Sets the AT_DeleteLupeMasterResult value for this AT_DeleteLupeMasterResponse.
     * 
     * @param AT_DeleteLupeMasterResult
     */
    public void setAT_DeleteLupeMasterResult(java.lang.String AT_DeleteLupeMasterResult) {
        this.AT_DeleteLupeMasterResult = AT_DeleteLupeMasterResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AT_DeleteLupeMasterResponse)) return false;
        AT_DeleteLupeMasterResponse other = (AT_DeleteLupeMasterResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.AT_DeleteLupeMasterResult==null && other.getAT_DeleteLupeMasterResult()==null) || 
             (this.AT_DeleteLupeMasterResult!=null &&
              this.AT_DeleteLupeMasterResult.equals(other.getAT_DeleteLupeMasterResult())));
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
        if (getAT_DeleteLupeMasterResult() != null) {
            _hashCode += getAT_DeleteLupeMasterResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AT_DeleteLupeMasterResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AT_DeleteLupeMasterResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AT_DeleteLupeMasterResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "AT_DeleteLupeMasterResult"));
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
