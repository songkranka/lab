/**
 * AT_PrintToStationCastrolSAPResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AT_PrintToStationCastrolSAPResponse  implements java.io.Serializable {
    private org.tempuri.AT_PrintToStationCastrolSAPResponseAT_PrintToStationCastrolSAPResult AT_PrintToStationCastrolSAPResult;

    public AT_PrintToStationCastrolSAPResponse() {
    }

    public AT_PrintToStationCastrolSAPResponse(
           org.tempuri.AT_PrintToStationCastrolSAPResponseAT_PrintToStationCastrolSAPResult AT_PrintToStationCastrolSAPResult) {
           this.AT_PrintToStationCastrolSAPResult = AT_PrintToStationCastrolSAPResult;
    }


    /**
     * Gets the AT_PrintToStationCastrolSAPResult value for this AT_PrintToStationCastrolSAPResponse.
     * 
     * @return AT_PrintToStationCastrolSAPResult
     */
    public org.tempuri.AT_PrintToStationCastrolSAPResponseAT_PrintToStationCastrolSAPResult getAT_PrintToStationCastrolSAPResult() {
        return AT_PrintToStationCastrolSAPResult;
    }


    /**
     * Sets the AT_PrintToStationCastrolSAPResult value for this AT_PrintToStationCastrolSAPResponse.
     * 
     * @param AT_PrintToStationCastrolSAPResult
     */
    public void setAT_PrintToStationCastrolSAPResult(org.tempuri.AT_PrintToStationCastrolSAPResponseAT_PrintToStationCastrolSAPResult AT_PrintToStationCastrolSAPResult) {
        this.AT_PrintToStationCastrolSAPResult = AT_PrintToStationCastrolSAPResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AT_PrintToStationCastrolSAPResponse)) return false;
        AT_PrintToStationCastrolSAPResponse other = (AT_PrintToStationCastrolSAPResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.AT_PrintToStationCastrolSAPResult==null && other.getAT_PrintToStationCastrolSAPResult()==null) || 
             (this.AT_PrintToStationCastrolSAPResult!=null &&
              this.AT_PrintToStationCastrolSAPResult.equals(other.getAT_PrintToStationCastrolSAPResult())));
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
        if (getAT_PrintToStationCastrolSAPResult() != null) {
            _hashCode += getAT_PrintToStationCastrolSAPResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AT_PrintToStationCastrolSAPResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AT_PrintToStationCastrolSAPResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AT_PrintToStationCastrolSAPResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "AT_PrintToStationCastrolSAPResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>AT_PrintToStationCastrolSAPResponse>AT_PrintToStationCastrolSAPResult"));
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
