/*
Name: Xiaoli Lan
Date: March/9/2022

program discribe:
Asks users to input one or two countries and the target date to get the data on COVID-19.
Compares the confirmed, deaths, and recovered data for any specified date when two country arguments are given
Displays data for a specified date that is chosen by the users or finds the date
when the country reached a user-defined number when one country argument is given.
 
*/
package IndividualProject_COVIDApp;

import java.util.*;
public class Test {
    
    public static void main(String[] args) throws Exception{
        String inputLine = "0";
        Scanner input = new Scanner(System.in);
        boolean run = true;
       
        while (run){
            
            System.out.println("\nEnter one or two country name or 0 to stop");
            
            if(!input.hasNext()) {
                System.out.println("Exited due to no input.");
                break;
            }
            inputLine = input.nextLine();
            System.out.println();
            if(inputLine.equals("0")){
                run = false;
                System.out.println("Bye!");
                break;
            }
            else{
            
                String countries[] = inputLine.trim().split("\s");
                if (countries.length>2 || countries.length<1) {
                    System.out.println("Invalid input. Please enter countries again.");
                    break;
                }
                String country1 = countries[0];
                // if user input two country, get the second country's name
                if(countries.length==2){ 
                           
                    String country2 = countries[1];
                    System.out.println("which day do you want to compare for this two conutries? ");
                    System.out.println("input a special date in the format of year-month-day");
                    String date = input.next();          
                    DisplayData.displayCompareData(country1, country2,date);    
                }else{                            
                    System.out.println("Want do you want?");
                    System.out.println("Input 1 for display data for a special date");
                    System.out.println
                    ("Input 2 for find when the country get a number of confimed cases deaths, or recoveries");
                    
                    inputLine = input.nextLine();
                    if (!inputLine.matches("[0-9]+")) {
                        System.out.println("Input is not an integer. Please re-start");
                        break;
                    }
                   
                    int number = Integer.parseInt(inputLine);
                    if (number == 1){
                        System.out.println("Input a special date in the format of year-month-day");
                        String date = input.next();
                        DisplayData.displayDailyData(country1, date);
                    }else if(number ==2){
                        System.out.println("Input a number to getting a date");
                       
                        inputLine = input.nextLine();
                        if (!inputLine.matches("[0-9]+")) {
                            System.out.println("Input is not an integer. Please re-start");
                            break;
                        }
                       
                        int num = Integer.parseInt(inputLine);
                        DisplayData.displayTotalData(country1,num,input);
                       
                    }else{
                        System.out.println("Invoid number");                                                
                    }
                }                                      
            }
            input.nextLine();
        }        
        input.close();
    }
    
}
