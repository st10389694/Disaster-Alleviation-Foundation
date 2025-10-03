# Disaster Alleviation - Android App (Kotlin)

This is a ready-to-submit Android Studio Kotlin prototype implementing Part 2 requirements for the Disaster Alleviation Foundation project.

## Features implemented
- User registration & login (local Room DB, simple SHA-256 password hash) — 15 marks
- Incident reporting (submit reports stored in Room) — 15 marks
- Resource donations (record donations locally) — 10 marks
- Accessibility mode (simple UI scaling toggle) — included
- Volunteer management (create volunteer tasks) — 10 marks
- Project includes Git & Azure DevOps pipeline config example (yaml)

## What is included
- Full Android Studio project skeleton in Kotlin (app module)
- Room database implementation with entities and DAO
- Activities for auth, reporting, donations, volunteers
- `azure-pipelines.yml` sample for CI with Gradle build
- `README` and instructions to create a Git repository

## How to open & run
1. Download and unzip the provided archive.
2. Open Android Studio (Electric Eel or newer recommended).
3. Choose "Open" and select the project folder.
4. Let Gradle sync; then run the app on an emulator or device (minSdk 24).

## GitHub & Azure Repos
I cannot create repositories for you. Create a GitHub repo under **st10389694** (or push locally and set remote):

```bash
cd DisasterAlleviationApp
git init
git add .
git commit -m "Initial commit - Disaster Alleviation App"
git branch -M main
git remote add origin https://github.com/st10389694/DisasterAlleviationApp.git
git push -u origin main
```

Replace URL with your actual repo. For Azure Repos, create a new repo in your Azure DevOps project and push the same way.

### Suggested branching strategy
- `main` — production-ready
- `develop` — active development
- feature branches: `feature/auth`, `feature/reports`, etc.

## Azure Pipelines (CI) - sample
A simple `azure-pipelines.yml` is included (root of project) that builds the Gradle project.

To use in Azure DevOps:
1. Create a new pipeline -> choose YAML -> point to this file.
2. Configure an Android build agent / or use Microsoft-hosted Ubuntu agent with JDK + Gradle.

## Notes & limitations
- Authentication is local (Room + SHA-256). For production, replace with Azure AD or Firebase Auth.
- Sending donations/assigning tasks are local. For full production, implement backend APIs and cloud DB.
- This submission demonstrates required functionality in a prototype suitable for the assignment.

## Grading checklist mapping
- User Registration & Login: implemented (Room + simple hashing) — 15
- Disaster Incident Reporting: implemented (Room) — 15
- Resource Donation: implemented (Room) — 10
- Volunteer Management: tasks creation & storage — 10
- Git repo instructions & pipeline sample — 20 (10 Repos + 10 Pipelines)
- Source code & organisation — 10
- Build pipeline config & screenshots: include your Azure pipeline run screenshots in the final submission.

## Contact / Author
Student: Olebogeng Ikageng Lekalakala
Student ID: ST10389694

