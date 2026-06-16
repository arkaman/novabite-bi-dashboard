# NovaBite Business Intelligence Dashboard

A miniature AI-enabled Business Intelligence platform built as part of the RevMind AI backend/frontend assessment.

The application provides:

* 📊 Business KPI dashboard
* 📈 Monthly revenue trend visualization
* 🤖 AI-powered conversational insights
* 🗄️ CSV data ingestion into H2 database
* 🐳 Dockerized frontend and backend

---

# Tech Stack

## Backend

* Java 21
* Spring Boot 3
* Spring Data JPA
* H2 Database
* OpenCSV
* Gemini API

## Frontend

* React
* TypeScript
* Vite
* Shadcn/UI
* React Query
* Recharts
* Axios

## Infrastructure

* Docker
* Docker Compose

---

# Project Structure

```
.
├── backend/
│   ├── src/
│   ├── Dockerfile
│   └── ...
│
├── frontend/
│   ├── src/
│   ├── Dockerfile
│   └── ...
│
├── docker-compose.yml
├── .env.example
└── README.md
```

---

# Features

## Dashboard

* Total Net Revenue KPI
* Gross Profit Margin KPI
* Top Performing Region KPI
* Monthly Net Revenue Trend Chart

## Conversational BI Assistant

Supports natural language business questions such as:

* Which region had the highest net revenue in Q1 2024?
* What is the gross profit margin for the Snacks category?
* Which sales rep closed the most units in 2025?
* Compare E-Commerce vs Modern Trade net revenue.
* What was the best performing product in the West region?

---

# Backend Architecture

```
           CSV
            │
            ▼
        CSV Seeder
            │
            ▼
        H2 Database
            │
            ▼
     Spring Data JPA
            │
            ▼
     Service Layer
            │
     ┌──────┴────────┐
     ▼               ▼
Dashboard API    Chat API
                     │
                     ▼
           Gemini LLM Integration
```

---

# REST API

## Summary

```
GET /api/summary
```

Returns:

* Total Net Revenue
* Total Units Sold
* Gross Profit Margin
* Top Region
* Top Channel
* Top Product

---

## Products

```
GET /api/products
```

Returns aggregated products with:

* Product Name
* Total Net Revenue
* Total Units Sold

---

## Trends

```
GET /api/trends
```

Returns monthly net revenue aggregation for chart rendering.

---

## Chat

```
POST /api/chat
```

Request:

```json
{
  "question": "Which region had the highest net revenue in Q1 2024?"
}
```

Response:

```json
{
  "answer": "West region had the highest net revenue in Q1 2024."
}
```

---

# Running Locally

## 1. Clone

```bash
git clone <your-repository-url>

cd novabite-dashboard
```

---

## 2. Configure Environment Variables

Create:

```
.env
```

Example:

```env
GEMINI_API_KEY=your_gemini_api_key

VITE_API_URL=http://localhost:8080/api
```

---

## 3. Backend

```
cd backend
```

Run:

```bash
./mvnw spring-boot:run
```

The application will:

* Start Spring Boot
* Initialize the H2 database
* Load and seed the provided CSV dataset

Runs on:

```
http://localhost:8080
```

---

## 4. Frontend

```
cd frontend
```

Install:

```bash
npm install
```

Run:

```bash
npm run dev
```

Runs on:

```
http://localhost:5173
```

---

# Running with Docker

Build and start:

```bash
docker compose up --build
```

Backend:

```
http://localhost:8080
```

Frontend:

```
http://localhost:5173
```

---

# LLM Used

Google Gemini (Flash)

Reasons:

* Fast response time
* Simple REST API integration
* Cost-effective
* Good performance for natural language business question answering
* Easy environment-based authentication

---

# Prompt Structure

The chat endpoint constructs a prompt containing:

* System instructions describing the assistant as a Business Intelligence analyst
* Relevant business context retrieved from the application
* The user's natural language question

Example:

```
You are a Business Intelligence assistant for NovaBite Consumer Goods.

Answer only from the supplied business context.

Business Context:
...

Question:
Which region had the highest net revenue in Q1 2024?
```

The design separates business data retrieval from natural language generation, allowing the LLM to focus on explanation rather than computation.

---

# Design Decisions

* Layered Spring Boot architecture
* DTO-based API responses
* Repository-driven aggregation queries
* React Query for asynchronous data fetching and caching
* Recharts for lightweight visualization
* Shadcn/UI for reusable components
* Dockerized services for reproducible local development
