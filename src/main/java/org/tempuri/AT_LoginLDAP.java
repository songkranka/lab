/**
 * AT_LoginLDAP.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AT_LoginLDAP  implements java.io.Serializable {
    private java.lang.String sUsername;

    private java.lang.String sPassword;

    public AT_LoginLDAP() {
    }

    public AT_LoginLDAP(
           java.lang.String sUsername,
           java.lang.String sPassword) {
           this.sUsername = sUsername;
           this.sPassword = sPassword;
    }


    /**
     * Gets the sUsername value for this AT_LoginLDAP.
     * 
     * @return sUsername
     */
    public java.lang.String getSUsername() {
        return sUsername;
    }


    /**
     * Sets the sUsername value for this AT_LoginLDAP.
     * 
     * @param sUsername
     */
    public void setSUsername(java.lang.String sUsername) {
        this.sUsername = sUsername;
    }


    /**
     * Gets the sPassword value for this AT_LoginLDAP.
     * 
     * @return sPassword
     */
    public java.lang.String getSPassword() {
        return sPassword;
    }


    /**
     * Sets the sPassword value for this AT_LoginLDAP.
     * 
     * @param sPassword
     */
    public void setSPassword(java.lang.String sPassword) {
        this.sPassword = sPassword;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AT_LoginLDAP)) return false;
        AT_LoginLDAP other = (AT_LoginLDAP) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.sUsername==null && other.getSUsername()==null) || 
             (this.sUsername!=null &&
              this.sUsername.equals(other.getSUsername()))) &&
            ((this.sPassword==null && other.getSPassword()==null) || 
             (this.sPassword!=null &&
              this.sPassword.equals(other.getSPassword())));
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
        if (getSUsername() != null) {
            _hashCode += getSUsername().hashCode();
        }
        if (getSPassword() != null) {
            _hashCode += getSPassword().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AT_LoginLDAP.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AT_LoginLDAP"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SUsername");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "sUsername"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SPassword");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "sPassword"));
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
