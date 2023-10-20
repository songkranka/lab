/**
 * Supply_CheckApMngPR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class Supply_CheckApMngPR  implements java.io.Serializable {
    private java.lang.String sSupplier;

    private java.lang.String sComp;

    private java.lang.String sLocation;

    private java.lang.String sDate;

    public Supply_CheckApMngPR() {
    }

    public Supply_CheckApMngPR(
           java.lang.String sSupplier,
           java.lang.String sComp,
           java.lang.String sLocation,
           java.lang.String sDate) {
           this.sSupplier = sSupplier;
           this.sComp = sComp;
           this.sLocation = sLocation;
           this.sDate = sDate;
    }


    /**
     * Gets the sSupplier value for this Supply_CheckApMngPR.
     * 
     * @return sSupplier
     */
    public java.lang.String getSSupplier() {
        return sSupplier;
    }


    /**
     * Sets the sSupplier value for this Supply_CheckApMngPR.
     * 
     * @param sSupplier
     */
    public void setSSupplier(java.lang.String sSupplier) {
        this.sSupplier = sSupplier;
    }


    /**
     * Gets the sComp value for this Supply_CheckApMngPR.
     * 
     * @return sComp
     */
    public java.lang.String getSComp() {
        return sComp;
    }


    /**
     * Sets the sComp value for this Supply_CheckApMngPR.
     * 
     * @param sComp
     */
    public void setSComp(java.lang.String sComp) {
        this.sComp = sComp;
    }


    /**
     * Gets the sLocation value for this Supply_CheckApMngPR.
     * 
     * @return sLocation
     */
    public java.lang.String getSLocation() {
        return sLocation;
    }


    /**
     * Sets the sLocation value for this Supply_CheckApMngPR.
     * 
     * @param sLocation
     */
    public void setSLocation(java.lang.String sLocation) {
        this.sLocation = sLocation;
    }


    /**
     * Gets the sDate value for this Supply_CheckApMngPR.
     * 
     * @return sDate
     */
    public java.lang.String getSDate() {
        return sDate;
    }


    /**
     * Sets the sDate value for this Supply_CheckApMngPR.
     * 
     * @param sDate
     */
    public void setSDate(java.lang.String sDate) {
        this.sDate = sDate;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Supply_CheckApMngPR)) return false;
        Supply_CheckApMngPR other = (Supply_CheckApMngPR) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.sSupplier==null && other.getSSupplier()==null) || 
             (this.sSupplier!=null &&
              this.sSupplier.equals(other.getSSupplier()))) &&
            ((this.sComp==null && other.getSComp()==null) || 
             (this.sComp!=null &&
              this.sComp.equals(other.getSComp()))) &&
            ((this.sLocation==null && other.getSLocation()==null) || 
             (this.sLocation!=null &&
              this.sLocation.equals(other.getSLocation()))) &&
            ((this.sDate==null && other.getSDate()==null) || 
             (this.sDate!=null &&
              this.sDate.equals(other.getSDate())));
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
        if (getSSupplier() != null) {
            _hashCode += getSSupplier().hashCode();
        }
        if (getSComp() != null) {
            _hashCode += getSComp().hashCode();
        }
        if (getSLocation() != null) {
            _hashCode += getSLocation().hashCode();
        }
        if (getSDate() != null) {
            _hashCode += getSDate().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Supply_CheckApMngPR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">Supply_CheckApMngPR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SSupplier");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "sSupplier"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SComp");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "sComp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SLocation");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "sLocation"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "sDate"));
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
