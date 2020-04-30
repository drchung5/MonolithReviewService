# MonolithReviewService

## Get all restaurants 
curl --location --request GET 'http://localhost:8080/restaurants' 

## Get a restaurant
curl --location --request GET 'http://localhost:8080/restaurants/1'

## Add a restaurant
curl --location --request POST 'http://localhost:8080/restaurants' \
--header 'Content-Type: application/json' \
--data-raw '{"name": "Sushi House", "cuisine" : {"cuisine_id":2}}'

## Get all cuisines
curl --location --request GET 'http://localhost:8080/cuisines'

## Get a cusine
curl --location --request GET 'http://localhost:8080/cuisines/1'

## Add a cuisine
curl --location --request POST 'http://localhost:8080/cuisines' \
--header 'Content-Type: application/json' \
--data-raw '{"cuisine_id":4, "name":"Pho"}'

## Get all reviews
curl --location --request GET 'http://localhost:8080/reviews'

## Get a review
curl --location --request GET 'http://localhost:8080/reviews/1'

## Add a review
curl --location --request POST 'http://localhost:8080/reviews' \
--header 'Content-Type: application/json' \
--data-raw '{
	"review_text":"Reminds me of evenings in Barcelona. The pulpo is awesome!",
	"rating": 3, 
	"restaurant" : { "restaurant_id": 3 }
}'

## Get all reviews for a restaurant
curl --location --request GET 'http://localhost:8080/reviews/restaurant/1'

## Get best restaurant by category
curl --location --request GET 'localhost:8080/restaurants/best?cuisine_id=1'