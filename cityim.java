import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Map.Entry;
import java.util.stream.Collectors;

//City&countries DAO
public class cityim implements main1interface{ 
   private BufferedReader br=null;
    public List<maincity> readcity (String filename) throws FileNotFoundException{
        List<maincity> l=new ArrayList<>();
         br=new BufferedReader(new FileReader(filename));
        String line=null;
        try {
            line = br.readLine();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            line = br.readLine();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        while(line!=null){
            String[] attributes=line.split(",");
            l.add(create(attributes));
            try {
                line = br.readLine();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        
    }
        return l;
         
    }
    public maincity create(String[] data){
        return new maincity(data[0], data[1],Double.parseDouble(data[2]) , data[3]);
    }
    @Override
    public List<conobj> readcountry(String filename) throws FileNotFoundException {
        List<conobj> l=new ArrayList<>();
        br=new BufferedReader(new FileReader(filename));
        String line=null;
        try {
            line = br.readLine();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            line = br.readLine();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        while(line!=null){
            String[] attributes=line.split(",");
            l.add(create1(attributes));
            try {
                line = br.readLine();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        
    }
        return l;
        
    }
    public conobj create1(String[] data){
        return new conobj(data[0], data[1],Double.parseDouble(data[2]) , data[3],Integer.parseInt(data[4]));
    }
    public Map<String,List<maincity>> Map_cityCountry(List<maincity> L){
        return L.stream().collect(Collectors.groupingBy(maincity::getID));
    }
    public List<maincity> Sort_By_pop(String s,Map<String,List<maincity>> M){
        List<maincity> L=M.get(" "+s);
        L.sort(Comparator.comparingDouble(maincity::getPop).reversed());
        return L;
    }

    public List<Double> List_of_country_pop(List<conobj> L1){

        return L1.stream().map(conobj::getPopc).collect(Collectors.toList());
    }
    public OptionalDouble AvgCountryPop(List<Double> Lp){
        OptionalDouble statsAvg = Lp.stream()
                                     .mapToDouble(x -> x)
                                     .average();
        return statsAvg;
    }

    public OptionalDouble MaxCountryPop(List<Double> Lp){
        OptionalDouble statsMax = Lp.stream()
                                     .mapToDouble(x -> x)
                                     .max();
        return statsMax;
    }
    
    public Map<String, List<maincity>> Highest_pop(Map<String,List<maincity>> map,List<maincity> L1,List<conobj> L2){
        
        Map<String,List<maincity>> b=new HashMap<>();
        Map<String,List<maincity>> a=new HashMap<>();
        for(Entry<String, List<maincity>> set : map.entrySet()){
            String key1=set.getKey();
            
            Double max=map.get(key1).stream()
                .max(Comparator.comparing(maincity::getPop))
                .get()
                .getPop();
    
             a = L1.stream().filter(m -> m.getPop()==max).collect(Collectors.groupingBy(maincity::getID,
                Collectors.toList()));
            b.put((String) a.keySet().toArray()[0], a.get(key1));
        }//String.valueOf(b.size()+1)
        return b;

        
    }
    public Optional<maincity> get_Highest_pop_capital(List<maincity> L1,List<conobj> L){
        //creating map of country and it's capital code
        Map<String,Integer> coun_capitals=L.stream().collect(Collectors.toMap(conobj::getIdc,conobj::getCapital));
        //filter only country that has capital
        List<maincity> cap=L1.stream()
        .filter(city->coun_capitals.containsValue(Integer.parseInt(city.getNo()))).collect(Collectors.toList());
        return cap.stream().max(Comparator.comparing(maincity::getPop));
        
    }
}

