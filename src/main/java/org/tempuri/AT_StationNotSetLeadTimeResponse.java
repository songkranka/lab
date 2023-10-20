/**
 * AT_StationNotSetLeadTimeResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AT_StationNotSetLeadTimeResponse  implements java.io.Serializable {
    private org.tempuri.AT_StationNotSetLeadTimeResponseAT_StationNotSetLeadTimeResult AT_StationNotSetLeadTimeResult;

    public AT_StationNotSetLeadTimeResponse() {
    }

    public AT_StationNotSetLeadTimeResponse(
           org.tempuri.AT_StationNotSetLeadTimeResponseAT_StationNotSetLeadTimeResult AT_StationNotSetLeadTimeResult) {
           this.AT_StationNotSetLeadTimeResult = AT_StationNotSetLeadTimeResult;
    }


    /**
     * Gets the AT_StationNotSetLeadTimeResult value for this AT_StationNotSetLeadTimeResponse.
     * 
     * @return AT_StationNotSetLeadTimeResult
     */
    public org.tempuri.AT_StationNotSetLeadTimeResponseAT_StationNotSetLeadTimeResult getAT_StationNotSetLeadTimeResult() {
        return AT_StationNotSetLeadTimeResult;
    }


    /**
     * Sets the AT_StationNotSetLeadTimeResult value for this AT_StationNotSetLeadTimeResponse.
     * 
     * @param AT_StationNotSetLeadTimeResult
     */
    public void setAT_StationNotSetLeadTimeResult(org.tempuri.AT_StationNotSetLeadTimeResponseAT_StationNotSetLeadTimeResult AT_StationNotSetLeadTimeResult) {
        this.AT_StationNotSetLeadTimeResult = AT_StationNotSetLeadTimeResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AT_StationNotSetLeadTimeResponse)) return false;
        AT_StationNotSetLeadTimeResponse other = (AT_StationNotSetLeadTimeResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.AT_StationNotSetLeadTimeResult==null && other.getAT_StationNotSetLeadTimeResult()==null) || 
             (this.AT_StationNotSetLeadTimeResult!=null &&
              this.AT_StationNotSetLeadTimeResult.equals(other.getAT_StationNotSetLeadTimeResult())));
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
        if (getAT_StationNotSetLeadTimeResult() != null) {
            _hashCode += getAT_StationNotSetLeadTimeResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AT_StationNotSetLeadTimeResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AT_StationNotSetLeadTimeResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AT_StationNotSetLeadTimeResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "AT_StationNotSetLeadTimeResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>AT_StationNotSetLeadTimeResponse>AT_StationNotSetLeadTimeResult"));
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
