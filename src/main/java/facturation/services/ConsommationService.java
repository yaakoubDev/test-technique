package main.java.facturation.services;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

public class ConsommationService {

    // Date du jour
    LocalDate jourJ =LocalDate.now();
    LocalDate debutMois =jourJ.withDayOfMonth(1);

    private final Map<LocalDate,Integer> conso = new LinkedHashMap<>();
    private final Map<String,Map<LocalDate,Integer>> consoClients;

    public ConsommationService(){
        consoClients = new LinkedHashMap<>();
        consoClients.put("EKW975312468",genConso());
        consoClients.put("EKW147963258",genConso());
        consoClients.put("EKW963147852",genConso());
        consoClients.put("EKW123456789",genConso());
        consoClients.put("EKW987654321",genConso());
        consoClients.put("EKW135798642",genConso());

    }

    public int rechercherConsommationClient(String ref){
        return consoClients.get(ref).values().stream().reduce(0, Integer::sum);
    }

    private Map<LocalDate, Integer> genConso(){
        LocalDate date = debutMois;
        Random rand = new Random();
        while(date.isBefore(jourJ)){
            conso.put(date,rand.nextInt(10,30));
            date=date.plusDays(1);
        }
        return conso;

    }
}
