/**
 * AT_OrderAutoCalPowerDashboardResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AT_OrderAutoCalPowerDashboardResponse  implements java.io.Serializable {
    private org.tempuri.AT_OrderAutoCalPowerDashboardResponseAT_OrderAutoCalPowerDashboardResult AT_OrderAutoCalPowerDashboardResult;

    public AT_OrderAutoCalPowerDashboardResponse() {
    }

    public AT_OrderAutoCalPowerDashboardResponse(
           org.tempuri.AT_OrderAutoCalPowerDashboardResponseAT_OrderAutoCalPowerDashboardResult AT_OrderAutoCalPowerDashboardResult) {
           this.AT_OrderAutoCalPowerDashboardResult = AT_OrderAutoCalPowerDashboardResult;
    }


    /**
     * Gets the AT_OrderAutoCalPowerDashboardResult value for this AT_OrderAutoCalPowerDashboardResponse.
     * 
     * @return AT_OrderAutoCalPowerDashboardResult
     */
    public org.tempuri.AT_OrderAutoCalPowerDashboardResponseAT_OrderAutoCalPowerDashboardResult getAT_OrderAutoCalPowerDashboardResult() {
        return AT_OrderAutoCalPowerDashboardResult;
    }


    /**
     * Sets the AT_OrderAutoCalPowerDashboardResult value for this AT_OrderAutoCalPowerDashboardResponse.
     * 
     * @param AT_OrderAutoCalPowerDashboardResult
     */
    public void setAT_OrderAutoCalPowerDashboardResult(org.tempuri.AT_OrderAutoCalPowerDashboardResponseAT_OrderAutoCalPowerDashboardResult AT_OrderAutoCalPowerDashboardResult) {
        this.AT_OrderAutoCalPowerDashboardResult = AT_OrderAutoCalPowerDashboardResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AT_OrderAutoCalPowerDashboardResponse)) return false;
        AT_OrderAutoCalPowerDashboardResponse other = (AT_OrderAutoCalPowerDashboardResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.AT_OrderAutoCalPowerDashboardResult==null && other.getAT_OrderAutoCalPowerDashboardResult()==null) || 
             (this.AT_OrderAutoCalPowerDashboardResult!=null &&
              this.AT_OrderAutoCalPowerDashboardResult.equals(other.getAT_OrderAutoCalPowerDashboardResult())));
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
        if (getAT_OrderAutoCalPowerDashboardResult() != null) {
            _hashCode += getAT_OrderAutoCalPowerDashboardResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AT_OrderAutoCalPowerDashboardResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AT_OrderAutoCalPowerDashboardResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AT_OrderAutoCalPowerDashboardResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "AT_OrderAutoCalPowerDashboardResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>AT_OrderAutoCalPowerDashboardResponse>AT_OrderAutoCalPowerDashboardResult"));
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
