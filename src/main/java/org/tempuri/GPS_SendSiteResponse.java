/**
 * GPS_SendSiteResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class GPS_SendSiteResponse  implements java.io.Serializable {
    private java.lang.String GPS_SendSiteResult;

    public GPS_SendSiteResponse() {
    }

    public GPS_SendSiteResponse(
           java.lang.String GPS_SendSiteResult) {
           this.GPS_SendSiteResult = GPS_SendSiteResult;
    }


    /**
     * Gets the GPS_SendSiteResult value for this GPS_SendSiteResponse.
     * 
     * @return GPS_SendSiteResult
     */
    public java.lang.String getGPS_SendSiteResult() {
        return GPS_SendSiteResult;
    }


    /**
     * Sets the GPS_SendSiteResult value for this GPS_SendSiteResponse.
     * 
     * @param GPS_SendSiteResult
     */
    public void setGPS_SendSiteResult(java.lang.String GPS_SendSiteResult) {
        this.GPS_SendSiteResult = GPS_SendSiteResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GPS_SendSiteResponse)) return false;
        GPS_SendSiteResponse other = (GPS_SendSiteResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.GPS_SendSiteResult==null && other.getGPS_SendSiteResult()==null) || 
             (this.GPS_SendSiteResult!=null &&
              this.GPS_SendSiteResult.equals(other.getGPS_SendSiteResult())));
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
        if (getGPS_SendSiteResult() != null) {
            _hashCode += getGPS_SendSiteResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GPS_SendSiteResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GPS_SendSiteResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("GPS_SendSiteResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "GPS_SendSiteResult"));
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
