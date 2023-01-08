<#import "parts/common.ftlh" as c>
<#import "parts/loginTmp.ftlh" as l>
<#import "parts/header.ftlh" as h>
<@c.page>
    <@h.header>

    </@h.header>
    <main class="main">
        <div>
            <form method="post" action="/main" enctype="multipart/form-data">
                <label>
                    <input type="text" name="name" placeholder="Введите название" />
                </label>
                <label>
                    <input type="number" name="price" placeholder="Цена">
                </label>
                <label>
                    <input type="number" name="amount" placeholder="Количество на складе">
                </label>
                <input type="file" name="file">
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <button type="submit">Добавить</button>
            </form>
        </div>
        <div>Список сообщений</div>
        <form method="get" action="/main">
            <label>
                <input type="text" name="filter" value="${filter?ifExists}">
            </label>
            <button type="submit">Найти</button>
        </form>
        <#list products as product>
            <div class="prod">

                <span>${product.name}</span>
                <i>${product.price}</i>
                <strong>${product.amount}</strong>
                <div class="img_prod">
                    <#if product.filename??>
                        <img src="/img/${product.filename}" alt="image">
                    </#if>
                </div>
            </div>
        <#else>
            No products
        </#list>
    </main>
</@c.page>