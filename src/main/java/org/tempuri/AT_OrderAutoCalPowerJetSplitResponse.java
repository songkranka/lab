/**
 * AT_OrderAutoCalPowerJetSplitResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AT_OrderAutoCalPowerJetSplitResponse  implements java.io.Serializable {
    private org.tempuri.AT_OrderAutoCalPowerJetSplitResponseAT_OrderAutoCalPowerJetSplitResult AT_OrderAutoCalPowerJetSplitResult;

    public AT_OrderAutoCalPowerJetSplitResponse() {
    }

    public AT_OrderAutoCalPowerJetSplitResponse(
           org.tempuri.AT_OrderAutoCalPowerJetSplitResponseAT_OrderAutoCalPowerJetSplitResult AT_OrderAutoCalPowerJetSplitResult) {
           this.AT_OrderAutoCalPowerJetSplitResult = AT_OrderAutoCalPowerJetSplitResult;
    }


    /**
     * Gets the AT_OrderAutoCalPowerJetSplitResult value for this AT_OrderAutoCalPowerJetSplitResponse.
     * 
     * @return AT_OrderAutoCalPowerJetSplitResult
     */
    public org.tempuri.AT_OrderAutoCalPowerJetSplitResponseAT_OrderAutoCalPowerJetSplitResult getAT_OrderAutoCalPowerJetSplitResult() {
        return AT_OrderAutoCalPowerJetSplitResult;
    }


    /**
     * Sets the AT_OrderAutoCalPowerJetSplitResult value for this AT_OrderAutoCalPowerJetSplitResponse.
     * 
     * @param AT_OrderAutoCalPowerJetSplitResult
     */
    public void setAT_OrderAutoCalPowerJetSplitResult(org.tempuri.AT_OrderAutoCalPowerJetSplitResponseAT_OrderAutoCalPowerJetSplitResult AT_OrderAutoCalPowerJetSplitResult) {
        this.AT_OrderAutoCalPowerJetSplitResult = AT_OrderAutoCalPowerJetSplitResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AT_OrderAutoCalPowerJetSplitResponse)) return false;
        AT_OrderAutoCalPowerJetSplitResponse other = (AT_OrderAutoCalPowerJetSplitResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.AT_OrderAutoCalPowerJetSplitResult==null && other.getAT_OrderAutoCalPowerJetSplitResult()==null) || 
             (this.AT_OrderAutoCalPowerJetSplitResult!=null &&
              this.AT_OrderAutoCalPowerJetSplitResult.equals(other.getAT_OrderAutoCalPowerJetSplitResult())));
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
        if (getAT_OrderAutoCalPowerJetSplitResult() != null) {
            _hashCode += getAT_OrderAutoCalPowerJetSplitResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AT_OrderAutoCalPowerJetSplitResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AT_OrderAutoCalPowerJetSplitResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AT_OrderAutoCalPowerJetSplitResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "AT_OrderAutoCalPowerJetSplitResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>AT_OrderAutoCalPowerJetSplitResponse>AT_OrderAutoCalPowerJetSplitResult"));
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
