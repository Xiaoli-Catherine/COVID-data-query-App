
/*
Name: Xiaoli Lan
Date: March/9/2022

program discribe:
display the data of confirmed, deaths, and recovered in a specified date 
if the user input one country, 
or ask user to choose what data they wnat to get
(confirmed, deaths, or recovered)
If the user input two countries,display two countries' data
 
*/
package IndividualProject_COVIDApp;

import java.util.*;

public class DisplayData {


   
   
// if the user choose to display a country data in a specified date
    public static void displayDailyData(String country, String date) throws Exception{
        ReadData.getData(country);
        
        System.out.println("the covid data for "+ date +" is: ");
        System.out.println("confirmed: " + ReadData.confirmedMap.get(date));
        System.out.println("deaths: " + ReadData.deathsMap.get(date));
        System.out.println("recovered: " + ReadData.recoveredMap.get(date));
    }

    // if the user choose to display when a country reached a number of
    // confirmed, deaths, or recoveries
    public static void displayTotalData(String country, int number, Scanner input) throws Exception{
        
        ReadData.getData(country);

        System.out.println
        ("what do you want? input 1 for Confirmed, 2 for deaths, 3 for recoveres");
        int num = input.nextInt();
        if (num == 1){
            getConDate(country, number);
        }else if(num == 2){
            getDeathDate(country, number);
        }else if(num ==3){
            getReDate(country, number);
        }else{
            System.out.println("invoid num");
        }

    }

// get the date when the deaths reached a number
    public static void getDeathDate(String country, int number){

        int indexOfDeaths = ReadData.totalDeaths.size();
        int index = 0;
        int low = 0;
        // use binary seach to find the date
        while (low <=indexOfDeaths) {
            int mid = low  + ((indexOfDeaths - low) / 2);
            if (ReadData.totalDeaths.get(mid) < number) {
                low = mid + 1;
            } else if (ReadData.totalDeaths.get(mid) > number) {
                indexOfDeaths = mid - 1;
            } else if (ReadData.totalDeaths.get(mid) == number||low == indexOfDeaths) {
                index = mid;
                break;
            }
        }
        String dateOfDe = getData(index);
        System.out.println(country + " in "+ dateOfDe+" the deaths get "+number);

    }

// get the date when the confirmed reached a number
    public static void getConDate(String country, int number){
        int indexOfCon = ReadData.totalConfirmed.size();
        int index = 0;
        int lowIndex = 0;
        while (lowIndex <=indexOfCon) {
            int mid = lowIndex  + ((indexOfCon - lowIndex) / 2);
            if (ReadData.totalConfirmed.get(mid) < number) {
                lowIndex = mid + 1;
            } else if (ReadData.totalConfirmed.get(mid) > number) {
                indexOfCon = mid - 1;
            } else if (ReadData.totalConfirmed.get(mid) == number||lowIndex+1 == indexOfCon) {
                index = mid;
                break;
            }
        }
        String date = getData(index);
        System.out.println(country+ " in "+ date+" the confirmed get "+number);

    }

    // get the date when the recovered reached a number
    public static void getReDate(String country,int number){
        int indexOfRe = ReadData.totalRecovered.size();
        int index = 0;
        int lowIndex = 0;
        while (lowIndex <=indexOfRe) {
            int mid = lowIndex  + ((indexOfRe - lowIndex) / 2);
            if (ReadData.totalRecovered.get(mid) < number) {
                lowIndex = mid + 1;
            } else if (ReadData.totalRecovered.get(mid) > number) {
                indexOfRe = mid - 1;
            } else if (ReadData.totalRecovered.get(mid) == number||lowIndex+1 == indexOfRe) {
                index = mid;
                break;
            }
        }
        String date = getData(index);
        System.out.println(country+ " in "+ date+" the recoveres get "+number);

    }

    // transfer the index to a date
    public static String getData(int index){
        // set the start date
        int year = 2020;
        int month = 1;
        int day = 22;

        day = 22+index;
        while(day>28 && month == 2||
        day >30&&(month == 4||month== 6||month ==9||month==11)
        ||day >31){
            if((month <=7 && month%2 ==1)||(month >7 && month%2==0)){
                if(day>31){
                    month++;
                    day -= 31;          
                }
            }else if(month == 2){
                
                if(day >28){
                    month++;
                    day -= 28;
                }
                
            }else{
                if(day >30){
                    month++;
                    day -= 30;
                }
            }
            if(month >12) {
                year++;
                month = 1;
            }     
        }
        // return a string 
        if(day <10){
            return year+"/"+month+"/0"+day;
        }else if(month <10){
            return year+"/0"+month+"/"+day;
        }else if(day <10 && month<10){
            return year+"/0"+month+"/0"+day;
        }else{
            return year+"/"+month+"/"+day;
        }
    }

    // display two countries' data of confirmed, deaths, and recovered
    public static void displayCompareData(String country1, String country2, String date) throws Exception{
        ReadData.getData(country1);
        
        long country1Confirmed = ReadData.confirmedMap.get(date);
        long country1Deaths = ReadData.deathsMap.get(date);
        long country1Recovered = ReadData.recoveredMap.get(date);

        // read the second country's data
        ReadData.getData(country2);
        
        long country2Confirmed = ReadData.confirmedMap.get(date);
        long country2Deaths = ReadData.deathsMap.get(date);
        long country2Recovered = ReadData.recoveredMap.get(date);

        // display data of two countries
        System.out.println("The Covid-19 data of "+ country1 +" and "
        + country2+ " in "+ date);
        System.out.println();
        System.out.println("             "+country1+"     "+country2);
        System.out.println("confirmed:   "+ country1Confirmed+"     "+ 
        country2Confirmed);
        System.out.println("deaths:       "+country1Deaths+"     "+country2Deaths);
        System.out.println("recovered:    "+ country1Recovered+"     "+
        country2Recovered);       

    }

   
    
}
