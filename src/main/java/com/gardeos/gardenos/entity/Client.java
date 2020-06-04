package com.gardeos.gardenos.entity;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity(name="client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    @NotNull(message = "Name cannot be null")
    private String name;

    @Column(name="surrname")
    private String surrname;

    @Column(name="email")
    @Email(message = "Email should be valid")
    private String email;

    @Column(name="telephone_number")
    @Pattern(regexp="(^$|[0-9]{9})")
    private String telephoneNumber;

    @Column(name="extra")
    @Size(min = 10, max = 200, message = "Extra should be max 200")
    private String extra;

    @OneToMany(mappedBy = "adress",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY)
    private List<Adress> adressList = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurrname() {
        return surrname;
    }

    public void setSurrname(String surrname) {
        this.surrname = surrname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public List<Adress> getAdressList() {
        return adressList;
    }

    public void setAdressList(List<Adress> adressList) {
        this.adressList = adressList;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surrname='" + surrname + '\'' +
                ", email='" + email + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", extra='" + extra + '\'' +
                ", adressList=" + adressList +
                '}';
    }
}
