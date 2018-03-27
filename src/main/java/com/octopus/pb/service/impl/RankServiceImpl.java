package com.octopus.pb.service.impl;


import com.octopus.pb.dto.RankDto;
import com.octopus.pb.entity.Rank;
import com.octopus.pb.mapper.CycleAvoidContext;
import com.octopus.pb.mapper.RankMapper;
import com.octopus.pb.repository.RankRepository;
import com.octopus.pb.service.RankService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("rankService")
@RequiredArgsConstructor
public class RankServiceImpl implements RankService {

    private final RankRepository rankRepository;
    private final RankMapper rankMapper;
    private final CycleAvoidContext cycleAvoidContext;

    @Override
    public RankDto createRankDto(RankDto rankDto) {

        Rank rankEntity = rankMapper.dtoToEntity(rankDto);
        rankEntity = rankRepository.save(rankEntity);

        return rankMapper.entityToDto(rankEntity);
    }

    @Override
    public Rank saveRank(Rank rank) {
        return rankRepository.save(rank);
    }

    @Override
    public Rank getRank(int rankId) {
        return rankRepository.findOne(rankId);
    }

    @Override
    public List<Rank> getRankList() {
        return rankRepository.findAll();
    }

}
