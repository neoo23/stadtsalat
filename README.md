#STADTSALAT - Coding Challenge

Wir bei STADTSALAT wollen einen URL-Shortener für Salat- und Bowlkonfigurationen ermöglichen.

Dabei sollen möglichst wenig alphanumerische Zeichen in die URL mit einfließen. Es ist wichtig, dass Short-Urls (Slugs) langfristig aufgelöst werden können, da diese über Social Media geteilt werden.

Dein Kollege hat ein ersten Entwurf erstellt, du sollst ihn für eine prototypische Verwendung finalisieren.
Da wir Common Code Ownership leben, refactore den Code gerne so, dass er die Aufgabe erfüllt.
Mache gerne Verbesserungen, die dir sinnvoll erscheinen, sodass der Shortener in Produktion verwendet werden kann.

Ziele der Aufgabe:

* Wunsch Slug: 
  Ein Nutzer soll beim shorten einer URL optional einen Wunschnamen als Slug vergeben können.

* Verbindung zu einem User: 
  Die Nutzertabelle soll verwendet werden und die Verbindung zu einem Nutzer soll hergestellt werden.
  Keine Authentifizierung des Users, wir glauben dem Request für die Nutzer-Assoziation
  Keine API um den User anzulegen (Test-Eintrag in der DB reicht)

* Slug löschen:
  Via eines API Endpunkts, soll ein User seine Slugs wieder löschen können

* Hybride Datenhaltung: 
  Die Slugs sollen hohen Belastungen standhalten. Dafür soll eine geeignete Caching Lösung eingebaut werden. Gleichzeitig müssen die Slugs natürlich persistiert werden.

Für alle Fragen stehen dir deine neuen Kollegen gerne zur Seite!