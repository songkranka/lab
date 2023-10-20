/**
 * AT_ModifyAutoLupeDepotResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AT_ModifyAutoLupeDepotResponse  implements java.io.Serializable {
    private java.lang.String AT_ModifyAutoLupeDepotResult;

    public AT_ModifyAutoLupeDepotResponse() {
    }

    public AT_ModifyAutoLupeDepotResponse(
           java.lang.String AT_ModifyAutoLupeDepotResult) {
           this.AT_ModifyAutoLupeDepotResult = AT_ModifyAutoLupeDepotResult;
    }


    /**
     * Gets the AT_ModifyAutoLupeDepotResult value for this AT_ModifyAutoLupeDepotResponse.
     * 
     * @return AT_ModifyAutoLupeDepotResult
     */
    public java.lang.String getAT_ModifyAutoLupeDepotResult() {
        return AT_ModifyAutoLupeDepotResult;
    }


    /**
     * Sets the AT_ModifyAutoLupeDepotResult value for this AT_ModifyAutoLupeDepotResponse.
     * 
     * @param AT_ModifyAutoLupeDepotResult
     */
    public void setAT_ModifyAutoLupeDepotResult(java.lang.String AT_ModifyAutoLupeDepotResult) {
        this.AT_ModifyAutoLupeDepotResult = AT_ModifyAutoLupeDepotResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AT_ModifyAutoLupeDepotResponse)) return false;
        AT_ModifyAutoLupeDepotResponse other = (AT_ModifyAutoLupeDepotResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.AT_ModifyAutoLupeDepotResult==null && other.getAT_ModifyAutoLupeDepotResult()==null) || 
             (this.AT_ModifyAutoLupeDepotResult!=null &&
              this.AT_ModifyAutoLupeDepotResult.equals(other.getAT_ModifyAutoLupeDepotResult())));
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
        if (getAT_ModifyAutoLupeDepotResult() != null) {
            _hashCode += getAT_ModifyAutoLupeDepotResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AT_ModifyAutoLupeDepotResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AT_ModifyAutoLupeDepotResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AT_ModifyAutoLupeDepotResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "AT_ModifyAutoLupeDepotResult"));
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
