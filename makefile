SRC_DIR = .
BIN_DIR = bin
MAIN_CLASS = Main
JAVAC = javac
JAVA = java
SOURCES = $(shell find $(SRC_DIR) -name "*.java")

all: compile

compile:
	@echo "Compiling Java sources..."
	@mkdir -p $(BIN_DIR)
	@$(JAVAC) -d $(BIN_DIR) $(SOURCES)
	@echo "Compilation complete."

run: compile
	@echo "Running the project..."
	@$(JAVA) -cp $(BIN_DIR) $(MAIN_CLASS)

debug: compile
	@echo "Running the project in debug mode..."
	@$(JAVA) -cp $(BIN_DIR) Debug


clean:
	@echo "Cleaning up..."
	@rm -rf $(BIN_DIR)
	@echo "Clean complete."

help:
	@echo "Makefile commands:"
	@echo "  make        - Compile the project"
	@echo "  make run    - Compile and run the project"
	@echo "  make clean  - Remove all compiled files"
	@echo "  make help   - Display this help message"

.PHONY: all compile run clean help
