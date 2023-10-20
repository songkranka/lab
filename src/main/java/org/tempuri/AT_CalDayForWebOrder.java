/**
 * AT_CalDayForWebOrder.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AT_CalDayForWebOrder  implements java.io.Serializable {
    private java.lang.String sOLDComp;

    private java.lang.String sDepotBrn;

    private java.lang.String sStationbrn;

    private double dRotationPolicy;

    private int iAverageSell;

    private int iAheadago;

    public AT_CalDayForWebOrder() {
    }

    public AT_CalDayForWebOrder(
           java.lang.String sOLDComp,
           java.lang.String sDepotBrn,
           java.lang.String sStationbrn,
           double dRotationPolicy,
           int iAverageSell,
           int iAheadago) {
           this.sOLDComp = sOLDComp;
           this.sDepotBrn = sDepotBrn;
           this.sStationbrn = sStationbrn;
           this.dRotationPolicy = dRotationPolicy;
           this.iAverageSell = iAverageSell;
           this.iAheadago = iAheadago;
    }


    /**
     * Gets the sOLDComp value for this AT_CalDayForWebOrder.
     * 
     * @return sOLDComp
     */
    public java.lang.String getSOLDComp() {
        return sOLDComp;
    }


    /**
     * Sets the sOLDComp value for this AT_CalDayForWebOrder.
     * 
     * @param sOLDComp
     */
    public void setSOLDComp(java.lang.String sOLDComp) {
        this.sOLDComp = sOLDComp;
    }


    /**
     * Gets the sDepotBrn value for this AT_CalDayForWebOrder.
     * 
     * @return sDepotBrn
     */
    public java.lang.String getSDepotBrn() {
        return sDepotBrn;
    }


    /**
     * Sets the sDepotBrn value for this AT_CalDayForWebOrder.
     * 
     * @param sDepotBrn
     */
    public void setSDepotBrn(java.lang.String sDepotBrn) {
        this.sDepotBrn = sDepotBrn;
    }


    /**
     * Gets the sStationbrn value for this AT_CalDayForWebOrder.
     * 
     * @return sStationbrn
     */
    public java.lang.String getSStationbrn() {
        return sStationbrn;
    }


    /**
     * Sets the sStationbrn value for this AT_CalDayForWebOrder.
     * 
     * @param sStationbrn
     */
    public void setSStationbrn(java.lang.String sStationbrn) {
        this.sStationbrn = sStationbrn;
    }


    /**
     * Gets the dRotationPolicy value for this AT_CalDayForWebOrder.
     * 
     * @return dRotationPolicy
     */
    public double getDRotationPolicy() {
        return dRotationPolicy;
    }


    /**
     * Sets the dRotationPolicy value for this AT_CalDayForWebOrder.
     * 
     * @param dRotationPolicy
     */
    public void setDRotationPolicy(double dRotationPolicy) {
        this.dRotationPolicy = dRotationPolicy;
    }


    /**
     * Gets the iAverageSell value for this AT_CalDayForWebOrder.
     * 
     * @return iAverageSell
     */
    public int getIAverageSell() {
        return iAverageSell;
    }


    /**
     * Sets the iAverageSell value for this AT_CalDayForWebOrder.
     * 
     * @param iAverageSell
     */
    public void setIAverageSell(int iAverageSell) {
        this.iAverageSell = iAverageSell;
    }


    /**
     * Gets the iAheadago value for this AT_CalDayForWebOrder.
     * 
     * @return iAheadago
     */
    public int getIAheadago() {
        return iAheadago;
    }


    /**
     * Sets the iAheadago value for this AT_CalDayForWebOrder.
     * 
     * @param iAheadago
     */
    public void setIAheadago(int iAheadago) {
        this.iAheadago = iAheadago;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AT_CalDayForWebOrder)) return false;
        AT_CalDayForWebOrder other = (AT_CalDayForWebOrder) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.sOLDComp==null && other.getSOLDComp()==null) || 
             (this.sOLDComp!=null &&
              this.sOLDComp.equals(other.getSOLDComp()))) &&
            ((this.sDepotBrn==null && other.getSDepotBrn()==null) || 
             (this.sDepotBrn!=null &&
              this.sDepotBrn.equals(other.getSDepotBrn()))) &&
            ((this.sStationbrn==null && other.getSStationbrn()==null) || 
             (this.sStationbrn!=null &&
              this.sStationbrn.equals(other.getSStationbrn()))) &&
            this.dRotationPolicy == other.getDRotationPolicy() &&
            this.iAverageSell == other.getIAverageSell() &&
            this.iAheadago == other.getIAheadago();
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
        if (getSOLDComp() != null) {
            _hashCode += getSOLDComp().hashCode();
        }
        if (getSDepotBrn() != null) {
            _hashCode += getSDepotBrn().hashCode();
        }
        if (getSStationbrn() != null) {
            _hashCode += getSStationbrn().hashCode();
        }
        _hashCode += new Double(getDRotationPolicy()).hashCode();
        _hashCode += getIAverageSell();
        _hashCode += getIAheadago();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AT_CalDayForWebOrder.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AT_CalDayForWebOrder"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SOLDComp");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "sOLDComp"));
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
        elemField.setFieldName("SStationbrn");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "sStationbrn"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DRotationPolicy");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "dRotationPolicy"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IAverageSell");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "iAverageSell"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IAheadago");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "iAheadago"));
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
