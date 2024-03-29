package com.example.WoTRecommender.model;
import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name="TANK")
public class Tank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="price")
    private Integer price;

    @Column(name="tank_status")
    @Enumerated(EnumType.STRING)
    private TankStatus tankStatus;

    @Enumerated(EnumType.STRING)
    private TankType tankType;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "tank_characteristics",
            joinColumns = @JoinColumn(name = "tank_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "characteristics_id", referencedColumnName = "id"))
    private List<Characteristics> characteristics;


    public Tank() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTankType(TankType tankType) {
        this.tankType = tankType;
    }


    public void setCharacteristics(List<Characteristics> characteristics) {
        this.characteristics = characteristics;
    }

    public TankStatus getTankStatus() {
        return tankStatus;
    }

    public void setTankStatus(TankStatus tankStatus) {
        this.tankStatus = tankStatus;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public TankType getTankType() {
        return tankType;
    }

    public Collection<Characteristics> getCharacteristics() {
        return characteristics;
    }

}
