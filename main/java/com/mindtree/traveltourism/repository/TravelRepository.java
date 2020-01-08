package com.mindtree.traveltourism.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.traveltourism.entity.Travel;

@Repository
public interface TravelRepository extends JpaRepository<Travel, Integer> {

}
