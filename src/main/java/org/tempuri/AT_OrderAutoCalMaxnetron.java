/**
 * AT_OrderAutoCalMaxnetron.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AT_OrderAutoCalMaxnetron  implements java.io.Serializable {
    private int iTYPE;

    private java.lang.String sOLDComp;

    private java.lang.String sDepotBrn;

    private java.lang.String sType;

    public AT_OrderAutoCalMaxnetron() {
    }

    public AT_OrderAutoCalMaxnetron(
           int iTYPE,
           java.lang.String sOLDComp,
           java.lang.String sDepotBrn,
           java.lang.String sType) {
           this.iTYPE = iTYPE;
           this.sOLDComp = sOLDComp;
           this.sDepotBrn = sDepotBrn;
           this.sType = sType;
    }


    /**
     * Gets the iTYPE value for this AT_OrderAutoCalMaxnetron.
     * 
     * @return iTYPE
     */
    public int getITYPE() {
        return iTYPE;
    }


    /**
     * Sets the iTYPE value for this AT_OrderAutoCalMaxnetron.
     * 
     * @param iTYPE
     */
    public void setITYPE(int iTYPE) {
        this.iTYPE = iTYPE;
    }


    /**
     * Gets the sOLDComp value for this AT_OrderAutoCalMaxnetron.
     * 
     * @return sOLDComp
     */
    public java.lang.String getSOLDComp() {
        return sOLDComp;
    }


    /**
     * Sets the sOLDComp value for this AT_OrderAutoCalMaxnetron.
     * 
     * @param sOLDComp
     */
    public void setSOLDComp(java.lang.String sOLDComp) {
        this.sOLDComp = sOLDComp;
    }


    /**
     * Gets the sDepotBrn value for this AT_OrderAutoCalMaxnetron.
     * 
     * @return sDepotBrn
     */
    public java.lang.String getSDepotBrn() {
        return sDepotBrn;
    }


    /**
     * Sets the sDepotBrn value for this AT_OrderAutoCalMaxnetron.
     * 
     * @param sDepotBrn
     */
    public void setSDepotBrn(java.lang.String sDepotBrn) {
        this.sDepotBrn = sDepotBrn;
    }


    /**
     * Gets the sType value for this AT_OrderAutoCalMaxnetron.
     * 
     * @return sType
     */
    public java.lang.String getSType() {
        return sType;
    }


    /**
     * Sets the sType value for this AT_OrderAutoCalMaxnetron.
     * 
     * @param sType
     */
    public void setSType(java.lang.String sType) {
        this.sType = sType;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AT_OrderAutoCalMaxnetron)) return false;
        AT_OrderAutoCalMaxnetron other = (AT_OrderAutoCalMaxnetron) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.iTYPE == other.getITYPE() &&
            ((this.sOLDComp==null && other.getSOLDComp()==null) || 
             (this.sOLDComp!=null &&
              this.sOLDComp.equals(other.getSOLDComp()))) &&
            ((this.sDepotBrn==null && other.getSDepotBrn()==null) || 
             (this.sDepotBrn!=null &&
              this.sDepotBrn.equals(other.getSDepotBrn()))) &&
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
        _hashCode += getITYPE();
        if (getSOLDComp() != null) {
            _hashCode += getSOLDComp().hashCode();
        }
        if (getSDepotBrn() != null) {
            _hashCode += getSDepotBrn().hashCode();
        }
        if (getSType() != null) {
            _hashCode += getSType().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AT_OrderAutoCalMaxnetron.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AT_OrderAutoCalMaxnetron"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ITYPE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "iTYPE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SOLDComp");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "sOLDComp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SDepotBrn");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "sDepotBrn"));
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
