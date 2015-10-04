package com.example.dw.jpa.entity;

import javax.persistence.*;

@Entity
@Table(name = "SCORE")
public class Score extends AbstractEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private Player player;

    @Column(name = "STAGE")
    private Long stage;

    @Column(name = "POINTS")
    private Long points;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Long getStage() {
        return stage;
    }

    public void setStage(Long stage) {
        this.stage = stage;
    }

    public Long getPoints() {
        return points;
    }

    public void setPoints(Long points) {
        this.points = points;
    }
}
