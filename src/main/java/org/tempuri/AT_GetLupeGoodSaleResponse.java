/**
 * AT_GetLupeGoodSaleResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AT_GetLupeGoodSaleResponse  implements java.io.Serializable {
    private org.tempuri.AT_GetLupeGoodSaleResponseAT_GetLupeGoodSaleResult AT_GetLupeGoodSaleResult;

    public AT_GetLupeGoodSaleResponse() {
    }

    public AT_GetLupeGoodSaleResponse(
           org.tempuri.AT_GetLupeGoodSaleResponseAT_GetLupeGoodSaleResult AT_GetLupeGoodSaleResult) {
           this.AT_GetLupeGoodSaleResult = AT_GetLupeGoodSaleResult;
    }


    /**
     * Gets the AT_GetLupeGoodSaleResult value for this AT_GetLupeGoodSaleResponse.
     * 
     * @return AT_GetLupeGoodSaleResult
     */
    public org.tempuri.AT_GetLupeGoodSaleResponseAT_GetLupeGoodSaleResult getAT_GetLupeGoodSaleResult() {
        return AT_GetLupeGoodSaleResult;
    }


    /**
     * Sets the AT_GetLupeGoodSaleResult value for this AT_GetLupeGoodSaleResponse.
     * 
     * @param AT_GetLupeGoodSaleResult
     */
    public void setAT_GetLupeGoodSaleResult(org.tempuri.AT_GetLupeGoodSaleResponseAT_GetLupeGoodSaleResult AT_GetLupeGoodSaleResult) {
        this.AT_GetLupeGoodSaleResult = AT_GetLupeGoodSaleResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AT_GetLupeGoodSaleResponse)) return false;
        AT_GetLupeGoodSaleResponse other = (AT_GetLupeGoodSaleResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.AT_GetLupeGoodSaleResult==null && other.getAT_GetLupeGoodSaleResult()==null) || 
             (this.AT_GetLupeGoodSaleResult!=null &&
              this.AT_GetLupeGoodSaleResult.equals(other.getAT_GetLupeGoodSaleResult())));
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
        if (getAT_GetLupeGoodSaleResult() != null) {
            _hashCode += getAT_GetLupeGoodSaleResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AT_GetLupeGoodSaleResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AT_GetLupeGoodSaleResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AT_GetLupeGoodSaleResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "AT_GetLupeGoodSaleResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>AT_GetLupeGoodSaleResponse>AT_GetLupeGoodSaleResult"));
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
