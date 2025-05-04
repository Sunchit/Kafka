# 📘 Apache Kafka Command Cheat Sheet
### 🚀 By [Coding Decoded](https://www.youtube.com/c/CodingDecoded) | 👨‍💻 Sunchit Dudeja

A concise guide to commonly used Kafka command-line tools for managing topics, brokers, producers, consumers, and more.

---

## 1️⃣ Kafka Topics Management

### 🔹 Create a New Topic
```bash
kafka-topics --create \
  --topic <topic-name> \
  --bootstrap-server localhost:9092 \
  --partitions <num-partitions> \
  --replication-factor <replication-factor>
```

- `--topic` → Name of the topic
- `--bootstrap-server` → Kafka broker address
- `--partitions` → Number of partitions
- `--replication-factor` → Replication factor for high availability

---

### 🔹 List All Topics
```bash
kafka-topics --list --bootstrap-server localhost:9092
```

---

### 🔹 Describe a Topic
```bash
kafka-topics --describe --topic <topic-name> --bootstrap-server localhost:9092
```

---

### 🔹 Delete a Topic
```bash
kafka-topics --delete --topic <topic-name> --bootstrap-server localhost:9092
```

> ⚠️ Ensure `delete.topic.enable=true` in Kafka config

---

## 2️⃣ Producing & Consuming Messages

### 🔹 Start a Producer
```bash
kafka-console-producer --topic <topic-name> --bootstrap-server localhost:9092
```

---

### 🔹 Start a Consumer
```bash
kafka-console-consumer \
  --topic <topic-name> \
  --bootstrap-server localhost:9092 \
  --from-beginning
```

---

## 3️⃣ Managing Consumer Groups

### 🔹 List All Consumer Groups
```bash
kafka-consumer-groups --list --bootstrap-server localhost:9092
```

### 🔹 Describe a Consumer Group
```bash
kafka-consumer-groups \
  --describe \
  --group <group-name> \
  --bootstrap-server localhost:9092
```

### 🔹 Reset Consumer Group Offset
```bash
kafka-consumer-groups \
  --reset-offsets \
  --group <group-name> \
  --topic <topic-name> \
  --to-earliest \
  --bootstrap-server localhost:9092 \
  --execute
```

---

## 4️⃣ Kafka Cluster Management

### 🔹 Check Broker API Versions
```bash
kafka-broker-api-versions --bootstrap-server localhost:9092
```

### 🔹 Describe Cluster (Broker Info)
```bash
kafka-cluster --describe --bootstrap-server localhost:9092
```

---

## 5️⃣ Admin Commands

### 🔹 Start Zookeeper
```bash
zookeeper-server-start.sh config/zookeeper.properties
```

### 🔹 Start Kafka Broker
```bash
kafka-server-start.sh config/server.properties
```

### 🔹 Stop Kafka Broker
```bash
kafka-server-stop.sh
```

### 🔹 Stop Zookeeper
```bash
zookeeper-server-stop.sh
```

---

## 6️⃣ Kafka Performance Testing

### 🔹 Test Producer Performance
```bash
kafka-producer-perf-test \
  --topic <topic-name> \
  --num-records 100000 \
  --record-size 100 \
  --throughput 1000 \
  --bootstrap-server localhost:9092
```

### 🔹 Test Consumer Performance
```bash
kafka-consumer-perf-test \
  --topic <topic-name> \
  --messages 100000 \
  --bootstrap-server localhost:9092
```

---

## 7️⃣ Debugging & Troubleshooting

### 🔹 Check Kafka-Zookeeper Connection
```bash
echo dump | nc localhost 2181
```

### 🔹 List Active Kafka Topics
```bash
kafka-topics --list --bootstrap-server localhost:9092
```

### 🔹 List Active Consumer Groups
```bash
kafka-consumer-groups --list --bootstrap-server localhost:9092
```

---

## 🚨 Final Notes

- Ensure Kafka and Zookeeper are running before using these commands.
- Replace `localhost:9092` with your actual Kafka broker address if needed.

---

Follow for more Dev content:
📺 [Coding Decoded](https://www.youtube.com/c/CodingDecoded)  
💼 [LinkedIn](https://www.linkedin.com/in/sunchitdudeja/)
📸 [Instagram](https://www.instagram.com/sunchitdudeja/)
🚀 Happy Kafka-ing!
