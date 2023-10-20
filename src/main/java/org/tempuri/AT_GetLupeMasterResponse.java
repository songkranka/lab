/**
 * AT_GetLupeMasterResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AT_GetLupeMasterResponse  implements java.io.Serializable {
    private org.tempuri.AT_GetLupeMasterResponseAT_GetLupeMasterResult AT_GetLupeMasterResult;

    public AT_GetLupeMasterResponse() {
    }

    public AT_GetLupeMasterResponse(
           org.tempuri.AT_GetLupeMasterResponseAT_GetLupeMasterResult AT_GetLupeMasterResult) {
           this.AT_GetLupeMasterResult = AT_GetLupeMasterResult;
    }


    /**
     * Gets the AT_GetLupeMasterResult value for this AT_GetLupeMasterResponse.
     * 
     * @return AT_GetLupeMasterResult
     */
    public org.tempuri.AT_GetLupeMasterResponseAT_GetLupeMasterResult getAT_GetLupeMasterResult() {
        return AT_GetLupeMasterResult;
    }


    /**
     * Sets the AT_GetLupeMasterResult value for this AT_GetLupeMasterResponse.
     * 
     * @param AT_GetLupeMasterResult
     */
    public void setAT_GetLupeMasterResult(org.tempuri.AT_GetLupeMasterResponseAT_GetLupeMasterResult AT_GetLupeMasterResult) {
        this.AT_GetLupeMasterResult = AT_GetLupeMasterResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AT_GetLupeMasterResponse)) return false;
        AT_GetLupeMasterResponse other = (AT_GetLupeMasterResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.AT_GetLupeMasterResult==null && other.getAT_GetLupeMasterResult()==null) || 
             (this.AT_GetLupeMasterResult!=null &&
              this.AT_GetLupeMasterResult.equals(other.getAT_GetLupeMasterResult())));
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
        if (getAT_GetLupeMasterResult() != null) {
            _hashCode += getAT_GetLupeMasterResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AT_GetLupeMasterResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AT_GetLupeMasterResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AT_GetLupeMasterResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "AT_GetLupeMasterResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>AT_GetLupeMasterResponse>AT_GetLupeMasterResult"));
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
