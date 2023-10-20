/**
 * WebStationGetLotus.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class WebStationGetLotus  implements java.io.Serializable {
    private java.lang.String comp;

    private java.lang.String brn;

    private java.lang.String stkdate;

    public WebStationGetLotus() {
    }

    public WebStationGetLotus(
           java.lang.String comp,
           java.lang.String brn,
           java.lang.String stkdate) {
           this.comp = comp;
           this.brn = brn;
           this.stkdate = stkdate;
    }


    /**
     * Gets the comp value for this WebStationGetLotus.
     * 
     * @return comp
     */
    public java.lang.String getComp() {
        return comp;
    }


    /**
     * Sets the comp value for this WebStationGetLotus.
     * 
     * @param comp
     */
    public void setComp(java.lang.String comp) {
        this.comp = comp;
    }


    /**
     * Gets the brn value for this WebStationGetLotus.
     * 
     * @return brn
     */
    public java.lang.String getBrn() {
        return brn;
    }


    /**
     * Sets the brn value for this WebStationGetLotus.
     * 
     * @param brn
     */
    public void setBrn(java.lang.String brn) {
        this.brn = brn;
    }


    /**
     * Gets the stkdate value for this WebStationGetLotus.
     * 
     * @return stkdate
     */
    public java.lang.String getStkdate() {
        return stkdate;
    }


    /**
     * Sets the stkdate value for this WebStationGetLotus.
     * 
     * @param stkdate
     */
    public void setStkdate(java.lang.String stkdate) {
        this.stkdate = stkdate;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WebStationGetLotus)) return false;
        WebStationGetLotus other = (WebStationGetLotus) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.comp==null && other.getComp()==null) || 
             (this.comp!=null &&
              this.comp.equals(other.getComp()))) &&
            ((this.brn==null && other.getBrn()==null) || 
             (this.brn!=null &&
              this.brn.equals(other.getBrn()))) &&
            ((this.stkdate==null && other.getStkdate()==null) || 
             (this.stkdate!=null &&
              this.stkdate.equals(other.getStkdate())));
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
        if (getComp() != null) {
            _hashCode += getComp().hashCode();
        }
        if (getBrn() != null) {
            _hashCode += getBrn().hashCode();
        }
        if (getStkdate() != null) {
            _hashCode += getStkdate().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WebStationGetLotus.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">webStationGetLotus"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("comp");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "comp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("brn");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "brn"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stkdate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "stkdate"));
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
