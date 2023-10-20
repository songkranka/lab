/**
 * PTG_VersionUpdateCheck.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class PTG_VersionUpdateCheck  implements java.io.Serializable {
    private java.lang.String sSystem;

    private java.lang.String sMAC;

    public PTG_VersionUpdateCheck() {
    }

    public PTG_VersionUpdateCheck(
           java.lang.String sSystem,
           java.lang.String sMAC) {
           this.sSystem = sSystem;
           this.sMAC = sMAC;
    }


    /**
     * Gets the sSystem value for this PTG_VersionUpdateCheck.
     * 
     * @return sSystem
     */
    public java.lang.String getSSystem() {
        return sSystem;
    }


    /**
     * Sets the sSystem value for this PTG_VersionUpdateCheck.
     * 
     * @param sSystem
     */
    public void setSSystem(java.lang.String sSystem) {
        this.sSystem = sSystem;
    }


    /**
     * Gets the sMAC value for this PTG_VersionUpdateCheck.
     * 
     * @return sMAC
     */
    public java.lang.String getSMAC() {
        return sMAC;
    }


    /**
     * Sets the sMAC value for this PTG_VersionUpdateCheck.
     * 
     * @param sMAC
     */
    public void setSMAC(java.lang.String sMAC) {
        this.sMAC = sMAC;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PTG_VersionUpdateCheck)) return false;
        PTG_VersionUpdateCheck other = (PTG_VersionUpdateCheck) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.sSystem==null && other.getSSystem()==null) || 
             (this.sSystem!=null &&
              this.sSystem.equals(other.getSSystem()))) &&
            ((this.sMAC==null && other.getSMAC()==null) || 
             (this.sMAC!=null &&
              this.sMAC.equals(other.getSMAC())));
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
        if (getSSystem() != null) {
            _hashCode += getSSystem().hashCode();
        }
        if (getSMAC() != null) {
            _hashCode += getSMAC().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PTG_VersionUpdateCheck.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">PTG_VersionUpdateCheck"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SSystem");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "sSystem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SMAC");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "sMAC"));
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
