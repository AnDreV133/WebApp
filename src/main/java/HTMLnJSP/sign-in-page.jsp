<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Регистрация</title>
</head>

<body>
    <h2>Регистрация</h2>
    <form method="post" action="/WebApplication/log-in">
        <label for="username">Логин:</label>
        <input type="text" id="username" name="username" required><br><br>

        <label for="password_first">Придумайте пароль:</label>
        <input type="password" id="password_first" name="password_first" required><br><br>

        <label for="password_second">Повторите пароль:</label>
        <input type="password" id="password_second" name="password_second" required><br><br>


        <%

        %>

        <input type="submit" value="Зарегистрироваться">
    </form>
</body>

</html>

