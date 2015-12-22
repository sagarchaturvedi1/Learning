package com.learn.ds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sagar
 * Constant complexity for edge search, removal and addition
 * Space required = O(n*n)
 * O(n*n) complexity for whole graph traversal
 * O(n) complexity for finding input or output edges from a node
 * Good for dense graph where number of edges is lose to n*n
 *
 */
public class AdjacencyMatrix {
	int number;
	int[][] adj;

	public static void main(String[] args) {
		
	}

	public AdjacencyMatrix(int number, int[][] adj) {
		super();
		this.number = number;
		this.adj = adj;
	}

	// O(1)
	void addEdge(int i,int j) {
		adj[i][j] = 1;
	}

	// O(1)
	int searchEdge(int i,int j) {
		return adj[i][j];
	}
	
	// O(1)
	void removeEdge(int i,int j) {
		adj[i][j] = 0;
	}
	
	// O(n)
	List<Integer> outEdge(int i) {
		List<Integer> edges = new ArrayList<Integer>();
		for(int j=0;j<number;j++) {
			if(adj[i][j]==1) {
				edges.add(j);
			}
		}
		return edges;
	}
	
	// O(n)
	List<Integer> inEdge(int j) {
		List<Integer> edges = new ArrayList<Integer>();
		for(int i=0;i<number;i++) {
			if(adj[i][j]==1) {
				edges.add(i);
			}
		}
		return edges;
	}
	
	// O(n*n)
	Map<Integer, Integer> allEdge() {
		Map<Integer,Integer> edges = new HashMap<Integer, Integer>();
		for(int i=0;i<number;i++) {
			for(int j=0;j<number;j++) {
				if(adj[i][j]==1) {
					edges.put(i,j);
				}
		}
		}
		return edges;
	}
	
	void addVertex(int i) {
		
	}
	
}
