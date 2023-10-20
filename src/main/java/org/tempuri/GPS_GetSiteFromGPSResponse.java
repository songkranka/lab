/**
 * GPS_GetSiteFromGPSResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class GPS_GetSiteFromGPSResponse  implements java.io.Serializable {
    private java.lang.String GPS_GetSiteFromGPSResult;

    public GPS_GetSiteFromGPSResponse() {
    }

    public GPS_GetSiteFromGPSResponse(
           java.lang.String GPS_GetSiteFromGPSResult) {
           this.GPS_GetSiteFromGPSResult = GPS_GetSiteFromGPSResult;
    }


    /**
     * Gets the GPS_GetSiteFromGPSResult value for this GPS_GetSiteFromGPSResponse.
     * 
     * @return GPS_GetSiteFromGPSResult
     */
    public java.lang.String getGPS_GetSiteFromGPSResult() {
        return GPS_GetSiteFromGPSResult;
    }


    /**
     * Sets the GPS_GetSiteFromGPSResult value for this GPS_GetSiteFromGPSResponse.
     * 
     * @param GPS_GetSiteFromGPSResult
     */
    public void setGPS_GetSiteFromGPSResult(java.lang.String GPS_GetSiteFromGPSResult) {
        this.GPS_GetSiteFromGPSResult = GPS_GetSiteFromGPSResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GPS_GetSiteFromGPSResponse)) return false;
        GPS_GetSiteFromGPSResponse other = (GPS_GetSiteFromGPSResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.GPS_GetSiteFromGPSResult==null && other.getGPS_GetSiteFromGPSResult()==null) || 
             (this.GPS_GetSiteFromGPSResult!=null &&
              this.GPS_GetSiteFromGPSResult.equals(other.getGPS_GetSiteFromGPSResult())));
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
        if (getGPS_GetSiteFromGPSResult() != null) {
            _hashCode += getGPS_GetSiteFromGPSResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GPS_GetSiteFromGPSResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GPS_GetSiteFromGPSResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("GPS_GetSiteFromGPSResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "GPS_GetSiteFromGPSResult"));
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
