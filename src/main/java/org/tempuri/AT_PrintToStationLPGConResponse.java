/**
 * AT_PrintToStationLPGConResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AT_PrintToStationLPGConResponse  implements java.io.Serializable {
    private org.tempuri.AT_PrintToStationLPGConResponseAT_PrintToStationLPGConResult AT_PrintToStationLPGConResult;

    public AT_PrintToStationLPGConResponse() {
    }

    public AT_PrintToStationLPGConResponse(
           org.tempuri.AT_PrintToStationLPGConResponseAT_PrintToStationLPGConResult AT_PrintToStationLPGConResult) {
           this.AT_PrintToStationLPGConResult = AT_PrintToStationLPGConResult;
    }


    /**
     * Gets the AT_PrintToStationLPGConResult value for this AT_PrintToStationLPGConResponse.
     * 
     * @return AT_PrintToStationLPGConResult
     */
    public org.tempuri.AT_PrintToStationLPGConResponseAT_PrintToStationLPGConResult getAT_PrintToStationLPGConResult() {
        return AT_PrintToStationLPGConResult;
    }


    /**
     * Sets the AT_PrintToStationLPGConResult value for this AT_PrintToStationLPGConResponse.
     * 
     * @param AT_PrintToStationLPGConResult
     */
    public void setAT_PrintToStationLPGConResult(org.tempuri.AT_PrintToStationLPGConResponseAT_PrintToStationLPGConResult AT_PrintToStationLPGConResult) {
        this.AT_PrintToStationLPGConResult = AT_PrintToStationLPGConResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AT_PrintToStationLPGConResponse)) return false;
        AT_PrintToStationLPGConResponse other = (AT_PrintToStationLPGConResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.AT_PrintToStationLPGConResult==null && other.getAT_PrintToStationLPGConResult()==null) || 
             (this.AT_PrintToStationLPGConResult!=null &&
              this.AT_PrintToStationLPGConResult.equals(other.getAT_PrintToStationLPGConResult())));
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
        if (getAT_PrintToStationLPGConResult() != null) {
            _hashCode += getAT_PrintToStationLPGConResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AT_PrintToStationLPGConResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AT_PrintToStationLPGConResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AT_PrintToStationLPGConResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "AT_PrintToStationLPGConResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>AT_PrintToStationLPGConResponse>AT_PrintToStationLPGConResult"));
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
