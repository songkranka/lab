/**
 * AT_ViewAllResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AT_ViewAllResponse  implements java.io.Serializable {
    private org.tempuri.AT_ViewAllResponseAT_ViewAllResult AT_ViewAllResult;

    public AT_ViewAllResponse() {
    }

    public AT_ViewAllResponse(
           org.tempuri.AT_ViewAllResponseAT_ViewAllResult AT_ViewAllResult) {
           this.AT_ViewAllResult = AT_ViewAllResult;
    }


    /**
     * Gets the AT_ViewAllResult value for this AT_ViewAllResponse.
     * 
     * @return AT_ViewAllResult
     */
    public org.tempuri.AT_ViewAllResponseAT_ViewAllResult getAT_ViewAllResult() {
        return AT_ViewAllResult;
    }


    /**
     * Sets the AT_ViewAllResult value for this AT_ViewAllResponse.
     * 
     * @param AT_ViewAllResult
     */
    public void setAT_ViewAllResult(org.tempuri.AT_ViewAllResponseAT_ViewAllResult AT_ViewAllResult) {
        this.AT_ViewAllResult = AT_ViewAllResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AT_ViewAllResponse)) return false;
        AT_ViewAllResponse other = (AT_ViewAllResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.AT_ViewAllResult==null && other.getAT_ViewAllResult()==null) || 
             (this.AT_ViewAllResult!=null &&
              this.AT_ViewAllResult.equals(other.getAT_ViewAllResult())));
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
        if (getAT_ViewAllResult() != null) {
            _hashCode += getAT_ViewAllResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AT_ViewAllResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AT_ViewAllResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AT_ViewAllResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "AT_ViewAllResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>AT_ViewAllResponse>AT_ViewAllResult"));
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
