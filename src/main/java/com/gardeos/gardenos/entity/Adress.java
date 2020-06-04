package com.gardeos.gardenos.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity(name="adress")
public class Adress {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @NotNull
    @Column(name="adress")
    private String adress;

    @NotNull
    @Column(name="street_number")
    private Integer streetNumber;

    @Column(name="home_number")
    private Integer homeNumber;

    @Column(name="extra")
    @Size(min = 10, max = 200, message = "Extra should be max 200")
    private String extra;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    @JsonIgnore
    private Client client = new Client();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Integer getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(Integer streetNumber) {
        this.streetNumber = streetNumber;
    }

    public Integer getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(Integer homeNumber) {
        this.homeNumber = homeNumber;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    @JsonIgnore
    public Client getClient() {
        return client;
    }

    @JsonProperty
    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Adress{" +
                "id=" + id +
                ", adress='" + adress + '\'' +
                ", streetNumber=" + streetNumber +
                ", homeNumber=" + homeNumber +
                ", extra='" + extra + '\'' +
                '}';
    }
}
