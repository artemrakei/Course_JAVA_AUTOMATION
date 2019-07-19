package sax;

import model.UsersDatas;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;


public class WebElementsHandler extends DefaultHandler {
    private List<UsersDatas> usersDatas;
    private UsersDatas userDatas;
    boolean bLogin = false;
    boolean bPassword = false;


    public List<UsersDatas> getWebElements() {
        return usersDatas;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {

        if (qName.equalsIgnoreCase("UserDatas")) {
            String id = attributes.getValue("id");
            userDatas = new UsersDatas();
            userDatas.setId(Integer.parseInt(id));
            if (usersDatas == null) {
                usersDatas = new ArrayList<>();
            }
        } else if (qName.equalsIgnoreCase("login")) {
            bLogin = true;
        } else if (qName.equalsIgnoreCase("password")) {
            bPassword = true;
        }

    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equalsIgnoreCase("UserDatas")) {
            usersDatas.add(userDatas);
        }
    }

    @Override
    public void characters(char ch[], int start, int length) {

        if (bLogin) {
            userDatas.setLogin(new String(ch, start, length));
            bLogin = false;
        } else if (bPassword) {
            userDatas.setPassword(new String(ch, start, length));
            bPassword = false;
        }
    }
}
