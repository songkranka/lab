/**
 * AT_PrintToStationSAPNoShipment.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AT_PrintToStationSAPNoShipment  implements java.io.Serializable {
    private org.tempuri.AT_PrintToStationSAPNoShipmentODTB oDTB;

    public AT_PrintToStationSAPNoShipment() {
    }

    public AT_PrintToStationSAPNoShipment(
           org.tempuri.AT_PrintToStationSAPNoShipmentODTB oDTB) {
           this.oDTB = oDTB;
    }


    /**
     * Gets the oDTB value for this AT_PrintToStationSAPNoShipment.
     * 
     * @return oDTB
     */
    public org.tempuri.AT_PrintToStationSAPNoShipmentODTB getODTB() {
        return oDTB;
    }


    /**
     * Sets the oDTB value for this AT_PrintToStationSAPNoShipment.
     * 
     * @param oDTB
     */
    public void setODTB(org.tempuri.AT_PrintToStationSAPNoShipmentODTB oDTB) {
        this.oDTB = oDTB;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AT_PrintToStationSAPNoShipment)) return false;
        AT_PrintToStationSAPNoShipment other = (AT_PrintToStationSAPNoShipment) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.oDTB==null && other.getODTB()==null) || 
             (this.oDTB!=null &&
              this.oDTB.equals(other.getODTB())));
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
        if (getODTB() != null) {
            _hashCode += getODTB().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AT_PrintToStationSAPNoShipment.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AT_PrintToStationSAPNoShipment"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ODTB");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "oDTB"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>AT_PrintToStationSAPNoShipment>oDTB"));
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
