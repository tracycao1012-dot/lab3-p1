# Binary Calculator Webapp - GKE Deployment

This repository contains a Spring Boot Binary Calculator application, dockerized and deployed to Google Kubernetes Engine (GKE) via Artifact Registry.

## Deployment Steps

### 1. Clone the Repository
Clone this repository to your local machine or GCP Cloud Shell:
```bash
git clone https://github.com/tracycao1012-dot/lab3-p1.git
cd lab3-p1/BinaryCalculatorWebapp
```

### 2. Package the Application
Build the executable `.war` file using Maven (utilizing the `spring-boot-maven-plugin`):
```bash
mvn clean package
```

### 3. Build the Docker Image
Build the Docker image using the provided `Dockerfile`. Ensure you include the period `.` at the end of the command:
```bash
docker build -t us-central1-docker.pkg.dev/project-fac1ad71-1dcd-49c3-bb0/sofe3980u/binarycalculator .
```

### 4. Push to Artifact Registry
Push the generated Docker image to the GCP Artifact Registry:
```bash
docker push us-central1-docker.pkg.dev/project-fac1ad71-1dcd-49c3-bb0/sofe3980u/binarycalculator
```

### 5. Deploy to GKE
Navigate to the `deployment` directory and apply the Kubernetes YAML configurations:
```bash
cd deployment
kubectl apply -f binarycalculatorwebapp-deploy.yaml
kubectl apply -f binarycalculatorwebapp-service.yaml
```
*(Note: To restart or update a deployment after pushing a new image, run `kubectl rollout restart deployment binary-calculator-webapp-deployment`)*

### 6. Access the Application
Wait for the external IP to be assigned to the LoadBalancer service:
```bash
kubectl get service binary-calculator-webapp-service --watch
```
Once the `EXTERNAL-IP` changes from `<pending>` to a valid IP address, open your web browser and visit:
```text
http://<EXTERNAL-IP>:8080
```
