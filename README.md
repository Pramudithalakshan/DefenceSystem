# 🛡️ DefenceSystem

*A Java Desktop Simulation Project Built with NetBeans (Swing + MVC)*

## 🚀 Overview

**DefenceSystem** is a lightweight Java desktop simulation/game focused on controlling and monitoring three defence vehicles: **Helicopter**, **Tank**, and **Submarine**.
Built with **Swing** using the NetBeans GUI designer, the project follows a simple **MVC-inspired architecture**, separating UI, control logic, and domain model.

This project demonstrates event-driven UI programming, controller–view coordination, sound effects, and object-oriented design concepts.

---

## 🎮 Features

### ✈️ Vehicle Interfaces

Each defence vehicle comes with its own interactive window:

* **Helicopter**
* **Tank**
* **Submarine**

Every vehicle UI includes:

* Dedicated controls
* Animated or timed events
* Sound feedback
* Custom GUI panels designed in NetBeans

### 🎧 Sound Effects

Located under the `/sounds` directory — sounds play on actions such as:

* Starting engines
* Low fuel warnings
* Movement / state changes

### 🧩 MVC Structure

The project is organized into three main layers:

* `view/` — All Swing GUIs (`*.java` + `*.form`)
* `controller/` — Central logic (`Controller.java`)
* `model/` — Observer logic (`MainObserver`, etc.)

The UI communicates with the controller, and the controller triggers model updates.

### 🔔 Observer Pattern

Using **MainObserver**, views can react dynamically to internal state changes, such as:

* Fuel level decreasing
* Engine states
* Alerts / statuses

---

## 📁 Project Structure

```
DefenceSystem/
├── build.xml
├── nbproject/
├── src/
│   ├── view/
│   │   ├── MainController.java
│   │   ├── MainController.form
│   │   ├── Helicopter.java
│   │   ├── Helicopter.form
│   │   ├── Tank.java
│   │   ├── Tank.form
│   │   ├── Submarine.java
│   │   ├── Submarine.form
│   ├── controller/
│   │   └── Controller.java
│   └── model/
│       └── MainObserver.java
└── sounds/
    └── *.wav
```

---

## ▶️ How to Run

### ✔️ Using NetBeans (Recommended)

1. Open NetBeans
2. **File → Open Project**
3. Select the `DefenceSystem` folder
4. Click **Run**

NetBeans automatically handles GUI forms, libraries, and Ant build scripts.

### ✔️ Using Command Line

From the project root:

```
ant
ant run
```

Requires **Ant** and a compatible **JDK (Java 8+)**.

---

## 🏗️ Technologies Used

* **Java (Swing)** — Desktop UI
* **NetBeans / Ant** — Build system & GUI builder
* **Observer Pattern** — Event handling
* **Custom Assets** — UI forms + sound effects

---

## 🎯 Purpose

The goal of this project is to explore:

* OOP principles
* GUI design using NetBeans
* Real-time simulation concepts
* Controller–View communication
* Playing audio in Java
* Designing modular desktop applications

---

## 📌 Future Improvements (Ideas)

* Add animations or smoother motion
* Add a combined dashboard for all vehicles
* Introduce a minimap / radar
* Expand vehicle behaviors
* Score or mission system
* More advanced sound engine
* Game-style difficulty levels

---

## 📝 License

This project is free to use for learning and experimentation.

---

## 🙌 Author

Developed by **Pramuditha Lakshan** as part of learning and exploring Java GUI development.
