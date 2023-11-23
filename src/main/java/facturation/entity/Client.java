package main.java.facturation.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import main.java.facturation.enums.Energie;

@Getter
@Setter
@AllArgsConstructor
public class Client {
    String referenceClient;
    Energie energie;
}
