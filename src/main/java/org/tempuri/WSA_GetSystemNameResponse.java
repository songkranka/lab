/**
 * WSA_GetSystemNameResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class WSA_GetSystemNameResponse  implements java.io.Serializable {
    private org.tempuri.WSA_GetSystemNameResponseWSA_GetSystemNameResult WSA_GetSystemNameResult;

    public WSA_GetSystemNameResponse() {
    }

    public WSA_GetSystemNameResponse(
           org.tempuri.WSA_GetSystemNameResponseWSA_GetSystemNameResult WSA_GetSystemNameResult) {
           this.WSA_GetSystemNameResult = WSA_GetSystemNameResult;
    }


    /**
     * Gets the WSA_GetSystemNameResult value for this WSA_GetSystemNameResponse.
     * 
     * @return WSA_GetSystemNameResult
     */
    public org.tempuri.WSA_GetSystemNameResponseWSA_GetSystemNameResult getWSA_GetSystemNameResult() {
        return WSA_GetSystemNameResult;
    }


    /**
     * Sets the WSA_GetSystemNameResult value for this WSA_GetSystemNameResponse.
     * 
     * @param WSA_GetSystemNameResult
     */
    public void setWSA_GetSystemNameResult(org.tempuri.WSA_GetSystemNameResponseWSA_GetSystemNameResult WSA_GetSystemNameResult) {
        this.WSA_GetSystemNameResult = WSA_GetSystemNameResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WSA_GetSystemNameResponse)) return false;
        WSA_GetSystemNameResponse other = (WSA_GetSystemNameResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.WSA_GetSystemNameResult==null && other.getWSA_GetSystemNameResult()==null) || 
             (this.WSA_GetSystemNameResult!=null &&
              this.WSA_GetSystemNameResult.equals(other.getWSA_GetSystemNameResult())));
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
        if (getWSA_GetSystemNameResult() != null) {
            _hashCode += getWSA_GetSystemNameResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WSA_GetSystemNameResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">WSA_GetSystemNameResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("WSA_GetSystemNameResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "WSA_GetSystemNameResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>WSA_GetSystemNameResponse>WSA_GetSystemNameResult"));
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
