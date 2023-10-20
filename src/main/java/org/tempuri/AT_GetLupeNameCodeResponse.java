/**
 * AT_GetLupeNameCodeResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AT_GetLupeNameCodeResponse  implements java.io.Serializable {
    private org.tempuri.AT_GetLupeNameCodeResponseAT_GetLupeNameCodeResult AT_GetLupeNameCodeResult;

    public AT_GetLupeNameCodeResponse() {
    }

    public AT_GetLupeNameCodeResponse(
           org.tempuri.AT_GetLupeNameCodeResponseAT_GetLupeNameCodeResult AT_GetLupeNameCodeResult) {
           this.AT_GetLupeNameCodeResult = AT_GetLupeNameCodeResult;
    }


    /**
     * Gets the AT_GetLupeNameCodeResult value for this AT_GetLupeNameCodeResponse.
     * 
     * @return AT_GetLupeNameCodeResult
     */
    public org.tempuri.AT_GetLupeNameCodeResponseAT_GetLupeNameCodeResult getAT_GetLupeNameCodeResult() {
        return AT_GetLupeNameCodeResult;
    }


    /**
     * Sets the AT_GetLupeNameCodeResult value for this AT_GetLupeNameCodeResponse.
     * 
     * @param AT_GetLupeNameCodeResult
     */
    public void setAT_GetLupeNameCodeResult(org.tempuri.AT_GetLupeNameCodeResponseAT_GetLupeNameCodeResult AT_GetLupeNameCodeResult) {
        this.AT_GetLupeNameCodeResult = AT_GetLupeNameCodeResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AT_GetLupeNameCodeResponse)) return false;
        AT_GetLupeNameCodeResponse other = (AT_GetLupeNameCodeResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.AT_GetLupeNameCodeResult==null && other.getAT_GetLupeNameCodeResult()==null) || 
             (this.AT_GetLupeNameCodeResult!=null &&
              this.AT_GetLupeNameCodeResult.equals(other.getAT_GetLupeNameCodeResult())));
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
        if (getAT_GetLupeNameCodeResult() != null) {
            _hashCode += getAT_GetLupeNameCodeResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AT_GetLupeNameCodeResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AT_GetLupeNameCodeResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AT_GetLupeNameCodeResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "AT_GetLupeNameCodeResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>AT_GetLupeNameCodeResponse>AT_GetLupeNameCodeResult"));
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
