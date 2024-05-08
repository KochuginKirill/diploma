<!DOCTYPE html>
<html lang="en">

<head>
</head>

<body>
<h1>BUYSELL </h1><hr>
<h4>Панель администратора</h4>
<table>

</table>
<#list products as product>
    <div>
        <p><b>${product.title}</b> ${product.price} | <a href="/product/${product.id}">Подробнее...</a></p>
    </div>
<#else>
    <h3>Товара нет</h3>
</#list>
<#if user.email??>
    <hr>
    <h3>Создать новый товар</h3>
    <form action="/product/create" method="post" enctype="multipart/form-data">
        Название объявления: <input type="text" name="title"><br><br>
        Описание: <input type="text" name="description"><br><br>
        Цена: <input type="text" name="price"><br><br>
        Город: <input type="text" name="city"><br><br>
        Первая фотография: <input type="file" name="file1"><br><br>
        Вторя фотография: <input type="file" name="file2"><br><br>
        Третья фотография: <input type="file" name="file3"><br><br>
        <input type="hidden", name="_csrf", value=${_csrf.token}>
        <input type="submit" value="Добавить товар">
    </form>
</#if>
</body>
</html>