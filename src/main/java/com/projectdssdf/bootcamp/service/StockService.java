package com.projectdssdf.bootcamp.service;


import com.projectdssdf.bootcamp.mapper.StockMapper;
import com.projectdssdf.bootcamp.model.Stock;
import com.projectdssdf.bootcamp.model.dto.StockDTO;
import com.projectdssdf.bootcamp.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class StockService {

    @Autowired
    private StockRepository repository;

    @Autowired
    private StockMapper mapper;

    @Transactional
    public StockDTO save(StockDTO dto) {
        Stock stock = mapper.toEntity(dto);
        repository.save(stock);
        return mapper.toDto(stock);
    }
}
