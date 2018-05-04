package org.datacontract.schemas._2004._07.SealSignDSSFrontend;

import java.util.Hashtable;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;

public final class SignatureContext extends SoapObject {
    private byte[] asyncState;

    private java.lang.String instance;

    public SignatureContext() {
        super("", "");
    }
    public void setAsyncState(byte[] asyncState) {
        this.asyncState = asyncState;
    }

    public byte[] getAsyncState(byte[] asyncState) {
        return this.asyncState;
    }

    public void setInstance(java.lang.String instance) {
        this.instance = instance;
    }

    public java.lang.String getInstance(java.lang.String instance) {
        return this.instance;
    }

    public int getPropertyCount() {
        return 2;
    }

    public Object getProperty(int __index) {
        switch(__index)  {
        case 0: return asyncState;
        case 1: return instance;
        }
        return null;
    }

    public void setProperty(int __index, Object __obj) {
        switch(__index)  {
        case 0: asyncState = org.kobjects.base64.Base64.decode(((SoapPrimitive)__obj).toString()); break;
        case 1: instance = ((SoapPrimitive)__obj).toString(); break;
        }
    }

    public void getPropertyInfo(int __index, Hashtable __table, PropertyInfo __info) {
        switch(__index)  {
        case 0:
            __info.name = "asyncState";
            __info.type = byte[].class; break;
        case 1:
            __info.name = "instance";
            __info.type = java.lang.String.class; break;
        }
    }

}
