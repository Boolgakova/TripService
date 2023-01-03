# Дипломный проект профессии «Тестировщик»

## Документация

1. [План автоматизации](https://github.com/Boolgakova/TripService/blob/master/Plan.md)

1. [Отчётные документы по итогам тестирования](https://github.com/Boolgakova/TripService/blob/master/Report.md)

1. [Отчётные документы по итогам автоматизации]()

## Инструкция по запуску и сворачиванию приложения

### Запуск SUT
* Открыть проект в IntelliJ IDEA
* Запустить Docker Desktop
* Поднять необходимые контейнеры с помощью команды в терминале docker-compose up
* Запустить приложение командой java -jar artifacts/aqa-shopjar

### Создание отчета
* Создать отчеты и открыть их в браузере командой ./gradlew allureServe

### Сворачивание приложения
* Остановить приложение: перейти в терминал, в котором оно было запущено, и ввести CTRL + C
* Остановить контейнеры docker-compose down
