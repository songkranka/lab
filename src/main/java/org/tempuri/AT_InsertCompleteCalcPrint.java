/**
 * AT_InsertCompleteCalcPrint.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AT_InsertCompleteCalcPrint  implements java.io.Serializable {
    private java.lang.String sOLDComp;

    private java.lang.String sDepotBrn;

    private org.tempuri.AT_InsertCompleteCalcPrintODTB oDTB;

    private java.lang.String sFileName;

    private java.lang.String sBrnName;

    public AT_InsertCompleteCalcPrint() {
    }

    public AT_InsertCompleteCalcPrint(
           java.lang.String sOLDComp,
           java.lang.String sDepotBrn,
           org.tempuri.AT_InsertCompleteCalcPrintODTB oDTB,
           java.lang.String sFileName,
           java.lang.String sBrnName) {
           this.sOLDComp = sOLDComp;
           this.sDepotBrn = sDepotBrn;
           this.oDTB = oDTB;
           this.sFileName = sFileName;
           this.sBrnName = sBrnName;
    }


    /**
     * Gets the sOLDComp value for this AT_InsertCompleteCalcPrint.
     * 
     * @return sOLDComp
     */
    public java.lang.String getSOLDComp() {
        return sOLDComp;
    }


    /**
     * Sets the sOLDComp value for this AT_InsertCompleteCalcPrint.
     * 
     * @param sOLDComp
     */
    public void setSOLDComp(java.lang.String sOLDComp) {
        this.sOLDComp = sOLDComp;
    }


    /**
     * Gets the sDepotBrn value for this AT_InsertCompleteCalcPrint.
     * 
     * @return sDepotBrn
     */
    public java.lang.String getSDepotBrn() {
        return sDepotBrn;
    }


    /**
     * Sets the sDepotBrn value for this AT_InsertCompleteCalcPrint.
     * 
     * @param sDepotBrn
     */
    public void setSDepotBrn(java.lang.String sDepotBrn) {
        this.sDepotBrn = sDepotBrn;
    }


    /**
     * Gets the oDTB value for this AT_InsertCompleteCalcPrint.
     * 
     * @return oDTB
     */
    public org.tempuri.AT_InsertCompleteCalcPrintODTB getODTB() {
        return oDTB;
    }


    /**
     * Sets the oDTB value for this AT_InsertCompleteCalcPrint.
     * 
     * @param oDTB
     */
    public void setODTB(org.tempuri.AT_InsertCompleteCalcPrintODTB oDTB) {
        this.oDTB = oDTB;
    }


    /**
     * Gets the sFileName value for this AT_InsertCompleteCalcPrint.
     * 
     * @return sFileName
     */
    public java.lang.String getSFileName() {
        return sFileName;
    }


    /**
     * Sets the sFileName value for this AT_InsertCompleteCalcPrint.
     * 
     * @param sFileName
     */
    public void setSFileName(java.lang.String sFileName) {
        this.sFileName = sFileName;
    }


    /**
     * Gets the sBrnName value for this AT_InsertCompleteCalcPrint.
     * 
     * @return sBrnName
     */
    public java.lang.String getSBrnName() {
        return sBrnName;
    }


    /**
     * Sets the sBrnName value for this AT_InsertCompleteCalcPrint.
     * 
     * @param sBrnName
     */
    public void setSBrnName(java.lang.String sBrnName) {
        this.sBrnName = sBrnName;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AT_InsertCompleteCalcPrint)) return false;
        AT_InsertCompleteCalcPrint other = (AT_InsertCompleteCalcPrint) obj;
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
            ((this.oDTB==null && other.getODTB()==null) || 
             (this.oDTB!=null &&
              this.oDTB.equals(other.getODTB()))) &&
            ((this.sFileName==null && other.getSFileName()==null) || 
             (this.sFileName!=null &&
              this.sFileName.equals(other.getSFileName()))) &&
            ((this.sBrnName==null && other.getSBrnName()==null) || 
             (this.sBrnName!=null &&
              this.sBrnName.equals(other.getSBrnName())));
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
        if (getODTB() != null) {
            _hashCode += getODTB().hashCode();
        }
        if (getSFileName() != null) {
            _hashCode += getSFileName().hashCode();
        }
        if (getSBrnName() != null) {
            _hashCode += getSBrnName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AT_InsertCompleteCalcPrint.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AT_InsertCompleteCalcPrint"));
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
        elemField.setFieldName("ODTB");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "oDTB"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>AT_InsertCompleteCalcPrint>oDTB"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SBrnName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "sBrnName"));
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
