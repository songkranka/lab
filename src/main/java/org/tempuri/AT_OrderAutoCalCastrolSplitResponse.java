/**
 * AT_OrderAutoCalCastrolSplitResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AT_OrderAutoCalCastrolSplitResponse  implements java.io.Serializable {
    private org.tempuri.AT_OrderAutoCalCastrolSplitResponseAT_OrderAutoCalCastrolSplitResult AT_OrderAutoCalCastrolSplitResult;

    public AT_OrderAutoCalCastrolSplitResponse() {
    }

    public AT_OrderAutoCalCastrolSplitResponse(
           org.tempuri.AT_OrderAutoCalCastrolSplitResponseAT_OrderAutoCalCastrolSplitResult AT_OrderAutoCalCastrolSplitResult) {
           this.AT_OrderAutoCalCastrolSplitResult = AT_OrderAutoCalCastrolSplitResult;
    }


    /**
     * Gets the AT_OrderAutoCalCastrolSplitResult value for this AT_OrderAutoCalCastrolSplitResponse.
     * 
     * @return AT_OrderAutoCalCastrolSplitResult
     */
    public org.tempuri.AT_OrderAutoCalCastrolSplitResponseAT_OrderAutoCalCastrolSplitResult getAT_OrderAutoCalCastrolSplitResult() {
        return AT_OrderAutoCalCastrolSplitResult;
    }


    /**
     * Sets the AT_OrderAutoCalCastrolSplitResult value for this AT_OrderAutoCalCastrolSplitResponse.
     * 
     * @param AT_OrderAutoCalCastrolSplitResult
     */
    public void setAT_OrderAutoCalCastrolSplitResult(org.tempuri.AT_OrderAutoCalCastrolSplitResponseAT_OrderAutoCalCastrolSplitResult AT_OrderAutoCalCastrolSplitResult) {
        this.AT_OrderAutoCalCastrolSplitResult = AT_OrderAutoCalCastrolSplitResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AT_OrderAutoCalCastrolSplitResponse)) return false;
        AT_OrderAutoCalCastrolSplitResponse other = (AT_OrderAutoCalCastrolSplitResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.AT_OrderAutoCalCastrolSplitResult==null && other.getAT_OrderAutoCalCastrolSplitResult()==null) || 
             (this.AT_OrderAutoCalCastrolSplitResult!=null &&
              this.AT_OrderAutoCalCastrolSplitResult.equals(other.getAT_OrderAutoCalCastrolSplitResult())));
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
        if (getAT_OrderAutoCalCastrolSplitResult() != null) {
            _hashCode += getAT_OrderAutoCalCastrolSplitResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AT_OrderAutoCalCastrolSplitResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AT_OrderAutoCalCastrolSplitResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AT_OrderAutoCalCastrolSplitResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "AT_OrderAutoCalCastrolSplitResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>AT_OrderAutoCalCastrolSplitResponse>AT_OrderAutoCalCastrolSplitResult"));
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
