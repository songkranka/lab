/**
 * AT_InsertCompleteCalcCastrolResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AT_InsertCompleteCalcCastrolResponse  implements java.io.Serializable {
    private java.lang.String AT_InsertCompleteCalcCastrolResult;

    public AT_InsertCompleteCalcCastrolResponse() {
    }

    public AT_InsertCompleteCalcCastrolResponse(
           java.lang.String AT_InsertCompleteCalcCastrolResult) {
           this.AT_InsertCompleteCalcCastrolResult = AT_InsertCompleteCalcCastrolResult;
    }


    /**
     * Gets the AT_InsertCompleteCalcCastrolResult value for this AT_InsertCompleteCalcCastrolResponse.
     * 
     * @return AT_InsertCompleteCalcCastrolResult
     */
    public java.lang.String getAT_InsertCompleteCalcCastrolResult() {
        return AT_InsertCompleteCalcCastrolResult;
    }


    /**
     * Sets the AT_InsertCompleteCalcCastrolResult value for this AT_InsertCompleteCalcCastrolResponse.
     * 
     * @param AT_InsertCompleteCalcCastrolResult
     */
    public void setAT_InsertCompleteCalcCastrolResult(java.lang.String AT_InsertCompleteCalcCastrolResult) {
        this.AT_InsertCompleteCalcCastrolResult = AT_InsertCompleteCalcCastrolResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AT_InsertCompleteCalcCastrolResponse)) return false;
        AT_InsertCompleteCalcCastrolResponse other = (AT_InsertCompleteCalcCastrolResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.AT_InsertCompleteCalcCastrolResult==null && other.getAT_InsertCompleteCalcCastrolResult()==null) || 
             (this.AT_InsertCompleteCalcCastrolResult!=null &&
              this.AT_InsertCompleteCalcCastrolResult.equals(other.getAT_InsertCompleteCalcCastrolResult())));
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
        if (getAT_InsertCompleteCalcCastrolResult() != null) {
            _hashCode += getAT_InsertCompleteCalcCastrolResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AT_InsertCompleteCalcCastrolResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AT_InsertCompleteCalcCastrolResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AT_InsertCompleteCalcCastrolResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "AT_InsertCompleteCalcCastrolResult"));
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
