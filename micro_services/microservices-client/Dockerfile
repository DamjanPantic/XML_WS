FROM node:alpine3.11

WORKDIR /usr/src/microservices-client 
COPY . .
RUN ["npm", "install"]
COPY . .
EXPOSE 8090
CMD [ "npm", "run", "serve"]
