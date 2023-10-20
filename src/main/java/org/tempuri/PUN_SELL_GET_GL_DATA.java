/**
 * PUN_SELL_GET_GL_DATA.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class PUN_SELL_GET_GL_DATA  implements java.io.Serializable {
    private java.lang.String punSellDataInterfaceAxJSON;

    public PUN_SELL_GET_GL_DATA() {
    }

    public PUN_SELL_GET_GL_DATA(
           java.lang.String punSellDataInterfaceAxJSON) {
           this.punSellDataInterfaceAxJSON = punSellDataInterfaceAxJSON;
    }


    /**
     * Gets the punSellDataInterfaceAxJSON value for this PUN_SELL_GET_GL_DATA.
     * 
     * @return punSellDataInterfaceAxJSON
     */
    public java.lang.String getPunSellDataInterfaceAxJSON() {
        return punSellDataInterfaceAxJSON;
    }


    /**
     * Sets the punSellDataInterfaceAxJSON value for this PUN_SELL_GET_GL_DATA.
     * 
     * @param punSellDataInterfaceAxJSON
     */
    public void setPunSellDataInterfaceAxJSON(java.lang.String punSellDataInterfaceAxJSON) {
        this.punSellDataInterfaceAxJSON = punSellDataInterfaceAxJSON;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PUN_SELL_GET_GL_DATA)) return false;
        PUN_SELL_GET_GL_DATA other = (PUN_SELL_GET_GL_DATA) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.punSellDataInterfaceAxJSON==null && other.getPunSellDataInterfaceAxJSON()==null) || 
             (this.punSellDataInterfaceAxJSON!=null &&
              this.punSellDataInterfaceAxJSON.equals(other.getPunSellDataInterfaceAxJSON())));
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
        if (getPunSellDataInterfaceAxJSON() != null) {
            _hashCode += getPunSellDataInterfaceAxJSON().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PUN_SELL_GET_GL_DATA.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">PUN_SELL_GET_GL_DATA"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("punSellDataInterfaceAxJSON");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "punSellDataInterfaceAxJSON"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
