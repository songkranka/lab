/**
 * WSA_GetSystemDataResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class WSA_GetSystemDataResponse  implements java.io.Serializable {
    private org.tempuri.WSA_GetSystemDataResponseWSA_GetSystemDataResult WSA_GetSystemDataResult;

    public WSA_GetSystemDataResponse() {
    }

    public WSA_GetSystemDataResponse(
           org.tempuri.WSA_GetSystemDataResponseWSA_GetSystemDataResult WSA_GetSystemDataResult) {
           this.WSA_GetSystemDataResult = WSA_GetSystemDataResult;
    }


    /**
     * Gets the WSA_GetSystemDataResult value for this WSA_GetSystemDataResponse.
     * 
     * @return WSA_GetSystemDataResult
     */
    public org.tempuri.WSA_GetSystemDataResponseWSA_GetSystemDataResult getWSA_GetSystemDataResult() {
        return WSA_GetSystemDataResult;
    }


    /**
     * Sets the WSA_GetSystemDataResult value for this WSA_GetSystemDataResponse.
     * 
     * @param WSA_GetSystemDataResult
     */
    public void setWSA_GetSystemDataResult(org.tempuri.WSA_GetSystemDataResponseWSA_GetSystemDataResult WSA_GetSystemDataResult) {
        this.WSA_GetSystemDataResult = WSA_GetSystemDataResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WSA_GetSystemDataResponse)) return false;
        WSA_GetSystemDataResponse other = (WSA_GetSystemDataResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.WSA_GetSystemDataResult==null && other.getWSA_GetSystemDataResult()==null) || 
             (this.WSA_GetSystemDataResult!=null &&
              this.WSA_GetSystemDataResult.equals(other.getWSA_GetSystemDataResult())));
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
        if (getWSA_GetSystemDataResult() != null) {
            _hashCode += getWSA_GetSystemDataResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WSA_GetSystemDataResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">WSA_GetSystemDataResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("WSA_GetSystemDataResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "WSA_GetSystemDataResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>WSA_GetSystemDataResponse>WSA_GetSystemDataResult"));
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
