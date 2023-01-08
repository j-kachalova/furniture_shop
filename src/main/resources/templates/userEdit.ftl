<#import "parts/common.ftlh" as c>

<@c.page>
    <div class="block">
        <a class="button" href="/user">Назад</a>
        <h2 style="display: flex; justify-content: center">Редактировать данные пользователя</h2>
        <form class="edit" action="/user" method="post">
            <label><input class="editInput" type="text" name="username" value="${human.username}"> Логин</label>
            <label><input class="editInput" type="text" name="surname" value="${human.surname}">Фамилия</label>
            <label><input class="editInput" type="text" name="name" value="${human.name}">Имя</label>
            <label><input class="editInput" type="text" name="patronymic" value="${human.patronymic}">Отчество</label>
            <#list roles as role>
                <div>
                    <label><input type="checkbox" name="${role}" ${human.roles?seq_contains(role)?string("checked", "")}>${role}</label>
                </div>
            </#list>
            <input type="hidden" value="${human.id}" name="userId">
            <input type="hidden" value="${_csrf.token}" name="_csrf">
            <div><button class="button editInput" type="submit">Сохранить</button></div>
        </form>
    </div>


</@c.page>