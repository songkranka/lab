/**
 * Supply_GetValueFinanceResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class Supply_GetValueFinanceResponse  implements java.io.Serializable {
    private org.tempuri.Supply_GetValueFinanceResponseSupply_GetValueFinanceResult supply_GetValueFinanceResult;

    public Supply_GetValueFinanceResponse() {
    }

    public Supply_GetValueFinanceResponse(
           org.tempuri.Supply_GetValueFinanceResponseSupply_GetValueFinanceResult supply_GetValueFinanceResult) {
           this.supply_GetValueFinanceResult = supply_GetValueFinanceResult;
    }


    /**
     * Gets the supply_GetValueFinanceResult value for this Supply_GetValueFinanceResponse.
     * 
     * @return supply_GetValueFinanceResult
     */
    public org.tempuri.Supply_GetValueFinanceResponseSupply_GetValueFinanceResult getSupply_GetValueFinanceResult() {
        return supply_GetValueFinanceResult;
    }


    /**
     * Sets the supply_GetValueFinanceResult value for this Supply_GetValueFinanceResponse.
     * 
     * @param supply_GetValueFinanceResult
     */
    public void setSupply_GetValueFinanceResult(org.tempuri.Supply_GetValueFinanceResponseSupply_GetValueFinanceResult supply_GetValueFinanceResult) {
        this.supply_GetValueFinanceResult = supply_GetValueFinanceResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Supply_GetValueFinanceResponse)) return false;
        Supply_GetValueFinanceResponse other = (Supply_GetValueFinanceResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.supply_GetValueFinanceResult==null && other.getSupply_GetValueFinanceResult()==null) || 
             (this.supply_GetValueFinanceResult!=null &&
              this.supply_GetValueFinanceResult.equals(other.getSupply_GetValueFinanceResult())));
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
        if (getSupply_GetValueFinanceResult() != null) {
            _hashCode += getSupply_GetValueFinanceResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Supply_GetValueFinanceResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">Supply_GetValueFinanceResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("supply_GetValueFinanceResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Supply_GetValueFinanceResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>Supply_GetValueFinanceResponse>Supply_GetValueFinanceResult"));
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
