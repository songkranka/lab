/**
 * AT_InsertCompleteCalcLPGPrintResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AT_InsertCompleteCalcLPGPrintResponse  implements java.io.Serializable {
    private org.tempuri.AT_InsertCompleteCalcLPGPrintResponseAT_InsertCompleteCalcLPGPrintResult AT_InsertCompleteCalcLPGPrintResult;

    public AT_InsertCompleteCalcLPGPrintResponse() {
    }

    public AT_InsertCompleteCalcLPGPrintResponse(
           org.tempuri.AT_InsertCompleteCalcLPGPrintResponseAT_InsertCompleteCalcLPGPrintResult AT_InsertCompleteCalcLPGPrintResult) {
           this.AT_InsertCompleteCalcLPGPrintResult = AT_InsertCompleteCalcLPGPrintResult;
    }


    /**
     * Gets the AT_InsertCompleteCalcLPGPrintResult value for this AT_InsertCompleteCalcLPGPrintResponse.
     * 
     * @return AT_InsertCompleteCalcLPGPrintResult
     */
    public org.tempuri.AT_InsertCompleteCalcLPGPrintResponseAT_InsertCompleteCalcLPGPrintResult getAT_InsertCompleteCalcLPGPrintResult() {
        return AT_InsertCompleteCalcLPGPrintResult;
    }


    /**
     * Sets the AT_InsertCompleteCalcLPGPrintResult value for this AT_InsertCompleteCalcLPGPrintResponse.
     * 
     * @param AT_InsertCompleteCalcLPGPrintResult
     */
    public void setAT_InsertCompleteCalcLPGPrintResult(org.tempuri.AT_InsertCompleteCalcLPGPrintResponseAT_InsertCompleteCalcLPGPrintResult AT_InsertCompleteCalcLPGPrintResult) {
        this.AT_InsertCompleteCalcLPGPrintResult = AT_InsertCompleteCalcLPGPrintResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AT_InsertCompleteCalcLPGPrintResponse)) return false;
        AT_InsertCompleteCalcLPGPrintResponse other = (AT_InsertCompleteCalcLPGPrintResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.AT_InsertCompleteCalcLPGPrintResult==null && other.getAT_InsertCompleteCalcLPGPrintResult()==null) || 
             (this.AT_InsertCompleteCalcLPGPrintResult!=null &&
              this.AT_InsertCompleteCalcLPGPrintResult.equals(other.getAT_InsertCompleteCalcLPGPrintResult())));
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
        if (getAT_InsertCompleteCalcLPGPrintResult() != null) {
            _hashCode += getAT_InsertCompleteCalcLPGPrintResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AT_InsertCompleteCalcLPGPrintResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AT_InsertCompleteCalcLPGPrintResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AT_InsertCompleteCalcLPGPrintResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "AT_InsertCompleteCalcLPGPrintResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>AT_InsertCompleteCalcLPGPrintResponse>AT_InsertCompleteCalcLPGPrintResult"));
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
