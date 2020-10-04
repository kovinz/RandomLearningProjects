import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class HelloWorld {

  public static void main(String[] args) {

    try {
      Document document = DocumentHelper.createDocument();
      Element root = document.addElement( "cars" );
      Element supercarElement = root.addElement("supercars")
              .addAttribute("company", "Ferrai");

      supercarElement.addElement("carname")
              .addAttribute("type", "Ferrari 101")
              .addText("Ferrari 101");

      supercarElement.addElement("carname")
              .addAttribute("type", "sports")
              .addText("Ferrari 202");

      // Pretty print the document to System.out
      OutputFormat format = OutputFormat.createPrettyPrint();
      XMLWriter writer;
      writer = new XMLWriter( System.out, format );
      writer.write( document );
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}