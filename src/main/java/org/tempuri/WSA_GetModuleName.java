/**
 * WSA_GetModuleName.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class WSA_GetModuleName  implements java.io.Serializable {
    private java.lang.String sEmployeeData;

    private java.lang.String sSystemName;

    private java.lang.String sModuleName;

    public WSA_GetModuleName() {
    }

    public WSA_GetModuleName(
           java.lang.String sEmployeeData,
           java.lang.String sSystemName,
           java.lang.String sModuleName) {
           this.sEmployeeData = sEmployeeData;
           this.sSystemName = sSystemName;
           this.sModuleName = sModuleName;
    }


    /**
     * Gets the sEmployeeData value for this WSA_GetModuleName.
     * 
     * @return sEmployeeData
     */
    public java.lang.String getSEmployeeData() {
        return sEmployeeData;
    }


    /**
     * Sets the sEmployeeData value for this WSA_GetModuleName.
     * 
     * @param sEmployeeData
     */
    public void setSEmployeeData(java.lang.String sEmployeeData) {
        this.sEmployeeData = sEmployeeData;
    }


    /**
     * Gets the sSystemName value for this WSA_GetModuleName.
     * 
     * @return sSystemName
     */
    public java.lang.String getSSystemName() {
        return sSystemName;
    }


    /**
     * Sets the sSystemName value for this WSA_GetModuleName.
     * 
     * @param sSystemName
     */
    public void setSSystemName(java.lang.String sSystemName) {
        this.sSystemName = sSystemName;
    }


    /**
     * Gets the sModuleName value for this WSA_GetModuleName.
     * 
     * @return sModuleName
     */
    public java.lang.String getSModuleName() {
        return sModuleName;
    }


    /**
     * Sets the sModuleName value for this WSA_GetModuleName.
     * 
     * @param sModuleName
     */
    public void setSModuleName(java.lang.String sModuleName) {
        this.sModuleName = sModuleName;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WSA_GetModuleName)) return false;
        WSA_GetModuleName other = (WSA_GetModuleName) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.sEmployeeData==null && other.getSEmployeeData()==null) || 
             (this.sEmployeeData!=null &&
              this.sEmployeeData.equals(other.getSEmployeeData()))) &&
            ((this.sSystemName==null && other.getSSystemName()==null) || 
             (this.sSystemName!=null &&
              this.sSystemName.equals(other.getSSystemName()))) &&
            ((this.sModuleName==null && other.getSModuleName()==null) || 
             (this.sModuleName!=null &&
              this.sModuleName.equals(other.getSModuleName())));
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
        if (getSEmployeeData() != null) {
            _hashCode += getSEmployeeData().hashCode();
        }
        if (getSSystemName() != null) {
            _hashCode += getSSystemName().hashCode();
        }
        if (getSModuleName() != null) {
            _hashCode += getSModuleName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WSA_GetModuleName.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">WSA_GetModuleName"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SEmployeeData");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "sEmployeeData"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SSystemName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "sSystemName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SModuleName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "sModuleName"));
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
