package com.codingdojo.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.lookify.models.Song;
import com.codingdojo.lookify.services.SongService;

@Controller
public class HomeController {

	@Autowired
	private SongService songService;
	
	@GetMapping("/")
	public String welcomePage() {
		return "welcome.jsp";
	}
	
	//Get all 
	@GetMapping("/songs")
	public String dashboardPage(Model model) {
		List<Song> allSongs = songService.allSongs();
		model.addAttribute("songList", allSongs);
		return "dashboard.jsp";
	}
	
	//Create One - view create form
	@GetMapping("/songs/new")
	public String displayNewSongForm(@ModelAttribute("newSong") Song song) {
		return "addsong.jsp";
	}
	
	
	//Create One - process the form
    @PostMapping("/songs/new")
    public String create(@Valid @ModelAttribute("newSong") Song song, BindingResult result) {
        if (result.hasErrors()) {
            return "addsong.jsp";
        } 
        else {
            songService.addSong(song);
            return "redirect:/songs";
        }
    }
	
	//Get One - view one
	@GetMapping("/songs/{id}")
	public String oneExpense(@PathVariable("id")Long id, Model model) {
		Song song = songService.oneSong(id);
		model.addAttribute("song", song);
		return "onesong.jsp";
	}
	
	
	//Edit Form - display form
	@GetMapping("/songs/{id}/edit")
	public String displayUpdateForm(@PathVariable("id")Long id, Model model) 
	{
		Song song = songService.oneSong(id);
		model.addAttribute("song", song);
		return "editsong.jsp";
	}
	
	//Edit Form = process form
	@PutMapping("/songs/{id}/edit")
	public String processUpdate(@Valid @ModelAttribute("song") Song song, 
	BindingResult result) 
	{
		if(result.hasErrors()) {
			return"editsong.jsp";
		}
		else {
			songService.updateSong(song);
			return "redirect:/songs";
		}
	}

	
    //Delete One
	@DeleteMapping(value="/songs/{id}")
	public String deleteSong(@PathVariable("id") Long id) {
		songService.deleteSong(id);
		return "redirect:/songs";
	}
	
	
	
	
	//SearchByArtist - Create the request parameter and redirect to a get route which will run the function.
	@PostMapping("/songs/search")
	public String artistSearch(@RequestParam("artist") String artist) {
		System.out.println(artist);
		return "redirect:/songs/search/" + artist;
	}
	
	//SearchByArtist
	@GetMapping("/songs/search/{artist}")
	public String searchByArtist(Model model, @PathVariable("artist")String artist) {
		List<Song> songList = songService.artistSearch(artist);
		model.addAttribute("songList", songList);	
		return "dashboard.jsp";
	}
	
	
	
	//Top5
	@GetMapping("/songs/top5")
	public String displayTop5(Model model) {
		List<Song> songList = songService.getTop5();
		System.out.println(songList);
		model.addAttribute("songList", songList);
		return "top5.jsp";			
	}
	
	

}
