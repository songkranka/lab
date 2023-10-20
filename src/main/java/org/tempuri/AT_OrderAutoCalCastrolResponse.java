/**
 * AT_OrderAutoCalCastrolResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AT_OrderAutoCalCastrolResponse  implements java.io.Serializable {
    private org.tempuri.AT_OrderAutoCalCastrolResponseAT_OrderAutoCalCastrolResult AT_OrderAutoCalCastrolResult;

    public AT_OrderAutoCalCastrolResponse() {
    }

    public AT_OrderAutoCalCastrolResponse(
           org.tempuri.AT_OrderAutoCalCastrolResponseAT_OrderAutoCalCastrolResult AT_OrderAutoCalCastrolResult) {
           this.AT_OrderAutoCalCastrolResult = AT_OrderAutoCalCastrolResult;
    }


    /**
     * Gets the AT_OrderAutoCalCastrolResult value for this AT_OrderAutoCalCastrolResponse.
     * 
     * @return AT_OrderAutoCalCastrolResult
     */
    public org.tempuri.AT_OrderAutoCalCastrolResponseAT_OrderAutoCalCastrolResult getAT_OrderAutoCalCastrolResult() {
        return AT_OrderAutoCalCastrolResult;
    }


    /**
     * Sets the AT_OrderAutoCalCastrolResult value for this AT_OrderAutoCalCastrolResponse.
     * 
     * @param AT_OrderAutoCalCastrolResult
     */
    public void setAT_OrderAutoCalCastrolResult(org.tempuri.AT_OrderAutoCalCastrolResponseAT_OrderAutoCalCastrolResult AT_OrderAutoCalCastrolResult) {
        this.AT_OrderAutoCalCastrolResult = AT_OrderAutoCalCastrolResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AT_OrderAutoCalCastrolResponse)) return false;
        AT_OrderAutoCalCastrolResponse other = (AT_OrderAutoCalCastrolResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.AT_OrderAutoCalCastrolResult==null && other.getAT_OrderAutoCalCastrolResult()==null) || 
             (this.AT_OrderAutoCalCastrolResult!=null &&
              this.AT_OrderAutoCalCastrolResult.equals(other.getAT_OrderAutoCalCastrolResult())));
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
        if (getAT_OrderAutoCalCastrolResult() != null) {
            _hashCode += getAT_OrderAutoCalCastrolResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AT_OrderAutoCalCastrolResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AT_OrderAutoCalCastrolResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AT_OrderAutoCalCastrolResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "AT_OrderAutoCalCastrolResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>AT_OrderAutoCalCastrolResponse>AT_OrderAutoCalCastrolResult"));
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
