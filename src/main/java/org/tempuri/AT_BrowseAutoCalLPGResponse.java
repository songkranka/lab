/**
 * AT_BrowseAutoCalLPGResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AT_BrowseAutoCalLPGResponse  implements java.io.Serializable {
    private org.tempuri.AT_BrowseAutoCalLPGResponseAT_BrowseAutoCalLPGResult AT_BrowseAutoCalLPGResult;

    public AT_BrowseAutoCalLPGResponse() {
    }

    public AT_BrowseAutoCalLPGResponse(
           org.tempuri.AT_BrowseAutoCalLPGResponseAT_BrowseAutoCalLPGResult AT_BrowseAutoCalLPGResult) {
           this.AT_BrowseAutoCalLPGResult = AT_BrowseAutoCalLPGResult;
    }


    /**
     * Gets the AT_BrowseAutoCalLPGResult value for this AT_BrowseAutoCalLPGResponse.
     * 
     * @return AT_BrowseAutoCalLPGResult
     */
    public org.tempuri.AT_BrowseAutoCalLPGResponseAT_BrowseAutoCalLPGResult getAT_BrowseAutoCalLPGResult() {
        return AT_BrowseAutoCalLPGResult;
    }


    /**
     * Sets the AT_BrowseAutoCalLPGResult value for this AT_BrowseAutoCalLPGResponse.
     * 
     * @param AT_BrowseAutoCalLPGResult
     */
    public void setAT_BrowseAutoCalLPGResult(org.tempuri.AT_BrowseAutoCalLPGResponseAT_BrowseAutoCalLPGResult AT_BrowseAutoCalLPGResult) {
        this.AT_BrowseAutoCalLPGResult = AT_BrowseAutoCalLPGResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AT_BrowseAutoCalLPGResponse)) return false;
        AT_BrowseAutoCalLPGResponse other = (AT_BrowseAutoCalLPGResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.AT_BrowseAutoCalLPGResult==null && other.getAT_BrowseAutoCalLPGResult()==null) || 
             (this.AT_BrowseAutoCalLPGResult!=null &&
              this.AT_BrowseAutoCalLPGResult.equals(other.getAT_BrowseAutoCalLPGResult())));
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
        if (getAT_BrowseAutoCalLPGResult() != null) {
            _hashCode += getAT_BrowseAutoCalLPGResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AT_BrowseAutoCalLPGResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AT_BrowseAutoCalLPGResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AT_BrowseAutoCalLPGResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "AT_BrowseAutoCalLPGResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>AT_BrowseAutoCalLPGResponse>AT_BrowseAutoCalLPGResult"));
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
