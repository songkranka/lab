/**
 * AT_UpdatePolicy.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AT_UpdatePolicy  implements java.io.Serializable {
    private java.lang.String sDepotComp;

    private java.lang.String sDepotBrn;

    private double dRotateDay;

    private int iDayAvgSell;

    public AT_UpdatePolicy() {
    }

    public AT_UpdatePolicy(
           java.lang.String sDepotComp,
           java.lang.String sDepotBrn,
           double dRotateDay,
           int iDayAvgSell) {
           this.sDepotComp = sDepotComp;
           this.sDepotBrn = sDepotBrn;
           this.dRotateDay = dRotateDay;
           this.iDayAvgSell = iDayAvgSell;
    }


    /**
     * Gets the sDepotComp value for this AT_UpdatePolicy.
     * 
     * @return sDepotComp
     */
    public java.lang.String getSDepotComp() {
        return sDepotComp;
    }


    /**
     * Sets the sDepotComp value for this AT_UpdatePolicy.
     * 
     * @param sDepotComp
     */
    public void setSDepotComp(java.lang.String sDepotComp) {
        this.sDepotComp = sDepotComp;
    }


    /**
     * Gets the sDepotBrn value for this AT_UpdatePolicy.
     * 
     * @return sDepotBrn
     */
    public java.lang.String getSDepotBrn() {
        return sDepotBrn;
    }


    /**
     * Sets the sDepotBrn value for this AT_UpdatePolicy.
     * 
     * @param sDepotBrn
     */
    public void setSDepotBrn(java.lang.String sDepotBrn) {
        this.sDepotBrn = sDepotBrn;
    }


    /**
     * Gets the dRotateDay value for this AT_UpdatePolicy.
     * 
     * @return dRotateDay
     */
    public double getDRotateDay() {
        return dRotateDay;
    }


    /**
     * Sets the dRotateDay value for this AT_UpdatePolicy.
     * 
     * @param dRotateDay
     */
    public void setDRotateDay(double dRotateDay) {
        this.dRotateDay = dRotateDay;
    }


    /**
     * Gets the iDayAvgSell value for this AT_UpdatePolicy.
     * 
     * @return iDayAvgSell
     */
    public int getIDayAvgSell() {
        return iDayAvgSell;
    }


    /**
     * Sets the iDayAvgSell value for this AT_UpdatePolicy.
     * 
     * @param iDayAvgSell
     */
    public void setIDayAvgSell(int iDayAvgSell) {
        this.iDayAvgSell = iDayAvgSell;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AT_UpdatePolicy)) return false;
        AT_UpdatePolicy other = (AT_UpdatePolicy) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.sDepotComp==null && other.getSDepotComp()==null) || 
             (this.sDepotComp!=null &&
              this.sDepotComp.equals(other.getSDepotComp()))) &&
            ((this.sDepotBrn==null && other.getSDepotBrn()==null) || 
             (this.sDepotBrn!=null &&
              this.sDepotBrn.equals(other.getSDepotBrn()))) &&
            this.dRotateDay == other.getDRotateDay() &&
            this.iDayAvgSell == other.getIDayAvgSell();
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
        if (getSDepotComp() != null) {
            _hashCode += getSDepotComp().hashCode();
        }
        if (getSDepotBrn() != null) {
            _hashCode += getSDepotBrn().hashCode();
        }
        _hashCode += new Double(getDRotateDay()).hashCode();
        _hashCode += getIDayAvgSell();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AT_UpdatePolicy.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AT_UpdatePolicy"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SDepotComp");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "sDepotComp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SDepotBrn");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "sDepotBrn"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DRotateDay");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "dRotateDay"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IDayAvgSell");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "iDayAvgSell"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
