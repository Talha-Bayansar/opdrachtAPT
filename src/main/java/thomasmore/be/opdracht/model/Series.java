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

    public String getSeriesName() {
        return seriesName;
    }

    public String getSeriesLinkMoreInfo() {
        return seriesLinkMoreInfo;
    }
}
