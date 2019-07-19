package runner;

import dom.DomParserMailRu;
import model.UsersDatas;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import sax.WebElementsHandler;
import stax.StaxParserMailRu;

import javax.xml.parsers.*;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;


public class RunMailRu {

    private static final String WEB_ELEMENTS_XML = "UsersDatas.xml";

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException,
            XMLStreamException {
        System.out.println(" ========================= SAX parser ==============================");
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();
        WebElementsHandler webElementsHandler = new WebElementsHandler();
        saxParser.parse(new File(WEB_ELEMENTS_XML), webElementsHandler);
        List<UsersDatas> webElements = webElementsHandler.getWebElements();
        webElements.forEach(webElement -> System.out.println(webElement));

        System.out.println(" ============================== STAX parser =========================");
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileInputStream(WEB_ELEMENTS_XML));
        webElements = new StaxParserMailRu().parse(xmlEventReader);
        webElements.forEach(webElement -> System.out.println(webElement));

        System.out.println(" ============================== DOM parser =========================");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document document = dBuilder.parse(WEB_ELEMENTS_XML);
        webElements = new DomParserMailRu().parse(document);
        webElements.forEach(webElement -> System.out.println(webElement));


    }

}
