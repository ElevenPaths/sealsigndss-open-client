/* Copyright (c) 2003,2004, Stefan Haustein, Oberhausen, Rhld., Germany
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or
 * sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The  above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS
 * IN THE SOFTWARE. */

package org.ksoap2;

import java.io.*;
import org.xmlpull.v1.*;
import org.kxml2.kdom.*;

/**
 * Exception class encapsulating SOAP Faults
 */

public class SoapFault extends IOException {

    /** The SOAP fault code */
    public String faultcode;
    /** The SOAP fault code */
    public String faultstring;
    /** The SOAP fault code */
    public String faultactor;
    /** A KDom Node holding the details of the fault */
    public Node detail;

    /** Fills the fault details from the given XML stream */
    public void parse(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, SoapEnvelope.ENV, "Fault");
        while (parser.nextTag() == XmlPullParser.START_TAG) {
            String name = parser.getName();
            if (name.equals("detail")) {
                detail = new Node();
                detail.parse(parser);
                continue;
            } else if (name.equals("faultcode"))
                faultcode = parser.nextText();
            else if (name.equals("faultstring"))
                faultstring = parser.nextText();
            else if (name.equals("faultactor"))
                faultactor = parser.nextText();
            else
                throw new RuntimeException("unexpected tag:" + name);
            parser.require(XmlPullParser.END_TAG, null, name);
        }
        
        // Correcci�n para faults sin detail
        if (parser.getName().equals("Fault"))
        {
        	parser.nextTag();
        }
    }

    /** Writes the fault to the given XML stream */
    public void write(XmlSerializer xw) throws IOException {
        xw.startTag(SoapEnvelope.ENV, "Fault");
        xw.startTag(null, "faultcode");
        xw.text("" + faultcode);
        xw.endTag(null, "faultcode");
        xw.startTag(null, "faultstring");
        xw.text("" + faultstring);
        xw.endTag(null, "faultstring");
        xw.startTag(null, "detail");
        if (detail != null)
            detail.write(xw);
        xw.endTag(null, "detail");
        xw.endTag(SoapEnvelope.ENV, "Fault");
    }

    /** Returns a simple string representation of the fault */
    public String toString() {
        return "SoapFault - faultcode: '" + faultcode + "' faultstring: '" + faultstring + "' faultactor: '" + faultactor + "' detail: " + detail;
    }
}
