import java.util.Arraylist
import java.util.Random
/**
* This is the class for simulating the machine
* @author David Bosun Arebuwa
*/

public class Simulator {
protected int pTime; //time taken to process the task
protected final double jamProbability; //the probability of the machine jamming
protected int jamQ; //time taken until there is no longer a jam
protected Food foodType; //the current food in the system
protected <Food> fQueue; //queue waiting for food to be processed
protected boolean isRunning; //checks to see if the machine is running
protected Random rndm;  
private static final int DEFAULT_JAM_TIME = 30; //default time machine is set to work


/**
* @param: probablility of a jam happening (double) inherited from super class
* @param : rndm : generates a random item out of queue to begin process
*/

public Simulator(double probability, Random rndm){
this.jamProbability = probability;
this.Queue = new Arraylist<Food>(); // creates a new arraylist which would be used to hold the types of food in the queue
this.rndm = Random;

}

public void queue(Food food) { //queues food into the machine
this.fQueue.add(food);

}

public void removeItem(Food food){ //removes food from machine
this.fQueue.remove(food);
}

public Food nextItem(){ //brings in next food into the machine
if(fQueue isEmpty(){
return null;
}
else{
return fQueue.get(0);
}
}

public int pTime(){ //time taken to process food
return this.fQueue.pTime();
}

public int itemQueued() { //number of items in the queue
return this.fQueue.size();
}

public boolean isJammed(){ //checks to see if machine bas been jammed
return !this.running;
}

public Food currentItem(){ // displays the current food in the machine
return this.currentItem;
}

public void jam(){ 
if(this.jamQ > 0){ 
this.jamQ -= 1;
if(this.jamQ == 0){
this.running = true;
else{
return null;
}
}
}
}
}
