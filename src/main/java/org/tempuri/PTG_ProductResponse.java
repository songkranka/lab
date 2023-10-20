/**
 * PTG_ProductResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class PTG_ProductResponse  implements java.io.Serializable {
    private org.tempuri.PTG_ProductResponsePTG_ProductResult PTG_ProductResult;

    public PTG_ProductResponse() {
    }

    public PTG_ProductResponse(
           org.tempuri.PTG_ProductResponsePTG_ProductResult PTG_ProductResult) {
           this.PTG_ProductResult = PTG_ProductResult;
    }


    /**
     * Gets the PTG_ProductResult value for this PTG_ProductResponse.
     * 
     * @return PTG_ProductResult
     */
    public org.tempuri.PTG_ProductResponsePTG_ProductResult getPTG_ProductResult() {
        return PTG_ProductResult;
    }


    /**
     * Sets the PTG_ProductResult value for this PTG_ProductResponse.
     * 
     * @param PTG_ProductResult
     */
    public void setPTG_ProductResult(org.tempuri.PTG_ProductResponsePTG_ProductResult PTG_ProductResult) {
        this.PTG_ProductResult = PTG_ProductResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PTG_ProductResponse)) return false;
        PTG_ProductResponse other = (PTG_ProductResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.PTG_ProductResult==null && other.getPTG_ProductResult()==null) || 
             (this.PTG_ProductResult!=null &&
              this.PTG_ProductResult.equals(other.getPTG_ProductResult())));
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
        if (getPTG_ProductResult() != null) {
            _hashCode += getPTG_ProductResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PTG_ProductResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">PTG_ProductResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PTG_ProductResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "PTG_ProductResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>PTG_ProductResponse>PTG_ProductResult"));
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
