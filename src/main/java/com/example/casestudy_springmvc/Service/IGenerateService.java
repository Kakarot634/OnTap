package com.example.casestudy_springmvc.Service;

import java.util.Optional;

public interface IGenerateService<G> {
    Iterable<G> findAll();
    void save(G g);

    void deleteById(int id);

    Optional<G> findById(int id);
}
