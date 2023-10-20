/**
 * WSA_GetAcessControlResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class WSA_GetAcessControlResponse  implements java.io.Serializable {
    private org.tempuri.WSA_GetAcessControlResponseWSA_GetAcessControlResult WSA_GetAcessControlResult;

    public WSA_GetAcessControlResponse() {
    }

    public WSA_GetAcessControlResponse(
           org.tempuri.WSA_GetAcessControlResponseWSA_GetAcessControlResult WSA_GetAcessControlResult) {
           this.WSA_GetAcessControlResult = WSA_GetAcessControlResult;
    }


    /**
     * Gets the WSA_GetAcessControlResult value for this WSA_GetAcessControlResponse.
     * 
     * @return WSA_GetAcessControlResult
     */
    public org.tempuri.WSA_GetAcessControlResponseWSA_GetAcessControlResult getWSA_GetAcessControlResult() {
        return WSA_GetAcessControlResult;
    }


    /**
     * Sets the WSA_GetAcessControlResult value for this WSA_GetAcessControlResponse.
     * 
     * @param WSA_GetAcessControlResult
     */
    public void setWSA_GetAcessControlResult(org.tempuri.WSA_GetAcessControlResponseWSA_GetAcessControlResult WSA_GetAcessControlResult) {
        this.WSA_GetAcessControlResult = WSA_GetAcessControlResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WSA_GetAcessControlResponse)) return false;
        WSA_GetAcessControlResponse other = (WSA_GetAcessControlResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.WSA_GetAcessControlResult==null && other.getWSA_GetAcessControlResult()==null) || 
             (this.WSA_GetAcessControlResult!=null &&
              this.WSA_GetAcessControlResult.equals(other.getWSA_GetAcessControlResult())));
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
        if (getWSA_GetAcessControlResult() != null) {
            _hashCode += getWSA_GetAcessControlResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WSA_GetAcessControlResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">WSA_GetAcessControlResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("WSA_GetAcessControlResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "WSA_GetAcessControlResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>WSA_GetAcessControlResponse>WSA_GetAcessControlResult"));
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
