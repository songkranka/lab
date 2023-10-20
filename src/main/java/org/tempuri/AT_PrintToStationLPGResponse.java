/**
 * AT_PrintToStationLPGResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AT_PrintToStationLPGResponse  implements java.io.Serializable {
    private org.tempuri.AT_PrintToStationLPGResponseAT_PrintToStationLPGResult AT_PrintToStationLPGResult;

    public AT_PrintToStationLPGResponse() {
    }

    public AT_PrintToStationLPGResponse(
           org.tempuri.AT_PrintToStationLPGResponseAT_PrintToStationLPGResult AT_PrintToStationLPGResult) {
           this.AT_PrintToStationLPGResult = AT_PrintToStationLPGResult;
    }


    /**
     * Gets the AT_PrintToStationLPGResult value for this AT_PrintToStationLPGResponse.
     * 
     * @return AT_PrintToStationLPGResult
     */
    public org.tempuri.AT_PrintToStationLPGResponseAT_PrintToStationLPGResult getAT_PrintToStationLPGResult() {
        return AT_PrintToStationLPGResult;
    }


    /**
     * Sets the AT_PrintToStationLPGResult value for this AT_PrintToStationLPGResponse.
     * 
     * @param AT_PrintToStationLPGResult
     */
    public void setAT_PrintToStationLPGResult(org.tempuri.AT_PrintToStationLPGResponseAT_PrintToStationLPGResult AT_PrintToStationLPGResult) {
        this.AT_PrintToStationLPGResult = AT_PrintToStationLPGResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AT_PrintToStationLPGResponse)) return false;
        AT_PrintToStationLPGResponse other = (AT_PrintToStationLPGResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.AT_PrintToStationLPGResult==null && other.getAT_PrintToStationLPGResult()==null) || 
             (this.AT_PrintToStationLPGResult!=null &&
              this.AT_PrintToStationLPGResult.equals(other.getAT_PrintToStationLPGResult())));
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
        if (getAT_PrintToStationLPGResult() != null) {
            _hashCode += getAT_PrintToStationLPGResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AT_PrintToStationLPGResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AT_PrintToStationLPGResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AT_PrintToStationLPGResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "AT_PrintToStationLPGResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>AT_PrintToStationLPGResponse>AT_PrintToStationLPGResult"));
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
