package com.example.WoTRecommender.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="CHARACTERISTICS")
public class Characteristics {

        private static final long serialVersionUID = 1L;

        @Id
        @Column(name="id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name="name")
        private String name;

        @ManyToMany(mappedBy = "characteristics")
        @JsonIgnore
        List<Tank> tanks;

        @ManyToMany(mappedBy = "characteristics")
        @JsonIgnore
        List<User> users;


        public Characteristics() {
        }

        public void setName(String name) {
                this.name = name;
        }


        public String getName() {
                return name;
        }


        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public List<Tank> getTanks() {
                return tanks;
        }

        public void setTanks(List<Tank> tanks) {
                this.tanks = tanks;
        }

        public List<User> getUsers() {
                return users;
        }

        public void setUsers(List<User> users) {
                this.users = users;
        }
}
