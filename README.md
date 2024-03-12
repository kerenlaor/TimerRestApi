# TimerRestApi
creating rest api that creates a timer and return number of seconds left until termination

command to generate schema:

./gradlew openApiGenerate

command to download script to generate typescript interfaces from swagger:

1. incase this is your first time, download swagger-typescript-api, I didn't have permissions to download it so I ran the command with sudo


    npm install -g swagger-typescript-api

2. to generate typescript interfaces from swagger please run this command:


    swagger-typescript-api -p path/to/your/swagger.json -o path/to/output

now copy your Api.ts file to your angular project