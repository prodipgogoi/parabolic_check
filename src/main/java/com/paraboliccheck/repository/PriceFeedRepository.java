package com.paraboliccheck.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paraboliccheck.entity.PriceFeedModel;

public interface PriceFeedRepository extends JpaRepository<PriceFeedModel, Long> {

}
