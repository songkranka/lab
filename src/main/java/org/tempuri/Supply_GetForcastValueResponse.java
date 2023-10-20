/**
 * Supply_GetForcastValueResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class Supply_GetForcastValueResponse  implements java.io.Serializable {
    private org.tempuri.Supply_GetForcastValueResponseSupply_GetForcastValueResult supply_GetForcastValueResult;

    public Supply_GetForcastValueResponse() {
    }

    public Supply_GetForcastValueResponse(
           org.tempuri.Supply_GetForcastValueResponseSupply_GetForcastValueResult supply_GetForcastValueResult) {
           this.supply_GetForcastValueResult = supply_GetForcastValueResult;
    }


    /**
     * Gets the supply_GetForcastValueResult value for this Supply_GetForcastValueResponse.
     * 
     * @return supply_GetForcastValueResult
     */
    public org.tempuri.Supply_GetForcastValueResponseSupply_GetForcastValueResult getSupply_GetForcastValueResult() {
        return supply_GetForcastValueResult;
    }


    /**
     * Sets the supply_GetForcastValueResult value for this Supply_GetForcastValueResponse.
     * 
     * @param supply_GetForcastValueResult
     */
    public void setSupply_GetForcastValueResult(org.tempuri.Supply_GetForcastValueResponseSupply_GetForcastValueResult supply_GetForcastValueResult) {
        this.supply_GetForcastValueResult = supply_GetForcastValueResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Supply_GetForcastValueResponse)) return false;
        Supply_GetForcastValueResponse other = (Supply_GetForcastValueResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.supply_GetForcastValueResult==null && other.getSupply_GetForcastValueResult()==null) || 
             (this.supply_GetForcastValueResult!=null &&
              this.supply_GetForcastValueResult.equals(other.getSupply_GetForcastValueResult())));
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
        if (getSupply_GetForcastValueResult() != null) {
            _hashCode += getSupply_GetForcastValueResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Supply_GetForcastValueResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">Supply_GetForcastValueResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("supply_GetForcastValueResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Supply_GetForcastValueResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>Supply_GetForcastValueResponse>Supply_GetForcastValueResult"));
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
