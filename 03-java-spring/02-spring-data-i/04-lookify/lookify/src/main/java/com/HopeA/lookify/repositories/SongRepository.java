package com.HopeA.lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.HopeA.lookify.models.Song;

@Repository
public interface SongRepository extends CrudRepository<Song, Long> { 
	
	List<Song> findAll();
	
	public List<Song> findByArtistContaining(String artist);
	
	public List<Song> findTop10ByOrderByRatingDesc();
	

}
