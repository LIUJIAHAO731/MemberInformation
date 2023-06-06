<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>会員情報更新</title>
</head>
<body>
  <h2>会員情報更新</h2>
  <form action="../updateServlet" method="post">
    <label for="name">名前:</label>
    <input type="text" name="name" id="name"  required value="${member.name}"><br>
        
    <label for="gender">性別:</label>
    <input type="radio" name="gender" value="男"  ${member.gender == 'M' ? 'checked' : ''}>男性
    <input type="radio" name="gender" value="女"  ${member.gender == 'F' ? 'checked' : ''}>女性<br>
        
    <label for="phone">電話番号:</label>
    <input type="text" name="phone" id="phone"  value="${member.phone}"><br>
        
    <label for="email">メールアドレス:</label>
    <input type="email" name="email" id="email"  value="${member.email}"><br>
        
    <label for="password">パスワード:</label>
    <input type="password" name="password" id="password" ><br>
        
    <input type="submit" value="更新">
    <input type="reset" value="リセット">
  </form>
</body>
</html>