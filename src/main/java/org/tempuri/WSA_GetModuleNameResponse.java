/**
 * WSA_GetModuleNameResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class WSA_GetModuleNameResponse  implements java.io.Serializable {
    private org.tempuri.WSA_GetModuleNameResponseWSA_GetModuleNameResult WSA_GetModuleNameResult;

    public WSA_GetModuleNameResponse() {
    }

    public WSA_GetModuleNameResponse(
           org.tempuri.WSA_GetModuleNameResponseWSA_GetModuleNameResult WSA_GetModuleNameResult) {
           this.WSA_GetModuleNameResult = WSA_GetModuleNameResult;
    }


    /**
     * Gets the WSA_GetModuleNameResult value for this WSA_GetModuleNameResponse.
     * 
     * @return WSA_GetModuleNameResult
     */
    public org.tempuri.WSA_GetModuleNameResponseWSA_GetModuleNameResult getWSA_GetModuleNameResult() {
        return WSA_GetModuleNameResult;
    }


    /**
     * Sets the WSA_GetModuleNameResult value for this WSA_GetModuleNameResponse.
     * 
     * @param WSA_GetModuleNameResult
     */
    public void setWSA_GetModuleNameResult(org.tempuri.WSA_GetModuleNameResponseWSA_GetModuleNameResult WSA_GetModuleNameResult) {
        this.WSA_GetModuleNameResult = WSA_GetModuleNameResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WSA_GetModuleNameResponse)) return false;
        WSA_GetModuleNameResponse other = (WSA_GetModuleNameResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.WSA_GetModuleNameResult==null && other.getWSA_GetModuleNameResult()==null) || 
             (this.WSA_GetModuleNameResult!=null &&
              this.WSA_GetModuleNameResult.equals(other.getWSA_GetModuleNameResult())));
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
        if (getWSA_GetModuleNameResult() != null) {
            _hashCode += getWSA_GetModuleNameResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WSA_GetModuleNameResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">WSA_GetModuleNameResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("WSA_GetModuleNameResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "WSA_GetModuleNameResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>WSA_GetModuleNameResponse>WSA_GetModuleNameResult"));
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
