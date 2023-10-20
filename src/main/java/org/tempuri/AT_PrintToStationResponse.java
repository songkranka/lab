/**
 * AT_PrintToStationResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AT_PrintToStationResponse  implements java.io.Serializable {
    private org.tempuri.AT_PrintToStationResponseAT_PrintToStationResult AT_PrintToStationResult;

    public AT_PrintToStationResponse() {
    }

    public AT_PrintToStationResponse(
           org.tempuri.AT_PrintToStationResponseAT_PrintToStationResult AT_PrintToStationResult) {
           this.AT_PrintToStationResult = AT_PrintToStationResult;
    }


    /**
     * Gets the AT_PrintToStationResult value for this AT_PrintToStationResponse.
     * 
     * @return AT_PrintToStationResult
     */
    public org.tempuri.AT_PrintToStationResponseAT_PrintToStationResult getAT_PrintToStationResult() {
        return AT_PrintToStationResult;
    }


    /**
     * Sets the AT_PrintToStationResult value for this AT_PrintToStationResponse.
     * 
     * @param AT_PrintToStationResult
     */
    public void setAT_PrintToStationResult(org.tempuri.AT_PrintToStationResponseAT_PrintToStationResult AT_PrintToStationResult) {
        this.AT_PrintToStationResult = AT_PrintToStationResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AT_PrintToStationResponse)) return false;
        AT_PrintToStationResponse other = (AT_PrintToStationResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.AT_PrintToStationResult==null && other.getAT_PrintToStationResult()==null) || 
             (this.AT_PrintToStationResult!=null &&
              this.AT_PrintToStationResult.equals(other.getAT_PrintToStationResult())));
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
        if (getAT_PrintToStationResult() != null) {
            _hashCode += getAT_PrintToStationResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AT_PrintToStationResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AT_PrintToStationResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AT_PrintToStationResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "AT_PrintToStationResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>AT_PrintToStationResponse>AT_PrintToStationResult"));
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
