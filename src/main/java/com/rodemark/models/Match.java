package com.rodemark.models;


import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@jakarta.persistence.Entity
@Table(name = "matches")
public class Match extends Entity{
    @Column(name = "player1")
    private Long player1;

    @Column(name = "player2")
    private Long player2;

    @Column(name = "winner")
    private Long winner;
}
