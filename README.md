### Teste-API

O ambiente criado de acordo com o readme do teste está localizado na pasta *calculo*

***A API responde os seguintes ID_da_Cidade:***

1. ***1032*** (Porto Seguro)
2. ***7110*** (Rio de Janeiro)
3. ***9626*** (São Paulo)

### Como rodar o projeto?

Se faz necessario ter o [STS Spring Tools](https://spring.io/tools) instalado na maquina em que o ambiente será clonada.
com o sts na maquina, basta importar o projeto para a IDE e RUN AS Spring Boot App

### Os conhecimentos necessarios para a construção dos micro-serviços foram:

  Conhecimento em microserviços RestApi para consumo de serviço de api's externas,
  Java 11,
  Lombok,
  RestTemplates,
  Entendimento sobre Clean Code e Refactoring,
  Manipulação de DTOs,
  Conceitos de Oriatação a objeto.
  
### Como efetuar o chamados?

Para efetuar um chamado na api é necessario ter um conhecimento minimo do [Postman API Platform](https://www.postman.com/downloads/)

### Primeiro Teste

```
http://localhost:8080/calculo_avail/7110?dataCheckIn=01-06-2022&dataCheckOut=04-06-2022&adults=2&childs=1
```

```
[
    {
        "id": 3,
        "cityName": "Rio de Janeiro",
        "rooms": [
            {
                "roomId": 0,
                "categoryName": "Standard",
                "totalPrice": 11945.87,
                "pricesDetail": {
                    "pricePerDayAdult": 3304.41,
                    "pricePerDayChild": 1753.29
                }
            },
            {
                "roomId": 1,
                "categoryName": "Luxo",
                "totalPrice": 10968.86,
                "pricesDetail": {
                    "pricePerDayAdult": 3478.95,
                    "pricePerDayChild": 720.30
                }
            },
            {
                "roomId": 2,
                "categoryName": "Triplo",
                "totalPrice": 7836.08,
                "pricesDetail": {
                    "pricePerDayAdult": 1402.65,
                    "pricePerDayChild": 2679.96
                }
            }
        ]
    },
    {
        "id": 8,
        "cityName": "Rio de Janeiro",
        "rooms": [
            {
                "roomId": 0,
                "categoryName": "Standard",
                "totalPrice": 21040.03,
                "pricesDetail": {
                    "pricePerDayAdult": 5903.37,
                    "pricePerDayChild": 2921.28
                }
            },
            {
                "roomId": 1,
                "categoryName": "Luxo",
                "totalPrice": 11354.48,
                "pricesDetail": {
                    "pricePerDayAdult": 2987.73,
                    "pricePerDayChild": 1972.68
                }
            }
        ]
    }, etc etc etc.......
```

### Segundo Teste
```
http://localhost:8080/calculo_hotel/1
```
```
{
    "id": 1,
    "cityName": "Porto Seguro",
    "rooms": [
        {
            "roomId": 0,
            "categoryName": "Standard",
            "totalPrice": 3173.07,
            "pricesDetail": {
                "pricePerDayAdult": 1372.54,
                "pricePerDayChild": 848.61
            }
        }
    ]
}
```
