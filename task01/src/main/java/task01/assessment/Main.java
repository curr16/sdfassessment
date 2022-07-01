package task01.assessment;

import java.io.*;  
import java.util.Scanner;
import com.opencsv.exceptions.CsvException;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args)  throws IOException, CsvException {

    String fileName = "c:\\test\\csv\\thankyou.csv";
    

    //parsing a CSV file into Scanner class constructor  
    Scanner sc = new Scanner(new File("F:\\CSVDemo.csv"));  
    sc.useDelimiter(",");  
    while (sc.hasNext())
{  
    System.out.print(sc.next());  
}   
        sc.close();
        
    }


    
}