package com.devsuperior.dsmeta.controllers;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

    @Autowired
    private SaleService service;

    @GetMapping
    public List<Sale> findSales(){
        return service.findSales();
    }

    @GetMapping("/page")
    public Page<Sale> findSalesbyPage(Pageable pageable){
        return service.findSalesByPage(pageable);
    }

    @GetMapping("/date")
    public Page<Sale> findSalesbyDate(@RequestParam(value="mindate", defaultValue="") String minDate,
                                      @RequestParam(value="maxdate", defaultValue="") String maxDate,
                                      Pageable pageable){
        return service.findSalesByDate(minDate, maxDate,pageable);
    }


}
