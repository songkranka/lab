/**
 * POS_PROMOTION_SET.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class POS_PROMOTION_SET  implements java.io.Serializable {
    private org.tempuri.POS_PROMOTION_SETODS oDS;

    public POS_PROMOTION_SET() {
    }

    public POS_PROMOTION_SET(
           org.tempuri.POS_PROMOTION_SETODS oDS) {
           this.oDS = oDS;
    }


    /**
     * Gets the oDS value for this POS_PROMOTION_SET.
     * 
     * @return oDS
     */
    public org.tempuri.POS_PROMOTION_SETODS getODS() {
        return oDS;
    }


    /**
     * Sets the oDS value for this POS_PROMOTION_SET.
     * 
     * @param oDS
     */
    public void setODS(org.tempuri.POS_PROMOTION_SETODS oDS) {
        this.oDS = oDS;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof POS_PROMOTION_SET)) return false;
        POS_PROMOTION_SET other = (POS_PROMOTION_SET) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.oDS==null && other.getODS()==null) || 
             (this.oDS!=null &&
              this.oDS.equals(other.getODS())));
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
        if (getODS() != null) {
            _hashCode += getODS().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(POS_PROMOTION_SET.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">POS_PROMOTION_SET"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ODS");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "oDS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>POS_PROMOTION_SET>oDS"));
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
