# coupons-challenge
Rest API made in Java that returns list of items a person can get that doesn´t exceed the coupon maximum amount.

# Getting Started
1. Clonar el repositorio
2. Para ejecutar con maven en la carpeta del repositorio ingresar los siguientes comandos 
  `mvn complie`
  
  `mvn spring-boot:run`
  
# Endpoints
**POST /coupon/**

Body:

`{
    "items_ids": ["MLA811601010","MLA816019440","MLA810645375"],
    "amount":150000
}`

# URL api
http://ec2-52-86-159-60.compute-1.amazonaws.com:8080/coupon/
