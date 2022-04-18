package de.rickandmorty.demo.demo.Repository;

import org.springframework.stereotype.Repository;
import de.rickandmorty.demo.demo.Entity.Episode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EpisodeRepository {
    Episode episode1 = new Episode(1, "Pilot", "December 2,2013", "S01E01");
    Episode episode2 = new Episode(2, "Lawnmower Dog", "December 9, 2013", "S01E02");

    ArrayList<Episode> episodes = new ArrayList<Episode>();

    public EpisodeRepository() {
        episodes.add(episode1);
        episodes.add(episode2);
    }

    public Episode findById(int id) {
        return episodes.stream()
                .filter(ep -> ep.getId() == id)
                .findFirst().orElse(null);
    }

    public List<Episode> findByName(String name) {
        return episodes.stream().filter(episode -> episode.getName().toLowerCase().contains(name.toLowerCase()))
                .toList();

    }

    public Collection<Episode> getEpisodesbyCharcterId(int id) {
        return episodes.stream()
                .filter(episode -> episode.getResidents() == null
                        || Arrays.stream(episode.getResidents()).anyMatch(character -> character.getId() == id))
                .collect(Collectors.toList());
    }

    public ArrayList<Episode> getEpisodes() {
        return episodes;
    }

}
