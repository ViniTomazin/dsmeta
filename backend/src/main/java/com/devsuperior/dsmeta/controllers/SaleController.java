package com.devsuperior.dsmeta.controllers;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.services.SaleService;
import com.devsuperior.dsmeta.services.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

    @Autowired
    private SaleService service;

    @Autowired
    private SmsService smsService;

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

    @GetMapping("/{id}/notification")
    public void notifySms(@PathVariable Long id){
        smsService.sendSms(id);
    }
}
