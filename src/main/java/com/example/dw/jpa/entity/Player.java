package com.example.dw.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "Player.findByName", query = "SELECT p FROM Player p WHERE p.name = :name ORDER BY p.id")
})
@Table(name = "PLAYER")
public class Player extends AbstractEntity {

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "player", cascade = CascadeType.ALL)
    private List<Score> scoreList;

    @NotNull
    @Size(min = 3, max = 45)
    @Column(name = "NAME", length = 45)
    private String name;

    @NotNull
    @Size(min = 3, max = 45)
    @Column(name = "LOGIN", length = 45)
    private String login;

    @JsonIgnore
    public List<Score> getScoreList() {
        return scoreList;
    }

    public void setScoreList(List<Score> scoreList) {
        this.scoreList = scoreList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
