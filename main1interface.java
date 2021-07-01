import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;

public interface main1interface {
    //private BufferedReader br;
    List<maincity> readcity (String filename) throws FileNotFoundException ;
    List<conobj> readcountry (String filename) throws FileNotFoundException ;
    maincity create(String[] data);
    conobj create1(String[] data);
    Map<String,List<maincity>> Map_cityCountry(List<maincity> L);
    List<maincity> Sort_By_pop(String s,Map<String,List<maincity>> M);
    List<Double> List_of_country_pop(List<conobj> L1);
    OptionalDouble AvgCountryPop(List<Double> Lp);
    OptionalDouble MaxCountryPop(List<Double> Lp);
    Map<String, List<maincity>> Highest_pop(Map<String,List<maincity>> map,List<maincity> L1,List<conobj> L2);
    Optional<maincity> get_Highest_pop_capital(List<maincity> L1,List<conobj> L);
}
