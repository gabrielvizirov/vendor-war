***	README.txt	******************************************************
------------------------------------------------------------------------------
Gnostech Inc. Programming Challenge v1.0

Title: Vendor War
File (main): vendorwar.java
Author: Vizirov, Gabriel
Last Modified: August 19, 2018
------------------------------------------------------------------------------

Specifics:
Java programming language was used.
I used Eclipse Neon Java Photon R IDE on Windows 10 to write, compile, and test the program.
Eclipse IDE for Java Developers
Version: Photon Release (4.8.0)
Build id: 20180619-1200
I used 'Java SE 10.0.2'
VendorWar.java is the main file to run the game.
(no .exe file was created)

Items that might need to be downloaded to run the program:
Eclipse PHOTON IDE, found at "https://www.eclipse.org/downloads/"
JavaSE JDK and JRE, found at "http://www.oracle.com/technetwork/java/javase/downloads/index.html"

Java will need to be installed in Windows OS if you do not have it already installed.
Java should already be installed, by default, to the kernel in Linux or Unix.

-------------------------------------------------
Run:

To run the program in Eclipse IDE for Java Developers in a Windows OS:
1. Open Eclipse Photon
2. Create a workspace directory or use the default given, press the "OK" Button.
3. Select "File->New->Java Project"
4. A box will open, go to the "Project name:" textbox and enter "vendorwar" (all lowercase).
5. Click on the "Finish" Button.
6. In the "Package Explorer" window, select the "vendorwar" folder, right-click and select "New->Package"
7. A box will open, go to the "Name:" textbox and enter "vendorwar" (all lowercase).
8. Click on the "Finish" Button.
9. Go to the folder directory you have the java files stored on your PC
10. Drag the java files into the "vendorwar" package we have just created.
11. A box will appear with "Copy files" already selected. Click on the "OK" Button to continue.
12.double click on vendorwar.java in the package explorer which should open up in the code window.
13. Open the file directory you have the eclipse-workspace located in which would be "eclipse-workspace -> vendorwar" and copy the csv file "vendor_fighters" to that directory.
14. Go back to eclipse and click on "Project->Build All" at the top menu to compile the code, or use the hotkey "CTRL-B". (This step should not be needed as Eclipse auto compiles the code in Photon.)
15. Click on "Run->Run" at the top menu to start the program,or press the play button on the toolbar, or use the hotkey "CTRL-F11"
16. Run the game till it finishes
17. Everything will be shown on the Console located at the bottom by default on Eclipse.


To run the program in a Linux Terminal:
1. Go to the Directory where the files are located.
2. Type "javac *.java" and press ENTER to compile all the java files.
3. Type "java vendorwar" to run the program.


-------------------------------------------------
To Play:
1. Just run the file
2. The code will give the winner at the end and stop running.

-------------------------------------------------
Object of the Program:
The program will import vendor information from a csv file.
The program will then make each vendor battle each other to see which vendor coomes out on top at the end with the most wins against other vendors.
The matches will be over when a vendors health drops to 0 (zero) and the the other vendor wins a point.
The vendor with the most points at the end wins.
A tiebreaker will be set by having an extra match for winner.
This program has all the bonus objectives included such as biases for initiative, dodging, and critical attacks.

*Toshiba and Apple have a larger chance to win as they have more attack damage and much larger health than the other vendors in the csv file.

-------------------------------------------------
The files provided include: 
(No .exe file was created)
a. vendorwar.java - the main program file for the user to run. Calls Match.java to start the war.
b. Match.java - This is the file that vendorwar.java calls in order to initialize, start, battle, and end a match.
c. Fighter.java - This file stores all the information about a vendor that was taken from the csv table.
d. vendor_fighters.csv - This is a csv file that carries a table for all the venders and their vitals/values.