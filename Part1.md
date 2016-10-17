# Part 1. Creating the project and JavaFX manager class.

## Creating the project in Eclipse that works with JavaFX
You will need the Eclipse IDE which can be found at [eclipse.org](http://eclipse.org).
Once you have it downloaded and set up, create a new JavaFX project called "platformer".

You will need to inform Eclipse that you will be using JavaFX for this project.
By default, it will not allow you to access JavaFX API. (For more information, see the second answer [of this StackOverflow post](http://stackoverflow.com/questions/33383248/eclipse-mars-wont-auto-import-javafx)

1. Go to Project ▸ Properties and select Java Build Path in the sidebar of the Properties Window.
2. Go to the Libraries tab and click the disclosure triangle next to JRE System Library.
3. Double click "Access Rules" and then "Add" a new access rule with Resolution: Accessible and Rule Pattern: javafx/**

You should now be able to use JavaFX in the Eclipse project.
