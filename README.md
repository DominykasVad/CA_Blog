# CodeAcademy Blog project

CodeAcademy.lt homework blog project

## Getting Started

### Prerequisites

 - Docker
 - docker-copose

### Installing

Using sample docker-compose.yaml file here or in repository

```
---
version: "3.7"
services:
  app:
    image: dominykasvad/ca_blog:latest
    container_name: ca_app
    environment:
      - APP_DATABASE_HOST=db
      - APP_DATABASE_PORT=3306
      - APP_DATABASE_NAME=ca_blog
      - APP_DATABASE_USERNAME=causer
      - APP_DATABASE_PASSWORD=capassword
      - APP_PAGE_TITLE=some title asd
      - APP_PAGE_FOOTER=some footer content
    ports:
      - 8080:8080
    depends_on:
      - db
    restart: unless-stopped # Restart policy
  db:
    image: ghcr.io/linuxserver/mariadb
    container_name: ca_mariadb
    environment:
      - PUID=1000
      - PGID=1000
      - MYSQL_ROOT_PASSWORD=carootpassword
      - TZ=Europe/Vilnius
      - MYSQL_DATABASE=ca_blog
      - MYSQL_USER=causer
      - MYSQL_PASSWORD=capassword
        volumes:
          - .database/config:/config
    restart: unless-stopped # Restart policy
```

And

```
docker-compose up -d
```

