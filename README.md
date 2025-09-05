# ThreadMastery

A Java backend project demonstrating:

- ✅ Single Threading  
- ✅ Multithreading  
- ✅ Thread Pooling  

Each mode simulates a simple client-server model. The client sends a number, and the server returns its factorial.

---

## Project Structure

ThreadMastery/
├── single_thread/
│ ├── Server.java
│ └── Client.java
├── multi_thread/
│ ├── Server.java
│ └── Client.java
├── thread_pool/
│ ├── Server.java
│ └── Client.java
├── README.md

## How to Run

For each mode (`single_thread`, `multi_thread`, `thread_pool`):

1. Navigate to the folder:
cd folder_name
Compile the code:

javac Server.java
javac Client.java
Start the server (first terminal):
java Server
Start the client (second terminal):
java Client


| Mode        | Behavior                                       |
| ----------- | ---------------------------------------------- |
| Single      | One client at a time (others wait)             |
| Multi       | Each client gets its own thread                |
| Thread Pool | Fixed thread count handles clients efficiently |


##Concepts Covered
Java Networking (ServerSocket, Socket)
Input/Output Streams (BufferedReader, PrintWriter)
Threading and Concurrency
ExecutorService & Thread Pool Management

##Purpose
Learn how threads work in different models
See how server behavior changes with each approach
Build strong Java concurrency knowledge