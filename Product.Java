
public class Product
{

	private String type;
	private double Cost;
	private Boolean Processed;
	private Boolean Packed;

	public Product()
	{
		Cost = 0.20;
		Processed = false;
		Packed = false;
	} 

	public void setType(String type)
	{
	this.type = type; 
	}
 
	public String getType()
	{
		return type; 
	}

	public double getCost()
	{
		return Cost;
	}
	
	public boolean isProcessed()
	{
		return Processed;
	}
	
	public void togglePro()
	{
		Processed = !Processed; 
	}
	
	public boolean isPacked()
	{
		return Packed; 
	}
	
	public void togglePack()
	{
		Packed = !Packed;
	}

}
