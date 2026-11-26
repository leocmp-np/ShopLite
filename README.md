\# ShopLite



ShopLite is a full-stack web application for managing an e-commerce product catalog, built with Spring Boot and Angular.



The project demonstrates REST API development, database integration, frontend-backend communication and reactive programming.



\## Features



\- Product catalog visualization

\- Product creation, editing and deletion

\- Product search with debouncing

\- Category-based filtering

\- Reactive forms

\- RESTful API integration



\## Tech Stack



\### Backend

\- Java

\- Spring Boot

\- Spring Data JPA

\- Hibernate

\- MySQL

\- Maven



\### Frontend

\- Angular

\- TypeScript

\- RxJS

\- Angular Signals

\- HTML \& CSS



\## Architecture



The backend follows a layered architecture with separation of responsibilities:



\- Controller

\- Service

\- Repository

\- DTO

\- Mapper

\- Entity



The frontend uses a component-based architecture with dedicated services and models.



\## Project Structure



```text

ShopLite/

├── backend/

├── frontend/

├── .gitignore

└── README.md

```



\## Getting Started



\### Database Setup



Create a MySQL database:



```sql

CREATE DATABASE shoplite;

```



\### Backend



Configure your database credentials through environment variables:



```bash

export DB\_USERNAME=root

export DB\_PASSWORD=your\_password

```



Start the Spring Boot application:



```bash

cd backend

./mvnw spring-boot:run

```



The backend runs at `http://localhost:8080`.



\### Frontend



```bash

cd frontend

npm install

npm start

```



Open `http://localhost:4200` in your browser.



\## Project Purpose



ShopLite was developed as a learning and portfolio project to consolidate practical skills in full-stack web development using Java, Spring Boot and Angular.

