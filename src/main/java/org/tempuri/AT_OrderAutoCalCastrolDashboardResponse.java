/**
 * AT_OrderAutoCalCastrolDashboardResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AT_OrderAutoCalCastrolDashboardResponse  implements java.io.Serializable {
    private org.tempuri.AT_OrderAutoCalCastrolDashboardResponseAT_OrderAutoCalCastrolDashboardResult AT_OrderAutoCalCastrolDashboardResult;

    public AT_OrderAutoCalCastrolDashboardResponse() {
    }

    public AT_OrderAutoCalCastrolDashboardResponse(
           org.tempuri.AT_OrderAutoCalCastrolDashboardResponseAT_OrderAutoCalCastrolDashboardResult AT_OrderAutoCalCastrolDashboardResult) {
           this.AT_OrderAutoCalCastrolDashboardResult = AT_OrderAutoCalCastrolDashboardResult;
    }


    /**
     * Gets the AT_OrderAutoCalCastrolDashboardResult value for this AT_OrderAutoCalCastrolDashboardResponse.
     * 
     * @return AT_OrderAutoCalCastrolDashboardResult
     */
    public org.tempuri.AT_OrderAutoCalCastrolDashboardResponseAT_OrderAutoCalCastrolDashboardResult getAT_OrderAutoCalCastrolDashboardResult() {
        return AT_OrderAutoCalCastrolDashboardResult;
    }


    /**
     * Sets the AT_OrderAutoCalCastrolDashboardResult value for this AT_OrderAutoCalCastrolDashboardResponse.
     * 
     * @param AT_OrderAutoCalCastrolDashboardResult
     */
    public void setAT_OrderAutoCalCastrolDashboardResult(org.tempuri.AT_OrderAutoCalCastrolDashboardResponseAT_OrderAutoCalCastrolDashboardResult AT_OrderAutoCalCastrolDashboardResult) {
        this.AT_OrderAutoCalCastrolDashboardResult = AT_OrderAutoCalCastrolDashboardResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AT_OrderAutoCalCastrolDashboardResponse)) return false;
        AT_OrderAutoCalCastrolDashboardResponse other = (AT_OrderAutoCalCastrolDashboardResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.AT_OrderAutoCalCastrolDashboardResult==null && other.getAT_OrderAutoCalCastrolDashboardResult()==null) || 
             (this.AT_OrderAutoCalCastrolDashboardResult!=null &&
              this.AT_OrderAutoCalCastrolDashboardResult.equals(other.getAT_OrderAutoCalCastrolDashboardResult())));
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
        if (getAT_OrderAutoCalCastrolDashboardResult() != null) {
            _hashCode += getAT_OrderAutoCalCastrolDashboardResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AT_OrderAutoCalCastrolDashboardResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AT_OrderAutoCalCastrolDashboardResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AT_OrderAutoCalCastrolDashboardResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "AT_OrderAutoCalCastrolDashboardResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>AT_OrderAutoCalCastrolDashboardResponse>AT_OrderAutoCalCastrolDashboardResult"));
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
