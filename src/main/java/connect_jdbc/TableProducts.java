package connect_jdbc;

import enums.Tables;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.sql.Statement;
import models.Product;

public class TableProducts {
    private Connection mysql;
    private final Tables table = Tables.productos;
    //campos
    private final String cID = "id_producto";
    private final String cName = "name";
    private final String cPrice = "price";
    private final String cQuality = "quality";
    private final String cDescription = "description";
    //querys
    private final String productbyid = "SELECT * FROM " + table + " WHERE id_producto = ?";
    private final String commentsbyproduct = "SELECT id_usuario, comment, c.quality FROM productos AS p INNER JOIN "
            + "comentarios AS c ON c.id_producto = p.id_producto WHERE p.id_producto = ?;";
    private final String products = "SELECT * FROM " + table;
    private final String createproduct = "insert into "+ table +" (name, price) value (?, ?)";
    private final String productByName = "select * from " + table + " where name = ? and price = ?";

    public TableProducts() {
        mysql = new Mysql().getConnection();
    }

    public Product createProduct(String name, float price) throws SQLException{
        PreparedStatement query = mysql.prepareStatement(createproduct);
        query.setString(1, name);
        query.setFloat(2, price);
        Product producto = null;
        if(query.executeUpdate() == 1){
            PreparedStatement query1 = mysql.prepareStatement(productByName);
            query1.setString(1, name);
            query1.setFloat(2, price);
            ResultSet data = query1.executeQuery();
            while(data.next()){
                producto = new Product(data.getInt(cID), data.getString(cName), data.getFloat(cPrice), data.getFloat(cQuality), data.getString(cDescription));
            }
        }
        return producto;
    }
    
    public List<Map<String, Object>> allProducts() throws SQLException {
        List<Map<String, Object>> products = new ArrayList<>();
        Statement query = mysql.createStatement();
        ResultSet data = query.executeQuery(this.products);
        while (data.next()) {
            Map<String, Object> product = new LinkedHashMap<>();
            product.put(cID, data.getInt(cID));
            product.put(cName, data.getString(cName));
            product.put(cPrice, data.getString(cPrice));
            product.put(cQuality, data.getString(cQuality));
            product.put(cDescription, data.getString(cDescription));
            products.add(product);
        }
        return products;
    }

    public Map<String, Object> productById(int id) throws SQLException {
        PreparedStatement query = mysql.prepareStatement(productbyid);
        query.setInt(1, id);
        ResultSet data = query.executeQuery();
        Map<String, Object> resultJson = new LinkedHashMap<>();
        while (data.next()) {
            resultJson.put(cID, data.getInt(cID));
            resultJson.put(cName, data.getString(cName));
            resultJson.put(cPrice, data.getString(cPrice));
            resultJson.put(cQuality, data.getString(cQuality));
            resultJson.put(cDescription, data.getString(cDescription));
        }
        return resultJson;
    }

    public List<Map<String, Object>> commentsByProduct(int id) throws SQLException {
        PreparedStatement query = mysql.prepareStatement(commentsbyproduct);
        query.setInt(1, id);
        ResultSet data = query.executeQuery();
        Map<String, Object> resultJson = new LinkedHashMap<>();
        List<Map<String, Object>> comments = new ArrayList<>();
        while (data.next()) {
            Map<String, Object> json = new LinkedHashMap<>();
            json.put("id_usuario", data.getInt("id_usuario"));
            json.put("comment", data.getString("comment"));
            json.put("quality", data.getString("quality"));
            comments.add(json);
        }
        resultJson.put("comments", comments);
        return comments;
    }

}
