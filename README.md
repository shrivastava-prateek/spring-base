
# Spring Base #

This project consists of spring basic handson snippets which includes:
	*scope snippets
	*transaction snippets and configuration
	*lamda methods snippets


This project uses two database nodes to test the **mutli datasource JTA commit and rollback using weblogic** and postgres
to run two different database instances you can use following small images to start containers

`docker run --name postgresql-container -p 5432:5432 -e POSTGRES_PASSWORD=postgres -d postgres:alpine --max_prepared_transactions=100

docker run --name postgresql2-container -p 5433:5432 -e POSTGRES_PASSWORD=somePassword -d postgres:alpine --max_prepared_transactions=100`