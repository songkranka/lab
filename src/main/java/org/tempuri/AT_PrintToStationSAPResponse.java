/**
 * AT_PrintToStationSAPResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AT_PrintToStationSAPResponse  implements java.io.Serializable {
    private org.tempuri.AT_PrintToStationSAPResponseAT_PrintToStationSAPResult AT_PrintToStationSAPResult;

    public AT_PrintToStationSAPResponse() {
    }

    public AT_PrintToStationSAPResponse(
           org.tempuri.AT_PrintToStationSAPResponseAT_PrintToStationSAPResult AT_PrintToStationSAPResult) {
           this.AT_PrintToStationSAPResult = AT_PrintToStationSAPResult;
    }


    /**
     * Gets the AT_PrintToStationSAPResult value for this AT_PrintToStationSAPResponse.
     * 
     * @return AT_PrintToStationSAPResult
     */
    public org.tempuri.AT_PrintToStationSAPResponseAT_PrintToStationSAPResult getAT_PrintToStationSAPResult() {
        return AT_PrintToStationSAPResult;
    }


    /**
     * Sets the AT_PrintToStationSAPResult value for this AT_PrintToStationSAPResponse.
     * 
     * @param AT_PrintToStationSAPResult
     */
    public void setAT_PrintToStationSAPResult(org.tempuri.AT_PrintToStationSAPResponseAT_PrintToStationSAPResult AT_PrintToStationSAPResult) {
        this.AT_PrintToStationSAPResult = AT_PrintToStationSAPResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AT_PrintToStationSAPResponse)) return false;
        AT_PrintToStationSAPResponse other = (AT_PrintToStationSAPResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.AT_PrintToStationSAPResult==null && other.getAT_PrintToStationSAPResult()==null) || 
             (this.AT_PrintToStationSAPResult!=null &&
              this.AT_PrintToStationSAPResult.equals(other.getAT_PrintToStationSAPResult())));
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
        if (getAT_PrintToStationSAPResult() != null) {
            _hashCode += getAT_PrintToStationSAPResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AT_PrintToStationSAPResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AT_PrintToStationSAPResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AT_PrintToStationSAPResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "AT_PrintToStationSAPResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>AT_PrintToStationSAPResponse>AT_PrintToStationSAPResult"));
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
