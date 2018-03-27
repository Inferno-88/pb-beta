package com.octopus.pb.controller;


import com.octopus.pb.dto.RankDto;
import com.octopus.pb.service.RankService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/rank")
@Slf4j
public class RankController {

    @Autowired
    RankService rankService;


    @PostMapping("/create")
    public RankDto createRank(RankDto rankDto) {

        return rankService.createRankDto(rankDto);
    }

}
