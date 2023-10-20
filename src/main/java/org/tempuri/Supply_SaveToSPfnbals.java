/**
 * Supply_SaveToSPfnbals.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class Supply_SaveToSPfnbals  implements java.io.Serializable {
    private org.tempuri.Supply_SaveToSPfnbalsODT oDT;

    private java.lang.String sSupplier;

    private java.lang.String sComp;

    private java.lang.String sBrn;

    private java.lang.String sLocation;

    private java.lang.String sDate;

    private java.lang.String sUser;

    public Supply_SaveToSPfnbals() {
    }

    public Supply_SaveToSPfnbals(
           org.tempuri.Supply_SaveToSPfnbalsODT oDT,
           java.lang.String sSupplier,
           java.lang.String sComp,
           java.lang.String sBrn,
           java.lang.String sLocation,
           java.lang.String sDate,
           java.lang.String sUser) {
           this.oDT = oDT;
           this.sSupplier = sSupplier;
           this.sComp = sComp;
           this.sBrn = sBrn;
           this.sLocation = sLocation;
           this.sDate = sDate;
           this.sUser = sUser;
    }


    /**
     * Gets the oDT value for this Supply_SaveToSPfnbals.
     * 
     * @return oDT
     */
    public org.tempuri.Supply_SaveToSPfnbalsODT getODT() {
        return oDT;
    }


    /**
     * Sets the oDT value for this Supply_SaveToSPfnbals.
     * 
     * @param oDT
     */
    public void setODT(org.tempuri.Supply_SaveToSPfnbalsODT oDT) {
        this.oDT = oDT;
    }


    /**
     * Gets the sSupplier value for this Supply_SaveToSPfnbals.
     * 
     * @return sSupplier
     */
    public java.lang.String getSSupplier() {
        return sSupplier;
    }


    /**
     * Sets the sSupplier value for this Supply_SaveToSPfnbals.
     * 
     * @param sSupplier
     */
    public void setSSupplier(java.lang.String sSupplier) {
        this.sSupplier = sSupplier;
    }


    /**
     * Gets the sComp value for this Supply_SaveToSPfnbals.
     * 
     * @return sComp
     */
    public java.lang.String getSComp() {
        return sComp;
    }


    /**
     * Sets the sComp value for this Supply_SaveToSPfnbals.
     * 
     * @param sComp
     */
    public void setSComp(java.lang.String sComp) {
        this.sComp = sComp;
    }


    /**
     * Gets the sBrn value for this Supply_SaveToSPfnbals.
     * 
     * @return sBrn
     */
    public java.lang.String getSBrn() {
        return sBrn;
    }


    /**
     * Sets the sBrn value for this Supply_SaveToSPfnbals.
     * 
     * @param sBrn
     */
    public void setSBrn(java.lang.String sBrn) {
        this.sBrn = sBrn;
    }


    /**
     * Gets the sLocation value for this Supply_SaveToSPfnbals.
     * 
     * @return sLocation
     */
    public java.lang.String getSLocation() {
        return sLocation;
    }


    /**
     * Sets the sLocation value for this Supply_SaveToSPfnbals.
     * 
     * @param sLocation
     */
    public void setSLocation(java.lang.String sLocation) {
        this.sLocation = sLocation;
    }


    /**
     * Gets the sDate value for this Supply_SaveToSPfnbals.
     * 
     * @return sDate
     */
    public java.lang.String getSDate() {
        return sDate;
    }


    /**
     * Sets the sDate value for this Supply_SaveToSPfnbals.
     * 
     * @param sDate
     */
    public void setSDate(java.lang.String sDate) {
        this.sDate = sDate;
    }


    /**
     * Gets the sUser value for this Supply_SaveToSPfnbals.
     * 
     * @return sUser
     */
    public java.lang.String getSUser() {
        return sUser;
    }


    /**
     * Sets the sUser value for this Supply_SaveToSPfnbals.
     * 
     * @param sUser
     */
    public void setSUser(java.lang.String sUser) {
        this.sUser = sUser;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Supply_SaveToSPfnbals)) return false;
        Supply_SaveToSPfnbals other = (Supply_SaveToSPfnbals) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.oDT==null && other.getODT()==null) || 
             (this.oDT!=null &&
              this.oDT.equals(other.getODT()))) &&
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
            ((this.sDate==null && other.getSDate()==null) || 
             (this.sDate!=null &&
              this.sDate.equals(other.getSDate()))) &&
            ((this.sUser==null && other.getSUser()==null) || 
             (this.sUser!=null &&
              this.sUser.equals(other.getSUser())));
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
        if (getODT() != null) {
            _hashCode += getODT().hashCode();
        }
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
        if (getSDate() != null) {
            _hashCode += getSDate().hashCode();
        }
        if (getSUser() != null) {
            _hashCode += getSUser().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Supply_SaveToSPfnbals.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">Supply_SaveToSPfnbals"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ODT");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "oDT"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>Supply_SaveToSPfnbals>oDT"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
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
        elemField.setFieldName("SDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "sDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SUser");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "sUser"));
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
