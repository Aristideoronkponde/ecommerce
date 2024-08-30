## tables 
1.User:stock des infos sur les clients
|Nom de la colone|Type de donnée|Description            |
|----------------|--------------|-----------------------|
|id              |BIGINT        |clé primaire           |
|username        |VARCHAR       |pseudo unique du client|
|email           |VARCHAR       |Email du client        |
|password        |VARCHAR       |MDP du client          |
|create_at       |TIMESTAMPS    |Date de créatiion      |
|update_at       |TIMESTAMPS    |Date de modification   |



2.Products: stock les infos sur les produits
|Nom de la colone|Type de donnée|Description            |
|----------------|--------------|-----------------------|
|id              |BIGINT        |clé primaire           |
|name            |VARCHAR       |pseudo unique du client|
|description     |TEXT          |description du produit |
|stock_qty       |INT           |quantité du stock      |
|create_at       |TIMESTAMPS    |Date de créatiion      |
|update_at       |TIMESTAMPS    |Date de modification   |



3.Orders: stock les infos sur les commandes faotes par les clients

|Nom de la colone|Type de donnée|Description            |
|----------------|--------------|-----------------------|
|id              |BIGINT        |clé primaire           |
|user_id         |BIGINT        |Clé secondaire         |
|total_amount    |DECIMAL       |Montant total          |
|statut          |VARCHAR       |statuts (encour ... )  |
|create_at       |TIMESTAMPS    |Date de créatiion      |
|update_at       |TIMESTAMPS    |Date de modification   |




4.Oder Items: stock les infos sur les produits inclus dans chaque commande
|Nom de la colone|Type de donnée|Description              |
|----------------|--------------|-------------------------|
|id              |BIGINT        |clé primaire             |
|order_id        |BIGINT        |Clé secondaire=>`oders`  |
|product_id      |DECIMAL       |Clé secondaire=>`product`|
|quantity        |INT           |Qté de produits commandée|
|price           |DECIMAL       |prix du produit          |
|create_at       |TIMESTAMPS    |Date de créatiion        |
|update_at       |TIMESTAMPS    |Date de modification     |


## Relations

*`users`->`orders`: un usser peut faire plusieurs commandes
*`orders`->`orders_items`:une commande peut avoir plusieurs items *`product`->`order_items`: un produit peut être commander plusieurs fois

`spring.jpa.hibernate.ddl-auto`:
Cette propriéte est utilisée pour spécifier la stratégie de génèration de schéma de la BDD lors du démarrage de l'application .
Hibernate, l'ORM utilisé par défaut dans Spring Boot , peut automatiquement créer, mettre à jour, valider ou gérer le schéma de la BDd en fonction de cette propriété. 
voici une explication des différentes valeurs qu'on peut attibuer :
1.`none`: Désactive la gestion automatique du schéma par hiernate.Aucune modification du schéma de BDD ne sera effectué au démarrage de l'applicatio.

2.`validate`: Hibernate vérifie que le schéma de la Bdd correspond à la sturcture défine dans les entités JPA . Aucune modification du schéma ne sera effectuée, mais se le schéma est incorreste ou ne correspond pas, une exception est levée

3.`update`: Hibernate met à jour le schema de la BDD pour qu'il corresponde aux entirés JPA définies. cela inclu lèajout de nouvelles tables , colonees,ou contraintes, mais ne supprime ni ne modifie le tables ou colones existantes.

4.`create`: Hibernate supprime le schéma existant et crée un nouveau schéma à patir des entirés JPA définies. Cela implique de perdre toutes les données existantes puisque le schéma est recrée à chaque démarrage de l'application

5.`create-drop`:similaire a `create`, mais avec la particularité signifie que la BDD est recréée a chaque démarrage est supprimée à chaque arrêt de l'application.

## Schéma d'une BDD

Le `schéma` d'une BDD est une représentation de la structure logique des données, incluant des tables, les colones, les relations entre les tables , et les contraintes. Il définit comment les données sont organisées , interconnectés, et gérées pour assurer leur coohérance et intégrité.