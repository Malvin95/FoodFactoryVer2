
public class Perishable extends Product
{

	private int time;
	protected boolean isSpoilt;
	protected double prob;// 'p' is the probability of Perishable products occurring.

	public Perishable(String name, String Type, int time, double p)
	{
		super(name, Type, time);
		isSpoilt = false;
		prob = p;
	}

	public String getName()
	{
		return pName;
	}

	protected void toExpire()
	{
		for(int t = time; t > 0;t--)
		{
			if(t == 0)
			{
				isSpoilt = true;
			}
		}
	}
}
