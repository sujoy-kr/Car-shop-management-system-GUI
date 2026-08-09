#!/bin/bash

# Navigate to the src directory
cd src

# Compile all application Java files (excluding Tests)
echo "Compiling..."
javac $(find carShop -name "*.java" ! -name "*Test.java")

# If compilation is successful, run the Main class
if [ $? -eq 0 ]; then
    echo "Running Car Shop Management System GUI..."
    java carShop.Main
else
    echo "Compilation failed."
fi
