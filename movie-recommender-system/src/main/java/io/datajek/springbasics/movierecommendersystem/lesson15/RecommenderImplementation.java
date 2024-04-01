package io.datajek.springbasics.movierecommendersystem.lesson15;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RecommenderImplementation {

    //Filter is a dependency of RecommenderImplementation
    @Autowired
    private Filter filter;

    @Value("${recommender.implementation.favoriteMovie: hello}")
    private String favoriteMovie;

    public RecommenderImplementation(Filter filter) {
        this.filter = filter;
    }

    public Filter getFilter() {
        return filter;
    }

    public String returnFavoriteMovie() {
        return favoriteMovie;
    }

    //use a filter to find recommendations
    public String [] recommendMovies (String movie) {

        //print the name of interface implementation being used
        System.out.println("\nName of the filter in use: " + filter + "\n");

        String[] results = filter.getRecommendations(movie);

        return results;
    }

}