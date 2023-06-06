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
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// MemberDAOを使って会員情報をデータベースに登録

		try {
			// フォームからの入力値を取得
			String name = request.getParameter("name");
			String gender = request.getParameter("gender");
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");
			String password = request.getParameter("password");

			// 電話番号の桁数チェック
			if (phone.length() < 11 || phone.length() > 15) {
				response.sendRedirect("/MemberInformation/views/error.jsp?message="
						+ URLEncoder.encode("電話番号は11桁以上15桁以下で入力してください。", "UTF-8"));
				return;
			}

			Member member = new Member();
			member.setName(name);
			member.setGender(gender);
			member.setPhone(phone);
			member.setEmail(email);
			member.setPassword(password);

			MemberDAO memberDAO = new MemberDAO();

			// メールアドレスの重複チェック
			Member existingEmailMember = memberDAO.searchByEmail(email);
			if (existingEmailMember != null) {
				response.sendRedirect("/MemberInformation/views/error.jsp?message="
						+ URLEncoder.encode("同じメールアドレスの会員情報が既に存在します。", "UTF-8"));
				return;
			}

			//電話番号の重複確認
			Member existingPhoneMember = memberDAO.searchByPhone(phone);
			if (existingPhoneMember != null) {
				response.sendRedirect("/MemberInformation/views/error.jsp?message="
						+ URLEncoder.encode("同じ電話番号の会員情報が既に存在します。", "UTF-8"));
				return;
			}

			//会員情報の重複チェック
			Member existingMember = memberDAO.searchByName(name);
			if (existingMember != null) {
				response.sendRedirect("/MemberInformation/views/error.jsp?message="
						+ URLEncoder.encode("同じ名前の会員情報が既に存在します。", "UTF-8"));
				return;
			}

			//会員情報の登録
			int line = memberDAO.insert(member);
			if (line > 0) {
				response.sendRedirect("/MemberInformation/views/success.jsp"); // 登録成功時の遷移先ページ
			} else {
				response.sendRedirect("/MemberInformation/views/error.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("/MemberInformation/views/error.jsp"); // 登録失敗時の遷移先ページ
		}
		
		// フォームの値をクリアする
		if (request.getParameter("reset") != null) {
			request.getRequestDispatcher("/register.jsp").forward(request, response);

		}
	}

}
