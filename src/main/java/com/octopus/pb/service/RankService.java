package com.octopus.pb.service;


import com.octopus.pb.dto.RankDto;
import com.octopus.pb.entity.Rank;
import java.util.List;

public interface RankService {

    //DTO methods
    RankDto createRankDto(RankDto rankDto);

    //Repository methods
    Rank saveRank(Rank rank);

    Rank getRank(int rankId);

    List<Rank> getRankList();

}
