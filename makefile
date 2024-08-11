JAVAC = javac
JAVA = java
SRC_DIR = src
BIN_DIR = bin

SRC_FILES = $(wildcard $(SRC_DIR)/*.java)

all: compile

#Compile Java source files
compile:
	@mkdir -p $(BIN_DIR)
	$(JAVAC) -d $(BIN_DIR) $(SRC_FILES)

#Run RMI Registry
registry:
	@echo "Starting RMI registry..."
	@cd $(BIN_DIR) && $(RMI_REGISTRY) &

#Run the server
run-server: registry
	@echo "Starting Calculator Server..."
	@cd $(BIN_DIR) && $(JAVA) CalculatorServer

#Run the client
run-client:
	@echo "Starting Calculator Client..."
	@cd $(BIN_DIR) && $(JAVA) CalculatorClient

#Clean build directory
clean:
	@echo "Cleaning up..."
	@rm -rf $(BIN_DIR)

#Phony targets (for optimizing performance)
.PHONY: all compile registry run-server run-client clean
