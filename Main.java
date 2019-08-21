// Authors: Jeet Kumar, Chintan Patel, and Caitlin Miller
// Project Name: Hospital Information System
// Summary: This program consists of three modules. The three modules are billing, personal 
// information and staff. The purpose of the personal info module is to store, print and update data in
// text files assigned to each patient. The purpose of the billing module is to print hospital costs and print
// the amount the patient owes based on the amount of days they stayed at the hospital. The purpose of the staff 
// module is to see which nurses, doctors, and other staff members are employed in the hospital and add any staff
// members. 

import java.util.Scanner;
import java.sql.Timestamp;
import java.util.Date;
import java.util.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.System.*;
import java.io.File;
import java.io.FilenameFilter;


public class Main{
   public static void main(String [] args){
   newMain();
   }

  
   public static void newMain(){
//This function acts as a menu for our program 

      Scanner input = new Scanner(System.in);
      System.out.println("Welcome to the Hospital Information System!");
      System.out.println("Enter 1 to access the personal information module");
      System.out.println("Enter 2 to access the billing module");
      System.out.println("Enter 3 to access the staff module");
      int number = input.nextInt();
         
      if (number == 1)   
//Access the PersonalInfo module

         PersonalInfo();
            
      if (number == 2)   
//Access the Billing module

         Billing();
                     
      if (number == 3)
//Access the Staff module

         Staff(); 
   }
     
   public static void PersonalInfo(){
//The purpose of the PersonalInfo function is to enter in new patient information, see patient information
//and update patient information by using text files 

      Scanner input = new Scanner(System.in);
      System.out.println("Welcome to the Personal Information Module");
      System.out.println("Enter '0' to go back");
      System.out.println("Enter '1' to enter new patient information"); 
      System.out.println("Enter '2' to see patient information"); 
      System.out.println("Enter '3' to update patient information");
      int number = input.nextInt();
   
      if (number == 0){
//Go back to the start of the program 
 
      newMain();
      }
  
      if (number == 1){  
         System.out.println("Is the patient new to the hospital? (Y/N): ");
         char NewPatient = input.next().charAt(0);
         if (NewPatient == 'Y') { 
            
//Asks the user to enter in the patient info and then assigns the patient a random number using Math.Random, 
//and writes the output to a .txt file saved in the same directory. It will also name that patient file using the Random number generator.
            
            System.out.println("Enter Patient Information in this order with commas (Fullname, Date of Birth, Address, Phone Number, Height, Weight, Age, First Emergency Contact, Relationship to the Patient, First Emergency Contact Phone, Second Emergency Contact, Relationship to Patient, Second Emergency Contact Phone");    
            Scanner scan = new Scanner(System.in);
            String p1 = scan.nextLine();
            FileWriter fWriter = null;
            BufferedWriter writer = null;
            
            int randomNum = (int)(Math.random()* 10000);
              
            System.out.println("This patient's number is " + randomNum);

//Writes the patient info to a text file
            try {
               fWriter = new FileWriter(randomNum+".txt");
               writer = new BufferedWriter(fWriter);
               writer.write(p1);
               writer.newLine();
               writer.close();
               System.err.println("Your input of " + p1.length() + " characters was saved.");
            } 
            catch (Exception e) {
               System.out.println("Error!");
             }
            }
                                       
            Scanner input2 = new Scanner(System.in);
            System.out.println("Enter '1' to go back");
            int number2 = input.nextInt();
            
            if (number == 1)
//Accesses the personal info module
               PersonalInfo();     
         }
             
if (number == 2){
//Lists the patient files with their patient numbers
    
         File file = new File(".");
         String[] files=file.list(new FilenameFilter(){
         public boolean accept (File file, String string){
            return string.toLowerCase().endsWith(".txt");
            }
            });
         for (String string : files) {
            System.out.println(string);
            }
//Asks user to input a patient number
 
         Scanner read = new Scanner(System.in);
         System.out.print("Enter the patient number: ");
         String patient = read.nextLine();   
            
        try {
            FileReader reader = new FileReader(patient + ".txt");
            int character;
//Reads the user input of patient number and opens the .txt file
 
        while ((character = reader.read()) != -1) {
                System.out.print((char) character);
            }
            reader.close();
      }
      
      catch (IOException e) {
            e.printStackTrace();
        }

      Scanner input3 = new Scanner(System.in);
      System.out.println("Enter '2' to go back");
      int number3 = input.nextInt();
      
      if (number == 2)
//Access the personal info module
            PersonalInfo();
}    
  
      if (number == 3){
//Lists the patient files using the patient number
    
         File file = new File(".");
         String[] files=file.list(new FilenameFilter(){
         public boolean accept (File file, String string){
            return string.toLowerCase().endsWith(".txt");
            }
            });
         for (String string : files) {
            System.out.println(string);
            }
//Asks user to input a patient number
 
          Scanner update = new Scanner(System.in);
         System.out.print("Enter the patient number: ");
          String patient = update.nextLine();   
         System.out.print("Enter new information of the patient: ");
          String newtext = update.nextLine();        
//Asks the user for the information they wish to add to the existing file 
        
          FileWriter fWriter = null;
          BufferedWriter writer = null;
          try {
//APPEND MODE SET HERE this will append the text file insted of overwriting it

            writer = new BufferedWriter(new FileWriter(patient+".txt", true));
            writer.write("Updated Information - "+newtext);
            writer.newLine();
            writer.flush();
            }  
            catch (IOException ioe) {
               ioe.printStackTrace();
            }  
            finally {                       
               if (writer != null) try {
                  writer.close();
               }   
            catch (IOException ioe2) {   
     }
    } 
//Prints out the Updated text file
                
        try {
            FileReader reader = new FileReader(patient+".txt");
            int character;
 
        while ((character = reader.read()) != -1) {
                System.out.print((char) character);
            }
            reader.close();
 
      }catch (IOException e) {
            e.printStackTrace();
   }
   Scanner input4 = new Scanner(System.in);
   System.out.println("Enter '3' to go back");
   int number4 = input4.nextInt();
   if (number4 == 3)
//Accesses the PersonalInfo module

         PersonalInfo();
        
      }           
    }
   
      
   public static void Billing(){
   
// a class for billing  
    class billing {
         double medicine = 500;
         double room = 1000;
         double food = 100;
         double days = 1;
   
      public billing(){
      }
// a constructor for the billing class

      public billing (double newDays) {
         days = newDays;   
         }

      public double getTotal() {
         return days *(medicine + room + food);
         }
// Calculates the total cost

      public void setDays(double newDays) {
         days = newDays;
 }
}   
      Scanner input = new Scanner(System.in);
      System.out.println("Welcome to the Billing Module");
      System.out.println("Enter '0' to go back");
      System.out.println("Enter '1' to see hospital costs"); 
      System.out.println("Enter '2' to see payment due"); 
      int number = input.nextInt();
       
      if (number == 0){
         newMain();
         }
      
      if (number == 1){
         billing patient = new billing();
         
         System.out.println("The cost of the room is $" + patient.room + " per day");
         System.out.println("The cost of food is $" + patient.food + " per day");
         System.out.println("The cost of medicine is $" + patient.medicine + " per day");
        
        Scanner input5 = new Scanner(System.in);
         System.out.println("Enter '4' to go back");
         int number5 = input5.nextInt();
         if (number5 == 4)
//Accesses the Billing module
         Billing();

}
        
        
        
      if (number == 2){
//Asks the user to input how many days the patient stayed in the hospital
      
      System.out.println("How many days did the patient stay in the Hospital?: ");
      int days = input.nextInt();
      billing patient = new billing (days);
      System.out.println("The total cost for patient is: $" + patient.getTotal());
//Prints out the total cost
      Scanner input4 = new Scanner(System.in);
      System.out.println("Enter '3' to go back");
      int number4 = input4.nextInt();
      if (number4 == 3)
//Accesses the Billing module
         Billing();
         }
       }
//The Staff function will print lists of doctors, nurses, and other staff members and also
//add new members to each list
       
