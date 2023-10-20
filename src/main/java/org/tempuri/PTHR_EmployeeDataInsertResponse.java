/**
 * PTHR_EmployeeDataInsertResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class PTHR_EmployeeDataInsertResponse  implements java.io.Serializable {
    private org.tempuri.ActionResult PTHR_EmployeeDataInsertResult;

    public PTHR_EmployeeDataInsertResponse() {
    }

    public PTHR_EmployeeDataInsertResponse(
           org.tempuri.ActionResult PTHR_EmployeeDataInsertResult) {
           this.PTHR_EmployeeDataInsertResult = PTHR_EmployeeDataInsertResult;
    }


    /**
     * Gets the PTHR_EmployeeDataInsertResult value for this PTHR_EmployeeDataInsertResponse.
     * 
     * @return PTHR_EmployeeDataInsertResult
     */
    public org.tempuri.ActionResult getPTHR_EmployeeDataInsertResult() {
        return PTHR_EmployeeDataInsertResult;
    }


    /**
     * Sets the PTHR_EmployeeDataInsertResult value for this PTHR_EmployeeDataInsertResponse.
     * 
     * @param PTHR_EmployeeDataInsertResult
     */
    public void setPTHR_EmployeeDataInsertResult(org.tempuri.ActionResult PTHR_EmployeeDataInsertResult) {
        this.PTHR_EmployeeDataInsertResult = PTHR_EmployeeDataInsertResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PTHR_EmployeeDataInsertResponse)) return false;
        PTHR_EmployeeDataInsertResponse other = (PTHR_EmployeeDataInsertResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.PTHR_EmployeeDataInsertResult==null && other.getPTHR_EmployeeDataInsertResult()==null) || 
             (this.PTHR_EmployeeDataInsertResult!=null &&
              this.PTHR_EmployeeDataInsertResult.equals(other.getPTHR_EmployeeDataInsertResult())));
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
        if (getPTHR_EmployeeDataInsertResult() != null) {
            _hashCode += getPTHR_EmployeeDataInsertResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PTHR_EmployeeDataInsertResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">PTHR_EmployeeDataInsertResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PTHR_EmployeeDataInsertResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "PTHR_EmployeeDataInsertResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "ActionResult"));
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
