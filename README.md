# infotecs
Тестовое задание для Infotecs Academy. Реализован клиент, который общается с FTP сервером и предоставляет пользовательский интерфейс
для взаимодействия с коллекцией хранимых элементов  

Инструкция по работе с программой
При запуске программа запросит данные для подключения к FTP серверу. Если подключение прошло успешно, появится подобное меню:

1. Получение списка студентов по имени
2. Получение информации о студенте по id
3. Добавление студента ( id генерируется автоматически)
4. Удаление студента по id
5. Завершение работы

Для того, чтобы выполнить команду нужно ввести ее номер. После исполнения команд, которые изменяют список студентов, программа пытается актуализировать данные на сервере. Если это не получается, программа спрашивает у пользователя, хочет ли он попытаться подключиться к серверу еще раз или продолжить без актуализаци информации на сервере.

Id студента может быть либо натуральным числом, либо 0. Максимальное число студентов в списке - 1000000.
