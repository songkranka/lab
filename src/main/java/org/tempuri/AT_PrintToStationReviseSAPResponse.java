/**
 * AT_PrintToStationReviseSAPResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AT_PrintToStationReviseSAPResponse  implements java.io.Serializable {
    private org.tempuri.AT_PrintToStationReviseSAPResponseAT_PrintToStationReviseSAPResult AT_PrintToStationReviseSAPResult;

    public AT_PrintToStationReviseSAPResponse() {
    }

    public AT_PrintToStationReviseSAPResponse(
           org.tempuri.AT_PrintToStationReviseSAPResponseAT_PrintToStationReviseSAPResult AT_PrintToStationReviseSAPResult) {
           this.AT_PrintToStationReviseSAPResult = AT_PrintToStationReviseSAPResult;
    }


    /**
     * Gets the AT_PrintToStationReviseSAPResult value for this AT_PrintToStationReviseSAPResponse.
     * 
     * @return AT_PrintToStationReviseSAPResult
     */
    public org.tempuri.AT_PrintToStationReviseSAPResponseAT_PrintToStationReviseSAPResult getAT_PrintToStationReviseSAPResult() {
        return AT_PrintToStationReviseSAPResult;
    }


    /**
     * Sets the AT_PrintToStationReviseSAPResult value for this AT_PrintToStationReviseSAPResponse.
     * 
     * @param AT_PrintToStationReviseSAPResult
     */
    public void setAT_PrintToStationReviseSAPResult(org.tempuri.AT_PrintToStationReviseSAPResponseAT_PrintToStationReviseSAPResult AT_PrintToStationReviseSAPResult) {
        this.AT_PrintToStationReviseSAPResult = AT_PrintToStationReviseSAPResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AT_PrintToStationReviseSAPResponse)) return false;
        AT_PrintToStationReviseSAPResponse other = (AT_PrintToStationReviseSAPResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.AT_PrintToStationReviseSAPResult==null && other.getAT_PrintToStationReviseSAPResult()==null) || 
             (this.AT_PrintToStationReviseSAPResult!=null &&
              this.AT_PrintToStationReviseSAPResult.equals(other.getAT_PrintToStationReviseSAPResult())));
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
        if (getAT_PrintToStationReviseSAPResult() != null) {
            _hashCode += getAT_PrintToStationReviseSAPResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AT_PrintToStationReviseSAPResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AT_PrintToStationReviseSAPResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AT_PrintToStationReviseSAPResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "AT_PrintToStationReviseSAPResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>AT_PrintToStationReviseSAPResponse>AT_PrintToStationReviseSAPResult"));
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
