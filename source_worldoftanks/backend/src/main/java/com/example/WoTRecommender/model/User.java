package com.example.WoTRecommender.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.joda.time.DateTime;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

@Entity
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private Integer balance;

    private Integer paidmoney;

    private Boolean discount;

    @Column(name = "recommendation_string")
    private String recommendationString;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_category")
    private UserCategory userCategory;

    @OneToOne()
    private Tank currentTank;

    @Column(name = "enabled")
    private boolean enabled;

    @Column(name = "last_password_reset_date")
    private Timestamp lastPasswordResetDate;

    @OneToMany(mappedBy = "user")
    private List<UserTank> tanks;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_authority",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id"))
    private List<Authority> authorities;

    // This field represents which characteristics user picked for his favourite tank
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_characteristics",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "characteristics_id", referencedColumnName = "id"))
    private List<Characteristics> characteristics;

    public User() {
    }

    public User(Long id, String username, String password, Integer balance, Integer paidmoney, Boolean discount,
                String recommendationString, UserCategory userCategory, List<UserTank> tanks) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.balance = balance;
        this.userCategory = userCategory;
        this.paidmoney = paidmoney;
        this.discount = discount;
        this.recommendationString = recommendationString;
        this.tanks = tanks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public Timestamp getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }

    public UserCategory getUserCategory() {
        return userCategory;
    }

    public Integer getPaidmoney() {
        return paidmoney;
    }

    public void setPaidmoney(Integer paidmoney) {
        this.paidmoney = paidmoney;
    }

    public void setUserCategory(UserCategory userCategory) {
        this.userCategory = userCategory;
    }

    public void setLastPasswordResetDate(Timestamp lastPasswordResetDate) {
        this.lastPasswordResetDate = lastPasswordResetDate;
    }

    public void setCurrentTank(Tank currentTank) {
        this.currentTank = currentTank;
    }

    public Tank getCurrentTank() {
        return currentTank;
    }

    public List<Characteristics> getUser_characteristics() {
        return characteristics;
    }

    public void setUser_characteristics(List<Characteristics> user_characteristics) {
        this.characteristics = user_characteristics;
    }

    public void setPassword(String password) {
        Timestamp now = new Timestamp(DateTime.now().getMillis());
        this.setLastPasswordResetDate( now );
        this.password = password;
    }

    public String getRecommendationString() {
        return recommendationString;
    }

    public void setRecommendationString(String reccomendationString) {
        this.recommendationString = reccomendationString;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Boolean getDiscount() {
        return discount;
    }

    public void setDiscount(Boolean discount) {
        this.discount = discount;
    }

    public List<UserTank> getTanks() {
        return tanks;
    }

    public void setTanks(List<UserTank> tanks) {
        this.tanks = tanks;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

}
