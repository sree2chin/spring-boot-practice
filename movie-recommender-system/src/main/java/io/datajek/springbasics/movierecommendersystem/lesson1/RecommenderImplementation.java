package io.datajek.springbasics.movierecommendersystem.lesson1;

public class RecommenderImplementation {

    public String [] recommendMovies (String movie) {

        //use content based filter to find similar movies

        ContentBasedFilter filter = new ContentBasedFilter();
        String[] results = filter.getRecommendations(movie);

        //return the results
        //return new String[] {"M1", "M2", "M3"};
        return results;
    }

}