import java.util.ArrayList;
import java.util.Random;
/**
*The ProcessingMachine class : class responsible for processing food.
*author : Nelson Poon
*

* @param: probablility of a jam happening (double) inherited from super class
* @param : rndm : generates a random item out of queue to begin processing
*/

public class ProcessingMachine extends Machine {
	static final int Process_Time1 = 20;
	static final int Process_Time2 = 22;
	protected ArrayList<Product> PerishQ1; //queue waiting for food to be processed
	protected ArrayList<Product> PerishQ2; //queue waiting for food to be processed
	protected ArrayList<Product> NPerishQ; //queue waiting for food to be processed
	public Product product;
	
	

	public ProcessingMachine(double probability,Random rndm)
	{
		super(probability, rndm);//
		PerishQ1 = new ArrayList<Product>();//Holds Perishable Product Types
		PerishQ2 = new ArrayList<Product>();//Holds Perishable Product Types
		NPerishQ = new ArrayList<Product>();//Holds NonPerishable Product Types
	}

	public ProcessingMachine()
	{
		
	}



public void processing(){ //main processing method
	Simulator.jam(); //check if machine jam
	if (this.type == null && !this.foodQueue.isEmpty(){
		this.type = this.foodqueue(); //takes food in queue into the machine
		}
	
	if(this.prTime >= PROCESS_TIME){ //main processing method
		Food foodreturned = this.type; 
		this.nextFood(this.type); // moves to the next item in the queue
		this.prTime = 0;
		return foodReturned; //processing has been completed
		}
	
    else if (this.type != null){ //holds food till process is completed
		this.prTime ++; //increseas time that its held in machine

		}
		return null
                }



		}
