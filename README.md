# car-mechanic-support-page-backend

This repository is the backend for the [front-end car-mechanic page of the same name](https://github.com/kristof01124/car-mechanic-support-page-frontend).
It's hard to say anything concrete about it so far, we only know that we will use the Java Spring framework,
have some sort of a database, and have the entire thing run in Docker.

***HOW TO USE:***
Execute the following command while in root directory:
`./mvnw spring-boot:run`

The application will start at `http://localhost:8080`. 
You can test any functions using Postman or a similar program.
`Ctrl+C` in the terminal to stop execution.

*Stay tuned for more~*

**Known bugs:**
- The database needs to be downloaded separately, and it can only handle `utf-8` encoded characters, it errors out when encountering special hungarian characters, such as "ű" and "ő"
- The database's "Orders" table contains a faulty column called "sevrity" instead of "severity". This was an oversight on part of the creator, but it can be fixed by running the following command:
`ALTER TABLE car_service.orders DROP COLUMN sevrity;`

It is currently unknown why the above faulty column escapes the Spring JPA's inconsistency detection, but fixing this will be top priority.