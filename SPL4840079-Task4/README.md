__Antworten zu den Fragen auf dem Aufgabenblatt:__  
Es gab weder Probleme, noch Fehler. Ich habe mich jedoch dazu entschieden, eine redundante Methode zu löschen, die ich in den ersten Aufgaben geschrieben hatte.  
Der Aufwand Plugins zu erstellen hielt sich durch die Größe des Projekts in Grenzen. Bei größeren Projekten scheint es jedoch sinnvoll,  
die Architektur direkt auf Plugins aufzubauen, da das Refactoring das Einzige ist, was Zeit gekostet hat.  
Interfaces musste ich einmal anpassen, da ich zuerst eine Funktion in meinem TweetWindow-Script hatte, welche die Größe des Tweetfensters vergrößert;  
hierfür hatte ich im Interface das TweetWindow mit einer setTweetWindow()-Funktion übergeben. Letztendlich habe ich diese Funktion durch einen Integerwert  
getauscht, welcher die zusätzliche Größe angibt, und die Größe im TweetWindow selbst gesetzt.  
Insgesamt habe ich mich für drei Interfaces entschieden, welche alle die jeweiligen Parent-Knoten der Tiefe 1 meines Models widerspiegeln.  
Anpassungen sollten sich auf das Erweitern des Konstruktors meines TweetWindows beschränken.
