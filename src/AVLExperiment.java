import java.util.Scanner;
import java.io.*;


public class AVLExperiment{
     
     
    int num = 0;  
     
    public AVLExperiment(){
    }
    String[] newArray = new String[9919];
    
    public void permutation(String[] array, int size, int n, int times)
    {
        if(size == 1)
        {       
            num++;
            if((num-1)==times){
                for(int i = 0;i<n;i++){
               try{
                        
                    FileWriter wrt = new FileWriter("/home/shaun/Assignment2/data/newFile.txt");
                    for(int j = 0; j<9919;j++){
                        wrt.write(array[j]+"\n");
                  }
                    wrt.close();
                }
                catch(IOException e)
                {
                    e.printStackTrace();
                } 
                
            }
            return;
            }
        }
        for(int i = 0; i<size; i++)
        {
            permutation(array,size-1,n,times);
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
        }
    }



    public static void main(String[] args)
    {
        AVLExperiment exp = new AVLExperiment();
        String[] arr = new String[9919];
        int count = 0;
        int permutations = 1;
        try{
             permutations = Integer.parseInt(args[0]);
            
            try{
                BufferedReader read = new BufferedReader(new FileReader("data/vaccinations.csv"));
                String line = "";
                while((line = read.readLine())!=null)
                {
                     arr[count] = line;
                     count++;   
                }
                File newFile = new File("/home/shaun/Assignment2/data/newFile.txt");
                newFile.createNewFile();

                
                
            }
            catch(FileNotFoundException e)
            {
                System.out.println("File does not exist!");
                System.exit(0);
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            e.printStackTrace();
        } 
        System.out.println(arr[2]+" "+count);   
        exp.permutation(arr,9919,9919,permutations);
    }

}