/**
 * AT_OrderAutoCalPowerJetResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AT_OrderAutoCalPowerJetResponse  implements java.io.Serializable {
    private org.tempuri.AT_OrderAutoCalPowerJetResponseAT_OrderAutoCalPowerJetResult AT_OrderAutoCalPowerJetResult;

    public AT_OrderAutoCalPowerJetResponse() {
    }

    public AT_OrderAutoCalPowerJetResponse(
           org.tempuri.AT_OrderAutoCalPowerJetResponseAT_OrderAutoCalPowerJetResult AT_OrderAutoCalPowerJetResult) {
           this.AT_OrderAutoCalPowerJetResult = AT_OrderAutoCalPowerJetResult;
    }


    /**
     * Gets the AT_OrderAutoCalPowerJetResult value for this AT_OrderAutoCalPowerJetResponse.
     * 
     * @return AT_OrderAutoCalPowerJetResult
     */
    public org.tempuri.AT_OrderAutoCalPowerJetResponseAT_OrderAutoCalPowerJetResult getAT_OrderAutoCalPowerJetResult() {
        return AT_OrderAutoCalPowerJetResult;
    }


    /**
     * Sets the AT_OrderAutoCalPowerJetResult value for this AT_OrderAutoCalPowerJetResponse.
     * 
     * @param AT_OrderAutoCalPowerJetResult
     */
    public void setAT_OrderAutoCalPowerJetResult(org.tempuri.AT_OrderAutoCalPowerJetResponseAT_OrderAutoCalPowerJetResult AT_OrderAutoCalPowerJetResult) {
        this.AT_OrderAutoCalPowerJetResult = AT_OrderAutoCalPowerJetResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AT_OrderAutoCalPowerJetResponse)) return false;
        AT_OrderAutoCalPowerJetResponse other = (AT_OrderAutoCalPowerJetResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.AT_OrderAutoCalPowerJetResult==null && other.getAT_OrderAutoCalPowerJetResult()==null) || 
             (this.AT_OrderAutoCalPowerJetResult!=null &&
              this.AT_OrderAutoCalPowerJetResult.equals(other.getAT_OrderAutoCalPowerJetResult())));
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
        if (getAT_OrderAutoCalPowerJetResult() != null) {
            _hashCode += getAT_OrderAutoCalPowerJetResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AT_OrderAutoCalPowerJetResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AT_OrderAutoCalPowerJetResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AT_OrderAutoCalPowerJetResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "AT_OrderAutoCalPowerJetResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>AT_OrderAutoCalPowerJetResponse>AT_OrderAutoCalPowerJetResult"));
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
