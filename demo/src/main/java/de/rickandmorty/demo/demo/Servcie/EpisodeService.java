package de.rickandmorty.demo.demo.Servcie;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;
import de.rickandmorty.demo.demo.Entity.Episode;
import de.rickandmorty.demo.demo.Repository.EpisodeRepository;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;

@GraphQLApi
@Service
public class EpisodeService {

    private final EpisodeRepository episodeRepo;

    public EpisodeService( EpisodeRepository epRepo) {
        this.episodeRepo=epRepo;
    }

    @GraphQLQuery
    public Episode EpisodeById(int id) {
        return episodeRepo.findById(id);
    }

    @GraphQLQuery
    public List<Episode> EpisodeByName(String name) {
        return episodeRepo.findByName(name);
    }


    @GraphQLQuery
    public Collection<Episode> Episodes(int characterId) {
        return this.episodeRepo.getEpisodesbyCharcterId(characterId);
    }

    
}
