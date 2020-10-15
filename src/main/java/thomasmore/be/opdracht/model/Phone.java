package thomasmore.be.opdracht.model;

import javax.persistence.*;

@Entity
public class Phone {

    @GeneratedValue
    @Id
    private Integer id;
    private String name;
    private int prijs;

    @ManyToOne
    private Brand brand;

    @ManyToOne(fetch = FetchType.LAZY)
    private Series series;

    public Phone() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Series getSeries() {
        return series;
    }

    public void setSeries(Series series) {
        this.series = series;
    }

    public int getPrijs() {
        return prijs;
    }

    public void setPrijs(int prijs) {
        this.prijs = prijs;
    }
}
