package projetoFinalGrafos;

import java.util.ArrayList;
import java.util.List;

public class Graph {
	private int V;
	private int E;
	private List<List<Integer>> adj;
	
	public Graph(int V){
		this.V = V;
		adj = new ArrayList<List<Integer>>();
		for(int i = 0; i < V; i++){
			adj.add(new ArrayList<Integer>());
			for(int j = 0; j < V; j++){
				adj.get(i).add(0);
			}
		}
	}
	
	public void AddEdge(int v, int u, int weight){
		adj.get(v).set(u, weight);
	}
	
	public int GetEdge(int v, int u){
		return adj.get(v).get(u);
	}
	
	public void PrintGraph(){
		for(int i = 0; i < V; i++){
			for(int j = 0; j < V; j++){
				System.out.print(adj.get(i).get(j) + "\t");
			}
			System.out.print("\n");
		}
	}
}
