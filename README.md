# :moneybag: Challenge conversor de monedas :money_with_wings:
![Badge en Desarollo](https://img.shields.io/badge/STATUS-EN%20DESAROLLO-green)
![GitHub License](https://img.shields.io/github/license/DiegoFranco16/conversor-de-monedas)
![Java](https://img.shields.io/badge/Java-17-blue?logo=java&logoColor=white)

Este repositorio se crea con el objetivo de documentar a detalle la labor de desarrollo realizada en el conversor de monedas propuesto por Alura Latam en el Challenge final de la formación Java Orientado a Objetos G7 - ONE

## Índice
- [Descripción del proyecto](#descripción-del-proyecto)
- [Acceso al proyecto](#acceso-al-proyecto)
- [Recursos utilizados](#recursos-utilizados)
- [Características de la aplicación y demostración](#características-de-la-aplicación-y-demostración)
- [Conclusión](#conclusión)

## Descripción del proyecto
El objetivo principal de este challenge es ofrecer una experiencia práctica de desarrollo de un proyecto real, simulando el trabajo cotidiano de una persona desarrolladora. Este desafío brinda la oportunidad de aplicar los conceptos aprendidos en cursos anteriores, orientados al dominio de habilidades en desarrollo en Java.

Este proyecto está diseñado para consolidar los aprendizajes adquiridos en los siguientes cursos:
- Java: creando tu primera aplicación
- Java: aplicando la Orientación a Objetos
- Java: consumir API, escribir archivos y manejar errores
- Java: trabajar con listas y colecciones de datos

En este proyecto se ha seleccionado la API "Exchange Rate API" por sus tasas de cambio en tiempo real, proporcionando datos precisos y actualizados para las conversiones de moneda. Esta API es gratuita y fácil de utilizar, asegurando un acceso confiable y eficiente a la información esencial para el desarrollo del proyecto.

## Acceso al proyecto
Para hacer uso del proyecto basta con clonar el repositorio a través del siguiente comando:
```bash
git clone https://github.com/tu_usuario/tu_repositorio.git
```

## Recursos utilizados
Para el funcionamiento de la aplicación se siguió el siguiente paso a paso, con sus respectivas herramientas:
- Repositorio del proyecto en GitHub - Por eso estás leyendo esto :)
- Configurar el entorno Java, el cuál se compone de los siguientes items:
  - Instalar Java JDK 17
  - Biblioteca Gson 2.10.1
  - IDE (Entorno de Desarrollo Integrado) IntelliJ IDEA
  - Agregar en estructura del proyecto, en el apartado módulos, el .jar de Gson 2.10.1
- Postman, para validación de respuestas de la API a utilizar
- ExchangeRate-API, disponible en https://www.exchangerate-api.com/
- Open exchange rates-API, disponible en https://openexchangerates.org/

### Obtención de clave API
Para obtener la clave de acceso, es necesario realizar un registro inicial ingresando un correo electrónico. Después de completar el registro, se enviará la clave al correo electrónico proporcionado, y estará lista para su uso.

### Comandos principales
Respecto a la ExchangeRate-API se consideran los siguientes comandos:

`GET https://v6.exchangerate-api.com/v6/YOUR-API-KEY/pair/EUR/GBP`

`GET https://v6.exchangerate-api.com/v6/YOUR-API-KEY/pair/EUR/GBP/AMOUNT`

Respecto a la Open exchange rates-API se consideran el siguientes comando:

`https://openexchangerates.org/api/latest.json?app_id=d7b6ea597a334d3cb2ccfc1969f8555e&symbols=GBP`

Respecto a las herramientas de conexión de Java, se usaron los siguientes recursos:
- [Class HttpClient](https://docs.oracle.com/en/java/javase/11/docs/api/java.net.http/java/net/http/HttpClient.html)
- [Class HttpRequest](https://docs.oracle.com/en/java/javase/11/docs/api/java.net.http/java/net/http/HttpRequest.html)
- [Interfaz HttpResponse](https://docs.oracle.com/en/java/javase/11/docs/api/java.net.http/java/net/http/HttpResponse.html)
- [Class Scanner](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Scanner.html)


## Características de la aplicación y demostración
La aplicación permite seleccionar a través del teclado una opción de un menú inicial, donde se proponen 8 conversiones de divisas y una opción de salida.
Adicionalmente, se implementó un módulo para seleccionar de forma libre las dos divisas a convertir.
Por temas didácticos, las 8 conversiones predefinidas se implementan con ExchangeRate-API, y la opción de conversión libre se implementa con Open exchange rates-API.


## Conclusión

Este proyecto resalta la importancia de herramientas esenciales en el desarrollo de aplicaciones Java orientadas a objetos, enfocándose en la implementación práctica de conocimientos adquiridos sobre consumo de API, manejo de datos y validación de respuestas. Con el uso de herramientas como Postman para pruebas de API, la biblioteca Gson para manejar datos en JSON y Java HttpClient para gestionar solicitudes HTTP, el proyecto demuestra cómo cada componente contribuye a construir una solución funcional y eficiente para la conversión de divisas en tiempo real. Estas herramientas aseguran la fiabilidad y el desempeño de la aplicación en un entorno de desarrollo robusto.



## Autores
[Diego Franco](https://www.linkedin.com/in/diego-alejandro-franco-alvarez/)

