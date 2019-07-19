package stax;

import model.UsersDatas;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.util.ArrayList;
import java.util.List;


public class StaxParserMailRu {
    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final String USER_DATAS = "UserDatas";
    private static final String ID = "id";
    private UsersDatas userDatas;
    List<UsersDatas> usersDatas = new ArrayList<>();

    public List<UsersDatas> parse(XMLEventReader xmlEventReader) throws XMLStreamException {
        while (xmlEventReader.hasNext()) {
            XMLEvent xmlEvent = xmlEventReader.nextEvent();
            proceedStartElement(xmlEvent, xmlEventReader);
            proceedEndElement(xmlEvent);
        }
        return usersDatas;
    }

    private void proceedStartElement(XMLEvent xmlEvent, XMLEventReader xmlEventReader) throws XMLStreamException {
        if (xmlEvent.isStartElement()) {
            StartElement startElement = xmlEvent.asStartElement();
            if (isTagNameEqual(startElement, USER_DATAS)) {
                userDatas = new UsersDatas();
                Attribute attribute = startElement.getAttributeByName(new QName(ID));
                if (attribute != null) {
                    userDatas.setId(Integer.parseInt(attribute.getValue()));
                }
            } else if (isTagNameEqual(startElement, LOGIN)) {
                userDatas.setLogin(xmlEventReader.nextEvent().asCharacters().getData());
            } else if (isTagNameEqual(startElement, PASSWORD)) {
                userDatas.setPassword(xmlEventReader.nextEvent().asCharacters().getData());
            }

        }
    }

    private void proceedEndElement(XMLEvent xmlEvent) {
        if (xmlEvent.isEndElement()) {
            EndElement endElement = xmlEvent.asEndElement();
            if (endElement.getName().getLocalPart().equals(USER_DATAS)) {
                usersDatas.add(userDatas);
            }
        }
    }

    private boolean isTagNameEqual(StartElement startElement, String tagName) {
        return startElement.getName().getLocalPart().equals(tagName);
    }
}
