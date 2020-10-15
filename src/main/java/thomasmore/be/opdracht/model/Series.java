package thomasmore.be.opdracht.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Series {

    @Id
    private int id;

    private String seriesName;
    private String seriesLinkMoreInfo;

    public Series() {
    }

    public int getId() {
        return id;
    }

    //Speculative Generality
    public void setId(int id) {
        this.id = id;
    }

    public String getSeriesName() {
        return seriesName;
    }

    //Speculative Generality
    public void setSeriesName(String name) {
        this.seriesName = name;
    }

    public String getSeriesLinkMoreInfo() {
        return seriesLinkMoreInfo;
    }

    //Speculative Generality
    public void setSeriesLinkMoreInfo(String linkMoreInfo) {
        this.seriesLinkMoreInfo = linkMoreInfo;
    }
}
