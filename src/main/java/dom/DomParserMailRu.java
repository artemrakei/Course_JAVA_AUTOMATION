package dom;

import model.UsersDatas;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class DomParserMailRu
{
    public List<UsersDatas> parse(Document document)
    {
        NodeList nodeList = document.getElementsByTagName("UserDatas");
        List<UsersDatas> refs = new ArrayList<UsersDatas>();
        for (int i = 0; i < nodeList.getLength(); i++)
        {
            refs.add(getWebElement(nodeList.item(i)));
        }
        return refs;
    }

    private static UsersDatas getWebElement(Node node)
    {
        UsersDatas webElement = new UsersDatas();
        Element element = (Element) node;
        webElement.setId(Integer.parseInt(element.getAttribute("id")));
        webElement.setLogin(getTagValue("login", element));
        webElement.setPassword(getTagValue("password", element));
        return webElement;
    }

    private static String getTagValue(String tag, Element element)
    {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = nodeList.item(0);
        return node.getNodeValue();
    }
}
