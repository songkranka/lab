/**
 * WSA_GetBranchDataResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class WSA_GetBranchDataResponse  implements java.io.Serializable {
    private org.tempuri.WSA_GetBranchDataResponseWSA_GetBranchDataResult WSA_GetBranchDataResult;

    public WSA_GetBranchDataResponse() {
    }

    public WSA_GetBranchDataResponse(
           org.tempuri.WSA_GetBranchDataResponseWSA_GetBranchDataResult WSA_GetBranchDataResult) {
           this.WSA_GetBranchDataResult = WSA_GetBranchDataResult;
    }


    /**
     * Gets the WSA_GetBranchDataResult value for this WSA_GetBranchDataResponse.
     * 
     * @return WSA_GetBranchDataResult
     */
    public org.tempuri.WSA_GetBranchDataResponseWSA_GetBranchDataResult getWSA_GetBranchDataResult() {
        return WSA_GetBranchDataResult;
    }


    /**
     * Sets the WSA_GetBranchDataResult value for this WSA_GetBranchDataResponse.
     * 
     * @param WSA_GetBranchDataResult
     */
    public void setWSA_GetBranchDataResult(org.tempuri.WSA_GetBranchDataResponseWSA_GetBranchDataResult WSA_GetBranchDataResult) {
        this.WSA_GetBranchDataResult = WSA_GetBranchDataResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WSA_GetBranchDataResponse)) return false;
        WSA_GetBranchDataResponse other = (WSA_GetBranchDataResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.WSA_GetBranchDataResult==null && other.getWSA_GetBranchDataResult()==null) || 
             (this.WSA_GetBranchDataResult!=null &&
              this.WSA_GetBranchDataResult.equals(other.getWSA_GetBranchDataResult())));
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
        if (getWSA_GetBranchDataResult() != null) {
            _hashCode += getWSA_GetBranchDataResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WSA_GetBranchDataResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">WSA_GetBranchDataResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("WSA_GetBranchDataResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "WSA_GetBranchDataResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>WSA_GetBranchDataResponse>WSA_GetBranchDataResult"));
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
