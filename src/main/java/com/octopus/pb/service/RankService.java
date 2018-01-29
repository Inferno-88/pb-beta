package com.octopus.pb.service;


import com.octopus.pb.model.Rank;
import java.util.List;

public interface RankService {

    //Core methods


    //Repository methods
    Rank saveRank(Rank rank);

    Rank getRank(String rankId);

    List<Rank> getRankList();

    int setNameForRank(String rankId, String name);

}
