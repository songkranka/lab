/**
 * ArUpdateAging.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class ArUpdateAging  implements java.io.Serializable {
    private org.tempuri.ArUpdateAgingDts dts;

    public ArUpdateAging() {
    }

    public ArUpdateAging(
           org.tempuri.ArUpdateAgingDts dts) {
           this.dts = dts;
    }


    /**
     * Gets the dts value for this ArUpdateAging.
     * 
     * @return dts
     */
    public org.tempuri.ArUpdateAgingDts getDts() {
        return dts;
    }


    /**
     * Sets the dts value for this ArUpdateAging.
     * 
     * @param dts
     */
    public void setDts(org.tempuri.ArUpdateAgingDts dts) {
        this.dts = dts;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ArUpdateAging)) return false;
        ArUpdateAging other = (ArUpdateAging) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dts==null && other.getDts()==null) || 
             (this.dts!=null &&
              this.dts.equals(other.getDts())));
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
        if (getDts() != null) {
            _hashCode += getDts().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ArUpdateAging.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">arUpdateAging"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dts");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "dts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>arUpdateAging>dts"));
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
