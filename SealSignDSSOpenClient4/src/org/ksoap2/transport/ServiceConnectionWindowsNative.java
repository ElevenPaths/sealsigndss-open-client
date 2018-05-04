package org.ksoap2.transport;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import es.smartaccess.sealsigndss.WinHttpConnectionService;

public class ServiceConnectionWindowsNative implements ServiceConnection 
{
	private WinHttpConnectionService service;
	
	private URL _url;
	private String _headers;
	private byte[] _request;
	private byte[] _response;
	private ByteArrayOutputStream _outputStream;
	private ByteArrayInputStream _inputStream;
			 	
	public ServiceConnectionWindowsNative(String url) throws IOException {
        service = new WinHttpConnectionService();
        _url = new URL(url);
        _headers = "";
    }

    public void connect() throws IOException 
    {
    	if (_outputStream != null)
    	{
	    	_request = _outputStream.toByteArray();
	    	if (_request != null)
	    	{
	    		if (_headers.length() != 0)
	    		{
	    			_headers = _headers.substring(0, _headers.length() - 1);
	    		}
	    		
		    	_response = service.invoke(_url.getPath(), 
		        	_url.getHost(), 
		        	_url.getPort(), 
		        	_url.getProtocol().equals("https"), 
		        	_headers, 
		        	_request);
	    	}
    	}
    }

    public void disconnect() {
       
    }

    public void setRequestProperty(String string, String soapAction) {
    	_headers += string + ": " + soapAction + "\r\n";
    }

    public void setRequestMethod(String requestMethod) throws IOException {
        
    }

    public OutputStream openOutputStream() throws IOException {
    	_outputStream = new ByteArrayOutputStream();
    	return _outputStream;
    }

    public InputStream openInputStream() throws IOException {
    	_inputStream = new ByteArrayInputStream(_response);
    	return _inputStream;
    }

    public InputStream getErrorStream() {
        _inputStream = new ByteArrayInputStream(_response);
        return _inputStream;
    }
}
