package com.ksk.dsa.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class GraphProblems {

    public static void main(String[] args) {
        GraphProblems g = new GraphProblems(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println(
                "Following is Breadth First Traversal "
                        + "(starting from vertex 2)");

        g.printBFS(2);

        System.out.println(
                "Following is Depth First Traversal "
                        + "(starting from vertex 2)");

        g.printDFS(2);
    }

    private LinkedList<Integer> adj[];
    private int V;

    public GraphProblems(int v){
        this.V = v;
        adj = new LinkedList[v];
        for (int i=0;i<v;i++){
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v,int w){
        adj[v].add(w);
    }

    /**
     * This method is used to print bfs- Level order first
     * @param v
     */
    public void printBFS(int v){

        boolean[] visited = new boolean[V];
        visited[v] = true;

        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(v);
        while (queue.size() != 0){

            int element = queue.poll();
            System.out.println(element);
            Iterator<Integer> iterator = adj[element].iterator();
            while (iterator.hasNext()){
                int s = iterator.next();
                if (!visited[s]){
                    visited[s] = true;
                    queue.add(s);
                }
            }
        }


    }


    /**
     * This method is used to print DFS like Tree which is depth first search
     * @param v
     */
    public void printDFS(int v){

        boolean[] visited = new boolean[V];
        visited[v] = true;

        Stack<Integer> stack = new Stack<>();
        stack.add(v);
        while (stack.size() != 0){

            int element = stack.peek();
            stack.pop();

            System.out.print(element);
            Iterator<Integer> iterator = adj[element].iterator();
            while (iterator.hasNext()){
                int s = iterator.next();
                if (!visited[s]){
                    visited[s] = true;
                    stack.add(s);
                }
            }
        }


    }
}
