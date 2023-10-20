/**
 * AT_EditDayByBranchResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AT_EditDayByBranchResponse  implements java.io.Serializable {
    private java.lang.String AT_EditDayByBranchResult;

    public AT_EditDayByBranchResponse() {
    }

    public AT_EditDayByBranchResponse(
           java.lang.String AT_EditDayByBranchResult) {
           this.AT_EditDayByBranchResult = AT_EditDayByBranchResult;
    }


    /**
     * Gets the AT_EditDayByBranchResult value for this AT_EditDayByBranchResponse.
     * 
     * @return AT_EditDayByBranchResult
     */
    public java.lang.String getAT_EditDayByBranchResult() {
        return AT_EditDayByBranchResult;
    }


    /**
     * Sets the AT_EditDayByBranchResult value for this AT_EditDayByBranchResponse.
     * 
     * @param AT_EditDayByBranchResult
     */
    public void setAT_EditDayByBranchResult(java.lang.String AT_EditDayByBranchResult) {
        this.AT_EditDayByBranchResult = AT_EditDayByBranchResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AT_EditDayByBranchResponse)) return false;
        AT_EditDayByBranchResponse other = (AT_EditDayByBranchResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.AT_EditDayByBranchResult==null && other.getAT_EditDayByBranchResult()==null) || 
             (this.AT_EditDayByBranchResult!=null &&
              this.AT_EditDayByBranchResult.equals(other.getAT_EditDayByBranchResult())));
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
        if (getAT_EditDayByBranchResult() != null) {
            _hashCode += getAT_EditDayByBranchResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AT_EditDayByBranchResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AT_EditDayByBranchResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AT_EditDayByBranchResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "AT_EditDayByBranchResult"));
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
