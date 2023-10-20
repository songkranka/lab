/**
 * LDAP_ResetPasswordResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class LDAP_ResetPasswordResponse  implements java.io.Serializable {
    private java.lang.String LDAP_ResetPasswordResult;

    public LDAP_ResetPasswordResponse() {
    }

    public LDAP_ResetPasswordResponse(
           java.lang.String LDAP_ResetPasswordResult) {
           this.LDAP_ResetPasswordResult = LDAP_ResetPasswordResult;
    }


    /**
     * Gets the LDAP_ResetPasswordResult value for this LDAP_ResetPasswordResponse.
     * 
     * @return LDAP_ResetPasswordResult
     */
    public java.lang.String getLDAP_ResetPasswordResult() {
        return LDAP_ResetPasswordResult;
    }


    /**
     * Sets the LDAP_ResetPasswordResult value for this LDAP_ResetPasswordResponse.
     * 
     * @param LDAP_ResetPasswordResult
     */
    public void setLDAP_ResetPasswordResult(java.lang.String LDAP_ResetPasswordResult) {
        this.LDAP_ResetPasswordResult = LDAP_ResetPasswordResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof LDAP_ResetPasswordResponse)) return false;
        LDAP_ResetPasswordResponse other = (LDAP_ResetPasswordResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.LDAP_ResetPasswordResult==null && other.getLDAP_ResetPasswordResult()==null) || 
             (this.LDAP_ResetPasswordResult!=null &&
              this.LDAP_ResetPasswordResult.equals(other.getLDAP_ResetPasswordResult())));
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
        if (getLDAP_ResetPasswordResult() != null) {
            _hashCode += getLDAP_ResetPasswordResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(LDAP_ResetPasswordResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">LDAP_ResetPasswordResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("LDAP_ResetPasswordResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "LDAP_ResetPasswordResult"));
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
