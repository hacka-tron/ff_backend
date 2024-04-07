# Full Featured Backend
This is a project made to explore setting up a backend with Springboot. 

## Available Features
* HTTP API 
* Caching with Redis
* Data Storage in a MySQL server
* All components encapsulated in Docker containers
* A Docker compose file for defining the cohntainers and launching the project

## Usage
The simplest way to use this project yourself: 

1. Build the springboot app using gradle. Do this by running gradle build, or using a gradle build command in your IDE `gradle build`.  

2. Install Docker and make sure Docker server is running. 
3. Run `docker compose up` in the base app directory. Simple as that! Now you should be able to make requests to the app server and play around. 