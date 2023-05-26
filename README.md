# tp_sma_algorithme_genetique

Le travail concernant l'implémentation de l'algorithme génétique avec les islands se trouve dans le packages ma.enset.ga_string_sma

L'algorithme génétique avec les îles, également connu sous le nom d'algorithme génétique parallèle, est une variante de l'algorithme génétique classique qui vise à améliorer les performances et la diversité des solutions.

Dans un algorithme génétique traditionnel, une seule population d'individus évolue au fil des générations pour trouver la meilleure solution possible. Cependant, cette approche peut parfois entraîner une convergence prématurée vers un optimum local, limitant ainsi l'exploration de l'espace des solutions.

L'idée principale derrière l'algorithme génétique avec les îles est de créer plusieurs sous-populations indépendantes, appelées "îles", qui évoluent simultanément. Chaque île a sa propre population d'individus et effectue des opérations génétiques (sélection, croisement, mutation) de manière autonome.

Périodiquement, des individus sélectionnés parmi les meilleures solutions de chaque île sont échangés avec d'autres îles. Cela permet de transférer des informations génétiques entre les îles, favorisant ainsi l'exploration de différentes régions de l'espace des solutions.

# Implémentation de l'algorithme

Pour l'implémentation de l'algorithme nous avons crée 2 agents principales :
  # L'agent Island
