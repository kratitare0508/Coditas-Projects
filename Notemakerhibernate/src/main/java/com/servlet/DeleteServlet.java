package com.servlet;

import com.entities.Note;
import com.helper.FactoryProvider;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int noteId=Integer.parseInt(req.getParameter("note_id").trim());
        Session session= FactoryProvider.getFactory().openSession();
        Transaction tx=session.beginTransaction();
        Note note=session.get(Note.class,noteId);
        session.delete(note);
        tx.commit();
        session.close();


        resp.sendRedirect("all_notes.jsp");
    }
}
