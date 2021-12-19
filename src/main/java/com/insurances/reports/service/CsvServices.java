package com.insurances.reports.service;

import com.insurances.reports.domain.Aseguradora;
import com.insurances.reports.domain.CrrReclamantes;
import com.insurances.reports.domain.CrrReclamos;
import com.insurances.reports.repository.AseguradoraRepository;
import com.insurances.reports.repository.CrrReaclamantesRepository;
import com.insurances.reports.repository.CrrReclamosRepository;
import com.insurances.reports.utils.CSVHelper;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class CsvServices {
     @Autowired
     private AseguradoraRepository aseguradoraRepository;

     @Autowired
     private CrrReclamosRepository reclamosRepository;

     @Autowired
    private CrrReaclamantesRepository reclamantesRepository;

    public void save(MultipartFile file) {
        try {


            List<?> registers = CSVHelper.generateRecord(file.getInputStream());

            if (registers instanceof List && ((List) registers).stream()
                    .noneMatch((o -> !(o instanceof Aseguradora)))) {
                aseguradoraRepository.saveAll((List<Aseguradora>)registers);
            }else{
                if(registers instanceof List && ((List) registers).stream()
                        .noneMatch((o -> !(o instanceof CrrReclamos))))
            {
                reclamosRepository.saveAll((List<CrrReclamos>)registers);
            }else{
                    if(registers instanceof List && ((List) registers).stream()
                            .noneMatch((o -> !(o instanceof CrrReclamantes)))){
                        reclamantesRepository.saveAll((List<CrrReclamantes>)registers);
                    }
                }
            }

        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }
}
