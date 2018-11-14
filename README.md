Выполнил Egor Belkov    

Ссылка на проект https://github.com/anderfred/CDEKtest

При старте приложения spring boot инициализирует базу данных файлами schema.sql для создания структуры таблицы и data.sql для наполнения ее тестовыми данными, тоже самое можно сделать самому нажав кнопку "Заполнить БД тестовыми данными". Для более красивого отображения сайта был применен Bootstrap , за отрисовку таблицы отвечает DataTables плагин к jQuery. 

Тестировалось на Win10, Сервер MySql  5 на vscale ubuntu 16.

Данные для подключения к БД DB:
spring.datasource.url=jdbc:mysql://31.184.255.141/test
spring.datasource.username=fred
spring.datasource.password=19881988
