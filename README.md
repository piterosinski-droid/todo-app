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
