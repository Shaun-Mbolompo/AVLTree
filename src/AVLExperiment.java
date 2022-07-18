import java.util.Scanner;
import java.io.*;

/** 
* The AVLExperiment object has the main method to run the experiment to test the AVL tree by randomisation of data
* 
* @author Shaun
* @version 1.0 17/03/2022
*/

public class AVLExperiment{
     
     
    int num = 0;  
    AVLTree<Vaccine> bt = new AVLTree<Vaccine> ();
    
    /**
    * The AVLExperiment empty constructor
    *
    */
    
    public AVLExperiment(){
    }
      
      
    FileWriter wrt = null;
 
    /**
    * Permutes the array according to given number of randomisations
    * 
    * @param array the array to be randomised
    * @param size the size of the array
    * @param permu number of randomisation for the array
    */
     
    public void permutation(String[] array,int size,int permu)
    {
        
        if(permu<9919){
               
        for(int i = 0; i<permu; i++)
        {
            if(size%2 == 1)
            {
                String temp = array[0];
                array[0] = array[size-1];
                array[size-1] = temp;
            }
            else
            {
                String temp;
                temp = array[i];
                array[i] = array[size-1];
                array[size-1] = temp;
            }
            size = size-1;
        }
        }
        else{
            for(int i = 0; i<9919; i++)
            {
            if(size%2 == 1)
            {
                String temp = array[0];
                array[0] = array[size-1];
                array[size-1] = temp;
            }
            else
            {
                String temp;
                temp = array[i];
                array[i] = array[size-1];
                array[size-1] = temp;
            }
            size = size - 1;
        }
            permu = permu-9919;
            size = 9919;
            permutation(array,size,permu);
        }
    }

    /**
    * The main method to run the experiment, it takes an argument to specify the number of randomisation the  
    * the vaccinations.csv file that it reads in and stores in an array must have
    *
    * @param args takes in string argument 
    */
    
    public static void main(String[] args)
    {
        AVLTree<Vaccine> avl = new AVLTree<Vaccine> ();  // Call the AVLTree object
        AVLExperiment exp = new AVLExperiment(); // Call this object
        
        String[] arr = new String[9919]; // Create a string array
        
        int count = 0;
        int permutations = 1;
        
        // Reads the vaccinations.csv file and stores the data into an array 
        try{
             permutations = Integer.parseInt(args[0]); // initializes the permutations/ randomisations needed
            
            try{
                BufferedReader read = new BufferedReader(new FileReader("data/vaccinations.csv"));
                String line = "";
                while((line = read.readLine())!=null)
                {
                     arr[count] = line;  
                     count++;   
                } 
            }
            catch(FileNotFoundException e)
            {
                System.out.println("File does not exist!");
                System.exit(0);
            }
            catch(IOException e){
                e.printStackTrace();}
        }
        catch(ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
            System.exit(0);}
        
        // calls the permutations method of the object AVLExperiment and pass in the arguments  
        exp.permutation(arr,9919,permutations);
        
        FileWriter wrt2 = null;
        FileWriter ins = null;
        int numb = 0;
        
        // Creates the searching and inserting files and use them to append the number of opCount and insertOpCount for the randomised dataset
            try{
                File search = new File("data/search/searching_"+permutations);
                search.createNewFile();
                File insert = new File("data/insert/inserting_"+permutations);
                insert.createNewFile();

                wrt2 = new FileWriter("data/search/searching_"+permutations);
                ins = new FileWriter("data/insert/inserting_"+permutations);
                
                
                for(int i =0;i<9919;i++){
                    avl.insert(new Vaccine(arr[i])); // insert the data items from the randomised data into the AVL tree
                    ins.write(avl.insertOpCount+"\n"); // writes on the created insert file the number of insertion key comparison taken
                    avl.insertOpCount = 0; // resets the insertOpCount to zero
                    numb++;
                    }
                ins.close(); // close the insertion file
                
                for(int i =0;i<9919;i++){
                    avl.find(new Vaccine(arr[i])); // searches each data item from dataset
                    wrt2.write(avl.opCount+"\n"); // writes on the created searching file the number of search key comparison taken for each item
                    avl.opCount = 0; // resets the opCount to zero
                    }
        }
        catch(FileNotFoundException e){
            System.out.println("The file does not exist!");}
        catch(IOException e){
            e.printStackTrace();}      
        try{
          wrt2.close();}catch(IOException e){e.printStackTrace();}
    }
}
