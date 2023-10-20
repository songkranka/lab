/**
 * MailService1.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class MailService1  implements java.io.Serializable {
    private java.lang.String sTo;

    private java.lang.String sMessage;

    public MailService1() {
    }

    public MailService1(
           java.lang.String sTo,
           java.lang.String sMessage) {
           this.sTo = sTo;
           this.sMessage = sMessage;
    }


    /**
     * Gets the sTo value for this MailService1.
     * 
     * @return sTo
     */
    public java.lang.String getSTo() {
        return sTo;
    }


    /**
     * Sets the sTo value for this MailService1.
     * 
     * @param sTo
     */
    public void setSTo(java.lang.String sTo) {
        this.sTo = sTo;
    }


    /**
     * Gets the sMessage value for this MailService1.
     * 
     * @return sMessage
     */
    public java.lang.String getSMessage() {
        return sMessage;
    }


    /**
     * Sets the sMessage value for this MailService1.
     * 
     * @param sMessage
     */
    public void setSMessage(java.lang.String sMessage) {
        this.sMessage = sMessage;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MailService1)) return false;
        MailService1 other = (MailService1) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.sTo==null && other.getSTo()==null) || 
             (this.sTo!=null &&
              this.sTo.equals(other.getSTo()))) &&
            ((this.sMessage==null && other.getSMessage()==null) || 
             (this.sMessage!=null &&
              this.sMessage.equals(other.getSMessage())));
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
        if (getSTo() != null) {
            _hashCode += getSTo().hashCode();
        }
        if (getSMessage() != null) {
            _hashCode += getSMessage().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MailService1.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">MailService1"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("STo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "sTo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SMessage");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "sMessage"));
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
