/**
 * MailService4.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class MailService4  implements java.io.Serializable {
    private java.lang.String sServer;

    private java.lang.String sFrom;

    private java.lang.String sTo;

    private java.lang.String sSubject;

    private java.lang.String sMessage;

    public MailService4() {
    }

    public MailService4(
           java.lang.String sServer,
           java.lang.String sFrom,
           java.lang.String sTo,
           java.lang.String sSubject,
           java.lang.String sMessage) {
           this.sServer = sServer;
           this.sFrom = sFrom;
           this.sTo = sTo;
           this.sSubject = sSubject;
           this.sMessage = sMessage;
    }


    /**
     * Gets the sServer value for this MailService4.
     * 
     * @return sServer
     */
    public java.lang.String getSServer() {
        return sServer;
    }


    /**
     * Sets the sServer value for this MailService4.
     * 
     * @param sServer
     */
    public void setSServer(java.lang.String sServer) {
        this.sServer = sServer;
    }


    /**
     * Gets the sFrom value for this MailService4.
     * 
     * @return sFrom
     */
    public java.lang.String getSFrom() {
        return sFrom;
    }


    /**
     * Sets the sFrom value for this MailService4.
     * 
     * @param sFrom
     */
    public void setSFrom(java.lang.String sFrom) {
        this.sFrom = sFrom;
    }


    /**
     * Gets the sTo value for this MailService4.
     * 
     * @return sTo
     */
    public java.lang.String getSTo() {
        return sTo;
    }


    /**
     * Sets the sTo value for this MailService4.
     * 
     * @param sTo
     */
    public void setSTo(java.lang.String sTo) {
        this.sTo = sTo;
    }


    /**
     * Gets the sSubject value for this MailService4.
     * 
     * @return sSubject
     */
    public java.lang.String getSSubject() {
        return sSubject;
    }


    /**
     * Sets the sSubject value for this MailService4.
     * 
     * @param sSubject
     */
    public void setSSubject(java.lang.String sSubject) {
        this.sSubject = sSubject;
    }


    /**
     * Gets the sMessage value for this MailService4.
     * 
     * @return sMessage
     */
    public java.lang.String getSMessage() {
        return sMessage;
    }


    /**
     * Sets the sMessage value for this MailService4.
     * 
     * @param sMessage
     */
    public void setSMessage(java.lang.String sMessage) {
        this.sMessage = sMessage;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MailService4)) return false;
        MailService4 other = (MailService4) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.sServer==null && other.getSServer()==null) || 
             (this.sServer!=null &&
              this.sServer.equals(other.getSServer()))) &&
            ((this.sFrom==null && other.getSFrom()==null) || 
             (this.sFrom!=null &&
              this.sFrom.equals(other.getSFrom()))) &&
            ((this.sTo==null && other.getSTo()==null) || 
             (this.sTo!=null &&
              this.sTo.equals(other.getSTo()))) &&
            ((this.sSubject==null && other.getSSubject()==null) || 
             (this.sSubject!=null &&
              this.sSubject.equals(other.getSSubject()))) &&
            ((this.sMessage==null && other.getSMessage()==null) || 
             (this.sMessage!=null &&
              this.sMessage.equals(other.getSMessage())));
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
        if (getSServer() != null) {
            _hashCode += getSServer().hashCode();
        }
        if (getSFrom() != null) {
            _hashCode += getSFrom().hashCode();
        }
        if (getSTo() != null) {
            _hashCode += getSTo().hashCode();
        }
        if (getSSubject() != null) {
            _hashCode += getSSubject().hashCode();
        }
        if (getSMessage() != null) {
            _hashCode += getSMessage().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MailService4.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">MailService4"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SServer");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "sServer"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SFrom");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "sFrom"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("STo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "sTo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SSubject");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "sSubject"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SMessage");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "sMessage"));
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
