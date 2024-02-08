# ProjectTensis

# Документация за Стрес Пате Магазин
## Добре дошли в документацията на приложението за създаване на стрес патета с използването на Spring и React.

## Стартиране на Spring Backend
### Клониране на хранилището:
> git clone https://github.com/Daneto123/ProjectTensis.git

## Влизане в директорията на проекта:
> cd backend

## Конфигуриране на базата данни:
Отворете src/main/resources/application.properties и задайте настройките за базата данни.

##Стартиране на Spring приложението: 
> ./mvnw spring-boot:run
Приложението ще бъде достъпно на http://localhost:8080.

## Стартиране на React Frontend
> cd frontend
> npm start
Приложението ще бъде достъпно на http://localhost:3000.

## API Ендпойнти
> GET /api/ducks: Връща списък с всички създадени патета.
> POST /api/newduck: Създава ново пате със зададени параметри.
> GET /api/ducks/{id}: Връща информация за конкретно пате по идентификатор.
> PUT /api/ducks/{id}: Актуализира информацията за конкретно пате по идентификатор.
> DELETE /api/ducks/{id}: Изтрива пате по идентификатор.

## Документация
> https://swagger.io/docs/

## Функционалности:

