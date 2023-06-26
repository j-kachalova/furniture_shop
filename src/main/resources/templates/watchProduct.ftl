<#import "parts/common.ftlh" as c>
<#import "parts/loginTmp.ftlh" as l>
<#import "parts/header.ftlh" as h>
<@c.page>
    <@h.header>

    </@h.header>
    <main class="main">
        <div >
            <form >
                <div class="nameProduct">${product.name}</div>
                <div class="productPage">
                    <div class="colPr img_description">
                        <img class="img_product" src="/img/${product.filename}" alt="image">
                        <div class="description">${product.description}</div>
                    </div>
                    <div class="colPr">
                        <h2>${product.price}</h2>

                        <#if product.amount!=0>
                            <div>Доступно к заказу: ${product.amount}</div>
                            <button class="button"> Избранное</button>
                            <button class="button"> Добавить в корзину</button>
                        </#if>
                        <#if product.amount==0>
                            <div>Нет в наличии</div>
                            <button class="button"> Избранное</button>
                        </#if>

                    </div>
                </div>
            </form>
        </div>
    </main>
</@c.page>