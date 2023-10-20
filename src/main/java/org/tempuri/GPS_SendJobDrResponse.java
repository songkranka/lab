/**
 * GPS_SendJobDrResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class GPS_SendJobDrResponse  implements java.io.Serializable {
    private java.lang.String GPS_SendJobDrResult;

    public GPS_SendJobDrResponse() {
    }

    public GPS_SendJobDrResponse(
           java.lang.String GPS_SendJobDrResult) {
           this.GPS_SendJobDrResult = GPS_SendJobDrResult;
    }


    /**
     * Gets the GPS_SendJobDrResult value for this GPS_SendJobDrResponse.
     * 
     * @return GPS_SendJobDrResult
     */
    public java.lang.String getGPS_SendJobDrResult() {
        return GPS_SendJobDrResult;
    }


    /**
     * Sets the GPS_SendJobDrResult value for this GPS_SendJobDrResponse.
     * 
     * @param GPS_SendJobDrResult
     */
    public void setGPS_SendJobDrResult(java.lang.String GPS_SendJobDrResult) {
        this.GPS_SendJobDrResult = GPS_SendJobDrResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GPS_SendJobDrResponse)) return false;
        GPS_SendJobDrResponse other = (GPS_SendJobDrResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.GPS_SendJobDrResult==null && other.getGPS_SendJobDrResult()==null) || 
             (this.GPS_SendJobDrResult!=null &&
              this.GPS_SendJobDrResult.equals(other.getGPS_SendJobDrResult())));
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
        if (getGPS_SendJobDrResult() != null) {
            _hashCode += getGPS_SendJobDrResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GPS_SendJobDrResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GPS_SendJobDrResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("GPS_SendJobDrResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "GPS_SendJobDrResult"));
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
