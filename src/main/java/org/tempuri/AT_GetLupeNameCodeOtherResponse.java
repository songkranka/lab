/**
 * AT_GetLupeNameCodeOtherResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AT_GetLupeNameCodeOtherResponse  implements java.io.Serializable {
    private org.tempuri.AT_GetLupeNameCodeOtherResponseAT_GetLupeNameCodeOtherResult AT_GetLupeNameCodeOtherResult;

    public AT_GetLupeNameCodeOtherResponse() {
    }

    public AT_GetLupeNameCodeOtherResponse(
           org.tempuri.AT_GetLupeNameCodeOtherResponseAT_GetLupeNameCodeOtherResult AT_GetLupeNameCodeOtherResult) {
           this.AT_GetLupeNameCodeOtherResult = AT_GetLupeNameCodeOtherResult;
    }


    /**
     * Gets the AT_GetLupeNameCodeOtherResult value for this AT_GetLupeNameCodeOtherResponse.
     * 
     * @return AT_GetLupeNameCodeOtherResult
     */
    public org.tempuri.AT_GetLupeNameCodeOtherResponseAT_GetLupeNameCodeOtherResult getAT_GetLupeNameCodeOtherResult() {
        return AT_GetLupeNameCodeOtherResult;
    }


    /**
     * Sets the AT_GetLupeNameCodeOtherResult value for this AT_GetLupeNameCodeOtherResponse.
     * 
     * @param AT_GetLupeNameCodeOtherResult
     */
    public void setAT_GetLupeNameCodeOtherResult(org.tempuri.AT_GetLupeNameCodeOtherResponseAT_GetLupeNameCodeOtherResult AT_GetLupeNameCodeOtherResult) {
        this.AT_GetLupeNameCodeOtherResult = AT_GetLupeNameCodeOtherResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AT_GetLupeNameCodeOtherResponse)) return false;
        AT_GetLupeNameCodeOtherResponse other = (AT_GetLupeNameCodeOtherResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.AT_GetLupeNameCodeOtherResult==null && other.getAT_GetLupeNameCodeOtherResult()==null) || 
             (this.AT_GetLupeNameCodeOtherResult!=null &&
              this.AT_GetLupeNameCodeOtherResult.equals(other.getAT_GetLupeNameCodeOtherResult())));
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
        if (getAT_GetLupeNameCodeOtherResult() != null) {
            _hashCode += getAT_GetLupeNameCodeOtherResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AT_GetLupeNameCodeOtherResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AT_GetLupeNameCodeOtherResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AT_GetLupeNameCodeOtherResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "AT_GetLupeNameCodeOtherResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>AT_GetLupeNameCodeOtherResponse>AT_GetLupeNameCodeOtherResult"));
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
