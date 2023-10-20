/**
 * Supply_GetSupplierResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class Supply_GetSupplierResponse  implements java.io.Serializable {
    private org.tempuri.Supply_GetSupplierResponseSupply_GetSupplierResult supply_GetSupplierResult;

    public Supply_GetSupplierResponse() {
    }

    public Supply_GetSupplierResponse(
           org.tempuri.Supply_GetSupplierResponseSupply_GetSupplierResult supply_GetSupplierResult) {
           this.supply_GetSupplierResult = supply_GetSupplierResult;
    }


    /**
     * Gets the supply_GetSupplierResult value for this Supply_GetSupplierResponse.
     * 
     * @return supply_GetSupplierResult
     */
    public org.tempuri.Supply_GetSupplierResponseSupply_GetSupplierResult getSupply_GetSupplierResult() {
        return supply_GetSupplierResult;
    }


    /**
     * Sets the supply_GetSupplierResult value for this Supply_GetSupplierResponse.
     * 
     * @param supply_GetSupplierResult
     */
    public void setSupply_GetSupplierResult(org.tempuri.Supply_GetSupplierResponseSupply_GetSupplierResult supply_GetSupplierResult) {
        this.supply_GetSupplierResult = supply_GetSupplierResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Supply_GetSupplierResponse)) return false;
        Supply_GetSupplierResponse other = (Supply_GetSupplierResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.supply_GetSupplierResult==null && other.getSupply_GetSupplierResult()==null) || 
             (this.supply_GetSupplierResult!=null &&
              this.supply_GetSupplierResult.equals(other.getSupply_GetSupplierResult())));
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
        if (getSupply_GetSupplierResult() != null) {
            _hashCode += getSupply_GetSupplierResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Supply_GetSupplierResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">Supply_GetSupplierResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("supply_GetSupplierResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Supply_GetSupplierResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>Supply_GetSupplierResponse>Supply_GetSupplierResult"));
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
