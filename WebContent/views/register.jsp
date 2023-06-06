<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>会員情報登録</title>
    
</head>
<body>
    <link rel="stylesheet" href="css/tyles.css">
    <h1>会員情報登録</h1>
    <form action="../registerServlet" method="post">
        <label for="name">名前:</label>
        <input type="text" name="name" id="name" required><br>
        
        <label for="gender">性別:</label>
        <input type="radio" name="gender" value="男" required>男性
        <input type="radio" name="gender" value="女" required>女性<br>
        
        <label for="phone">電話番号:</label>
        <input type="text" name="phone" id="phone" required><br>
        
        <label for="email">メールアドレス:</label>
        <input type="email" name="email" id="email" required><br>
        
        <label for="password">パスワード:</label>
        <input type="password" name="password" id="password" required><br>
        
        <input type="submit" value="登録">
        <input type="reset" value="リセット">
        
    </form>
    <script type="text/javascript" src='<c:url value="/js/script.js"/'></script>
</body>
</html>
