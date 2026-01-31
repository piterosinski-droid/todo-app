# TODO Application — prezentacja

## 1. Cel projektu
- Prosta konsolowa aplikacja TODO w Javie.
- Zarządzanie listą zadań i ich stanem (TODO / IN_PROGRESS / DONE).
- Zapis/odczyt zadań do pliku.

## 2. Funkcjonalności (wymagania)
- Dodanie zadania do listy
- Wyświetlenie wszystkich zadań
- Zmiana statusu zadania (markInProgress, markDone)
- Walidacja danych wejściowych (TaskValidator)
- Obsługa sytuacji „nie znaleziono zadania” (TaskNotFoundException)
- Zapis/odczyt danych przez repozytorium plikowe (FileTaskRepository)

## 3. Architektura i struktura
Pakiety:
- model — klasy domenowe (Task, SimpleTask, Category, enumy)
- service — logika (TaskService, TaskFactory, TaskValidator)
- persistence — zapis/odczyt (TaskRepository, FileTaskRepository, Storable)
- exception — własny wyjątek (TaskNotFoundException)

## 4. Najważniejsze elementy OOP
- Klasa abstrakcyjna: Task
- Dziedziczenie: SimpleTask extends Task
- Enumy: CategoryType, Priority, TaskStatus
- Interfejs: Storable, TaskRepository
- Metoda statyczna: TaskFactory.createSimpleTask(...)
- Hermetyzacja i walidacja w konstruktorach

## 5. UML
- Diagram UML znajduje się w pliku: uml-diagram.png

## 6. Uruchomienie
- Uruchom klasę: pl.put.todo.Main
- Program wykonuje prosty test: dodaje zadanie, zmienia status, wypisuje listę.
