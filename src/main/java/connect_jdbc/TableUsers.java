package connect_jdbc;

import enums.Tables;
import java.sql.*;
import java.util.LinkedHashMap;
import java.util.Map;
import models.User;

public class TableUsers {

    private Connection mysql;
    private final Tables table = Tables.USUARIOS;
    //campos
    private final String cID = "id_usuario";
    private final String cName = "name";
    private final String cSurname = "surname";
    private final String cEmail = "email";
    private final String cPassword = "password";
    private final String cRol = "rol";
    //querys
    private final String createuser = "INSERT INTO " + table + "(name, surname, email, password) VALUES (?, ?, ?, ?)";
    private final String login = "SELECT * FROM " + table +" where " + cEmail + "= ? and "+ cPassword +" = ?";

    public TableUsers() {
        mysql = new Mysql().getConnection();
    }

    public Map<String, Object> createUser(String name, String surname, String email, String password) throws SQLException {
        Map<String, Object> result = new LinkedHashMap<>();
        PreparedStatement query = mysql.prepareStatement(createuser);
        query.setString(1, name);
        query.setString(2, surname);
        query.setString(3, email);
        query.setString(4, password);
        if(query.executeUpdate() == 1){
            result.put("mensaje", "user create");
        }
        return result;
    }
    
    public User getUserLogin(String email, String password) throws SQLException{
        PreparedStatement query = mysql.prepareStatement(login);
        query.setString(1, email);
        query.setString(2, password);
        User usuario = null;
        ResultSet data = query.executeQuery();
        while(data.next()){
            usuario = new User(data.getInt(cID), data.getString(cName), data.getString(cSurname), data.getString(cEmail), data.getString(cPassword), data.getString(cRol));
        }
        return usuario;
    }
}
