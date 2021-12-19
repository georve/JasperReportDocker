package com.insurances.reports.utils;

import com.insurances.reports.domain.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.StreamSupport;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.QuoteMode;
import org.springframework.web.multipart.MultipartFile;

public class CSVHelper {

    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String[] HEADERs = {"Aseguradora_id",
            "Nombre",
            "participa_proyecto",
            "Nombre_corto",
            "Proteccion",
            "activo"};
    static String[] HEADER_RECLAMOS = {"codaseguradora",
            "numeroreclamo",
            "fecharegistro",
            "usuarioregistro",
            "fechareclamo",
            "usuarioreclamo",
            "fechasiniestro",
            "tiposiniestro",
            "descripcion",
            "numparte",
            "numresolucion",
            "numdenuncia",
            "numoficio",
            "nombrecorredor",
            "estadosiniestro",
            "ubicacionsiniestro",
            "numeroplacapolicia",
            "foto",
            "coaseguro",
            "fecha_carga"};

    static String[] HEADER_RECLAMANTES={"codaseguradora",
            "numeroreclamo",
            "numeroreclamante",
            "fecha_reclamo",
            "monto",
            "foto",
            "descripcion",
            "observacion",
            "estadoreclamo",
            "subrogacion",
            "idaseguradorasub",
            "tipopago",
            "taller",
            "provincia",
            "inicial",
            "tomo",
            "folio",
            "asiento",
            "cedularuccorrida",
            "tipopersona",
            "primernombre",
            "segundonombre",
            "primerapellido",
            "segundoapellido",
            "apellidocasada",
            "codcliente",
            "numplaca",
            "numchasis",
            "nummotor",
            "vin",
            "cupo",
            "marca",
            "modelo",
            "anno",
            "color",
            "estilo",
            "hipoteca",
            "agenciahipotecaria",
            "perdidatotal",
            "estadoauto",
            "provinciaconductor",
            "inicialconductor",
            "tomoconductor",
            "folioconductor",
            "cedulacorridaconductor",
            "primernombreconductor",
            "segundonombreconductor",
            "primerapellidoconductor",
            "segundoapellidoconductor",
            "apellidocasadaconductor",
            "fecha_carga"
    };

    public static boolean hasCSVFormat(MultipartFile file) {
        if (TYPE.equals(file.getContentType())
                || file.getContentType().equals("application/vnd.ms-excel")) {
            return true;
        }

        return false;
    }
    public static List<?> generateRecord(InputStream is) throws IOException{
        try{
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.withHeader(HEADERs).parse(fileReader);
            if(records!=null && StreamSupport.stream(records.spliterator(), false).count()>0){
                return csvToAseguradora(is);
            }else {
                Iterable<CSVRecord> recordReclamos = CSVFormat.DEFAULT.withHeader(HEADER_RECLAMOS).parse(fileReader);
                if (recordReclamos != null && StreamSupport.stream(recordReclamos.spliterator(), false).count() > 0) {
                    return csvToReclamos(is);
                }else{
                    Iterable<CSVRecord> recordReclamantes = CSVFormat.DEFAULT.withHeader(HEADER_RECLAMANTES).parse(fileReader);
                    if (recordReclamantes != null && StreamSupport.stream(recordReclamantes.spliterator(), false).count() > 0) {
                        return csvToReclamantes(is);
                    }
                }
            }
        }catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
        return null;
    }

    public static List<Aseguradora> csvToAseguradora(InputStream is) throws IOException {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<Aseguradora> developerTutorialList = new ArrayList<>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                Aseguradora row = new Aseguradora();
                row.setId(Integer.parseInt(csvRecord.get(HEADERs[0])));
                row.setNombre(csvRecord.get(HEADERs[1]));
                row.setParticipaProyecto(Integer.parseInt(csvRecord.get(HEADERs[2])));
                row.setNombreCorto(csvRecord.get(HEADERs[3]));
                row.setProteccion(csvRecord.get(HEADERs[4]));
                row.setActivo(true);
                developerTutorialList.add(row);
            }

