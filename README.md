---
# Apple Market App
With this app you can manage the apple bags on the biggest apple market. You can see the apple bag on the market or create and add your own apple bag to the market for sale.

---

## How to run
You can run the application by cloning it to your local and connecting to local database.
Just pull the [repository](https://github.com/akiftasci/market-app) and change the `application.yml` with your mysql database
port and credentials. Run the following commands to create a jar file.

`mvn clean install`

Under the target folder run the jar file with `java -jar *.jar` command. The application should be ready on your local host port:`8080`(if the port is not already in use).

---
## API's

To see what is sale on the Apple Market you can make a get request to `localhost:8080/`.
To create your own apple bag make a post request with the parameters amount, supplier and the price to `localhost:8080/`
---
## Author

*Akif Tasci*