/**
 * AT_GetBrnLupeConfigResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AT_GetBrnLupeConfigResponse  implements java.io.Serializable {
    private org.tempuri.AT_GetBrnLupeConfigResponseAT_GetBrnLupeConfigResult AT_GetBrnLupeConfigResult;

    public AT_GetBrnLupeConfigResponse() {
    }

    public AT_GetBrnLupeConfigResponse(
           org.tempuri.AT_GetBrnLupeConfigResponseAT_GetBrnLupeConfigResult AT_GetBrnLupeConfigResult) {
           this.AT_GetBrnLupeConfigResult = AT_GetBrnLupeConfigResult;
    }


    /**
     * Gets the AT_GetBrnLupeConfigResult value for this AT_GetBrnLupeConfigResponse.
     * 
     * @return AT_GetBrnLupeConfigResult
     */
    public org.tempuri.AT_GetBrnLupeConfigResponseAT_GetBrnLupeConfigResult getAT_GetBrnLupeConfigResult() {
        return AT_GetBrnLupeConfigResult;
    }


    /**
     * Sets the AT_GetBrnLupeConfigResult value for this AT_GetBrnLupeConfigResponse.
     * 
     * @param AT_GetBrnLupeConfigResult
     */
    public void setAT_GetBrnLupeConfigResult(org.tempuri.AT_GetBrnLupeConfigResponseAT_GetBrnLupeConfigResult AT_GetBrnLupeConfigResult) {
        this.AT_GetBrnLupeConfigResult = AT_GetBrnLupeConfigResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AT_GetBrnLupeConfigResponse)) return false;
        AT_GetBrnLupeConfigResponse other = (AT_GetBrnLupeConfigResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.AT_GetBrnLupeConfigResult==null && other.getAT_GetBrnLupeConfigResult()==null) || 
             (this.AT_GetBrnLupeConfigResult!=null &&
              this.AT_GetBrnLupeConfigResult.equals(other.getAT_GetBrnLupeConfigResult())));
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
        if (getAT_GetBrnLupeConfigResult() != null) {
            _hashCode += getAT_GetBrnLupeConfigResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AT_GetBrnLupeConfigResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AT_GetBrnLupeConfigResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AT_GetBrnLupeConfigResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "AT_GetBrnLupeConfigResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>AT_GetBrnLupeConfigResponse>AT_GetBrnLupeConfigResult"));
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
