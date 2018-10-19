import java.util.*;
import java.io.*;

public class Main {
    
    static int[]p;
    public static void main(String[] args) {
       
       FastReader in=new FastReader();
       
       int v=in.nextInt();
       
       int e=in.nextInt();
       
       p=new int[v+1];
       
       for(int i=0;i<p.length;i++){
           p[i]=i;
       }
       
       Edge[]x=new Edge[e];
       
       for(int i=0;i<e;i++){
           int a=in.nextInt(),b=in.nextInt(),cost=in.nextInt();
           x[i]=new Edge(a,b,cost);
       }
       
       Arrays.sort(x,new Edge()); 
       
       int cost=0;
       
       StringBuilder sb=new StringBuilder();
       
       for(int i=0;i<e;i++){
           int v1=x[i].a;
           int v2=x[i].b;
           int c=x[i].weight;
           
           int root1=find(v1);
           int root2=find(v2);
           
           if(root1 != root2){
              p[root1]=root2;
              cost+=c;
              sb.append(v1+"--"+v2+" "+c+"\n");
           }
       }
       
        System.out.println(sb+"\n"+cost);
    }
    
    public static int find(int a){
        if(p[a] == a){
            return a;
        }
        
        else 
            return p[a]=find(p[a]);
    }
}

class Edge implements Comparator <Edge> {
    int a;
    int b;
    int weight;
    
    public Edge(){
        
    }
    
    public Edge(int a,int b,int weight){
        this.a=a;
        this.b=b;
        this.weight=weight;
    }
    
    public int compare(Edge o1 , Edge o2){
        return o1.weight-o2.weight;
    }
}

class FastReader {

    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}
