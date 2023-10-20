/**
 * WSA_GetModuleDataResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class WSA_GetModuleDataResponse  implements java.io.Serializable {
    private org.tempuri.WSA_GetModuleDataResponseWSA_GetModuleDataResult WSA_GetModuleDataResult;

    public WSA_GetModuleDataResponse() {
    }

    public WSA_GetModuleDataResponse(
           org.tempuri.WSA_GetModuleDataResponseWSA_GetModuleDataResult WSA_GetModuleDataResult) {
           this.WSA_GetModuleDataResult = WSA_GetModuleDataResult;
    }


    /**
     * Gets the WSA_GetModuleDataResult value for this WSA_GetModuleDataResponse.
     * 
     * @return WSA_GetModuleDataResult
     */
    public org.tempuri.WSA_GetModuleDataResponseWSA_GetModuleDataResult getWSA_GetModuleDataResult() {
        return WSA_GetModuleDataResult;
    }


    /**
     * Sets the WSA_GetModuleDataResult value for this WSA_GetModuleDataResponse.
     * 
     * @param WSA_GetModuleDataResult
     */
    public void setWSA_GetModuleDataResult(org.tempuri.WSA_GetModuleDataResponseWSA_GetModuleDataResult WSA_GetModuleDataResult) {
        this.WSA_GetModuleDataResult = WSA_GetModuleDataResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WSA_GetModuleDataResponse)) return false;
        WSA_GetModuleDataResponse other = (WSA_GetModuleDataResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.WSA_GetModuleDataResult==null && other.getWSA_GetModuleDataResult()==null) || 
             (this.WSA_GetModuleDataResult!=null &&
              this.WSA_GetModuleDataResult.equals(other.getWSA_GetModuleDataResult())));
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
        if (getWSA_GetModuleDataResult() != null) {
            _hashCode += getWSA_GetModuleDataResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WSA_GetModuleDataResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">WSA_GetModuleDataResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("WSA_GetModuleDataResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "WSA_GetModuleDataResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>WSA_GetModuleDataResponse>WSA_GetModuleDataResult"));
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
