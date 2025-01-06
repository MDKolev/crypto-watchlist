# In progress

## Overview
The Crypto Watchlist Microservices Project is designed to help users monitor cryptocurrency prices, manage watchlists, and set alerts. It utilizes the CoinGecko API to fetch cryptocurrency data and provides RESTful endpoints for various functionalities. The system is composed of four main microservices:
  - Coin Service
  - Watchlist Service
  - Alert Service
  - User Service

Each service has its own database, enabling separation of concerns and scalability.

-----------------------------------------------
## Table of Contents
1. [Microservices Overview](#microservices-overview)
2. [API Endpoints](#api-endpoints)
3. [Architecture](#architecture)
-----------------------------------------------

## Microservices Overview
- Coin Service - The Coin Service fetches cryptocurrency data from the CoinGecko API and stores it in a database. This allows the application to maintain an updated list of coins, including their prices and metadata.
- Watchlist Service - The Watchlist Service allows users to create, manage, and delete watchlists for tracking cryptocurrencies. Each watchlist can include multiple coins and supports multiple fiat currencies like USD, EUR, and GBP.
- Alert Service - The Alert Service lets users set alerts for specific coins. When a coin's price reaches the user-defined threshold, the alert is triggered.
- User Service - The User service allows users to register and login in order to access their watchlists and alerts on each coin.
-----------------------------------------------
## API Endpoints
### Coin Service 
 - GET /api/coins/all: Fetches all coins from CoinGeckoAPI
 - PUT /api/coins/save: Saves all coins fetched from CoinGeckoAPI to a database
 - GET /api/coins/id: Provies data about a coin
 - GET /api/coins/id/details: Provides coin data which is required only for the watchlist

### Watchlist Service
  - POST /api/watchlists/new: Creates a new watchlist
  - GET /api/watchlists/all: Provides all watchlist of the current user
  - GET /api/watchlists/id: Provides a watchlist by id
  - DELETE /api/watchlists/id: Deletes a watchlist  by id
  - PUT /api/watchlists/id: Renames a watchlist by id
  - PUT /api/watchlists/id/coindId/add: Adds a coin to a watchlist
  - DELETE /api/watchlists/id/coinId: Deletes a coin from watchlist

### Alert Service
  - POST /api/alerts/new: Creates a new alert on a coin
  - GET /api/alerts/all: Provides all alerts of the current user
  - GET /api/alerts/coinId/all: Provides all alerts of a coin
  - GET /api/alerts/id: Provides an alert by id
  - PUT /api/alerts/id: Edits the threshold pricec of an alert
  - DELETE /api/alerts/id: Deletes an alert by id

### User Service
  - POST /api/users/register: Registers a user with email and password
  - POST /api/users/login: Authenticates the user by the provided credentials
-----------------------------------------------
## Architecture
### The project follows a microservices architecture, with each service communicating independently. Key components include:
  - Spring Boot: Framework for building each microservice.
  - MySQL: Database used by each service to persist data.
  - RestTemplate: User for synchronous internal service-to-service communication 
  - WebClient: Used to asynchronously fetch data from external API (CoinGecko) 
  - Scheduled Tasks: Used in the Alert Service to periodically check if any alerts have been triggered and in Coin Service to periodically update the prices of each coin in the database
