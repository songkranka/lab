/**
 * AT_InsertCompleteCalcPrintResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AT_InsertCompleteCalcPrintResponse  implements java.io.Serializable {
    private org.tempuri.AT_InsertCompleteCalcPrintResponseAT_InsertCompleteCalcPrintResult AT_InsertCompleteCalcPrintResult;

    public AT_InsertCompleteCalcPrintResponse() {
    }

    public AT_InsertCompleteCalcPrintResponse(
           org.tempuri.AT_InsertCompleteCalcPrintResponseAT_InsertCompleteCalcPrintResult AT_InsertCompleteCalcPrintResult) {
           this.AT_InsertCompleteCalcPrintResult = AT_InsertCompleteCalcPrintResult;
    }


    /**
     * Gets the AT_InsertCompleteCalcPrintResult value for this AT_InsertCompleteCalcPrintResponse.
     * 
     * @return AT_InsertCompleteCalcPrintResult
     */
    public org.tempuri.AT_InsertCompleteCalcPrintResponseAT_InsertCompleteCalcPrintResult getAT_InsertCompleteCalcPrintResult() {
        return AT_InsertCompleteCalcPrintResult;
    }


    /**
     * Sets the AT_InsertCompleteCalcPrintResult value for this AT_InsertCompleteCalcPrintResponse.
     * 
     * @param AT_InsertCompleteCalcPrintResult
     */
    public void setAT_InsertCompleteCalcPrintResult(org.tempuri.AT_InsertCompleteCalcPrintResponseAT_InsertCompleteCalcPrintResult AT_InsertCompleteCalcPrintResult) {
        this.AT_InsertCompleteCalcPrintResult = AT_InsertCompleteCalcPrintResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AT_InsertCompleteCalcPrintResponse)) return false;
        AT_InsertCompleteCalcPrintResponse other = (AT_InsertCompleteCalcPrintResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.AT_InsertCompleteCalcPrintResult==null && other.getAT_InsertCompleteCalcPrintResult()==null) || 
             (this.AT_InsertCompleteCalcPrintResult!=null &&
              this.AT_InsertCompleteCalcPrintResult.equals(other.getAT_InsertCompleteCalcPrintResult())));
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
        if (getAT_InsertCompleteCalcPrintResult() != null) {
            _hashCode += getAT_InsertCompleteCalcPrintResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AT_InsertCompleteCalcPrintResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AT_InsertCompleteCalcPrintResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AT_InsertCompleteCalcPrintResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "AT_InsertCompleteCalcPrintResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>AT_InsertCompleteCalcPrintResponse>AT_InsertCompleteCalcPrintResult"));
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
