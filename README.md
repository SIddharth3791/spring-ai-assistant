# Spring AI Assistant

## Overview

I have created a **React and Spring AI** project where users can:

- Ask questions to **OpenAI** and receive responses.
- Generate images using **OpenAI's image generation model**.
- Create **food recipes** based on a list of ingredients.

This project leverages **OpenAI APIs** and follows a **Microservice & Microfrontend architecture** using **Spring Boot (Spring AI)** and **React**.

## Features

- 🧠 **AI-Powered Chat**: Users can ask questions and get responses from OpenAI.
- 🎨 **Image Generation**: Users can generate images based on text prompts.
- 🍽️ **Recipe Generator**: Users can input ingredients, and the AI suggests recipes.
- 🔗 **Microservices & Microfrontend**: Uses independent services for scalability and flexibility.
- 🌟 **Custom Prompt Templates**: Uses `PromptTemplate` to format responses as required.

## Tech Stack

### Backend - Spring Boot (Spring AI)

- **Spring Boot** for backend services.
- **Spring AI** for seamless integration with OpenAI.
- **OpenAI APIs** used:
  - `ChatModel`
  - `OpenAiImageModel`
  - `OpenAiImageOptions`
  - `PromptTemplate`
- **Microservices architecture** for modular development.

### Frontend - React

- **React.js** for a dynamic UI.
- **Microfrontend Strategy** for scalable front-end modules.
- **REST API Integration** to interact with Spring Boot services.

## Usage

1. Open the React application in a browser.
2. Choose one of the AI services:
   - **Ask a Question**: Enter your query and get a response from OpenAI.
   - **Generate Image**: Provide a description, and OpenAI will create an image.
   - **Create Recipe**: Enter ingredients, and OpenAI will generate a recipe.
3. Enjoy AI-powered interactions!

## Future Enhancements

- 🔥 **User Authentication** for personalized experiences.
- 📊 **History & Logs** to track previous queries and results.
- 🎤 **Voice Input Support** for chat and commands.
---
