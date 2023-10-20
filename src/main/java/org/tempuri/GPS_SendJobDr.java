/**
 * GPS_SendJobDr.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class GPS_SendJobDr  implements java.io.Serializable {
    private java.lang.String sJhcomp;

    private java.lang.String sJhbrn;

    private java.lang.String sJhlocation;

    private java.lang.String sJhrunno;

    public GPS_SendJobDr() {
    }

    public GPS_SendJobDr(
           java.lang.String sJhcomp,
           java.lang.String sJhbrn,
           java.lang.String sJhlocation,
           java.lang.String sJhrunno) {
           this.sJhcomp = sJhcomp;
           this.sJhbrn = sJhbrn;
           this.sJhlocation = sJhlocation;
           this.sJhrunno = sJhrunno;
    }


    /**
     * Gets the sJhcomp value for this GPS_SendJobDr.
     * 
     * @return sJhcomp
     */
    public java.lang.String getSJhcomp() {
        return sJhcomp;
    }


    /**
     * Sets the sJhcomp value for this GPS_SendJobDr.
     * 
     * @param sJhcomp
     */
    public void setSJhcomp(java.lang.String sJhcomp) {
        this.sJhcomp = sJhcomp;
    }


    /**
     * Gets the sJhbrn value for this GPS_SendJobDr.
     * 
     * @return sJhbrn
     */
    public java.lang.String getSJhbrn() {
        return sJhbrn;
    }


    /**
     * Sets the sJhbrn value for this GPS_SendJobDr.
     * 
     * @param sJhbrn
     */
    public void setSJhbrn(java.lang.String sJhbrn) {
        this.sJhbrn = sJhbrn;
    }


    /**
     * Gets the sJhlocation value for this GPS_SendJobDr.
     * 
     * @return sJhlocation
     */
    public java.lang.String getSJhlocation() {
        return sJhlocation;
    }


    /**
     * Sets the sJhlocation value for this GPS_SendJobDr.
     * 
     * @param sJhlocation
     */
    public void setSJhlocation(java.lang.String sJhlocation) {
        this.sJhlocation = sJhlocation;
    }


    /**
     * Gets the sJhrunno value for this GPS_SendJobDr.
     * 
     * @return sJhrunno
     */
    public java.lang.String getSJhrunno() {
        return sJhrunno;
    }


    /**
     * Sets the sJhrunno value for this GPS_SendJobDr.
     * 
     * @param sJhrunno
     */
    public void setSJhrunno(java.lang.String sJhrunno) {
        this.sJhrunno = sJhrunno;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GPS_SendJobDr)) return false;
        GPS_SendJobDr other = (GPS_SendJobDr) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.sJhcomp==null && other.getSJhcomp()==null) || 
             (this.sJhcomp!=null &&
              this.sJhcomp.equals(other.getSJhcomp()))) &&
            ((this.sJhbrn==null && other.getSJhbrn()==null) || 
             (this.sJhbrn!=null &&
              this.sJhbrn.equals(other.getSJhbrn()))) &&
            ((this.sJhlocation==null && other.getSJhlocation()==null) || 
             (this.sJhlocation!=null &&
              this.sJhlocation.equals(other.getSJhlocation()))) &&
            ((this.sJhrunno==null && other.getSJhrunno()==null) || 
             (this.sJhrunno!=null &&
              this.sJhrunno.equals(other.getSJhrunno())));
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
        if (getSJhcomp() != null) {
            _hashCode += getSJhcomp().hashCode();
        }
        if (getSJhbrn() != null) {
            _hashCode += getSJhbrn().hashCode();
        }
        if (getSJhlocation() != null) {
            _hashCode += getSJhlocation().hashCode();
        }
        if (getSJhrunno() != null) {
            _hashCode += getSJhrunno().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GPS_SendJobDr.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GPS_SendJobDr"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SJhcomp");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "sJhcomp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SJhbrn");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "sJhbrn"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SJhlocation");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "sJhlocation"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SJhrunno");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "sJhrunno"));
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
