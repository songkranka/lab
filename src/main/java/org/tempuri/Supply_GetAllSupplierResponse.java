/**
 * Supply_GetAllSupplierResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class Supply_GetAllSupplierResponse  implements java.io.Serializable {
    private org.tempuri.Supply_GetAllSupplierResponseSupply_GetAllSupplierResult supply_GetAllSupplierResult;

    public Supply_GetAllSupplierResponse() {
    }

    public Supply_GetAllSupplierResponse(
           org.tempuri.Supply_GetAllSupplierResponseSupply_GetAllSupplierResult supply_GetAllSupplierResult) {
           this.supply_GetAllSupplierResult = supply_GetAllSupplierResult;
    }


    /**
     * Gets the supply_GetAllSupplierResult value for this Supply_GetAllSupplierResponse.
     * 
     * @return supply_GetAllSupplierResult
     */
    public org.tempuri.Supply_GetAllSupplierResponseSupply_GetAllSupplierResult getSupply_GetAllSupplierResult() {
        return supply_GetAllSupplierResult;
    }


    /**
     * Sets the supply_GetAllSupplierResult value for this Supply_GetAllSupplierResponse.
     * 
     * @param supply_GetAllSupplierResult
     */
    public void setSupply_GetAllSupplierResult(org.tempuri.Supply_GetAllSupplierResponseSupply_GetAllSupplierResult supply_GetAllSupplierResult) {
        this.supply_GetAllSupplierResult = supply_GetAllSupplierResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Supply_GetAllSupplierResponse)) return false;
        Supply_GetAllSupplierResponse other = (Supply_GetAllSupplierResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.supply_GetAllSupplierResult==null && other.getSupply_GetAllSupplierResult()==null) || 
             (this.supply_GetAllSupplierResult!=null &&
              this.supply_GetAllSupplierResult.equals(other.getSupply_GetAllSupplierResult())));
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
        if (getSupply_GetAllSupplierResult() != null) {
            _hashCode += getSupply_GetAllSupplierResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Supply_GetAllSupplierResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">Supply_GetAllSupplierResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("supply_GetAllSupplierResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Supply_GetAllSupplierResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>Supply_GetAllSupplierResponse>Supply_GetAllSupplierResult"));
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
