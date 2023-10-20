/**
 * GPS_SendSite.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class GPS_SendSite  implements java.io.Serializable {
    private java.lang.String sStcomp;

    private java.lang.String sStno;

    public GPS_SendSite() {
    }

    public GPS_SendSite(
           java.lang.String sStcomp,
           java.lang.String sStno) {
           this.sStcomp = sStcomp;
           this.sStno = sStno;
    }


    /**
     * Gets the sStcomp value for this GPS_SendSite.
     * 
     * @return sStcomp
     */
    public java.lang.String getSStcomp() {
        return sStcomp;
    }


    /**
     * Sets the sStcomp value for this GPS_SendSite.
     * 
     * @param sStcomp
     */
    public void setSStcomp(java.lang.String sStcomp) {
        this.sStcomp = sStcomp;
    }


    /**
     * Gets the sStno value for this GPS_SendSite.
     * 
     * @return sStno
     */
    public java.lang.String getSStno() {
        return sStno;
    }


    /**
     * Sets the sStno value for this GPS_SendSite.
     * 
     * @param sStno
     */
    public void setSStno(java.lang.String sStno) {
        this.sStno = sStno;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GPS_SendSite)) return false;
        GPS_SendSite other = (GPS_SendSite) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.sStcomp==null && other.getSStcomp()==null) || 
             (this.sStcomp!=null &&
              this.sStcomp.equals(other.getSStcomp()))) &&
            ((this.sStno==null && other.getSStno()==null) || 
             (this.sStno!=null &&
              this.sStno.equals(other.getSStno())));
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
        if (getSStcomp() != null) {
            _hashCode += getSStcomp().hashCode();
        }
        if (getSStno() != null) {
            _hashCode += getSStno().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GPS_SendSite.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GPS_SendSite"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SStcomp");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "sStcomp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SStno");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "sStno"));
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