   public static void Staff(){
      Scanner input = new Scanner(System.in);
      System.out.println("Welcome to the Staff Module!");
      System.out.println("Enter '0' to go back");
      System.out.println("Enter '1' to view a list of doctors"); 
      System.out.println("Enter '2' to view a list of nurses");
      System.out.println("Enter '3' to view other staff");
      System.out.println("Enter '4' to add a new staff member");
      int number = input.nextInt();
      
      String[] Doctors = new String[4];
      String[] Nurses = new String[4];
      String[] Staff = new String[4];
      
      Doctors[0] = "Doctors";
      Doctors[1] = "Bruce Wayne";
      Doctors[2] = "Clark Kent";
      
      Nurses[0] = "Nurses";
      Nurses[1] = "Barry Allen";
      Nurses[2] = "Oliver Queen";
      
      Staff[0] = "Other Staff";
      Staff[1] = "Bernie Sanders";
      Staff[2] = "Donald Trump";
         
      if (number == 0)
// go back to the start of the program
         newMain();
         
      if (number == 1){
         for (int i=0; i<Doctors.length; i++){
             if (Doctors[i]!=null){  
               System.out.println(Doctors[i]);
             }
            }
            
         Scanner input6 = new Scanner(System.in);
            System.out.println("Enter '1' to go back");
            int number6 = input6.nextInt();
            
            if (number == 1){
//Accesses the staff module
               Staff();
      }
      }
      if (number == 2){
           for (int n=0; n<Nurses.length; n++){
             if (Nurses[n]!=null){  
               System.out.println(Nurses[n]);
             }
            }
          Scanner input7 = new Scanner(System.in);
            System.out.println("Enter '2' to go back");
            int number7 = input7.nextInt();
            
            if (number == 2){
//Accesses the staff module
               Staff();
}
}          
          
          
      if (number == 3){
          for (int s=0; s<Staff.length; s++){
             if (Staff[s]!=null){ 
               System.out.println(Staff[s]);
             }
            }

         Scanner input8 = new Scanner(System.in);
            System.out.println("Enter '3' to go back");
            int number8 = input8.nextInt();
            
            if (number == 3){
//Accesses the staff module
               Staff();
}
}      
            Scanner input1 = new Scanner(System.in);
            
       if (number == 4){
            System.out.print("Is the new staff member a doctor, a nurse or other? (d,n,o): ");
            char answer = input.next().charAt(0);
               if (answer == 'd'){
                  System.out.println("What is the doctor's name? :");
                  String member = input1.next();
            
                  Doctors[3] = member;
               
               for (int i=0; i<Doctors.length; i++){
                  if (Doctors[i]!=null) {
                     System.out.println(Doctors[i]);
     }
    }
   }
            Scanner input2 = new Scanner(System.in);
               if (answer =='n'){
               System.out.println("What is the nurse's name? :");
               String newNurse = input2.next();
               
               Nurses[3] = newNurse;
               
               for (int n=0; n<Nurses.length; n++){
                  if (Nurses[n]!=null){
                     System.out.println(Nurses[n]);
    }
   }            
  }
            Scanner input3 = new Scanner(System.in);
               if (answer =='o')
               System.out.println("What is the other staff's name? :");
               String newStaff = input3.next();
               
               Staff[3] = newStaff;
               
               for (int s=0; s<Staff.length; s++){
                  if (Staff[s]!=null){
                     System.out.println(Staff[s]);
    }
   }                         
  }
 }
}