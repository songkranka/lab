/**
 * AT_EditDayAvgSellResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AT_EditDayAvgSellResponse  implements java.io.Serializable {
    private java.lang.String AT_EditDayAvgSellResult;

    public AT_EditDayAvgSellResponse() {
    }

    public AT_EditDayAvgSellResponse(
           java.lang.String AT_EditDayAvgSellResult) {
           this.AT_EditDayAvgSellResult = AT_EditDayAvgSellResult;
    }


    /**
     * Gets the AT_EditDayAvgSellResult value for this AT_EditDayAvgSellResponse.
     * 
     * @return AT_EditDayAvgSellResult
     */
    public java.lang.String getAT_EditDayAvgSellResult() {
        return AT_EditDayAvgSellResult;
    }


    /**
     * Sets the AT_EditDayAvgSellResult value for this AT_EditDayAvgSellResponse.
     * 
     * @param AT_EditDayAvgSellResult
     */
    public void setAT_EditDayAvgSellResult(java.lang.String AT_EditDayAvgSellResult) {
        this.AT_EditDayAvgSellResult = AT_EditDayAvgSellResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AT_EditDayAvgSellResponse)) return false;
        AT_EditDayAvgSellResponse other = (AT_EditDayAvgSellResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.AT_EditDayAvgSellResult==null && other.getAT_EditDayAvgSellResult()==null) || 
             (this.AT_EditDayAvgSellResult!=null &&
              this.AT_EditDayAvgSellResult.equals(other.getAT_EditDayAvgSellResult())));
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
        if (getAT_EditDayAvgSellResult() != null) {
            _hashCode += getAT_EditDayAvgSellResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AT_EditDayAvgSellResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AT_EditDayAvgSellResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AT_EditDayAvgSellResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "AT_EditDayAvgSellResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
