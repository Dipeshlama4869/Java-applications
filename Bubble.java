class Bubble
{
   public void bubbleSort(int a[],int n)
   {
	   for(int i=0;i<n;i++)
	   {
	      for(int j=0;j<n-i-1;j++)
	      {
		     if(a[j]>a[j+1])
		     {
			    int temp=a[j+1];
			    a[j+1]=a[j];
			    a[j]=temp;
			 }
		  }
	   }
   }
   public static void main(String args[])
   {
      Bubble obj=new Bubble();
      int a[]={25,57,48,37,12,92,86,33};
      obj.bubbleSort(a,a.length);
      System.out.println("Sorted Array is:");
      for(int i=0;i<a.length;i++)
      {
	     System.out.print(a[i] +"  ");
	  }
	  System.out.println("");
   }

}