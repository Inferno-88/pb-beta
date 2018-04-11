package com.octopus.pb.controller;


import com.octopus.pb.dto.GroupDto;
import com.octopus.pb.dto.PlayerDto;
import com.octopus.pb.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Set;


@RestController
@RequestMapping("/group")
public class GroupController {

    @Autowired
    GroupService groupService;


    @GetMapping("/groups/{groupId}")
    public Set<PlayerDto> getGroupPlayerList(@RequestParam("groupId") int groupId,
                                             HttpServletResponse httpServletResponse) {
        return groupService.getPlayersFromGroup(groupId);
    }

    @PostMapping("/groups/{groupId}/players/{playerId}")
    public GroupDto addPlayerToGroup(@RequestParam("groupId") int groupId, @RequestParam("playerId") int playerId,
                                     HttpServletResponse httpServletResponse) {
        groupService.putPlayerToGroup(groupId, playerId);
        return new GroupDto();
    }

    @DeleteMapping("/groups/{groupId}/players/{playerId}")
    public GroupDto removePlayerFromGroup(@RequestParam("groupId") int groupId, @RequestParam("playerId") int playerId,
                                          HttpServletResponse httpServletResponse) {
        groupService.removePlayerFromGroup(groupId, playerId);
        return new GroupDto();
    }

}

