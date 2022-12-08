package controller;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CleanDemo")
public class CleanDemo extends HttpServlet {
//    objeto de libreria Gson para json
    private Gson gson = new Gson();
        
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        seteamos la respuesta en formato json
        response.setContentType("application/json;charset=UTF-8");
        
//        creamos para tener una estructura clara
        Map<String, Object> item = new HashMap<>();
        item.put("name", "marco");
        //transformamos el objeto a un string con formato json
        String data = gson.toJson(item);
        String json = gson.toJson(item);
        //generamos la respuesta
        PrintWriter out = response.getWriter();
        out.println(json);
    }
}
