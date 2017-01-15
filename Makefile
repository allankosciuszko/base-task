
selenium:
	docker-compose up -d selenium

clean:
	docker-compose down	

test: selenium run_test clean

run_test: 
	./gradlew firefoxTest -Dsuite=dev 

.PHONY: test
	selenium \
	test \