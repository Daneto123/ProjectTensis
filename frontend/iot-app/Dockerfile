FROM node:14-alpine

WORKDIR /app

COPY public/ /iot-app/public
COPY src/ /iot-app/src
COPY package.json /iot-app/

RUN npm install

EXPOSE 3000:3000

CMD ["npm", "start"]
