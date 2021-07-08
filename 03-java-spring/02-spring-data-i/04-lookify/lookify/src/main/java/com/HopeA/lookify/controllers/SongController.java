package com.HopeA.lookify.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.HopeA.lookify.models.Song;
import com.HopeA.lookify.services.SongService;

@Controller
public class SongController {
	private final SongService sService;
	public SongController(SongService service) {
		this.sService = service;
	}
	
	//Welcome Screen index.jsp
	
	@GetMapping("/")
	public String index() {
	return "index.jsp";
	}
	//Dashboard display dashboard.jsp
	
	@GetMapping("/dashboard")
	public String dashboard(Model viewModel, Song song) {
		viewModel.addAttribute("allSongs", this.sService.allSongs());
		return "dashboard.jsp";
	}
	
//	@PostMapping("/artist")
//	public String artist(@Valid @ModelAttribute("artist") Song song, BindingResult result, Model viewModel) {
//		if(result.hasErrors()) {
//			viewModel.addAttribute("allSongs", this.sService.allSongs());
//			return "dashboard.jsp";
//		}
//		this.sService.findById(id);
//		return "redirect:/artist";
//	}
	
	//Adding New Song added to dashboard.jsp
	
	@GetMapping("/newsong")
	public String newSong(Model viewModel, @ModelAttribute("song") Song song) {
		viewModel.addAttribute("allSongs", this.sService.allSongs());
		return "newsong.jsp";
	}
	
	@PostMapping("/newsong")
	public String addSong(@Valid @ModelAttribute("song") Song song, BindingResult result, Model viewModel) {
		if(result.hasErrors()) {
			viewModel.addAttribute("allSongs", this.sService.allSongs());
			return "newsong.jsp";
		}
		this.sService.createSong(song);
		return "redirect:/dashboard";
	}
	
	//Shows/Displays info
	
	@GetMapping("/show/{id}")
	public String showSong(Model viewModel, @PathVariable("id") Long id) {
		viewModel.addAttribute("thisSong", this.sService.findSong(id));
		return "show.jsp";
		
	}
	//Delete One
	
	@DeleteMapping("/delete/{id}")
	public String deleteSong(@PathVariable("id") Long id) {
		this.sService.deleteSong(id);
		return "redirect:/dashboard";
	}
	
	//Artist Songs
	
	@GetMapping("/artist")
	public String artist(@RequestParam("artist") String artist, Model viewModel) {
		viewModel.addAttribute("thisSong", this.sService.songsContainingArtist(artist));
		viewModel.addAttribute("artist", artist);
		return "artist.jsp";
	}
	
	//Top Ten
	
	@GetMapping("/Top10")
	public String topTen(Model viewModel) {
		viewModel.addAttribute("song", sService.topTenByRating());
		return "Top10.jsp";
	}
	
	
}
