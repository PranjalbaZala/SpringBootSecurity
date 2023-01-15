package com.example.pgfinder.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pgfinder.models.RoomInfo;

@Repository
public interface RoomInfoRepository extends JpaRepository<RoomInfo,Long>{

}
