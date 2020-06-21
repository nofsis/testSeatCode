To compile and run the application :

1- Execute "mvn clean install -U" In the root of the project
2- Execute this command for run de application "mvn spring-boot:run"
3- Run this curl for test the application :

  curl --location --request POST 'http://localhost:8080/' \
  --header 'Content-Type: application/json' \
  --data-raw '{
    "upperRightPosition":"55",
    "mowers":[
       {
		  	"position": "1 2 N",
		  	"instructions": "LMLMLMLMM"
		  },
       {
			  "position": "3 3 E",
		  	"instructions": "MMRMMRMRRM"
	  	}
    ]
   }'

