/**
 * AT_GetdayByBranchResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AT_GetdayByBranchResponse  implements java.io.Serializable {
    private org.tempuri.AT_GetdayByBranchResponseAT_GetdayByBranchResult AT_GetdayByBranchResult;

    public AT_GetdayByBranchResponse() {
    }

    public AT_GetdayByBranchResponse(
           org.tempuri.AT_GetdayByBranchResponseAT_GetdayByBranchResult AT_GetdayByBranchResult) {
           this.AT_GetdayByBranchResult = AT_GetdayByBranchResult;
    }


    /**
     * Gets the AT_GetdayByBranchResult value for this AT_GetdayByBranchResponse.
     * 
     * @return AT_GetdayByBranchResult
     */
    public org.tempuri.AT_GetdayByBranchResponseAT_GetdayByBranchResult getAT_GetdayByBranchResult() {
        return AT_GetdayByBranchResult;
    }


    /**
     * Sets the AT_GetdayByBranchResult value for this AT_GetdayByBranchResponse.
     * 
     * @param AT_GetdayByBranchResult
     */
    public void setAT_GetdayByBranchResult(org.tempuri.AT_GetdayByBranchResponseAT_GetdayByBranchResult AT_GetdayByBranchResult) {
        this.AT_GetdayByBranchResult = AT_GetdayByBranchResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AT_GetdayByBranchResponse)) return false;
        AT_GetdayByBranchResponse other = (AT_GetdayByBranchResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.AT_GetdayByBranchResult==null && other.getAT_GetdayByBranchResult()==null) || 
             (this.AT_GetdayByBranchResult!=null &&
              this.AT_GetdayByBranchResult.equals(other.getAT_GetdayByBranchResult())));
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
        if (getAT_GetdayByBranchResult() != null) {
            _hashCode += getAT_GetdayByBranchResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AT_GetdayByBranchResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AT_GetdayByBranchResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AT_GetdayByBranchResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "AT_GetdayByBranchResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>AT_GetdayByBranchResponse>AT_GetdayByBranchResult"));
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
