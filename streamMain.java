import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;

public class streamMain {
    public static void main(String[] args) throws IOException {
        cityim pdao= new cityim();
        
        List<maincity> list1=  pdao.readcity("D:\\Cities.csv");
        List<conobj> list2=  pdao.readcountry("D:\\C.csv");
        //Printing list of Countries and cities in the csv file
        System.out.println("List Of Cities From CSV File : "+list1);
        System.out.println("List Of Countries From CSV File : "+list2);
        //Make and print map of countries and the cities in them
        Map<String,List<maincity>> map=pdao.Map_cityCountry(list1);
        System.out.println("Map of countries and cities:  \n"+map);
        InputStreamReader r=new InputStreamReader(System.in);  
        BufferedReader br=new BufferedReader(r);  
       System.out.println("please Enter the Country ID You Want to show sorted : ");
       String name=br.readLine();  
       List<maincity> L=pdao.Sort_By_pop(name, map);
       //Show the country city's taken from user in sorted manner
       System.out.println(L);
       //List of Countries population to use it to get Average and Maximum
       List<Double> LL=pdao.List_of_country_pop(list2);
       System.out.println("Country population List : "+ LL);

       OptionalDouble OD1=pdao.AvgCountryPop(LL);
       OptionalDouble OD2 = pdao.MaxCountryPop(LL) ; 
       //print Highest population and average for countries  
        System.out.println("Average of Countries Population is : "+OD1);
        System.out.println("Maximum  Country Population is : "+OD2);
        //Highest Population city for each country
        System.out.println("Highest Population City for each country is : \n"+ pdao.Highest_pop(map, list1,list2));
        //Highest population capital
        System.out.println("Highest population Capital Overall is : "+ pdao.get_Highest_pop_capital(list1, list2));

          

    }
    }
   
