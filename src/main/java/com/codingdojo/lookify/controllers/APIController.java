package com.codingdojo.lookify.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.lookify.models.Song;
import com.codingdojo.lookify.services.SongService;

@RestController
@RequestMapping("/api")
public class APIController {

	private final SongService songService;
	
	public APIController(SongService songService) {
		this.songService = songService;
	}	
	
	
	//get all
	@GetMapping("/songs")
	public List<Song> getAllSongs(){
		return songService.allSongs();
	}
	
	
	//create 
	@PostMapping("/songs")
	public Song createSong( 
		@RequestParam("songTitle") String songTitle,
		@RequestParam("artist") String artist,
		@RequestParam("rating") Integer rating
		) {
		Song newSong = new Song(songTitle, artist, rating);
		return songService.addSong(newSong);
	} 
	
	
	//get one 
	@GetMapping("/songs/{id}")
	public Song getOneSong(@PathVariable("id")Long id) {
		return songService.oneSong(id);
	}
	
	
	
	//update -- findOne & create
	@PutMapping("/songs/{id}") 
	public Song editSongProcess(	
		@PathVariable("id") Long id,
		@RequestParam("songTitle") String songTitle,
		@RequestParam("artist") String artist,
		@RequestParam("rating") Integer rating
		) {
		Song foundSong = songService.oneSong(id);
		foundSong.setSongTitle(songTitle);
		foundSong.setArtist(artist);
		foundSong.setRating(rating);
		return songService.updateSong(foundSong);
		}
	
	
	//delete 
	@DeleteMapping("/songs/{id}")
	public void deleteSong(@PathVariable("id")Long id) {
		songService.deleteSong(id);
	}
	
	
	
}
