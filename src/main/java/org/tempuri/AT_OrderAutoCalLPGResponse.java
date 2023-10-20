/**
 * AT_OrderAutoCalLPGResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AT_OrderAutoCalLPGResponse  implements java.io.Serializable {
    private org.tempuri.AT_OrderAutoCalLPGResponseAT_OrderAutoCalLPGResult AT_OrderAutoCalLPGResult;

    public AT_OrderAutoCalLPGResponse() {
    }

    public AT_OrderAutoCalLPGResponse(
           org.tempuri.AT_OrderAutoCalLPGResponseAT_OrderAutoCalLPGResult AT_OrderAutoCalLPGResult) {
           this.AT_OrderAutoCalLPGResult = AT_OrderAutoCalLPGResult;
    }


    /**
     * Gets the AT_OrderAutoCalLPGResult value for this AT_OrderAutoCalLPGResponse.
     * 
     * @return AT_OrderAutoCalLPGResult
     */
    public org.tempuri.AT_OrderAutoCalLPGResponseAT_OrderAutoCalLPGResult getAT_OrderAutoCalLPGResult() {
        return AT_OrderAutoCalLPGResult;
    }


    /**
     * Sets the AT_OrderAutoCalLPGResult value for this AT_OrderAutoCalLPGResponse.
     * 
     * @param AT_OrderAutoCalLPGResult
     */
    public void setAT_OrderAutoCalLPGResult(org.tempuri.AT_OrderAutoCalLPGResponseAT_OrderAutoCalLPGResult AT_OrderAutoCalLPGResult) {
        this.AT_OrderAutoCalLPGResult = AT_OrderAutoCalLPGResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AT_OrderAutoCalLPGResponse)) return false;
        AT_OrderAutoCalLPGResponse other = (AT_OrderAutoCalLPGResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.AT_OrderAutoCalLPGResult==null && other.getAT_OrderAutoCalLPGResult()==null) || 
             (this.AT_OrderAutoCalLPGResult!=null &&
              this.AT_OrderAutoCalLPGResult.equals(other.getAT_OrderAutoCalLPGResult())));
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
        if (getAT_OrderAutoCalLPGResult() != null) {
            _hashCode += getAT_OrderAutoCalLPGResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AT_OrderAutoCalLPGResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AT_OrderAutoCalLPGResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AT_OrderAutoCalLPGResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "AT_OrderAutoCalLPGResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>AT_OrderAutoCalLPGResponse>AT_OrderAutoCalLPGResult"));
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
