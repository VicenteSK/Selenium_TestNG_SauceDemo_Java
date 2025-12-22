Selenium TestNG – SauceDemo Automation Framework
📌 Descripción

Framework de automatización de pruebas E2E para el sitio SauceDemo, desarrollado con Java, Selenium WebDriver, TestNG y Maven, aplicando Page Object Model (POM), listeners, reportes y buenas prácticas de QA Automation.

El proyecto automatiza los flujos principales del e-commerce, incluyendo Login, Productos y Checkout completo, con validaciones funcionales y reportes automáticos.

🚀 Tecnologías utilizadas

Java 21

Selenium WebDriver

TestNG

Maven

ChromeDriver

Extent Reports

Page Object Model (POM)

Git & GitHub

📂 Estructura del proyecto
Selenium_TestNG_SauceDemo_Java
│
├── pom.xml
├── testng.xml
├── .gitignore
│
├── src
│   ├── main
│   │   └── java
│   │       ├── pages
│   │       │   ├── BasePage.java
│   │       │   ├── LoginPage.java
│   │       │   ├── ProductsPage.java
│   │       │   ├── CartPage.java
│   │       │   └── CheckoutPage.java
│   │       │
│   │       └── utils
│   │           └── DriverManager.java
│   │
│   └── test
│       └── java
│           ├── listeners
│           │   └── TestListener.java
│           │
│           └── tests
│               ├── BaseTest.java
│               ├── LoginTest.java
│               ├── ProductTest.java
│               └── CheckoutTest.java
│
└── target   (ignorado por git)

🧠 Patrón de diseño

El framework utiliza Page Object Model (POM) para:

Separar lógica de negocio y tests

Facilitar mantenimiento

Mejorar legibilidad y escalabilidad

✅ Flujos automatizados
🔐 Login

Autenticación con credenciales válidas

Validación de acceso exitoso

🛒 Productos

Visualización de productos

Agregar producto al carrito

💳 Checkout completo

Login

Agregar producto al carrito

Ir al carrito

Iniciar checkout

Completar información del usuario

Finalizar compra

Validar total

Validar mensaje de confirmación

▶️ Ejecución de pruebas
Ejecutar todos los tests
mvn test

Ejecutar un test específico
mvn -Dtest=CheckoutTest test

Ejecutar suite TestNG
mvn test -DsuiteXmlFile=testng.xml

📊 Reportes

TestNG Surefire Reports (HTML)

Extent Reports (HTML)

📁 Generados automáticamente al finalizar la ejecución.

🛠️ Buenas prácticas aplicadas

Page Object Model

WebDriverWait y sincronización explícita

Listener para reportes

BaseTest reutilizable

Ejecución en modo incógnito

Código limpio y mantenible

👨‍💻 Autor

Vicente Valenzuela
QA Manual | QA Tester Automation Engineer
Selenium • TestNG • Cypress • Postman • Scrum