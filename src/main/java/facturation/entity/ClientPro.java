package main.java.facturation.entity;

import lombok.Getter;
import lombok.Setter;

import main.java.facturation.enums.Energie;

@Setter
@Getter
public class ClientPro extends Client {
    String siret;
    String raisonSociale;
    int chiffreAffaire;

    public ClientPro(String referenceClient, Energie energie, String siret, String raisonSociale, int chiffreAffaire) {
        super(referenceClient, energie);
        this.siret=siret;
        this.raisonSociale=raisonSociale;
        this.chiffreAffaire=chiffreAffaire;
    }
}
