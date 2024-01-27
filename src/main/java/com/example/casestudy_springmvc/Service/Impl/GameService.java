package com.example.casestudy_springmvc.Service.Impl;

import com.example.casestudy_springmvc.Model.Game;
import com.example.casestudy_springmvc.Repository.IGameRepository;
import com.example.casestudy_springmvc.Service.IGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class GameService implements IGameService {
    @Autowired
    private IGameRepository gameRepository;

    @Override
    public Iterable<Game> findAll() {
        return gameRepository.findAll();
    }

    @Override
    public void save(Game game) {
        gameRepository.save(game);
    }

    @Override
    public void deleteById(int id) {
        gameRepository.deleteById(id);
    }

    @Override
    public Optional<Game> findById(int id) {
        return gameRepository.findById(id);
    }
}
