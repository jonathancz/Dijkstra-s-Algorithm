import java.util.Scanner;

public Class DijkstraAlgorithm{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int[][] matrix = new int [5][5]; // Using 5 nodes
		// Updates itself according to each node visit
		// so that the element in the node will have the 
		// least distance
		int[] distance = new int[5]; // Store first row of matrix
		int[] visited = new int[5];
		//
		int[] preD = new int[5];
		int min;
		// nextNode is going to hold the value of the next node which
		// we find in the running area
		int nextNode = 0;

		System.out.println("Enter the Matrix: ");

		for(int i = 0; i < 5; i++) {
			visited[i] = 0;
			preD[i] = 0;
			for(int j = 0; j < 5; j++) {
				matrix[i][j] = scan.nextInt();
				if(matrix[i][j] == 0) {
					matrix[i][j] = 999;
				} 
			}	
		}

		// Set the first row of the matrix to the distance array
		distance = matrix[0];
		// Initialize the first element of distance as 0
		// there is no distance from the source. Ex from A -> A,
		// distance is 0.
		distance[0] = 0;
		visited[0] = 1;

		// Initiate the algorithm
		for(int i = 0; i < 5; i++) {
			min = 999;
			
			for(int j = 0; j < 5; j++){
				if(min > distance[j] && visited[j] != 1) {
					min = distance[j];
					// The next node we're going to visit from the source
					nextNode = j;
				}
			}
			visited[nextNode] = 1;

			for(int c = 0; c < 5; c++) {
				if(visited[c] != 1) {
					if(min + matrix[nextNode][c] < distance[c]) {
						distance[c] = (min + matrix[nextNode][c]);
						preD[c] = nextNode;
					}
				}
			}
		}
		
		
		//Print Paths
		for(int i = 0; i < 5; i++){
			
			System.out.print("|" + distance[i]);
			
		}
		System.out.println("|");
		
		int j;
		for(int i = 0; i < 5; i++){
			
			if(i!=0){
				
				System.out.print("Path = " + i);
				j = i;
				do{
					j=preD[j];
					System.out.print(" <- " + j);
				}while(j!=0);
			}
			
			System.out.println();
			
		}
	}
}