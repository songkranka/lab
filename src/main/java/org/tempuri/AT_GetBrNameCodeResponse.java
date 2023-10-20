/**
 * AT_GetBrNameCodeResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AT_GetBrNameCodeResponse  implements java.io.Serializable {
    private org.tempuri.AT_GetBrNameCodeResponseAT_GetBrNameCodeResult AT_GetBrNameCodeResult;

    public AT_GetBrNameCodeResponse() {
    }

    public AT_GetBrNameCodeResponse(
           org.tempuri.AT_GetBrNameCodeResponseAT_GetBrNameCodeResult AT_GetBrNameCodeResult) {
           this.AT_GetBrNameCodeResult = AT_GetBrNameCodeResult;
    }


    /**
     * Gets the AT_GetBrNameCodeResult value for this AT_GetBrNameCodeResponse.
     * 
     * @return AT_GetBrNameCodeResult
     */
    public org.tempuri.AT_GetBrNameCodeResponseAT_GetBrNameCodeResult getAT_GetBrNameCodeResult() {
        return AT_GetBrNameCodeResult;
    }


    /**
     * Sets the AT_GetBrNameCodeResult value for this AT_GetBrNameCodeResponse.
     * 
     * @param AT_GetBrNameCodeResult
     */
    public void setAT_GetBrNameCodeResult(org.tempuri.AT_GetBrNameCodeResponseAT_GetBrNameCodeResult AT_GetBrNameCodeResult) {
        this.AT_GetBrNameCodeResult = AT_GetBrNameCodeResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AT_GetBrNameCodeResponse)) return false;
        AT_GetBrNameCodeResponse other = (AT_GetBrNameCodeResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.AT_GetBrNameCodeResult==null && other.getAT_GetBrNameCodeResult()==null) || 
             (this.AT_GetBrNameCodeResult!=null &&
              this.AT_GetBrNameCodeResult.equals(other.getAT_GetBrNameCodeResult())));
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
        if (getAT_GetBrNameCodeResult() != null) {
            _hashCode += getAT_GetBrNameCodeResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AT_GetBrNameCodeResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AT_GetBrNameCodeResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AT_GetBrNameCodeResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "AT_GetBrNameCodeResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>AT_GetBrNameCodeResponse>AT_GetBrNameCodeResult"));
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
