/**
 * UpdateInfPaymentSuccessResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class UpdateInfPaymentSuccessResponse  implements java.io.Serializable {
    private java.lang.String updateInfPaymentSuccessResult;

    public UpdateInfPaymentSuccessResponse() {
    }

    public UpdateInfPaymentSuccessResponse(
           java.lang.String updateInfPaymentSuccessResult) {
           this.updateInfPaymentSuccessResult = updateInfPaymentSuccessResult;
    }


    /**
     * Gets the updateInfPaymentSuccessResult value for this UpdateInfPaymentSuccessResponse.
     * 
     * @return updateInfPaymentSuccessResult
     */
    public java.lang.String getUpdateInfPaymentSuccessResult() {
        return updateInfPaymentSuccessResult;
    }


    /**
     * Sets the updateInfPaymentSuccessResult value for this UpdateInfPaymentSuccessResponse.
     * 
     * @param updateInfPaymentSuccessResult
     */
    public void setUpdateInfPaymentSuccessResult(java.lang.String updateInfPaymentSuccessResult) {
        this.updateInfPaymentSuccessResult = updateInfPaymentSuccessResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof UpdateInfPaymentSuccessResponse)) return false;
        UpdateInfPaymentSuccessResponse other = (UpdateInfPaymentSuccessResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.updateInfPaymentSuccessResult==null && other.getUpdateInfPaymentSuccessResult()==null) || 
             (this.updateInfPaymentSuccessResult!=null &&
              this.updateInfPaymentSuccessResult.equals(other.getUpdateInfPaymentSuccessResult())));
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
        if (getUpdateInfPaymentSuccessResult() != null) {
            _hashCode += getUpdateInfPaymentSuccessResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(UpdateInfPaymentSuccessResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">UpdateInfPaymentSuccessResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("updateInfPaymentSuccessResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "UpdateInfPaymentSuccessResult"));
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
