/**
 * AT_InsertCompleteCalcRevisePrintResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AT_InsertCompleteCalcRevisePrintResponse  implements java.io.Serializable {
    private org.tempuri.AT_InsertCompleteCalcRevisePrintResponseAT_InsertCompleteCalcRevisePrintResult AT_InsertCompleteCalcRevisePrintResult;

    public AT_InsertCompleteCalcRevisePrintResponse() {
    }

    public AT_InsertCompleteCalcRevisePrintResponse(
           org.tempuri.AT_InsertCompleteCalcRevisePrintResponseAT_InsertCompleteCalcRevisePrintResult AT_InsertCompleteCalcRevisePrintResult) {
           this.AT_InsertCompleteCalcRevisePrintResult = AT_InsertCompleteCalcRevisePrintResult;
    }


    /**
     * Gets the AT_InsertCompleteCalcRevisePrintResult value for this AT_InsertCompleteCalcRevisePrintResponse.
     * 
     * @return AT_InsertCompleteCalcRevisePrintResult
     */
    public org.tempuri.AT_InsertCompleteCalcRevisePrintResponseAT_InsertCompleteCalcRevisePrintResult getAT_InsertCompleteCalcRevisePrintResult() {
        return AT_InsertCompleteCalcRevisePrintResult;
    }


    /**
     * Sets the AT_InsertCompleteCalcRevisePrintResult value for this AT_InsertCompleteCalcRevisePrintResponse.
     * 
     * @param AT_InsertCompleteCalcRevisePrintResult
     */
    public void setAT_InsertCompleteCalcRevisePrintResult(org.tempuri.AT_InsertCompleteCalcRevisePrintResponseAT_InsertCompleteCalcRevisePrintResult AT_InsertCompleteCalcRevisePrintResult) {
        this.AT_InsertCompleteCalcRevisePrintResult = AT_InsertCompleteCalcRevisePrintResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AT_InsertCompleteCalcRevisePrintResponse)) return false;
        AT_InsertCompleteCalcRevisePrintResponse other = (AT_InsertCompleteCalcRevisePrintResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.AT_InsertCompleteCalcRevisePrintResult==null && other.getAT_InsertCompleteCalcRevisePrintResult()==null) || 
             (this.AT_InsertCompleteCalcRevisePrintResult!=null &&
              this.AT_InsertCompleteCalcRevisePrintResult.equals(other.getAT_InsertCompleteCalcRevisePrintResult())));
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
        if (getAT_InsertCompleteCalcRevisePrintResult() != null) {
            _hashCode += getAT_InsertCompleteCalcRevisePrintResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AT_InsertCompleteCalcRevisePrintResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AT_InsertCompleteCalcRevisePrintResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AT_InsertCompleteCalcRevisePrintResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "AT_InsertCompleteCalcRevisePrintResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>AT_InsertCompleteCalcRevisePrintResponse>AT_InsertCompleteCalcRevisePrintResult"));
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
