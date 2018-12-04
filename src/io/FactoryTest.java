package io;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.testng.Assert.assertEquals;


/**
 * tests XML file reading
 *
 * @author Team15
 * @version 1.0
 */
public class FactoryTest {
    private  List<Element> allObjects1 , allObjects2 , allObjects3;

    public void createLists(){
        //read the information from the XML file into a JDOM Document
        Document theXMLDoc1 = null;
        Document theXMLDoc2 = null ;
        Document theXMLDoc3 = null;
        try {
            theXMLDoc1 = new SAXBuilder().build("xml/Szenario 1/object.xml");
            theXMLDoc2 = new SAXBuilder().build("xml/Szenario 2/object.xml");
            theXMLDoc3 = new SAXBuilder().build("xml/Szenario 3/object.xml");
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        Element root1 = theXMLDoc1.getRootElement(); // contains 10 wood and 10 metal
        Element root2 = theXMLDoc2.getRootElement(); // contains 12 wood and 11 metal
        Element root3 = theXMLDoc3.getRootElement(); // contains 10 wood and 10 metal


        //get all the objects into a List object
       allObjects1 =  root1.getChildren("object");
        allObjects2 =  root2.getChildren("object");
        allObjects3 =  root3.getChildren("object");


    }

    /**
     * tests if the values of the xml  files were correctly loaded into the arrays;
     * has to be changed after editing the object.xml files
     */
    @Test
    public void myXMLTest(){
        createLists();
      assertEquals(allObjects1.size() , 20);
      assertEquals(allObjects2.size() , 23);
      assertEquals(allObjects3.size() , 20);

    }

    }





