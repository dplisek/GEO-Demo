package com.zentity.demo.repositories;

import com.zentity.demo.domain.ATM;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ATMRepository extends JpaRepository<ATM, Long> {

    List<ATM> findByLocLatCentroidBetweenAndLocLongCentroidBetween(double latSouth, double latNorth, double longWest, double longEast);
}
