# TP 2 – Gestion des produits avec Spring Boot, JPA et H2

## 📌 Description du projet

Ce projet consiste à développer une application de gestion des produits avec **Spring Boot**, **Spring Data JPA** et **H2 Database**.

L'application permet d'effectuer les opérations CRUD (Create, Read, Update, Delete) sur les produits.

## 🛠️ Technologies utilisées

- Java 21
- Spring Boot
- Spring Data JPA
- Spring Web
- H2 Database
- Lombok
- Maven
- IntelliJ IDEA Ultimate

## 📂 Structure du projet

```text
activite2/
│
├── src/
│   └── main/
│       ├── java/
│       │   └── org/benaounia/activite2/
│       │       ├── entities/
│       │       │   └── Product.java
│       │       │
│       │       ├── repository/
│       │       │   └── ProductRepository.java
│       │       │
│       │       ├── web/
│       │       │   └── ProductRestController.java
│       │       │
│       │       └── Activite2Application.java
│       │
│       └── resources/
│           └── application.properties
│
├── pom.xml
└── README.md
```

## 📦 Entité Product

L'entité `Product` contient les attributs suivants :

| Attribut | Type |
|---|---|
| id | Long |
| name | String |
| price | double |
| quantity | int |

Les annotations JPA et Lombok sont utilisées pour faciliter la gestion de l'entité.

## 🗄️ Configuration de la base de données

Le projet utilise H2 Database comme base de données en mémoire.

Configuration dans `application.properties` :

```properties
spring.datasource.url=jdbc:h2:mem:products-db
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```

## 🔍 Repository

L'interface `ProductRepository` étend `JpaRepository<Product, Long>`.

Elle permet d'utiliser les méthodes suivantes :

- `save()` : ajouter ou modifier un produit.
- `findAll()` : récupérer tous les produits.
- `findById()` : rechercher un produit par son identifiant.
- `deleteById()` : supprimer un produit.
- `findByNameContainsIgnoreCase()` : rechercher un produit par son nom.
- `@Query` : effectuer une recherche personnalisée avec JPQL.

## 🚀 Fonctionnalités

L'application permet de réaliser les opérations suivantes :

1. Ajouter un produit.
2. Consulter tous les produits.
3. Consulter un produit par son ID.
4. Rechercher des produits par nom.
5. Modifier un produit.
6. Supprimer un produit.

## 🌐 API REST

Les endpoints disponibles :

| Méthode HTTP | URL | Description |
|---|---|---|
| POST | `/products` | Ajouter un produit |
| GET | `/products` | Consulter tous les produits |
| GET | `/products/{id}` | Consulter un produit |
| GET | `/products/search/{kw}` | Rechercher par nom |
| PUT | `/products/{id}` | Modifier un produit |
| DELETE | `/products/{id}` | Supprimer un produit |

## 🧪 Exemple d'ajout d'un produit

**POST** `/products`

Body JSON :

```json
{
  "name": "PC HP",
  "price": 7500,
  "quantity": 10
}
```

## ▶️ Lancement du projet

1. Cloner le repository :

```bash
git clone URL_DU_REPOSITORY
```

2. Ouvrir le projet dans IntelliJ IDEA Ultimate.

3. Attendre le téléchargement des dépendances Maven.

4. Exécuter la classe `Activite2Application.java`.

5. L'application démarre sur :

```text
http://localhost:8080
```

## 🗃️ Console H2

Accéder à la console H2 :

```text
http://localhost:8080/h2-console
```

Informations de connexion :

- JDBC URL : `jdbc:h2:mem:products-db`
- Username : `sa`
- Password : vide

## 🎯 Objectifs pédagogiques

Ce TP permet de comprendre :

- La création d'un projet Spring Boot avec Spring Initializr.
- La création et la configuration d'une entité JPA.
- La configuration d'une base de données H2.
- L'utilisation de Spring Data JPA.
- La création d'un Repository.
- L'utilisation des requêtes JPQL.
- La création d'une API REST.
- La réalisation des opérations CRUD.

---

**Projet réalisé dans le cadre des travaux pratiques en développement Java et Spring Boot.**
