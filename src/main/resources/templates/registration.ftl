<#import "parts/common.ftlh" as c>
<#import "parts/loginTmp.ftlh" as l>

<@c.page>
    <main class="block">
        <h2>Зарегистрироваться</h2>
        <@l.loginTmp "/registration" />
    </main>
</@c.page>