<#import "parts/common.ftlh" as c>
<#import "parts/loginTmp.ftlh" as l>
<#import "parts/header.ftlh" as h>
<@c.page>
    <@h.header>

    </@h.header>
    <main class="main">
        <div class="admin">
            <form>
                <input class="input_add" type="text" name="name" placeholder="Введите название">
                <#list groups as group>
                    <label><input class="row" type="radio" name="group" value="${group.name}">${group.name}</label>
                </#list>
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <button class="button block_add" type="submit">Добавить</button>
            </form>
        </div>
    </main>
</@c.page>