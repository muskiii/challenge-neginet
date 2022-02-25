# Neginet Challenge by Jose Maria Fabiano

### Output
The names cardinality for full, last, and first names: Full names: 48432 Last names: 468 First names: 3007
The most common last names are: Barton: 143 Lang: 136 Ortiz: 135 Hilll: 134 Hills: 130 Terry: 129 Johns: 128 Romaguera: 128 Becker: 128 Crist: 127
The most common first names are: Tara: 32 Keon: 31 Andreanne: 31 Stephania: 31 Kaycee: 30 Baron: 29 Heath: 29 Kayley: 29 Ulices: 29 Charlotte: 29
[Graham, Garfield, Marvin, Mariah, McLaughlin, Agustina, Lang, Nikko, Bradtke, Luis, Adams, Matilde, Lehner, Anita, Ortiz, Berry, Koch, Nicolas, Cartwright, Elmo, Fisher, Gertrude, Kunze, Davin, Stanton, Roy, Runolfsdottir, Colby, Rogahn, Ryley, Tromp, Stanley, Hoppe, Bethel, Shanahan, Samanta, Hills, Thad, McGlynn, Norma, Lynch, Lennie, Bahringer, Madison, Tillman, Donna, Stoltenberg, Sonya, Dickinson, Mckenna]

## Instructions:
Files to be used in this application should be stored under the "resources" directory.

### Running the application:
```sh
./gradlew run --args="coding-test-data.txt 25"
```
Where the first argument is the name of the file and the second argument is the size for new list of names.

### Running Tests:
```sh
./gradlew test
```

People Name Program 1.0
=======================

Description
-----------

Write a program that processes the included example file that contains
people's names, outputs some statistics and generates updated output.

Input:

 . An arbitrary file with the same format as the attached example file. Your
   program will be tested on much (e.g., 100x) larger files.


Output:

  1. The cardinality (count of unique items) of each the three sets of full, last, and first names
  2. The ten most common last names sorted in descending order, including the count of these names.
  3. The ten most common first names sorted in descending order, including the count of these names.
  4. A list of modified names (see below for details)

Note: For 1, 2 and 3, the order within names with same cardinality does not matter (e.g. if two names have a count of 18, which one you display first is not important)


Assumptions About Names
-----------------------

Here are some assumptions you can make about names which are meant to
make the program easier to write:

. Names start at the beginning of the line.
. Names follow these rules:
  . Formatted as: Lastname, Firstname
  . Lastname and firstname to contain only alphabetic characters ("a" to "z" and "A" to "Z"; No punctuation, dashes, quotes, etc.)
. A full name is identical to another full name if it has the same first name (case sensitive) and last name (case sensitive).
Names that don't follow those rules can be ignored.

Example
-------

For the following input sample:

    Smith, Joan -- corporis
        Totam eos ut omnis et nemo dolore.
    Smith, Sam -- ut
        Ut dolorem est voluptate fugit qui vitae.
    Thomas, Joan -- modi
        Nesciunt magni suscipit maxime quaerat sint hic voluptate.
    Upton, Joan -- veritatis
        Sed ut impedit harum.
    Cartman, Eric -- tenetur
        Esse amet adipisicing commodo labore.
    O'Shea, Peter

The first line contains a name:
    The full name is: Smith, Joan
    The last name is: Smith
    The first name is: Joan

The last line does not contain a valid name, as it includes punctuation (single quote).

1. The names cardinality for full, last, and first names:
    Full names : 5
    Last names: 4
    First names: 3

2. The most common last names are:
    Smith: 2
    Thomas: 1
    Upton: 1
    Cartman: 1

3. The most common first names are:
    Joan: 3
    Sam: 1
    Eric: 1

4. List of Modified Names
-------------------------

Step 1 - Build a new list of N names by taking the first N names from the input file where the following is true:

  . No previous name in the new list has the same first name.
  . No previous name in the new list has the same last name.

Note: This list is for internal manipulation and should not be part of the output of your program (see Step 2 for what goes to the output)

  For example, consider these names:

    Smith, Joan
    Smith, John
    Smith, Sam
    Thomas, Joan
    Upton, Joan
    Upton, Tom
    Vasquez, Cesar

  These names would be part of the new list:

    Smith, Joan
    Upton, Tom
    Vasquez, Cesar

  These names would not:

    Smith, John     # Already have a last name "Smith"
    Smith, Sam      # Already have a last name "Smith"
    Thomas, Joan    # Already have a first name "Joan"
    Upton, Joan     # Already have a first name "Joan"

Your program must support an arbitrary value for N, but for your example output
you may use 25.

Step 2 - After you have built this list of N names, print as output of your program a new list that contains N modified names. This  These modified names should only use first names and last names from the original N names.  However, the new list and the old list should not share any full names.

Note: Each first name and last name should be used exactly once (see example of incorrect answer below with "Carl" being used multiple times)

  For example, if the file contains the names:

    Brutananadilewski, Carl
    Crews, Xander
    Cartman, Eric
    ... 22 more names if N=25 ...

  Then this is a valid output:

    Brutananadilewski, Eric
    Crews, Carl
    Cartman, Xander
    ... 22 more names if N=25 ...

  But this is not (because "Barney" and "Bambam" weren't in the original file):

    Brutananadilewski, Fred
    Crews, Barney
    Cartman, Bambam
    ... 22 more names if N=25 ...

  This is also incorrect (because "Cartman, Eric" is unchanged):

    Brutananadilewski, Xander
    Crews, Carl
    Cartman, Eric
    ... 22 more names if N=25 ...

  This is also incorrect (because "Carl" is used multiple times):

    Brutananadilewski, Xander
    Crews, Carl
    Cartman, Carl
    ... 22 more names if N=25 ...

Important Notes
---------------

. While our backend is primarily written in Java and Kotlin, we use
  Python and Scala as well. You can choose any of these languages for
  your solution. We recommend you choose the language you are the most
  comfortable with.
. This exercise tests your knowledge of data structures and sorting. It
  is simple enough to be completed using just the standard library of
  your language of choice. Please, do not use any frameworks, databases
  or non-standard libraries (except for unit testing).
. The program should be as time and memory efficient as you can
  make it. Keep in mind that your code will be executed against much
  larger data sets! How does that affect your approach? Can you point
  out what you specifically did in your design to address this?
. The program should provide the correct answers. How did you test for
  correctness?
. You should provide the output of your program with your submission.
. It should be easy for others compile and execute your submission. Build
  tools (maven, gradle, sbt, ant, etc) can come in very handy for this.
  Please, avoid submitting binaries and instead give instructions on
  how to build and run your code. And above all, your code should
  compile!
. The program should be as concise and readable as possible.
. Brief comments explaining implementation choices are welcome, but
  not required.
. You can hard code the name of the input file and the modified name
  count into your program (to make it easier to write) but it should
  otherwise be built to handle an arbitrary file with the same format
  as the example file.
. Last but not least, you should be prepared to discuss the solution
  you came up with for the exercise. We value highly not just your ability
  to complete the work, but also your ability to explain why you took the
  approach you did and what factors you considered while doing it.


Finishing Up
------------

Please, archive the following into a compressed file:
* Your source code (no binaries or IDE specific files please).
* Your build file (e.g., pom.xml, build.xml etc) and/or instructions on how to
  compile your program.
* A txt file with the output of your program.


Thanks for investing the time to do this!  We believe this should
take you about two to three hours to write assuming you have proficiency with
your chosen programming language.
