//A program to implement routing protocol for a simple topology 
//of routers that simulates the routing tables for routers for 
//observing the working of IP protocol using Dijkstra's algorithm

import java.io.*;
import java.util.*;

public class Routing{
	public static void main(String[] args){
	
		//Get number of nodes and graph costs
		Scanner dataInput = new Scanner(System.in);
		System.out.print("Enter the Number of nodes: ");
		int N = dataInput.nextInt();
		
		int graphCosts[][] = new int[N][N];
		System.out.println("Enter the cost matrix from graph:");
		for(int i = 0; i < N; i++){
			for (int j = 0; j < N; j++){
				graphCosts[i][j] = dataInput.nextInt();
				
				if(graphCosts[i][j] == 0)
					graphCosts[i][j] = 10000;
			}
		}
	
		//Initialization
		int C[] = new int[N]; 			
		Boolean M[] = new Boolean[N];	
		C[0] = 0;
		M[0] = true;
		
		for(int i = 1; i < N; i++){
			M[i] = false;
			if(graphCosts[0][i] > 0)
				C[i] = graphCosts[0][i];
			else
				C[i] = 10000;
		}
		
		for(int i = 1; i < N; i++){
			//get next min cost array
			int x = Integer.MAX_VALUE;
			int w = 0;
			for(int j = 1; j < N; j++){
				if(M[j] == false && C[j] < x){
					x = C[j];
					w = j;
				}
			}
			M[w] = true;

			for(int k = 1; k < N; k++){
				if(M[k] == false)
					C[k] = Math.min(C[k], (C[w] + graphCosts[w][k]));
			}
		}

		for(int i = 0; i < N; i++) 
			System.out.println("Shortest path to Node " + i + " is:" + C[i]);
	}
}