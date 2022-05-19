package de.rickandmorty.demo.demo.Repository.MongoCurdRepository;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import de.rickandmorty.demo.demo.Entity.Character;

@Repository 
public interface CharacterCurdRepository extends MongoRepository<Character, Integer> {
    List<Character> findByNameContaining(String name);
}
