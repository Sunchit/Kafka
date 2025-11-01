start-all:
	@echo "Starting all Services..."
	@docker compose up --build -d

stop-all:
	@echo "Stopping all Services..."
	@docker compose down --remove-orphans

stop-publisher:
	@echo "Stopping kafka publisher service..."
	@docker compose stop kafka-publisher

restart-publisher: stop-publisher
	@echo "Rebuilding and restarting kafka publisher service..."
	@docker compose up --build -d --no-deps kafka-publisher

stop-consumer:
	@echo "Stopping kafka consumer service..."
	@docker compose stop kafka-consumer

restart-consumer: stop-consumer
	@echo "Rebuilding and restarting kafka consumer service..."
	@docker compose up --build -d --no-deps kafka-consumer

