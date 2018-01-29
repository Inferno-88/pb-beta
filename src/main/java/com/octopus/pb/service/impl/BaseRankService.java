package com.octopus.pb.service.impl;


import com.octopus.pb.model.Rank;
import com.octopus.pb.service.RankService;

import java.util.List;

public class BaseRankService implements RankService {

    @Override
    public Rank saveRank(Rank rank) {
        return null;
    }

    @Override
    public Rank getRank(String rankId) {
        return null;
    }

    @Override
    public List<Rank> getRankList() {
        return null;
    }

    @Override
    public int setNameForRank(String rankId, String name) {
        return 0;
    }

}
