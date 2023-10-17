/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.sanclemen.jsonb;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

/**
 *
 * @author a22angelgp
 */
public class JSONB {

    public static void main(String[] args) {
        // Crear un objeto Java
        Persona persona = new Persona("Otto", 4, "Santiago de Compostela");

        // Crear un objeto Jsonb
        Jsonb jsonb = JsonbBuilder.create();

        // Convertir el objeto Java a JSON
        String strJson = jsonb.toJson(persona);

        // Imprimir la cadena JSON
        System.out.println("JSON Resultante (JSON-B):");
        System.out.println(strJson);
    }

    // Clase de ejemplo
    static class Persona {

        String nome;
        int idade;
        String cidade;

        public Persona(String nome, int idade, String cidade) {
            this.nome = nome;
            this.idade = idade;
            this.cidade = cidade;
        }
    }
}
