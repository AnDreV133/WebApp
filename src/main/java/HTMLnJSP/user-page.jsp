<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Главная страница.</title>
</head>

<body>
    <form method="post" action="/WebApplication/user-page">
        <h2><%= new SQLHandler().getUserByID(request.getParameter("id")).getLogin() %>, это ваш блокнот.</h2>
        <label for="textarea">Блокнот:</label>
        <textarea name="textarea" id="textarea" cols="70" rows="80"></textarea>

        <input >
    </form>
</body>

</html>

