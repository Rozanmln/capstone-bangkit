# Gunakan base image yang sesuai dengan aplikasi Anda
FROM node:18.14.2 as dependencies

# Mengambil nilai dari env variable pada saat build
ARG DATABASE_URL
ARG SECRET_KEY

# Set working directory di dalam container
WORKDIR /app

# Salin package.json dan package-lock.json (jika ada) ke dalam container
COPY package*.json ./

# Install dependencies
RUN npm install
ENV DATABASE_URL $DATABASE_URL
ENV SECRET_KEY $SECRET_KEY
ENV NODE_ENV production
ENV HOST 0.0.0.0
ENV PORT 8080  
EXPOSE 8080

# Salin kode program aplikasi Anda ke dalam container
COPY . .

# Jalankan perintah untuk memulai aplikasi
CMD [ "npm", "run", "start:prod" ]