package com.example.WoTRecommender.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="USER_TANK")
public class UserTank {

    @EmbeddedId
    UserTankKey id;

    @ManyToOne
    @MapsId("user_id")
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @ManyToOne
    @MapsId("tank_id")
    @JoinColumn(name = "tank_id")
    private Tank tank;

    public UserTank() {
    }

    public UserTank(UserTankKey id, Tank tank) {
        this.id = id;
        //this.user = user;
        this.tank = tank;
    }

    public UserTankKey getId() {
        return id;
    }

    public void setId(UserTankKey id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Tank getTank() {
        return tank;
    }

    public void setTank(Tank tank) {
        this.tank = tank;
    }
}
