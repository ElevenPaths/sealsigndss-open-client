package es.uji.security.ui.applet.io;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Hashtable;

import es.uji.security.ui.applet.SignatureApplet;

public class StateInputParams extends AbstractData implements InputParams
{
    private String[] _states;
    
    private int _current = 0;
    private int _count = 0;

    public StateInputParams(String[] in)
    {
    	this._states = in;
    	     	 
         _count = 1;
    }

    public int getInputCount() throws Exception
    {
        return _count;
    }

    public InputStream getSignData() throws Exception
    {
    	byte[] ret = this._states[_current].getBytes();

        _current++;

        return new ByteArrayInputStream(ret);
    }

    public InputStream getSignData(int item) throws Exception
    {
        // TODO Auto-generated method stub
        return null;
    }
    
    public String getParameter()
    {
    	return null;
    }

    public String getSignFormat(SignatureApplet base)
    {
        // TODO Auto-generated method stub
        return null;
    }

    public void initialize(Hashtable<String, Object> props)
    {
        // TODO Auto-generated method stub
    }

    public void flush()
    {
        _current = 0;
    }

}