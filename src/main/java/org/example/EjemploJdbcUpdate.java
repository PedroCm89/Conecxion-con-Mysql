package org.example;

import org.example.util.DataBaseConnection;
import org.example.util.models.Categorie;
import org.example.util.models.Product;
import org.example.util.repository.ProductRepository;
import org.example.util.repository.Repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class EjemploJdbcUpdate {

    public static void main(String[] args) {


        try (Connection conn = DataBaseConnection.getIntace()) {

           Repository<Product> repo = new ProductRepository();

            System.out.println("=====================listar========================");
            repo.findAll().forEach(System.out::println);

            System.out.println("=====================obtener por id========================");
            System.out.println(repo.forId(1L).toString());

            System.out.println("=====================editar producto========================");
            Product product = new Product();
            product.setId(20L);
            product.setName("dron");
            product.setPrice(700);
            Categorie categorie = new Categorie();
            categorie.setId(2L);
            product.setCategorie(categorie);
            repo.save(product);
            System.out.println(product);
            System.out.println("producto catualizado con exito");
            repo.findAll().forEach(System.out::println);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

