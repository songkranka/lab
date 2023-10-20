/**
 * PTHR_EmployeeDataInsert.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class PTHR_EmployeeDataInsert  implements java.io.Serializable {
    private java.lang.String empcode_creator;

    private org.tempuri.Pthr_EmployeeDataObj pthrEmpObj;

    private org.tempuri.Ptref_EmpObj ptrefEmpObj;

    public PTHR_EmployeeDataInsert() {
    }

    public PTHR_EmployeeDataInsert(
           java.lang.String empcode_creator,
           org.tempuri.Pthr_EmployeeDataObj pthrEmpObj,
           org.tempuri.Ptref_EmpObj ptrefEmpObj) {
           this.empcode_creator = empcode_creator;
           this.pthrEmpObj = pthrEmpObj;
           this.ptrefEmpObj = ptrefEmpObj;
    }


    /**
     * Gets the empcode_creator value for this PTHR_EmployeeDataInsert.
     * 
     * @return empcode_creator
     */
    public java.lang.String getEmpcode_creator() {
        return empcode_creator;
    }


    /**
     * Sets the empcode_creator value for this PTHR_EmployeeDataInsert.
     * 
     * @param empcode_creator
     */
    public void setEmpcode_creator(java.lang.String empcode_creator) {
        this.empcode_creator = empcode_creator;
    }


    /**
     * Gets the pthrEmpObj value for this PTHR_EmployeeDataInsert.
     * 
     * @return pthrEmpObj
     */
    public org.tempuri.Pthr_EmployeeDataObj getPthrEmpObj() {
        return pthrEmpObj;
    }


    /**
     * Sets the pthrEmpObj value for this PTHR_EmployeeDataInsert.
     * 
     * @param pthrEmpObj
     */
    public void setPthrEmpObj(org.tempuri.Pthr_EmployeeDataObj pthrEmpObj) {
        this.pthrEmpObj = pthrEmpObj;
    }


    /**
     * Gets the ptrefEmpObj value for this PTHR_EmployeeDataInsert.
     * 
     * @return ptrefEmpObj
     */
    public org.tempuri.Ptref_EmpObj getPtrefEmpObj() {
        return ptrefEmpObj;
    }


    /**
     * Sets the ptrefEmpObj value for this PTHR_EmployeeDataInsert.
     * 
     * @param ptrefEmpObj
     */
    public void setPtrefEmpObj(org.tempuri.Ptref_EmpObj ptrefEmpObj) {
        this.ptrefEmpObj = ptrefEmpObj;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PTHR_EmployeeDataInsert)) return false;
        PTHR_EmployeeDataInsert other = (PTHR_EmployeeDataInsert) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.empcode_creator==null && other.getEmpcode_creator()==null) || 
             (this.empcode_creator!=null &&
              this.empcode_creator.equals(other.getEmpcode_creator()))) &&
            ((this.pthrEmpObj==null && other.getPthrEmpObj()==null) || 
             (this.pthrEmpObj!=null &&
              this.pthrEmpObj.equals(other.getPthrEmpObj()))) &&
            ((this.ptrefEmpObj==null && other.getPtrefEmpObj()==null) || 
             (this.ptrefEmpObj!=null &&
              this.ptrefEmpObj.equals(other.getPtrefEmpObj())));
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
        if (getEmpcode_creator() != null) {
            _hashCode += getEmpcode_creator().hashCode();
        }
        if (getPthrEmpObj() != null) {
            _hashCode += getPthrEmpObj().hashCode();
        }
        if (getPtrefEmpObj() != null) {
            _hashCode += getPtrefEmpObj().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PTHR_EmployeeDataInsert.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">PTHR_EmployeeDataInsert"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("empcode_creator");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "empcode_creator"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pthrEmpObj");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "pthrEmpObj"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "Pthr_EmployeeDataObj"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ptrefEmpObj");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "ptrefEmpObj"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "Ptref_EmpObj"));
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
