/**
 * PUN_SELL_InterfaceAX.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class PUN_SELL_InterfaceAX  implements java.io.Serializable {
    private java.lang.String periodDDMMYYYY;

    private java.lang.String ledgerJournalTransImportJSON;

    public PUN_SELL_InterfaceAX() {
    }

    public PUN_SELL_InterfaceAX(
           java.lang.String periodDDMMYYYY,
           java.lang.String ledgerJournalTransImportJSON) {
           this.periodDDMMYYYY = periodDDMMYYYY;
           this.ledgerJournalTransImportJSON = ledgerJournalTransImportJSON;
    }


    /**
     * Gets the periodDDMMYYYY value for this PUN_SELL_InterfaceAX.
     * 
     * @return periodDDMMYYYY
     */
    public java.lang.String getPeriodDDMMYYYY() {
        return periodDDMMYYYY;
    }


    /**
     * Sets the periodDDMMYYYY value for this PUN_SELL_InterfaceAX.
     * 
     * @param periodDDMMYYYY
     */
    public void setPeriodDDMMYYYY(java.lang.String periodDDMMYYYY) {
        this.periodDDMMYYYY = periodDDMMYYYY;
    }


    /**
     * Gets the ledgerJournalTransImportJSON value for this PUN_SELL_InterfaceAX.
     * 
     * @return ledgerJournalTransImportJSON
     */
    public java.lang.String getLedgerJournalTransImportJSON() {
        return ledgerJournalTransImportJSON;
    }


    /**
     * Sets the ledgerJournalTransImportJSON value for this PUN_SELL_InterfaceAX.
     * 
     * @param ledgerJournalTransImportJSON
     */
    public void setLedgerJournalTransImportJSON(java.lang.String ledgerJournalTransImportJSON) {
        this.ledgerJournalTransImportJSON = ledgerJournalTransImportJSON;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PUN_SELL_InterfaceAX)) return false;
        PUN_SELL_InterfaceAX other = (PUN_SELL_InterfaceAX) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.periodDDMMYYYY==null && other.getPeriodDDMMYYYY()==null) || 
             (this.periodDDMMYYYY!=null &&
              this.periodDDMMYYYY.equals(other.getPeriodDDMMYYYY()))) &&
            ((this.ledgerJournalTransImportJSON==null && other.getLedgerJournalTransImportJSON()==null) || 
             (this.ledgerJournalTransImportJSON!=null &&
              this.ledgerJournalTransImportJSON.equals(other.getLedgerJournalTransImportJSON())));
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
        if (getPeriodDDMMYYYY() != null) {
            _hashCode += getPeriodDDMMYYYY().hashCode();
        }
        if (getLedgerJournalTransImportJSON() != null) {
            _hashCode += getLedgerJournalTransImportJSON().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PUN_SELL_InterfaceAX.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">PUN_SELL_InterfaceAX"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("periodDDMMYYYY");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "PeriodDDMMYYYY"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ledgerJournalTransImportJSON");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "LedgerJournalTransImportJSON"));
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
