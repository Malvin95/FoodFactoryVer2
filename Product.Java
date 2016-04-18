public class Product
{

	private String type;
	private double Cost;

	public Product()
	{
		Cost = 0.20;
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
}
