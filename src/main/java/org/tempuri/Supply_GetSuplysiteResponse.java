/**
 * Supply_GetSuplysiteResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class Supply_GetSuplysiteResponse  implements java.io.Serializable {
    private org.tempuri.Supply_GetSuplysiteResponseSupply_GetSuplysiteResult supply_GetSuplysiteResult;

    public Supply_GetSuplysiteResponse() {
    }

    public Supply_GetSuplysiteResponse(
           org.tempuri.Supply_GetSuplysiteResponseSupply_GetSuplysiteResult supply_GetSuplysiteResult) {
           this.supply_GetSuplysiteResult = supply_GetSuplysiteResult;
    }


    /**
     * Gets the supply_GetSuplysiteResult value for this Supply_GetSuplysiteResponse.
     * 
     * @return supply_GetSuplysiteResult
     */
    public org.tempuri.Supply_GetSuplysiteResponseSupply_GetSuplysiteResult getSupply_GetSuplysiteResult() {
        return supply_GetSuplysiteResult;
    }


    /**
     * Sets the supply_GetSuplysiteResult value for this Supply_GetSuplysiteResponse.
     * 
     * @param supply_GetSuplysiteResult
     */
    public void setSupply_GetSuplysiteResult(org.tempuri.Supply_GetSuplysiteResponseSupply_GetSuplysiteResult supply_GetSuplysiteResult) {
        this.supply_GetSuplysiteResult = supply_GetSuplysiteResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Supply_GetSuplysiteResponse)) return false;
        Supply_GetSuplysiteResponse other = (Supply_GetSuplysiteResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.supply_GetSuplysiteResult==null && other.getSupply_GetSuplysiteResult()==null) || 
             (this.supply_GetSuplysiteResult!=null &&
              this.supply_GetSuplysiteResult.equals(other.getSupply_GetSuplysiteResult())));
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
        if (getSupply_GetSuplysiteResult() != null) {
            _hashCode += getSupply_GetSuplysiteResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Supply_GetSuplysiteResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">Supply_GetSuplysiteResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("supply_GetSuplysiteResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Supply_GetSuplysiteResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>Supply_GetSuplysiteResponse>Supply_GetSuplysiteResult"));
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
