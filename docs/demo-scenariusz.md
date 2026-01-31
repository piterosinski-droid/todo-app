# Scenariusz demo — TODO Application



### Krok 1 — start aplikacji
- Uruchamiam: pl.put.todo.Main
- Na konsoli pojawia się test modelu oraz test serwisu + persystencji.

### Krok 2 — tworzenie i prezentacja zadania
- Program tworzy Category i SimpleTask
- Wypisuje obiekt (toString)
- Wypisuje wynik serialize()

### Krok 3 — zmiana statusu
- Wywołanie markInProgress()
- Wywołanie markDone()
- Na konsoli widać zmianę statusu

### Krok 4 — zapis i odczyt
- TaskService dodaje zadanie i repozytorium zapisuje do pliku tasks.txt
- Następnie pobieram wszystkie zadania i wypisuję listę

### Krok 5 — obsługa błędu 
- Pokazuję mechanizm wyjątku TaskNotFoundException (np. przy pobraniu/usunięciu nieistniejącego id)
- Wyjaśniam, że to własny wyjątek projektu
