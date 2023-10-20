/**
 * Supply_CheckApMngPRResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class Supply_CheckApMngPRResponse  implements java.io.Serializable {
    private org.tempuri.Supply_CheckApMngPRResponseSupply_CheckApMngPRResult supply_CheckApMngPRResult;

    public Supply_CheckApMngPRResponse() {
    }

    public Supply_CheckApMngPRResponse(
           org.tempuri.Supply_CheckApMngPRResponseSupply_CheckApMngPRResult supply_CheckApMngPRResult) {
           this.supply_CheckApMngPRResult = supply_CheckApMngPRResult;
    }


    /**
     * Gets the supply_CheckApMngPRResult value for this Supply_CheckApMngPRResponse.
     * 
     * @return supply_CheckApMngPRResult
     */
    public org.tempuri.Supply_CheckApMngPRResponseSupply_CheckApMngPRResult getSupply_CheckApMngPRResult() {
        return supply_CheckApMngPRResult;
    }


    /**
     * Sets the supply_CheckApMngPRResult value for this Supply_CheckApMngPRResponse.
     * 
     * @param supply_CheckApMngPRResult
     */
    public void setSupply_CheckApMngPRResult(org.tempuri.Supply_CheckApMngPRResponseSupply_CheckApMngPRResult supply_CheckApMngPRResult) {
        this.supply_CheckApMngPRResult = supply_CheckApMngPRResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Supply_CheckApMngPRResponse)) return false;
        Supply_CheckApMngPRResponse other = (Supply_CheckApMngPRResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.supply_CheckApMngPRResult==null && other.getSupply_CheckApMngPRResult()==null) || 
             (this.supply_CheckApMngPRResult!=null &&
              this.supply_CheckApMngPRResult.equals(other.getSupply_CheckApMngPRResult())));
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
        if (getSupply_CheckApMngPRResult() != null) {
            _hashCode += getSupply_CheckApMngPRResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Supply_CheckApMngPRResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">Supply_CheckApMngPRResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("supply_CheckApMngPRResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Supply_CheckApMngPRResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>Supply_CheckApMngPRResponse>Supply_CheckApMngPRResult"));
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
