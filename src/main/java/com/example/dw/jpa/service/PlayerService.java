package com.example.dw.jpa.service;

import com.example.dw.jpa.entity.Player;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Optional;

public class PlayerService extends AbstractService<Player> {

    public List<Player> findPlayerByName(final Optional<String> name) {
        if (name.isPresent()) {
            return dao.find(entityClass, "Player.findByName", ImmutableMap.of("name", name.get()));
        } else {
            return Lists.newArrayList();
        }
    }
}
