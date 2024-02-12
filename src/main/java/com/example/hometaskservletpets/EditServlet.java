package com.example.hometaskservletpets;

import com.example.Pets.Pet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "edit", value = "/edit")
public class EditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        int id = Integer.parseInt(request.getParameter("id"));
        Pet pet = new Pet();
        request.setAttribute("pet",pet.selectPet(id));
        getServletContext().getRequestDispatcher("/edit.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        int id =Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String breed = request.getParameter("breed");
        int age = Integer.parseInt(request.getParameter("age"));
        int price = Integer.parseInt(request.getParameter("price"));
        Pet pet = new Pet(id,name,breed,age,price);
        pet.updatePet();
        response.sendRedirect(request.getContextPath()+"/index");
    }
}
