package io.datajek.springbasics.movierecommendersystem.lesson8;

import java.util.Set;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CollaborativeFilter implements Filter{

    public CollaborativeFilter() {
        super();
    }

    //getRecommendations takes a movie as input and returns a list of similar movies
    public String[] getRecommendations(String movie) {

        //implement logic of collaborative filter

        //return movie recommendations
        return new String[] {"Finding Nemo", "Ice Age", "Toy Story"};
    }
}