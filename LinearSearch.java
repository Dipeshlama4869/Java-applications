import java.util.Scanner;
public class LinearSearch
{
   public int linearSearch(int a[],int key)
   {

	   for(int i=0;i<a.length;i++)
	   {
		   if(a[i]==key)
		   {

		      return i;

		   }
	   }
	   return -1;
   }
   public static void main(String args[])
   {
       Scanner scan=new Scanner(System.in);
       LinearSearch obj=new LinearSearch();
       int a[]={12,2,5,6,9,4,1};
       System.out.print("Enter Search Value:");
       int element=scan.nextInt();
       int index=obj.linearSearch(a,element);
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