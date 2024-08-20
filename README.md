# Проет интернет магазина и вк бота для него


## Состоит из трех частей (модулей)

### eurikaServer (сервер эврики для взаимодействия между модулями)

* запускается первым

### webSrore (интернет магазин, работающий с mysql базой данных)

![web_store_show_1](https://github.com/user-attachments/assets/a8d371b6-dacd-44a7-b1ac-22c658eb17fe)

### vkBot (ВК бот для магазина)

![image](https://github.com/user-attachments/assets/7f0c67ed-3835-4a05-97a9-4c9425ebf9fc)

## Порядок запуска

## Магазин

1. Скачиваем mysql (https://dev.mysql.com/downloads/installer/)
2. Создаем там схему buysell
3. Проверяем
![image](https://github.com/user-attachments/assets/9e92055b-2f83-40c3-abe9-2ecce5aa2e17)

4. Вводим данные в webSrore/src/main/resources/application.properties

![image](https://github.com/user-attachments/assets/3cca5c5f-ce91-43cc-b6ae-3d2d90535bbc)

3. Запускаем модуль eurikaServer

![image](https://github.com/user-attachments/assets/8715301b-bdfc-4010-9b97-2373a002da78)


4. Запускаем модуль webSrore
   
![image](https://github.com/user-attachments/assets/c513e566-b060-47bb-af3a-b60ee1ba1ee9)


5. Заходим в браузере по адресу http://localhost:3333/

6. Щелкаем на значок наверху справа "Войти"

7.  Щелкаем по сслылке "Зарегистрируйся!"
   
8.  Вводим свои данные

9.  Используем эти данные для входа (Почта и пароль)

10. Нажимаем на значок наверху справа

![image](https://github.com/user-attachments/assets/7c639786-3355-4500-891c-ed9def27732d)

11. Нажимаем "Мои товары"

12. Нажимаем "Добавить новый товар"

13. Вводим данные (Можно даже подгрузить изображения)

14. Ваш товар добавлен и теперь на главной странице!

14.1 (Опционально) Аккаунт администратора 
![image](https://github.com/user-attachments/assets/79963db2-e1ff-4f0a-ae0f-f9109b38d587)

![image](https://github.com/user-attachments/assets/b764040b-2120-42ac-83e9-df04ba20d912)

![image](https://github.com/user-attachments/assets/8b51f92b-b2df-45bb-93c8-359178fc31f0)

15. Создаем группу в вк и заходим в настройки, затем работа с Api 

16. Переходим в следующие вкладки и копируем оттуда данные в vkBot/src/main/resources/application.yml

![image](https://github.com/user-attachments/assets/459c4b5b-6bd2-492d-b42f-66aa4c21f5ca)

![image](https://github.com/user-attachments/assets/6293bd13-b6dc-40f8-a3af-55829146f716)

