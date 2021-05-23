package dataaccesslayer;

import businesslayer.model.HotelAdmin;

public interface IDataHandler {

    HotelAdmin readXML();

    void writeXML(HotelAdmin hotelAdmin);
}
