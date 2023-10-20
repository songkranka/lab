/**
 * AT_GetLupeBrnNotSetResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AT_GetLupeBrnNotSetResponse  implements java.io.Serializable {
    private org.tempuri.AT_GetLupeBrnNotSetResponseAT_GetLupeBrnNotSetResult AT_GetLupeBrnNotSetResult;

    public AT_GetLupeBrnNotSetResponse() {
    }

    public AT_GetLupeBrnNotSetResponse(
           org.tempuri.AT_GetLupeBrnNotSetResponseAT_GetLupeBrnNotSetResult AT_GetLupeBrnNotSetResult) {
           this.AT_GetLupeBrnNotSetResult = AT_GetLupeBrnNotSetResult;
    }


    /**
     * Gets the AT_GetLupeBrnNotSetResult value for this AT_GetLupeBrnNotSetResponse.
     * 
     * @return AT_GetLupeBrnNotSetResult
     */
    public org.tempuri.AT_GetLupeBrnNotSetResponseAT_GetLupeBrnNotSetResult getAT_GetLupeBrnNotSetResult() {
        return AT_GetLupeBrnNotSetResult;
    }


    /**
     * Sets the AT_GetLupeBrnNotSetResult value for this AT_GetLupeBrnNotSetResponse.
     * 
     * @param AT_GetLupeBrnNotSetResult
     */
    public void setAT_GetLupeBrnNotSetResult(org.tempuri.AT_GetLupeBrnNotSetResponseAT_GetLupeBrnNotSetResult AT_GetLupeBrnNotSetResult) {
        this.AT_GetLupeBrnNotSetResult = AT_GetLupeBrnNotSetResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AT_GetLupeBrnNotSetResponse)) return false;
        AT_GetLupeBrnNotSetResponse other = (AT_GetLupeBrnNotSetResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.AT_GetLupeBrnNotSetResult==null && other.getAT_GetLupeBrnNotSetResult()==null) || 
             (this.AT_GetLupeBrnNotSetResult!=null &&
              this.AT_GetLupeBrnNotSetResult.equals(other.getAT_GetLupeBrnNotSetResult())));
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
        if (getAT_GetLupeBrnNotSetResult() != null) {
            _hashCode += getAT_GetLupeBrnNotSetResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AT_GetLupeBrnNotSetResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AT_GetLupeBrnNotSetResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AT_GetLupeBrnNotSetResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "AT_GetLupeBrnNotSetResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>AT_GetLupeBrnNotSetResponse>AT_GetLupeBrnNotSetResult"));
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
