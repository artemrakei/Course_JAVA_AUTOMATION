package runner;

import dom.DomParser;
import model.Country;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import sax.RefsHandler;
import stax.StaxParser;

import javax.xml.parsers.*;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;


public class Run {

    private static final String REFS_XML = "Refs.xml";

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException,
            XMLStreamException {
        System.out.println(" ========================= SAX parser ==============================");
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();
        RefsHandler refsHandler = new RefsHandler();
        saxParser.parse(new File(REFS_XML), refsHandler);
        List<Country> countries = refsHandler.getRefs();
        countries.forEach(country -> System.out.println(country));

        System.out.println(" ============================== STAX parser =========================");
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileInputStream(REFS_XML));
        countries = new StaxParser().parse(xmlEventReader);
        countries.forEach(employee -> System.out.println(employee));

        System.out.println(" ============================== DOM parser =========================");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document document = dBuilder.parse(REFS_XML);
        countries = new DomParser().parse(document);
        countries.forEach(country -> System.out.println(country));


    }

}
