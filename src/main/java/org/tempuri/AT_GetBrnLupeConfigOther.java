/**
 * AT_GetBrnLupeConfigOther.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AT_GetBrnLupeConfigOther  implements java.io.Serializable {
    private java.lang.String sOLDComp;

    private java.lang.String sDepotBrn;

    private java.lang.String brnCode;

    private java.lang.String sLupecode;

    public AT_GetBrnLupeConfigOther() {
    }

    public AT_GetBrnLupeConfigOther(
           java.lang.String sOLDComp,
           java.lang.String sDepotBrn,
           java.lang.String brnCode,
           java.lang.String sLupecode) {
           this.sOLDComp = sOLDComp;
           this.sDepotBrn = sDepotBrn;
           this.brnCode = brnCode;
           this.sLupecode = sLupecode;
    }


    /**
     * Gets the sOLDComp value for this AT_GetBrnLupeConfigOther.
     * 
     * @return sOLDComp
     */
    public java.lang.String getSOLDComp() {
        return sOLDComp;
    }


    /**
     * Sets the sOLDComp value for this AT_GetBrnLupeConfigOther.
     * 
     * @param sOLDComp
     */
    public void setSOLDComp(java.lang.String sOLDComp) {
        this.sOLDComp = sOLDComp;
    }


    /**
     * Gets the sDepotBrn value for this AT_GetBrnLupeConfigOther.
     * 
     * @return sDepotBrn
     */
    public java.lang.String getSDepotBrn() {
        return sDepotBrn;
    }


    /**
     * Sets the sDepotBrn value for this AT_GetBrnLupeConfigOther.
     * 
     * @param sDepotBrn
     */
    public void setSDepotBrn(java.lang.String sDepotBrn) {
        this.sDepotBrn = sDepotBrn;
    }


    /**
     * Gets the brnCode value for this AT_GetBrnLupeConfigOther.
     * 
     * @return brnCode
     */
    public java.lang.String getBrnCode() {
        return brnCode;
    }


    /**
     * Sets the brnCode value for this AT_GetBrnLupeConfigOther.
     * 
     * @param brnCode
     */
    public void setBrnCode(java.lang.String brnCode) {
        this.brnCode = brnCode;
    }


    /**
     * Gets the sLupecode value for this AT_GetBrnLupeConfigOther.
     * 
     * @return sLupecode
     */
    public java.lang.String getSLupecode() {
        return sLupecode;
    }


    /**
     * Sets the sLupecode value for this AT_GetBrnLupeConfigOther.
     * 
     * @param sLupecode
     */
    public void setSLupecode(java.lang.String sLupecode) {
        this.sLupecode = sLupecode;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AT_GetBrnLupeConfigOther)) return false;
        AT_GetBrnLupeConfigOther other = (AT_GetBrnLupeConfigOther) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.sOLDComp==null && other.getSOLDComp()==null) || 
             (this.sOLDComp!=null &&
              this.sOLDComp.equals(other.getSOLDComp()))) &&
            ((this.sDepotBrn==null && other.getSDepotBrn()==null) || 
             (this.sDepotBrn!=null &&
              this.sDepotBrn.equals(other.getSDepotBrn()))) &&
            ((this.brnCode==null && other.getBrnCode()==null) || 
             (this.brnCode!=null &&
              this.brnCode.equals(other.getBrnCode()))) &&
            ((this.sLupecode==null && other.getSLupecode()==null) || 
             (this.sLupecode!=null &&
              this.sLupecode.equals(other.getSLupecode())));
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
        if (getSOLDComp() != null) {
            _hashCode += getSOLDComp().hashCode();
        }
        if (getSDepotBrn() != null) {
            _hashCode += getSDepotBrn().hashCode();
        }
        if (getBrnCode() != null) {
            _hashCode += getBrnCode().hashCode();
        }
        if (getSLupecode() != null) {
            _hashCode += getSLupecode().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AT_GetBrnLupeConfigOther.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AT_GetBrnLupeConfigOther"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
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
        elemField.setFieldName("brnCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "BrnCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SLupecode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "sLupecode"));
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
