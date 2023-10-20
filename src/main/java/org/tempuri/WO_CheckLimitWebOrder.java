/**
 * WO_CheckLimitWebOrder.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class WO_CheckLimitWebOrder  implements java.io.Serializable {
    private java.lang.String sCstno;

    public WO_CheckLimitWebOrder() {
    }

    public WO_CheckLimitWebOrder(
           java.lang.String sCstno) {
           this.sCstno = sCstno;
    }


    /**
     * Gets the sCstno value for this WO_CheckLimitWebOrder.
     * 
     * @return sCstno
     */
    public java.lang.String getSCstno() {
        return sCstno;
    }


    /**
     * Sets the sCstno value for this WO_CheckLimitWebOrder.
     * 
     * @param sCstno
     */
    public void setSCstno(java.lang.String sCstno) {
        this.sCstno = sCstno;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WO_CheckLimitWebOrder)) return false;
        WO_CheckLimitWebOrder other = (WO_CheckLimitWebOrder) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.sCstno==null && other.getSCstno()==null) || 
             (this.sCstno!=null &&
              this.sCstno.equals(other.getSCstno())));
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
        if (getSCstno() != null) {
            _hashCode += getSCstno().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WO_CheckLimitWebOrder.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">WO_CheckLimitWebOrder"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SCstno");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "sCstno"));
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
