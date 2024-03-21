# E-commerce Kata

Ce projet est un site e-commerce simple réalisé dans le cadre d'un kata.

## Backend (Java)

Le backend est développé en Java et utilise les technologies suivantes :

-Spring Boot : Framework web complet pour la création d'applications microservices.

-Spring Data JPA : Permet la simplification de l'accès aux données via JPA (Java Persistence API).

-Lombok : Bibliothèque permettant de réduire le code boilerplate en Java (getters, setters, etc.).

-H2 Database : Base de données embarquée utilisée pour le développement et les tests.

-Jackson : Bibliothèque de mappage objet-JSON utilisée pour convertir les données de l'API Fakestore en objets Java et vice versa.

Le backend appelle l'API de fakestoreapi.com pour récupérer des produits et les stocke ensuite dans la base de données H2. L'application backend est accessible sur le port 9292 par défaut. Ce port peut être modifié via le fichier application.properties.

Lancement du backend (sous Linux/macOS) :

```bash
mvn spring-boot:run
```

Le port par défaut du backend est défini dans le fichier application.properties. Vous pouvez le modifier en ajoutant la propriété suivante :
```python
server.port=8080  # Remplacez 8080 par le port souhaité
```
## Frontend (Vue.js)
Le frontend est construit avec Vue.js et utilise Vite pour le bundling et le développement.

Installation des dépendances (dans le dossier front) :

```bash
npm install
```

Lancement du serveur:

```bash
npm run dev
```