# MonolithReviewService

## Get all restaurants 
curl --location --request GET 'http://host:port/restaurants' 

## Get a restaurant
curl --location --request GET 'http://host:port/restaurants/1'

## Add a restaurant
curl --location --request POST 'http://host:port/restaurants' \
--header 'Content-Type: application/json' \
--data-raw '{"name": "Sushi House", "cuisine" : {"cuisine_id":2}}'

## Get all cuisines
curl --location --request GET 'http://host:port/cuisines'

## Get a cusine
curl --location --request GET 'http://host:port/cuisines/1'

## Add a cuisine
curl --location --request POST 'http://host:port/cuisines' \
--header 'Content-Type: application/json' \
--data-raw '{"cuisine_id":4, "name":"Pho"}'

## Get all reviews
curl --location --request GET 'http://host:port/reviews'

## Get a review
curl --location --request GET 'http://host:port/reviews/1'

## Add a review
curl --location --request POST 'http://host:port/reviews' \
--header 'Content-Type: application/json' \
--data-raw '{
	"review_text":"Reminds me of evenings in Barcelona. The pulpo is awesome!",
	"rating": 3, 
	"restaurant" : { "restaurant_id": 3 }
}'

## Get all reviews for a restaurant
curl --location --request GET 'http://host:port/reviews/restaurant/1'
