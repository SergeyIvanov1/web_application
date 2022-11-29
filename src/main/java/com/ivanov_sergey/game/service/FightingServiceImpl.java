package com.ivanov_sergey.game.service;

import com.ivanov_sergey.game.repository.Storage;

public class FightingServiceImpl implements FightingService {
    Storage repository;

    public FightingServiceImpl(Storage repository) {
        this.repository = repository;
    }
}
