/**
 * AN_MovePreOrder2Order_SplitResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AN_MovePreOrder2Order_SplitResponse  implements java.io.Serializable {
    private boolean AN_MovePreOrder2Order_SplitResult;

    public AN_MovePreOrder2Order_SplitResponse() {
    }

    public AN_MovePreOrder2Order_SplitResponse(
           boolean AN_MovePreOrder2Order_SplitResult) {
           this.AN_MovePreOrder2Order_SplitResult = AN_MovePreOrder2Order_SplitResult;
    }


    /**
     * Gets the AN_MovePreOrder2Order_SplitResult value for this AN_MovePreOrder2Order_SplitResponse.
     * 
     * @return AN_MovePreOrder2Order_SplitResult
     */
    public boolean isAN_MovePreOrder2Order_SplitResult() {
        return AN_MovePreOrder2Order_SplitResult;
    }


    /**
     * Sets the AN_MovePreOrder2Order_SplitResult value for this AN_MovePreOrder2Order_SplitResponse.
     * 
     * @param AN_MovePreOrder2Order_SplitResult
     */
    public void setAN_MovePreOrder2Order_SplitResult(boolean AN_MovePreOrder2Order_SplitResult) {
        this.AN_MovePreOrder2Order_SplitResult = AN_MovePreOrder2Order_SplitResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AN_MovePreOrder2Order_SplitResponse)) return false;
        AN_MovePreOrder2Order_SplitResponse other = (AN_MovePreOrder2Order_SplitResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.AN_MovePreOrder2Order_SplitResult == other.isAN_MovePreOrder2Order_SplitResult();
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
        _hashCode += (isAN_MovePreOrder2Order_SplitResult() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AN_MovePreOrder2Order_SplitResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AN_MovePreOrder2Order_SplitResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AN_MovePreOrder2Order_SplitResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "AN_MovePreOrder2Order_SplitResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
