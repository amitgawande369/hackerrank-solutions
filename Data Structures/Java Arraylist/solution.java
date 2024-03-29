
import java.util.Scanner;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        ArrayList<ArrayList<Integer>> lists = new ArrayList();
        for (int row = 0; row < n; row++) {
            int d = scan.nextInt();
            ArrayList<Integer> list = new ArrayList();
            for (int col = 0; col < d; col++) {
                list.add(scan.nextInt());
            }
            lists.add(list);
        }
        
        int q = scan.nextInt();
        for (int i = 0; i < q; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            ArrayList<Integer> list = lists.get(x-1);
            //System.out.println(lists.get(i)+"dd");
            if (y <= list.size()) {
                System.out.println(list.get(y-1));
                //System.out.println(lists.get(x-1)+"dd");
            } else {
                System.out.println("ERROR!");
            }
        }
        
        scan.close();
    }
}
