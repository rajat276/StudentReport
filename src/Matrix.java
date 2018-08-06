import java.util.ArrayList;

public class Matrix {

    int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
        int temp = 0;
        for (int i = 0; i < a.size(); ++i) {
            if (a.get(i) <= b.get(i)) {
                temp = 1;
                break;
            }
        }
        if (temp == 0) return 1;
        temp = 0;
        for (int i = 0; i < a.size(); ++i) {
            if (a.get(i) >= b.get(i)) {
                temp = 1;
                break;
            }
        }
        if (temp == 0) return -1;

        return 0;
    }

    ArrayList<ArrayList<Integer>> getmatrix(ArrayList<ArrayList<Integer>> Matrix) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < Matrix.size(); ++i) {
            ArrayList<Integer> temp = new ArrayList();
            for (int j = 0; j < Matrix.size(); ++j) {
                temp.add(j,compare(Matrix.get(i), Matrix.get(j)));
//                result[i][j] = compare(Matrix.get(i), Matrix.get(j));
//                result[j][i] = -result[i][j];
            }
            result.add(i,temp);
        }

        System.out.println("m: " + result.size() + " n: " + result.get(0).size());
        for (int i=0;i<result.size();++i){
            for(int j : result.get(i)){
                System.out.print(j + " ");
            }
            System.out.println();
        }
        return result;
    }

    ArrayList<ArrayList<Integer>> getAdjList(ArrayList<ArrayList<Integer>> Matrix){
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for (int i = 0;i < Matrix.size(); ++i){
            ArrayList<Integer> temp2 = new ArrayList();
            for (int j = 0; j < Matrix.size(); ++j) {
                if(Matrix.get(i).get(j) == 1) {
                    temp2.add(j);
                }
            }
            adjList.add(i,temp2);
        }

        for (int i=0;i<adjList.size();++i){
            for(int j : adjList.get(i)){
                System.out.print(j + " ");
            }
            System.out.println();
        }

        return adjList;
    }
}
