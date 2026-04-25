⚡ EVMP & EMMA — Energy-Efficient VM Placement for Cloud Data Centers
> Mémoire de Master — Implémentation Java des algorithmes EVMP et EMMA pour l'efficacité énergétique dans les Data Centers Cloud.
---
📄 Résumé
Les Data Centers consomment d'énormes quantités d'énergie, entraînant des coûts élevés et des émissions massives de CO₂. Ce projet propose deux algorithmes complémentaires pour optimiser le placement des machines virtuelles (VMs) dans un environnement Cloud IaaS, en tenant compte de contraintes multidimensionnelles (CPU, RAM, bande passante réseau).
EVMP (Energy-Efficient Virtual Machine Placement) — Algorithme d'allocation statique initiale des VMs sur les serveurs physiques.
EMMA (Energy-Efficient Minimization Migration Algorithm) — Algorithme de migration dynamique des VMs pour maintenir l'équilibre et réduire la consommation d'énergie.
---
🏗️ Architecture du Projet
```
EVMP-EMMA/
├── src/
│   └── com/EVMP/EMMA/
│       ├── EVMP_EMMA.java      # Algorithmes principaux EVMP & EMMA
│       ├── VM.java             # Classe Machine Virtuelle
│       └── Server.java         # Classe Serveur Physique
├── docs/
│   └── memoire.pdf             # Mémoire complet (optionnel)
├── README.md
└── .gitignore
```
---
⚙️ Algorithmes
🔹 EVMP — Placement Initial
L'algorithme sélectionne le serveur physique optimal pour chaque VM selon un critère de sélection SMᵢ combinant :
IUVᵢ — Déséquilibre d'utilisation multi-dimensionnelle des ressources
P(u) — Consommation énergétique du serveur
```
SMᵢ = w₁ × IUVᵢ + w₂ × P(uᵢ)     avec w₁ + w₂ = 1
```
Le serveur avec le SMᵢ minimal est sélectionné pour héberger la VM.
🔹 EMMA — Migration Dynamique
L'algorithme surveille en continu l'utilisation des serveurs et applique deux règles :
Condition	Action
Utilisation > Seuil haut	Migrer le minimum de VMs pour réduire la charge
Utilisation < Seuil bas	Migrer toutes les VMs et mettre le serveur en veille (sleep)
🔹 Modèle Énergétique
```
P(u) = k × Pmax + (1 - k) × Pmax × u

E = ∫[t0→t1] P(u(t)) dt
```
Où `u` est le taux d'utilisation CPU, `Pmax` la puissance maximale, et `k` la proportion de consommation au repos.
---
📊 Métriques Évaluées
Métrique	Description
Énergie totale (Pᵢ)	Consommation électrique du Data Center
IRᵢ	Utilisation moyenne des ressources (CPU, RAM, NET)
IUVᵢ	Déséquilibre multi-dimensionnel d'utilisation
SMᵢ	Critère de sélection combiné
SLA Violation	Pourcentage de violation des accords de service
---
🖥️ Environnement de Simulation
Types de Serveurs Physiques
Type	CPU (MIPS)	Mémoire (GB)	Réseau (Mbit/s)
1	1000	8	50
2	2000	16	100
3	3000	24	150
Types de Machines Virtuelles
Type	CPU (MIPS)	Mémoire (GB)	Réseau (Mbit/s)
1	100	1	10
2	200	1	20
3	300	2	10
4	400	4	40
---
🚀 Lancement du Projet
Prérequis
Java JDK 8+
IDE Eclipse (recommandé) ou tout autre IDE Java
Cloner le dépôt
```bash
git clone https://github.com/USERNAME/EVMP-EMMA.git
cd EVMP-EMMA
```
Compiler et exécuter
```bash
# Avec Maven
mvn compile
mvn exec:java -Dexec.mainClass="com.EVMP.EMMA.Main"

# Ou directement avec javac
javac src/com/EVMP/EMMA/*.java
java -cp src com.EVMP.EMMA.Main
```
---
📚 Structure du Mémoire
Chapitre	Contenu
Chapitre 1	Concepts des Data Centers, virtualisation et Cloud Computing (IaaS, PaaS, SaaS)
Chapitre 2	Problème de placement de VMs, migration, efficacité énergétique, modèles et algorithmes
Chapitre 3	Implémentation Java (Eclipse), expériences et résultats
---
📖 Références
Lin X., Liu Z., Guo W. (2015). Energy-Efficient VM Placement Algorithms for Cloud Data Center. CloudCom-Asia 2015, LNCS 9106, pp. 42–54. DOI: 10.1007/978-3-319-28430-9_4
Beloglazov A., Abawajy J., Buyya R. (2012). Energy-aware resource allocation heuristics for efficient management of data centers for cloud computing. Future Generation Computer Systems, 28(5), 755–768.
Li H. et al. (2013). Energy-aware scheduling scheme using workload-aware consolidation technique in cloud data centres. China Communications, 10, 114–124.
---
🔑 Mots-clés
`Cloud Computing` · `Data Center` · `VM Placement` · `Energy Efficiency` · `Virtual Machine Migration` · `IaaS` · `QoS` · `Java`
---
👤 Auteur
Mohaned
Mémoire de Master — Informatique
