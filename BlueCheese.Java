
public class BlueCheese extends Perishable{
  /**
   * The Perishable class : class which groups perishable food
   * @author : Malvin Harding
   */
   
   
  private String Name;
  private int time;
  private Boolean isSpoilt;
  private double prob;
  
  public BlueCheese()
  {
    Name = "BlueCheese";
    time = 40;
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
