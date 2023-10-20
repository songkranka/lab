/**
 * PUN_BUY_InterfaceAXResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class PUN_BUY_InterfaceAXResponse  implements java.io.Serializable {
    private java.lang.String PUN_BUY_InterfaceAXResult;

    public PUN_BUY_InterfaceAXResponse() {
    }

    public PUN_BUY_InterfaceAXResponse(
           java.lang.String PUN_BUY_InterfaceAXResult) {
           this.PUN_BUY_InterfaceAXResult = PUN_BUY_InterfaceAXResult;
    }


    /**
     * Gets the PUN_BUY_InterfaceAXResult value for this PUN_BUY_InterfaceAXResponse.
     * 
     * @return PUN_BUY_InterfaceAXResult
     */
    public java.lang.String getPUN_BUY_InterfaceAXResult() {
        return PUN_BUY_InterfaceAXResult;
    }


    /**
     * Sets the PUN_BUY_InterfaceAXResult value for this PUN_BUY_InterfaceAXResponse.
     * 
     * @param PUN_BUY_InterfaceAXResult
     */
    public void setPUN_BUY_InterfaceAXResult(java.lang.String PUN_BUY_InterfaceAXResult) {
        this.PUN_BUY_InterfaceAXResult = PUN_BUY_InterfaceAXResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PUN_BUY_InterfaceAXResponse)) return false;
        PUN_BUY_InterfaceAXResponse other = (PUN_BUY_InterfaceAXResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.PUN_BUY_InterfaceAXResult==null && other.getPUN_BUY_InterfaceAXResult()==null) || 
             (this.PUN_BUY_InterfaceAXResult!=null &&
              this.PUN_BUY_InterfaceAXResult.equals(other.getPUN_BUY_InterfaceAXResult())));
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
        if (getPUN_BUY_InterfaceAXResult() != null) {
            _hashCode += getPUN_BUY_InterfaceAXResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PUN_BUY_InterfaceAXResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">PUN_BUY_InterfaceAXResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PUN_BUY_InterfaceAXResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "PUN_BUY_InterfaceAXResult"));
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
