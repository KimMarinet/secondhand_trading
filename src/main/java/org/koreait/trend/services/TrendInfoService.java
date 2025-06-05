package org.koreait.trend.services;

import lombok.RequiredArgsConstructor;
import org.koreait.trend.entities.Trend;
import org.koreait.trend.exceptions.TrendNotFoundException;
import org.koreait.trend.repositories.TrendRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TrendInfoService {

    private final TrendRepository repository;

    public Trend getLatest(String category){
        Trend item = null;
        try {
             item = repository.getLatest(category).orElseThrow(TrendNotFoundException::new);
        } catch (Exception e) {}
        return item;
    }

    public Trend get(LocalDate date, String category){

        return null;
    }

    public List<Trend> getList(){
        return null;
    }

    public List<Trend> getList(String category, LocalDate date){
        return null;
    }
}
