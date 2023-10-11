package com.achraf.videogames.services;

import java.util.List;

import com.achraf.videogames.dto.VideogameDTO;
import com.achraf.videogames.entities.Genre;
import com.achraf.videogames.entities.Videogame;

public interface VideogameService {
VideogameDTO saveVideogame(VideogameDTO v);
VideogameDTO updateVideogame(VideogameDTO v);
void deleteVideogame(Videogame v);
void deleteVideogameById(Long id);
VideogameDTO getVideogame(long id);
List<VideogameDTO> getAllVideogames();
List<Videogame> findByNomVideogame(String nom);
List<Videogame> findByNomVideogameContains(String nom);
List<Videogame> findByNomPrix (String nom, Double prix);
List<Videogame> findByGenre (Genre genre);
List<Videogame> findByGenreIdGen(Long id);
List<Videogame> findByOrderByNomVideogameAsc();
List<Videogame> trierVideogamesNomsPrix();

VideogameDTO convertEntityToDto (Videogame produit);
Videogame convertDtoToEntity(VideogameDTO videogameDto);




}
