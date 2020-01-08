import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Plant {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("in.txt"));
        scanner.nextLine();
        double numTrees = 0;
        HashMap<String, Double> hashMap = new HashMap<>();
        ArrayList<String> trees = new ArrayList<>();
        while(scanner.hasNext()){
            numTrees += 1;
            String current = scanner.nextLine();
            if(!trees.contains(current)){
                trees.add(current);
            }
            if(hashMap.get(current) != null){
                double currentDouble = hashMap.get(current);
                hashMap.remove(current);
                hashMap.put(current, currentDouble + 1);
            }
            else{
                hashMap.put(current, 1.0);
            }
        }
        DecimalFormat decimalFormat = new DecimalFormat("##.####");
        for (int i = 0; i < trees.size(); i++) {
            // System.out.println(trees + "\n" + projectNumArray);
            boolean foundSpot = false;
            int j = 0;
            while(j < trees.size()-1){
                if(trees.get(j).compareTo(trees.get(j+1)) > 0){
                    String tempS = trees.get(j);
                    trees.set(j, trees.get(j+1));
                    trees.set(j+1, tempS);
                }
                j++;
            }
        }


        for (int i = 0; i < trees.size(); i++) {
            String current = trees.get(i);

            System.out.println(current + " " + decimalFormat.format(hashMap.get(current) / numTrees * 100));
        }
    }
}
