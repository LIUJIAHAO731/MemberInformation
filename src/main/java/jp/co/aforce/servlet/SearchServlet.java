package jp.co.aforce.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.bean.Member;
import jp.co.aforce.dao.MemberDAO;

/**
 * Servlet implementation class SearchServlet
 */

@WebServlet("/searchServlet")
public class SearchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String name = request.getParameter("name");

            MemberDAO memberDAO = new MemberDAO();

            Member member = memberDAO.searchByName(name);
            
            
            if (member != null) {
                request.setAttribute("member", member);
                request.getRequestDispatcher("/views/searchresult.jsp").forward(request, response);
            } else {
                String message = "該当する会員が見つかりませんでした。";
                request.setAttribute("message", message);
                request.getRequestDispatcher("/views/search.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("/views/searcherror.jsp");
        }
    }
}