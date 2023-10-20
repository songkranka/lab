/**
 * LDAP_VALIDATE_USERResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class LDAP_VALIDATE_USERResponse  implements java.io.Serializable {
    private java.lang.String LDAP_VALIDATE_USERResult;

    public LDAP_VALIDATE_USERResponse() {
    }

    public LDAP_VALIDATE_USERResponse(
           java.lang.String LDAP_VALIDATE_USERResult) {
           this.LDAP_VALIDATE_USERResult = LDAP_VALIDATE_USERResult;
    }


    /**
     * Gets the LDAP_VALIDATE_USERResult value for this LDAP_VALIDATE_USERResponse.
     * 
     * @return LDAP_VALIDATE_USERResult
     */
    public java.lang.String getLDAP_VALIDATE_USERResult() {
        return LDAP_VALIDATE_USERResult;
    }


    /**
     * Sets the LDAP_VALIDATE_USERResult value for this LDAP_VALIDATE_USERResponse.
     * 
     * @param LDAP_VALIDATE_USERResult
     */
    public void setLDAP_VALIDATE_USERResult(java.lang.String LDAP_VALIDATE_USERResult) {
        this.LDAP_VALIDATE_USERResult = LDAP_VALIDATE_USERResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof LDAP_VALIDATE_USERResponse)) return false;
        LDAP_VALIDATE_USERResponse other = (LDAP_VALIDATE_USERResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.LDAP_VALIDATE_USERResult==null && other.getLDAP_VALIDATE_USERResult()==null) || 
             (this.LDAP_VALIDATE_USERResult!=null &&
              this.LDAP_VALIDATE_USERResult.equals(other.getLDAP_VALIDATE_USERResult())));
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
        if (getLDAP_VALIDATE_USERResult() != null) {
            _hashCode += getLDAP_VALIDATE_USERResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(LDAP_VALIDATE_USERResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">LDAP_VALIDATE_USERResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("LDAP_VALIDATE_USERResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "LDAP_VALIDATE_USERResult"));
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
