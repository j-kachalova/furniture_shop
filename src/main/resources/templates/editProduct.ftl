<#import "parts/common.ftlh" as c>
<#import "parts/loginTmp.ftlh" as l>
<#import "parts/header.ftlh" as h>
<@c.page>
    <@h.header>

    </@h.header>
    <main class="main">

        <div >
            <div class="button_admin"><a class="button" href="/admin">Назад</a></div>
            <form >
                <div class="nameProduct">Редактировать название
                    <input class="input_add" type="text" name="name" value="${product.name}"></div>
                <div class="productPage">
                    <div class="colPr">
                        <img src="/img/${product.filename}" alt="image">
                        <div>Редактировать описание</div>
                        <textarea>${product.description}</textarea>
                    </div>
                    <div class="colPr">
                        <div>Цена ${product.price}</div>
                        <input class="input_add" type="number" name="price" value="${product.price}" placeholder="Изменить цену">
                        <div>Количество на складе: ${product.amount}</div>
                        <input class="input_add" type="number" name="amount" value="${product.amount}" placeholder="Изменить количество">
                        <button class="button"> Сохранить товар</button>
                    </div>
                </div>


            </form>
        </div>
    </main>
</@c.page>