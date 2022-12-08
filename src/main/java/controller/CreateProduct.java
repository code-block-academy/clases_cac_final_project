package controller;

import com.google.gson.Gson;
import connect_jdbc.TableProducts;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLDataException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Product;

/**
 *
 * @author marco
 */
@WebServlet(name = "CreateProduct", urlPatterns = {"/crearProducto"})
public class CreateProduct extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String stringPrice = request.getParameter("price");
        String name = request.getParameter("name");
        float price = Float.parseFloat(stringPrice);

        TableProducts consultaProductos = new TableProducts();
        Product producto = null;
        Gson gson = new Gson();
        String respuesta = "";
        try {
            producto = consultaProductos.createProduct(name, price);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (producto != null) {
            respuesta = gson.toJson(producto.getData());
            PrintWriter out = response.getWriter();
            out.print(respuesta);
        } else {
            response.sendError(450);
        }

    }
}
