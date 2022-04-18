package de.rickandmorty.demo.demo.Repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import de.rickandmorty.demo.demo.Entity.*;
import de.rickandmorty.demo.demo.Entity.Character;
import de.rickandmorty.demo.demo.Entity.Character.Gender;
import de.rickandmorty.demo.demo.Entity.Character.Status;
import io.leangen.graphql.execution.relay.Page;
import io.leangen.graphql.execution.relay.generic.PageFactory;

@Repository
public class CharacterRepository {
        private final EpisodeRepository episodeRepository;
        private final LocationRepository locationRepository;

        public CharacterRepository(EpisodeRepository epRepo, LocationRepository locRepo) {
                this.episodeRepository = epRepo;
                this.locationRepository = locRepo;
        }

        public ArrayList<Character> GetData() {
                ArrayList<Episode> episodes = episodeRepository.getEpisodes();
                ArrayList<Character> data = new ArrayList<>();

                Character rickCharacter = new Character(1, "Rick Sanchez", Status.Alive, "Human", "", Gender.Male,
                                locationRepository.findById(1),
                                locationRepository.findById(1), "1.jpeg", episodes);
                Character mortyCharacter = new Character(2, "Morty Smith", Status.Alive, "Human", "", Gender.Male,
                                locationRepository.findById(1),
                                locationRepository.findById(1), "2.jpeg", episodes);
                Character Character3 = new Character(3, "Beth Smith", Status.Alive, "Human", "", Gender.Female,
                                locationRepository.findById(3),
                                locationRepository.findById(3), "3.jpeg", episodes);
                Character Character4 = new Character(4, "Summer Smith", Status.Alive, "Human", "", Gender.Female,
                                locationRepository.findById(3),
                                locationRepository.findById(3), "4.jpeg", episodes);
                Character Character5 = new Character(5, "Abadango Cluster Princess", Status.Alive, "Alien", "",
                                Gender.Female,
                                locationRepository.findById(2),
                                locationRepository.findById(2), "5.jpeg", episodes);
                episodes.get(0).setResidents(new Character[] { rickCharacter, mortyCharacter, Character3 });
                episodes.get(1).setResidents(new Character[] { rickCharacter, mortyCharacter });
                episodes.get(2).setResidents(
                                new Character[] { rickCharacter, mortyCharacter, Character3, Character4, Character5 });

                ArrayList<Location> locations = locationRepository.getLocations();
                locations.get(0).setResidents(new Character[] { rickCharacter, mortyCharacter });
                locations.get(1).setResidents(
                                new Character[] { rickCharacter, mortyCharacter, Character3, Character4 });
                locations.get(2).setResidents(new Character[] { Character5 });

                data.add(rickCharacter);
                data.add(mortyCharacter);
                data.add(Character3);
                data.add(Character4);
                data.add(Character5);
                return data;

        }

        public List<Character> findByName(String name) {
                ArrayList<Character> data = GetData();
                return data.stream().filter(character -> character.getName().toLowerCase().contains(name.toLowerCase()))
                                .toList();

        }

        public Character findByID(int id) {
                List<Character> data = GetData();
                return data.stream().filter(character -> character.getId() == id).findAny()
                                .orElse(null);

        }

        public Page<Character> findCharacters(int limit, int offset) {
                List<Character> allCharacters = GetData();
                List<Character> characters = allCharacters.subList(offset,
                                Math.min(offset + limit, allCharacters.size()));
                return PageFactory.createOffsetBasedPage(characters, allCharacters.size(), offset);
        }

        public org.springframework.data.domain.Page<Character> findCharacters(Pageable paging) {
                int offset = paging.getPageNumber() * paging.getPageSize();
                int limit = offset + paging.getPageSize();
                List<Character> allCharacters = GetData();
                List<Character> characters = allCharacters.subList(offset,
                                Math.min(offset + limit, allCharacters.size()));
                return new PageImpl<>(characters, paging, allCharacters.size());
        }

}
