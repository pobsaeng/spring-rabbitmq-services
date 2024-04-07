# Start applications locally

#### 1. Run Docker Compose:
```dockerfile
docker-compose -f docker-compose-rabbitmq.yml up -d
```
#### 2. Run `start_app1.sh` located in the spring-rabbitmq-h2 folder to start app1.

#### 3. Run `start_app2.sh` located in the spring-spring-receiver folder to start app2.

#### Grant execute permission to the owner of the file with this command:
```dockerfile
chmod +x start_app1.sh
chmod +x start_app2.sh
```

## Curl Commands
#### Create
```dockerfile
curl -X POST \
  http://localhost:8080/products \
  -H 'Content-Type: application/json' \
  -d '{
    "name": "Smartphone",
    "description": "High-end smartphone with advanced features",
    "price": 899.99,
    "currency": "USD",
    "quantity": 100,
    "category": "Electronics",
    "brand": "Samsung",
    "color": "Black",
    "size": "Large",
    "weight": 0.2,
    "length": 5.5,
    "width": 2.8,
    "height": 0.3,
    "imageUrls": "https://example.com/image1.jpg",
    "tags": "smartphone"
}'
```

#### Update
```dockerfile
curl -X PUT \
  http://localhost:8080/products/1 \
  -H 'Content-Type: application/json' \
  -d '{
    "name": "Updated Smartphone",
    "description": "Updated description of the smartphone",
    "price": 999.99,
    "currency": "USD",
    "quantity": 150,
    "category": "Electronics",
    "brand": "Updated Brand",
    "color": "White",
    "size": "Small",
    "weight": 0.3,
    "length": 6.0,
    "width": 3.0,
    "height": 0.4,
    "imageUrls": "https://example.com/image2.jpg",
    "tags": "iPhon 14"
}'
```

# Start applications with Docker Compose
#### 1. Run Docker Compose:
```dockerfile
docker-compose up -d
```

## Curl Commands
#### Create
```dockerfile
curl -X POST \
  http://localhost/products \
  -H 'Content-Type: application/json' \
  -d '{
    "name": "Smartphone",
    "description": "High-end smartphone with advanced features",
    "price": 899.99,
    "currency": "USD",
    "quantity": 100,
    "category": "Electronics",
    "brand": "Samsung",
    "color": "Black",
    "size": "Large",
    "weight": 0.2,
    "length": 5.5,
    "width": 2.8,
    "height": 0.3,
    "imageUrls": "https://example.com/image1.jpg",
    "tags": "smartphone"
}'
```

#### Update
```
curl -X PUT \
  http://localhost/products/1 \
  -H 'Content-Type: application/json' \
  -d '{
    "name": "Updated Smartphone",
    "description": "Updated description of the smartphone",
    "price": 999.99,
    "currency": "USD",
    "quantity": 150,
    "category": "Electronics",
    "brand": "Updated Brand",
    "color": "White",
    "size": "Small",
    "weight": 0.3,
    "length": 6.0,
    "width": 3.0,
    "height": 0.4,
    "imageUrls": "https://example.com/image2.jpg",
    "tags": "iPhon 14"
}'
```
