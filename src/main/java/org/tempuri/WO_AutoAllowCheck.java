/**
 * WO_AutoAllowCheck.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class WO_AutoAllowCheck  implements java.io.Serializable {
    private java.lang.String sOrderNo;

    private double dCustLimit;

    public WO_AutoAllowCheck() {
    }

    public WO_AutoAllowCheck(
           java.lang.String sOrderNo,
           double dCustLimit) {
           this.sOrderNo = sOrderNo;
           this.dCustLimit = dCustLimit;
    }


    /**
     * Gets the sOrderNo value for this WO_AutoAllowCheck.
     * 
     * @return sOrderNo
     */
    public java.lang.String getSOrderNo() {
        return sOrderNo;
    }


    /**
     * Sets the sOrderNo value for this WO_AutoAllowCheck.
     * 
     * @param sOrderNo
     */
    public void setSOrderNo(java.lang.String sOrderNo) {
        this.sOrderNo = sOrderNo;
    }


    /**
     * Gets the dCustLimit value for this WO_AutoAllowCheck.
     * 
     * @return dCustLimit
     */
    public double getDCustLimit() {
        return dCustLimit;
    }


    /**
     * Sets the dCustLimit value for this WO_AutoAllowCheck.
     * 
     * @param dCustLimit
     */
    public void setDCustLimit(double dCustLimit) {
        this.dCustLimit = dCustLimit;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WO_AutoAllowCheck)) return false;
        WO_AutoAllowCheck other = (WO_AutoAllowCheck) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.sOrderNo==null && other.getSOrderNo()==null) || 
             (this.sOrderNo!=null &&
              this.sOrderNo.equals(other.getSOrderNo()))) &&
            this.dCustLimit == other.getDCustLimit();
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
        if (getSOrderNo() != null) {
            _hashCode += getSOrderNo().hashCode();
        }
        _hashCode += new Double(getDCustLimit()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WO_AutoAllowCheck.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">WO_AutoAllowCheck"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SOrderNo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "sOrderNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DCustLimit");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "dCustLimit"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
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
