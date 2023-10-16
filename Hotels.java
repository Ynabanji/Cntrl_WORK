import java.util.ArrayList;
import java.util.Scanner;
public class Hotels implements Comparable<Hotels> {

    private String City;
    private String Name;
    private int Stars;

    @Override
    public int compareTo(Hotels o) {
        int temp =  this.City.compareTo(o.City);
        if (temp == 0) {
            if (this.Stars > o.Stars) {
                return -1;
            }
            if (this.Stars < o.Stars) {
                return 1;
            }
            else{
                return 0;
            }
        }
        return temp;
    }
//    public int compareTo_2(Hotels o) {
//        String a,b;
//        a = Integer.toString(this.Stars);
//        b = Integer.toString(o.Stars);
//        int temp =  a.compareTo(b);
//        return temp;
//    }

    public void GetData(Scanner scanner) {
        String Temp; String Arr[];

            Temp = scanner.nextLine();
            Arr = Temp.split("\\s");
            City = Arr[0];
            Name = Arr[1];
            Stars = Integer.parseInt(Arr[2]);
    }
    public void PutData() {
        System.out.print(City + ' ' + Name + ' ' + Stars + '\n');
    }

//    int comp (Hotels h1, Hotels h2) {
//        if((int)h1.Name[0] > (int)h2.Name[0]) return 1;
//    }
    String getName (){
        return this.Name;
    }
    String GetCity () {
        return this.City;
    }
    int getStars() {
        return this.Stars;
    }


}

