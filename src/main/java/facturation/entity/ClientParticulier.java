package main.java.facturation.entity;

import lombok.Getter;
import lombok.Setter;

import main.java.facturation.enums.Civilite;
import main.java.facturation.enums.Energie;

@Getter
@Setter
public class ClientParticulier extends Client {
    String nom;
    String prenom;
    Civilite civilite;

    public ClientParticulier(String referenceClient, Energie energie, Civilite civilite, String nom, String prenom) {
        super(referenceClient, energie);
        this.nom=nom;
        this.prenom=prenom;
        this.civilite=civilite;
    }
}
