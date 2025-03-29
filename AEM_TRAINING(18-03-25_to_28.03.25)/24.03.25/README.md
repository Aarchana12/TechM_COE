# News Component Implementation - AEM

## Table of Contents
- [Overview](#overview)
- [Steps](#steps)
  - [1. Create 5 News Article Pages](#1-create-5-news-article-pages)
  - [2. Use News Component](#2-use-news-component)
  - [3. Create Header Experience Fragment](#3-create-header-experience-fragment)
  - [4. Create Footer Experience Fragment](#4-create-footer-experience-fragment)
  - [5. Create Custom Service](#5-create-custom-service)
  - [6. Create Custom Configuration](#6-create-custom-configuration)

---

## Overview
This README provides a structured guide to implementing a news-based feature in AEM, including content pages, experience fragments, a custom service, and configurations for third-party API integration.

---

## Steps

### 1. Create 5 News Article Pages
- Navigate to **/content/us/en/news** in AEM.
- Create 5 unique news article pages.
- Ensure each page has a distinct title and content.

### 2. Use News Component
- Add the previously created **News Component** to each news page.
- The component should display:
  - **Title** (`<h2>`) in green.
  - **News Detail** (`<p>`) in yellow.
  - **Published Date** in black.

### 3. Create Header Experience Fragment
- Create a **Header Experience Fragment**.
- Include a navigation menu with:
  - **News Menu** (linked to news pages)
  - **Contact Us** page
  - **About Me** page

### 4. Create Footer Experience Fragment
- Create a **Footer Experience Fragment** with 4 sections:
  1. **News Menu Section**: Use a **List Component** to display 4 news articles.
  2. **About Me Section**: Use a **Text Component** to add content about the journalist.
  3. **Contact Us Section**: Use a **Text Component** with contact details (mobile number, email, office address).
  4. **Social Media Section**: Use a **List Component** to link social media accounts.

### 5. Create Custom Service
- Implement a **custom service** that prints `Hello World`.
- Call this service from the **News Component's Sling Model**.
- Log the output in AEM logs.

### 6. Create Custom Configuration
- Develop a **custom configuration** to store a third-party API URL (e.g., `https://jsonplaceholder.typicode.com/posts`).
- Retrieve JSON data from the API.
- Print the JSON response in AEM logs.

---

