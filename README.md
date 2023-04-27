# Company Data Microservice
This microservice provides an API to retrieve data about companies and write it to a CSV file. The data is retrieved from an external API and is then processed and written to a file.

All data is retrieved from this API : 
```
https://siret2idcc.fabrique.social.gouv.fr/api/v2/
```
There are two approaches :

- A rest controller accepts the siret codes and does invokes the logic to call the company api and store the results in a csv file.
- A kafka consumer that listens to recieve siret codes and then invokes the same logic.

## API Endpoints
The following endpoints are available:

***GET /api/v1/company/{siret}***
: Retrieve company data by SIRET ID.

**Parameters**
- siret	: string - The SIRET ID of the company
**Response**
- siret	: string - The SIRET ID of the company
- conventions : array - An array of convention objects

***POST /api/v1/company/store/csv***
: Writes company data to a CSV file.

**Request Param**
- siret : string - The SIRET ID of the company
**Response**
- If successful, the response will contain a message indicating that the CSV file was written.

## Kafka consumer
- Topic : siretcodes
- group id : siret_group
- bootstrap-servers: localhost:9092

## Configuration
The following configuration parameters are available:


- server.port : The port on which the microservice will listen
- company.data.url : The URL of the external API to retrieve data from (*conventions.csv* can be found in the root of the project ).
- kafka.bootstrap.servers : The Kafka server address.

## Docker
This microservice can be run as a Docker container. To build the Docker image, run:
```
docker build -t company-data-microservice .
```
To run the container, execute:

```
docker run -p 8080:8080 company-data-microservice
```
