/**
 * AT_EditDayByBranch.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AT_EditDayByBranch  implements java.io.Serializable {
    private org.tempuri.AT_EditDayByBranchDt dt;

    private java.lang.String sOLDComp;

    private java.lang.String sDepotBrn;

    private java.lang.String sBranch;

    public AT_EditDayByBranch() {
    }

    public AT_EditDayByBranch(
           org.tempuri.AT_EditDayByBranchDt dt,
           java.lang.String sOLDComp,
           java.lang.String sDepotBrn,
           java.lang.String sBranch) {
           this.dt = dt;
           this.sOLDComp = sOLDComp;
           this.sDepotBrn = sDepotBrn;
           this.sBranch = sBranch;
    }


    /**
     * Gets the dt value for this AT_EditDayByBranch.
     * 
     * @return dt
     */
    public org.tempuri.AT_EditDayByBranchDt getDt() {
        return dt;
    }


    /**
     * Sets the dt value for this AT_EditDayByBranch.
     * 
     * @param dt
     */
    public void setDt(org.tempuri.AT_EditDayByBranchDt dt) {
        this.dt = dt;
    }


    /**
     * Gets the sOLDComp value for this AT_EditDayByBranch.
     * 
     * @return sOLDComp
     */
    public java.lang.String getSOLDComp() {
        return sOLDComp;
    }


    /**
     * Sets the sOLDComp value for this AT_EditDayByBranch.
     * 
     * @param sOLDComp
     */
    public void setSOLDComp(java.lang.String sOLDComp) {
        this.sOLDComp = sOLDComp;
    }


    /**
     * Gets the sDepotBrn value for this AT_EditDayByBranch.
     * 
     * @return sDepotBrn
     */
    public java.lang.String getSDepotBrn() {
        return sDepotBrn;
    }


    /**
     * Sets the sDepotBrn value for this AT_EditDayByBranch.
     * 
     * @param sDepotBrn
     */
    public void setSDepotBrn(java.lang.String sDepotBrn) {
        this.sDepotBrn = sDepotBrn;
    }


    /**
     * Gets the sBranch value for this AT_EditDayByBranch.
     * 
     * @return sBranch
     */
    public java.lang.String getSBranch() {
        return sBranch;
    }


    /**
     * Sets the sBranch value for this AT_EditDayByBranch.
     * 
     * @param sBranch
     */
    public void setSBranch(java.lang.String sBranch) {
        this.sBranch = sBranch;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AT_EditDayByBranch)) return false;
        AT_EditDayByBranch other = (AT_EditDayByBranch) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dt==null && other.getDt()==null) || 
             (this.dt!=null &&
              this.dt.equals(other.getDt()))) &&
            ((this.sOLDComp==null && other.getSOLDComp()==null) || 
             (this.sOLDComp!=null &&
              this.sOLDComp.equals(other.getSOLDComp()))) &&
            ((this.sDepotBrn==null && other.getSDepotBrn()==null) || 
             (this.sDepotBrn!=null &&
              this.sDepotBrn.equals(other.getSDepotBrn()))) &&
            ((this.sBranch==null && other.getSBranch()==null) || 
             (this.sBranch!=null &&
              this.sBranch.equals(other.getSBranch())));
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
        if (getDt() != null) {
            _hashCode += getDt().hashCode();
        }
        if (getSOLDComp() != null) {
            _hashCode += getSOLDComp().hashCode();
        }
        if (getSDepotBrn() != null) {
            _hashCode += getSDepotBrn().hashCode();
        }
        if (getSBranch() != null) {
            _hashCode += getSBranch().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AT_EditDayByBranch.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AT_EditDayByBranch"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dt");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "dt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>AT_EditDayByBranch>dt"));
        elemField.setMinOccurs(0);
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
        elemField.setFieldName("SBranch");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "sBranch"));
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