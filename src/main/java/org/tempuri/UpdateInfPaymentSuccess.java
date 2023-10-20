/**
 * UpdateInfPaymentSuccess.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class UpdateInfPaymentSuccess  implements java.io.Serializable {
    private java.lang.String flag;

    private java.lang.String inBrn;

    private java.lang.String inNo;

    public UpdateInfPaymentSuccess() {
    }

    public UpdateInfPaymentSuccess(
           java.lang.String flag,
           java.lang.String inBrn,
           java.lang.String inNo) {
           this.flag = flag;
           this.inBrn = inBrn;
           this.inNo = inNo;
    }


    /**
     * Gets the flag value for this UpdateInfPaymentSuccess.
     * 
     * @return flag
     */
    public java.lang.String getFlag() {
        return flag;
    }


    /**
     * Sets the flag value for this UpdateInfPaymentSuccess.
     * 
     * @param flag
     */
    public void setFlag(java.lang.String flag) {
        this.flag = flag;
    }


    /**
     * Gets the inBrn value for this UpdateInfPaymentSuccess.
     * 
     * @return inBrn
     */
    public java.lang.String getInBrn() {
        return inBrn;
    }


    /**
     * Sets the inBrn value for this UpdateInfPaymentSuccess.
     * 
     * @param inBrn
     */
    public void setInBrn(java.lang.String inBrn) {
        this.inBrn = inBrn;
    }


    /**
     * Gets the inNo value for this UpdateInfPaymentSuccess.
     * 
     * @return inNo
     */
    public java.lang.String getInNo() {
        return inNo;
    }


    /**
     * Sets the inNo value for this UpdateInfPaymentSuccess.
     * 
     * @param inNo
     */
    public void setInNo(java.lang.String inNo) {
        this.inNo = inNo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof UpdateInfPaymentSuccess)) return false;
        UpdateInfPaymentSuccess other = (UpdateInfPaymentSuccess) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.flag==null && other.getFlag()==null) || 
             (this.flag!=null &&
              this.flag.equals(other.getFlag()))) &&
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
        if (getFlag() != null) {
            _hashCode += getFlag().hashCode();
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
        new org.apache.axis.description.TypeDesc(UpdateInfPaymentSuccess.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">UpdateInfPaymentSuccess"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("flag");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Flag"));
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
