import java.util.Scanner;

public class InsertionSort
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

		InsertionSort IS = new InsertionSort();
		IS.sortInsertion(A, n);

		System.out.println("\n");
		System.out.println("Sorted via Insertion Sort: ");
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
	
	void sortInsertion(int A[], int n){

		for (int i=1; i<=n-1; i++){
			int value = A[i];
			int hole = i;

			while(hole>0 && A[hole-1]>value){
				A[hole] = A[hole-1];
				hole = hole-1;
			}
			A[hole]=value;
		}
	}

	

}