<#import "parts/common.ftlh" as c>
<#import "parts/loginTmp.ftlh" as l>
<#import "parts/header.ftlh" as h>
<@c.page>
    <@h.header>

    </@h.header>
    <main class="main">
        <div class="block">
            <div class="button_admin"><a class="button" href="/user">Пользователи</a></div>
            <div class="button_admin"><a class="button" href="/main">Товары</a></div>
            <div class="button_admin"><a class="button" href="/editCategory">Категории</a></div>
        </div>
    </main>
</@c.page>