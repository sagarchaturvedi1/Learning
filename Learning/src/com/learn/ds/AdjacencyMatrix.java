package com.learn.ds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sagar
 * A 2D matrix
 * 
 * Constant complexity for edge search, removal and addition
 * O(n*n) complexity for whole graph traversal
 * O(n) complexity for finding input or output edges from a node
 * Good for dense graph where number of edges is close to n*n
 *
 * Space required = O(n*n/8) bytes
 * graph density d=e/n^2
 * 
 * If 8e > n^2/8  => e/n^2 > 1/64  => d > 1/64 then use Matrix else go with adjacency list.
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
	
	public AdjacencyMatrix(int number) {
		super();
		this.number = number;
		this.adj = new int[number][number];
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
