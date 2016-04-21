
public class Product
{
	private String pName;
	private String type;
	private double Cost;
	private Boolean Processed;
	private Boolean Packed;
	private double prob;

	public Product(String name, String Type, double prob)
	{
		pName = name;
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
	
	public void setProb(double p)
	{
		if(p > 1)
		{
			p = p/100;
			prob = p;
		}
		else
		{
			prob = p;
		}
	}
	
	public double checkProb()
	{
	    return prob;
	}

}
