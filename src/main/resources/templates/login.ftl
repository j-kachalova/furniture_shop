<#import "parts/common.ftlh" as c>
<#import "parts/loginTmp.ftlh" as l>

<@c.page>
    <main class="block">
        <h2>Вход в личный кабинет</h2>
        <@l.loginTmp "/login" />
        <a class="button" href="/registration">Зарегистрироваться</a>
    </main>
</@c.page>