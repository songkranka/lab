/**
 * AT_InsertCompleteCalcMaxnetronResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AT_InsertCompleteCalcMaxnetronResponse  implements java.io.Serializable {
    private java.lang.String AT_InsertCompleteCalcMaxnetronResult;

    public AT_InsertCompleteCalcMaxnetronResponse() {
    }

    public AT_InsertCompleteCalcMaxnetronResponse(
           java.lang.String AT_InsertCompleteCalcMaxnetronResult) {
           this.AT_InsertCompleteCalcMaxnetronResult = AT_InsertCompleteCalcMaxnetronResult;
    }


    /**
     * Gets the AT_InsertCompleteCalcMaxnetronResult value for this AT_InsertCompleteCalcMaxnetronResponse.
     * 
     * @return AT_InsertCompleteCalcMaxnetronResult
     */
    public java.lang.String getAT_InsertCompleteCalcMaxnetronResult() {
        return AT_InsertCompleteCalcMaxnetronResult;
    }


    /**
     * Sets the AT_InsertCompleteCalcMaxnetronResult value for this AT_InsertCompleteCalcMaxnetronResponse.
     * 
     * @param AT_InsertCompleteCalcMaxnetronResult
     */
    public void setAT_InsertCompleteCalcMaxnetronResult(java.lang.String AT_InsertCompleteCalcMaxnetronResult) {
        this.AT_InsertCompleteCalcMaxnetronResult = AT_InsertCompleteCalcMaxnetronResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AT_InsertCompleteCalcMaxnetronResponse)) return false;
        AT_InsertCompleteCalcMaxnetronResponse other = (AT_InsertCompleteCalcMaxnetronResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.AT_InsertCompleteCalcMaxnetronResult==null && other.getAT_InsertCompleteCalcMaxnetronResult()==null) || 
             (this.AT_InsertCompleteCalcMaxnetronResult!=null &&
              this.AT_InsertCompleteCalcMaxnetronResult.equals(other.getAT_InsertCompleteCalcMaxnetronResult())));
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
        if (getAT_InsertCompleteCalcMaxnetronResult() != null) {
            _hashCode += getAT_InsertCompleteCalcMaxnetronResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AT_InsertCompleteCalcMaxnetronResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AT_InsertCompleteCalcMaxnetronResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AT_InsertCompleteCalcMaxnetronResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "AT_InsertCompleteCalcMaxnetronResult"));
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
