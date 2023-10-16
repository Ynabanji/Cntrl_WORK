import java.util.ArrayList;
import java.util.Scanner;
import java.util.Comparator;

public class Hotels_Array {
    public ArrayList<Hotels> array = new ArrayList<Hotels> ();
    private int num;

    public void PutData (Scanner scanner) {
        num = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < num; i ++) {
            Hotels temp = new Hotels();
            temp.GetData(scanner);
            array.add(temp);
        }
    }

    int GetNum(){
        return this.num;
    }
//    public void sort_by_name () {
//        array.sort
//    }
    void cout () {
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        for(int i = 0; i < arr.GetNum(); i ++) {
            String temp = arr.array.get(i).GetCity();
            if (temp.equals(name)) {
                System.out.print(arr.array.get(i).getName() + ' ');
                System.out.println((arr.array.get(i).getStars() - 10) + '\n');
            }
        }

    }


}
