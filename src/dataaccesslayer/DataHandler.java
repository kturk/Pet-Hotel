package dataaccesslayer;

import businesslayer.model.HotelAdmin;

import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public class DataHandler implements IDataHandler {

    private String xmlPath;

    public DataHandler(String xmlPath) {
        this.xmlPath = xmlPath;
        initializeDataIfFileNotExist();
    }

    @Override
    public HotelAdmin readXML() {
        try {
            Unmarshaller unmarshaller = FileIOManager.getUnmarshaller();
            HotelAdmin hotelAdmin = null;
            if (unmarshaller != null)
                hotelAdmin = (HotelAdmin) unmarshaller.unmarshal(new FileInputStream(this.xmlPath));
            else
                System.out.println("Couldn't read Users from file.");
            return hotelAdmin;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public void writeXML(HotelAdmin hotelAdmin) {
        try {
            Marshaller marshaller = FileIOManager.getMarshaller();
            if (marshaller != null)
                marshaller.marshal(hotelAdmin, new FileOutputStream(this.xmlPath));
            else
                System.out.println("Null Marshaller");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initializeDataIfFileNotExist() {
        IDataInitializer dataInitializer = new DataInitializer();
        if (!new File(this.xmlPath).exists()) {
            this.writeXML(dataInitializer.getInitialAdmin());
        }

    }
}
