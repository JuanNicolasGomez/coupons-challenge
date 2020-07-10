# coupons-challenge
Rest API made in Java that returns list of items a person can get that doesn´t exceed the coupon maximum amount.

# Getting Started
1. Clonar el repositorio
2. Para ejecutar con maven, en la carpeta del repositorio ingresar los siguientes comandos 

  `mvn complie`
  
  `mvn spring-boot:run`
  
 El servicio queda corriendo en el puerto 8080
 
 **Nota:** el nivel 1 del challenge se encuentra en la clase coupons-challenge/src/main/java/com/challenge/coupons/services/CouponServiceStub.java

# Endpoints
**POST /coupon/**

Body:

`{
    "items_ids": ["MLA811601010","MLA816019440","MLA810645375"],
    "amount":150000
}`
# Arquitectura

Se usa un servicio de cache con Redis para mejorar el performance, guardando como llave valor el id del item y el precio.

![alt text](https://github.com/JuanNicolasGomez/coupons-challenge/blob/master/architecture_diagram.jpg)

# URL api
http://ec2-52-86-159-60.compute-1.amazonaws.com:8080/coupon/

# Pruebas de carga
Usando 100 hilos y 1000 peticiones por hilo
Se logro un throuput promedio de 2259 peticiones por segundo

Con latencia promedio de 49 milisegundos por peticion

![alt text](https://github.com/JuanNicolasGomez/coupons-challenge/blob/master/load_test.png)
