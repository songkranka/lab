/**
 * AT_InsertCompleteCalcCastrolPrintResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AT_InsertCompleteCalcCastrolPrintResponse  implements java.io.Serializable {
    private org.tempuri.AT_InsertCompleteCalcCastrolPrintResponseAT_InsertCompleteCalcCastrolPrintResult AT_InsertCompleteCalcCastrolPrintResult;

    public AT_InsertCompleteCalcCastrolPrintResponse() {
    }

    public AT_InsertCompleteCalcCastrolPrintResponse(
           org.tempuri.AT_InsertCompleteCalcCastrolPrintResponseAT_InsertCompleteCalcCastrolPrintResult AT_InsertCompleteCalcCastrolPrintResult) {
           this.AT_InsertCompleteCalcCastrolPrintResult = AT_InsertCompleteCalcCastrolPrintResult;
    }


    /**
     * Gets the AT_InsertCompleteCalcCastrolPrintResult value for this AT_InsertCompleteCalcCastrolPrintResponse.
     * 
     * @return AT_InsertCompleteCalcCastrolPrintResult
     */
    public org.tempuri.AT_InsertCompleteCalcCastrolPrintResponseAT_InsertCompleteCalcCastrolPrintResult getAT_InsertCompleteCalcCastrolPrintResult() {
        return AT_InsertCompleteCalcCastrolPrintResult;
    }


    /**
     * Sets the AT_InsertCompleteCalcCastrolPrintResult value for this AT_InsertCompleteCalcCastrolPrintResponse.
     * 
     * @param AT_InsertCompleteCalcCastrolPrintResult
     */
    public void setAT_InsertCompleteCalcCastrolPrintResult(org.tempuri.AT_InsertCompleteCalcCastrolPrintResponseAT_InsertCompleteCalcCastrolPrintResult AT_InsertCompleteCalcCastrolPrintResult) {
        this.AT_InsertCompleteCalcCastrolPrintResult = AT_InsertCompleteCalcCastrolPrintResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AT_InsertCompleteCalcCastrolPrintResponse)) return false;
        AT_InsertCompleteCalcCastrolPrintResponse other = (AT_InsertCompleteCalcCastrolPrintResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.AT_InsertCompleteCalcCastrolPrintResult==null && other.getAT_InsertCompleteCalcCastrolPrintResult()==null) || 
             (this.AT_InsertCompleteCalcCastrolPrintResult!=null &&
              this.AT_InsertCompleteCalcCastrolPrintResult.equals(other.getAT_InsertCompleteCalcCastrolPrintResult())));
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
        if (getAT_InsertCompleteCalcCastrolPrintResult() != null) {
            _hashCode += getAT_InsertCompleteCalcCastrolPrintResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AT_InsertCompleteCalcCastrolPrintResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AT_InsertCompleteCalcCastrolPrintResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AT_InsertCompleteCalcCastrolPrintResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "AT_InsertCompleteCalcCastrolPrintResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>AT_InsertCompleteCalcCastrolPrintResponse>AT_InsertCompleteCalcCastrolPrintResult"));
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
