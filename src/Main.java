import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        ArrayList<String> studentName= new ArrayList<>();
        ArrayList< ArrayList<Integer>> rankMatrix= new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextLine()){
            String name= scan.next();
            if(name.equals("stop")){
                break;
            }
            studentName.add(name);
            ArrayList<Integer> rank = new ArrayList<>();
            while(scan.hasNextInt()){
                rank.add(scan.nextInt());
            }
            rankMatrix.add(rank);
        }

        for(int i=0;i< studentName.size();i++){
            System.out.print(studentName.get(i)+ " ");
            for(int j : rankMatrix.get(i) ){
                System.out.print(j + " ");
            }
            System.out.println();
        }

        Matrix matrix = new Matrix();
        ArrayList< ArrayList<Integer>> newMatrix= new ArrayList<>();
        newMatrix = matrix.getmatrix(rankMatrix);
        matrix.getAdjList(newMatrix);
    }
}
