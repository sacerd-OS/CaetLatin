# CaetLatin - Command Line Latin Dictionary
While many online dictionaries for Latin already exist (such as William Whitaker’s Words and Perseus’ online Lewis and Short), I figured it’d be fun to try to implement a backend for a Latin dictionary using Java and JSON.

This project is only a proof of concept, currently at around 100 lemmas. While I do intend to expand the dictionary, the work required to implement the entire Latin lexicon (thousands of words) far exceeds the amount of time and interest I have for this project. Moreover, such a thing would require inclusion of alternate forms (of which most Latin words have a dozen or more) which would require more code to parse. 

In time, I might expand the functionality of the dictionary to include parsing for different forms, as well as more terms. 

The dictionary uses [Wiktionary](https://en.wiktionary.org/) as its primary source since it’s the most digestible and accessible Latin dictionary I’ve ever used which is licensed under the [CC BY-SA 3.0](https://creativecommons.org/licenses/by-sa/3.0/) license.

## How to Use
There is currently an executable JAR file released, but it is out of date. You may choose to clone the repository and creat an executable locally:
``git clone https://github.com/sacerd-OS/CaetLatin``

The UI is quite simple (as I favor simplicity). Run on the command line, enter the word you wish to find the definition of, hit enter. Press "q" to quit at any time, or close your terminal. Your choice.

## Issues
Please report any bugs, typos, or bad Latin using GitHub's issues feature. Thanks.

## To Do
In the approximate order I'll finish these tasks.
- [ ] Add more lemmas (from Horace, etc.) (In progress)
- [X] Release an executable package
- [ ] Add option to inflect searched lemmas
- [ ] Add search by inflected forms (ex. "sacerdotis" returns result for "sacerdos")
- [ ] Handle homonyms by providing multiple definitions
- [ ] Clean up code & make more efficient
- [ ] Clean up documentation
