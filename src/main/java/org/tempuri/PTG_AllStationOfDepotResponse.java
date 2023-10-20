/**
 * PTG_AllStationOfDepotResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class PTG_AllStationOfDepotResponse  implements java.io.Serializable {
    private org.tempuri.PTG_AllStationOfDepotResponsePTG_AllStationOfDepotResult PTG_AllStationOfDepotResult;

    public PTG_AllStationOfDepotResponse() {
    }

    public PTG_AllStationOfDepotResponse(
           org.tempuri.PTG_AllStationOfDepotResponsePTG_AllStationOfDepotResult PTG_AllStationOfDepotResult) {
           this.PTG_AllStationOfDepotResult = PTG_AllStationOfDepotResult;
    }


    /**
     * Gets the PTG_AllStationOfDepotResult value for this PTG_AllStationOfDepotResponse.
     * 
     * @return PTG_AllStationOfDepotResult
     */
    public org.tempuri.PTG_AllStationOfDepotResponsePTG_AllStationOfDepotResult getPTG_AllStationOfDepotResult() {
        return PTG_AllStationOfDepotResult;
    }


    /**
     * Sets the PTG_AllStationOfDepotResult value for this PTG_AllStationOfDepotResponse.
     * 
     * @param PTG_AllStationOfDepotResult
     */
    public void setPTG_AllStationOfDepotResult(org.tempuri.PTG_AllStationOfDepotResponsePTG_AllStationOfDepotResult PTG_AllStationOfDepotResult) {
        this.PTG_AllStationOfDepotResult = PTG_AllStationOfDepotResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PTG_AllStationOfDepotResponse)) return false;
        PTG_AllStationOfDepotResponse other = (PTG_AllStationOfDepotResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.PTG_AllStationOfDepotResult==null && other.getPTG_AllStationOfDepotResult()==null) || 
             (this.PTG_AllStationOfDepotResult!=null &&
              this.PTG_AllStationOfDepotResult.equals(other.getPTG_AllStationOfDepotResult())));
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
        if (getPTG_AllStationOfDepotResult() != null) {
            _hashCode += getPTG_AllStationOfDepotResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PTG_AllStationOfDepotResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">PTG_AllStationOfDepotResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PTG_AllStationOfDepotResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "PTG_AllStationOfDepotResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>PTG_AllStationOfDepotResponse>PTG_AllStationOfDepotResult"));
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
