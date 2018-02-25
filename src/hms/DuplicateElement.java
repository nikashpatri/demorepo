package hms;

public class DuplicateElement {
	
	public void removeDuplicates(int[] x)
	{
		
		for(int i=0;i<x.length;i++)
		{
			int duplicate=0;
			for(int j=0;j<i;j++)
			{
				if(x[i]==x[j])
				{
					duplicate=1;
					break;
				}
			}
			if(duplicate==0)
			{
				System.out.print(x[i]);
			}
		}
	}

	public static void main(String[] args) {
		DuplicateElement d=new DuplicateElement();
		d.removeDuplicates(new int[]{4,5,4,7,2,5,4,9,7});
		

	}

}
