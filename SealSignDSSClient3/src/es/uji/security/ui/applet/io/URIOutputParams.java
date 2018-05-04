package es.uji.security.ui.applet.io;

import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;



import org.apache.log4j.Logger;

//import es.uji.security.crypto.config.OS;
import es.uji.security.ui.applet.JSCommands;
//import es.uji.security.ui.applet.SignatureApplet;
import es.uji.security.ui.applet.SignatureThread;

public class URIOutputParams implements OutputParams
{
    private int _count = 1;
    private int _current = 0;
    
    private Logger log = Logger.getLogger(SignatureThread.class);

    public URIOutputParams()
    {
    }

    public void setSignData(InputStream is) throws IOException
    {
        if (_count > 1 && (_current != (_count - 1)))
        {
           _current++;
        }
    }

    public void setCount(int count)
    {
        this._count = count;
    }

    public void setSignFormat(Hashtable<String, Object> params, byte[] signFormat) throws IOException
    {
        // TODO Auto-generated method stub
    }

    public void setSignFormat(byte[] signFormat) throws IOException
    {
        // TODO Auto-generated method stub
    }

    public void signOk()
    {
    	try
        {
    		JSCommands.getWindow().call("onSignOk", new String[] { "" });
        }
	    catch (Exception e1)
	    {
	    	log.error("Exception getJsSignElementError", e1);
	  	}
    }

    public void flush()
    {
        // TODO Auto-generated method stub
    }
}
