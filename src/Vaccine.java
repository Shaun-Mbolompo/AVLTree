/**
* The Vaccine object defines each data item from the vaccinations.csv file and has a method to compare one 
* data item with another
*
* @author Shaun
* @version 1.0 17/03/2022
*/

public class Vaccine implements Comparable<Vaccine>{

    String country;
    String date;
    String vacNum;
    String keyID;
    
    /**
    * The Vaccine single parameter object to take in the each line from the dataset and create a Vaccine object
    * 
    * @param line the data item line from the vaccinations.csv file
    */
    
    public Vaccine(String line)
    {
        String[] split = null;
        try{
            split = line.split(",");
            if(split.length>2){
            country = split[0];
            date = split[1];
            vacNum = split[2];
            keyID = split[0]+split[1];}
            else{
            split = line.split(",");
            country = split[0];
            date = split[1];
            keyID = split[0]+split[1];
            }
        }
        catch(NullPointerException e){
            e.printStackTrace();
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            split = line.split(",");
            country = split[0];
            date = split[1];
            vacNum = "0";
            keyID = split[0]+split[1];
        }
    }
    
    /**
    * Compares the Vaccine objects
    *
    * @param other is the other object that is being compared with this objecy
    * @return either 0, positive number or negative number. 0 if the objects compared are the same, negative if the object comes
    * after this one or positive if it comes before
    */
        
    public int compareTo(Vaccine other)
    {
        return keyID.compareTo(other.keyID);
    }    
}