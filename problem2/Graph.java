package problem2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;


public class Graph {
     HashMap<String,LinkedList<Edge>> mygraph;
     int totalSum;
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        Graph graph = new Graph();

        graph.mygraph=new HashMap<>();
        int vertices=5;
        for(int i=0;i<vertices;i++){
            String v=sc.next();
            graph.mygraph.put(v,new LinkedList<>());
        }

        int edges=7;
        for(int i=0;i<edges;i++){
            String a=sc.next();
            String b=sc.next();
            int c=sc.nextInt();
            graph.mygraph.get(a).add(new Edge(b,c));
            graph.mygraph.get(b).add(new Edge(a,c));
        }
        


        
        int avgDistance=graph.calculateAverageDistanceBetweenTwoPoints("C",
                "E");
        System.out.println("the average distance between the given points: "+avgDistance);
    }
    public int calculateAverageDistanceBetweenTwoPoints(String x, String y) {
  
        
        HashSet<Character> h=new HashSet<>();
        int totalPaths=this.countPaths(x, y,0,h);
        System.out.println("the total number of paths: "+totalPaths);
        h.clear();
        this.countTotalSum(x,  y, 0, h);
        int sumOfAllPaths=totalSum;
        h.clear();
        return sumOfAllPaths/totalPaths;
        
        

    }
    void countTotalSum(String src,String dest,int currSum,HashSet<Character> visited){
        if(visited.contains(src.charAt(0)))
            return;
        else
            visited.add(src.charAt(0));
        if(src.equals(dest)){
            this.totalSum+=currSum;
        }
        else{
            for(Edge e: mygraph.get(src)){
                countTotalSum(e.nbr, dest, currSum+e.wt,visited);
            }
        }

        visited.remove(src.charAt(0));//remove present so that it can be counted again

    }
    int countPaths(String src,String dest,int pathCount,HashSet<Character> visited){
        //if already visited then return
        if(visited.contains(src.charAt(0)))
            return pathCount;
        else
            visited.add(src.charAt(0));

        if(src.equals(dest)){
            ++pathCount;
        }
        else{
            for(Edge e: mygraph.get(src)){
                pathCount=countPaths(e.nbr, dest, pathCount,visited);
            }
        }
        visited.remove(src.charAt(0));//remove present so that it can be counted again
        return pathCount;
    }

   
}

class Edge{
    // String src;
    String nbr;
    int wt;
    Edge( String b,int c){
        // this.src=a;
        this.nbr=b;
        this.wt=c;
    }
}