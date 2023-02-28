package com.codingdojo.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.lookify.models.Song;
import com.codingdojo.lookify.repositories.SongRepository;

@Service
public class SongService {
	
	
	@Autowired
	private SongRepository songRepo;
	
	
	//get all 
	public List<Song> allSongs(){
		return songRepo.findAll();
	}
	
	//create 
	public Song addSong(Song newSong) {
		return songRepo.save(newSong);
	}
	
	//find one
	public Song oneSong(Long id) {
		Optional<Song> optionalSong = songRepo.findById(id);
		if(optionalSong.isPresent()) {
			return optionalSong.get();
			
		}
		else {
			return null;
		}
	}
	
	//update
	public Song updateSong(Song foundSong) {
		return songRepo.save(foundSong);
	}
	
	//delete
	public void deleteSong(Long id) {
		songRepo.deleteById(id);
	}
	
	//Find By Artist
	public List<Song> artistSearch(String artist){
		return songRepo.findByArtistContaining(artist);
//		return songRepo.searchartist(artist);
	}
	
	
	//	Find Top 5
	public List<Song> getTop5(){
		return songRepo.findTop5ByOrderByRatingDesc();
	}
	
	
}
