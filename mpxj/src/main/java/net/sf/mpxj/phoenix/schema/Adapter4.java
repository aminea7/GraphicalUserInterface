//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2018.10.04 at 10:52:38 AM BST
//

package net.sf.mpxj.phoenix.schema;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import net.sf.mpxj.Duration;

public class Adapter4 extends XmlAdapter<String, Duration>
{

   @Override public Duration unmarshal(String value)
   {
      return (net.sf.mpxj.phoenix.DatatypeConverter.parseDuration(value));
   }

   @Override public String marshal(Duration value)
   {
      return (net.sf.mpxj.phoenix.DatatypeConverter.printDuration(value));
   }

}
