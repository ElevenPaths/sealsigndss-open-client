package es.uji.security.ui.applet.io;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Hashtable;

import es.uji.security.ui.applet.SignatureApplet;

public class URIInputParams extends AbstractData implements InputParams
{
    private String[] str_in;
    private String _parameter;
    private int _current = 0;
    private int _count = 0;

    public URIInputParams(String[] in, String parameter)
    {
    	 this.str_in = in;
    	 this._parameter = parameter;
    	 
         _count = this.str_in.length;
    }

    public int getInputCount() throws Exception
    {
        return _count;
    }

    public InputStream getSignData() throws Exception
    {
    	byte[] ret = this.str_in[_current].getBytes();

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
    	return _parameter;
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