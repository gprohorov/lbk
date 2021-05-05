<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>Table</h1>
<table border="3" bgcolor="#f0f8ff">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>DESC</th>

    </tr>
    <#list items as item>
        <tr>
            <td>${item.id}</td>
            <td>${item.name}</td>
            <td>${item.description}</td>

        </tr>
    </#list>
</table>
</body>
</html>
