/**
 * PTG_VersionControl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class PTG_VersionControl  implements java.io.Serializable {
    private java.lang.String sSystem;

    private java.lang.String sMAC;

    private java.lang.String sUSER;

    private java.lang.String sIP;

    private java.lang.String sVER;

    public PTG_VersionControl() {
    }

    public PTG_VersionControl(
           java.lang.String sSystem,
           java.lang.String sMAC,
           java.lang.String sUSER,
           java.lang.String sIP,
           java.lang.String sVER) {
           this.sSystem = sSystem;
           this.sMAC = sMAC;
           this.sUSER = sUSER;
           this.sIP = sIP;
           this.sVER = sVER;
    }


    /**
     * Gets the sSystem value for this PTG_VersionControl.
     * 
     * @return sSystem
     */
    public java.lang.String getSSystem() {
        return sSystem;
    }


    /**
     * Sets the sSystem value for this PTG_VersionControl.
     * 
     * @param sSystem
     */
    public void setSSystem(java.lang.String sSystem) {
        this.sSystem = sSystem;
    }


    /**
     * Gets the sMAC value for this PTG_VersionControl.
     * 
     * @return sMAC
     */
    public java.lang.String getSMAC() {
        return sMAC;
    }


    /**
     * Sets the sMAC value for this PTG_VersionControl.
     * 
     * @param sMAC
     */
    public void setSMAC(java.lang.String sMAC) {
        this.sMAC = sMAC;
    }


    /**
     * Gets the sUSER value for this PTG_VersionControl.
     * 
     * @return sUSER
     */
    public java.lang.String getSUSER() {
        return sUSER;
    }


    /**
     * Sets the sUSER value for this PTG_VersionControl.
     * 
     * @param sUSER
     */
    public void setSUSER(java.lang.String sUSER) {
        this.sUSER = sUSER;
    }


    /**
     * Gets the sIP value for this PTG_VersionControl.
     * 
     * @return sIP
     */
    public java.lang.String getSIP() {
        return sIP;
    }


    /**
     * Sets the sIP value for this PTG_VersionControl.
     * 
     * @param sIP
     */
    public void setSIP(java.lang.String sIP) {
        this.sIP = sIP;
    }


    /**
     * Gets the sVER value for this PTG_VersionControl.
     * 
     * @return sVER
     */
    public java.lang.String getSVER() {
        return sVER;
    }


    /**
     * Sets the sVER value for this PTG_VersionControl.
     * 
     * @param sVER
     */
    public void setSVER(java.lang.String sVER) {
        this.sVER = sVER;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PTG_VersionControl)) return false;
        PTG_VersionControl other = (PTG_VersionControl) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.sSystem==null && other.getSSystem()==null) || 
             (this.sSystem!=null &&
              this.sSystem.equals(other.getSSystem()))) &&
            ((this.sMAC==null && other.getSMAC()==null) || 
             (this.sMAC!=null &&
              this.sMAC.equals(other.getSMAC()))) &&
            ((this.sUSER==null && other.getSUSER()==null) || 
             (this.sUSER!=null &&
              this.sUSER.equals(other.getSUSER()))) &&
            ((this.sIP==null && other.getSIP()==null) || 
             (this.sIP!=null &&
              this.sIP.equals(other.getSIP()))) &&
            ((this.sVER==null && other.getSVER()==null) || 
             (this.sVER!=null &&
              this.sVER.equals(other.getSVER())));
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
        if (getSSystem() != null) {
            _hashCode += getSSystem().hashCode();
        }
        if (getSMAC() != null) {
            _hashCode += getSMAC().hashCode();
        }
        if (getSUSER() != null) {
            _hashCode += getSUSER().hashCode();
        }
        if (getSIP() != null) {
            _hashCode += getSIP().hashCode();
        }
        if (getSVER() != null) {
            _hashCode += getSVER().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PTG_VersionControl.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">PTG_VersionControl"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SSystem");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "sSystem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SMAC");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "sMAC"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SUSER");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "sUSER"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SIP");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "sIP"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SVER");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "sVER"));
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
