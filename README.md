<h1 align="center">:computer: Ionix | Test Java Developer :computer:</h1> 

<p align="center">Esta prueba esta hecha tal cual se pidio en el requerimiento enviado por el correo, en este readme dejare la solucion para el ultimo ejercicio el cual es teorico </p>

## Built With :technologist:

- Java 17
- Springboot 3.3.0
- Spring Security
- JPA
- ModelMapper
- Junit
- Mockito
- Memory database
- Swagger
- MVC

## PostData:

-Swagger documentation access: http://localhost:{PORT}/swagger-ui.html#/ 

 ## Links :link:
- [LinkedIn](https://www.linkedin.com/in/nelson-paulino/ "LinkedIn")


## Author :adult:

**Nelson Paulino**


EJERCICO 2

Considerar el siguiente caso:
Una aplicación debe capturar data sensible y enviarla a un servicio de
autorización. La data sensible debe ser transmitida a través de la APP API
según se indica en el siguiente diagrama, sin embargo, no puede ser legible
hasta que llegue al servicio de autorización.
Describa un método para permitir la captura y transmisión de información de
forma segura según lo planteado, sin considerar el uso de certificados SSL.

Importante: El desarrollo de este ejercicio no considera una implementación, si
no que la generación de una propuesta de solución para el escenario planteado.


RESPUESTA:

se podría realizar el cifrado y la transmisión de datos sensibles de forma segura en un entorno Java utilizando el algoritmo AES (Advanced Encryption Standard) el cual se usa para el cifrado de extremo a extremo y tambien podriamos usar  la biblioteca Apache HttpClient para la comunicación con el servicio de autorización.

Dejo el codigo de una experiencia previa que tuve hace unos meses que entiendo se ajusta a la pregunta:

public static byte[] encryptData(String datasource, String key)
        Cipher cipher = Cipher.getInstance("AES");
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), "AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        return cipher.doFinal(datasource.getBytes());

Este trozo de codigo basicamente toma una cadena de datos y una clave, luego utiliza el algoritmo de cifrado AES para cifrar la cadena de datos con la clave proporcionada luego al final retorna los datos cifrados como una matriz de bytes.

        

