package org.example;

import org.example.util.DataBaseConnection;
import org.example.util.models.Product;
import org.example.util.repository.ProductRepository;
import org.example.util.repository.Repository;

import java.sql.Connection;
import java.sql.SQLException;

public class EjemploJdbcDelete {

    public static void main(String[] args) {


        try (Connection conn = DataBaseConnection.getIntace()) {

           Repository<Product> repo = new ProductRepository();

            System.out.println("=====================listar========================");
            repo.findAll().forEach(System.out::println);

            System.out.println("=====================obtener por id========================");
            System.out.println(repo.forId(1L).toString());

            System.out.println("=====================editar producto========================");

            repo.delete(18L);
            repo.delete(19L);

            System.out.println("producto eliminado con exito");
            repo.findAll().forEach(System.out::println);




        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

