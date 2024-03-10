package io.datajek.springbasics.movierecommendersystem.lesson6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Qualifier;

@Component
public class RecommenderImplementation {

    //Filter is a dependency of RecommenderImplementation
    //use a filter to find recommendations
    @Autowired
    @Qualifier("CF")
    private Filter contentBasedFilter;

    public String [] recommendMovies (String movie) {
        System.out.println("\nName of the filter in use: " + contentBasedFilter + "\n");
        String[] results = contentBasedFilter.getRecommendations("Finding Dory");
        return results;
    }

}