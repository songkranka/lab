/**
 * ValidateLoanResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class ValidateLoanResponse  implements java.io.Serializable {
    private java.lang.String validateLoanResult;

    public ValidateLoanResponse() {
    }

    public ValidateLoanResponse(
           java.lang.String validateLoanResult) {
           this.validateLoanResult = validateLoanResult;
    }


    /**
     * Gets the validateLoanResult value for this ValidateLoanResponse.
     * 
     * @return validateLoanResult
     */
    public java.lang.String getValidateLoanResult() {
        return validateLoanResult;
    }


    /**
     * Sets the validateLoanResult value for this ValidateLoanResponse.
     * 
     * @param validateLoanResult
     */
    public void setValidateLoanResult(java.lang.String validateLoanResult) {
        this.validateLoanResult = validateLoanResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ValidateLoanResponse)) return false;
        ValidateLoanResponse other = (ValidateLoanResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.validateLoanResult==null && other.getValidateLoanResult()==null) || 
             (this.validateLoanResult!=null &&
              this.validateLoanResult.equals(other.getValidateLoanResult())));
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
        if (getValidateLoanResult() != null) {
            _hashCode += getValidateLoanResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ValidateLoanResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">ValidateLoanResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("validateLoanResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "ValidateLoanResult"));
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
