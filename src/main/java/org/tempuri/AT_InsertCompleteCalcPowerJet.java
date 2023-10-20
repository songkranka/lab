/**
 * AT_InsertCompleteCalcPowerJet.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AT_InsertCompleteCalcPowerJet  implements java.io.Serializable {
    private java.lang.String sOLDComp;

    private java.lang.String sDepotBrn;

    private java.lang.String sDepotBrnName;

    private org.tempuri.AT_InsertCompleteCalcPowerJetODTB oDTB;

    private java.lang.String sFileName;

    public AT_InsertCompleteCalcPowerJet() {
    }

    public AT_InsertCompleteCalcPowerJet(
           java.lang.String sOLDComp,
           java.lang.String sDepotBrn,
           java.lang.String sDepotBrnName,
           org.tempuri.AT_InsertCompleteCalcPowerJetODTB oDTB,
           java.lang.String sFileName) {
           this.sOLDComp = sOLDComp;
           this.sDepotBrn = sDepotBrn;
           this.sDepotBrnName = sDepotBrnName;
           this.oDTB = oDTB;
           this.sFileName = sFileName;
    }


    /**
     * Gets the sOLDComp value for this AT_InsertCompleteCalcPowerJet.
     * 
     * @return sOLDComp
     */
    public java.lang.String getSOLDComp() {
        return sOLDComp;
    }


    /**
     * Sets the sOLDComp value for this AT_InsertCompleteCalcPowerJet.
     * 
     * @param sOLDComp
     */
    public void setSOLDComp(java.lang.String sOLDComp) {
        this.sOLDComp = sOLDComp;
    }


    /**
     * Gets the sDepotBrn value for this AT_InsertCompleteCalcPowerJet.
     * 
     * @return sDepotBrn
     */
    public java.lang.String getSDepotBrn() {
        return sDepotBrn;
    }


    /**
     * Sets the sDepotBrn value for this AT_InsertCompleteCalcPowerJet.
     * 
     * @param sDepotBrn
     */
    public void setSDepotBrn(java.lang.String sDepotBrn) {
        this.sDepotBrn = sDepotBrn;
    }


    /**
     * Gets the sDepotBrnName value for this AT_InsertCompleteCalcPowerJet.
     * 
     * @return sDepotBrnName
     */
    public java.lang.String getSDepotBrnName() {
        return sDepotBrnName;
    }


    /**
     * Sets the sDepotBrnName value for this AT_InsertCompleteCalcPowerJet.
     * 
     * @param sDepotBrnName
     */
    public void setSDepotBrnName(java.lang.String sDepotBrnName) {
        this.sDepotBrnName = sDepotBrnName;
    }


    /**
     * Gets the oDTB value for this AT_InsertCompleteCalcPowerJet.
     * 
     * @return oDTB
     */
    public org.tempuri.AT_InsertCompleteCalcPowerJetODTB getODTB() {
        return oDTB;
    }


    /**
     * Sets the oDTB value for this AT_InsertCompleteCalcPowerJet.
     * 
     * @param oDTB
     */
    public void setODTB(org.tempuri.AT_InsertCompleteCalcPowerJetODTB oDTB) {
        this.oDTB = oDTB;
    }


    /**
     * Gets the sFileName value for this AT_InsertCompleteCalcPowerJet.
     * 
     * @return sFileName
     */
    public java.lang.String getSFileName() {
        return sFileName;
    }


    /**
     * Sets the sFileName value for this AT_InsertCompleteCalcPowerJet.
     * 
     * @param sFileName
     */
    public void setSFileName(java.lang.String sFileName) {
        this.sFileName = sFileName;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AT_InsertCompleteCalcPowerJet)) return false;
        AT_InsertCompleteCalcPowerJet other = (AT_InsertCompleteCalcPowerJet) obj;
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
            ((this.sDepotBrnName==null && other.getSDepotBrnName()==null) || 
             (this.sDepotBrnName!=null &&
              this.sDepotBrnName.equals(other.getSDepotBrnName()))) &&
            ((this.oDTB==null && other.getODTB()==null) || 
             (this.oDTB!=null &&
              this.oDTB.equals(other.getODTB()))) &&
            ((this.sFileName==null && other.getSFileName()==null) || 
             (this.sFileName!=null &&
              this.sFileName.equals(other.getSFileName())));
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
        if (getSDepotBrnName() != null) {
            _hashCode += getSDepotBrnName().hashCode();
        }
        if (getODTB() != null) {
            _hashCode += getODTB().hashCode();
        }
        if (getSFileName() != null) {
            _hashCode += getSFileName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AT_InsertCompleteCalcPowerJet.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AT_InsertCompleteCalcPowerJet"));
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
        elemField.setFieldName("SDepotBrnName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "sDepotBrnName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ODTB");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "oDTB"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>AT_InsertCompleteCalcPowerJet>oDTB"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SFileName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "sFileName"));
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
