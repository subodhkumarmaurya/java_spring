package com.gregchance.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.gregchance.lookify.models.Song;
import com.gregchance.lookify.repositories.SongRepo;

@Service
public class SongServ {

	private final SongRepo songRepo;
	
	public SongServ(SongRepo songRepo) {
		this.songRepo = songRepo;
	}
	
	public List<Song> findAll() {
		return songRepo.findAll();
	}
	public List<Song> findAllByRating() {
		return songRepo.findAllByOrderByRatingDesc();
	}
	public List<Song> searchArtists(String str) {
		return songRepo.findByArtistContaining(str);
	}
	public Song findOne(Long id) {
		Optional<Song> song = songRepo.findById(id);
		if(song.isPresent()) {
			return song.get();
		}
		return null;
	}
	public Song create(Song song) {
		return songRepo.save(song);
	}
	public Song update(Song song) {
		return songRepo.save(song);
	}
	public void delete(Long id) {
		songRepo.deleteById(id);
	}
}