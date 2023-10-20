/**
 * Supply_GetMrPrFinanceResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class Supply_GetMrPrFinanceResponse  implements java.io.Serializable {
    private org.tempuri.Supply_GetMrPrFinanceResponseSupply_GetMrPrFinanceResult supply_GetMrPrFinanceResult;

    public Supply_GetMrPrFinanceResponse() {
    }

    public Supply_GetMrPrFinanceResponse(
           org.tempuri.Supply_GetMrPrFinanceResponseSupply_GetMrPrFinanceResult supply_GetMrPrFinanceResult) {
           this.supply_GetMrPrFinanceResult = supply_GetMrPrFinanceResult;
    }


    /**
     * Gets the supply_GetMrPrFinanceResult value for this Supply_GetMrPrFinanceResponse.
     * 
     * @return supply_GetMrPrFinanceResult
     */
    public org.tempuri.Supply_GetMrPrFinanceResponseSupply_GetMrPrFinanceResult getSupply_GetMrPrFinanceResult() {
        return supply_GetMrPrFinanceResult;
    }


    /**
     * Sets the supply_GetMrPrFinanceResult value for this Supply_GetMrPrFinanceResponse.
     * 
     * @param supply_GetMrPrFinanceResult
     */
    public void setSupply_GetMrPrFinanceResult(org.tempuri.Supply_GetMrPrFinanceResponseSupply_GetMrPrFinanceResult supply_GetMrPrFinanceResult) {
        this.supply_GetMrPrFinanceResult = supply_GetMrPrFinanceResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Supply_GetMrPrFinanceResponse)) return false;
        Supply_GetMrPrFinanceResponse other = (Supply_GetMrPrFinanceResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.supply_GetMrPrFinanceResult==null && other.getSupply_GetMrPrFinanceResult()==null) || 
             (this.supply_GetMrPrFinanceResult!=null &&
              this.supply_GetMrPrFinanceResult.equals(other.getSupply_GetMrPrFinanceResult())));
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
        if (getSupply_GetMrPrFinanceResult() != null) {
            _hashCode += getSupply_GetMrPrFinanceResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Supply_GetMrPrFinanceResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">Supply_GetMrPrFinanceResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("supply_GetMrPrFinanceResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Supply_GetMrPrFinanceResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>Supply_GetMrPrFinanceResponse>Supply_GetMrPrFinanceResult"));
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
