/**
 * UpdateInfPaymentFailed.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class UpdateInfPaymentFailed  implements java.io.Serializable {
    private java.lang.String remark;

    private java.lang.String inBrn;

    private java.lang.String inNo;

    public UpdateInfPaymentFailed() {
    }

    public UpdateInfPaymentFailed(
           java.lang.String remark,
           java.lang.String inBrn,
           java.lang.String inNo) {
           this.remark = remark;
           this.inBrn = inBrn;
           this.inNo = inNo;
    }


    /**
     * Gets the remark value for this UpdateInfPaymentFailed.
     * 
     * @return remark
     */
    public java.lang.String getRemark() {
        return remark;
    }


    /**
     * Sets the remark value for this UpdateInfPaymentFailed.
     * 
     * @param remark
     */
    public void setRemark(java.lang.String remark) {
        this.remark = remark;
    }


    /**
     * Gets the inBrn value for this UpdateInfPaymentFailed.
     * 
     * @return inBrn
     */
    public java.lang.String getInBrn() {
        return inBrn;
    }


    /**
     * Sets the inBrn value for this UpdateInfPaymentFailed.
     * 
     * @param inBrn
     */
    public void setInBrn(java.lang.String inBrn) {
        this.inBrn = inBrn;
    }


    /**
     * Gets the inNo value for this UpdateInfPaymentFailed.
     * 
     * @return inNo
     */
    public java.lang.String getInNo() {
        return inNo;
    }


    /**
     * Sets the inNo value for this UpdateInfPaymentFailed.
     * 
     * @param inNo
     */
    public void setInNo(java.lang.String inNo) {
        this.inNo = inNo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof UpdateInfPaymentFailed)) return false;
        UpdateInfPaymentFailed other = (UpdateInfPaymentFailed) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.remark==null && other.getRemark()==null) || 
             (this.remark!=null &&
              this.remark.equals(other.getRemark()))) &&
            ((this.inBrn==null && other.getInBrn()==null) || 
             (this.inBrn!=null &&
              this.inBrn.equals(other.getInBrn()))) &&
            ((this.inNo==null && other.getInNo()==null) || 
             (this.inNo!=null &&
              this.inNo.equals(other.getInNo())));
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
        if (getRemark() != null) {
            _hashCode += getRemark().hashCode();
        }
        if (getInBrn() != null) {
            _hashCode += getInBrn().hashCode();
        }
        if (getInNo() != null) {
            _hashCode += getInNo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(UpdateInfPaymentFailed.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">UpdateInfPaymentFailed"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("remark");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Remark"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("inBrn");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "InBrn"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("inNo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "InNo"));
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
