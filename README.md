# TODO Application 

## Opis
Konsolowa aplikacja TODO w Javie. 
- podział na warstwy (model / service / persistence),
- dziedziczenie,
- klasa abstrakcyjna,
- metoda statyczna,
- własny wyjątek,
- zapis/odczyt do pliku.
## Wymagania funkcjonalne

Aplikacja konsolowa TODO realizuje następujące funkcjonalności:

1. Dodanie nowego zadania (SimpleTask) do listy zadań.
2. Walidacja danych zadania podczas dodawania (np. tytuł, priorytet, kategoria).
3. Pobranie listy wszystkich zadań.
4. Wyszukanie zadania po identyfikatorze (id).
5. Oznaczenie zadania jako DONE na podstawie id..
6. Zapis zadań do pliku tekstowego (persistencja).
7. Odczyt zadań z pliku tekstowego (persistencja).
8. Obsługa sytuacji błędnych (np. brak zadania o danym id – własny wyjątek).


## Wymagania funkcjonalne
- tworzenie zadań (Task/SimpleTask),
- kategorie i priorytety,
- zmiana statusu (TODO/IN_PROGRESS/DONE),
- walidacja danych (TaskValidator),
- obsługa błędów (TaskNotFoundException),
- zapis i odczyt zadań z pliku.

## Struktura
- `src/pl/put/todo/model` – model domeny
- `src/pl/put/todo/service` – logika biznesowa
- `src/pl/put/todo/persistence` – zapis do pliku
- `src/pl/put/todo/exception` – wyjątki
- `src/pl/put/todo/Main.java` – uruchomienie programu
