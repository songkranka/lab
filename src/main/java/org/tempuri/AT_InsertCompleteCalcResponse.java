/**
 * AT_InsertCompleteCalcResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AT_InsertCompleteCalcResponse  implements java.io.Serializable {
    private java.lang.String AT_InsertCompleteCalcResult;

    public AT_InsertCompleteCalcResponse() {
    }

    public AT_InsertCompleteCalcResponse(
           java.lang.String AT_InsertCompleteCalcResult) {
           this.AT_InsertCompleteCalcResult = AT_InsertCompleteCalcResult;
    }


    /**
     * Gets the AT_InsertCompleteCalcResult value for this AT_InsertCompleteCalcResponse.
     * 
     * @return AT_InsertCompleteCalcResult
     */
    public java.lang.String getAT_InsertCompleteCalcResult() {
        return AT_InsertCompleteCalcResult;
    }


    /**
     * Sets the AT_InsertCompleteCalcResult value for this AT_InsertCompleteCalcResponse.
     * 
     * @param AT_InsertCompleteCalcResult
     */
    public void setAT_InsertCompleteCalcResult(java.lang.String AT_InsertCompleteCalcResult) {
        this.AT_InsertCompleteCalcResult = AT_InsertCompleteCalcResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AT_InsertCompleteCalcResponse)) return false;
        AT_InsertCompleteCalcResponse other = (AT_InsertCompleteCalcResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.AT_InsertCompleteCalcResult==null && other.getAT_InsertCompleteCalcResult()==null) || 
             (this.AT_InsertCompleteCalcResult!=null &&
              this.AT_InsertCompleteCalcResult.equals(other.getAT_InsertCompleteCalcResult())));
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
        if (getAT_InsertCompleteCalcResult() != null) {
            _hashCode += getAT_InsertCompleteCalcResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AT_InsertCompleteCalcResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AT_InsertCompleteCalcResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AT_InsertCompleteCalcResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "AT_InsertCompleteCalcResult"));
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
