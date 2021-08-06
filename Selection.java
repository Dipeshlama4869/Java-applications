class Selection
{
   public void selectionSort(int a[],int n)
   {
      int index;
      for(int i=0;i<n;i++)
      {
	     int smlst=a[i];
	     index=i;
	     for(int j=i+1;j<n;j++)
	     {
		    if(a[j]<smlst)
		    {
			    index=j;
			    smlst=a[j];
			}
		 }
		 int temp=a[i];
		 a[index]=temp;
		 a[i]=smlst;

	  }


   }
   public static void main(String args[])
   {
      Selection obj=new Selection();
      int a[]={25,57,48,37,12,92,86,33};
      obj.selectionSort(a,a.length);
      System.out.println("Sorted Array is:");
      for(int i=0;i<a.length;i++)
      {
	     System.out.print(a[i] +"  ");
	  }
	  System.out.println("");
   }

}