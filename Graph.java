import java.util.*;
public class Graph 
{
	private final int MAX_VERTS = 20;
	private Vertex vertexList[]; //array of vertices
	public int adjMat[][]; //adjacency matrix
	private int nVerts; //current number of vertices
	private StackX theStack;
	private QueueX theQueue;
	
	public Graph()
	{
		vertexList = new Vertex[MAX_VERTS];
		adjMat = new int[MAX_VERTS][MAX_VERTS];
		nVerts = 0;
		
		for(int j = 0; j < MAX_VERTS; j++) //set adjacency
		{
			for(int k = 0; k<MAX_VERTS; k++) //matrix to 0
			{
				adjMat[j][k] = 0;
			}
		}
		theQueue = new QueueX();
	}

	
	public void addVertex(char lab) //argument is a label
	{
		vertexList[nVerts++] = new Vertex(lab);
	}
	
	public void addEdge(int start, int end)
	{
		adjMat[start][end] = 1;
		adjMat[end][start] = 1; //Get rid of this one for directed graphs.
	}
	
	public void displayVertex(int v)
	{
		System.out.println(vertexList[v].label);
	}
	
	public int getAdjUnvisitedVertex(int v)
	{
		for(int j = 0; j<nVerts; j++)
			if(adjMat[v][j]==1 &&vertexList[j].wasVisited ==false)
			{
				return j;
			}
		return -1;
	}
	
	public void dfs()
	{
		vertexList[0].wasVisited = true; //begin at vertex 0 and mark it.
		displayVertex(0); //display it
		theStack.push(0); //push it
		
		while(!theStack.isEmpty())//until stack is empty
		{
			int v = getAdjUnvisitedVertex(theStack.peek());
			if(v == -1) //if no such vertex...
				theStack.pop();
			else //if it does exist
			{
				vertexList[v].wasVisited = true; //mark it
				displayVertex(v); //display it
				theStack.push(v);
			}
		}
		//Stack is now empty, so we're done
		for(int j = 0; j<nVerts; j++) //reset flags
			vertexList[j].wasVisited = false;
	}//End of dfs, will return an unvisited vertex adjacent to v
	
	public void bfs()
	{
		vertexList[0].wasVisited = true; //Begin at vertex 0 and mark it
		displayVertex(0); //display it
		theQueue.insert(0); //insert it into the queue
		int v2;
		
		while(!theQueue.isEmpty()) //until the queue is empty...
		{
			int v1 = theQueue.remove(); //remove vertex at hand
			//until it has no unvisited neighbors
			while((v2 = getAdjUnvisitedVertex(v1)) != -1)
			{
				vertexList[v2].wasVisited = true; //get one and mark it
				displayVertex(v2); //display it
				theQueue.insert(v2);
			}
		}
		//Queue is empty, so we're done. Reset flags
		for(int j = 0; j<nVerts; j++)
			vertexList[j].wasVisited = false;
	}
	
	public void mst() //Minimum Spanning Tree (Depth First)
	{
		vertexList[0].wasVisited = true;//Start at 0, mark it
		theStack.push(0); //push it
		
		while (!theStack.isEmpty()) //until the stack is empty
		{
			int currentVertex = theStack.peek(); //Get the top of the stack
			int v = getAdjUnvisitedVertex(currentVertex); //get the next unvisited neighbor
			if(v == -1) //if no more neighbors
				theStack.pop(); //pop it off
			else //We found a neighbor
			{
				vertexList[v].wasVisited = true; //mark it
				theStack.push(v); //push it
				displayVertex(currentVertex); //display the edge from current v
				displayVertex(v); //to v
				System.out.println(" ");
			}
		}
		
		for(int j = 0; j<nVerts; j++)
			vertexList[j].wasVisited = false; //reset flags
	}
	
	public void warshallAlgo()
	{
		for(int k = 0; k<nVerts; k++)
		{
			for(int i = 0; i<nVerts; i++)
			{
				if(adjMat[k][i] == 1)
					continue;
				for(int j = 0; j<nVerts; j++)
					if(adjMat[j][k] == 1)
						adjMat[j][i] = 1;
			}
		}
	}

	
}
