package com.rodemark.models;


import com.sun.istack.NotNull;
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
    @NotNull
    @Column(name = "player1")
    private Long playerFirstID;

    @NotNull
    @Column(name = "player2")
    private Long playerSecondID;


    @Column(name = "winner")
    private Long winner;
}
