/**
 * AT_InsertAutoLupe.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AT_InsertAutoLupe  implements java.io.Serializable {
    private java.lang.String sOLDComp;

    private java.lang.String sDepotBrn;

    private java.lang.String brnCode;

    private java.lang.String brnName;

    private java.lang.String lupeCode;

    private java.lang.String lupeName;

    private java.lang.String lupeType;

    private java.lang.String sCmd;

    public AT_InsertAutoLupe() {
    }

    public AT_InsertAutoLupe(
           java.lang.String sOLDComp,
           java.lang.String sDepotBrn,
           java.lang.String brnCode,
           java.lang.String brnName,
           java.lang.String lupeCode,
           java.lang.String lupeName,
           java.lang.String lupeType,
           java.lang.String sCmd) {
           this.sOLDComp = sOLDComp;
           this.sDepotBrn = sDepotBrn;
           this.brnCode = brnCode;
           this.brnName = brnName;
           this.lupeCode = lupeCode;
           this.lupeName = lupeName;
           this.lupeType = lupeType;
           this.sCmd = sCmd;
    }


    /**
     * Gets the sOLDComp value for this AT_InsertAutoLupe.
     * 
     * @return sOLDComp
     */
    public java.lang.String getSOLDComp() {
        return sOLDComp;
    }


    /**
     * Sets the sOLDComp value for this AT_InsertAutoLupe.
     * 
     * @param sOLDComp
     */
    public void setSOLDComp(java.lang.String sOLDComp) {
        this.sOLDComp = sOLDComp;
    }


    /**
     * Gets the sDepotBrn value for this AT_InsertAutoLupe.
     * 
     * @return sDepotBrn
     */
    public java.lang.String getSDepotBrn() {
        return sDepotBrn;
    }


    /**
     * Sets the sDepotBrn value for this AT_InsertAutoLupe.
     * 
     * @param sDepotBrn
     */
    public void setSDepotBrn(java.lang.String sDepotBrn) {
        this.sDepotBrn = sDepotBrn;
    }


    /**
     * Gets the brnCode value for this AT_InsertAutoLupe.
     * 
     * @return brnCode
     */
    public java.lang.String getBrnCode() {
        return brnCode;
    }


    /**
     * Sets the brnCode value for this AT_InsertAutoLupe.
     * 
     * @param brnCode
     */
    public void setBrnCode(java.lang.String brnCode) {
        this.brnCode = brnCode;
    }


    /**
     * Gets the brnName value for this AT_InsertAutoLupe.
     * 
     * @return brnName
     */
    public java.lang.String getBrnName() {
        return brnName;
    }


    /**
     * Sets the brnName value for this AT_InsertAutoLupe.
     * 
     * @param brnName
     */
    public void setBrnName(java.lang.String brnName) {
        this.brnName = brnName;
    }


    /**
     * Gets the lupeCode value for this AT_InsertAutoLupe.
     * 
     * @return lupeCode
     */
    public java.lang.String getLupeCode() {
        return lupeCode;
    }


    /**
     * Sets the lupeCode value for this AT_InsertAutoLupe.
     * 
     * @param lupeCode
     */
    public void setLupeCode(java.lang.String lupeCode) {
        this.lupeCode = lupeCode;
    }


    /**
     * Gets the lupeName value for this AT_InsertAutoLupe.
     * 
     * @return lupeName
     */
    public java.lang.String getLupeName() {
        return lupeName;
    }


    /**
     * Sets the lupeName value for this AT_InsertAutoLupe.
     * 
     * @param lupeName
     */
    public void setLupeName(java.lang.String lupeName) {
        this.lupeName = lupeName;
    }


    /**
     * Gets the lupeType value for this AT_InsertAutoLupe.
     * 
     * @return lupeType
     */
    public java.lang.String getLupeType() {
        return lupeType;
    }


    /**
     * Sets the lupeType value for this AT_InsertAutoLupe.
     * 
     * @param lupeType
     */
    public void setLupeType(java.lang.String lupeType) {
        this.lupeType = lupeType;
    }


    /**
     * Gets the sCmd value for this AT_InsertAutoLupe.
     * 
     * @return sCmd
     */
    public java.lang.String getSCmd() {
        return sCmd;
    }


    /**
     * Sets the sCmd value for this AT_InsertAutoLupe.
     * 
     * @param sCmd
     */
    public void setSCmd(java.lang.String sCmd) {
        this.sCmd = sCmd;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AT_InsertAutoLupe)) return false;
        AT_InsertAutoLupe other = (AT_InsertAutoLupe) obj;
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
            ((this.brnCode==null && other.getBrnCode()==null) || 
             (this.brnCode!=null &&
              this.brnCode.equals(other.getBrnCode()))) &&
            ((this.brnName==null && other.getBrnName()==null) || 
             (this.brnName!=null &&
              this.brnName.equals(other.getBrnName()))) &&
            ((this.lupeCode==null && other.getLupeCode()==null) || 
             (this.lupeCode!=null &&
              this.lupeCode.equals(other.getLupeCode()))) &&
            ((this.lupeName==null && other.getLupeName()==null) || 
             (this.lupeName!=null &&
              this.lupeName.equals(other.getLupeName()))) &&
            ((this.lupeType==null && other.getLupeType()==null) || 
             (this.lupeType!=null &&
              this.lupeType.equals(other.getLupeType()))) &&
            ((this.sCmd==null && other.getSCmd()==null) || 
             (this.sCmd!=null &&
              this.sCmd.equals(other.getSCmd())));
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
        if (getBrnCode() != null) {
            _hashCode += getBrnCode().hashCode();
        }
        if (getBrnName() != null) {
            _hashCode += getBrnName().hashCode();
        }
        if (getLupeCode() != null) {
            _hashCode += getLupeCode().hashCode();
        }
        if (getLupeName() != null) {
            _hashCode += getLupeName().hashCode();
        }
        if (getLupeType() != null) {
            _hashCode += getLupeType().hashCode();
        }
        if (getSCmd() != null) {
            _hashCode += getSCmd().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AT_InsertAutoLupe.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AT_InsertAutoLupe"));
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
        elemField.setFieldName("brnCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "BrnCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("brnName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "BrnName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lupeCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "LupeCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lupeName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "LupeName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lupeType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "LupeType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SCmd");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "sCmd"));
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
