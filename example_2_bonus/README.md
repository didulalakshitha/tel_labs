# example_1_bonus

Rest API to calculate the minimum price plans for given features.

## Build app from source code

```gradle clean ```

## Start the app from source code

```gradle bootRun```

Application will start in port 8080.
URL: http://localhost:8080/

## Start application with docker image

Docker image has been created and hosted in dockerhub.

Pull the image.
https://hub.docker.com/repository/docker/dlakdocker/dlak-best-plan-selector

Start the image
Ex: \
```docker run --network host --name best-plan-selector dlakdocker/dlak-best-plan-selector:1.0```

Application will start. APIs will be accessible in port 8080.\
URL: http://localhost:8080/

____

## APIs

### Get the best price plan

URL: \
http://localhost:8080/api/plans?features=email,voice,admin

Type: GET

Response:
```
{
    "price": 200,
    "plans": [
        "PLAN1",
        "PLAN3"
    ]
}
```

### Update the plans and features offered by cloud service

URL:
http://localhost:8080/api/plans

Type: POST

Request:
```
[
    {
        "plan": "PLAN1",
        "price": 100,
        "features": [
            "voice",
            "email"
        ]
    },
    {
        "plan": "PLAN2",
        "price": 150,
        "features": [
            "email",
            "database",
            "admin"
        ]
    },
    {
        "plan": "PLAN3",
        "price": 125,
        "features": [
            "voice",
            "admin"
        ]
    },
    {
        "plan": "PLAN4",
        "price": 135,
        "features": [
            "database",
            "admin"
        ]
    }
]
```

Response:
```
success
```
