# Stage 1 -- Building the Angular App
FROM node:22 AS build
WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . .
RUN npm run build

# Stage 2 -- Serve the Angular App using Nginx
FROM nginx:alpine
COPY --from=build /app/dist/food-delivery-app/browser /usr/share/nginx/html
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]