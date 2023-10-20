/**
 * POS_PROMOTION_GETResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class POS_PROMOTION_GETResponse  implements java.io.Serializable {
    private org.tempuri.POS_PROMOTION_GETResponsePOS_PROMOTION_GETResult POS_PROMOTION_GETResult;

    public POS_PROMOTION_GETResponse() {
    }

    public POS_PROMOTION_GETResponse(
           org.tempuri.POS_PROMOTION_GETResponsePOS_PROMOTION_GETResult POS_PROMOTION_GETResult) {
           this.POS_PROMOTION_GETResult = POS_PROMOTION_GETResult;
    }


    /**
     * Gets the POS_PROMOTION_GETResult value for this POS_PROMOTION_GETResponse.
     * 
     * @return POS_PROMOTION_GETResult
     */
    public org.tempuri.POS_PROMOTION_GETResponsePOS_PROMOTION_GETResult getPOS_PROMOTION_GETResult() {
        return POS_PROMOTION_GETResult;
    }


    /**
     * Sets the POS_PROMOTION_GETResult value for this POS_PROMOTION_GETResponse.
     * 
     * @param POS_PROMOTION_GETResult
     */
    public void setPOS_PROMOTION_GETResult(org.tempuri.POS_PROMOTION_GETResponsePOS_PROMOTION_GETResult POS_PROMOTION_GETResult) {
        this.POS_PROMOTION_GETResult = POS_PROMOTION_GETResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof POS_PROMOTION_GETResponse)) return false;
        POS_PROMOTION_GETResponse other = (POS_PROMOTION_GETResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.POS_PROMOTION_GETResult==null && other.getPOS_PROMOTION_GETResult()==null) || 
             (this.POS_PROMOTION_GETResult!=null &&
              this.POS_PROMOTION_GETResult.equals(other.getPOS_PROMOTION_GETResult())));
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
        if (getPOS_PROMOTION_GETResult() != null) {
            _hashCode += getPOS_PROMOTION_GETResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(POS_PROMOTION_GETResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">POS_PROMOTION_GETResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("POS_PROMOTION_GETResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "POS_PROMOTION_GETResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>POS_PROMOTION_GETResponse>POS_PROMOTION_GETResult"));
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
