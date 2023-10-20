/**
 * LDAP_FIND_USER_BY_DISPLAYNAMEResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class LDAP_FIND_USER_BY_DISPLAYNAMEResponse  implements java.io.Serializable {
    private java.lang.String LDAP_FIND_USER_BY_DISPLAYNAMEResult;

    public LDAP_FIND_USER_BY_DISPLAYNAMEResponse() {
    }

    public LDAP_FIND_USER_BY_DISPLAYNAMEResponse(
           java.lang.String LDAP_FIND_USER_BY_DISPLAYNAMEResult) {
           this.LDAP_FIND_USER_BY_DISPLAYNAMEResult = LDAP_FIND_USER_BY_DISPLAYNAMEResult;
    }


    /**
     * Gets the LDAP_FIND_USER_BY_DISPLAYNAMEResult value for this LDAP_FIND_USER_BY_DISPLAYNAMEResponse.
     * 
     * @return LDAP_FIND_USER_BY_DISPLAYNAMEResult
     */
    public java.lang.String getLDAP_FIND_USER_BY_DISPLAYNAMEResult() {
        return LDAP_FIND_USER_BY_DISPLAYNAMEResult;
    }


    /**
     * Sets the LDAP_FIND_USER_BY_DISPLAYNAMEResult value for this LDAP_FIND_USER_BY_DISPLAYNAMEResponse.
     * 
     * @param LDAP_FIND_USER_BY_DISPLAYNAMEResult
     */
    public void setLDAP_FIND_USER_BY_DISPLAYNAMEResult(java.lang.String LDAP_FIND_USER_BY_DISPLAYNAMEResult) {
        this.LDAP_FIND_USER_BY_DISPLAYNAMEResult = LDAP_FIND_USER_BY_DISPLAYNAMEResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof LDAP_FIND_USER_BY_DISPLAYNAMEResponse)) return false;
        LDAP_FIND_USER_BY_DISPLAYNAMEResponse other = (LDAP_FIND_USER_BY_DISPLAYNAMEResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.LDAP_FIND_USER_BY_DISPLAYNAMEResult==null && other.getLDAP_FIND_USER_BY_DISPLAYNAMEResult()==null) || 
             (this.LDAP_FIND_USER_BY_DISPLAYNAMEResult!=null &&
              this.LDAP_FIND_USER_BY_DISPLAYNAMEResult.equals(other.getLDAP_FIND_USER_BY_DISPLAYNAMEResult())));
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
        if (getLDAP_FIND_USER_BY_DISPLAYNAMEResult() != null) {
            _hashCode += getLDAP_FIND_USER_BY_DISPLAYNAMEResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(LDAP_FIND_USER_BY_DISPLAYNAMEResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">LDAP_FIND_USER_BY_DISPLAYNAMEResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("LDAP_FIND_USER_BY_DISPLAYNAMEResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "LDAP_FIND_USER_BY_DISPLAYNAMEResult"));
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
