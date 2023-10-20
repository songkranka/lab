/**
 * AT_EditDayByBranchLPGResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AT_EditDayByBranchLPGResponse  implements java.io.Serializable {
    private java.lang.String AT_EditDayByBranchLPGResult;

    public AT_EditDayByBranchLPGResponse() {
    }

    public AT_EditDayByBranchLPGResponse(
           java.lang.String AT_EditDayByBranchLPGResult) {
           this.AT_EditDayByBranchLPGResult = AT_EditDayByBranchLPGResult;
    }


    /**
     * Gets the AT_EditDayByBranchLPGResult value for this AT_EditDayByBranchLPGResponse.
     * 
     * @return AT_EditDayByBranchLPGResult
     */
    public java.lang.String getAT_EditDayByBranchLPGResult() {
        return AT_EditDayByBranchLPGResult;
    }


    /**
     * Sets the AT_EditDayByBranchLPGResult value for this AT_EditDayByBranchLPGResponse.
     * 
     * @param AT_EditDayByBranchLPGResult
     */
    public void setAT_EditDayByBranchLPGResult(java.lang.String AT_EditDayByBranchLPGResult) {
        this.AT_EditDayByBranchLPGResult = AT_EditDayByBranchLPGResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AT_EditDayByBranchLPGResponse)) return false;
        AT_EditDayByBranchLPGResponse other = (AT_EditDayByBranchLPGResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.AT_EditDayByBranchLPGResult==null && other.getAT_EditDayByBranchLPGResult()==null) || 
             (this.AT_EditDayByBranchLPGResult!=null &&
              this.AT_EditDayByBranchLPGResult.equals(other.getAT_EditDayByBranchLPGResult())));
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
        if (getAT_EditDayByBranchLPGResult() != null) {
            _hashCode += getAT_EditDayByBranchLPGResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AT_EditDayByBranchLPGResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AT_EditDayByBranchLPGResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AT_EditDayByBranchLPGResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "AT_EditDayByBranchLPGResult"));
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
