package com.example.demo.repository;

import com.example.demo.model.Kisi;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KisiRepository extends JpaRepository<Kisi, Long> {

    }
