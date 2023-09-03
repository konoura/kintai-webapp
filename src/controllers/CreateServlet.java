package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Attendance;
import utils.DBUtil;

/**
 * Servlet implementation class CreateServlet
 */
@WebServlet("/create")
public class CreateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public CreateServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();
        em.getTransaction().begin();
        Long attendCount = em.createNamedQuery("getAttendCount", Long.class).getSingleResult();
        List<Attendance> attList = new ArrayList<Attendance>();

        for(int i = 0; i < attendCount; i++) {
            Attendance att = new Attendance();

            String attend_begin = request.getParameter("attend_begin");
            att.setAttend_begin(attend_begin);

            String attend_finish = request.getParameter("attend_finish");
            att.setAttend_finish(attend_finish);

            String attend_break = request.getParameter("attend_break");
            att.setAttend_begin(attend_break);

            attList.add(att);
        }

        em.persist(attList);
        em.getTransaction().commit();
        em.close();

        response.sendRedirect(request.getContextPath() + "/index");
    }

}
