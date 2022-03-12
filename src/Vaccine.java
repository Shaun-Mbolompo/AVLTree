
public class Vaccine implements Comparable<Vaccine>{

    String country;
    String date;
    String vacNum;
    String keyID;
    
    public Vaccine(String line)
    {
        String[] split = line.split(",");
         
        try{
            country = split[0];
            date = split[1];
            vacNum = split[2];
            keyID = split[0]+split[1];       
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            country = split[0];
            date = split[1];
            vacNum = "0";
            keyID = split[0]+split[1];
        }
        catch(NullPointerException e){
            e.printStackTrace();
        }
    }
    
    public int compareTo(Vaccine other)
    {
        return keyID.compareTo(other.keyID);
    }
    
    public String toString()
    {
        return country + " = " + vacNum;
    }    

}