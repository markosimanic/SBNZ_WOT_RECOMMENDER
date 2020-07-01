package com.example.WoTRecommender.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class UserTankKey implements Serializable {

    @Column(name = "user_id")
    Long userID;

    @Column(name = "tank_id")
    Long tankID;

    public UserTankKey(Long userID, Long tankID) {
        this.userID = userID;
        this.tankID = tankID;
    }

    public UserTankKey(){

    }

    public Long getTankID() {
        return tankID;
    }

    public void setTankID(Long tankID) {
        this.tankID = tankID;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }
}
