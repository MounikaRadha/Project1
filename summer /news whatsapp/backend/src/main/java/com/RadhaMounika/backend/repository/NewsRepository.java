package com.RadhaMounika.backend.repository;

import com.RadhaMounika.backend.modals.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News,Integer> {
}
