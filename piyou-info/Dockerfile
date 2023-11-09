# Build stage
FROM node:16-alpine as build-stage

# Set the working directory
WORKDIR /app

# Copy package.json and package-lock.json (if available)
COPY package*.json ./

# Install project dependencies
RUN npm install

# Copy project files and folders to the current working directory (i.e. 'app' folder)
COPY . .

# Build the app
RUN npm run build

# Production stage
FROM nginx:stable-alpine as production-stage

# Copy the build artifacts from the build stage
COPY --from=build-stage /app/dist /usr/share/nginx/html

# Expose port 5173 to the outside once the container has launched
EXPOSE 5173

# Configure nginx to listen on the specified port and serve the app
RUN sed -i 's/listen\(.*\)80;/listen 5173;/' /etc/nginx/conf.d/default.conf

# Start nginx
CMD ["nginx", "-g", "daemon off;"]
