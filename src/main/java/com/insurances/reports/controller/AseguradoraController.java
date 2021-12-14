package com.insurances.reports.controller;

import com.insurances.reports.domain.Aseguradora;
import com.insurances.reports.repository.AseguradoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AseguradoraController {

    @Autowired
    private AseguradoraRepository repository;

    @GetMapping("/getAseguradoras")
    public List<Aseguradora> getAseguradoras(){
        return repository.findAll();
    }
}
