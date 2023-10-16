import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) throws IOException {

        FileReader file = new FileReader("hotels.txt");
        Scanner scanner = new Scanner(file);
        Hotels_Array arr = new Hotels_Array();
        arr.PutData(scanner);
        Scanner in = new Scanner(System.in);
        String Name = in.nextLine();
        for(int i = 0; i < arr.GetNum(); i ++) {
            String temp = arr.array.get(i).getName();
            if (temp.equals(Name)) {
                System.out.println(arr.array.get(i).GetCity() + '\n');
            }
        }

        String name = in.nextLine();
        for(int i = 0; i < arr.GetNum(); i ++) {
            String temp = arr.array.get(i).GetCity();
            if (temp.equals(name)) {
                System.out.print(arr.array.get(i).getName() + ' ');
                System.out.println((arr.array.get(i).getStars() - 10) + '\n');
                }
            }


        System.out.println('\n');

        in.close();
        ArrayList<String> tmp= new ArrayList<String>();
        Collections.sort(arr.array, Hotels::compareTo);

        for (int i = 0; i < arr.GetNum(); i ++) {
            arr.array.get(i).PutData();

        }

    }
}