package org.datacontract.schemas._2004._07.SealSignDSSTypes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;

import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;

public final class CertificateReference extends SoapObject {
    private java.lang.String contactInfo;

    private byte[] encoded;

    private java.lang.Integer id;

    private java.lang.String issuer;

    private java.lang.String owner;

    private java.lang.Boolean passwordRequired;

    private java.lang.Boolean passwordSealSignRequired;

    private java.lang.String serial;

    private java.lang.String subject;

    private Date validFrom;

    private Date validTo;

    public CertificateReference() {
        super("", "");
    }
    public void setContactInfo(java.lang.String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public java.lang.String getContactInfo(java.lang.String contactInfo) {
        return this.contactInfo;
    }

    public void setEncoded(byte[] encoded) {
        this.encoded = encoded;
    }

    public byte[] getEncoded(byte[] encoded) {
        return this.encoded;
    }

    public void setId(java.lang.Integer id) {
        this.id = id;
    }

    public java.lang.Integer getId(java.lang.Integer id) {
        return this.id;
    }

    public void setIssuer(java.lang.String issuer) {
        this.issuer = issuer;
    }

    public java.lang.String getIssuer(java.lang.String issuer) {
        return this.issuer;
    }

    public void setOwner(java.lang.String owner) {
        this.owner = owner;
    }

    public java.lang.String getOwner(java.lang.String owner) {
        return this.owner;
    }

    public void setPasswordRequired(java.lang.Boolean passwordRequired) {
        this.passwordRequired = passwordRequired;
    }

    public java.lang.Boolean getPasswordRequired(java.lang.Boolean passwordRequired) {
        return this.passwordRequired;
    }

    public void setPasswordSealSignRequired(java.lang.Boolean passwordSealSignRequired) {
        this.passwordSealSignRequired = passwordSealSignRequired;
    }

    public java.lang.Boolean getPasswordSealSignRequired(java.lang.Boolean passwordSealSignRequired) {
        return this.passwordSealSignRequired;
    }

    public void setSerial(java.lang.String serial) {
        this.serial = serial;
    }

    public java.lang.String getSerial(java.lang.String serial) {
        return this.serial;
    }

    public void setSubject(java.lang.String subject) {
        this.subject = subject;
    }

    public java.lang.String getSubject(java.lang.String subject) {
        return this.subject;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public Date getValidFrom(java.util.Calendar validFrom) {
        return this.validFrom;
    }

    public void setValidTo(Date validTo) {
        this.validTo = validTo;
    }

    public Date getValidTo(java.util.Calendar validTo) {
        return this.validTo;
    }

    public int getPropertyCount() {
        return 11;
    }

    public Object getProperty(int __index) {
        switch(__index)  {
        case 0: return contactInfo;
        case 1: return encoded;
        case 2: return id;
        case 3: return issuer;
        case 4: return owner;
        case 5: return passwordRequired;
        case 6: return passwordSealSignRequired;
        case 7: return serial;
        case 8: return subject;
        case 9: return validFrom;
        case 10: return validTo;
        }
        return null;
    }

    public void setProperty(int __index, Object __obj) {
        switch(__index)  {
        case 0: contactInfo = ((SoapPrimitive)__obj).toString(); break;
        case 1: encoded = org.kobjects.base64.Base64.decode(((SoapPrimitive)__obj).toString()); break;
        case 2: id = Integer.parseInt(((SoapPrimitive)__obj).toString()); break;
        case 3: issuer = ((SoapPrimitive)__obj).toString(); break;
        case 4: owner = ((SoapPrimitive)__obj).toString(); break;
        case 5: passwordRequired = Boolean.parseBoolean(((SoapPrimitive)__obj).toString()); break;
        case 6: passwordSealSignRequired = Boolean.parseBoolean(((SoapPrimitive)__obj).toString()); break;
        case 7: serial = ((SoapPrimitive)__obj).toString(); break;
        case 8: subject = ((SoapPrimitive)__obj).toString(); break;
        case 9: try 
        		{
					validFrom = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(((SoapPrimitive)__obj).toString());
        		} 
        		catch (ParseException e) 
        		{
        			e.printStackTrace();
        		} 
        		break;	
        case 10: try 
				{
					validTo = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(((SoapPrimitive)__obj).toString());
				} 
				catch (ParseException e) 
				{
					e.printStackTrace();
				} 
				break;
        }
    }

    public void getPropertyInfo(int __index, Hashtable __table, PropertyInfo __info) {
        switch(__index)  {
        case 0:
            __info.name = "contactInfo";
            __info.type = java.lang.String.class; break;
        case 1:
            __info.name = "encoded";
            __info.type = byte[].class; break;
        case 2:
            __info.name = "id";
            __info.type = java.lang.Integer.class; break;
        case 3:
            __info.name = "issuer";
            __info.type = java.lang.String.class; break;
        case 4:
            __info.name = "owner";
            __info.type = java.lang.String.class; break;
        case 5:
            __info.name = "passwordRequired";
            __info.type = java.lang.Boolean.class; break;
        case 6:
            __info.name = "passwordSealSignRequired";
            __info.type = java.lang.Boolean.class; break;
        case 7:
            __info.name = "serial";
            __info.type = java.lang.String.class; break;
        case 8:
            __info.name = "subject";
            __info.type = java.lang.String.class; break;
        case 9:
            __info.name = "validFrom";
            __info.type = java.util.Date.class; break;
        case 10:
            __info.name = "validTo";
            __info.type = java.util.Date.class; break;
        }
    }

}
