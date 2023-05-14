# Deutsche Bank Exercise
Process a signal

Access [Swagger Link]( http://localhost:8080/swagger-ui/index.html) for getting altogether glimpse at api, request and responses

Two ways to run as follows:

1) Run `TradingApplication.java` directly

    or

2) **Using Docker**

* Run ``` mvn clean package ```
* Run ``` docker-compose up ```

Then access the api via:

  **POST**: [/api/db/signal](http://localhost:8080/api/db/signal)

HEADER: ```db_auth``` = ```db_secret```
```
Body: 
{
"signal": 1,
"param1": 10,
"param2": 20
}
 ```

Also be executed by importing this curl:

curl --location 'http://localhost:8080/api/db/signal' \
--header 'db-Auth: db_secret' \
--header 'Content-Type: application/json' \
--data '{

"signal": 1,
"param1": 10,
"param2": 20
}'

