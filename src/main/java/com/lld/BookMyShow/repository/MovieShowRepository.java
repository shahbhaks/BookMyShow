package com.lld.BookMyShow.repository;

import com.lld.BookMyShow.models.MovieShow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovieShowRepository extends JpaRepository<MovieShow, Long> {

    @Override
    Optional<MovieShow> findById(Long movieShowId);

    @Override
    MovieShow save(MovieShow movieShow);
}
