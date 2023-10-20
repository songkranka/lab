/**
 * WriteLog.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class WriteLog  implements java.io.Serializable {
    private java.lang.String IP;

    private java.lang.String user;

    private java.lang.String sys;

    private java.lang.String event;

    private java.lang.String modname;

    private java.lang.String note;

    public WriteLog() {
    }

    public WriteLog(
           java.lang.String IP,
           java.lang.String user,
           java.lang.String sys,
           java.lang.String event,
           java.lang.String modname,
           java.lang.String note) {
           this.IP = IP;
           this.user = user;
           this.sys = sys;
           this.event = event;
           this.modname = modname;
           this.note = note;
    }


    /**
     * Gets the IP value for this WriteLog.
     * 
     * @return IP
     */
    public java.lang.String getIP() {
        return IP;
    }


    /**
     * Sets the IP value for this WriteLog.
     * 
     * @param IP
     */
    public void setIP(java.lang.String IP) {
        this.IP = IP;
    }


    /**
     * Gets the user value for this WriteLog.
     * 
     * @return user
     */
    public java.lang.String getUser() {
        return user;
    }


    /**
     * Sets the user value for this WriteLog.
     * 
     * @param user
     */
    public void setUser(java.lang.String user) {
        this.user = user;
    }


    /**
     * Gets the sys value for this WriteLog.
     * 
     * @return sys
     */
    public java.lang.String getSys() {
        return sys;
    }


    /**
     * Sets the sys value for this WriteLog.
     * 
     * @param sys
     */
    public void setSys(java.lang.String sys) {
        this.sys = sys;
    }


    /**
     * Gets the event value for this WriteLog.
     * 
     * @return event
     */
    public java.lang.String getEvent() {
        return event;
    }


    /**
     * Sets the event value for this WriteLog.
     * 
     * @param event
     */
    public void setEvent(java.lang.String event) {
        this.event = event;
    }


    /**
     * Gets the modname value for this WriteLog.
     * 
     * @return modname
     */
    public java.lang.String getModname() {
        return modname;
    }


    /**
     * Sets the modname value for this WriteLog.
     * 
     * @param modname
     */
    public void setModname(java.lang.String modname) {
        this.modname = modname;
    }


    /**
     * Gets the note value for this WriteLog.
     * 
     * @return note
     */
    public java.lang.String getNote() {
        return note;
    }


    /**
     * Sets the note value for this WriteLog.
     * 
     * @param note
     */
    public void setNote(java.lang.String note) {
        this.note = note;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WriteLog)) return false;
        WriteLog other = (WriteLog) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.IP==null && other.getIP()==null) || 
             (this.IP!=null &&
              this.IP.equals(other.getIP()))) &&
            ((this.user==null && other.getUser()==null) || 
             (this.user!=null &&
              this.user.equals(other.getUser()))) &&
            ((this.sys==null && other.getSys()==null) || 
             (this.sys!=null &&
              this.sys.equals(other.getSys()))) &&
            ((this.event==null && other.getEvent()==null) || 
             (this.event!=null &&
              this.event.equals(other.getEvent()))) &&
            ((this.modname==null && other.getModname()==null) || 
             (this.modname!=null &&
              this.modname.equals(other.getModname()))) &&
            ((this.note==null && other.getNote()==null) || 
             (this.note!=null &&
              this.note.equals(other.getNote())));
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
        if (getIP() != null) {
            _hashCode += getIP().hashCode();
        }
        if (getUser() != null) {
            _hashCode += getUser().hashCode();
        }
        if (getSys() != null) {
            _hashCode += getSys().hashCode();
        }
        if (getEvent() != null) {
            _hashCode += getEvent().hashCode();
        }
        if (getModname() != null) {
            _hashCode += getModname().hashCode();
        }
        if (getNote() != null) {
            _hashCode += getNote().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WriteLog.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">WriteLog"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IP");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "IP"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("user");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "User"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sys");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Sys"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("event");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Event"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("modname");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Modname"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("note");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Note"));
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
