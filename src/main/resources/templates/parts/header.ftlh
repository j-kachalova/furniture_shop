<#include "../style/header.css">
<#macro header>
    <header class="header">
        <nav class="nav">
            <div class="nav-links">
                <div class="logo">
                </div>
                <a class="header__link" href="/"> Мебельный магазин </a>
                <a class="header__link" href="../personalArea"> Личный кабинет </a>
                <#nested>
            </div>
        </nav>
    </header>
</#macro>