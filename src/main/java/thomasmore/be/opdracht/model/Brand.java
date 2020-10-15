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

    public void setId(int id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String name) {
        this.brandName = name;
    }

    public String getBrandLinkMoreInfo() {
        return brandLinkMoreInfo;
    }

    public void setBrandLinkMoreInfo(String linkMoreInfo) {
        this.brandLinkMoreInfo = linkMoreInfo;
    }
}
