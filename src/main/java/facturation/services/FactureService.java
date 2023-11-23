package main.java.facturation.services;

import main.java.facturation.entity.Client;
import main.java.facturation.entity.ClientParticulier;
import main.java.facturation.entity.ClientPro;
import main.java.facturation.dto.FactureDto;

import java.math.BigDecimal;

public class FactureService {

    public static FactureDto facture(Client client) {
        ConsommationService consommationService = new ConsommationService();
        int consommation = consommationService.rechercherConsommationClient(client.getReferenceClient());

        return switch (client) {
            case ClientParticulier clientParticulier ->
                    new FactureDto(clientParticulier.getReferenceClient(), consommation, calculeFacturePart(clientParticulier, consommation));
            case ClientPro clientPro ->
                    new FactureDto(clientPro.getReferenceClient(), consommation, calculeFacturePro(clientPro, consommation));

            default -> throw new IllegalStateException("Unexpected value: " + client);
        };

    }

    private static BigDecimal calculeFacturePart(ClientParticulier clientParticulier, int consommation) {
        return switch (clientParticulier.getEnergie()) {
            case ELECTRICITE -> {
                BigDecimal consommationElecPart = BigDecimal.valueOf(consommation);
                BigDecimal tarifElecPart = BigDecimal.valueOf(0.133);
                yield consommationElecPart.multiply(tarifElecPart);
            }
            case GAZ -> {
                BigDecimal consommationGazPart = BigDecimal.valueOf(consommation);
                BigDecimal tarifGazPart = BigDecimal.valueOf(0.108);
                yield consommationGazPart.multiply(tarifGazPart);
            }
        };


    }

    private static BigDecimal calculeFacturePro(ClientPro clientPro, int consommation) {

        if (clientPro.getChiffreAffaire() > 1000000) {
            return switch (clientPro.getEnergie()) {
                case ELECTRICITE ->{
                    BigDecimal consommationElecPro = BigDecimal.valueOf(consommation);
                    BigDecimal tarifElecPro = BigDecimal.valueOf(0.110);
                    yield consommationElecPro.multiply(tarifElecPro);}
                case GAZ ->{
                    BigDecimal consommationGazPro = BigDecimal.valueOf(consommation);
                    BigDecimal tarifGazPro = BigDecimal.valueOf(0.123);
                    yield consommationGazPro.multiply(tarifGazPro);}
            };
        } else {
            return switch (clientPro.getEnergie()) {
                case ELECTRICITE ->{
                    BigDecimal consommationElecProPme = BigDecimal.valueOf(consommation);
                    BigDecimal tarifElecProPme = BigDecimal.valueOf(0.112);
                    yield consommationElecProPme.multiply(tarifElecProPme);}
                case GAZ -> {
                    BigDecimal consommationGazProPme= BigDecimal.valueOf(consommation);
                    BigDecimal tarifGazProPme = BigDecimal.valueOf(0.117);
                    yield consommationGazProPme.multiply(tarifGazProPme);}
            };
        }

    }


}
