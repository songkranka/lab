/**
 * PUN_BUY_GET_GL_DATA.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class PUN_BUY_GET_GL_DATA  implements java.io.Serializable {
    private java.lang.String punBuyDataInterfaceAxJSON;

    private java.lang.String countListPun;

    private java.lang.String countDoc;

    private java.lang.String payeeCode;

    public PUN_BUY_GET_GL_DATA() {
    }

    public PUN_BUY_GET_GL_DATA(
           java.lang.String punBuyDataInterfaceAxJSON,
           java.lang.String countListPun,
           java.lang.String countDoc,
           java.lang.String payeeCode) {
           this.punBuyDataInterfaceAxJSON = punBuyDataInterfaceAxJSON;
           this.countListPun = countListPun;
           this.countDoc = countDoc;
           this.payeeCode = payeeCode;
    }


    /**
     * Gets the punBuyDataInterfaceAxJSON value for this PUN_BUY_GET_GL_DATA.
     * 
     * @return punBuyDataInterfaceAxJSON
     */
    public java.lang.String getPunBuyDataInterfaceAxJSON() {
        return punBuyDataInterfaceAxJSON;
    }


    /**
     * Sets the punBuyDataInterfaceAxJSON value for this PUN_BUY_GET_GL_DATA.
     * 
     * @param punBuyDataInterfaceAxJSON
     */
    public void setPunBuyDataInterfaceAxJSON(java.lang.String punBuyDataInterfaceAxJSON) {
        this.punBuyDataInterfaceAxJSON = punBuyDataInterfaceAxJSON;
    }


    /**
     * Gets the countListPun value for this PUN_BUY_GET_GL_DATA.
     * 
     * @return countListPun
     */
    public java.lang.String getCountListPun() {
        return countListPun;
    }


    /**
     * Sets the countListPun value for this PUN_BUY_GET_GL_DATA.
     * 
     * @param countListPun
     */
    public void setCountListPun(java.lang.String countListPun) {
        this.countListPun = countListPun;
    }


    /**
     * Gets the countDoc value for this PUN_BUY_GET_GL_DATA.
     * 
     * @return countDoc
     */
    public java.lang.String getCountDoc() {
        return countDoc;
    }


    /**
     * Sets the countDoc value for this PUN_BUY_GET_GL_DATA.
     * 
     * @param countDoc
     */
    public void setCountDoc(java.lang.String countDoc) {
        this.countDoc = countDoc;
    }


    /**
     * Gets the payeeCode value for this PUN_BUY_GET_GL_DATA.
     * 
     * @return payeeCode
     */
    public java.lang.String getPayeeCode() {
        return payeeCode;
    }


    /**
     * Sets the payeeCode value for this PUN_BUY_GET_GL_DATA.
     * 
     * @param payeeCode
     */
    public void setPayeeCode(java.lang.String payeeCode) {
        this.payeeCode = payeeCode;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PUN_BUY_GET_GL_DATA)) return false;
        PUN_BUY_GET_GL_DATA other = (PUN_BUY_GET_GL_DATA) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.punBuyDataInterfaceAxJSON==null && other.getPunBuyDataInterfaceAxJSON()==null) || 
             (this.punBuyDataInterfaceAxJSON!=null &&
              this.punBuyDataInterfaceAxJSON.equals(other.getPunBuyDataInterfaceAxJSON()))) &&
            ((this.countListPun==null && other.getCountListPun()==null) || 
             (this.countListPun!=null &&
              this.countListPun.equals(other.getCountListPun()))) &&
            ((this.countDoc==null && other.getCountDoc()==null) || 
             (this.countDoc!=null &&
              this.countDoc.equals(other.getCountDoc()))) &&
            ((this.payeeCode==null && other.getPayeeCode()==null) || 
             (this.payeeCode!=null &&
              this.payeeCode.equals(other.getPayeeCode())));
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
        if (getPunBuyDataInterfaceAxJSON() != null) {
            _hashCode += getPunBuyDataInterfaceAxJSON().hashCode();
        }
        if (getCountListPun() != null) {
            _hashCode += getCountListPun().hashCode();
        }
        if (getCountDoc() != null) {
            _hashCode += getCountDoc().hashCode();
        }
        if (getPayeeCode() != null) {
            _hashCode += getPayeeCode().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PUN_BUY_GET_GL_DATA.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">PUN_BUY_GET_GL_DATA"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("punBuyDataInterfaceAxJSON");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "punBuyDataInterfaceAxJSON"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("countListPun");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "countListPun"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("countDoc");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "countDoc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("payeeCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "payeeCode"));
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
