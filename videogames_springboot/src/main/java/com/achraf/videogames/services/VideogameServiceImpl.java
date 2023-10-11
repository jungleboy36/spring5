package com.achraf.videogames.services;

import java.util.List;
import java.util.stream.Collectors;

import com.achraf.videogames.dto.VideogameDTO;
import com.achraf.videogames.repos.ImageRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.achraf.videogames.entities.Genre;
import com.achraf.videogames.entities.Videogame;
import com.achraf.videogames.repos.VideogameRepository;
@Service
public class VideogameServiceImpl implements VideogameService{
    @Autowired
	VideogameRepository videogameRepository ;

	@Autowired
	ModelMapper modelMapper;


	@Autowired
	ImageRepository imageRepository;
    @Override
	public VideogameDTO saveVideogame(VideogameDTO v) {
		return convertEntityToDto(videogameRepository.save(convertDtoToEntity(v)));
	}

	@Override
	public VideogameDTO updateVideogame(VideogameDTO v) {
		Videogame vidUpdated = videogameRepository.save(convertDtoToEntity(v));

		return convertEntityToDto(vidUpdated) ;


	}

	@Override
	public void deleteVideogame(Videogame v) {
		videogameRepository.delete(v);
		
	}

	@Override
	public void deleteVideogameById(Long id) {
		videogameRepository.deleteById(id);
		
	}

	@Override
	public VideogameDTO getVideogame(long id) {
		return convertEntityToDto(videogameRepository.findById(id).get());
	}

	@Override
	public List<VideogameDTO> getAllVideogames() {
		return videogameRepository.findAll().stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}
	@Override
	public List<Videogame> findByNomVideogame(String nom) {
	return videogameRepository.findByNomVideogame(nom);
	}
	@Override
	public List<Videogame> findByNomVideogameContains(String nom) {
	return videogameRepository.findByNomVideogameContains(nom);
	}
	@Override
	public List<Videogame> findByNomPrix(String nom, Double prix) {
		return videogameRepository.findByNomPrix(nom, prix);
	}
	@Override
	public List<Videogame> findByGenre(Genre genre) {
	return videogameRepository.findByGenre(genre);
	}
	@Override
	public List<Videogame> findByGenreIdGen(Long id) {
	return videogameRepository.findByGenreIdGen(id);
	}
	@Override
	public List<Videogame> findByOrderByNomVideogameAsc() {
	return videogameRepository.findByOrderByNomVideogameAsc();
	}
	@Override
	public List<Videogame> trierVideogamesNomsPrix() {
	return videogameRepository.trierVideogamesNomsPrix();
	}

	@Override
	public VideogameDTO convertEntityToDto(Videogame videogame) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		VideogameDTO videogameDTO = modelMapper.map(videogame, VideogameDTO.class);

		/*VideogameDTO videogameDTO = new VideogameDTO();
		videogameDTO.setIdVideogame(videogame.getIdVideogame());
		videogameDTO.setNomVideogame(videogame.getNomVideogame());
		videogameDTO.setPrixVideogame(videogame.getPrixVideogame());
		videogameDTO.setDateCreation(videogame.getDateCreation());
		videogameDTO.setGenre(videogame.getGenre());*/

		return videogameDTO;

 /*return VideogameDTO.builder()
.idVideogame(videogame.getIdVideogame())
.nomVideogame(videogame.getNomVideogame())
.prixVideogame(videogame.getPrixVideogame())
.dateCreation(p.getDateCreation())
.categorie(videogame.getGenre())
.build();*/
	}

	@Override
	public Videogame convertDtoToEntity(VideogameDTO videogameDto) {
		Videogame videogame = new Videogame();
		videogame = modelMapper.map(videogameDto, Videogame.class);
		/*Videogame videogame = new Videogame();
		videogame.setIdVideogame(videogameDto.getIdVideogame());
		videogame.setNomVideogame(videogameDto.getNomVideogame());
		videogame.setPrixVideogame(videogameDto.getPrixVideogame());
		videogame.setDateCreation(videogameDto.getDateCreation());
		videogame.setGenre(videogameDto.getGenre());*/
		return videogame;
	}

}
