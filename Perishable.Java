
public class Perishable extends Product
{

	private int time;
	private String pName;
	protected boolean isSpoilt;
	protected double prob;

	public Perishable()
	{
		isSpoilt = false;
	}

	public void setName(String name)
	{
		pName = name;
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
}
