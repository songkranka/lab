/**
 * AT_GetLupeNameCodeForEditBResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AT_GetLupeNameCodeForEditBResponse  implements java.io.Serializable {
    private org.tempuri.AT_GetLupeNameCodeForEditBResponseAT_GetLupeNameCodeForEditBResult AT_GetLupeNameCodeForEditBResult;

    public AT_GetLupeNameCodeForEditBResponse() {
    }

    public AT_GetLupeNameCodeForEditBResponse(
           org.tempuri.AT_GetLupeNameCodeForEditBResponseAT_GetLupeNameCodeForEditBResult AT_GetLupeNameCodeForEditBResult) {
           this.AT_GetLupeNameCodeForEditBResult = AT_GetLupeNameCodeForEditBResult;
    }


    /**
     * Gets the AT_GetLupeNameCodeForEditBResult value for this AT_GetLupeNameCodeForEditBResponse.
     * 
     * @return AT_GetLupeNameCodeForEditBResult
     */
    public org.tempuri.AT_GetLupeNameCodeForEditBResponseAT_GetLupeNameCodeForEditBResult getAT_GetLupeNameCodeForEditBResult() {
        return AT_GetLupeNameCodeForEditBResult;
    }


    /**
     * Sets the AT_GetLupeNameCodeForEditBResult value for this AT_GetLupeNameCodeForEditBResponse.
     * 
     * @param AT_GetLupeNameCodeForEditBResult
     */
    public void setAT_GetLupeNameCodeForEditBResult(org.tempuri.AT_GetLupeNameCodeForEditBResponseAT_GetLupeNameCodeForEditBResult AT_GetLupeNameCodeForEditBResult) {
        this.AT_GetLupeNameCodeForEditBResult = AT_GetLupeNameCodeForEditBResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AT_GetLupeNameCodeForEditBResponse)) return false;
        AT_GetLupeNameCodeForEditBResponse other = (AT_GetLupeNameCodeForEditBResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.AT_GetLupeNameCodeForEditBResult==null && other.getAT_GetLupeNameCodeForEditBResult()==null) || 
             (this.AT_GetLupeNameCodeForEditBResult!=null &&
              this.AT_GetLupeNameCodeForEditBResult.equals(other.getAT_GetLupeNameCodeForEditBResult())));
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
        if (getAT_GetLupeNameCodeForEditBResult() != null) {
            _hashCode += getAT_GetLupeNameCodeForEditBResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AT_GetLupeNameCodeForEditBResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AT_GetLupeNameCodeForEditBResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AT_GetLupeNameCodeForEditBResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "AT_GetLupeNameCodeForEditBResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>AT_GetLupeNameCodeForEditBResponse>AT_GetLupeNameCodeForEditBResult"));
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
