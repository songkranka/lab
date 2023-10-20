/**
 * GPS_SendDriver.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class GPS_SendDriver  implements java.io.Serializable {
    private java.lang.String sDrcomp;

    private java.lang.String sDrno;

    public GPS_SendDriver() {
    }

    public GPS_SendDriver(
           java.lang.String sDrcomp,
           java.lang.String sDrno) {
           this.sDrcomp = sDrcomp;
           this.sDrno = sDrno;
    }


    /**
     * Gets the sDrcomp value for this GPS_SendDriver.
     * 
     * @return sDrcomp
     */
    public java.lang.String getSDrcomp() {
        return sDrcomp;
    }


    /**
     * Sets the sDrcomp value for this GPS_SendDriver.
     * 
     * @param sDrcomp
     */
    public void setSDrcomp(java.lang.String sDrcomp) {
        this.sDrcomp = sDrcomp;
    }


    /**
     * Gets the sDrno value for this GPS_SendDriver.
     * 
     * @return sDrno
     */
    public java.lang.String getSDrno() {
        return sDrno;
    }


    /**
     * Sets the sDrno value for this GPS_SendDriver.
     * 
     * @param sDrno
     */
    public void setSDrno(java.lang.String sDrno) {
        this.sDrno = sDrno;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GPS_SendDriver)) return false;
        GPS_SendDriver other = (GPS_SendDriver) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.sDrcomp==null && other.getSDrcomp()==null) || 
             (this.sDrcomp!=null &&
              this.sDrcomp.equals(other.getSDrcomp()))) &&
            ((this.sDrno==null && other.getSDrno()==null) || 
             (this.sDrno!=null &&
              this.sDrno.equals(other.getSDrno())));
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
        if (getSDrcomp() != null) {
            _hashCode += getSDrcomp().hashCode();
        }
        if (getSDrno() != null) {
            _hashCode += getSDrno().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GPS_SendDriver.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GPS_SendDriver"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SDrcomp");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "sDrcomp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SDrno");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "sDrno"));
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
