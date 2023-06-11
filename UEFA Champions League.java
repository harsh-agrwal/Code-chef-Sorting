/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.Map.Entry;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int i = 0; i < tc; i++){
		    HashMap <String, Integer> points = new HashMap<>();
		    HashMap <String, Integer> goals = new HashMap<>();
		    int max = -1;
		    for(int j=0; j<12; j++){
    		    String arr[] = br.readLine().split(" ");
    		    String HomeTeamName = arr[0];
    		    int HomeTeamGoals = Integer.parseInt(arr[1]);
    		    int AwayTeamGoals = Integer.parseInt(arr[3]);
    		    String AwayTeamName = arr[4];
    		    if(HomeTeamGoals>AwayTeamGoals){
    		        if(!points.containsKey(HomeTeamName)){
    		            points.put(HomeTeamName, 3);
    		            goals.put(HomeTeamName, (HomeTeamGoals-AwayTeamGoals));
    		        }else{
    		            int p = points.get(HomeTeamName)+3;
    		            points.put(HomeTeamName, p);
    		            int g = goals.get(HomeTeamName)+(HomeTeamGoals-AwayTeamGoals);
    		            goals.put(HomeTeamName, g);
    		        }
    		        if(!points.containsKey(AwayTeamName)){   
    		            points.put(AwayTeamName, 0);
    		            goals.put(AwayTeamName, (AwayTeamGoals-HomeTeamGoals));
    		        }else{
    		            //no point update
    		            int g = goals.get(AwayTeamName)-HomeTeamGoals+AwayTeamGoals;
    		            goals.put(AwayTeamName, g);
    		        }
    		    }
    		    else if(AwayTeamGoals>HomeTeamGoals){
    		        if(!points.containsKey(AwayTeamName)){
    		            points.put(AwayTeamName, 3);
    		            goals.put(AwayTeamName, (AwayTeamGoals-HomeTeamGoals));
    		        }else{
    		            int p = points.get(AwayTeamName)+3;
    		            points.put(AwayTeamName, p);
    		            int g = goals.get(AwayTeamName)+(AwayTeamGoals-HomeTeamGoals);
    		            goals.put(AwayTeamName, g);
    		        }
    		        if(!points.containsKey(HomeTeamName)){
    		            points.put(HomeTeamName, 0);
    		            goals.put(HomeTeamName, (HomeTeamGoals-AwayTeamGoals));
    		        }else{
    		            //no point update
    		            int g = goals.get(HomeTeamName)+HomeTeamGoals-AwayTeamGoals;
    		            goals.put(HomeTeamName, g);
    		        }
    		    }
    		    else{  //tie
    		        if(!points.containsKey(HomeTeamName)){
    		            points.put(HomeTeamName,1);
    		            goals.put(HomeTeamName, 0);
    		        }else{
    		            int p = points.get(HomeTeamName)+1;
    		            points.put(HomeTeamName, p);
    		            
    		            //no goal update
    		        }
    		        if(!points.containsKey(AwayTeamName)){
    		            points.put(AwayTeamName, 1);
    		            goals.put(AwayTeamName, 0);
    		        }else{
    		            int p = points.get(AwayTeamName)+1;
    		            points.put(AwayTeamName, p);
    		            
    		            //no goal update
    		        }
    		    }
		    }
		    Set<Entry<String, Integer>> ptable = points.entrySet();
		    String team1 = "", team2 = "";
		    for(Entry<String, Integer> entry: ptable){
		        if(entry.getValue()>max){
		            team1 = entry.getKey();
		            max = entry.getValue();
		        }else if(entry.getValue()==max){
		            if(goals.get(entry.getKey())>goals.get(team1)){
		                team1 = entry.getKey();
		            }
		        }
		    }
		    goals.remove(team1);
		    points.remove(team1);
		    Set<Entry<String, Integer>> ptable2 = points.entrySet();
            max = -1;
		    for(Entry<String, Integer> entry : ptable2){
		        if(entry.getValue()>max){
		            team2 = entry.getKey();
		            max = entry.getValue();
		        }else if(entry.getValue()==max){
		            if(goals.get(entry.getKey())>goals.get(team2)){
		                team2 = entry.getKey();
		            }
		        }
		    }
		    System.out.println(team1+" "+team2);
		}
		
	}
}
