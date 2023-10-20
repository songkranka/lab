/**
 * PUN_BUY_GET_GL_DATAResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class PUN_BUY_GET_GL_DATAResponse  implements java.io.Serializable {
    private java.lang.String PUN_BUY_GET_GL_DATAResult;

    public PUN_BUY_GET_GL_DATAResponse() {
    }

    public PUN_BUY_GET_GL_DATAResponse(
           java.lang.String PUN_BUY_GET_GL_DATAResult) {
           this.PUN_BUY_GET_GL_DATAResult = PUN_BUY_GET_GL_DATAResult;
    }


    /**
     * Gets the PUN_BUY_GET_GL_DATAResult value for this PUN_BUY_GET_GL_DATAResponse.
     * 
     * @return PUN_BUY_GET_GL_DATAResult
     */
    public java.lang.String getPUN_BUY_GET_GL_DATAResult() {
        return PUN_BUY_GET_GL_DATAResult;
    }


    /**
     * Sets the PUN_BUY_GET_GL_DATAResult value for this PUN_BUY_GET_GL_DATAResponse.
     * 
     * @param PUN_BUY_GET_GL_DATAResult
     */
    public void setPUN_BUY_GET_GL_DATAResult(java.lang.String PUN_BUY_GET_GL_DATAResult) {
        this.PUN_BUY_GET_GL_DATAResult = PUN_BUY_GET_GL_DATAResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PUN_BUY_GET_GL_DATAResponse)) return false;
        PUN_BUY_GET_GL_DATAResponse other = (PUN_BUY_GET_GL_DATAResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.PUN_BUY_GET_GL_DATAResult==null && other.getPUN_BUY_GET_GL_DATAResult()==null) || 
             (this.PUN_BUY_GET_GL_DATAResult!=null &&
              this.PUN_BUY_GET_GL_DATAResult.equals(other.getPUN_BUY_GET_GL_DATAResult())));
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
        if (getPUN_BUY_GET_GL_DATAResult() != null) {
            _hashCode += getPUN_BUY_GET_GL_DATAResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PUN_BUY_GET_GL_DATAResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">PUN_BUY_GET_GL_DATAResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PUN_BUY_GET_GL_DATAResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "PUN_BUY_GET_GL_DATAResult"));
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
