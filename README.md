🔬 Annual Science Fair Projects (Frontend & Management Console)

This repository contains the front-end code for the Annual Science Fair, divided into two main components: the Public Website (for visitors and participants) and the Management Console (for administrators to perform CRUD operations on project data).

💡 Overview

This project is a two-part system designed to manage and display information for a student science fair:

Main Website (index.html): The landing page provides general information, lists project categories, showcases coordinator videos, includes a basic project submission form, and features interactive elements (Canvas drawing and Geolocation).

Management Console (Linked CRUD Interface): A separate application (referenced via a local link) that enables administrators to Create, Read, Update, and Delete project records using a form and a dynamic table. This console requires a running backend server.

🚀 Key Features

Public Website Features (index.html)

Responsive Navigation: Drop-down menu for accessing sub-pages (Student Details, Rules, Management).

Project Catalog: Static table listing example project groups, titles, and categories.

Multimedia Content: Embedded audio welcome message and video presentations from Group Coordinators.

Interactive Elements: Simple Canvas demonstration and a Geolocation feature to detect and display the user's coordinates.

Project Submission: A basic HTML form for submitting project details (requires a backend to process).

Management Console Features (CRUD Index)

Project CRUD: Interface to add new projects and edit or delete existing ones.

Data Fields: Supports data entry for Project Title, Student Name, Category, Grade Level, Judge's Score, Supervisor, and Project Abstract.

Backend Integration: Designed to interact with a Node.js/MySQL (or similar) backend via API calls (indicated by the form structure and dependency on app.js).

📂 Project Structure

The public-facing website assets are organized as follows:

.
├── index.html          (Main Public Website Landing Page)
├── css/
│   └── style.css       (External stylesheet for layout and styling)
├── assets/
│   ├── imgs/
│   │   └── SciencefairBanner.jpg
│   ├── audio/
│   │   └── Audio.html  (Placeholder for audio file)
│   ├── video/          (Coordinator presentation videos)
│   │   ├── webtech presenter.mp4
│   │   ├── Arctecturepresentor.html.mp4
│   │   └── ... (other video files)
└── pages/
    ├── Studentdetails.html
    ├── project.html
    └── Rulesandcriteria.html


🛠️ Technology Stack

Frontend: HTML5, CSS (Embedded & External style.css), Vanilla JavaScript

Management Console Dependency: HTML/CSS/JS (CRUD interface) which relies on a separate JavaScript file (app.js) and a live backend.

Backend (External): The CRUD functionality links to a local host address (http://127.0.0.1:5501/node-mysql-crud/frontend/index.html), implying dependency on a separate Node.js/Express/MySQL application for data persistence.

▶️ How to Run Locally

1. Public Website (index.html)

The main website is entirely static (with client-side JavaScript features).

Clone this repository.

Open the index.html file directly in your browser by double-clicking it.

2. Management Console (CRUD)

To use the Science Fair Projects Management link in the navigation menu, the linked backend service must be running.

Set up the Backend: Ensure your separate Node/MySQL CRUD application is running and accessible at the specified address (e.g., http://127.0.0.1:5501/node-mysql-crud/frontend/).

Access: Either click the link in the main navigation menu or open the corresponding index.html file for the CRUD console. Note: The CRUD interface will not function without the external API/database.

📝 Troubleshooting & Known Issues

Missing Assets: The site references external files (e.g., style.css, image, and video files in assets/). If these are not present in the correct relative paths, the page will not render fully.

CRUD Link: The navigation link to the management console points to a hardcoded local URL (http://127.0.0.1:5501/...). This must be adjusted if your local server runs on a different port or path.

Audio/Video Sources: Some video sources use .html.mp4 extensions (e.g., Arctecturepresentor.html.mp4), which may be incorrectly named. Verify the actual file extensions if media playback fails.
