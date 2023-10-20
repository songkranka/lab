/**
 * AT_LPGListResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AT_LPGListResponse  implements java.io.Serializable {
    private org.tempuri.AT_LPGListResponseAT_LPGListResult AT_LPGListResult;

    public AT_LPGListResponse() {
    }

    public AT_LPGListResponse(
           org.tempuri.AT_LPGListResponseAT_LPGListResult AT_LPGListResult) {
           this.AT_LPGListResult = AT_LPGListResult;
    }


    /**
     * Gets the AT_LPGListResult value for this AT_LPGListResponse.
     * 
     * @return AT_LPGListResult
     */
    public org.tempuri.AT_LPGListResponseAT_LPGListResult getAT_LPGListResult() {
        return AT_LPGListResult;
    }


    /**
     * Sets the AT_LPGListResult value for this AT_LPGListResponse.
     * 
     * @param AT_LPGListResult
     */
    public void setAT_LPGListResult(org.tempuri.AT_LPGListResponseAT_LPGListResult AT_LPGListResult) {
        this.AT_LPGListResult = AT_LPGListResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AT_LPGListResponse)) return false;
        AT_LPGListResponse other = (AT_LPGListResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.AT_LPGListResult==null && other.getAT_LPGListResult()==null) || 
             (this.AT_LPGListResult!=null &&
              this.AT_LPGListResult.equals(other.getAT_LPGListResult())));
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
        if (getAT_LPGListResult() != null) {
            _hashCode += getAT_LPGListResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AT_LPGListResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AT_LPGListResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AT_LPGListResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "AT_LPGListResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>AT_LPGListResponse>AT_LPGListResult"));
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
