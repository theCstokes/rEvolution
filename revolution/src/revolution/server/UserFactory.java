/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package revolution.server;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Chris
 */
public class UserFactory {
    private static HashMap<String, User> accounts = new HashMap<>();
    public static void saveUser(HashMap<String, User> accounts) {
		try {

			DocumentBuilderFactory documentFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder documentBuilder = documentFactory
					.newDocumentBuilder();

			// define root elements
			Document document = documentBuilder.newDocument();
			Element rootElement = document.createElement("Accounts");
			document.appendChild(rootElement);                     
			
                        
                        for(Entry<String, User> entry : accounts.entrySet()) {
                            String key = entry.getKey();
                            User value = entry.getValue();
                            
                            Element user = document.createElement(key);
                            rootElement.appendChild(user);
                            
                            //probaly putting it in a bad spot
                            SerializeObject.Convert(value, key);
                        }                        

			// creating and writing to xml file
			TransformerFactory transformerFactory = TransformerFactory
					.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource domSource = new DOMSource(document);
			StreamResult streamResult = new StreamResult(new File(
					"clientAccounts/Accounts.xml"));

			transformer.transform(domSource, streamResult);

			System.out.println("File saved to specified path!");

		} catch (ParserConfigurationException | TransformerException pce) {
		}
	}
    public static HashMap<String, User> loadUser(){

        
         try{
			File xmlFile = new File("clientAccounts/Accounts.xml");
			DocumentBuilderFactory documentFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder documentBuilder = documentFactory
					.newDocumentBuilder();
			Document doc = documentBuilder.parse(xmlFile);

			doc.getDocumentElement().normalize();

                        

		
        Iterate(doc.getDocumentElement());
            }catch(ParserConfigurationException pce){
            }catch(SAXException | IOException saxe){
            }
        
        return accounts;        
    }
    
    private static void Iterate(Node node) {
        if(!"Accounts".equals(node.getNodeName())){
            //probaly looking in the wrong folder
            accounts.put(node.getNodeName(), (User) DeserializeObject.Convert(node.getNodeName()));
        }

        NodeList nodeList = node.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node currentNode = nodeList.item(i);
            if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
                //calls this method for all the children which is Element
                Iterate(currentNode);
            }
        }
    }
}
