/**
 * AT_OrderAutoCalMaxnetronSplitResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AT_OrderAutoCalMaxnetronSplitResponse  implements java.io.Serializable {
    private org.tempuri.AT_OrderAutoCalMaxnetronSplitResponseAT_OrderAutoCalMaxnetronSplitResult AT_OrderAutoCalMaxnetronSplitResult;

    public AT_OrderAutoCalMaxnetronSplitResponse() {
    }

    public AT_OrderAutoCalMaxnetronSplitResponse(
           org.tempuri.AT_OrderAutoCalMaxnetronSplitResponseAT_OrderAutoCalMaxnetronSplitResult AT_OrderAutoCalMaxnetronSplitResult) {
           this.AT_OrderAutoCalMaxnetronSplitResult = AT_OrderAutoCalMaxnetronSplitResult;
    }


    /**
     * Gets the AT_OrderAutoCalMaxnetronSplitResult value for this AT_OrderAutoCalMaxnetronSplitResponse.
     * 
     * @return AT_OrderAutoCalMaxnetronSplitResult
     */
    public org.tempuri.AT_OrderAutoCalMaxnetronSplitResponseAT_OrderAutoCalMaxnetronSplitResult getAT_OrderAutoCalMaxnetronSplitResult() {
        return AT_OrderAutoCalMaxnetronSplitResult;
    }


    /**
     * Sets the AT_OrderAutoCalMaxnetronSplitResult value for this AT_OrderAutoCalMaxnetronSplitResponse.
     * 
     * @param AT_OrderAutoCalMaxnetronSplitResult
     */
    public void setAT_OrderAutoCalMaxnetronSplitResult(org.tempuri.AT_OrderAutoCalMaxnetronSplitResponseAT_OrderAutoCalMaxnetronSplitResult AT_OrderAutoCalMaxnetronSplitResult) {
        this.AT_OrderAutoCalMaxnetronSplitResult = AT_OrderAutoCalMaxnetronSplitResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AT_OrderAutoCalMaxnetronSplitResponse)) return false;
        AT_OrderAutoCalMaxnetronSplitResponse other = (AT_OrderAutoCalMaxnetronSplitResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.AT_OrderAutoCalMaxnetronSplitResult==null && other.getAT_OrderAutoCalMaxnetronSplitResult()==null) || 
             (this.AT_OrderAutoCalMaxnetronSplitResult!=null &&
              this.AT_OrderAutoCalMaxnetronSplitResult.equals(other.getAT_OrderAutoCalMaxnetronSplitResult())));
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
        if (getAT_OrderAutoCalMaxnetronSplitResult() != null) {
            _hashCode += getAT_OrderAutoCalMaxnetronSplitResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AT_OrderAutoCalMaxnetronSplitResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AT_OrderAutoCalMaxnetronSplitResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AT_OrderAutoCalMaxnetronSplitResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "AT_OrderAutoCalMaxnetronSplitResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>AT_OrderAutoCalMaxnetronSplitResponse>AT_OrderAutoCalMaxnetronSplitResult"));
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
