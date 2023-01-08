<#import "parts/common.ftlh" as c>
<#import "parts/loginTmp.ftlh" as l>
<#import "parts/header.ftlh" as h>
<@c.page>
    <@h.header>

    </@h.header>
    <main class="main">
        <div class="block">
            <h1>Каталог</h1>
            <div class="catalog">
                <div class="groups">
                    <#list tariff as tariff>
                        <h2><a href="#">${tariff.key.name}</a></h2>
                    <#else>
                    </#list>
                </div>
                <div>
                    <#list tariff as tariff>
                        <div class="category">
                            <#list tariff.value as value>
                                <div><a href="#">${value.name}</a></div>
                            </#list>
                        </div>
                    </#list>
                </div>

            </div>


        </div>
    </main>
</@c.page>