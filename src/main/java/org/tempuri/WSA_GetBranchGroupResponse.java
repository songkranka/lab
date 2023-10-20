/**
 * WSA_GetBranchGroupResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class WSA_GetBranchGroupResponse  implements java.io.Serializable {
    private org.tempuri.WSA_GetBranchGroupResponseWSA_GetBranchGroupResult WSA_GetBranchGroupResult;

    public WSA_GetBranchGroupResponse() {
    }

    public WSA_GetBranchGroupResponse(
           org.tempuri.WSA_GetBranchGroupResponseWSA_GetBranchGroupResult WSA_GetBranchGroupResult) {
           this.WSA_GetBranchGroupResult = WSA_GetBranchGroupResult;
    }


    /**
     * Gets the WSA_GetBranchGroupResult value for this WSA_GetBranchGroupResponse.
     * 
     * @return WSA_GetBranchGroupResult
     */
    public org.tempuri.WSA_GetBranchGroupResponseWSA_GetBranchGroupResult getWSA_GetBranchGroupResult() {
        return WSA_GetBranchGroupResult;
    }


    /**
     * Sets the WSA_GetBranchGroupResult value for this WSA_GetBranchGroupResponse.
     * 
     * @param WSA_GetBranchGroupResult
     */
    public void setWSA_GetBranchGroupResult(org.tempuri.WSA_GetBranchGroupResponseWSA_GetBranchGroupResult WSA_GetBranchGroupResult) {
        this.WSA_GetBranchGroupResult = WSA_GetBranchGroupResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WSA_GetBranchGroupResponse)) return false;
        WSA_GetBranchGroupResponse other = (WSA_GetBranchGroupResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.WSA_GetBranchGroupResult==null && other.getWSA_GetBranchGroupResult()==null) || 
             (this.WSA_GetBranchGroupResult!=null &&
              this.WSA_GetBranchGroupResult.equals(other.getWSA_GetBranchGroupResult())));
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
        if (getWSA_GetBranchGroupResult() != null) {
            _hashCode += getWSA_GetBranchGroupResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WSA_GetBranchGroupResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">WSA_GetBranchGroupResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("WSA_GetBranchGroupResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "WSA_GetBranchGroupResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>WSA_GetBranchGroupResponse>WSA_GetBranchGroupResult"));
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
