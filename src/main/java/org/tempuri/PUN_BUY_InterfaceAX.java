/**
 * PUN_BUY_InterfaceAX.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class PUN_BUY_InterfaceAX  implements java.io.Serializable {
    private java.lang.String periodDDMMYYYY;

    private java.lang.String ledgerJournalTransImportJSON;

    private java.lang.String flagVoucher;

    private java.lang.String totalCredit;

    private java.lang.String documentDateLast;

    public PUN_BUY_InterfaceAX() {
    }

    public PUN_BUY_InterfaceAX(
           java.lang.String periodDDMMYYYY,
           java.lang.String ledgerJournalTransImportJSON,
           java.lang.String flagVoucher,
           java.lang.String totalCredit,
           java.lang.String documentDateLast) {
           this.periodDDMMYYYY = periodDDMMYYYY;
           this.ledgerJournalTransImportJSON = ledgerJournalTransImportJSON;
           this.flagVoucher = flagVoucher;
           this.totalCredit = totalCredit;
           this.documentDateLast = documentDateLast;
    }


    /**
     * Gets the periodDDMMYYYY value for this PUN_BUY_InterfaceAX.
     * 
     * @return periodDDMMYYYY
     */
    public java.lang.String getPeriodDDMMYYYY() {
        return periodDDMMYYYY;
    }


    /**
     * Sets the periodDDMMYYYY value for this PUN_BUY_InterfaceAX.
     * 
     * @param periodDDMMYYYY
     */
    public void setPeriodDDMMYYYY(java.lang.String periodDDMMYYYY) {
        this.periodDDMMYYYY = periodDDMMYYYY;
    }


    /**
     * Gets the ledgerJournalTransImportJSON value for this PUN_BUY_InterfaceAX.
     * 
     * @return ledgerJournalTransImportJSON
     */
    public java.lang.String getLedgerJournalTransImportJSON() {
        return ledgerJournalTransImportJSON;
    }


    /**
     * Sets the ledgerJournalTransImportJSON value for this PUN_BUY_InterfaceAX.
     * 
     * @param ledgerJournalTransImportJSON
     */
    public void setLedgerJournalTransImportJSON(java.lang.String ledgerJournalTransImportJSON) {
        this.ledgerJournalTransImportJSON = ledgerJournalTransImportJSON;
    }


    /**
     * Gets the flagVoucher value for this PUN_BUY_InterfaceAX.
     * 
     * @return flagVoucher
     */
    public java.lang.String getFlagVoucher() {
        return flagVoucher;
    }


    /**
     * Sets the flagVoucher value for this PUN_BUY_InterfaceAX.
     * 
     * @param flagVoucher
     */
    public void setFlagVoucher(java.lang.String flagVoucher) {
        this.flagVoucher = flagVoucher;
    }


    /**
     * Gets the totalCredit value for this PUN_BUY_InterfaceAX.
     * 
     * @return totalCredit
     */
    public java.lang.String getTotalCredit() {
        return totalCredit;
    }


    /**
     * Sets the totalCredit value for this PUN_BUY_InterfaceAX.
     * 
     * @param totalCredit
     */
    public void setTotalCredit(java.lang.String totalCredit) {
        this.totalCredit = totalCredit;
    }


    /**
     * Gets the documentDateLast value for this PUN_BUY_InterfaceAX.
     * 
     * @return documentDateLast
     */
    public java.lang.String getDocumentDateLast() {
        return documentDateLast;
    }


    /**
     * Sets the documentDateLast value for this PUN_BUY_InterfaceAX.
     * 
     * @param documentDateLast
     */
    public void setDocumentDateLast(java.lang.String documentDateLast) {
        this.documentDateLast = documentDateLast;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PUN_BUY_InterfaceAX)) return false;
        PUN_BUY_InterfaceAX other = (PUN_BUY_InterfaceAX) obj;
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
              this.ledgerJournalTransImportJSON.equals(other.getLedgerJournalTransImportJSON()))) &&
            ((this.flagVoucher==null && other.getFlagVoucher()==null) || 
             (this.flagVoucher!=null &&
              this.flagVoucher.equals(other.getFlagVoucher()))) &&
            ((this.totalCredit==null && other.getTotalCredit()==null) || 
             (this.totalCredit!=null &&
              this.totalCredit.equals(other.getTotalCredit()))) &&
            ((this.documentDateLast==null && other.getDocumentDateLast()==null) || 
             (this.documentDateLast!=null &&
              this.documentDateLast.equals(other.getDocumentDateLast())));
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
        if (getFlagVoucher() != null) {
            _hashCode += getFlagVoucher().hashCode();
        }
        if (getTotalCredit() != null) {
            _hashCode += getTotalCredit().hashCode();
        }
        if (getDocumentDateLast() != null) {
            _hashCode += getDocumentDateLast().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PUN_BUY_InterfaceAX.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">PUN_BUY_InterfaceAX"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("flagVoucher");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "FlagVoucher"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalCredit");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "TotalCredit"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("documentDateLast");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "DocumentDateLast"));
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
