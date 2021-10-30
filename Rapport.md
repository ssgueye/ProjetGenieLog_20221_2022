![](C:\Users\gueye\OneDrive\Documents\institut-informatique-logo-long.png)
## Master 1: Rapport TP Genie Logicielle 2021/2022
##### Nom: GUEYE
##### Prénom: Serigne Saliou
#### Github: _www.github.com/ssgueye_ 

### I. Notre architecture sytème
Le but de ce TP est d'implémenter des tests unitaires et de faire le refactoring de _Gilded Rose_ (un kata de refactoring).
Pour ce TP, nous avons utilisé l'outil `Gradle` pour compiler notre programme.  
Puisque nous allons se baser que sur des tests, nous allons utiliser la commande test de gradle pour lancer tous les tests:  
`> ./gradlew test`  
D'autres outils très importants nous ont été proposés par `Gradle` afin d'avoir une analyse statistique de nos tests:
* `Jacoco` pour nous guider sur des métriques de couverture des tests
* `Pit` pour nous guider sur les tests de mutations (C'est ici qu'on peut voir si nos tests sont assez robustes ou pas).  

Dans notre dossier de projet nommé GildedRose, nous avons des fichiers pour la configurations de `Gradle` (on va pas perdre du temps pour expliquer tous ces fichiers -:)), ensuite nous avons aussi deux fichers nommés `build` et `src`:
* Dans le fichier `src` se trouvent toutes nos classes java dont notre classe test `GildedRoseTest.java`
* Dans le fichier `build` se trouvent notamment nos fichiers `.class` et les rapports statistiques générés par `Jacoco` et `pit`.  

Avant de terminer cette partie dans laquelle nous vous expliquons l'architecture du projet, nous voulons préciser qu'on a déjà fait un `git init` pour faire un dépôt `Git` du projet.  

### II. Explication des démarches suivies
###**Test unitaire:**  
Puisque ce sont les tests qui nous intéressent plus dans ce projet, donc on n'a pas besoin de la commande de `Gradle` pour lancer le main.  
On a besoin par contre de la commande `./gradlew test` pour lancer nos tests.  
Une fois la commande passe (i.e sans erreur), vous pouvez maintenant lancer la commande `./gradlew jacocoTestReport` pour avoir une analyse statistique des tests(vous allez voir toutes les branches qui ont été couvertes par vos tests).  
Cette commande `./gradlew jacocoTestReport` crée un fichier `index.html`(fichier dans lequel se trouve l'analyse statistique de vos tests).  
Vous pouvez trouver ce fichier à  partir de `build/reports/jacoco/index.html`.  

**Astuce:** _Essayez de mettre en commentaire les tests et les exécuter un par un en générant toujours votre analyse statistique._  

Une fois tous nos tests terminés, on peut vérifier leur robustesse gràce à la commande `./gradlew pitest`. Cette commande génére également un fichier html qui se trouve dans 
`build/reports/pitest/fichier_corrrespondant/index.html`.

###**Refactoring:**  
Nous constatons que notre classe `GildedRose.java` contient une méthode `updateQuality()` qui est très longue et difficile à comprendre.  
Le but de cette partie est de la rendre plus facile à comprendre.
Les commits de notre `git` vous montrent toutes les étapes passées avant d'atteindre notre but.  
Mais nous allons vous faire une briève explication de toutes les étapes:
* Etape 1: Nous avons fait un petit changement sur notre boucle `for` pour le rendre plus facile à manipuler (pour les méthodes que nous allons créer plus tard).
* Etape 2: On crée maintenant une Extract Method nommée `updateItem(item)`. Dans cette méthode, nous avons extrait tout le contenu du `for` de notre méthode `updateQuality()`.
* Etape 3: On a remarqué une duplication de code pour l'incrémentation de la qualité. Donc on crée une méthode `qualityIncreased(item)` pour remplacer ce bout de code dupliqué.
* Etape 4: On a procédé de la même façon que précédemment pour mettre tous les codes dupliqués dans des méthodes. On a créé du coup les méthodes `qualityDecreased(item)`, `sellInDecreased(item)`, `qualityNull(item)` et `nearToExpired(item)`.
* Etape 5: Et maintenant qu'on a réussi à faire de l'Extract Method, on a réécrit la méthode `updateItem(item)` pour spécifier ce que fait chaque produit de Gilded Rose.
* Etape 6:  Et enfin mettre des constantes pour rendre plus explicite certaines valeurs comme le `10` et le `5` pour `SellIn`et le `50` pour `quality`.

**Important:** _N'oubliez pas que chaque étape du refactoring doit être suivie de tests._  

Néanmoins, il est important de savoir que, les tests qui marchaient avant le refactoring, doivent continuer de marcher après le refactoring.  

### III. Commandes utiles
`> ./gradlew test`  
`> ./gradlew jacocoTestReport`  
`> ./gradlew pitest`

