package io.datajek.springbasics.movierecommendersystem.lesson5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RecommenderImplementation {

    //Filter is a dependency of RecommenderImplementation
    //use a filter to find recommendations
    @Autowired
    private Filter contentBasedFilter;

    public String [] recommendMovies (String movie) {
        System.out.println("\nName of the filter in use: " + contentBasedFilter + "\n");
        String[] results = contentBasedFilter.getRecommendations("Finding Dory");
        return results;
    }

}