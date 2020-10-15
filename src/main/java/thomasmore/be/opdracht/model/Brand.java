package thomasmore.be.opdracht.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Brand {

    @Id
    private int id;

    private String brandName;
    private String brandLinkMoreInfo;

    public Brand() {
    }

    public int getId() {
        return id;
    }

    public String getBrandName() {
        return brandName;
    }

    public String getBrandLinkMoreInfo() {
        return brandLinkMoreInfo;
    }
}
