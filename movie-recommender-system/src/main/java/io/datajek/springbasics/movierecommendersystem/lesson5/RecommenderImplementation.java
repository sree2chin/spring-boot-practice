package io.datajek.springbasics.movierecommendersystem.lesson5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RecommenderImplementation {

    //Filter is a dependency of RecommenderImplementation
    //use a filter to find recommendations
    @Autowired
    private Filter collaborativeFilter;

    public String [] recommendMovies (String movie) {
        System.out.println("\nName of the filter in use: " + collaborativeFilter + "\n");
        String[] results = collaborativeFilter.getRecommendations("Finding Dory");
        return results;
    }

}