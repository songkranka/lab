/**
 * POS_PROMOTION_GET.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class POS_PROMOTION_GET  implements java.io.Serializable {
    private java.lang.String sBRN;

    public POS_PROMOTION_GET() {
    }

    public POS_PROMOTION_GET(
           java.lang.String sBRN) {
           this.sBRN = sBRN;
    }


    /**
     * Gets the sBRN value for this POS_PROMOTION_GET.
     * 
     * @return sBRN
     */
    public java.lang.String getSBRN() {
        return sBRN;
    }


    /**
     * Sets the sBRN value for this POS_PROMOTION_GET.
     * 
     * @param sBRN
     */
    public void setSBRN(java.lang.String sBRN) {
        this.sBRN = sBRN;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof POS_PROMOTION_GET)) return false;
        POS_PROMOTION_GET other = (POS_PROMOTION_GET) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.sBRN==null && other.getSBRN()==null) || 
             (this.sBRN!=null &&
              this.sBRN.equals(other.getSBRN())));
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
        if (getSBRN() != null) {
            _hashCode += getSBRN().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(POS_PROMOTION_GET.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">POS_PROMOTION_GET"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SBRN");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "sBRN"));
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