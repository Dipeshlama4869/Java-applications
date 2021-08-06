import java.util.Scanner;
public class BinarySearch
{
   public int binarySearch(int a[],int key)
   {

	   int first=0;
	   int last=a.length-1;
	   int middle=(first+last)/2;
	   while(first<=last)
	   {
		   if(key> a[middle])
		   {
			   first=middle+1;
		   }
		   else if(a[middle]==key)
		   {
			   return (middle+1);
		   }
		   else
		   {
			   last=middle-1;
		   }
		   middle=(first+last)/2;
	   }
// if element is not found then first > last
	   return -1;
   }
   public static void main(String args[])
   {
       Scanner scan=new Scanner(System.in);
       BinarySearch obj=new BinarySearch();
       int a[]={2,3,4,5,8,19,21};
       System.out.print("Enter Search Value:");
       int element=scan.nextInt();
       int index=obj.binarySearch(a,element);
       if(index==-1)
       {
		   System.out.println("Value Not Found");
	   }
	   else
	   {
		   System.out.println("Value found at index="+index);
	   }

   }
}