package hms;

public class Marble {
	private int weight;
	private String color;
	private float diameter;
	
	Marble(int weight)
	{
		this.weight=weight;
	}
	
	public void marbleAction()
	{
		System.out.println("marble rolls");
	}
	public int findweight()
	{
		return weight;
		
	}

}
