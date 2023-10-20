/**
 * Supply_GetValueOilSupplyResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class Supply_GetValueOilSupplyResponse  implements java.io.Serializable {
    private org.tempuri.Supply_GetValueOilSupplyResponseSupply_GetValueOilSupplyResult supply_GetValueOilSupplyResult;

    public Supply_GetValueOilSupplyResponse() {
    }

    public Supply_GetValueOilSupplyResponse(
           org.tempuri.Supply_GetValueOilSupplyResponseSupply_GetValueOilSupplyResult supply_GetValueOilSupplyResult) {
           this.supply_GetValueOilSupplyResult = supply_GetValueOilSupplyResult;
    }


    /**
     * Gets the supply_GetValueOilSupplyResult value for this Supply_GetValueOilSupplyResponse.
     * 
     * @return supply_GetValueOilSupplyResult
     */
    public org.tempuri.Supply_GetValueOilSupplyResponseSupply_GetValueOilSupplyResult getSupply_GetValueOilSupplyResult() {
        return supply_GetValueOilSupplyResult;
    }


    /**
     * Sets the supply_GetValueOilSupplyResult value for this Supply_GetValueOilSupplyResponse.
     * 
     * @param supply_GetValueOilSupplyResult
     */
    public void setSupply_GetValueOilSupplyResult(org.tempuri.Supply_GetValueOilSupplyResponseSupply_GetValueOilSupplyResult supply_GetValueOilSupplyResult) {
        this.supply_GetValueOilSupplyResult = supply_GetValueOilSupplyResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Supply_GetValueOilSupplyResponse)) return false;
        Supply_GetValueOilSupplyResponse other = (Supply_GetValueOilSupplyResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.supply_GetValueOilSupplyResult==null && other.getSupply_GetValueOilSupplyResult()==null) || 
             (this.supply_GetValueOilSupplyResult!=null &&
              this.supply_GetValueOilSupplyResult.equals(other.getSupply_GetValueOilSupplyResult())));
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
        if (getSupply_GetValueOilSupplyResult() != null) {
            _hashCode += getSupply_GetValueOilSupplyResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Supply_GetValueOilSupplyResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">Supply_GetValueOilSupplyResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("supply_GetValueOilSupplyResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Supply_GetValueOilSupplyResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>Supply_GetValueOilSupplyResponse>Supply_GetValueOilSupplyResult"));
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
