/**
 * AT_InsertDayByBranchLPGResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AT_InsertDayByBranchLPGResponse  implements java.io.Serializable {
    private java.lang.String AT_InsertDayByBranchLPGResult;

    public AT_InsertDayByBranchLPGResponse() {
    }

    public AT_InsertDayByBranchLPGResponse(
           java.lang.String AT_InsertDayByBranchLPGResult) {
           this.AT_InsertDayByBranchLPGResult = AT_InsertDayByBranchLPGResult;
    }


    /**
     * Gets the AT_InsertDayByBranchLPGResult value for this AT_InsertDayByBranchLPGResponse.
     * 
     * @return AT_InsertDayByBranchLPGResult
     */
    public java.lang.String getAT_InsertDayByBranchLPGResult() {
        return AT_InsertDayByBranchLPGResult;
    }


    /**
     * Sets the AT_InsertDayByBranchLPGResult value for this AT_InsertDayByBranchLPGResponse.
     * 
     * @param AT_InsertDayByBranchLPGResult
     */
    public void setAT_InsertDayByBranchLPGResult(java.lang.String AT_InsertDayByBranchLPGResult) {
        this.AT_InsertDayByBranchLPGResult = AT_InsertDayByBranchLPGResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AT_InsertDayByBranchLPGResponse)) return false;
        AT_InsertDayByBranchLPGResponse other = (AT_InsertDayByBranchLPGResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.AT_InsertDayByBranchLPGResult==null && other.getAT_InsertDayByBranchLPGResult()==null) || 
             (this.AT_InsertDayByBranchLPGResult!=null &&
              this.AT_InsertDayByBranchLPGResult.equals(other.getAT_InsertDayByBranchLPGResult())));
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
        if (getAT_InsertDayByBranchLPGResult() != null) {
            _hashCode += getAT_InsertDayByBranchLPGResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AT_InsertDayByBranchLPGResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AT_InsertDayByBranchLPGResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AT_InsertDayByBranchLPGResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "AT_InsertDayByBranchLPGResult"));
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
