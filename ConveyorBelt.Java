import java.util.ArrayList;
import java.util.Random;
/**
* This is the class for simulating the machine
* @author David Bosun Arebuwa
*/

public class ConveyorBelt{
	
	protected int pTime; //time taken to process the task
	protected final double jamProbability; //the probability of the machine jamming
	protected int JamT; //time taken until there is no longer a jam
	protected Product pType; //the current food in the system
	protected ArrayList<Product> pQueue; //queue waiting for food to be processed
	protected boolean isRunning; //checks to see if the machine is running
	protected Random rndm;  
	private static final int DEFAULT_JAM_TIME = 30; //default time machine is set to work

/**
 	* @param: probablility of a jam happening (double) inherited from super class
* @param : rndm : generates a random item out of queue to begin process
*/

	public ConveyorBelt(double prob, Random rndm)
	{
		jamProbability = prob;
		rndm = new Random();
		pQueue = new ArrayList<Product>(); // creates a new arrayList that is used to hold food types in queue.
		isRunning = false; 
	}

	//queues food into the machine
	public void queue(Product prd) 
	{
		pQueue.add(prd);
	}

	//removes food from machine
	public void removeItem(Product product)
	{
		this.pQueue.remove(product);
	}

	//brings in next food into the machine
	public Product nextItem()
	{
		if(pQueue.isEmpty())
		{
			return null;
		}
	else
		{
		return pQueue.get(0);
		}
	}

	//time taken to process food
	public int checkTime()
	{
		return pTime;
	}

	//number of items in the queue
	public int itemQueued() 
	{ 
		return this.pQueue.size();
	}

	//checks to see if machine bas been jammed
	public boolean isJammed()
	{
		return isRunning;
	}

	/* displays the current food in the machine
	public Product currentItem()
	{ 
		return this.currentItem;
	}*/

	public void JamSim()
	{
		
		if(JamT > 0)
		{ 
			JamT -= 1;
		}
		else if(JamT == 0)
		{
			isRunning = true;
		}
	}
}
