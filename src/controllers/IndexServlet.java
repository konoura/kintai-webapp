package controllers;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Attendance;
import utils.DBUtil;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public IndexServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();

        List<Attendance> attend = em.createNamedQuery("getAllAttend", Attendance.class).getResultList();

        em.close();

        request.setAttribute("attend", attend);
        request.setAttribute("at", new Attendance());

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/attend/index.jsp");
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            EntityManager em = DBUtil.createEntityManager();
            em.getTransaction().begin();

            Attendance att = new Attendance();

            String attend_begin = request.getParameter("attend_begin");
            att.setAttend_begin(attend_begin);

            String attend_finish = request.getParameter("attend_finish");
            att.setAttend_finish(attend_finish);

            String attend_break = request.getParameter("attend_break");
            att.setAttend_begin(attend_break);

            em.persist(att);
            em.getTransaction().commit();
            em.close();

    }

}
