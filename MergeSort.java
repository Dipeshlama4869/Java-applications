import java.util.Scanner;

public class MergeSort
{	
	/*Driver Program*/
	public static void main(String[] args) {

		Scanner S = new Scanner(System.in);
		System.out.println("Enter length of the unsorted array: ");
		int n = S.nextInt();

		/* To insert & print the elements of Array*/
		int [] A = new int[n];
		System.out.println("Enter key values of the array of size " +n +":\t");
		for (int i=0; i<A.length; i++) {
			A[i] = S.nextInt();			
		}

		System.out.print("Unsorted Elements: "+"\n");
		printArray(A);

		MergeSort MS = new MergeSort();
		MS.sortMerge(A);

		System.out.println("\n");
		System.out.println("Sorted via Merge Sort: ");
		System.out.println("=================================================");
		printArray(A);
		System.out.println("\n");
		System.out.println("=================================================");

		
	}
	/* To print the elements of Array*/
	static void printArray(int Arr[]){
		for (int i=0; i<Arr.length; i++) {
			System.out.print("\t" + Arr[i]);
			
		}
	}
	/* Recursive Calls*/
	void sortMerge(int A[]){

		int n = A.length;
		if(n!=1) 
		{	
			int mid = n/2; 
			int Left [] = new int [mid];
			int Right [] = new int [n-mid];

			for (int i=0; i<mid; i++){
				Left[i] = A[i];
			}

			for (int i=mid; i<n; i++){
				Right[i-mid] = A[i];
			}

			sortMerge(Left);
			sortMerge(Right);

			Merge(Left, Right, A);
		}
	}

	/* Comparing & Merging Method*/
	void Merge (int Left[], int Right[], int A[]){

		int nL = Left.length;
		int nR = Right.length;
		int i=0; int j=0; int k=0;

		while (i<nL && j<nR){
			if(Left[i]<=Right[j]){
				A[k] = Left[i];
				i++;
			}
			else{
				A[k] = Right[j];
				j++;
			}
		k++;			
		} 

		while (i<nL){
			A[k] = Left[i];
			i++; k++;
		}

		while (j<nR){
			A[k]=Right[j]; j++; k++;
		}		
	}

}