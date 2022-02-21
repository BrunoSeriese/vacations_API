package nl.hsleiden.model;


import javax.persistence.*;

@Entity
@Table
public class Vacation {
    @Id
    @SequenceGenerator(
            name = "vacation_sequence",
            sequenceName = "vacation_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "vacation_sequence"
    )

    private long id;
    private String country;
    private double price;
    private String city;
    private int seasonID;
    private String description;

    public Vacation(){

    }

    public Vacation(String country, double price, String city, int seasonID, String description) {
        this.country = country;
        this.price = price;
        this.city = city;
        this.seasonID = seasonID;
        this.description = description;
    }

    public Vacation(long id, String country, double price, String city, int seasonID, String description) {
        this.id = id;
        this.country = country;
        this.price = price;
        this.city = city;
        this.seasonID = seasonID;
        this.description = description;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getSeasonID() {
        return seasonID;
    }

    public void setSeasonID(int seasonID) {
        this.seasonID = seasonID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Vacation{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", price=" + price +
                ", city='" + city + '\'' +
                ", seasonID=" + seasonID +
                ", description='" + description + '\'' +
                '}';
    }
}