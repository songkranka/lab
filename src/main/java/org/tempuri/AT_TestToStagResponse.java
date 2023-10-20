/**
 * AT_TestToStagResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AT_TestToStagResponse  implements java.io.Serializable {
    private java.lang.String AT_TestToStagResult;

    public AT_TestToStagResponse() {
    }

    public AT_TestToStagResponse(
           java.lang.String AT_TestToStagResult) {
           this.AT_TestToStagResult = AT_TestToStagResult;
    }


    /**
     * Gets the AT_TestToStagResult value for this AT_TestToStagResponse.
     * 
     * @return AT_TestToStagResult
     */
    public java.lang.String getAT_TestToStagResult() {
        return AT_TestToStagResult;
    }


    /**
     * Sets the AT_TestToStagResult value for this AT_TestToStagResponse.
     * 
     * @param AT_TestToStagResult
     */
    public void setAT_TestToStagResult(java.lang.String AT_TestToStagResult) {
        this.AT_TestToStagResult = AT_TestToStagResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AT_TestToStagResponse)) return false;
        AT_TestToStagResponse other = (AT_TestToStagResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.AT_TestToStagResult==null && other.getAT_TestToStagResult()==null) || 
             (this.AT_TestToStagResult!=null &&
              this.AT_TestToStagResult.equals(other.getAT_TestToStagResult())));
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
        if (getAT_TestToStagResult() != null) {
            _hashCode += getAT_TestToStagResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AT_TestToStagResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AT_TestToStagResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AT_TestToStagResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "AT_TestToStagResult"));
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
