/*
 * This program will take in a list of student names and each students marks from a file. It will then take the data
 * and split it into 2 arrays, one for the student names and one for the marks. These will be parallel arrays so that
 * each index in the student names array will corespond to that students mark in the student marks array. We have 2 sorting
 * methods that will organize the arrays by alphabetical student name or by student mark from highest to lowest while 
 * maintaining the parallel array format. The program displays the data in its original form, alphabetical form, and
 * numerically organized form.
 * 
 * @author Akshar Barot
 * @author Jeffery Hu
 * @author Shreyansh Thakral
 * @since 2021-03-10
 * Teacher: Ms. Krasteva
*/

import java.util.*;
import java.io.*;

public class SortingStudents {
   
   private static String [] studentNames; //Holds the students names
   private static int [] studentMarks; //Holds the students marks
   
   /**
    * This method will use the insertion sorting method to organize the data alphabetically. 
    * It will keep the arrays parallel by making the same changes to the studentMarks array that are made
    * to the studentNames array. This means the data will still be proper.
   */
   
   public static void alphabetSort (){
      for (int i = 0; i < studentNames.length; i ++){
         String key = studentNames [i];
         int tempMark = studentMarks [i];
         int compIndex = i - 1 ;
         
         while (compIndex >= 0 && studentNames[compIndex].compareTo (key) > 0){
            studentNames [compIndex + 1] = studentNames [compIndex];
            studentMarks [compIndex + 1] = studentMarks [compIndex];
            compIndex --;
         }
         studentNames [compIndex + 1] = key;
         studentMarks [compIndex + 1] = tempMark;
      }
   } 
   
   /**
    * This method will use the insertion sorting method to organize the data by marks from highest to lowest. 
    * It will keep the arrays parallel by making the same changes to the studentNames array that are made
    * to the studentMarks array. This means the data will still be proper.
   */
   
   public static void markSort (){
      for (int i = 0; i < studentMarks.length; i ++){
         int key = studentMarks [i];
         String tempName = studentNames [i];
         int compIndex = i - 1;
         
         while (compIndex >= 0 && studentMarks [compIndex] < key){
            studentMarks [compIndex + 1] = studentMarks [compIndex];
            studentNames [compIndex + 1] = studentNames [compIndex];
            compIndex --;
         }
         studentMarks [compIndex + 1] = key;
         studentNames [compIndex + 1] = tempName;
      }
   }
   
   /**
    * This is the main method where we will read the data from the files, put it into the arrays,
    * call the different sorting methods, and then print out all the different sets of data. We use
    * BufferedReader to read through the file just to see how many lines there are, and then initialized
    * the arrays with the correct value (numberofLines /2). Then with another for loop, we read the data
    * from the file to the arrays using a conditional that makes sure that names go to the names array and
    * marks go to the marks array. Then it prints the entire set of data. Then we call the alphabeticalSort() 
    * method and print that. Then we finish by calling the numericalSort() method and printing that. We use
    * printf to get a nicely formatted result
   */
   
   public static void main (String [] args){
      int numberOfStudents = 0;
      try{
         BufferedReader input0 = new BufferedReader (new FileReader ("A7-1.txt"));
         String line = "";
         while (true){
            line = input0.readLine ();
            if (line == null){
               break;
            }
            numberOfStudents ++;
         }
         input0.close ();
      }
         catch (IOException e){
      }
      
      studentNames = new String [numberOfStudents/2];
      studentMarks = new int [numberOfStudents/2];
      
      try{
         BufferedReader input = new BufferedReader (new FileReader ("A7-1.txt"));
         for (int i = 0; i < numberOfStudents; i ++){
            String line = input.readLine ();
            if (i % 2 == 0){
               studentNames [i/2] = line;   
            }
            else{
               studentMarks [i/2] = Integer.parseInt (line);
            }   
         }
         input.close ();
      }
      catch (IOException e){     
      }      
      
      System.out.println ("Original Data");
      for (int i = 0; i < studentNames.length; i ++){
         System.out.printf ("%-7s  %7d \n", studentNames [i], studentMarks [i]);
      }
      
      System.out.println ("\nOrganized Alphabetically");   
      alphabetSort ();
      for (int i = 0; i < studentNames.length; i ++){
         System.out.printf ("%-7s  %7d \n", studentNames [i], studentMarks [i]);
      }
      
      System.out.println ("\nOrganized by Marks From Greatest to Lowest");
      
      markSort ();
      for (int i = 0; i < studentNames.length; i ++){
         System.out.printf ("%-7s  %7d %n", studentNames [i], studentMarks [i]);
      }
      
   }
}
