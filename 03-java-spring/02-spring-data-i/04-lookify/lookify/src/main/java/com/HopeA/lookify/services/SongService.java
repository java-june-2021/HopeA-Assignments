package com.HopeA.lookify.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.HopeA.lookify.models.Song;
import com.HopeA.lookify.repositories.SongRepository;

@Service

public class SongService {

	private final SongRepository sRepo;
	public SongService(SongRepository repo) {
		this.sRepo = repo;
	}
	
	//METHODS
	
	//FIND ALL
	
	public List<Song> allSongs() {
		return this.sRepo.findAll();
	}
	
	//FIND ONE SONG
	
	public Song findSong(Long id) {
		return this.sRepo.findById(id).orElse(null);
	}
	
	//FIND ONE ARTIST
	
	public List<Song> songsContainingArtist(String artist) {
		return this.sRepo.findByArtistContaining(artist);
	}
	
	//FIND TOPTEN
	
	public List<Song> topTenByRating() {
		return this.sRepo.findTop10ByOrderByRatingDesc();
	}
	
	//CREATE
	
	public Song createSong(Song newSong) {
		return this.sRepo.save(newSong);
	}
	
	//DELETE
	
	public void deleteSong(Long id) {
		this.sRepo.deleteById(id);
	}
}
