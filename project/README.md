# LPOO_TG Snake

> In this project we will implement the classic snake game using java. The game will be text-based and will use lanterna API. Throughout this project we will use the methods taught in LPOO class and follow good object oriented design practices. The main focus of the project is the good usage of design patterns so that OOP principles, like SOLID, are not violated. The game will be designed for a single player or two players playing on the same keyboard. 
>
>For the two player mode, each player controls a snake, if the snakes collide the game will be over. The player with a greater score will be the winner at the end of a game.
You can improve your score by eating the apples, which also make the snake get bigger. The bigger you get, the harder it is to avoid collion with the walls, yourself and possibility the other player. The is a special kind of apple, a big apple, that gives the double of the points.
> The player can choose the the level in which we wants to play. The level changes the speed of the moviment of the snake.
>
>This is a project by Maria Helena Ferreira (https://github.com/MHelena45) and Nuno Miguel Marques (https://github.com/nunomiguel22).

## Screenshots

> Menu Main in Lanterna

<img src= "https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_37/blob/master/images/Lanterna/MenuMain.PNG" width="300" >

> Menu Level in Swing

<img src= "https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_37/blob/master/images/Swing/MenuLevel.PNG" width="250" >

> Menu Level in Lanterna

<img src= "https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_37/blob/master/images/Lanterna/MenuLevel.PNG" width="400">

> Menu Help in Swing

<img src= "https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_37/blob/master/images/Swing/MenuHelp.PNG" width="400">

> SinglePlayer Mode in Swing

<img src= "https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_37/blob/master/images/Swing/SinglePlayer.PNG" width="500">

> Multiplayer Mode in Lanterna

<img src= "https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_37/blob/master/images/Lanterna/snake2.PNG" width="500">

> BigApple in Lantera

<img src= "https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_37/blob/master/images/Lanterna/bigApple.PNG" width="500">

> Menu Best Scores in Swing

<img src= "https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_37/blob/master/images/Swing/MenuBestScores.PNG" width="300" >

> Menu Score SinglePlayer in Lanterna

<img src= "https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_37/blob/master/images/Lanterna/MenuGameScore.PNG" width="400">

> Menu Score MultiPlayer in Lanterna

<img src= "https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_37/blob/master/images/Lanterna/MenuGameScoreMultiplayer.PNG" width="250">

> Menu GameOver in Lanterna

<img src= "https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_37/blob/master/images/Lanterna/MenuGameOver.PNG" width="250">

> Menu Game Over in Swing when tied in Multiplayer

<img src= "https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_37/blob/master/images/Swing/MenuGameOverTied.PNG" width="300" >

## Install Instructions

* This project uses gradle, as such command 'gradle run' or './gradlew run', on linux, will build and execute the application.
* Command 'gradle fatjar' can be used to generate an executable .jar file.
* Use arguments "Swing" or "Lanterna" to choose interface. Lanterna is default. Examples:
>"./gradle run --args='Lanterna'", or "java -jar .\snake-all-1.0.jar Swing" if executing the fatJar 

