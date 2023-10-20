/**
 * AT_PrintToStationReviseSAP.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AT_PrintToStationReviseSAP  implements java.io.Serializable {
    private org.tempuri.AT_PrintToStationReviseSAPODTB oDTB;

    private java.lang.String sType;

    private java.lang.String ptBrn;

    public AT_PrintToStationReviseSAP() {
    }

    public AT_PrintToStationReviseSAP(
           org.tempuri.AT_PrintToStationReviseSAPODTB oDTB,
           java.lang.String sType,
           java.lang.String ptBrn) {
           this.oDTB = oDTB;
           this.sType = sType;
           this.ptBrn = ptBrn;
    }


    /**
     * Gets the oDTB value for this AT_PrintToStationReviseSAP.
     * 
     * @return oDTB
     */
    public org.tempuri.AT_PrintToStationReviseSAPODTB getODTB() {
        return oDTB;
    }


    /**
     * Sets the oDTB value for this AT_PrintToStationReviseSAP.
     * 
     * @param oDTB
     */
    public void setODTB(org.tempuri.AT_PrintToStationReviseSAPODTB oDTB) {
        this.oDTB = oDTB;
    }


    /**
     * Gets the sType value for this AT_PrintToStationReviseSAP.
     * 
     * @return sType
     */
    public java.lang.String getSType() {
        return sType;
    }


    /**
     * Sets the sType value for this AT_PrintToStationReviseSAP.
     * 
     * @param sType
     */
    public void setSType(java.lang.String sType) {
        this.sType = sType;
    }


    /**
     * Gets the ptBrn value for this AT_PrintToStationReviseSAP.
     * 
     * @return ptBrn
     */
    public java.lang.String getPtBrn() {
        return ptBrn;
    }


    /**
     * Sets the ptBrn value for this AT_PrintToStationReviseSAP.
     * 
     * @param ptBrn
     */
    public void setPtBrn(java.lang.String ptBrn) {
        this.ptBrn = ptBrn;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AT_PrintToStationReviseSAP)) return false;
        AT_PrintToStationReviseSAP other = (AT_PrintToStationReviseSAP) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.oDTB==null && other.getODTB()==null) || 
             (this.oDTB!=null &&
              this.oDTB.equals(other.getODTB()))) &&
            ((this.sType==null && other.getSType()==null) || 
             (this.sType!=null &&
              this.sType.equals(other.getSType()))) &&
            ((this.ptBrn==null && other.getPtBrn()==null) || 
             (this.ptBrn!=null &&
              this.ptBrn.equals(other.getPtBrn())));
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
        if (getODTB() != null) {
            _hashCode += getODTB().hashCode();
        }
        if (getSType() != null) {
            _hashCode += getSType().hashCode();
        }
        if (getPtBrn() != null) {
            _hashCode += getPtBrn().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AT_PrintToStationReviseSAP.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AT_PrintToStationReviseSAP"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ODTB");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "oDTB"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>AT_PrintToStationReviseSAP>oDTB"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "sType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ptBrn");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "ptBrn"));
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
