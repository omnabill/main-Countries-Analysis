//Country pojo Class
public class conobj {
    private String idc;
    private String country;
    private Double popc;
    private  String content;
    private int capital ;
    public String getIdc() {
        return this.idc;
    }
    public void setIdc(String idc) {
        this.idc = idc;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Double getPopc() {
        return this.popc;
    }

    public void setPopc(Double popc) {
        this.popc = popc;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCapital() {
        return this.capital;
    }

    public void setCapital(int capital) {
        this.capital = capital;
    }



    public conobj(String idc, String country, Double popc, String content, int capital) {
        this.idc = idc;
        this.country = country;
        this.popc = popc;
        this.content = content;
        this.capital = capital;
    }
  


    @Override
    public String toString() {
        return "{" +
            " idc='" + getIdc() + "'" +
            ", country='" + getCountry() + "'" +
            ", popc='" + getPopc() + "'" +
            ", content='" + getContent() + "'" +
            ", capital='" + getCapital() + "'" +
            "}"+'\n';
    }
   
}
