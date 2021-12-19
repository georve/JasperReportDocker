package com.insurances.reports.service;

import com.insurances.reports.domain.Aseguradora;
import com.insurances.reports.repository.AseguradoraRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {

    @Autowired
    private AseguradoraRepository repository;

    public String exportAseguradorReport(String reportFormat) throws FileNotFoundException, JRException {
        List<Aseguradora> aseguradoras=repository.findAll();
        String path="/home/";
        File file= ResourceUtils.getFile("classpath:aseguradoras.jrxml");
        JasperReport jasper= JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource=new JRBeanCollectionDataSource(aseguradoras);
        Map<String,Object> map=new HashMap<>();
        map.put("createdBy","Georman Calderon");
        JasperPrint jasperPrint= JasperFillManager.fillReport(jasper,map,dataSource);
        if(reportFormat.equalsIgnoreCase("html")){
            JasperExportManager.exportReportToHtmlFile(jasperPrint,path+"aseguradora.html");
        }else{
            JasperExportManager.exportReportToPdfFile(jasperPrint,path+"aseguradora.pdf");
        }
        return "report generates in path"+path;
    }
}
