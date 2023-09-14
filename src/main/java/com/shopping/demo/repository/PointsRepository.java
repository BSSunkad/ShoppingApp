package com.shopping.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopping.demo.entity.PointsValues;


@Repository
public interface PointsRepository extends JpaRepository<PointsValues, String>{

}
