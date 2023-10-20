/**
 * LoReadcusResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class LoReadcusResponse  implements java.io.Serializable {
    private org.tempuri.LoReadcusResponseLoReadcusResult loReadcusResult;

    public LoReadcusResponse() {
    }

    public LoReadcusResponse(
           org.tempuri.LoReadcusResponseLoReadcusResult loReadcusResult) {
           this.loReadcusResult = loReadcusResult;
    }


    /**
     * Gets the loReadcusResult value for this LoReadcusResponse.
     * 
     * @return loReadcusResult
     */
    public org.tempuri.LoReadcusResponseLoReadcusResult getLoReadcusResult() {
        return loReadcusResult;
    }


    /**
     * Sets the loReadcusResult value for this LoReadcusResponse.
     * 
     * @param loReadcusResult
     */
    public void setLoReadcusResult(org.tempuri.LoReadcusResponseLoReadcusResult loReadcusResult) {
        this.loReadcusResult = loReadcusResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof LoReadcusResponse)) return false;
        LoReadcusResponse other = (LoReadcusResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.loReadcusResult==null && other.getLoReadcusResult()==null) || 
             (this.loReadcusResult!=null &&
              this.loReadcusResult.equals(other.getLoReadcusResult())));
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
        if (getLoReadcusResult() != null) {
            _hashCode += getLoReadcusResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(LoReadcusResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">loReadcusResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("loReadcusResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "loReadcusResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>loReadcusResponse>loReadcusResult"));
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
