package com.lld.BookMyShow.repository;

import com.lld.BookMyShow.models.MovieShow;
import com.lld.BookMyShow.models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShowSeatRepository extends JpaRepository <ShowSeat, Long> {

    @Override
    Optional<ShowSeat> findById(Long showSeatId);

    @Override
    ShowSeat save(ShowSeat showSeat);
}

