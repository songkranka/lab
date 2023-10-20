/**
 * WO_SetStatus.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class WO_SetStatus  implements java.io.Serializable {
    private java.lang.String sOrderNo;

    private int nStatus;

    private java.lang.String sUser;

    public WO_SetStatus() {
    }

    public WO_SetStatus(
           java.lang.String sOrderNo,
           int nStatus,
           java.lang.String sUser) {
           this.sOrderNo = sOrderNo;
           this.nStatus = nStatus;
           this.sUser = sUser;
    }


    /**
     * Gets the sOrderNo value for this WO_SetStatus.
     * 
     * @return sOrderNo
     */
    public java.lang.String getSOrderNo() {
        return sOrderNo;
    }


    /**
     * Sets the sOrderNo value for this WO_SetStatus.
     * 
     * @param sOrderNo
     */
    public void setSOrderNo(java.lang.String sOrderNo) {
        this.sOrderNo = sOrderNo;
    }


    /**
     * Gets the nStatus value for this WO_SetStatus.
     * 
     * @return nStatus
     */
    public int getNStatus() {
        return nStatus;
    }


    /**
     * Sets the nStatus value for this WO_SetStatus.
     * 
     * @param nStatus
     */
    public void setNStatus(int nStatus) {
        this.nStatus = nStatus;
    }


    /**
     * Gets the sUser value for this WO_SetStatus.
     * 
     * @return sUser
     */
    public java.lang.String getSUser() {
        return sUser;
    }


    /**
     * Sets the sUser value for this WO_SetStatus.
     * 
     * @param sUser
     */
    public void setSUser(java.lang.String sUser) {
        this.sUser = sUser;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WO_SetStatus)) return false;
        WO_SetStatus other = (WO_SetStatus) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.sOrderNo==null && other.getSOrderNo()==null) || 
             (this.sOrderNo!=null &&
              this.sOrderNo.equals(other.getSOrderNo()))) &&
            this.nStatus == other.getNStatus() &&
            ((this.sUser==null && other.getSUser()==null) || 
             (this.sUser!=null &&
              this.sUser.equals(other.getSUser())));
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
        if (getSOrderNo() != null) {
            _hashCode += getSOrderNo().hashCode();
        }
        _hashCode += getNStatus();
        if (getSUser() != null) {
            _hashCode += getSUser().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WO_SetStatus.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">WO_SetStatus"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SOrderNo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "sOrderNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("NStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "nStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SUser");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "sUser"));
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
