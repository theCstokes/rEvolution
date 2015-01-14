/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package revolution.server;

import java.io.File;
import java.io.IOException;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Chris
 */
public class ServerFactory {
    public static HashMap<String, Server> servers = new HashMap<>();
    public static String currentServer;
    
    public static void saveServer(HashMap<String, Server> server) {
		try {

			DocumentBuilderFactory documentFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder documentBuilder = documentFactory
					.newDocumentBuilder();

			// define root elements
			Document document = documentBuilder.newDocument();
			Element rootElement = document.createElement("Servers");
			document.appendChild(rootElement);                     
			
                        
                        for(Map.Entry<String, Server> entry : server.entrySet()) {
                            String key = entry.getKey();
                            Server value = entry.getValue();
                            
                            Element data = document.createElement(key);
                            rootElement.appendChild(data);
                            
                            //pribaly putting it in a bad spot
                            System.out.println(value.getPort());
                            SerializeObject.Convert(value, key);
                        }                        

			// creating and writing to xml file
			TransformerFactory transformerFactory = TransformerFactory
					.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource domSource = new DOMSource(document);
			StreamResult streamResult = new StreamResult(new File(
					"serverBackups/Backups.xml"));

			transformer.transform(domSource, streamResult);

			System.out.println("File saved to specified path!");

		} catch (ParserConfigurationException | TransformerException pce) {
		}
	}
    public static HashMap<String, Server> loadServer(){

        
         try{
			File xmlFile = new File("serverBackups/Backups.xml");
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
        
        return servers;        
    }
    
    private static void Iterate(Node node) {
        if(!"Accounts".equals(node.getNodeName())){
            //probaly looking in the wrong folder
            servers.put(node.getNodeName(), (Server) DeserializeObject.Convert(node.getNodeName()));
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
    
    
    public static void add(String name, int port) throws SocketException, IOException{
        servers.put(name, new Server(port));
        currentServer = name;
    }
}
