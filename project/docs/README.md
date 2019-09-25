# LPOO_TG Snake

> In this project we will implement the classic snake game using java. The game will be text-based and will use the lanterna API and Swing. Throughout this project we will use the methods taught in LPOO class and follow good object oriented design practices. The main focus of the project is the good usage of design patterns so that OOP principles, like SOLID, are not violated. The game will be designed for a single player or two players playing on the same keyboard. 
>
>For the two player mode, each player controls a snake, if the snakes collide the game will be over. The player with a greater score will be the winner at the end of a game.
You can improve your score by eating the apples, which also make the snake get bigger. The bigger you get, the harder it is to avoid collision with the walls, yourself and possibility the other player. The is a special kind of apple, a big apple, that gives the double of the points.
> The player can choose the the level in which we wants to play.
>
>This is a project by Maria Helena Ferreira (https://github.com/MHelena45) and Nuno Miguel Marques (https://github.com/nunomiguel22).

## Implemented Features
* Lanterna GUI menus
  * Main, pause, level, help, best scores, game over and score menus ( named as LMenuMain, LMenuPause, LMenuLevel, LMenuHelp, LMenuBestScores, LMenuGameOver, and LMenuScore, respectively)
* Swing menus
  * Main, pause, level, help, game over and best scores menus (named as SMenuMain, SMenuPause SMenuLevel, SMenuHelp, SMenuGameOver and SMenuBestScores , respectively)
* Single player
  * Randomly spawning apple
  * Randomly spawning big apple
  * Randomly spawning big obstacles
  * Player controlled snake
  * Collision of the player snake and all other elements
  * Player score
* Multiplayer mode
  * Randomly spawning apple
  * Randomly spawning big apple
  * Two snakes controlled by different players
    * Player 1 uses up, left, right, down arrows
    * Player 2 uses W, A, D, S
  * Collision between player snakes and of each snake with all other elements
  * Individual player1 and player2 scores
* Graphical and Input
  * Receive inputs using Lanterna and Swing
  * Render all elements using Lanterna and Swing
## Planned Features
* Graphical and Input
  * Option to use Swing for inputs and rendering instead of Lanterna
* Have the apple and big apple spawn only on free space
* More comprehensive settings such as arena size and big apple spawn rate
* Obstacles that appear form time to time, blinking before they are definitive 
* Time limit on apples


# Design
> ## Model-View-Controller
> The game was designed with the MVC architectural pattern in mind. As such the project was divided into 3 main packages.
>  * Model: Contains all game elements and logic
>  * View: Is responsible for rendering the game to the console
>  * Controller: Makes the connection between the two previous models
> The exception to this are the current Lanterna menus, as we use Lanterna gui windows, we found it difficult to make the menus fit in this architecture. This is an item we plan to improve.

> ## State Pattern
> During the game's execution its behavior will change between displaying menus to playing different levels. As such the "State Pattern" was chosen to reflect this, as the user navigates the menus or starts a new game the game alters it's state to behave correctly. As such the class Game Controller contains one active object of the class "State", State's derivatives then alter the behavior of the Game Controller depending on the situation. Game Controller's state alters itself as each state derivative can change the current state at any time. Such "Main Menu" change the state to a new single player state to begin a new game. 
>
> ## Command
> Since an invoked action varies with the key pressed, we wanted to parameterize objects by an action to perform and execute requests at different times. So the pattern we used was command. We created an interface named Command, and the four possible commands implemented its functionality. So, at the end, it's easy to add new command.
>
> ## Singleton
> The Game Controller contains the main game loop and as such will not be instantiated more than once in the program execution, instead it's behavior is altered by using the state pattern, to reflect this the class was made into a singleton. It is instantiated only once and future access to this class uses that single instance. This is the pattern known as singleton. To implement this pattern the constructor for Game Controller was made private and a method to access this instance, or create it for the first time, was made public. We use this pattern because we were passing the argument game to many time, so it made since could get it every every where.

> ## Factory
> Since several game elements with some similar code are created for each game type, a factory class was created to handle the task of generating the elements. This factory can generate elements in a given position by specifying the element type and position or randomly by element type and position constraints. The factory also has methods to generate more complex elements, such as a group of walls or a snake with random position and direction. This design pattern made level construction much easier and cleaner.


## Known Code Smells and Refactoring Suggestions
> In the first delivery we and some code smells as:
>  * Lazy Class: Some classes, such as the Apple class, at the moment are very small and have limited usefulness. This may be fixed by removing classes if they will not have additional features.
>  * Long Parameter List\ Data Clumps: This could be fixed with parameter objects, an example of this is width and height being used as parameters together as separate parameters throughout the program.

> For the second delivery we remove the Apple Class by using the class element for the apple existing, as both classes were doing the same. In the matter of the long parameter List/Data clumps, our classes are now smaller without repeated code.


## Testing Results

* Tests report in HTML format can be found in docs/tests folder.
* Mutation tests report in HTML format can be found in docs/pitTest folder

> Coverage of the test

<img src= "https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_37/blob/master/images/TestResults.PNG" width="500">

> Coverage of the package Controller

<img src= "https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_37/blob/master/images/testControllers.PNG" width="500">

> Coverage of the package Command

<img src= "https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_37/blob/master/images/testCommands.PNG" width="500">

> Coverage of the package Model

<img src= "https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_37/blob/master/images/testModel.PNG" width="500">

> Mutation tests

<img src= "https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_37/blob/master/images/testMutation.png" width="500">

## Self-evaluation

> The workload was shared evenly between the two members.
