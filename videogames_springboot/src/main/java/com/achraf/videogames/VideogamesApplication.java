package com.achraf.videogames;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.achraf.videogames.entities.Genre;
import com.achraf.videogames.entities.Videogame;

@SpringBootApplication
public class VideogamesApplication implements CommandLineRunner{

	
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration ;
	public static void main(String[] args) {
		SpringApplication.run(VideogamesApplication.class, args);}

		@Override
		public void run(String... args) throws Exception {
		repositoryRestConfiguration.exposeIdsFor(Videogame.class,Genre.class);
		}

	@Bean
	public ModelMapper modelMapper()
	{
		return new ModelMapper();
	}


}
