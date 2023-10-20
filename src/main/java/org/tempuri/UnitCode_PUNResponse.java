/**
 * UnitCode_PUNResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class UnitCode_PUNResponse  implements java.io.Serializable {
    private java.lang.String unitCode_PUNResult;

    public UnitCode_PUNResponse() {
    }

    public UnitCode_PUNResponse(
           java.lang.String unitCode_PUNResult) {
           this.unitCode_PUNResult = unitCode_PUNResult;
    }


    /**
     * Gets the unitCode_PUNResult value for this UnitCode_PUNResponse.
     * 
     * @return unitCode_PUNResult
     */
    public java.lang.String getUnitCode_PUNResult() {
        return unitCode_PUNResult;
    }


    /**
     * Sets the unitCode_PUNResult value for this UnitCode_PUNResponse.
     * 
     * @param unitCode_PUNResult
     */
    public void setUnitCode_PUNResult(java.lang.String unitCode_PUNResult) {
        this.unitCode_PUNResult = unitCode_PUNResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof UnitCode_PUNResponse)) return false;
        UnitCode_PUNResponse other = (UnitCode_PUNResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.unitCode_PUNResult==null && other.getUnitCode_PUNResult()==null) || 
             (this.unitCode_PUNResult!=null &&
              this.unitCode_PUNResult.equals(other.getUnitCode_PUNResult())));
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
        if (getUnitCode_PUNResult() != null) {
            _hashCode += getUnitCode_PUNResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(UnitCode_PUNResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">UnitCode_PUNResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("unitCode_PUNResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "UnitCode_PUNResult"));
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
