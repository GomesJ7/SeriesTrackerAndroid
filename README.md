# SeriesTracker

C'est une application Android permettant de lister les séries TV les plus populaires, développée dans le cadre du cours de Développement Mobile Android (ESEO-S8).

## Aperçu

| Chargement | Liste des séries | Erreur réseau |
|:-----------:|:----------------:|:-------------:|
| *(capture à venir)* | *(capture à venir)* | *(capture à venir)* |

## Stack technique

- **Kotlin** + **Jetpack Compose** — interface utilisateur
- **Retrofit** + **Gson** — appels réseau et parsing JSON
- **Dagger-Hilt** — injection de dépendances
- **Coil** — chargement des images
- **ViewModel** + **StateFlow** — gestion de l'état (architecture MVVM)

## API utilisée

[EpisoDate](https://www.episodate.com/api) — `GET https://www.episodate.com/api/most-popular?page=1`

## Lancer le projet

### Prérequis

- Android Studio Hedgehog ou supérieur
- JDK 11
- Android SDK 26+

### Étapes

1. Cloner le dépôt :
   ```bash
   git clone https://github.com/GomesJ7/SeriesTrackerProject.git
   ```
2. Ouvrir le dossier `SeriesTrackerProject` dans Android Studio
3. Faire **Sync Project with Gradle Files**
4. Lancer l'application sur un émulateur ou un appareil physique (API 26 minimum)

### Installer l'APK directement

Un APK debug est disponible dans le dossier [`/apk`](./apk).

```bash
adb install apk/app-debug.apk
```

## Architecture

```
fr.eseo.seriestracker
├── di/                  # Module Hilt (NetworkModule)
├── model/               # DTOs et modèle métier (TvShowDto, TvShow)
├── network/             # Interface Retrofit (SeriesApi)
├── repository/          # Couche données (SeriesRepository)
├── ui/                  # Composables et ViewModel
│   ├── EcranAccueil.kt
│   ├── CarteSerie.kt
│   ├── PopulairesViewModel.kt
│   └── theme/           # Couleurs, typographie, thème
└── MainActivity.kt
```

## Auteurs

Projet réalisé par **Manassé PASSI DE MANDA**, **Jean GOMES** et **Adam KALAA** 
ESEO 2025-2026
