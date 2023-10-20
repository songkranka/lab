/**
 * AT_CurrentPolicyResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AT_CurrentPolicyResponse  implements java.io.Serializable {
    private org.tempuri.AT_CurrentPolicyResponseAT_CurrentPolicyResult AT_CurrentPolicyResult;

    public AT_CurrentPolicyResponse() {
    }

    public AT_CurrentPolicyResponse(
           org.tempuri.AT_CurrentPolicyResponseAT_CurrentPolicyResult AT_CurrentPolicyResult) {
           this.AT_CurrentPolicyResult = AT_CurrentPolicyResult;
    }


    /**
     * Gets the AT_CurrentPolicyResult value for this AT_CurrentPolicyResponse.
     * 
     * @return AT_CurrentPolicyResult
     */
    public org.tempuri.AT_CurrentPolicyResponseAT_CurrentPolicyResult getAT_CurrentPolicyResult() {
        return AT_CurrentPolicyResult;
    }


    /**
     * Sets the AT_CurrentPolicyResult value for this AT_CurrentPolicyResponse.
     * 
     * @param AT_CurrentPolicyResult
     */
    public void setAT_CurrentPolicyResult(org.tempuri.AT_CurrentPolicyResponseAT_CurrentPolicyResult AT_CurrentPolicyResult) {
        this.AT_CurrentPolicyResult = AT_CurrentPolicyResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AT_CurrentPolicyResponse)) return false;
        AT_CurrentPolicyResponse other = (AT_CurrentPolicyResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.AT_CurrentPolicyResult==null && other.getAT_CurrentPolicyResult()==null) || 
             (this.AT_CurrentPolicyResult!=null &&
              this.AT_CurrentPolicyResult.equals(other.getAT_CurrentPolicyResult())));
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
        if (getAT_CurrentPolicyResult() != null) {
            _hashCode += getAT_CurrentPolicyResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AT_CurrentPolicyResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AT_CurrentPolicyResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AT_CurrentPolicyResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "AT_CurrentPolicyResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>AT_CurrentPolicyResponse>AT_CurrentPolicyResult"));
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
