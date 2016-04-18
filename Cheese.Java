
public class Cheese extends Perishable{
  
  private String Name;
  private int time;
  private Boolean isSpoilt;
  private double prob;
  
  public Cheese()
  {
    Name = "Cheese";
    time = 45;
    isSpoilt = false; 
  }
  
  public String getName()
  {
    return Name;  
  }
  
  public int getTime()
  {
    return time;
  }
  
  public boolean checkIfSpoilt()
  {
	  return isSpoilt;
  }
  
  public double checkProb()
  {
    return prob;
  }
  
}
