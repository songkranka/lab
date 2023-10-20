/**
 * LDAP_USER_AUTHENResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class LDAP_USER_AUTHENResponse  implements java.io.Serializable {
    private java.lang.String LDAP_USER_AUTHENResult;

    public LDAP_USER_AUTHENResponse() {
    }

    public LDAP_USER_AUTHENResponse(
           java.lang.String LDAP_USER_AUTHENResult) {
           this.LDAP_USER_AUTHENResult = LDAP_USER_AUTHENResult;
    }


    /**
     * Gets the LDAP_USER_AUTHENResult value for this LDAP_USER_AUTHENResponse.
     * 
     * @return LDAP_USER_AUTHENResult
     */
    public java.lang.String getLDAP_USER_AUTHENResult() {
        return LDAP_USER_AUTHENResult;
    }


    /**
     * Sets the LDAP_USER_AUTHENResult value for this LDAP_USER_AUTHENResponse.
     * 
     * @param LDAP_USER_AUTHENResult
     */
    public void setLDAP_USER_AUTHENResult(java.lang.String LDAP_USER_AUTHENResult) {
        this.LDAP_USER_AUTHENResult = LDAP_USER_AUTHENResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof LDAP_USER_AUTHENResponse)) return false;
        LDAP_USER_AUTHENResponse other = (LDAP_USER_AUTHENResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.LDAP_USER_AUTHENResult==null && other.getLDAP_USER_AUTHENResult()==null) || 
             (this.LDAP_USER_AUTHENResult!=null &&
              this.LDAP_USER_AUTHENResult.equals(other.getLDAP_USER_AUTHENResult())));
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
        if (getLDAP_USER_AUTHENResult() != null) {
            _hashCode += getLDAP_USER_AUTHENResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(LDAP_USER_AUTHENResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">LDAP_USER_AUTHENResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("LDAP_USER_AUTHENResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "LDAP_USER_AUTHENResult"));
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
