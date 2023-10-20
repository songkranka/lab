/**
 * AT_GetRotationdayResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AT_GetRotationdayResponse  implements java.io.Serializable {
    private org.tempuri.AT_GetRotationdayResponseAT_GetRotationdayResult AT_GetRotationdayResult;

    public AT_GetRotationdayResponse() {
    }

    public AT_GetRotationdayResponse(
           org.tempuri.AT_GetRotationdayResponseAT_GetRotationdayResult AT_GetRotationdayResult) {
           this.AT_GetRotationdayResult = AT_GetRotationdayResult;
    }


    /**
     * Gets the AT_GetRotationdayResult value for this AT_GetRotationdayResponse.
     * 
     * @return AT_GetRotationdayResult
     */
    public org.tempuri.AT_GetRotationdayResponseAT_GetRotationdayResult getAT_GetRotationdayResult() {
        return AT_GetRotationdayResult;
    }


    /**
     * Sets the AT_GetRotationdayResult value for this AT_GetRotationdayResponse.
     * 
     * @param AT_GetRotationdayResult
     */
    public void setAT_GetRotationdayResult(org.tempuri.AT_GetRotationdayResponseAT_GetRotationdayResult AT_GetRotationdayResult) {
        this.AT_GetRotationdayResult = AT_GetRotationdayResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AT_GetRotationdayResponse)) return false;
        AT_GetRotationdayResponse other = (AT_GetRotationdayResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.AT_GetRotationdayResult==null && other.getAT_GetRotationdayResult()==null) || 
             (this.AT_GetRotationdayResult!=null &&
              this.AT_GetRotationdayResult.equals(other.getAT_GetRotationdayResult())));
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
        if (getAT_GetRotationdayResult() != null) {
            _hashCode += getAT_GetRotationdayResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AT_GetRotationdayResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AT_GetRotationdayResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AT_GetRotationdayResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "AT_GetRotationdayResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>AT_GetRotationdayResponse>AT_GetRotationdayResult"));
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
