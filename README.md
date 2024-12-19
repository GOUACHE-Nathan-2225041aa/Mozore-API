# Documentation de l'API des Revues de films

Cette API permet de gérer les revues de films, incluant la création, la récupération, la mise à jour et la suppression des revues.

## Endpoints

### 1. Créer une revue

**Méthode** : `POST`  
**URL** : `/revues`  
**Description** : Crée une nouvelle revue de film.  
**Paramètres** :
- `titre_film` (string) : Titre du film.
- `image_film` (string) : URL de l'image du film.
- `contenu_revue` (string) : Contenu de la revue.
- `note` (float) : Note attribuée au film.

**Exemple de requête** :

```bash
curl -X POST http://10.203.28.121:42069/revues \
-H "Content-Type: application/json" \
-d '{"titre_film": "Inception", "image_film": "http://image.url", "contenu_revue": "Excellent!", "note": 4.5}'
```

**Réponse** :

```json
{
    "_id": "676042f9df19e53e0db68a6e",
    "titre_film": "Inception",
    "image_film": "http://image.url",
    "contenu_revue": "Excellent!",
    "note": 4.5
}
```

### 2. Récupérer toutes les revues triées par titre

**Méthode** : `GET`  
**URL** : `/revues/par-titre`  
**Description** : Récupère toutes les revues, triées par titre de manière croissante.

**Exemple de requête** :

```bash
curl -X GET http://10.203.28.121:42069/revues/par-titre
```

**Réponse** :

```json
[
    {
        "_id": "676042f9df19e53e0db68a6e",
        "titre_film": "Inception",
        "image_film": "http://image.url",
        "contenu_revue": "Excellent!",
        "note": 4.5
    },
    {
        "_id": "676042f9df19e53e0db68a6f",
        "titre_film": "The Dark Knight",
        "image_film": "http://image.url",
        "contenu_revue": "Superb!",
        "note": 5.0
    }
]
```

### 3. Récupérer toutes les revues triées par note

**Méthode** : `GET`  
**URL** : `/revues/par-note`  
**Description** : Récupère toutes les revues, triées par note de manière décroissante.

**Exemple de requête** :

```bash
curl -X GET http://10.203.28.121:42069/revues/par-note
```

**Réponse** :

```json
[
    {
        "_id": "676042f9df19e53e0db68a6f",
        "titre_film": "The Dark Knight",
        "image_film": "http://image.url",
        "contenu_revue": "Superb!",
        "note": 5.0
    },
    {
        "_id": "676042f9df19e53e0db68a6e",
        "titre_film": "Inception",
        "image_film": "http://image.url",
        "contenu_revue": "Excellent!",
        "note": 4.5
    }
]
```

### 4. Récupérer une revue par son ID

**Méthode** : `GET`  
**URL** : `/revues/{id}`  
**Description** : Récupère une revue spécifique en fonction de son ID.  
**Paramètres** :
- `id` (string) : ID de la revue.

**Exemple de requête** :

```bash
curl -X GET http://10.203.28.121:42069/revues/676042f9df19e53e0db68a6e
```

**Réponse** :

```json
{
    "_id": "676042f9df19e53e0db68a6e",
    "titre_film": "Inception",
    "image_film": "http://image.url",
    "contenu_revue": "Excellent!",
    "note": 4.5
}
```

### 5. Mettre à jour une revue existante

**Méthode** : `PUT`  
**URL** : `/revues/{id}`  
**Description** : Modifie une revue existante en utilisant son ID.  
**Paramètres** :
- `id` (string) : ID de la revue.
- `titre_film` (string) : Nouveau titre du film.
- `image_film` (string) : Nouvelle URL de l'image du film.
- `contenu_revue` (string) : Nouveau contenu de la revue.
- `note` (float) : Nouvelle note attribuée au film.

**Exemple de requête** :

```bash
curl -X PUT http://10.203.28.121:42069/revues/676042f9df19e53e0db68a6e \
-H "Content-Type: application/json" \
-d '{"titre_film": "Inception Updated", "image_film": "http://newimage.url", "contenu_revue": "Encore meilleur!", "note": 5.0}'
```

**Réponse** :

```json
{
    "_id": "676042f9df19e53e0db68a6e",
    "titre_film": "Inception Updated",
    "image_film": "http://newimage.url",
    "contenu_revue": "Encore meilleur!",
    "note": 5.0
}
```

### 6. Supprimer une revue

**Méthode** : `DELETE`  
**URL** : `/revues/{id}`  
**Description** : Supprime une revue en fonction de son ID.  
**Paramètres** :
- `id` (string) : ID de la revue.

**Exemple de requête** :

```bash
curl -X DELETE http://10.203.28.121:42069/revues/676042f9df19e53e0db68a6e
```

**Réponse** :

```json
{
    "message": "Revue supprimée avec succès"
}
```

## Personnalisation

### 1. Adresse IP

Pour changer l'IP et le port de déploiement de l'API sur ce PC, vous pouvez changer les paramètres dans le fichier ```application.properties``` :

#### Exemple :
```
server.address=0.0.0.0
server.port=42069
```

### 2. Base de données

Pour changer le serveur et la base de données utilisés pour stocker les données, vous pouvez modifier les paramètres dans le fichier ```application.properties``` :

#### Exemple :
```
spring.data.mongodb.uri=mongodb+srv://leperliermael:yKu6JD7MKpnqrBGn@cluster0.8ligg.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0
spring.data.mongodb.database=RevuesFilm
```