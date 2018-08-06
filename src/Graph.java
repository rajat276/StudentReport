import java.util.*;

class Graph
{
    int V;
    List <Integer> adj[];

    public void IntializeAdjList(ArrayList<ArrayList<Integer>> adjList)
    {
        adj = new ArrayList[adjList.size()];
        V= adjList.size();
        for(int i = 0; i < adjList.size(); i++)
            adj[i]=adjList.get(i);
    }

    public Vector<Integer> topologicalSort()
    {
        int indegree[] = new int[V];
        for(int i = 0; i < V; i++)
        {
            ArrayList<Integer> temp = (ArrayList<Integer>) adj[i];
            for(int node : temp)
            {
                indegree[node]++;
            }
        }
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 0;i < V; i++)
        {
            if(indegree[i]==0)
                q.add(i);
        }
        int cnt = 0;
        Vector <Integer> topOrder=new Vector<Integer>();
        while(!q.isEmpty())
        {
            int u=q.poll();
            topOrder.add(u);
            for(int node : adj[u])
            {
                if(--indegree[node] == 0)
                    q.add(node);
            }
            cnt++;
        }

        // Check if there was a cycle
        if(cnt != V)
        {
            System.out.println("There exists a cycle in the graph");
            return new Vector<>();
        }

        // Print topological order
        for(int i : topOrder)
        {
            System.out.print(i+" ");
        }
        System.out.println();
        return topOrder;
    }

}



