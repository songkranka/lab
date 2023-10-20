/**
 * AT_EditDayTransferResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AT_EditDayTransferResponse  implements java.io.Serializable {
    private java.lang.String AT_EditDayTransferResult;

    public AT_EditDayTransferResponse() {
    }

    public AT_EditDayTransferResponse(
           java.lang.String AT_EditDayTransferResult) {
           this.AT_EditDayTransferResult = AT_EditDayTransferResult;
    }


    /**
     * Gets the AT_EditDayTransferResult value for this AT_EditDayTransferResponse.
     * 
     * @return AT_EditDayTransferResult
     */
    public java.lang.String getAT_EditDayTransferResult() {
        return AT_EditDayTransferResult;
    }


    /**
     * Sets the AT_EditDayTransferResult value for this AT_EditDayTransferResponse.
     * 
     * @param AT_EditDayTransferResult
     */
    public void setAT_EditDayTransferResult(java.lang.String AT_EditDayTransferResult) {
        this.AT_EditDayTransferResult = AT_EditDayTransferResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AT_EditDayTransferResponse)) return false;
        AT_EditDayTransferResponse other = (AT_EditDayTransferResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.AT_EditDayTransferResult==null && other.getAT_EditDayTransferResult()==null) || 
             (this.AT_EditDayTransferResult!=null &&
              this.AT_EditDayTransferResult.equals(other.getAT_EditDayTransferResult())));
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
        if (getAT_EditDayTransferResult() != null) {
            _hashCode += getAT_EditDayTransferResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AT_EditDayTransferResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AT_EditDayTransferResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AT_EditDayTransferResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "AT_EditDayTransferResult"));
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
