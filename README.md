# game-of-life

A Clojure/ClojureScript version of Game of Life

## Getting started with Cursive and Intellij

We recommend using Cursive and IntelliJ when developing Clojure.

1. Install [IntelliJ](https://www.jetbrains.com/idea/download/)
1. Install [Cursive](https://cursive-ide.com/)
1. Make sure you have the code template downloaded on your computer.
1. In IntelliJ, Import project (from existing sources). Select your project root directory. Choose "Import project from external model" and select Leiningen. When prompted to choose a Project SDK, select Java 1.8 or above.
1. Make sure you can start a REPL. To run a REPL, right click on the project (in the Project space usually to the left) and select the option "Run 'REPL for firestone'". You can also configure a Run task: Run -> Edit Configurations... -> + -> Clojure REPL -> Local.
1. Configure keyboard shortcuts. Under preferences -> Keymap, on the right side, Main menu -> Tools -> REPL: Create shortcut for "Run test in current NS" in REPL and "Send form before caret to REPL".

We recommend using the built-in format functionality in the editor. See https://www.jetbrains.com/help/idea/reformatting-source-code.html .

You might also want to disable "structured editing" or learn additional commands such as slurp and barf.

Sometimes it is nice to be able to reset the REPL (especially if you are working with multimethods). You can use the following commands in the REPL:

```clojure
(require 'clojure.tools.namespace.repl)
(clojure.tools.namespace.repl/refresh-all)
```

## Using figwheel

To get an interactive development environment run:

    lein figwheel

and open your browser at [localhost:3449](http://localhost:3449/).
This will auto compile and send all changes to the browser without the
need to reload. After the compilation process is complete, you will
get a Browser Connected REPL. An easy way to try it is:

    (js/alert "Am I connected?")

and you should see an alert in the browser window.

To clean all compiled files:

    lein clean

To create a production build run:

    lein do clean, cljsbuild once min

And open your browser in `resources/public/index.html`. You will not
get live reloading, nor a REPL. 