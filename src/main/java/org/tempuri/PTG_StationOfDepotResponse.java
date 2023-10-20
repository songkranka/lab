/**
 * PTG_StationOfDepotResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class PTG_StationOfDepotResponse  implements java.io.Serializable {
    private org.tempuri.PTG_StationOfDepotResponsePTG_StationOfDepotResult PTG_StationOfDepotResult;

    public PTG_StationOfDepotResponse() {
    }

    public PTG_StationOfDepotResponse(
           org.tempuri.PTG_StationOfDepotResponsePTG_StationOfDepotResult PTG_StationOfDepotResult) {
           this.PTG_StationOfDepotResult = PTG_StationOfDepotResult;
    }


    /**
     * Gets the PTG_StationOfDepotResult value for this PTG_StationOfDepotResponse.
     * 
     * @return PTG_StationOfDepotResult
     */
    public org.tempuri.PTG_StationOfDepotResponsePTG_StationOfDepotResult getPTG_StationOfDepotResult() {
        return PTG_StationOfDepotResult;
    }


    /**
     * Sets the PTG_StationOfDepotResult value for this PTG_StationOfDepotResponse.
     * 
     * @param PTG_StationOfDepotResult
     */
    public void setPTG_StationOfDepotResult(org.tempuri.PTG_StationOfDepotResponsePTG_StationOfDepotResult PTG_StationOfDepotResult) {
        this.PTG_StationOfDepotResult = PTG_StationOfDepotResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PTG_StationOfDepotResponse)) return false;
        PTG_StationOfDepotResponse other = (PTG_StationOfDepotResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.PTG_StationOfDepotResult==null && other.getPTG_StationOfDepotResult()==null) || 
             (this.PTG_StationOfDepotResult!=null &&
              this.PTG_StationOfDepotResult.equals(other.getPTG_StationOfDepotResult())));
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
        if (getPTG_StationOfDepotResult() != null) {
            _hashCode += getPTG_StationOfDepotResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PTG_StationOfDepotResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">PTG_StationOfDepotResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PTG_StationOfDepotResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "PTG_StationOfDepotResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>PTG_StationOfDepotResponse>PTG_StationOfDepotResult"));
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
