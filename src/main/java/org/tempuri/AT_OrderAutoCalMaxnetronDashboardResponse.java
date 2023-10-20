/**
 * AT_OrderAutoCalMaxnetronDashboardResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AT_OrderAutoCalMaxnetronDashboardResponse  implements java.io.Serializable {
    private org.tempuri.AT_OrderAutoCalMaxnetronDashboardResponseAT_OrderAutoCalMaxnetronDashboardResult AT_OrderAutoCalMaxnetronDashboardResult;

    public AT_OrderAutoCalMaxnetronDashboardResponse() {
    }

    public AT_OrderAutoCalMaxnetronDashboardResponse(
           org.tempuri.AT_OrderAutoCalMaxnetronDashboardResponseAT_OrderAutoCalMaxnetronDashboardResult AT_OrderAutoCalMaxnetronDashboardResult) {
           this.AT_OrderAutoCalMaxnetronDashboardResult = AT_OrderAutoCalMaxnetronDashboardResult;
    }


    /**
     * Gets the AT_OrderAutoCalMaxnetronDashboardResult value for this AT_OrderAutoCalMaxnetronDashboardResponse.
     * 
     * @return AT_OrderAutoCalMaxnetronDashboardResult
     */
    public org.tempuri.AT_OrderAutoCalMaxnetronDashboardResponseAT_OrderAutoCalMaxnetronDashboardResult getAT_OrderAutoCalMaxnetronDashboardResult() {
        return AT_OrderAutoCalMaxnetronDashboardResult;
    }


    /**
     * Sets the AT_OrderAutoCalMaxnetronDashboardResult value for this AT_OrderAutoCalMaxnetronDashboardResponse.
     * 
     * @param AT_OrderAutoCalMaxnetronDashboardResult
     */
    public void setAT_OrderAutoCalMaxnetronDashboardResult(org.tempuri.AT_OrderAutoCalMaxnetronDashboardResponseAT_OrderAutoCalMaxnetronDashboardResult AT_OrderAutoCalMaxnetronDashboardResult) {
        this.AT_OrderAutoCalMaxnetronDashboardResult = AT_OrderAutoCalMaxnetronDashboardResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AT_OrderAutoCalMaxnetronDashboardResponse)) return false;
        AT_OrderAutoCalMaxnetronDashboardResponse other = (AT_OrderAutoCalMaxnetronDashboardResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.AT_OrderAutoCalMaxnetronDashboardResult==null && other.getAT_OrderAutoCalMaxnetronDashboardResult()==null) || 
             (this.AT_OrderAutoCalMaxnetronDashboardResult!=null &&
              this.AT_OrderAutoCalMaxnetronDashboardResult.equals(other.getAT_OrderAutoCalMaxnetronDashboardResult())));
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
        if (getAT_OrderAutoCalMaxnetronDashboardResult() != null) {
            _hashCode += getAT_OrderAutoCalMaxnetronDashboardResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AT_OrderAutoCalMaxnetronDashboardResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AT_OrderAutoCalMaxnetronDashboardResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AT_OrderAutoCalMaxnetronDashboardResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "AT_OrderAutoCalMaxnetronDashboardResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>AT_OrderAutoCalMaxnetronDashboardResponse>AT_OrderAutoCalMaxnetronDashboardResult"));
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
