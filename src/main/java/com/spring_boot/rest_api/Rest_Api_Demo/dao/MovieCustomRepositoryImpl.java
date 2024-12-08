package com.spring_boot.rest_api.Rest_Api_Demo.dao;

import com.spring_boot.rest_api.Rest_Api_Demo.pojo.Movie;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieCustomRepositoryImpl implements MovieCustomRepository{
    private EntityManager entityManager;

    @Autowired
    public MovieCustomRepositoryImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }
    @Override
    public List<Movie> sortMovieByPublicationYear() {
        TypedQuery<Movie> query=entityManager.createQuery("from Movie order by publication_year desc",Movie.class);
        return query.getResultList();
    }

    @Override
    public List<Movie> searchMovieByTitle(String title) {
       TypedQuery<Movie> query =entityManager.createQuery("from Movie where title like :keyword",Movie.class);
        query.setParameter("keyword","%"+title+"%");
        return query.getResultList();
    }
}