            return developerTutorialList;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }

    public static List<CrrReclamos> csvToReclamos(InputStream is) throws IOException {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<CrrReclamos> developerTutorialList = new ArrayList<>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                CrrReclamos row = new CrrReclamos();
                CrrReclamosPK input = new CrrReclamosPK();
                input.setCodAseguradora(Integer.parseInt(csvRecord.get(HEADER_RECLAMOS[0])));
                input.setNumeroReclamo(csvRecord.get(HEADER_RECLAMOS[1]));

                row.setReclamosPK(input);
                row.setFechaRegistro(new Date(csvRecord.get(HEADER_RECLAMOS[2])));
                row.setUsuarioRegistro(csvRecord.get(HEADER_RECLAMOS[3]));
                row.setFechaReclamo(new Date(csvRecord.get(HEADER_RECLAMOS[4])));
                row.setUsuarioReclamo(csvRecord.get(HEADER_RECLAMOS[5]));
                row.setFechaSiniestro(new Date(csvRecord.get(HEADER_RECLAMOS[6])));
                row.setTipoDeSiniestro(Integer.parseInt(csvRecord.get(HEADER_RECLAMOS[7])));
                row.setDescripcion(csvRecord.get(HEADER_RECLAMOS[8]));
                row.setNumparte(csvRecord.get(HEADER_RECLAMOS[9]));
                row.setNumResolucion(csvRecord.get(HEADER_RECLAMOS[10]));
                row.setNumDenuncia(csvRecord.get(HEADER_RECLAMOS[11]));
                row.setNumOficio(csvRecord.get(HEADER_RECLAMOS[12]));
                row.setNumbreCorredor(csvRecord.get(HEADER_RECLAMOS[13]));
                row.setEstadoSiniestro(csvRecord.get(HEADER_RECLAMOS[14]));
                row.setUbicacionSiniestro(csvRecord.get(HEADER_RECLAMOS[15]));
                row.setNumeroPlacaPolicia(csvRecord.get(HEADER_RECLAMOS[16]));
                row.setFoto(csvRecord.get(HEADER_RECLAMOS[17]));
                row.setCoaseguro(csvRecord.get(HEADER_RECLAMOS[18]));
                row.setFechaRegistro(new Date(csvRecord.get(HEADER_RECLAMOS[19])));

                developerTutorialList.add(row);
            }

            return developerTutorialList;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }

    public static List<CrrReclamantes> csvToReclamantes(InputStream is) throws IOException {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<CrrReclamantes> developerTutorialList = new ArrayList<>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                CrrReclamantes row = new CrrReclamantes();
                CrrReclamantesPK input = new CrrReclamantesPK();
                input.setCodAseguradora(Integer.parseInt(csvRecord.get(HEADER_RECLAMANTES[0])));
                input.setNumeroReclamo(csvRecord.get(HEADER_RECLAMANTES[1]));
                input.setNumeroReclamante(Integer.parseInt(csvRecord.get(HEADER_RECLAMANTES[2])));
                row.setReclamantesPK(input);
                row.setFechaReclamo(new Date(csvRecord.get(HEADER_RECLAMANTES[3])));
                row.setMonto(Double.parseDouble(csvRecord.get(HEADER_RECLAMANTES[4])));
                row.setFoto(csvRecord.get(HEADER_RECLAMANTES[5]));
                row.setDescripcion(csvRecord.get(HEADER_RECLAMANTES[6]));
                row.setObservacion(csvRecord.get(HEADER_RECLAMANTES[7]));
                row.setEstadoreclamo(csvRecord.get(HEADER_RECLAMANTES[8]));
                row.setSubrogacion(csvRecord.get(HEADER_RECLAMANTES[9]));
                row.setIdaseguradorasub(Integer.parseInt(csvRecord.get(HEADER_RECLAMANTES[10])));
                row.setTipoPago(csvRecord.get(HEADER_RECLAMANTES[11]));
                row.setTaller(csvRecord.get(HEADER_RECLAMANTES[12]));
                row.setProvincia(csvRecord.get(HEADER_RECLAMANTES[13]));
                row.setInicial(csvRecord.get(HEADER_RECLAMANTES[14]));
                row.setTomo(csvRecord.get(HEADER_RECLAMANTES[15]));
                row.setFolio(csvRecord.get(HEADER_RECLAMANTES[16]));
                row.setAsiento(csvRecord.get(HEADER_RECLAMANTES[17]));
                row.setCedularuccorrida(csvRecord.get(HEADER_RECLAMANTES[18]));
                row.setTipoPersona(csvRecord.get(HEADER_RECLAMANTES[19]));
                row.setPrimerNombre(csvRecord.get(HEADER_RECLAMANTES[20]));
                row.setSegundoNombre(csvRecord.get(HEADER_RECLAMANTES[21]));
                row.setPrimerApellido(csvRecord.get(HEADER_RECLAMANTES[22]));
                row.setSegundoApellido(csvRecord.get(HEADER_RECLAMANTES[23]));
                row.setApellidocasada(csvRecord.get(HEADER_RECLAMANTES[24]));
                row.setCodCliente(csvRecord.get(HEADER_RECLAMANTES[25]));
                row.setNumplaca(csvRecord.get(HEADER_RECLAMANTES[26]));
                row.setNumchasis(csvRecord.get(HEADER_RECLAMANTES[27]));
                row.setNummotor(csvRecord.get(HEADER_RECLAMANTES[28]));
                row.setVin(csvRecord.get(HEADER_RECLAMANTES[29]));
                row.setCupo(csvRecord.get(HEADER_RECLAMANTES[30]));
                row.setMarca(csvRecord.get(HEADER_RECLAMANTES[31]));
                row.setModelo(csvRecord.get(HEADER_RECLAMANTES[32]));
                row.setAnno(Integer.parseInt(csvRecord.get(HEADER_RECLAMANTES[33])));
                row.setColor(csvRecord.get(HEADER_RECLAMANTES[34]));
                row.setEstilo(csvRecord.get(HEADER_RECLAMANTES[35]));
                row.setHipoteca(csvRecord.get(HEADER_RECLAMANTES[36]));
                row.setAgenciahipoteca(csvRecord.get(HEADER_RECLAMANTES[37]));
                row.setPerdidatotal(csvRecord.get(HEADER_RECLAMANTES[38]));
                row.setEstadoauto(csvRecord.get(HEADER_RECLAMANTES[39]));
                row.setProvinciaConductor(csvRecord.get(HEADER_RECLAMANTES[40]));
                row.setInicialConductor(csvRecord.get(HEADER_RECLAMANTES[42]));
                row.setTomoConductor(csvRecord.get(HEADER_RECLAMANTES[42]));
                row.setFolioConductor(csvRecord.get(HEADER_RECLAMANTES[43]));
                row.setCedulacorridacondutor(csvRecord.get(HEADER_RECLAMANTES[44]));
                row.setPrimerNombreConductor(csvRecord.get(HEADER_RECLAMANTES[45]));
                row.setSegundoNombreConductor(csvRecord.get(HEADER_RECLAMANTES[46]));
                row.setPrimerApellidoConductor(csvRecord.get(HEADER_RECLAMANTES[47]));
                row.setSegundoApellidoConductor(csvRecord.get(HEADER_RECLAMANTES[48]));
                row.setApellidocasadoConductor(csvRecord.get(HEADER_RECLAMANTES[49]));
                row.setFechaCarga(new Date(csvRecord.get(HEADER_RECLAMANTES[50])));
                developerTutorialList.add(row);
            }

            return developerTutorialList;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }
}
