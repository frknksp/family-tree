# Family Tree

This project is a program that reads a list of people from an Excel file and creates a tree data structure representing their relationships. The program allows the user to perform various queries on the data, such as finding the list of people who don't have children, sorted by age, or finding the list of siblings of a given person, sorted alphabetically.

## Prerequisites

- Java 8 or higher
- Apache POI library for reading Excel files (download from https://poi.apache.org/)

## Running the program

To run the program, compile all the .java files and run the `Main` class. The program will prompt you to enter the path to the Excel file containing the data. Make sure the file is in the correct format (see below for details).

## Excel file format

The Excel file should contain a sheet with the following columns:

- ID: a unique ID for each person
- Name: the person's name
- Gender: the person's gender ("Male" or "Female")
- Blood Group: the person's blood group (e.g. "A", "B", "AB", "O")
- Father's Name: the name of the person's father
- Mother's Name: the name of the person's mother
- Maiden Name: the person's maiden name (if applicable)

## Classes

- `ReadExcel`: a class with a method for reading a list of people from an Excel file
- `TreeNode`: a class representing a node in the tree, with methods for adding children, printing the tree, and performing a depth-first search
- `Kisi`: a class representing a person, with methods for getting and setting various attributes such as name, blood group, and parent's names
- `BreadthFirstSearch`: a class with methods for performing a breadth-first search of a tree data structure and finding siblings
- `Functions`: a class with methods for searching for people with a specific blood group and for finding the depth of a tree
- `Main`: the main program class, containing the main method and the code for the menu and queries