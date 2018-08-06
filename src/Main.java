import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

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
        ArrayList< ArrayList<Integer>> newMatrix= matrix.getmatrix(rankMatrix);
        ArrayList< ArrayList<Integer>> adjmatrix= matrix.getAdjList(newMatrix);
        Graph graph= new Graph();
        graph.IntializeAdjList(adjmatrix);
        Vector<Integer> topoOrder = graph.topologicalSort();
        for(int i : topoOrder)
        {
            System.out.print(studentName.get(i) +" ");
        }
    }
}
