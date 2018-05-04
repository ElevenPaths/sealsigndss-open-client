package es.smartaccess.sealsigndss;

public class WinHttpConnectionService 
{
	  public native byte[] invoke(String service,
			  String host,
			  int port,
			  boolean ssl,
			  String headers,
			  byte[] request);
}
