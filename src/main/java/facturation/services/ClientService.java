package main.java.facturation.services;

import main.java.facturation.entity.Client;
import main.java.facturation.entity.ClientParticulier;
import main.java.facturation.entity.ClientPro;
import main.java.facturation.enums.Civilite;
import main.java.facturation.enums.Energie;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ClientService {

    private final Map<String, Client> mapClients;

    public ClientService(){

        mapClients = new LinkedHashMap<>();

        mapClients.put("EKW975312468",new ClientPro("EKW975312468", Energie.GAZ,"322 120 916 00208","Apple",10000000));
        mapClients.put("EKW147963258",new ClientPro("EKW147963258", Energie.ELECTRICITE,"65203185701473","Hp",200000));
        mapClients.put("EKW963147852",new ClientPro("EKW963147852", Energie.GAZ,"442 854 261 00041","Asus",30000000));
        mapClients.put("EKW123456789",new ClientParticulier("EKW123456789", Energie.ELECTRICITE, Civilite.HOMME,"Blue","Jack"));
        mapClients.put("EKW987654321",new ClientParticulier("EKW987654321", Energie.GAZ,Civilite.HOMME,"Noir","Adrien"));
        mapClients.put("EKW135798642",new ClientParticulier("EKW135798642", Energie.ELECTRICITE, Civilite.FEMME,"Rouge","Marinette"));

    }

    public List<Client> listClients() {return this.mapClients.values().stream().toList();}
}
