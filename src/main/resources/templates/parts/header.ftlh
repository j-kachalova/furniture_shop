<#include "../style/header.css">
<#macro header>
    <header class="header">
        <nav class="nav">
            <div class="nav-links">
                <div class="logo">
                </div>
                <a class="header__link" href="/"> Мебельный магазин </a>
                <a class="header__link" href="../personalArea"> Личный кабинет </a>
                <a class="header__link" href="../"> Избранное </a>
                <a class="header__link" href="../basket"> Корзина </a>
                <#nested>
            </div>
        </nav>
    </header>
</#macro>