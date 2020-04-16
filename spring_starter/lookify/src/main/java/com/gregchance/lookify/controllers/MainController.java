package com.gregchance.lookify.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gregchance.lookify.models.Song;
import com.gregchance.lookify.services.SongServ;

@Controller
public class MainController {

	private final SongServ songServ;
	
	public MainController(SongServ songServ) {
		this.songServ = songServ;
	}
	
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		List<Song> songs = songServ.findAll();
		model.addAttribute("songs", songs);
		return "dashboard.jsp";
	}
	@GetMapping("/songs/new")
	public String newSong(Model model) {
		model.addAttribute("song", new Song());
		return "newsong.jsp";
	}
	@GetMapping("songs/{song_id}")
	public String song(@PathVariable("song_id") Long id, Model model) {
		Song song = songServ.findOne(id);
		model.addAttribute("song", song);
		return "song.jsp";
	}
	@GetMapping("songs/topten")
	public String topten(Model model) {
		List<Song> songs = songServ.findAllByRating();
		ArrayList<Song> topten = new ArrayList<Song>();
		for(int i=0;i<songs.size();i++) {
			topten.add(songs.get(i));
			if(i == 9) {
				break;
			}
		}
		model.addAttribute("topten", topten);
		return "topten.jsp";
	}
	
	@PostMapping("/songs/new")
	public String newSong(@Valid @ModelAttribute("song") Song song, BindingResult result) {
		if(result.hasErrors()) {
			return "newsong.jsp";
		}
		songServ.create(song);
		return "redirect:/dashboard";
	}
	@PostMapping("/search")
	public String search(@RequestParam("search") String searchQuery, Model model) {
		List<Song> songs = songServ.searchArtists(searchQuery);
		if(songs.size() < 1) {
			model.addAttribute("error", "These are not the droids you're looking for");
		}
		model.addAttribute("songs", songs);
		return "searchartists.jsp";
	}
	
}
