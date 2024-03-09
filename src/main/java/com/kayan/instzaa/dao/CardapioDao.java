package com.kayan.instzaa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kayan.instzaa.model.CardapioItem;



public interface CardapioDao extends JpaRepository<CardapioItem, Long> {

}
