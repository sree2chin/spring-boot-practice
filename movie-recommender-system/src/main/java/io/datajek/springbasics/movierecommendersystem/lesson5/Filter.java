package io.datajek.springbasics.movierecommendersystem.lesson5;

public interface Filter {
    public String[] getRecommendations(String movie);
}