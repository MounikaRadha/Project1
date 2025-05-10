package com.RadhaMounika.backend.repository;

import com.RadhaMounika.backend.modals.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface NewsRepository extends JpaRepository<News, Integer> {
    @Query("select n.newsOfToday from News n order by id desc  limit 1")
    public String findTodayNews();
}
