package com.insurances.reports.controller;

import com.insurances.reports.domain.Aseguradora;
import com.insurances.reports.repository.AseguradoraRepository;
import com.insurances.reports.service.ReportService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api/aseguradoras")
public class AseguradoraController {

    @Autowired
    private AseguradoraRepository repository;

    @Autowired
    private ReportService service;

    @GetMapping("/getAseguradoras")
    public List<Aseguradora> getAseguradoras(){
        return repository.findAll();
    }

    @GetMapping("/reportAseguradoras/{format}")
    public String generateAseguradoraReport(@PathVariable String format) throws JRException, FileNotFoundException {
        return service.exportAseguradorReport(format);
    }


}
