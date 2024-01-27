package com.example.casestudy_springmvc.Repository;

import com.example.casestudy_springmvc.Model.Game;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IGameRepository extends CrudRepository<Game, Integer> {
    void deleteById(int id);
}
