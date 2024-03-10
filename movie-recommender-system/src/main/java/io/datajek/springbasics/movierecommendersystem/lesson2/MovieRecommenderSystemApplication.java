package io.datajek.springbasics.movierecommendersystem.lesson2;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MovieRecommenderSystemApplication {

    public static void main(String[] args) {

        //SpringApplication.run(MovieRecommenderSystemApplication.class, args);

        //passing name of the filter as constructor argument
        RecommenderImplementation recommender = new RecommenderImplementation((Filter) new ContentBasedFilter());

        //call method to get recommendations
        String[] result = recommender.recommendMovies("Finding Dory");

        //display results
        System.out.println(Arrays.toString(result));

    }

}