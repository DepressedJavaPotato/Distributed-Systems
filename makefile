JAVAC = javac
JAVA = java
RMI_REGISTRY = rmiregistry

SRC_DIR = src
BIN_DIR = bin

SRC_FILES = $(wildcard $(SRC_DIR)/*.java)#Java files
BIN_FILES = $(SRC_FILES:$(SRC_DIR)/%.java=$(BIN_DIR)/%.class)#Class files

all: compile

#Compile Java source files
compile:
	if not exist $(BIN_DIR) mkdir $(BIN_DIR)
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
	@rmdir /S /Q $(BIN_DIR)

#Phony targets
.PHONY: all compile registry run-server run-client clean
