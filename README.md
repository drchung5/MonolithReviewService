# MonolithReviewService

#Get all restaurants 
curl --location --request GET 'http://localhost:8080/restaurants' 

#Get a restaurant
curl --location --request GET 'http://localhost:8080/restaurants/1'

#Add a restaurant
curl --location --request POST 'http://localhost:8080/restaurants' \
--header 'Content-Type: application/json' \
--data-raw '{"name": "Sushi House", "cuisine" : {"cuisine_id":2}}'

