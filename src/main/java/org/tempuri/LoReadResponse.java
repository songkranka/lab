/**
 * LoReadResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class LoReadResponse  implements java.io.Serializable {
    private org.tempuri.LoReadResponseLoReadResult loReadResult;

    public LoReadResponse() {
    }

    public LoReadResponse(
           org.tempuri.LoReadResponseLoReadResult loReadResult) {
           this.loReadResult = loReadResult;
    }


    /**
     * Gets the loReadResult value for this LoReadResponse.
     * 
     * @return loReadResult
     */
    public org.tempuri.LoReadResponseLoReadResult getLoReadResult() {
        return loReadResult;
    }


    /**
     * Sets the loReadResult value for this LoReadResponse.
     * 
     * @param loReadResult
     */
    public void setLoReadResult(org.tempuri.LoReadResponseLoReadResult loReadResult) {
        this.loReadResult = loReadResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof LoReadResponse)) return false;
        LoReadResponse other = (LoReadResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.loReadResult==null && other.getLoReadResult()==null) || 
             (this.loReadResult!=null &&
              this.loReadResult.equals(other.getLoReadResult())));
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
        if (getLoReadResult() != null) {
            _hashCode += getLoReadResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(LoReadResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">loReadResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("loReadResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "loReadResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>loReadResponse>loReadResult"));
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
