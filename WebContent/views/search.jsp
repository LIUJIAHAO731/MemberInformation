<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>会員情報検索</title>
</head>
<body>
  <h1>会員情報検索</h1>
  <form action="../searchServlet" method="post">
    <label for="name">名前:</label>
    <input type="text" name="name" id="name" required><br>
    <input type="submit" value="検索">
  </form>
</body>
</html>