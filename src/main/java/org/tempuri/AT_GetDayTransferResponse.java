/**
 * AT_GetDayTransferResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AT_GetDayTransferResponse  implements java.io.Serializable {
    private org.tempuri.AT_GetDayTransferResponseAT_GetDayTransferResult AT_GetDayTransferResult;

    public AT_GetDayTransferResponse() {
    }

    public AT_GetDayTransferResponse(
           org.tempuri.AT_GetDayTransferResponseAT_GetDayTransferResult AT_GetDayTransferResult) {
           this.AT_GetDayTransferResult = AT_GetDayTransferResult;
    }


    /**
     * Gets the AT_GetDayTransferResult value for this AT_GetDayTransferResponse.
     * 
     * @return AT_GetDayTransferResult
     */
    public org.tempuri.AT_GetDayTransferResponseAT_GetDayTransferResult getAT_GetDayTransferResult() {
        return AT_GetDayTransferResult;
    }


    /**
     * Sets the AT_GetDayTransferResult value for this AT_GetDayTransferResponse.
     * 
     * @param AT_GetDayTransferResult
     */
    public void setAT_GetDayTransferResult(org.tempuri.AT_GetDayTransferResponseAT_GetDayTransferResult AT_GetDayTransferResult) {
        this.AT_GetDayTransferResult = AT_GetDayTransferResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AT_GetDayTransferResponse)) return false;
        AT_GetDayTransferResponse other = (AT_GetDayTransferResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.AT_GetDayTransferResult==null && other.getAT_GetDayTransferResult()==null) || 
             (this.AT_GetDayTransferResult!=null &&
              this.AT_GetDayTransferResult.equals(other.getAT_GetDayTransferResult())));
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
        if (getAT_GetDayTransferResult() != null) {
            _hashCode += getAT_GetDayTransferResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AT_GetDayTransferResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AT_GetDayTransferResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AT_GetDayTransferResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "AT_GetDayTransferResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>AT_GetDayTransferResponse>AT_GetDayTransferResult"));
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
