import java.util.Scanner;

public class QuickSort
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

		QuickSort QS = new QuickSort();
		QS.sortQuick(A, 0, n-1);

		System.out.println("\n");
		System.out.println("Sorted via Quick Sort: ");
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
	void sortQuick(int A[], int start, int end){

		if (start<end){		
		int pIndex=Partition(A, start, end);
		sortQuick(A, start, pIndex-1);
		sortQuick(A, pIndex+1, end);
		}
	}

	/* Partitioning Method*/
	int Partition(int A[], int start, int end){

		int pivot=A[end]; 
		int pIndex=start;

		for (int i=start; i<end; i++){
			if (A[i]<=pivot){

				int temp = A[i];	//swapping
				A[i]=A[pIndex];
				A[pIndex]=temp;

				pIndex++;
			}

		}
		int temp1=A[pIndex];	//Final swapping to move pivot in the middle position
		A[pIndex]=A[end];
		A[end]=temp1;

	return pIndex;	//goto line number 45
	}

}