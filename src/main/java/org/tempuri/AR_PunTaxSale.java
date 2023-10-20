/**
 * AR_PunTaxSale.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AR_PunTaxSale  implements java.io.Serializable {
    private java.lang.String jsonTextHD;

    private java.lang.String jsonTextDtl;

    public AR_PunTaxSale() {
    }

    public AR_PunTaxSale(
           java.lang.String jsonTextHD,
           java.lang.String jsonTextDtl) {
           this.jsonTextHD = jsonTextHD;
           this.jsonTextDtl = jsonTextDtl;
    }


    /**
     * Gets the jsonTextHD value for this AR_PunTaxSale.
     * 
     * @return jsonTextHD
     */
    public java.lang.String getJsonTextHD() {
        return jsonTextHD;
    }


    /**
     * Sets the jsonTextHD value for this AR_PunTaxSale.
     * 
     * @param jsonTextHD
     */
    public void setJsonTextHD(java.lang.String jsonTextHD) {
        this.jsonTextHD = jsonTextHD;
    }


    /**
     * Gets the jsonTextDtl value for this AR_PunTaxSale.
     * 
     * @return jsonTextDtl
     */
    public java.lang.String getJsonTextDtl() {
        return jsonTextDtl;
    }


    /**
     * Sets the jsonTextDtl value for this AR_PunTaxSale.
     * 
     * @param jsonTextDtl
     */
    public void setJsonTextDtl(java.lang.String jsonTextDtl) {
        this.jsonTextDtl = jsonTextDtl;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AR_PunTaxSale)) return false;
        AR_PunTaxSale other = (AR_PunTaxSale) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.jsonTextHD==null && other.getJsonTextHD()==null) || 
             (this.jsonTextHD!=null &&
              this.jsonTextHD.equals(other.getJsonTextHD()))) &&
            ((this.jsonTextDtl==null && other.getJsonTextDtl()==null) || 
             (this.jsonTextDtl!=null &&
              this.jsonTextDtl.equals(other.getJsonTextDtl())));
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
        if (getJsonTextHD() != null) {
            _hashCode += getJsonTextHD().hashCode();
        }
        if (getJsonTextDtl() != null) {
            _hashCode += getJsonTextDtl().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AR_PunTaxSale.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AR_PunTaxSale"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("jsonTextHD");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "jsonTextHD"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("jsonTextDtl");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "jsonTextDtl"));
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
