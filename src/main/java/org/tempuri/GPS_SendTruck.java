/**
 * GPS_SendTruck.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class GPS_SendTruck  implements java.io.Serializable {
    private java.lang.String sTrcomp;

    private java.lang.String sTrno;

    public GPS_SendTruck() {
    }

    public GPS_SendTruck(
           java.lang.String sTrcomp,
           java.lang.String sTrno) {
           this.sTrcomp = sTrcomp;
           this.sTrno = sTrno;
    }


    /**
     * Gets the sTrcomp value for this GPS_SendTruck.
     * 
     * @return sTrcomp
     */
    public java.lang.String getSTrcomp() {
        return sTrcomp;
    }


    /**
     * Sets the sTrcomp value for this GPS_SendTruck.
     * 
     * @param sTrcomp
     */
    public void setSTrcomp(java.lang.String sTrcomp) {
        this.sTrcomp = sTrcomp;
    }


    /**
     * Gets the sTrno value for this GPS_SendTruck.
     * 
     * @return sTrno
     */
    public java.lang.String getSTrno() {
        return sTrno;
    }


    /**
     * Sets the sTrno value for this GPS_SendTruck.
     * 
     * @param sTrno
     */
    public void setSTrno(java.lang.String sTrno) {
        this.sTrno = sTrno;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GPS_SendTruck)) return false;
        GPS_SendTruck other = (GPS_SendTruck) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.sTrcomp==null && other.getSTrcomp()==null) || 
             (this.sTrcomp!=null &&
              this.sTrcomp.equals(other.getSTrcomp()))) &&
            ((this.sTrno==null && other.getSTrno()==null) || 
             (this.sTrno!=null &&
              this.sTrno.equals(other.getSTrno())));
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
        if (getSTrcomp() != null) {
            _hashCode += getSTrcomp().hashCode();
        }
        if (getSTrno() != null) {
            _hashCode += getSTrno().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GPS_SendTruck.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GPS_SendTruck"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("STrcomp");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "sTrcomp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("STrno");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "sTrno"));
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
