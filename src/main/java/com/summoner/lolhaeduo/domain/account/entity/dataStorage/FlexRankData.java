package com.summoner.lolhaeduo.domain.account.entity.dataStorage;

import com.summoner.lolhaeduo.domain.duo.entity.Kda;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Entity
@Getter
@RequiredArgsConstructor
public class FlexRankData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tier;

    private String ranks;

    private int wins;

    private int totalGames;

    private Kda kda;

    private FlexRankData(String tier, String ranks, int wins, int totalGames, Kda kda) {
        this.tier = tier;
        this.ranks = ranks;
        this.wins = wins;
        this.totalGames = totalGames;
        this.kda = kda;
    }

    public static FlexRankData of(String tier, String ranks, int wins, int totalGames, Kda kda) {
        return new FlexRankData(tier, ranks, wins, totalGames, kda);
    }
}