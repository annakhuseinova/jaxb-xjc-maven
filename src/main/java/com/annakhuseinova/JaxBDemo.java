package com.annakhuseinova;

import com.annakhuseinova.patient.Patient;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

public class JaxBDemo {

    public static void main(String[] args) {
        try {
            JAXBContext context = JAXBContext.newInstance(Patient.class);
            Marshaller marshaller = context.createMarshaller();
            com.annakhuseinova.patient.Patient patient = new Patient();
            patient.setId(123);
            patient.setName("Anna");
            StringWriter writer = new StringWriter();
            marshaller.marshal(patient, writer);
            System.out.println(writer.toString());
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Patient patientUnmarshalled = (Patient) unmarshaller.unmarshal(new StringReader(writer.toString()));
            System.out.println(patientUnmarshalled.getName());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
