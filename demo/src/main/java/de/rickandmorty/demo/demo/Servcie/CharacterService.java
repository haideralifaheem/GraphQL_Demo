package de.rickandmorty.demo.demo.Servcie;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import de.rickandmorty.demo.demo.Entity.Character;
import de.rickandmorty.demo.demo.Repository.CharacterRepository;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.execution.relay.Page;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;

@GraphQLApi
@Service
public class CharacterService {

    private final CharacterRepository repo;
    public CharacterService(CharacterRepository repo) {
        this.repo = repo;
    }

    @GraphQLQuery
    public Character CharacterbyId(int code) {
        return repo.findByID(code);
    }

    @GraphQLQuery
    public List<Character> CharacterbyName(String name) {
        return repo.findByName(name);
    }

    
    @GraphQLQuery
    //Relay page! Not Spring Data page!
    public Page<Character> Characters(
            @GraphQLArgument(name = "limit", defaultValue = "10") int limit,
            @GraphQLArgument(name = "offset", defaultValue = "0") int offset) {
        return repo.findCharacters(limit, offset);
    }

    
    @GraphQLQuery
    //Spring Data page. Toggle graphql.spqr.relay.spring-data-compatible for Relay compliant mapping
    public org.springframework.data.domain.Page<Character> CharactersData(Pageable paging) {
        return repo.findCharacters(paging);
    }
    
}
