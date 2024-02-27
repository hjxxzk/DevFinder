## Opis

## Uruchamianie
Aplikacja DevFinder przujmuje jako argument wejściowy ścieżkę do pliku txt zawierającą listy projektów i programistów w poniższym formacie:

## Format pliku wejściowego
PROJECTS
P1: JAVA JAVA QA PM
P2: PYTHON QA PM
P3: JS ANGULAR QA PM
P4: JAVA ANGULAR QA
P5: RUST

STAFF
R1: JAVA
R2: ANGULAR QA
R3: PYTHON QA
R4: JAVA PYTHON
R5: PM
R6: ANGULAR JS
R7: PM
R8: JAVA PYTHON
R9: QA
R10: BLOCKCHAIN PM QA

Lista _Projects_ zawiera indeksy projektów wraz z listą ról, w których mają one zostać napisane. Lista _Staff_ zawiera indeksy pracowników wraz z językami, w których potrafią oni programować.
Program dopasowuje pracowników do projektów zakładając, że każdy programista może pracować tylko nad jednym projektem, natomiast QA i PM mogą nadzorować po dwa projekty.
