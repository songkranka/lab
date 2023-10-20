/**
 * Supply_GetFinanceResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class Supply_GetFinanceResponse  implements java.io.Serializable {
    private org.tempuri.Supply_GetFinanceResponseSupply_GetFinanceResult supply_GetFinanceResult;

    public Supply_GetFinanceResponse() {
    }

    public Supply_GetFinanceResponse(
           org.tempuri.Supply_GetFinanceResponseSupply_GetFinanceResult supply_GetFinanceResult) {
           this.supply_GetFinanceResult = supply_GetFinanceResult;
    }


    /**
     * Gets the supply_GetFinanceResult value for this Supply_GetFinanceResponse.
     * 
     * @return supply_GetFinanceResult
     */
    public org.tempuri.Supply_GetFinanceResponseSupply_GetFinanceResult getSupply_GetFinanceResult() {
        return supply_GetFinanceResult;
    }


    /**
     * Sets the supply_GetFinanceResult value for this Supply_GetFinanceResponse.
     * 
     * @param supply_GetFinanceResult
     */
    public void setSupply_GetFinanceResult(org.tempuri.Supply_GetFinanceResponseSupply_GetFinanceResult supply_GetFinanceResult) {
        this.supply_GetFinanceResult = supply_GetFinanceResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Supply_GetFinanceResponse)) return false;
        Supply_GetFinanceResponse other = (Supply_GetFinanceResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.supply_GetFinanceResult==null && other.getSupply_GetFinanceResult()==null) || 
             (this.supply_GetFinanceResult!=null &&
              this.supply_GetFinanceResult.equals(other.getSupply_GetFinanceResult())));
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
        if (getSupply_GetFinanceResult() != null) {
            _hashCode += getSupply_GetFinanceResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Supply_GetFinanceResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">Supply_GetFinanceResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("supply_GetFinanceResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Supply_GetFinanceResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>Supply_GetFinanceResponse>Supply_GetFinanceResult"));
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
