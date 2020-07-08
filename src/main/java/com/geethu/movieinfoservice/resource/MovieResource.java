package com.geethu.movieinfoservice.resource;

import com.geethu.movieinfoservice.model.Movie;
import com.geethu.movieinfoservice.model.MovieSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/movies")
public class MovieResource {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.key}")
    private String apiKey;


    @RequestMapping("/{movieId}")
    public Movie getCMovies(@PathVariable String movieId){
        MovieSummary movie = restTemplate
                .getForObject(
                        "https://api.themoviedb.org/3/movie/"+ movieId+
                                "?api_key="+ apiKey, MovieSummary.class);

        return new Movie(movieId, movie.getTitle(), movie.getOverView());
    }
}
