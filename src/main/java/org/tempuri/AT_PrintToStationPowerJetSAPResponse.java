/**
 * AT_PrintToStationPowerJetSAPResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AT_PrintToStationPowerJetSAPResponse  implements java.io.Serializable {
    private org.tempuri.AT_PrintToStationPowerJetSAPResponseAT_PrintToStationPowerJetSAPResult AT_PrintToStationPowerJetSAPResult;

    public AT_PrintToStationPowerJetSAPResponse() {
    }

    public AT_PrintToStationPowerJetSAPResponse(
           org.tempuri.AT_PrintToStationPowerJetSAPResponseAT_PrintToStationPowerJetSAPResult AT_PrintToStationPowerJetSAPResult) {
           this.AT_PrintToStationPowerJetSAPResult = AT_PrintToStationPowerJetSAPResult;
    }


    /**
     * Gets the AT_PrintToStationPowerJetSAPResult value for this AT_PrintToStationPowerJetSAPResponse.
     * 
     * @return AT_PrintToStationPowerJetSAPResult
     */
    public org.tempuri.AT_PrintToStationPowerJetSAPResponseAT_PrintToStationPowerJetSAPResult getAT_PrintToStationPowerJetSAPResult() {
        return AT_PrintToStationPowerJetSAPResult;
    }


    /**
     * Sets the AT_PrintToStationPowerJetSAPResult value for this AT_PrintToStationPowerJetSAPResponse.
     * 
     * @param AT_PrintToStationPowerJetSAPResult
     */
    public void setAT_PrintToStationPowerJetSAPResult(org.tempuri.AT_PrintToStationPowerJetSAPResponseAT_PrintToStationPowerJetSAPResult AT_PrintToStationPowerJetSAPResult) {
        this.AT_PrintToStationPowerJetSAPResult = AT_PrintToStationPowerJetSAPResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AT_PrintToStationPowerJetSAPResponse)) return false;
        AT_PrintToStationPowerJetSAPResponse other = (AT_PrintToStationPowerJetSAPResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.AT_PrintToStationPowerJetSAPResult==null && other.getAT_PrintToStationPowerJetSAPResult()==null) || 
             (this.AT_PrintToStationPowerJetSAPResult!=null &&
              this.AT_PrintToStationPowerJetSAPResult.equals(other.getAT_PrintToStationPowerJetSAPResult())));
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
        if (getAT_PrintToStationPowerJetSAPResult() != null) {
            _hashCode += getAT_PrintToStationPowerJetSAPResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AT_PrintToStationPowerJetSAPResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AT_PrintToStationPowerJetSAPResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AT_PrintToStationPowerJetSAPResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "AT_PrintToStationPowerJetSAPResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>AT_PrintToStationPowerJetSAPResponse>AT_PrintToStationPowerJetSAPResult"));
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
