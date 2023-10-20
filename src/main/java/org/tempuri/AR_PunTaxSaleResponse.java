/**
 * AR_PunTaxSaleResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AR_PunTaxSaleResponse  implements java.io.Serializable {
    private java.lang.String AR_PunTaxSaleResult;

    public AR_PunTaxSaleResponse() {
    }

    public AR_PunTaxSaleResponse(
           java.lang.String AR_PunTaxSaleResult) {
           this.AR_PunTaxSaleResult = AR_PunTaxSaleResult;
    }


    /**
     * Gets the AR_PunTaxSaleResult value for this AR_PunTaxSaleResponse.
     * 
     * @return AR_PunTaxSaleResult
     */
    public java.lang.String getAR_PunTaxSaleResult() {
        return AR_PunTaxSaleResult;
    }


    /**
     * Sets the AR_PunTaxSaleResult value for this AR_PunTaxSaleResponse.
     * 
     * @param AR_PunTaxSaleResult
     */
    public void setAR_PunTaxSaleResult(java.lang.String AR_PunTaxSaleResult) {
        this.AR_PunTaxSaleResult = AR_PunTaxSaleResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AR_PunTaxSaleResponse)) return false;
        AR_PunTaxSaleResponse other = (AR_PunTaxSaleResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.AR_PunTaxSaleResult==null && other.getAR_PunTaxSaleResult()==null) || 
             (this.AR_PunTaxSaleResult!=null &&
              this.AR_PunTaxSaleResult.equals(other.getAR_PunTaxSaleResult())));
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
        if (getAR_PunTaxSaleResult() != null) {
            _hashCode += getAR_PunTaxSaleResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AR_PunTaxSaleResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AR_PunTaxSaleResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AR_PunTaxSaleResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "AR_PunTaxSaleResult"));
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
