/**
 * AN_MovePreOrder2Order_Split.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AN_MovePreOrder2Order_Split  implements java.io.Serializable {
    private java.lang.String sComp;

    private java.lang.String sBrn;

    private int nSEQ;

    private int nOrderStatus;

    public AN_MovePreOrder2Order_Split() {
    }

    public AN_MovePreOrder2Order_Split(
           java.lang.String sComp,
           java.lang.String sBrn,
           int nSEQ,
           int nOrderStatus) {
           this.sComp = sComp;
           this.sBrn = sBrn;
           this.nSEQ = nSEQ;
           this.nOrderStatus = nOrderStatus;
    }


    /**
     * Gets the sComp value for this AN_MovePreOrder2Order_Split.
     * 
     * @return sComp
     */
    public java.lang.String getSComp() {
        return sComp;
    }


    /**
     * Sets the sComp value for this AN_MovePreOrder2Order_Split.
     * 
     * @param sComp
     */
    public void setSComp(java.lang.String sComp) {
        this.sComp = sComp;
    }


    /**
     * Gets the sBrn value for this AN_MovePreOrder2Order_Split.
     * 
     * @return sBrn
     */
    public java.lang.String getSBrn() {
        return sBrn;
    }


    /**
     * Sets the sBrn value for this AN_MovePreOrder2Order_Split.
     * 
     * @param sBrn
     */
    public void setSBrn(java.lang.String sBrn) {
        this.sBrn = sBrn;
    }


    /**
     * Gets the nSEQ value for this AN_MovePreOrder2Order_Split.
     * 
     * @return nSEQ
     */
    public int getNSEQ() {
        return nSEQ;
    }


    /**
     * Sets the nSEQ value for this AN_MovePreOrder2Order_Split.
     * 
     * @param nSEQ
     */
    public void setNSEQ(int nSEQ) {
        this.nSEQ = nSEQ;
    }


    /**
     * Gets the nOrderStatus value for this AN_MovePreOrder2Order_Split.
     * 
     * @return nOrderStatus
     */
    public int getNOrderStatus() {
        return nOrderStatus;
    }


    /**
     * Sets the nOrderStatus value for this AN_MovePreOrder2Order_Split.
     * 
     * @param nOrderStatus
     */
    public void setNOrderStatus(int nOrderStatus) {
        this.nOrderStatus = nOrderStatus;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AN_MovePreOrder2Order_Split)) return false;
        AN_MovePreOrder2Order_Split other = (AN_MovePreOrder2Order_Split) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.sComp==null && other.getSComp()==null) || 
             (this.sComp!=null &&
              this.sComp.equals(other.getSComp()))) &&
            ((this.sBrn==null && other.getSBrn()==null) || 
             (this.sBrn!=null &&
              this.sBrn.equals(other.getSBrn()))) &&
            this.nSEQ == other.getNSEQ() &&
            this.nOrderStatus == other.getNOrderStatus();
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
        if (getSComp() != null) {
            _hashCode += getSComp().hashCode();
        }
        if (getSBrn() != null) {
            _hashCode += getSBrn().hashCode();
        }
        _hashCode += getNSEQ();
        _hashCode += getNOrderStatus();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AN_MovePreOrder2Order_Split.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">AN_MovePreOrder2Order_Split"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
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
        elemField.setFieldName("NSEQ");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "nSEQ"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("NOrderStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "nOrderStatus"));
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
