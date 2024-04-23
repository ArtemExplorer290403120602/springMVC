<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>GetAnimal</title>
    <style>
        table{
            width: 100%; border-collapse: collapse;
        }

        th, td {
            border: 1px solid black; padding: 8px; text-align: left;

        }

        th {
            background-color: lightblue; /* Цвет фона для заголовков столбцов */
            color: white; /* Цвет текста для заголовков столбцов */
        }

        td:nth-child(odd) {
            background-color: #f2f2f2; /* Цвет фона для нечетных столбцов */
        }

        td:nth-child(even) {
            background-color: #ffffff; /* Цвет фона для четных столбцов */
        }

        .animalGet{
            text-align: center;
            font-size: 45px;
            font-family: "Times New Roman", Times, serif;
        }

        body{
            background-color: lightblue;
        }

        .buttonGetAnimal{
            text-align: center;
        }

        .buttonGetAnimal button {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            margin:  0 auto;
        }

        .buttonGetAnimal button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<div class="animalGet">
    <p>This is all Animals:</p>
    <br>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Age</th>
            <th>Place</th>
            <th>Birth</th>
        </tr>
        <c:forEach items="${animals}" var="animal">
            <tr>
                <td>${animal.id}</td>
                <td>${animal.name}</td>
                <td>${animal.age}</td>
                <td>${animal.place}</td>
                <td>${animal.birth}</td>
            </tr>
        </c:forEach>
    </table>
</div>
<br>
<div class="buttonGetAnimal">
    <form action="/" method="get">
        <button type="submit">Return main</button>
    </form>
</div>
</body>
</html>
