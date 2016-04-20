
/**
 *  The SoupPowder class : gives information on the soup powder class 
 * @author : Malvin Harding
 */
 
public class SoupPowder extends NonPerishable{
  
  private String Name;
  private double prob;
  
  public SoupPowder()
  {
    Name = "Soup";
  }
  
  public String getName()
  {
    return Name;  
  }
  
  public double checkProb()
  {
    return prob;
  }
  
  public void setProb(double p)
  {
	prob = p;
  }
  
}
