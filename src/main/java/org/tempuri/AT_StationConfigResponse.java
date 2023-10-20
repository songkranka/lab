/**
 * AT_StationConfigResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AT_StationConfigResponse  implements java.io.Serializable {
    private org.tempuri.AT_StationConfigResponseAT_StationConfigResult AT_StationConfigResult;

    public AT_StationConfigResponse() {
    }

    public AT_StationConfigResponse(
           org.tempuri.AT_StationConfigResponseAT_StationConfigResult AT_StationConfigResult) {
           this.AT_StationConfigResult = AT_StationConfigResult;
    }


    /**
     * Gets the AT_StationConfigResult value for this AT_StationConfigResponse.
     * 
     * @return AT_StationConfigResult
     */
    public org.tempuri.AT_StationConfigResponseAT_StationConfigResult getAT_StationConfigResult() {
        return AT_StationConfigResult;
    }


    /**
     * Sets the AT_StationConfigResult value for this AT_StationConfigResponse.
     * 
     * @param AT_StationConfigResult
     */
    public void setAT_StationConfigResult(org.tempuri.AT_StationConfigResponseAT_StationConfigResult AT_StationConfigResult) {
        this.AT_StationConfigResult = AT_StationConfigResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AT_StationConfigResponse)) return false;
        AT_StationConfigResponse other = (AT_StationConfigResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.AT_StationConfigResult==null && other.getAT_StationConfigResult()==null) || 
             (this.AT_StationConfigResult!=null &&
              this.AT_StationConfigResult.equals(other.getAT_StationConfigResult())));
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
        if (getAT_StationConfigResult() != null) {
            _hashCode += getAT_StationConfigResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AT_StationConfigResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AT_StationConfigResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AT_StationConfigResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "AT_StationConfigResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>AT_StationConfigResponse>AT_StationConfigResult"));
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
