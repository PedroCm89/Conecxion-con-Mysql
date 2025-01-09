package org.example.util.repository;

import org.example.util.DataBaseConnection;
import org.example.util.models.Categorie;
import org.example.util.models.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository  implements Repository<Product>{

    private Connection getConnection() throws SQLException {
        return DataBaseConnection.getIntace();
    }

    @Override
    public List<Product> findAll() {
        List<Product>products= new ArrayList<>();
        try(Statement stmt = getConnection().createStatement();
            ResultSet result = stmt.executeQuery("SELECT p.*, c.name as categorie FROM products " +
                    "as p inner join categories as c on (p.category_id = c.id)")) {
            while (result.next()){
                Product p = CreateProduct(result);
                products.add(p);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    @Override
    public Product forId(Long id) {
        Product product = null;

        try(PreparedStatement stm = getConnection()
                .prepareStatement("SELECT p.*, c.name as categorie FROM products as p inner join categories as c on (p.category_id = c.id) WHERE p.id =?")){
            stm.setLong(1,id);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    product = CreateProduct(rs);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return product;
    }

    @Override
    public void save(Product product) {
        String sql = null;
        if (product.getId() !=null && product.getId()>0) {
            sql = "UPDATE products SET name=?, price=?, category_id=? WHERE id=? ";
        }else{
            sql = "INSERT INTO products(name, price, category_id, date_registration) VALUES(?,?,?,?)";
        }
        try(PreparedStatement stmt= getConnection().prepareStatement(sql)) {
            stmt.setString(1, product.getName());
            stmt.setLong(2,product.getPrice());
            stmt.setLong(3, product.getCategorie().getId());

            if (product.getId() !=null && product.getId()>0) {
               stmt.setLong(4, product.getId());
            } else {
                stmt.setDate(4, new Date(product.getDateRegistration().getTime()));
            }

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Long id) {
        try(PreparedStatement stmt = getConnection().prepareStatement("DELETE FROM products WHERE id=?")){
            stmt.setLong(1,id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static Product CreateProduct(ResultSet result) throws SQLException {
        Product p = new Product(
                result.getLong("id"),
                result.getString("name"),
                result.getInt("price"),
                result.getDate("date_registration"));
        Categorie categorie = new Categorie();
            categorie.setId(result.getLong("category_id"));
            categorie.setName(result.getString("categorie"));
        p.setCategorie(categorie);
        return p;
    }
}
