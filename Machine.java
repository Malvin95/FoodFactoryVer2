import java.util.Random;

/**
The Machine class: A superclass which controls the processing and packaging classes
@author: David Bosun-Arebuwa 
*/

public class Machine{
	private Random rndm;
	private double prob;

	public Machine(){
	}

	public Machine(double probability, Random random) {
		// TODO Auto-generated constructor stub
		prob = probability;
		rndm = random;
	}

	public void random()
	{
		Random rndm = new Random();
	}

	public double getProb()
	{
		return prob;
	}
}
