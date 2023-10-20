/**
 * PUN_SELL_InterfaceAXResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class PUN_SELL_InterfaceAXResponse  implements java.io.Serializable {
    private java.lang.String PUN_SELL_InterfaceAXResult;

    public PUN_SELL_InterfaceAXResponse() {
    }

    public PUN_SELL_InterfaceAXResponse(
           java.lang.String PUN_SELL_InterfaceAXResult) {
           this.PUN_SELL_InterfaceAXResult = PUN_SELL_InterfaceAXResult;
    }


    /**
     * Gets the PUN_SELL_InterfaceAXResult value for this PUN_SELL_InterfaceAXResponse.
     * 
     * @return PUN_SELL_InterfaceAXResult
     */
    public java.lang.String getPUN_SELL_InterfaceAXResult() {
        return PUN_SELL_InterfaceAXResult;
    }


    /**
     * Sets the PUN_SELL_InterfaceAXResult value for this PUN_SELL_InterfaceAXResponse.
     * 
     * @param PUN_SELL_InterfaceAXResult
     */
    public void setPUN_SELL_InterfaceAXResult(java.lang.String PUN_SELL_InterfaceAXResult) {
        this.PUN_SELL_InterfaceAXResult = PUN_SELL_InterfaceAXResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PUN_SELL_InterfaceAXResponse)) return false;
        PUN_SELL_InterfaceAXResponse other = (PUN_SELL_InterfaceAXResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.PUN_SELL_InterfaceAXResult==null && other.getPUN_SELL_InterfaceAXResult()==null) || 
             (this.PUN_SELL_InterfaceAXResult!=null &&
              this.PUN_SELL_InterfaceAXResult.equals(other.getPUN_SELL_InterfaceAXResult())));
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
        if (getPUN_SELL_InterfaceAXResult() != null) {
            _hashCode += getPUN_SELL_InterfaceAXResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PUN_SELL_InterfaceAXResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">PUN_SELL_InterfaceAXResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PUN_SELL_InterfaceAXResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "PUN_SELL_InterfaceAXResult"));
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
