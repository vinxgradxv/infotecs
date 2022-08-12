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

Инструкция по сборке проекта:

1. Склонировать репозиторий
2. Перейти перейти в /src проекта и скомпилировать .java файлы в .class файлы с байт-кодом

javac main/*.java commands/*.java data/*.java utils/*.java

3. Создать исполняемый jar файл, указав ему главный класс с помошью манифеста.

jar cfm test.jar META-INF/MANIFEST.MF main/*.class data/*.class commands/*.class utils/*.class

4. Если нужно, установить jar файлу право на исполнение.

chmod o+x test.jar

5. Исполнить jar файл

java -jar test.jar




