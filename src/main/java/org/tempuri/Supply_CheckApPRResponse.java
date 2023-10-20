/**
 * Supply_CheckApPRResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class Supply_CheckApPRResponse  implements java.io.Serializable {
    private java.lang.String supply_CheckApPRResult;

    public Supply_CheckApPRResponse() {
    }

    public Supply_CheckApPRResponse(
           java.lang.String supply_CheckApPRResult) {
           this.supply_CheckApPRResult = supply_CheckApPRResult;
    }


    /**
     * Gets the supply_CheckApPRResult value for this Supply_CheckApPRResponse.
     * 
     * @return supply_CheckApPRResult
     */
    public java.lang.String getSupply_CheckApPRResult() {
        return supply_CheckApPRResult;
    }


    /**
     * Sets the supply_CheckApPRResult value for this Supply_CheckApPRResponse.
     * 
     * @param supply_CheckApPRResult
     */
    public void setSupply_CheckApPRResult(java.lang.String supply_CheckApPRResult) {
        this.supply_CheckApPRResult = supply_CheckApPRResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Supply_CheckApPRResponse)) return false;
        Supply_CheckApPRResponse other = (Supply_CheckApPRResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.supply_CheckApPRResult==null && other.getSupply_CheckApPRResult()==null) || 
             (this.supply_CheckApPRResult!=null &&
              this.supply_CheckApPRResult.equals(other.getSupply_CheckApPRResult())));
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
        if (getSupply_CheckApPRResult() != null) {
            _hashCode += getSupply_CheckApPRResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Supply_CheckApPRResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">Supply_CheckApPRResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("supply_CheckApPRResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Supply_CheckApPRResult"));
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
