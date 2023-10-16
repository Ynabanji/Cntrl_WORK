import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
class Hotel implements Comparable<Hotel> {
    String city;
    String name;
    int stars;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    @Override
    public String toString() {
        String str = this.city + " " + this.name + " " + this.stars;
        return str;
    }

    @Override
    public int compareTo(Hotel o) {
        int res = this.city.compareTo(o.city);
        if (res == 0) {
            if (o.stars > this.stars)
                res = 1;
            else if (o.stars == this.stars)
                res = 0;
            else
                res = -1;
        }
        return res;
    }
}
class HotelCollection {
    ArrayList<Hotel> hotelsList = new ArrayList<>();
    @Override
    public String toString() {
        String res = "";
        for(Hotel hotel : hotelsList)
        {
            res += hotel.city + " " + hotel.name + " " + hotel.stars + "\n";
        }
        return res;
    }
    public void add(Hotel hotel)
    {
        hotelsList.add(hotel);
    }

    public ArrayList<Hotel> getHotelsList() {
        return hotelsList;
    }
    public void setHotelsList(ArrayList<Hotel> hotelsList) {
        this.hotelsList = hotelsList;
    }
    public ArrayList<Hotel> takeInformCity(String searchableCity)
    {
        ArrayList<Hotel> subHotels = new ArrayList<>();
        for (Hotel hotel : hotelsList) {
            if (hotel.city.equals(searchableCity)) {
                subHotels.add(hotel);
            }
        }
        for (Hotel hotel : subHotels) {
            System.out.println(hotel.name + " " + hotel.stars);
        }
        return subHotels;
    }
    public ArrayList<String> takeInformHotel(String searchableHotel)
    {
        ArrayList<String> citiesWithHotels = new ArrayList<>();
        for(Hotel hotel : hotelsList)
        {
            if(citiesWithHotels.contains(hotel.city))
                continue;
            else {
                if (hotel.name.equals(searchableHotel))
                    citiesWithHotels.add(hotel.city);
                else continue;
            }
            System.out.println(hotel.city);
        }
        return citiesWithHotels;
    }



}

public class Main {

    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("hotel.txt");
        BufferedReader br = new BufferedReader(fr);
        String str = br.readLine();
        String[] allstr = str.split(" ");
        ArrayList<Hotel> hotelList = new ArrayList<>();
        HotelCollection hotelCollection = new HotelCollection();


        while (str != null) {
            Hotel hotel = new Hotel();
            allstr = str.split(" ");
            hotel.city = allstr[0];
            hotel.name = allstr[1];
            hotel.stars = Integer.parseInt(allstr[2]);
            hotelCollection.add(hotel);
            hotelList.add(hotel);
            str = br.readLine();
        }
        Collections.sort(hotelList);
        Collections.sort(hotelCollection.hotelsList);


        //System.out.println(hotelCollection);

        hotelCollection.takeInformHotel("Torist");
        hotelCollection.takeInformCity("Minsk");

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("output.json"), hotelCollection);
    }
}
