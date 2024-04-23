<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Failed</title>
    <style>
        body{
            background-color: lightblue;
        }
        .TextEmpty{
            text-align: center;
            font-size: 45px;
            font-family: "Times New Roman", Times, serif;
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
<div class="TextEmpty">
    <p>Nothing :)</p>
</div>
<br>
<div class="buttonGetAnimal">
    <form action="/" method="get">
        <button type="submit">Return main</button>
    </form>
</div>
</body>
</html>
