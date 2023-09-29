/*
Name: Xiaoli Lan
Date: March/9/2022

program discribe:
read data from a web, and stored the data into HashMaps
 
*/
package IndividualProject_COVIDApp;

import java.util.*;
import java.io.BufferedReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.net.URL;
import java.io.InputStreamReader;
import org.json.simple.JSONArray;

public class ReadData {
    // for store each day data
   public static HashMap<String, Long> confirmedMap = new HashMap<>();
   public static HashMap<String, Long> deathsMap = new HashMap<>();
   public static HashMap<String, Long> recoveredMap = new HashMap<>();
   
// for store the total number for confirmed, deaths, recovered
   public static ArrayList<Long> totalConfirmed = new ArrayList<>();
   public static ArrayList<Long> totalDeaths = new ArrayList<>();
   public static ArrayList<Long> totalRecovered = new ArrayList<>();
  
    
    public static void getData(String country) throws Exception{
       
        try{
            totalConfirmed = new ArrayList<>();
            totalDeaths = new ArrayList<>();
            totalRecovered = new ArrayList<>();
            // create a URL instance
            String theURL = "https://pomber.github.io/covid19/timeseries.json";
            
            URL url = new URL(theURL);
            BufferedReader br = 
            new BufferedReader(new InputStreamReader(url.openStream()));
            
            JSONParser jsonParser = new JSONParser();
            JSONObject myObject = (JSONObject)jsonParser.parse(br); 

            JSONArray dataArray = (JSONArray)myObject.get(country);
            String date;
            long confirmed, deaths, recovered;
            for(int i=0;i<dataArray.size();i++){
                JSONObject data = (JSONObject)dataArray.get(i);

                date = (String)data.get("date");
                confirmed = (long)data.get("confirmed");
                deaths = (long)data.get("deaths");
                recovered = (long)data.get("recovered");

                confirmedMap.put(date, confirmed);
                totalConfirmed.add(confirmed);
                
                deathsMap.put(date, deaths);
                totalDeaths.add(deaths);

                recoveredMap.put(date, recovered);
                totalRecovered.add(recovered);
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }

      
        
    }

}