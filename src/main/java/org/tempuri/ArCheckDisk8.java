/**
 * ArCheckDisk8.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class ArCheckDisk8  implements java.io.Serializable {
    private java.lang.String sComp;

    private java.lang.String sBrn;

    private java.lang.String sCstno;

    private java.lang.String sType;

    public ArCheckDisk8() {
    }

    public ArCheckDisk8(
           java.lang.String sComp,
           java.lang.String sBrn,
           java.lang.String sCstno,
           java.lang.String sType) {
           this.sComp = sComp;
           this.sBrn = sBrn;
           this.sCstno = sCstno;
           this.sType = sType;
    }


    /**
     * Gets the sComp value for this ArCheckDisk8.
     * 
     * @return sComp
     */
    public java.lang.String getSComp() {
        return sComp;
    }


    /**
     * Sets the sComp value for this ArCheckDisk8.
     * 
     * @param sComp
     */
    public void setSComp(java.lang.String sComp) {
        this.sComp = sComp;
    }


    /**
     * Gets the sBrn value for this ArCheckDisk8.
     * 
     * @return sBrn
     */
    public java.lang.String getSBrn() {
        return sBrn;
    }


    /**
     * Sets the sBrn value for this ArCheckDisk8.
     * 
     * @param sBrn
     */
    public void setSBrn(java.lang.String sBrn) {
        this.sBrn = sBrn;
    }


    /**
     * Gets the sCstno value for this ArCheckDisk8.
     * 
     * @return sCstno
     */
    public java.lang.String getSCstno() {
        return sCstno;
    }


    /**
     * Sets the sCstno value for this ArCheckDisk8.
     * 
     * @param sCstno
     */
    public void setSCstno(java.lang.String sCstno) {
        this.sCstno = sCstno;
    }


    /**
     * Gets the sType value for this ArCheckDisk8.
     * 
     * @return sType
     */
    public java.lang.String getSType() {
        return sType;
    }


    /**
     * Sets the sType value for this ArCheckDisk8.
     * 
     * @param sType
     */
    public void setSType(java.lang.String sType) {
        this.sType = sType;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ArCheckDisk8)) return false;
        ArCheckDisk8 other = (ArCheckDisk8) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.sComp==null && other.getSComp()==null) || 
             (this.sComp!=null &&
              this.sComp.equals(other.getSComp()))) &&
            ((this.sBrn==null && other.getSBrn()==null) || 
             (this.sBrn!=null &&
              this.sBrn.equals(other.getSBrn()))) &&
            ((this.sCstno==null && other.getSCstno()==null) || 
             (this.sCstno!=null &&
              this.sCstno.equals(other.getSCstno()))) &&
            ((this.sType==null && other.getSType()==null) || 
             (this.sType!=null &&
              this.sType.equals(other.getSType())));
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
        if (getSComp() != null) {
            _hashCode += getSComp().hashCode();
        }
        if (getSBrn() != null) {
            _hashCode += getSBrn().hashCode();
        }
        if (getSCstno() != null) {
            _hashCode += getSCstno().hashCode();
        }
        if (getSType() != null) {
            _hashCode += getSType().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ArCheckDisk8.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">arCheckDisk8"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SComp");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "sComp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SBrn");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "sBrn"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SCstno");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "sCstno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "sType"));
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
