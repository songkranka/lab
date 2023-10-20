/**
 * WSA_GetBranchNameResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class WSA_GetBranchNameResponse  implements java.io.Serializable {
    private org.tempuri.WSA_GetBranchNameResponseWSA_GetBranchNameResult WSA_GetBranchNameResult;

    public WSA_GetBranchNameResponse() {
    }

    public WSA_GetBranchNameResponse(
           org.tempuri.WSA_GetBranchNameResponseWSA_GetBranchNameResult WSA_GetBranchNameResult) {
           this.WSA_GetBranchNameResult = WSA_GetBranchNameResult;
    }


    /**
     * Gets the WSA_GetBranchNameResult value for this WSA_GetBranchNameResponse.
     * 
     * @return WSA_GetBranchNameResult
     */
    public org.tempuri.WSA_GetBranchNameResponseWSA_GetBranchNameResult getWSA_GetBranchNameResult() {
        return WSA_GetBranchNameResult;
    }


    /**
     * Sets the WSA_GetBranchNameResult value for this WSA_GetBranchNameResponse.
     * 
     * @param WSA_GetBranchNameResult
     */
    public void setWSA_GetBranchNameResult(org.tempuri.WSA_GetBranchNameResponseWSA_GetBranchNameResult WSA_GetBranchNameResult) {
        this.WSA_GetBranchNameResult = WSA_GetBranchNameResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WSA_GetBranchNameResponse)) return false;
        WSA_GetBranchNameResponse other = (WSA_GetBranchNameResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.WSA_GetBranchNameResult==null && other.getWSA_GetBranchNameResult()==null) || 
             (this.WSA_GetBranchNameResult!=null &&
              this.WSA_GetBranchNameResult.equals(other.getWSA_GetBranchNameResult())));
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
        if (getWSA_GetBranchNameResult() != null) {
            _hashCode += getWSA_GetBranchNameResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WSA_GetBranchNameResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">WSA_GetBranchNameResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("WSA_GetBranchNameResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "WSA_GetBranchNameResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>WSA_GetBranchNameResponse>WSA_GetBranchNameResult"));
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
