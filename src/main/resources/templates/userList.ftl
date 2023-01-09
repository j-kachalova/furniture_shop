
<#import "parts/common.ftlh" as c>

<@c.page>
    <div class="block">
        <a class="button" href="/admin">Назад</a>
        <h2 style="text-align: center">Пользователи</h2>
        <table>
            <thead>
            <tr>
                <th class="edit-cell">Логин</th>
                <th class="edit-cell">ФИО</th>
                <th class="edit-cell">Роль</th>
                <th class="edit-cell"></th>
            </tr>
            </thead>
            <tbody>
            <#list users as user>
                <tr>
                    <td class="edit-cell">${user.username}</td>

                        <td class="edit-cell">
                            <#if user.surname??>
                                ${user.surname}
                            </#if>
                            <#if user.name??>
                                ${user.name}
                            </#if>
                            <#if user.patronymic??>
                                ${user.patronymic}
                            </#if>
                        </td>
                    <td class="edit-cell"><#list user.roles as role>${role}<#sep>, </#list></td>
                    <td class="edit-cell"><a class="button" href="/user/${user.id}">Редактировать</a></td>
                </tr>
            </#list>
            </tbody>
        </table>
    </div>
</@c.page>