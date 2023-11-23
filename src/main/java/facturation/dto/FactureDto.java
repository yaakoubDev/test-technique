package main.java.facturation.dto;

import java.math.BigDecimal;

public record FactureDto(String referenceClient, Integer consommation, BigDecimal montant) {
}
