package com.idref.other;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import junit.framework.TestCase;

public class TestASupprimer extends TestCase {

	public void test1_idref() throws JAXBException {

        String packageOfObjectFactory = "com.idref.other";
		JAXBContext jc = JAXBContext.newInstance(packageOfObjectFactory);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        
        JAXBElement<DeliveryType> unmarshal = (JAXBElement<DeliveryType>) unmarshaller.unmarshal(Files.getFile("", "/otherexemple.xml"));
        DeliveryType deliveryType = unmarshal.getValue();

        assertTrue("la commande pointe bien vers le client toto par reference",
                ((CustomerType) deliveryType.getOrder().get(0).getCustomerRef()).getName().equals("toto"));
	}
	
}
