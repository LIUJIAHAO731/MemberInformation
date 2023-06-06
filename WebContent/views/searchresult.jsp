<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>検索結果</title>
</head>
<body>
  <h2>検索結果</h2>
  <table>
    <tr>
      <th>名前</th>
      <th>性別</th>
      <th>電話番号</th>
      <th>メールアドレス</th>
    </tr>
    <tr>
      <td>${member.name}</td>
      <td>${member.gender}</td>
      <td>${member.phone}</td>
      <td>${member.email}</td>
    </tr>
    
  </table>
  <p><input type="button" value="検索ページへ戻る" onclick="location.href='/MemberInformation/views/search.jsp'"</p><br>
  <p><input type="button" value="会員情報を更新" onclick="location.href='/MemberInformation/views/update.jsp'"</p>
</body>
</html>