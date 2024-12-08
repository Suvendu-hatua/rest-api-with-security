package com.spring_boot.rest_api.Rest_Api_Demo.dao;

import com.spring_boot.rest_api.Rest_Api_Demo.pojo.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Long>,MovieCustomRepository {
}
