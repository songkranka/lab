/**
 * AT_PrintToStationConResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AT_PrintToStationConResponse  implements java.io.Serializable {
    private org.tempuri.AT_PrintToStationConResponseAT_PrintToStationConResult AT_PrintToStationConResult;

    public AT_PrintToStationConResponse() {
    }

    public AT_PrintToStationConResponse(
           org.tempuri.AT_PrintToStationConResponseAT_PrintToStationConResult AT_PrintToStationConResult) {
           this.AT_PrintToStationConResult = AT_PrintToStationConResult;
    }


    /**
     * Gets the AT_PrintToStationConResult value for this AT_PrintToStationConResponse.
     * 
     * @return AT_PrintToStationConResult
     */
    public org.tempuri.AT_PrintToStationConResponseAT_PrintToStationConResult getAT_PrintToStationConResult() {
        return AT_PrintToStationConResult;
    }


    /**
     * Sets the AT_PrintToStationConResult value for this AT_PrintToStationConResponse.
     * 
     * @param AT_PrintToStationConResult
     */
    public void setAT_PrintToStationConResult(org.tempuri.AT_PrintToStationConResponseAT_PrintToStationConResult AT_PrintToStationConResult) {
        this.AT_PrintToStationConResult = AT_PrintToStationConResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AT_PrintToStationConResponse)) return false;
        AT_PrintToStationConResponse other = (AT_PrintToStationConResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.AT_PrintToStationConResult==null && other.getAT_PrintToStationConResult()==null) || 
             (this.AT_PrintToStationConResult!=null &&
              this.AT_PrintToStationConResult.equals(other.getAT_PrintToStationConResult())));
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
        if (getAT_PrintToStationConResult() != null) {
            _hashCode += getAT_PrintToStationConResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AT_PrintToStationConResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AT_PrintToStationConResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AT_PrintToStationConResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "AT_PrintToStationConResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>AT_PrintToStationConResponse>AT_PrintToStationConResult"));
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
