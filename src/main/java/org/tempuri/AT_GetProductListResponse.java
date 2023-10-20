/**
 * AT_GetProductListResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AT_GetProductListResponse  implements java.io.Serializable {
    private org.tempuri.AT_GetProductListResponseAT_GetProductListResult AT_GetProductListResult;

    public AT_GetProductListResponse() {
    }

    public AT_GetProductListResponse(
           org.tempuri.AT_GetProductListResponseAT_GetProductListResult AT_GetProductListResult) {
           this.AT_GetProductListResult = AT_GetProductListResult;
    }


    /**
     * Gets the AT_GetProductListResult value for this AT_GetProductListResponse.
     * 
     * @return AT_GetProductListResult
     */
    public org.tempuri.AT_GetProductListResponseAT_GetProductListResult getAT_GetProductListResult() {
        return AT_GetProductListResult;
    }


    /**
     * Sets the AT_GetProductListResult value for this AT_GetProductListResponse.
     * 
     * @param AT_GetProductListResult
     */
    public void setAT_GetProductListResult(org.tempuri.AT_GetProductListResponseAT_GetProductListResult AT_GetProductListResult) {
        this.AT_GetProductListResult = AT_GetProductListResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AT_GetProductListResponse)) return false;
        AT_GetProductListResponse other = (AT_GetProductListResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.AT_GetProductListResult==null && other.getAT_GetProductListResult()==null) || 
             (this.AT_GetProductListResult!=null &&
              this.AT_GetProductListResult.equals(other.getAT_GetProductListResult())));
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
        if (getAT_GetProductListResult() != null) {
            _hashCode += getAT_GetProductListResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AT_GetProductListResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AT_GetProductListResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AT_GetProductListResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "AT_GetProductListResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>AT_GetProductListResponse>AT_GetProductListResult"));
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
