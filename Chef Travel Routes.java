/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner rd = new Scanner(System.in);
		int numberOfCities = rd.nextInt();
        HashSet<String> setOfCities = new HashSet<>();
        for(int i=0;i<numberOfCities;i++){
            setOfCities.add(rd.next());
        }
        int routes = rd.nextInt();
        Map<List<String>,Integer> map = new HashMap<>();
        for(int i=0;i<routes;i++){
            List<String> l = new ArrayList<>();
            l.add(rd.next());
            l.add(rd.next());
            map.put(l,rd.nextInt());
        }
        int plannedRoutes = rd.nextInt();
        for(int i=0;i<plannedRoutes;i++){
            boolean anotherFlag = true;
            int r = rd.nextInt();
            List<String> routeList = new ArrayList<>();
            for(int j=0; j<r; j++){
                String str = rd.next();
                if(routeList.contains(str)){
                    anotherFlag = false;
                }
                routeList.add(str);
            }
            int sum= 0;
            boolean flag = false;
            if(anotherFlag){
                flag = true;
                if(routeList.size() == 1 && !setOfCities.contains(routeList.get(0))){
                    flag = false;
                }
                for(int k=0;k<routeList.size()-1;k++){
                    List<String> l = new ArrayList<>();
                    l.add(routeList.get(k));
                    l.add(routeList.get(k+1));
                    if(map.containsKey(l)){
                        sum = sum + map.get(l);
                    }else{
                        flag = false;
                        break;
                    }
                }
            }
            if(flag && anotherFlag)
                System.out.println(sum);
            else{
                System.out.println("ERROR");
            }
        }	// your code goes here
	}
}
