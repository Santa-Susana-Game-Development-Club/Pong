# Pong
New Pong for Fall 2016
### Setting Up libGDX Project
1. Run libGDX App Set Up
2. Enter the following information:
```
Name: Pong
Package: com.sshsgd.pong
Game Class: Game
Destination: [Path to Game Dev Folder]\Pong\Project
```
3. Make sure ONLY Desktop is checked in Sub Projects
4. Make sure ONLY Freetype and Controllers are checked in Extensions
5. Make sure ONLY Eclipse is checked in Advanced
6. Click Generate
7. Use Reconmended Build Tools

### Set up Git
Fork this repository.
Copy the .git link on the right hand side of your fork of the repository. Open GitShell and cd to your project's folder. Type in the following commands:
```
git init
git remote add origin https://github.com/[yourusername]/Snake.git
git fetch origin master
git reset --hard FETCH_HEAD
git clean -df
```
From there, you can add the repository to GitHub for desktop and contribute to the repository

### Eclipse Workspace
1. Make an Eclipse Workspace in [Path to Game Dev Folder]\Pong\workspace (NOT IN PROJECT FOLDER)
2. Go to https://marketplace.eclipse.org/content/gradle-sts-integration-eclipse
3. Drag and drop the "Install Button" into Eclipse and let it install
4. Click Import
5. Under Gradle, click Gradle Project
6. Click Next
7. Click Browse and select the Project Folder
8. Click Finish
