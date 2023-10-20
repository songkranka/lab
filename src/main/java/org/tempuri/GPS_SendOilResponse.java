/**
 * GPS_SendOilResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class GPS_SendOilResponse  implements java.io.Serializable {
    private java.lang.String GPS_SendOilResult;

    public GPS_SendOilResponse() {
    }

    public GPS_SendOilResponse(
           java.lang.String GPS_SendOilResult) {
           this.GPS_SendOilResult = GPS_SendOilResult;
    }


    /**
     * Gets the GPS_SendOilResult value for this GPS_SendOilResponse.
     * 
     * @return GPS_SendOilResult
     */
    public java.lang.String getGPS_SendOilResult() {
        return GPS_SendOilResult;
    }


    /**
     * Sets the GPS_SendOilResult value for this GPS_SendOilResponse.
     * 
     * @param GPS_SendOilResult
     */
    public void setGPS_SendOilResult(java.lang.String GPS_SendOilResult) {
        this.GPS_SendOilResult = GPS_SendOilResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GPS_SendOilResponse)) return false;
        GPS_SendOilResponse other = (GPS_SendOilResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.GPS_SendOilResult==null && other.getGPS_SendOilResult()==null) || 
             (this.GPS_SendOilResult!=null &&
              this.GPS_SendOilResult.equals(other.getGPS_SendOilResult())));
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
        if (getGPS_SendOilResult() != null) {
            _hashCode += getGPS_SendOilResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GPS_SendOilResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GPS_SendOilResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("GPS_SendOilResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "GPS_SendOilResult"));
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
