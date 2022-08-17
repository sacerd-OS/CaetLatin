# CaetLatin - Command Line Latin Dictionary
## About
While many online dictionaries for Latin already exist (such as William Whitaker’s Words and Perseus’ online Lewis and Short), I figured it’d be fun to try to implement a backend for a Latin dictionary using Java and JSON. This is also the first time I've ever formally used package management software (Maven) which is pretty cool.

This project is only a proof of concept, currently at 4 lemmas (so, the bare minimum for testing). While I do intend to expand the dictionary, the work required to implement the entire Latin lexicon (thousands of words) far exceeds the amount of time and interest I have for this project. Moreover, such a thing would require inclusion of alternate forms (of which most Latin words have a dozen or more) which would require more code to parse. 

In time, I might expand the functionality of the dictionary to include parsing for different forms, as well as more terms. 

The dictionary uses (Wiktionary)[https://en.wiktionary.org/] as its primary source since it’s the most digestible and accessible Latin dictionary I’ve ever used. It is licensed under the (CC BY-SA 3.0)[https://creativecommons.org/licenses/by-sa/3.0/] license.

## How to Use
In this version, no package (a JAR file, etc.) has been released. This will change in the next release, which should be coming out shortly. If you want, you can still download the source code and compile manually.

The UI is quite simple (as I favor simplicity). Run on the command line, enter the word you wish to find the definition of, hit enter. Press "q" to quit at any time, or close the command line. Your choice.

## To Do
- [ ] Add more lemmas (from Horace, etc.)
- [ ] Release an executable package
- [ ] Add option to inflect searched lemmas
- [ ] Add search by inflected forms (ex. "sacerdotis" returns result for "sacerdos")
- [ ] Handle homonyms by providing multiple definitions
- [ ] Clean up documentation
