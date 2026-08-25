# Docker Practice Notes

## Core Concepts

- Image: reusable template used to create containers.
- Container: individual instance created from an image.
- Docker CLI: commands used to interact with Docker.
- Docker Engine: manages and runs containers.
- One image can create multiple independent containers.
- A container runs as long as its main process is running.
- Stopping a container does not delete it.

Big Idea Analogy: Image = recipe, Containers = meals made from the recipe.

## Basic Commands

```bash
docker --version       # Check Docker installation
docker info            # View Docker information

docker images          # List downloaded images

docker ps              # List running containers
docker ps -a           # List all containers

docker run <image>     # Create and run a new container
docker start <name>    # Start an existing container
docker stop <name>     # Stop a container
docker rm <name>       # Remove a container
```

Docker automatically pulls an image from Docker Hub if it is not available locally.

## Naming Containers

```bash
docker run --name my-container <image>
```

Names can be used instead of container IDs when running Docker commands.

## Interactive Containers

```bash
docker run -it ubuntu bash
```

`-it` gives an interactive terminal inside the container.

Containers have their own isolated Linux environment and filesystem. On macOS, Docker Desktop uses a **lightweight Linux VM** to support Linux containers.

## Ports

Ran an Nginx web server with:

```bash
docker run --name duy-web -p 8080:80 nginx
```

`-p` publishes a container port:

```text
-p HOST:CONTAINER
Mac localhost:8080 → container port 80 → Nginx
```

This allows access to Nginx through `localhost:8080`.

## Detached Mode

```bash
docker run -d --name duy-web -p 8080:80 nginx
```

`-d` runs container in the background instead of occupying the terminal.

View its output with:

```bash
docker logs duy-web
docker logs -f duy-web    # Follow live logs
```

## Running Commands Inside a Container

```bash
docker exec -it duy-web bash
```

This starts Bash inside an **existing running** container.

Key distinction:

```text
docker run  → create a new container
docker exec → execute something inside an existing container
```

Exiting a `docker exec` Bash session does *not* stop the container if its **main process** is still running.

## Main Takeaways

- Images are templates; containers are instances.
- Containers can be running, stopped, restarted, or removed.
- Stopped containers retain their filesystem until removed.
- Containers are isolated from the host by default.
- Ports allow services inside containers to be accessed from the host.
- Detached containers run in the background.
- `docker logs` lets inspect container output.
- `docker exec` lets execute commands inside a running container.
