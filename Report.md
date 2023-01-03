# Отчёт по итогам тестирования

Отчёт о результатах автоматизированного тестированию функционала покупки тура "Путешествие дня".

## Количество тест-кейсов

Всего было проведено 9 автотестов. Общий процент успешных тестов равен 44.44%.

![image](https://user-images.githubusercontent.com/104353048/210388298-a8a57b0b-e5d3-4fe5-be22-21b8a68f923c.png)


### Результаты тестов по градации серьезности:

![image](https://user-images.githubusercontent.com/104353048/210388470-e7d03d33-f3cf-4319-beb1-1ae9696b4602.png)

### Детализация

![image](https://user-images.githubusercontent.com/104353048/210389160-948b5184-b739-4310-b378-daa16f35383c.png)

Тест на успешную покупку тура с валидными данными карты то падает, то проходит успешно, но чаще падает. 
Возможно, это связано с некоторой задержкой, с которой появляется сообщение об успешной покупке, но вычислить нужную длительность таймаута и добиться стабильности прохождения теста  так и не удалось.
![image](https://user-images.githubusercontent.com/104353048/210389709-3e5bb262-e419-47b0-9689-8096d7b589e6.png)

### Итоги:

В результате прогона тестов было составлено 6 [issue](https://github.com/Boolgakova/TripService/issues).