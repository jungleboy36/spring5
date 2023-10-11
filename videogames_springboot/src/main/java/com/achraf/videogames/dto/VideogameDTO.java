package com.achraf.videogames.dto;

import com.achraf.videogames.entities.Genre;
import com.achraf.videogames.entities.Image;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VideogameDTO {
    private Long idVideogame;
    private String nomVideogame ;
    private double prixVideogame ;
    private Date dateCreation ;
    private Genre genre;

    private String nomGen;
    private List<Image> images;

    public String getNomVideogame() {
        return nomVideogame;
    }

    public void setNomVideogame(String nomVideogame) {
        this.nomVideogame = nomVideogame;
    }

    public double getPrixVideogame() {
        return prixVideogame;
    }

    public void setPrixVideogame(double prixVideogame) {
        this.prixVideogame = prixVideogame;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public Long getIdVideogame() {
        return idVideogame;
    }

    public void setIdVideogame(Long idVideogame) {
        this.idVideogame = idVideogame;
    }

    public String getNomGen() {
        return nomGen;
    }

    public void setNomGen(String nomGen) {
        this.nomGen = nomGen;
    }
}
