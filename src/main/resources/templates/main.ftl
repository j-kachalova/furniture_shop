<#import "parts/common.ftlh" as c>
<#import "parts/loginTmp.ftlh" as l>
<#import "parts/header.ftlh" as h>
<@c.page>
    <@h.header>

    </@h.header>
    <main class="main">



        <div class="admin">



            <!-- Нормальная часть -->
            <div>
                <form method="post" action="/main" enctype="multipart/form-data">
                    <label>
                        <input class="input_add" type="text" name="name" placeholder="Введите название" />
                    </label>
                    <label>
                        <input class="input_add" type="number" name="price" placeholder="Цена">
                    </label>
                    <label>
                        <input class="input_add" type="number" name="amount" placeholder="Количество на складе">
                    </label>
                    <select name="categoryP">
                        <option disabled selected value="">Категория</option>
                        <#list categories as category>
                            <option value="${category.name}">${category.name}</option>
                        <#else>
                            No categories
                        </#list>
                    </select>
                    <input class="input_add" type="text" name="description" placeholder="Описание товара">
                    <input class="button" type="file" name="file">
                    <input type="hidden" name="_csrf" value="${_csrf.token}" />
                    <button class="button block_add" type="submit">Добавить</button>
                </form>
            </div>
            <div>Список товаров</div>
            <form method="get" action="/main">
                <label>
                    <input type="text" name="filter" value="${filter?ifExists}">
                </label>
                <button class="button" type="submit">Найти</button>
            </form>
            <div class="admin_prod">
                <#list products as product>
                    <div class="prod">
                        <div class="img_prod">
                            <#if product.filename??>
                                <img src="/img/${product.filename}" alt="image">
                            </#if>
                        </div>
                        <div class="text_prod">
                            <h3>${product.price} ₽</h3>
                            <div>${product.name}</div>
                            <div>Доступно к заказу ${product.amount}</div>
                        </div>
                        <button class="button"><a class="button" href="/main/${product.idProduct}">Редактировать </a></button>
                        <button class="button" onclick="popUpOpen()"> Удалить </button>

                        <!--Всплывающее окно -->
                        <div class="popUpPage_off">
                            <div class="popUpWin">
                                <div class="popUpQuestion">Вы уверены, что хотите удалить товар?</div>
                                <div class="popUpButtons">
                                    <a class="button b_answ" href="/main/delete/${product.idProduct}">Да</a>
                                    <button class="button b_answ" onclick="popUpClose()">Нет</button>
                                </div>
                            </div>

                        </div>



                    </div>
                <#else>
                    No products
                </#list>
            </div>

        </div>
    </main>
    <script>
        function popUpOpen() {
            document.getElementsByClassName("popUpPage_off")[0].setAttribute("class", "popUpPage_on");
        }
        function popUpClose(){
            document.getElementsByClassName("popUpPage_on")[0].setAttribute("class", "popUpPage_off");
        }
    </script>
</@c.page>