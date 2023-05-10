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
import java.util.Date;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public UpdateServlet() {
        super();

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title=req.getParameter("title");
         String content=  req.getParameter("content");
         int noteId=Integer.parseInt(req.getParameter("noteId").trim());
       Session session= FactoryProvider.getFactory().openSession();
        Transaction transaction= session.beginTransaction();
        Note note=session.get(Note.class,noteId);
        note.setTitle(title);
        note.setContent(content);
        note.setAddedDate(new Date());

        transaction.commit();
        session.close();
        resp.sendRedirect("all_notes.jsp");

    }
}
