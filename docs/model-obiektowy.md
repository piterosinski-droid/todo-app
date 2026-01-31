# Model obiektowy aplikacji TODO

Model obiektowy został wykonany na podstawie diagramu UML
i zaimplementowany w języku Java.

## Diagram UML
Diagram UML znajduje się w pliku:
- `uml-diagram.png`

## Klasy domenowe (model)

- **Task**  
  Klasa abstrakcyjna reprezentująca zadanie.  
  Przechowuje podstawowe dane: identyfikator, tytuł, opis, priorytet i status.  
  Implementuje interfejs `Storable`.

- **SimpleTask**  
  Konkretna implementacja klasy `Task`.  
  Reprezentuje podstawowy typ zadania.

- **Category**  
  Reprezentuje kategorię zadania.  
  Posiada typ `CategoryType`.

- **CategoryType (enum)**  
  Określa typ kategorii (np. STUDIA, PRACA, DOM, INNE).

- **Priority (enum)**  
  Określa priorytet zadania.

- **TaskStatus (enum)**  
  Określa status zadania (np. TODO, DONE).

## Warstwa serwisowa

- **TaskService**  
  Odpowiada za logikę biznesową aplikacji.  
  Wykorzystuje `TaskRepository` do zarządzania zadaniami.

- **TaskFactory**  
  Klasa fabrykująca obiekty typu `Task`.  
  Zawiera metodę statyczną do tworzenia zadań.

- **TaskValidator**  
  Klasa walidująca dane zadania.  
  Zawiera metodę statyczną `validate`.

## Warstwa persystencji

- **TaskRepository (interfejs)**  
  Definiuje operacje zapisu, odczytu i usuwania zadań.

- **FileTaskRepository**  
  Implementacja `TaskRepository`,  
  zapisująca dane zadań do pliku.

- **Storable (interfejs)**  
  Określa możliwość serializacji obiektu.

## Obsługa wyjątków

- **TaskNotFoundException**  
  Własny wyjątek domenowy zgłaszany,
  gdy zadanie o podanym identyfikatorze nie istnieje.


