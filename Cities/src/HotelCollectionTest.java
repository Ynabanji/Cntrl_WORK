import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HotelCollectionTest {
    @Test
    void takeInformCityTest() {
        HotelCollection hotelCollection = new HotelCollection();

        Hotel hotel1 = new Hotel();
        hotel1.setCity("Minsk");
        hotel1.setName("Hotel1");
        hotel1.setStars(4);

        Hotel hotel2 = new Hotel();
        hotel2.setCity("Moscow");
        hotel2.setName("Hotel2");
        hotel2.setStars(5);

        Hotel hotel3 = new Hotel();
        hotel3.setCity("Minsk");
        hotel3.setName("Hotel3");
        hotel3.setStars(3);

        hotelCollection.add(hotel1);
        hotelCollection.add(hotel2);
        hotelCollection.add(hotel3);

        ArrayList<Hotel> expectedSubHotels = new ArrayList<>();
        expectedSubHotels.add(hotel3);
        expectedSubHotels.add(hotel1);

        ArrayList<Hotel> subHotels;

        subHotels =  hotelCollection.takeInformCity("Minsk");
        assertEquals(expectedSubHotels, subHotels);
    }
    @Test
    void takeInformHotelTest() {
        HotelCollection hotelCollection = new HotelCollection();

        Hotel hotel1 = new Hotel();
        hotel1.setCity("Minsk");
        hotel1.setName("Tourist");
        hotel1.setStars(4);
        hotelCollection.add(hotel1);

        Hotel hotel2 = new Hotel();
        hotel2.setCity("Moscow");
        hotel2.setName("Tourist");
        hotel2.setStars(5);
        hotelCollection.add(hotel2);

        Hotel hotel3 = new Hotel();
        hotel3.setCity("Minsk");
        hotel3.setName("Radisson");
        hotel3.setStars(5);
        hotelCollection.add(hotel3);

        Hotel hotel4 = new Hotel();
        hotel4.setCity("London");
        hotel4.setName("Sheraton");
        hotel4.setStars(4);
        hotelCollection.add(hotel4);

        ArrayList<String> expectedCitiesWithHotel = new ArrayList<>();
        expectedCitiesWithHotel.add("Minsk");
        expectedCitiesWithHotel.add("Moscow");

        ArrayList<String> subHotels;
        subHotels = hotelCollection.takeInformHotel("Tourist");
        assertEquals(expectedCitiesWithHotel, subHotels);
    }
}





