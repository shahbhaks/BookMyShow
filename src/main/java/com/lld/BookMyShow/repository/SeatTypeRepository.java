package com.lld.BookMyShow.repository;

import com.lld.BookMyShow.models.SeatType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SeatTypeRepository extends JpaRepository<SeatType, Long> {

    @Override
    Optional<SeatType> findById(Long movieShowId);

    @Override
    SeatType save(SeatType movieShow);
}
