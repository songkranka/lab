/**
 * LoRead.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class LoRead  implements java.io.Serializable {
    private java.lang.String sProject;

    private java.util.Calendar dTime;

    public LoRead() {
    }

    public LoRead(
           java.lang.String sProject,
           java.util.Calendar dTime) {
           this.sProject = sProject;
           this.dTime = dTime;
    }


    /**
     * Gets the sProject value for this LoRead.
     * 
     * @return sProject
     */
    public java.lang.String getSProject() {
        return sProject;
    }


    /**
     * Sets the sProject value for this LoRead.
     * 
     * @param sProject
     */
    public void setSProject(java.lang.String sProject) {
        this.sProject = sProject;
    }


    /**
     * Gets the dTime value for this LoRead.
     * 
     * @return dTime
     */
    public java.util.Calendar getDTime() {
        return dTime;
    }


    /**
     * Sets the dTime value for this LoRead.
     * 
     * @param dTime
     */
    public void setDTime(java.util.Calendar dTime) {
        this.dTime = dTime;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof LoRead)) return false;
        LoRead other = (LoRead) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.sProject==null && other.getSProject()==null) || 
             (this.sProject!=null &&
              this.sProject.equals(other.getSProject()))) &&
            ((this.dTime==null && other.getDTime()==null) || 
             (this.dTime!=null &&
              this.dTime.equals(other.getDTime())));
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
        if (getSProject() != null) {
            _hashCode += getSProject().hashCode();
        }
        if (getDTime() != null) {
            _hashCode += getDTime().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(LoRead.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">loRead"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SProject");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "sProject"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DTime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "dTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
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
