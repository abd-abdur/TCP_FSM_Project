# TCP Finite State Machine (FSM) Project

## Author
- **Student ID:** `ar7165`

## Main Class
- `main.TcpFsmMain`

## Description
This project implements a TCP finite state machine (FSM) to simulate the TCP protocol's connection states and transitions. The FSM is implemented as a Mealy machine, generating outputs upon each transition based on input events.

## Usage Instructions

### 1. Compile

The JAR file `ar7165.jar` contains only the source files for this project. If you wish to recompile the project, use the following command:

```bash
javac -d bin src/fsm/*.java src/states/*.java src/events/*.java src/actions/*.java src/main/*.java


### 2. Run the Program

Run the Program: To run the program, navigate to the directory containing the compiled classes and execute:

```bash
java -cp bin main.TcpFsmMain

3. Input Events: Enter events as strings in uppercase, matching the following list:

PASSIVE_OPEN, ACTIVE_OPEN, SYN, SYN_ACK, ACK, FIN, FIN_ACK, CLOSE, RDATA, SDATA

Each event triggers a state transition if applicable. For invalid events, the program will display an error message and continue.

4. Exit the Program:

Type exit to quit the FSM program.

