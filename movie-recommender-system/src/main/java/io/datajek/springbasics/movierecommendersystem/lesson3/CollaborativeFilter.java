package io.datajek.springbasics.movierecommendersystem.lesson3;

public class CollaborativeFilter implements Filter{

    public String[] getRecommendations(String movie) {
        //logic of collaborative filter
        return new String[] {"Finding Nemo", "Ice Age", "Toy Story"};
    }
}