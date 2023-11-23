package main.java.facturation.main;

import main.java.facturation.entity.Client;
import main.java.facturation.entity.ClientParticulier;
import main.java.facturation.entity.ClientPro;
import main.java.facturation.services.ClientService;
import main.java.facturation.services.FactureService;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        ClientService clientService = new ClientService();

        List<Client> listeClients = clientService.listClients();

        System.out.println("\nListe Clients");
        listeClients.stream().forEach(client -> {
            switch (client) {
                case ClientParticulier clientParticulier -> System.out.printf("Client PARTICULIER : Reference= %s Nom= %s Prenom= %s %n", clientParticulier.getReferenceClient(), clientParticulier.getNom(), clientParticulier.getPrenom());
                case ClientPro clientPro-> System.out.printf("Client PRO : Reference= %s Raison sociale= %s %n",clientPro.getReferenceClient(),clientPro.getRaisonSociale());
                default -> throw new IllegalStateException("Unexpected value: " + client);
            };

        });
        System.out.println("\nListe Factures");
        listeClients.stream().map(FactureService::facture).forEach(facture -> {
            System.out.printf("Reference Client: %s, Consommation: %d kWh, Facture: %.2f €  \n",facture.referenceClient(),facture.consommation(),facture.montant());
        });


    }
}
