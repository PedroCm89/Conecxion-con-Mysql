package org.example;

import org.example.util.DataBaseConnection;
import org.example.util.models.Categorie;
import org.example.util.models.Product;
import org.example.util.repository.ProductRepository;
import org.example.util.repository.Repository;

import java.sql.*;
import java.util.Date;

public class EjemploJdbc {

    public static void main(String[] args) {


        try (Connection conn = DataBaseConnection.getIntace()) {

           Repository<Product> repo = new ProductRepository();

            System.out.println("=====================listar========================");
            repo.findAll().forEach(System.out::println);

            System.out.println("=====================obtener por id========================");
            System.out.println(repo.forId(1L).toString());

            System.out.println("=====================insertar nuevo producto========================");
            Product product = new Product();
            product.setName("Dron");
            product.setPrice(1000);
            product.setCategorie(new Categorie(2L));
            product.setDateRegistration(new Date());
            repo.save(product);
            System.out.println("producto guardado con exito");
            repo.findAll().forEach(System.out::println);







        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

