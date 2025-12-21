# FoodDeliveryApp_JFS_K8_ArgoCd

# Food Delivery Application 

A full-stack enterprice-grade food delivery application deployed on AWS EKS. This project utilizes **Spring Boot** for backend services, **Angular** for the frontend, and is containerised using **Docker** and orchestrated using **Kubernetes**.

![Website Preview](images/website_pic1.png)

## Architecture Overview

The application is built using a microservices architecture with the following components:

### Backend (Spring Boot)
*   **Service Registry (Eureka):** Handles service discovery (Port `8761`).
*   **Restaurant Listing Service:** Manages restaurant data (Port `9091`, MySQL).
*   **Food Catalogue Service:** Manages food items and menus (Port `9092`, MySQL).
*   **User Information Service:** Handles user profiles and authentication (Port `9093`, MySQL).
*   **Order Service:** Manages order placement and processing (Port `9094`, MongoDB).

### Frontend (Angular)
*   **Food Delivery App:** A responsive web interface for users to browse restaurants and place orders.

## 🛠️ Tech Stack

*   **Frontend:** Angular, TypeScript, HTML/CSS
*   **Backend:** Java 17, Spring Boot, Spring Cloud, Spring Data JPA
*   **Databases:** MySQL (RDS), MongoDB (Atlas)
*   **DevOps & Cloud:** Docker, Kubernetes (AWS EKS), AWS Application Load Balancer, ingress, ArgoCD

