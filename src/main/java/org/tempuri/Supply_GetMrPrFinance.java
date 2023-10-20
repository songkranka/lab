/**
 * Supply_GetMrPrFinance.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class Supply_GetMrPrFinance  implements java.io.Serializable {
    private java.lang.String sSupplier;

    private java.lang.String sComp;

    private java.lang.String sBrn;

    private java.lang.String sLocation;

    private java.lang.String sStDate;

    private java.lang.String sSpDate;

    public Supply_GetMrPrFinance() {
    }

    public Supply_GetMrPrFinance(
           java.lang.String sSupplier,
           java.lang.String sComp,
           java.lang.String sBrn,
           java.lang.String sLocation,
           java.lang.String sStDate,
           java.lang.String sSpDate) {
           this.sSupplier = sSupplier;
           this.sComp = sComp;
           this.sBrn = sBrn;
           this.sLocation = sLocation;
           this.sStDate = sStDate;
           this.sSpDate = sSpDate;
    }


    /**
     * Gets the sSupplier value for this Supply_GetMrPrFinance.
     * 
     * @return sSupplier
     */
    public java.lang.String getSSupplier() {
        return sSupplier;
    }


    /**
     * Sets the sSupplier value for this Supply_GetMrPrFinance.
     * 
     * @param sSupplier
     */
    public void setSSupplier(java.lang.String sSupplier) {
        this.sSupplier = sSupplier;
    }


    /**
     * Gets the sComp value for this Supply_GetMrPrFinance.
     * 
     * @return sComp
     */
    public java.lang.String getSComp() {
        return sComp;
    }


    /**
     * Sets the sComp value for this Supply_GetMrPrFinance.
     * 
     * @param sComp
     */
    public void setSComp(java.lang.String sComp) {
        this.sComp = sComp;
    }


    /**
     * Gets the sBrn value for this Supply_GetMrPrFinance.
     * 
     * @return sBrn
     */
    public java.lang.String getSBrn() {
        return sBrn;
    }


    /**
     * Sets the sBrn value for this Supply_GetMrPrFinance.
     * 
     * @param sBrn
     */
    public void setSBrn(java.lang.String sBrn) {
        this.sBrn = sBrn;
    }


    /**
     * Gets the sLocation value for this Supply_GetMrPrFinance.
     * 
     * @return sLocation
     */
    public java.lang.String getSLocation() {
        return sLocation;
    }


    /**
     * Sets the sLocation value for this Supply_GetMrPrFinance.
     * 
     * @param sLocation
     */
    public void setSLocation(java.lang.String sLocation) {
        this.sLocation = sLocation;
    }


    /**
     * Gets the sStDate value for this Supply_GetMrPrFinance.
     * 
     * @return sStDate
     */
    public java.lang.String getSStDate() {
        return sStDate;
    }


    /**
     * Sets the sStDate value for this Supply_GetMrPrFinance.
     * 
     * @param sStDate
     */
    public void setSStDate(java.lang.String sStDate) {
        this.sStDate = sStDate;
    }


    /**
     * Gets the sSpDate value for this Supply_GetMrPrFinance.
     * 
     * @return sSpDate
     */
    public java.lang.String getSSpDate() {
        return sSpDate;
    }


    /**
     * Sets the sSpDate value for this Supply_GetMrPrFinance.
     * 
     * @param sSpDate
     */
    public void setSSpDate(java.lang.String sSpDate) {
        this.sSpDate = sSpDate;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Supply_GetMrPrFinance)) return false;
        Supply_GetMrPrFinance other = (Supply_GetMrPrFinance) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.sSupplier==null && other.getSSupplier()==null) || 
             (this.sSupplier!=null &&
              this.sSupplier.equals(other.getSSupplier()))) &&
            ((this.sComp==null && other.getSComp()==null) || 
             (this.sComp!=null &&
              this.sComp.equals(other.getSComp()))) &&
            ((this.sBrn==null && other.getSBrn()==null) || 
             (this.sBrn!=null &&
              this.sBrn.equals(other.getSBrn()))) &&
            ((this.sLocation==null && other.getSLocation()==null) || 
             (this.sLocation!=null &&
              this.sLocation.equals(other.getSLocation()))) &&
            ((this.sStDate==null && other.getSStDate()==null) || 
             (this.sStDate!=null &&
              this.sStDate.equals(other.getSStDate()))) &&
            ((this.sSpDate==null && other.getSSpDate()==null) || 
             (this.sSpDate!=null &&
              this.sSpDate.equals(other.getSSpDate())));
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
        if (getSSupplier() != null) {
            _hashCode += getSSupplier().hashCode();
        }
        if (getSComp() != null) {
            _hashCode += getSComp().hashCode();
        }
        if (getSBrn() != null) {
            _hashCode += getSBrn().hashCode();
        }
        if (getSLocation() != null) {
            _hashCode += getSLocation().hashCode();
        }
        if (getSStDate() != null) {
            _hashCode += getSStDate().hashCode();
        }
        if (getSSpDate() != null) {
            _hashCode += getSSpDate().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Supply_GetMrPrFinance.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">Supply_GetMrPrFinance"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SSupplier");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "sSupplier"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SComp");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "sComp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SBrn");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "sBrn"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SLocation");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "sLocation"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SStDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "sStDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SSpDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "sSpDate"));
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
