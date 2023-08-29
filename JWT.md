## JWT

https://jwt.io/introduction

Es un estándar abierto que permite transmitir información entre dos partes.

JSON Web Token

## Funcionamiento Session (HttpSession)
1. Cliente (React, Angular) envía una petición a un servidor (/api/login)
2. Servidor valida username y password, si no son validos devolverá una respuesta 401 unauthorized.
3. Servidor valida username y password, si son válidos entonces se almacena el usuario en session.
4. Se genera una cookie en el cliente.
5. En las siguientes peticiones, se comprueba que el cliente está en session, si no está en session se pide volver a logear.

Desventajas:

* La información de la session se almacena en el servidor, lo cual consume muchos recursos.

## Funcionamiento JWT

1. Cliente (React, Angular) envía una petición a un servidor (/api/login)
2. Servidor valida username y password, si no son validos devolverá una respuesta 401 unauthorized
3. Servidor valida username y password, si son válidos entonces genera un token JWT utilizando una secret key, la cual puede estar en un archivo properties por ejemplo.
4. Servidor devuelve el token JWT generado al Cliente.
5. El Cliente se guarda ese token.
6. Cliente envía peticiones a los endpoints del servidor utilizando el token JWT en las cabeceras (cabecera authorization).
7. Servidor valida el token JWT en cada peticion, y si es correcto y esta autorizado, permite el acceso a los datos.

Ventajas:

* El token se almacena en el cliente, de manera que consume menos recursos en el servidor, lo cual permite mejor escalabilidad (dar servicio a más usuarios).

Desventajas: 

* El token está en el navegador, no podríamos invalidarlo antes de la fecha de expiración asignada cuando se creó.
    * Lo que se realiza es dar la opción de logout, lo cual simplemente borra el token.

## Estructura del token JWT

3 partes separadas por un punto (.) y codificadas en base 64 cada una:

1. Header

```json
{
    "alg": "HS512",
    "typ": "JWT"
}
```

2. Payload (información, datos no sensibles del usuario, acá no iría la contraseña)

```json
{
  "name": "",
  "admin": true
}
```
3. Signatura
```
HMACKSHA256(
base64UrlEncode(header) + "." + base64UrlEncode(playload), secret
)
```

El User-Agent (Navegador, Aplicación, etc) envía el token JWT en las cabeceras:

```
Authorization: Bearer <token>
```

## Configuración Spring 

Crear un proyecto Spring Boot con:

  * Spring Security
  * Spring Web
  * SpringBoot DevTools
  * Spring Data JPA
  * PostgreSQL
  * Swagger
  * Dependencia JWT (se añade manualmente en el pom.xml)
  ```xml
     <!-- https://mvnrepository.com/artifact/io.jsonwebtoken/jjwt-api -->
    <dependency>
        <groupId>io.jsonwebtoken</groupId>
        <artifactId>jjwt-api</artifactId>
        <version>0.11.5</version>
    </dependency>
  ```