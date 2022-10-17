# 🎄 Advent of Code
This project contains all my solutions (or attempts) of the Advent of Code puzzles. As obvious, the solutions are written Java. If you think you have an improvement for any of those solutions, feel free to open a pull request, if you want :)


# ❓ What is Advent of Code?
Advent of Code (https://www.adventofcode.com) is an Advent calendar for developers. From december 1st to december 25th, every day at 00:00 EST (UTC-5) will the new puzzle release. You will be able to solve this later, though (you can actually solve all puzzles from former years too, that's what I am doing currently).


# ▶ How to run a puzzle?
I implemented a very basic module system into this project, which allows me to easily provide the input as String and List. To run a specific puzzle you have to start the process (I recommend running this project via IntelliJ, because the compiled .jar file might not find the inputs). Then you just have to specify the puzzle in the console via `year/day` (e.g. `2015/03`)


# 💻 How can I add a solution?
If you want to add a solution, you have to create a new java file in the "modules/<year>" package. To get the methods implemented, you have to extend `AocModule`. To get the module loaded, you have to annotate the class with `Module`.

Here is an example of how a class should look like:

```
@Module(year = "2015", day = "04")
public class Day04 extends AocModule {
    @Override
    public void solution(String rawInput, List<String> input) {
        // Code to solve the puzzle
    }
}
```
    
P.S.: You have to create your input as a .txt file in the appropriate directory (`resources/<year>/<day>.txt`)
