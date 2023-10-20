/**
 * AT_VersionUpdateCheckResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AT_VersionUpdateCheckResponse  implements java.io.Serializable {
    private java.lang.String AT_VersionUpdateCheckResult;

    public AT_VersionUpdateCheckResponse() {
    }

    public AT_VersionUpdateCheckResponse(
           java.lang.String AT_VersionUpdateCheckResult) {
           this.AT_VersionUpdateCheckResult = AT_VersionUpdateCheckResult;
    }


    /**
     * Gets the AT_VersionUpdateCheckResult value for this AT_VersionUpdateCheckResponse.
     * 
     * @return AT_VersionUpdateCheckResult
     */
    public java.lang.String getAT_VersionUpdateCheckResult() {
        return AT_VersionUpdateCheckResult;
    }


    /**
     * Sets the AT_VersionUpdateCheckResult value for this AT_VersionUpdateCheckResponse.
     * 
     * @param AT_VersionUpdateCheckResult
     */
    public void setAT_VersionUpdateCheckResult(java.lang.String AT_VersionUpdateCheckResult) {
        this.AT_VersionUpdateCheckResult = AT_VersionUpdateCheckResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AT_VersionUpdateCheckResponse)) return false;
        AT_VersionUpdateCheckResponse other = (AT_VersionUpdateCheckResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.AT_VersionUpdateCheckResult==null && other.getAT_VersionUpdateCheckResult()==null) || 
             (this.AT_VersionUpdateCheckResult!=null &&
              this.AT_VersionUpdateCheckResult.equals(other.getAT_VersionUpdateCheckResult())));
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
        if (getAT_VersionUpdateCheckResult() != null) {
            _hashCode += getAT_VersionUpdateCheckResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AT_VersionUpdateCheckResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AT_VersionUpdateCheckResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AT_VersionUpdateCheckResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "AT_VersionUpdateCheckResult"));
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
