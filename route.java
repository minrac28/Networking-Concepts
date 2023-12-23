import java.io.*;
import java.util.*;
public class route{
	public static void main(String[] args){
		//Get number of nodes
		Scanner DataInput = new Scanner(System.in);
		System.out.print("Enter the number of nodes (n): ");
		int nodes = DataInput.nextInt();
		//Initialize arrays for costs and nodes
		int graphCosts[][] = new int[nodes][nodes];
		int costs[] = new int[nodes];
		Boolean confirmed[] = new Boolean[nodes];
		//Get costs - 0 - same node 999 no direct connection
		System.out.println("Enter the cost matrix from graph:");
		for(int i = 0; i < nodes; i++) {
			for(int j = 0; j < nodes; j++) {
				graphCosts[i][j] = DataInput.nextInt();
			}
		}
		//Get the source node
		System.out.print("Enter the Source Node: 0 to n-1 : ");
		int sourceNode = DataInput.nextInt();

		//Initialize Dijkstra algorithm from the sourceNode
		for(int i = 0; i < nodes; i++){
			costs[i] = graphCosts[sourceNode][i];
			confirmed[i] = false;
		}
		confirmed[sourceNode] = true;
		//Run for all nodes
		for(int i = 0; i < nodes; i++){	
			//get next minimum cost node
			int x = 999;
			int next = 0;
			for(int j = 0; j < nodes; j++) {
				if(confirmed[j] == false && costs[j] < x){
					x = costs[j];
					next = j;
				}
			}
		
	//Visit the next neighbor
			confirmed[next] = true;
			for(int j = 0; j < nodes; j++)
				if(confirmed[j] == false)
					costs[j] = Math.min(costs[j], (costs[next] + graphCosts[next][j]));
		}
		//Print costs
		for(int i = 0; i < nodes; i++)
			System.out.println("Shortest path from node " + sourceNode + " to node " + i + " is " + costs[i]);

	}
}






















