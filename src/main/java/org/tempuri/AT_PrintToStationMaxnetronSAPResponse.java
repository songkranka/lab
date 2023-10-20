/**
 * AT_PrintToStationMaxnetronSAPResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AT_PrintToStationMaxnetronSAPResponse  implements java.io.Serializable {
    private org.tempuri.AT_PrintToStationMaxnetronSAPResponseAT_PrintToStationMaxnetronSAPResult AT_PrintToStationMaxnetronSAPResult;

    public AT_PrintToStationMaxnetronSAPResponse() {
    }

    public AT_PrintToStationMaxnetronSAPResponse(
           org.tempuri.AT_PrintToStationMaxnetronSAPResponseAT_PrintToStationMaxnetronSAPResult AT_PrintToStationMaxnetronSAPResult) {
           this.AT_PrintToStationMaxnetronSAPResult = AT_PrintToStationMaxnetronSAPResult;
    }


    /**
     * Gets the AT_PrintToStationMaxnetronSAPResult value for this AT_PrintToStationMaxnetronSAPResponse.
     * 
     * @return AT_PrintToStationMaxnetronSAPResult
     */
    public org.tempuri.AT_PrintToStationMaxnetronSAPResponseAT_PrintToStationMaxnetronSAPResult getAT_PrintToStationMaxnetronSAPResult() {
        return AT_PrintToStationMaxnetronSAPResult;
    }


    /**
     * Sets the AT_PrintToStationMaxnetronSAPResult value for this AT_PrintToStationMaxnetronSAPResponse.
     * 
     * @param AT_PrintToStationMaxnetronSAPResult
     */
    public void setAT_PrintToStationMaxnetronSAPResult(org.tempuri.AT_PrintToStationMaxnetronSAPResponseAT_PrintToStationMaxnetronSAPResult AT_PrintToStationMaxnetronSAPResult) {
        this.AT_PrintToStationMaxnetronSAPResult = AT_PrintToStationMaxnetronSAPResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AT_PrintToStationMaxnetronSAPResponse)) return false;
        AT_PrintToStationMaxnetronSAPResponse other = (AT_PrintToStationMaxnetronSAPResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.AT_PrintToStationMaxnetronSAPResult==null && other.getAT_PrintToStationMaxnetronSAPResult()==null) || 
             (this.AT_PrintToStationMaxnetronSAPResult!=null &&
              this.AT_PrintToStationMaxnetronSAPResult.equals(other.getAT_PrintToStationMaxnetronSAPResult())));
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
        if (getAT_PrintToStationMaxnetronSAPResult() != null) {
            _hashCode += getAT_PrintToStationMaxnetronSAPResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AT_PrintToStationMaxnetronSAPResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AT_PrintToStationMaxnetronSAPResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AT_PrintToStationMaxnetronSAPResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "AT_PrintToStationMaxnetronSAPResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>AT_PrintToStationMaxnetronSAPResponse>AT_PrintToStationMaxnetronSAPResult"));
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
