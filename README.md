# CSX42: Assignment 4
## Name: Preeti Priyam

-----------------------------------------------------------------------

Following are the commands and the instructions to run ANT on your project.


Note: build.xml is present in [arrayvisitors/src](./arrayvisitors/src/) folder.

Instruction to clean:
####Command: ant -buildfile arrayvisitors/src/build.xml clean

Description: It cleans up all the .class files that were generated when compiled the code.

Instruction to compile:
####Command: ant -buildfile arrayvisitors/src/build.xml all

Description: Compiles code and generates .class files inside the BUILD folder.

Instruction to run:
####Command: ant -buildfile arrayvisitors/src/build.xml run -Dinput1="input1.txt" -Dinput2="input2.txt" -Dcommonintsout="commonintsout.txt" -Dmissingintsout="missingintsout.txt" -Ddebug="2"

Note: Arguments accept the absolute path of the files.

# Justification for the Data Structures used in the assignment in terms of time and/or space complexity.

Set: LinkedHashSet
I have used Set implementation LinkedHashSet. LinkedHashSet provides faster access and retrieval of elements when compared to other data structures. LinkedHashSet maintains insertion order compared to HashSet. LinkedHashSet also provides constant time complexity for basic operations such as add, remove and search and takes O(n) in terms of space complexity.


Time complexity for searching an element from LinkedHashSet : O(1)
Time complexity for adding an element to LinkedHashSet : O(1)
Time complexity for removing an element from LinkedHashSet : O(1)

List: ArrayList
I have used List implementation ArrayList because it is a dynamic size array which is better in terms of space and time complexity as we don't need to define a static size for the array. It's better to store objects in the ArrayList as it provides type checking through generics. Moreover, when compare to other data structure such as LinkedList, Stack, Queue, etc., in terms of time complexity for inserting, reading a value, ArrayList is better.

Time complexity for adding an element into an arbitrary indices of the List : O(n)
Time complexity for adding last element into the List : O(1)
Time complexity for reading an element from List : O(1)
Time complexity for searching an element from List : O(n)

[Reference](https://www.baeldung.com/java-singleton-double-checked-locking)
[Reference](https://www.vogella.com/tutorials/JavaDatastructureList/article.html)

## Academic Honesty statement:

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating an official form will be
submitted to the Academic Honesty Committee of the Watson School to
determine the action that needs to be taken. "

Date: [07/21/2020]
