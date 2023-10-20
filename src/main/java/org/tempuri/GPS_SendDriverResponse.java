/**
 * GPS_SendDriverResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class GPS_SendDriverResponse  implements java.io.Serializable {
    private java.lang.String GPS_SendDriverResult;

    public GPS_SendDriverResponse() {
    }

    public GPS_SendDriverResponse(
           java.lang.String GPS_SendDriverResult) {
           this.GPS_SendDriverResult = GPS_SendDriverResult;
    }


    /**
     * Gets the GPS_SendDriverResult value for this GPS_SendDriverResponse.
     * 
     * @return GPS_SendDriverResult
     */
    public java.lang.String getGPS_SendDriverResult() {
        return GPS_SendDriverResult;
    }


    /**
     * Sets the GPS_SendDriverResult value for this GPS_SendDriverResponse.
     * 
     * @param GPS_SendDriverResult
     */
    public void setGPS_SendDriverResult(java.lang.String GPS_SendDriverResult) {
        this.GPS_SendDriverResult = GPS_SendDriverResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GPS_SendDriverResponse)) return false;
        GPS_SendDriverResponse other = (GPS_SendDriverResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.GPS_SendDriverResult==null && other.getGPS_SendDriverResult()==null) || 
             (this.GPS_SendDriverResult!=null &&
              this.GPS_SendDriverResult.equals(other.getGPS_SendDriverResult())));
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
        if (getGPS_SendDriverResult() != null) {
            _hashCode += getGPS_SendDriverResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GPS_SendDriverResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GPS_SendDriverResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("GPS_SendDriverResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "GPS_SendDriverResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
