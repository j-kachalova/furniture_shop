<#import "parts/common.ftlh" as c>
<#import "parts/loginTmp.ftlh" as l>
<#import "parts/header.ftlh" as h>
<@c.page>
    <@h.header>

    </@h.header>
    <main class="main">
        <div class="block">
            <h1>Кровати</h1>
            <#list product as product>
                <div class="product_list">
                    <#list product.value as value>
                        <div class="product_block">
                            <img src="https://hoff.ru/upload/hoff_resize/hoff-images/449/864/6/4d866970f2b2f2e343194aec8e783283.jpg/1500x1000_85.webp" alt="image"/>
                            <div><a href="#">${value.name}</a></div>
                            <div><a href="#">${value.price}</a></div>
                            <div><a href="#">Доступно к заказу: ${value.amount}</a></div>
                        </div>

                    </#list>
                </div>
            </#list>
        </div>
    </main>
</@c.page>