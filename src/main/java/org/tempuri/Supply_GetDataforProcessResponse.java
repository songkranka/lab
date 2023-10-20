/**
 * Supply_GetDataforProcessResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class Supply_GetDataforProcessResponse  implements java.io.Serializable {
    private org.tempuri.Supply_GetDataforProcessResponseSupply_GetDataforProcessResult supply_GetDataforProcessResult;

    public Supply_GetDataforProcessResponse() {
    }

    public Supply_GetDataforProcessResponse(
           org.tempuri.Supply_GetDataforProcessResponseSupply_GetDataforProcessResult supply_GetDataforProcessResult) {
           this.supply_GetDataforProcessResult = supply_GetDataforProcessResult;
    }


    /**
     * Gets the supply_GetDataforProcessResult value for this Supply_GetDataforProcessResponse.
     * 
     * @return supply_GetDataforProcessResult
     */
    public org.tempuri.Supply_GetDataforProcessResponseSupply_GetDataforProcessResult getSupply_GetDataforProcessResult() {
        return supply_GetDataforProcessResult;
    }


    /**
     * Sets the supply_GetDataforProcessResult value for this Supply_GetDataforProcessResponse.
     * 
     * @param supply_GetDataforProcessResult
     */
    public void setSupply_GetDataforProcessResult(org.tempuri.Supply_GetDataforProcessResponseSupply_GetDataforProcessResult supply_GetDataforProcessResult) {
        this.supply_GetDataforProcessResult = supply_GetDataforProcessResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Supply_GetDataforProcessResponse)) return false;
        Supply_GetDataforProcessResponse other = (Supply_GetDataforProcessResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.supply_GetDataforProcessResult==null && other.getSupply_GetDataforProcessResult()==null) || 
             (this.supply_GetDataforProcessResult!=null &&
              this.supply_GetDataforProcessResult.equals(other.getSupply_GetDataforProcessResult())));
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
        if (getSupply_GetDataforProcessResult() != null) {
            _hashCode += getSupply_GetDataforProcessResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Supply_GetDataforProcessResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">Supply_GetDataforProcessResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("supply_GetDataforProcessResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Supply_GetDataforProcessResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>Supply_GetDataforProcessResponse>Supply_GetDataforProcessResult"));
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
