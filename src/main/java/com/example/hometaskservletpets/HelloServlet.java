package com.example.hometaskservletpets;

import com.example.Pets.Pet;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "index", value = "/index")
public class HelloServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
       Pet pet = new Pet();
       request.setAttribute("petList",pet.selectAllPets());
       getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
    }
    public void destroy() {
    }
}