
package jp.co.aforce.servlet;

import java.io.IOException;
import java.net.URLEncoder;

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
@WebServlet("/updateServlet")
public class UpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 更新画面を表示するためのJSPに遷移
        request.getRequestDispatcher("/MemberInformation/views/update.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String name = request.getParameter("name");

            // 名前の入力値空きかどうかのエラーチェック
            if (name.isEmpty()) {
                response.sendRedirect("/MemberInformation/views/update_error.jsp");
                return;
            }

            MemberDAO memberDAO = new MemberDAO();

            // 会員情報の検索
            Member existingMember = memberDAO.searchByName(name);
            if (existingMember == null) {
                response.sendRedirect("/MemberInformation/views/update_error.jsp?message="
                        + URLEncoder.encode("指定した名前の会員情報が存在しません。", "UTF-8"));
                return;
            }

            
            // 更新値を取得
            String gender = request.getParameter("gender");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            String password = request.getParameter("password");

         // 性別の更新値の設定
            System.out.println("Gender: " + gender); // デバッグ用
            if (gender != null && !gender.isEmpty()) {
                existingMember.setGender(gender);
            }
            
            
            //電話番号が入力されたら
            if (phone != null && !phone.isEmpty()) {
                // 電話番号の桁数チェックを入れる
                if (phone.length() < 11 || phone.length() > 15) {
                    response.sendRedirect("/MemberInformation/views/update_error.jsp?message="
                            + URLEncoder.encode("電話番号は11桁以上15桁以下で入力してください。", "UTF-8"));
                    return;
                }
                existingMember.setPhone(phone);
            }
            //メールアドレスが入力されたら
            if (email != null && !email.isEmpty()) {
                // メールアドレスの重複チェックを入れる
                Member existingEmailMember = memberDAO.searchByEmail(email);
                if (existingEmailMember != null) {
                    response.sendRedirect("/MemberInformation/views/update_error.jsp?message="
                            + URLEncoder.encode("同じメールアドレスの会員情報が既に存在します。", "UTF-8"));
                    return;
                }
                existingMember.setEmail(email);
            }
            
            //パスワードが入力されたら
            if (password != null && !password.isEmpty()) {
            	
            	//パスワードがセットできるように
                existingMember.setPassword(password);
            }

            //既存のメンバー情報を更新するため、updateメソッドを呼び出し
            int line = memberDAO.update(existingMember);
            if (line > 0) {
                response.sendRedirect("/MemberInformation/views/update_success.jsp");
            } else {
                response.sendRedirect("/MemberInformation/views/update_error.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("/MemberInformation/views/update_error.jsp");
        }
    }
}
