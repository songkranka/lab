/**
 * AT_InsertCompleteCalcLPGResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AT_InsertCompleteCalcLPGResponse  implements java.io.Serializable {
    private java.lang.String AT_InsertCompleteCalcLPGResult;

    public AT_InsertCompleteCalcLPGResponse() {
    }

    public AT_InsertCompleteCalcLPGResponse(
           java.lang.String AT_InsertCompleteCalcLPGResult) {
           this.AT_InsertCompleteCalcLPGResult = AT_InsertCompleteCalcLPGResult;
    }


    /**
     * Gets the AT_InsertCompleteCalcLPGResult value for this AT_InsertCompleteCalcLPGResponse.
     * 
     * @return AT_InsertCompleteCalcLPGResult
     */
    public java.lang.String getAT_InsertCompleteCalcLPGResult() {
        return AT_InsertCompleteCalcLPGResult;
    }


    /**
     * Sets the AT_InsertCompleteCalcLPGResult value for this AT_InsertCompleteCalcLPGResponse.
     * 
     * @param AT_InsertCompleteCalcLPGResult
     */
    public void setAT_InsertCompleteCalcLPGResult(java.lang.String AT_InsertCompleteCalcLPGResult) {
        this.AT_InsertCompleteCalcLPGResult = AT_InsertCompleteCalcLPGResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AT_InsertCompleteCalcLPGResponse)) return false;
        AT_InsertCompleteCalcLPGResponse other = (AT_InsertCompleteCalcLPGResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.AT_InsertCompleteCalcLPGResult==null && other.getAT_InsertCompleteCalcLPGResult()==null) || 
             (this.AT_InsertCompleteCalcLPGResult!=null &&
              this.AT_InsertCompleteCalcLPGResult.equals(other.getAT_InsertCompleteCalcLPGResult())));
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
        if (getAT_InsertCompleteCalcLPGResult() != null) {
            _hashCode += getAT_InsertCompleteCalcLPGResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AT_InsertCompleteCalcLPGResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AT_InsertCompleteCalcLPGResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AT_InsertCompleteCalcLPGResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "AT_InsertCompleteCalcLPGResult"));
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
