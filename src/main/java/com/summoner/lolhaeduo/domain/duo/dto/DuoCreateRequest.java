package com.summoner.lolhaeduo.domain.duo.dto;

import com.summoner.lolhaeduo.domain.duo.enums.Lane;
import com.summoner.lolhaeduo.domain.duo.enums.QueueType;
import lombok.Getter;

@Getter
public class DuoCreateRequest {

    private String summonerName;
    private String tagLine;
    private QueueType queueType;
    private Lane primaryRole;
    private String primaryChamp;
    private Lane secondaryRole;
    private String secondaryChamp;
    private Lane targetRole;
    private String memo;
    private Boolean mic;
}
