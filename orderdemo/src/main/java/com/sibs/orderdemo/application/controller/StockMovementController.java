package com.sibs.orderdemo.application.controller;

import com.sibs.orderdemo.application.request.StockMovementDto;
import com.sibs.orderdemo.domain.service.StockMovementService;
import com.sibs.orderdemo.util.StockDtoConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/stock")
public class StockMovementController {

    private final StockMovementService stockMovementService;


    public StockMovementController(StockMovementService stockMovementService) {
        this.stockMovementService = stockMovementService;
    }

    @PostMapping("/create")
    public ResponseEntity<StockMovementDto> createStock(@RequestBody final StockMovementDto stockDto){
        StockMovementDto dto = StockDtoConverter.convertToDto(this.stockMovementService
                .createStock(StockDtoConverter.convertToDomain(stockDto)));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
