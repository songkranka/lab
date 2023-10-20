/**
 * PTHR_EmployeeDataUpdateResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class PTHR_EmployeeDataUpdateResponse  implements java.io.Serializable {
    private org.tempuri.ActionResult PTHR_EmployeeDataUpdateResult;

    public PTHR_EmployeeDataUpdateResponse() {
    }

    public PTHR_EmployeeDataUpdateResponse(
           org.tempuri.ActionResult PTHR_EmployeeDataUpdateResult) {
           this.PTHR_EmployeeDataUpdateResult = PTHR_EmployeeDataUpdateResult;
    }


    /**
     * Gets the PTHR_EmployeeDataUpdateResult value for this PTHR_EmployeeDataUpdateResponse.
     * 
     * @return PTHR_EmployeeDataUpdateResult
     */
    public org.tempuri.ActionResult getPTHR_EmployeeDataUpdateResult() {
        return PTHR_EmployeeDataUpdateResult;
    }


    /**
     * Sets the PTHR_EmployeeDataUpdateResult value for this PTHR_EmployeeDataUpdateResponse.
     * 
     * @param PTHR_EmployeeDataUpdateResult
     */
    public void setPTHR_EmployeeDataUpdateResult(org.tempuri.ActionResult PTHR_EmployeeDataUpdateResult) {
        this.PTHR_EmployeeDataUpdateResult = PTHR_EmployeeDataUpdateResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PTHR_EmployeeDataUpdateResponse)) return false;
        PTHR_EmployeeDataUpdateResponse other = (PTHR_EmployeeDataUpdateResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.PTHR_EmployeeDataUpdateResult==null && other.getPTHR_EmployeeDataUpdateResult()==null) || 
             (this.PTHR_EmployeeDataUpdateResult!=null &&
              this.PTHR_EmployeeDataUpdateResult.equals(other.getPTHR_EmployeeDataUpdateResult())));
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
        if (getPTHR_EmployeeDataUpdateResult() != null) {
            _hashCode += getPTHR_EmployeeDataUpdateResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PTHR_EmployeeDataUpdateResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">PTHR_EmployeeDataUpdateResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PTHR_EmployeeDataUpdateResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "PTHR_EmployeeDataUpdateResult"));
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
