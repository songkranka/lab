/**
 * AT_OrderAutoCalMaxnetronResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AT_OrderAutoCalMaxnetronResponse  implements java.io.Serializable {
    private org.tempuri.AT_OrderAutoCalMaxnetronResponseAT_OrderAutoCalMaxnetronResult AT_OrderAutoCalMaxnetronResult;

    public AT_OrderAutoCalMaxnetronResponse() {
    }

    public AT_OrderAutoCalMaxnetronResponse(
           org.tempuri.AT_OrderAutoCalMaxnetronResponseAT_OrderAutoCalMaxnetronResult AT_OrderAutoCalMaxnetronResult) {
           this.AT_OrderAutoCalMaxnetronResult = AT_OrderAutoCalMaxnetronResult;
    }


    /**
     * Gets the AT_OrderAutoCalMaxnetronResult value for this AT_OrderAutoCalMaxnetronResponse.
     * 
     * @return AT_OrderAutoCalMaxnetronResult
     */
    public org.tempuri.AT_OrderAutoCalMaxnetronResponseAT_OrderAutoCalMaxnetronResult getAT_OrderAutoCalMaxnetronResult() {
        return AT_OrderAutoCalMaxnetronResult;
    }


    /**
     * Sets the AT_OrderAutoCalMaxnetronResult value for this AT_OrderAutoCalMaxnetronResponse.
     * 
     * @param AT_OrderAutoCalMaxnetronResult
     */
    public void setAT_OrderAutoCalMaxnetronResult(org.tempuri.AT_OrderAutoCalMaxnetronResponseAT_OrderAutoCalMaxnetronResult AT_OrderAutoCalMaxnetronResult) {
        this.AT_OrderAutoCalMaxnetronResult = AT_OrderAutoCalMaxnetronResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AT_OrderAutoCalMaxnetronResponse)) return false;
        AT_OrderAutoCalMaxnetronResponse other = (AT_OrderAutoCalMaxnetronResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.AT_OrderAutoCalMaxnetronResult==null && other.getAT_OrderAutoCalMaxnetronResult()==null) || 
             (this.AT_OrderAutoCalMaxnetronResult!=null &&
              this.AT_OrderAutoCalMaxnetronResult.equals(other.getAT_OrderAutoCalMaxnetronResult())));
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
        if (getAT_OrderAutoCalMaxnetronResult() != null) {
            _hashCode += getAT_OrderAutoCalMaxnetronResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AT_OrderAutoCalMaxnetronResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AT_OrderAutoCalMaxnetronResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AT_OrderAutoCalMaxnetronResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "AT_OrderAutoCalMaxnetronResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>AT_OrderAutoCalMaxnetronResponse>AT_OrderAutoCalMaxnetronResult"));
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
