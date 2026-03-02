# 🎟 Minimalistic Lottery App Backend

## 📌 Project Overview

This is a Spring Boot backend application for a lottery system where users can:

- View 10 dynamically generated lottery tickets
- Select a ticket and register using name and mobile number
- Trigger a random lottery draw
- Calculate winnings based on predefined rules
- Store participant details in an H2 in-memory database

---

## 🛠 Technologies Used

- Java 17
- Spring Boot
- Spring Data JPA
- H2 Database
- Maven

---

## 🎯 Lottery Rules

Winnings are calculated as follows:

- 20% of jackpot for each correct number in the correct position
- 10% of jackpot for each correct number in the wrong position
- 10% of jackpot for correct letter
- 100% jackpot for perfect combination

Jackpot Value: 10,000

---

## 🚀 How to Run the Application

### 1️⃣ Clone the Repository
https://github.com/abdulazoor/lottery-backend.git

### 2️⃣ Navigate to Project Folder
cd lottery-backend

### 3️⃣ Run the Application

Using Maven:

mvn spring-boot:run

OR run directly from IDE.

---

## 📡 API Endpoints

### 🎟 Get 10 Random Tickets
http://localhost:8080/api/lottery/tickets


Returns 10 dynamically generated lottery sequences.

---

### 🎯 Play Lottery

http://localhost:8080/api/lottery/play?name=John&mobile=0771234567&selectedSequence=4%206%202%207%20U


Returns:

- Lottery ID
- Selected Sequence
- Drawn Sequence
- Percentage Won
- Amount Won

---

## 🗄 H2 Database Console

URL:
http://localhost:8080/h2-console/login.jsp?jsessionid=bea6b44fecb11124e3328a1ddd9e0f04


JDBC URL:
jdbc:h2:mem:lotterydb


---

## 📂 Project Structure

- Controller Layer
- Service Layer
- Repository Layer
- Entity Model
- H2 In-Memory Database

---
## Screenshots
<img width="1324" height="647" alt="succ" src="https://github.com/user-attachments/assets/57707192-42bb-4603-a1aa-ddfbdd0fe954" />
<img width="498" height="383" alt="tickts" src="https://github.com/user-attachments/assets/5fd598c3-dcdf-4983-969e-87f9982884df" />
<img width="1080" height="313" alt="local" src="https://github.com/user-attachments/assets/96a25786-831d-4ffd-b0d9-f369b109b383" />



## ✅ Features Implemented

- Random unique 4-digit generation
- Random letter generation
- Winning calculation logic
- Data persistence
- RESTful API endpoints

---

## 👨‍💻 Author

S.M.Abdul Azoor
