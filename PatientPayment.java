 import java.util.Scanner;
 public class Payment{
   public static void main(String args[]){
   
   }
   
   Payment(){
   }
   
   public Payment(){
           myList[0][0] = "Medicine";
           myList[0][1] = "500";
           
           myList[1][0] = "Room";
           myList[1][1] = "1000";
           
           myList[2][0] = "Food";
           myList[2][1] = "550";
           
           int total = Integer.parseInt(myList[0][1]) + Integer.parseInt(myList[1][1]) + Integer.parseInt(myList[2][1]);
           
           System.out.println("The bill for the patient is: " + total);
        }
 }