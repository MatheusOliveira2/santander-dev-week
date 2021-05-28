package com.projectdssdf.bootcamp.service;


import com.projectdssdf.bootcamp.exception.BusinessException;
import com.projectdssdf.bootcamp.mapper.StockMapper;
import com.projectdssdf.bootcamp.model.Stock;
import com.projectdssdf.bootcamp.model.dto.StockDTO;
import com.projectdssdf.bootcamp.repository.StockRepository;
import com.projectdssdf.bootcamp.util.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class StockService {

    @Autowired
    private StockRepository repository;

    @Autowired
    private StockMapper mapper;

    @Transactional
    public StockDTO save(StockDTO dto) {
        Optional<Stock> optionalStock = repository.findByNameAndDate(dto.getName(),dto.getDate());
        if(optionalStock.isPresent()){
            throw new BusinessException(MessageUtils.STOCK_ALREADY_EXISTS);
        }

        Stock stock = mapper.toEntity(dto);
        repository.save(stock);
        return mapper.toDto(stock);
    }
}
