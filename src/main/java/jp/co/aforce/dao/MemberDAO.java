package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jp.co.aforce.bean.Member;

public class MemberDAO extends DAO {

	//登録機能
	public int insert(Member member) throws Exception {
		Connection con = null;
		PreparedStatement st = null;

		try {
			con = getConnection();

			st = con.prepareStatement(
					"INSERT INTO members (name, gender, p_number, email, password) VALUES (?, ?, ?, ?, ?)");
			st.setString(1, member.getName());
			st.setString(2, member.getGender());
			st.setString(3, member.getPhone());
			st.setString(4, member.getEmail());
			st.setString(5, member.getPassword());
			int line = st.executeUpdate();

			return line;
		} finally {
			// リソースの解放
			if (st != null) {
				st.close();
			}
			if (con != null) {
				con.close();
			}
		}
	}

	//名前による検索機能
	public Member searchByName(String name) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			con = getConnection();

			st = con.prepareStatement("SELECT * FROM members WHERE name = ?");
			st.setString(1, name);
			rs = st.executeQuery();

			if (rs.next()) {
				Member member = new Member();
				member.setName(rs.getString("name"));
				member.setGender(rs.getString("gender"));
				member.setPhone(rs.getString("p_number"));
				member.setEmail(rs.getString("email"));
				member.setPassword(rs.getString("password"));

				return member;
			} else {
				return null;
			}
		} finally {
			// リソースの解放
			if (rs != null) {
				rs.close();
			}
			if (st != null) {
				st.close();
			}
			if (con != null) {
				con.close();
			}
		}
	}

	// メールアドレスによる検索機能
	public Member searchByEmail(String email) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			con = getConnection();

			st = con.prepareStatement("SELECT * FROM members WHERE email = ?");
			st.setString(1, email);
			rs = st.executeQuery();

			if (rs.next()) {
				Member member = new Member();
				member.setName(rs.getString("name"));
				member.setGender(rs.getString("gender"));
				member.setPhone(rs.getString("p_number"));
				member.setEmail(rs.getString("email"));
				member.setPassword(rs.getString("password"));

				return member;
			} else {
				return null;
			}
		} finally {
			// リソースの解放
			if (rs != null) {
				rs.close();
			}
			if (st != null) {
				st.close();
			}
			if (con != null) {
				con.close();
			}
		}
	}

	//更新機能
	public int update(Member member) throws SQLException {
        Connection con = null;
        PreparedStatement st = null;
        
        try {
            con = getConnection();
            
            st = con.prepareStatement(
                    "UPDATE members SET gender = ?, p_number = ?, email = ?, password = ? WHERE name = ?");
            st.setString(1, member.getGender());
            st.setString(2, member.getPhone());
            st.setString(3, member.getEmail());
            st.setString(4, member.getPassword());
            st.setString(5, member.getName());
            
            int line = st.executeUpdate();
            
            return line;
        } finally {
            // リソースの解放
            if (st != null) {
                st.close();
            }
            if (con != null) {
                con.close();
            }
        }
        }

	// 電話番号による検索機能
	public Member searchByPhone(String phone) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			con = getConnection();

			st = con.prepareStatement("SELECT * FROM members WHERE p_number = ?");
			st.setString(1, phone);
			rs = st.executeQuery();

			if (rs.next()) {
				Member member = new Member();
				member.setName(rs.getString("name"));
				member.setGender(rs.getString("gender"));
				member.setPhone(rs.getString("p_number"));
				member.setEmail(rs.getString("email"));
				member.setPassword(rs.getString("password"));

				return member;
			} else {
				return null;
			}
		} finally {
			// リソースの解放
			if (st != null) {
				st.close();
			}
			if (con != null) {
				con.close();
			}
		}
	}
}
