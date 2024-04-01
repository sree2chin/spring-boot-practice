package io.datajek.springbasics.movierecommendersystem.lesson9;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

// ========== mixing Bean scope ==========
@SpringBootApplication
public class MovieRecommenderSystemApplication {

    public static void main(String[] args) {

        //ApplicationContext manages the beans and dependencies
        ApplicationContext appContext = SpringApplication.run(MovieRecommenderSystemApplication.class, args);

        //Retrieve and print singleton bean from application context
        ContentBasedFilter filter = appContext.getBean(ContentBasedFilter.class);
        System.out.println("\nContentBasedFilter bean with singleton scope");
        System.out.println(filter);

        //Retrieve and print prototype bean from the singleton bean twice
        Movie movie1 = filter.getMovie();
        Movie movie2 = filter.getMovie();
        Movie movie3 = filter.getMovie();

        /* As can be seen from the output, the singleton bean constructor is called when the ContentBasedFilter object is initialized,
        but the Movie constructor isn’t called at that time. The Movie constructor is called whenever the proxy object gets used */
        System.out.println("\nMovie bean with prototype scope");
        System.out.println(movie1);
        System.out.println(movie2);
        System.out.println(movie3);

        //Print number of instances of each bean
        System.out.println("\nContentBasedFilter instances created: "+ ContentBasedFilter.getInstances());
        System.out.println("Movie instances created: "+ Movie.getInstances());
    }
}