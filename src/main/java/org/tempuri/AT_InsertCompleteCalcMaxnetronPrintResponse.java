/**
 * AT_InsertCompleteCalcMaxnetronPrintResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AT_InsertCompleteCalcMaxnetronPrintResponse  implements java.io.Serializable {
    private org.tempuri.AT_InsertCompleteCalcMaxnetronPrintResponseAT_InsertCompleteCalcMaxnetronPrintResult AT_InsertCompleteCalcMaxnetronPrintResult;

    public AT_InsertCompleteCalcMaxnetronPrintResponse() {
    }

    public AT_InsertCompleteCalcMaxnetronPrintResponse(
           org.tempuri.AT_InsertCompleteCalcMaxnetronPrintResponseAT_InsertCompleteCalcMaxnetronPrintResult AT_InsertCompleteCalcMaxnetronPrintResult) {
           this.AT_InsertCompleteCalcMaxnetronPrintResult = AT_InsertCompleteCalcMaxnetronPrintResult;
    }


    /**
     * Gets the AT_InsertCompleteCalcMaxnetronPrintResult value for this AT_InsertCompleteCalcMaxnetronPrintResponse.
     * 
     * @return AT_InsertCompleteCalcMaxnetronPrintResult
     */
    public org.tempuri.AT_InsertCompleteCalcMaxnetronPrintResponseAT_InsertCompleteCalcMaxnetronPrintResult getAT_InsertCompleteCalcMaxnetronPrintResult() {
        return AT_InsertCompleteCalcMaxnetronPrintResult;
    }


    /**
     * Sets the AT_InsertCompleteCalcMaxnetronPrintResult value for this AT_InsertCompleteCalcMaxnetronPrintResponse.
     * 
     * @param AT_InsertCompleteCalcMaxnetronPrintResult
     */
    public void setAT_InsertCompleteCalcMaxnetronPrintResult(org.tempuri.AT_InsertCompleteCalcMaxnetronPrintResponseAT_InsertCompleteCalcMaxnetronPrintResult AT_InsertCompleteCalcMaxnetronPrintResult) {
        this.AT_InsertCompleteCalcMaxnetronPrintResult = AT_InsertCompleteCalcMaxnetronPrintResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AT_InsertCompleteCalcMaxnetronPrintResponse)) return false;
        AT_InsertCompleteCalcMaxnetronPrintResponse other = (AT_InsertCompleteCalcMaxnetronPrintResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.AT_InsertCompleteCalcMaxnetronPrintResult==null && other.getAT_InsertCompleteCalcMaxnetronPrintResult()==null) || 
             (this.AT_InsertCompleteCalcMaxnetronPrintResult!=null &&
              this.AT_InsertCompleteCalcMaxnetronPrintResult.equals(other.getAT_InsertCompleteCalcMaxnetronPrintResult())));
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
        if (getAT_InsertCompleteCalcMaxnetronPrintResult() != null) {
            _hashCode += getAT_InsertCompleteCalcMaxnetronPrintResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AT_InsertCompleteCalcMaxnetronPrintResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AT_InsertCompleteCalcMaxnetronPrintResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AT_InsertCompleteCalcMaxnetronPrintResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "AT_InsertCompleteCalcMaxnetronPrintResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>AT_InsertCompleteCalcMaxnetronPrintResponse>AT_InsertCompleteCalcMaxnetronPrintResult"));
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
