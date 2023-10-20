/**
 * AT_GetdayByBranchLPGResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AT_GetdayByBranchLPGResponse  implements java.io.Serializable {
    private org.tempuri.AT_GetdayByBranchLPGResponseAT_GetdayByBranchLPGResult AT_GetdayByBranchLPGResult;

    public AT_GetdayByBranchLPGResponse() {
    }

    public AT_GetdayByBranchLPGResponse(
           org.tempuri.AT_GetdayByBranchLPGResponseAT_GetdayByBranchLPGResult AT_GetdayByBranchLPGResult) {
           this.AT_GetdayByBranchLPGResult = AT_GetdayByBranchLPGResult;
    }


    /**
     * Gets the AT_GetdayByBranchLPGResult value for this AT_GetdayByBranchLPGResponse.
     * 
     * @return AT_GetdayByBranchLPGResult
     */
    public org.tempuri.AT_GetdayByBranchLPGResponseAT_GetdayByBranchLPGResult getAT_GetdayByBranchLPGResult() {
        return AT_GetdayByBranchLPGResult;
    }


    /**
     * Sets the AT_GetdayByBranchLPGResult value for this AT_GetdayByBranchLPGResponse.
     * 
     * @param AT_GetdayByBranchLPGResult
     */
    public void setAT_GetdayByBranchLPGResult(org.tempuri.AT_GetdayByBranchLPGResponseAT_GetdayByBranchLPGResult AT_GetdayByBranchLPGResult) {
        this.AT_GetdayByBranchLPGResult = AT_GetdayByBranchLPGResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AT_GetdayByBranchLPGResponse)) return false;
        AT_GetdayByBranchLPGResponse other = (AT_GetdayByBranchLPGResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.AT_GetdayByBranchLPGResult==null && other.getAT_GetdayByBranchLPGResult()==null) || 
             (this.AT_GetdayByBranchLPGResult!=null &&
              this.AT_GetdayByBranchLPGResult.equals(other.getAT_GetdayByBranchLPGResult())));
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
        if (getAT_GetdayByBranchLPGResult() != null) {
            _hashCode += getAT_GetdayByBranchLPGResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AT_GetdayByBranchLPGResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AT_GetdayByBranchLPGResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AT_GetdayByBranchLPGResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "AT_GetdayByBranchLPGResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>AT_GetdayByBranchLPGResponse>AT_GetdayByBranchLPGResult"));
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
