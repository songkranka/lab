/**
 * UpdateInfPaymentFailedResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class UpdateInfPaymentFailedResponse  implements java.io.Serializable {
    private java.lang.String updateInfPaymentFailedResult;

    public UpdateInfPaymentFailedResponse() {
    }

    public UpdateInfPaymentFailedResponse(
           java.lang.String updateInfPaymentFailedResult) {
           this.updateInfPaymentFailedResult = updateInfPaymentFailedResult;
    }


    /**
     * Gets the updateInfPaymentFailedResult value for this UpdateInfPaymentFailedResponse.
     * 
     * @return updateInfPaymentFailedResult
     */
    public java.lang.String getUpdateInfPaymentFailedResult() {
        return updateInfPaymentFailedResult;
    }


    /**
     * Sets the updateInfPaymentFailedResult value for this UpdateInfPaymentFailedResponse.
     * 
     * @param updateInfPaymentFailedResult
     */
    public void setUpdateInfPaymentFailedResult(java.lang.String updateInfPaymentFailedResult) {
        this.updateInfPaymentFailedResult = updateInfPaymentFailedResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof UpdateInfPaymentFailedResponse)) return false;
        UpdateInfPaymentFailedResponse other = (UpdateInfPaymentFailedResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.updateInfPaymentFailedResult==null && other.getUpdateInfPaymentFailedResult()==null) || 
             (this.updateInfPaymentFailedResult!=null &&
              this.updateInfPaymentFailedResult.equals(other.getUpdateInfPaymentFailedResult())));
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
        if (getUpdateInfPaymentFailedResult() != null) {
            _hashCode += getUpdateInfPaymentFailedResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(UpdateInfPaymentFailedResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">UpdateInfPaymentFailedResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("updateInfPaymentFailedResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "UpdateInfPaymentFailedResult"));
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
