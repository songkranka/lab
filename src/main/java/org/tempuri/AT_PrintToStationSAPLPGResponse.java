/**
 * AT_PrintToStationSAPLPGResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AT_PrintToStationSAPLPGResponse  implements java.io.Serializable {
    private org.tempuri.AT_PrintToStationSAPLPGResponseAT_PrintToStationSAPLPGResult AT_PrintToStationSAPLPGResult;

    public AT_PrintToStationSAPLPGResponse() {
    }

    public AT_PrintToStationSAPLPGResponse(
           org.tempuri.AT_PrintToStationSAPLPGResponseAT_PrintToStationSAPLPGResult AT_PrintToStationSAPLPGResult) {
           this.AT_PrintToStationSAPLPGResult = AT_PrintToStationSAPLPGResult;
    }


    /**
     * Gets the AT_PrintToStationSAPLPGResult value for this AT_PrintToStationSAPLPGResponse.
     * 
     * @return AT_PrintToStationSAPLPGResult
     */
    public org.tempuri.AT_PrintToStationSAPLPGResponseAT_PrintToStationSAPLPGResult getAT_PrintToStationSAPLPGResult() {
        return AT_PrintToStationSAPLPGResult;
    }


    /**
     * Sets the AT_PrintToStationSAPLPGResult value for this AT_PrintToStationSAPLPGResponse.
     * 
     * @param AT_PrintToStationSAPLPGResult
     */
    public void setAT_PrintToStationSAPLPGResult(org.tempuri.AT_PrintToStationSAPLPGResponseAT_PrintToStationSAPLPGResult AT_PrintToStationSAPLPGResult) {
        this.AT_PrintToStationSAPLPGResult = AT_PrintToStationSAPLPGResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AT_PrintToStationSAPLPGResponse)) return false;
        AT_PrintToStationSAPLPGResponse other = (AT_PrintToStationSAPLPGResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.AT_PrintToStationSAPLPGResult==null && other.getAT_PrintToStationSAPLPGResult()==null) || 
             (this.AT_PrintToStationSAPLPGResult!=null &&
              this.AT_PrintToStationSAPLPGResult.equals(other.getAT_PrintToStationSAPLPGResult())));
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
        if (getAT_PrintToStationSAPLPGResult() != null) {
            _hashCode += getAT_PrintToStationSAPLPGResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AT_PrintToStationSAPLPGResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AT_PrintToStationSAPLPGResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AT_PrintToStationSAPLPGResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "AT_PrintToStationSAPLPGResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>AT_PrintToStationSAPLPGResponse>AT_PrintToStationSAPLPGResult"));
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
