package com.codingdojo.lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.lookify.models.Song;

@Repository
public interface SongRepository extends CrudRepository<Song, Long> {
	List<Song> findAll();
	
	
	List<Song> findByArtistContaining(String artist);
	
	//native query for artist
//	@Query(value="SELECT * FROM songs WHERE artist=(:searchString)", nativeQuery=true)
//	List<Song> searchartist(@Param("artist")String searchString);
	
	
	
	
	List<Song> findTop5ByOrderByRatingDesc();
	
	

	
}

