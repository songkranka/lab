/**
 * Supply_GetSupplier.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class Supply_GetSupplier  implements java.io.Serializable {
    private java.lang.String sSpcode;

    private java.lang.String sSpname;

    public Supply_GetSupplier() {
    }

    public Supply_GetSupplier(
           java.lang.String sSpcode,
           java.lang.String sSpname) {
           this.sSpcode = sSpcode;
           this.sSpname = sSpname;
    }


    /**
     * Gets the sSpcode value for this Supply_GetSupplier.
     * 
     * @return sSpcode
     */
    public java.lang.String getSSpcode() {
        return sSpcode;
    }


    /**
     * Sets the sSpcode value for this Supply_GetSupplier.
     * 
     * @param sSpcode
     */
    public void setSSpcode(java.lang.String sSpcode) {
        this.sSpcode = sSpcode;
    }


    /**
     * Gets the sSpname value for this Supply_GetSupplier.
     * 
     * @return sSpname
     */
    public java.lang.String getSSpname() {
        return sSpname;
    }


    /**
     * Sets the sSpname value for this Supply_GetSupplier.
     * 
     * @param sSpname
     */
    public void setSSpname(java.lang.String sSpname) {
        this.sSpname = sSpname;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Supply_GetSupplier)) return false;
        Supply_GetSupplier other = (Supply_GetSupplier) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.sSpcode==null && other.getSSpcode()==null) || 
             (this.sSpcode!=null &&
              this.sSpcode.equals(other.getSSpcode()))) &&
            ((this.sSpname==null && other.getSSpname()==null) || 
             (this.sSpname!=null &&
              this.sSpname.equals(other.getSSpname())));
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
        if (getSSpcode() != null) {
            _hashCode += getSSpcode().hashCode();
        }
        if (getSSpname() != null) {
            _hashCode += getSSpname().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Supply_GetSupplier.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">Supply_GetSupplier"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SSpcode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "sSpcode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SSpname");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "sSpname"));
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
