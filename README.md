# 🎟️ EvenTopiaApplication

EvenTopia is an Android mobile application developed to simplify event management and digital ticketing.  
Users can browse events, view event details, and generate QR code-based digital tickets directly within the app.

---

## 🚀 Features

- Event listing and detail viewing  
- QR code-based digital ticket generation  
- User-friendly and intuitive interface  
- Modern Android development structure  
- Java-based Android application  

---

## 🛠 Technologies Used

- **Programming Language:** Java  
- **Development Environment:** Android Studio  
- **Architecture:** Android SDK  
- **QR Code Generation:** ZXing Library  
- **Version Control:** Git & GitHub  

---

## 📱 Installation

To run this project on your local machine:

1. Clone the repository:2. Open the Project in Android Studio

After cloning the repository:

Open Android Studio

Click File → Open

Navigate to the folder where the project was cloned

Select the EvenTopiaApplication folder

Click OK to load the project

Android Studio will automatically detect the project structure.

3. Sync Gradle and Build

Once the project is opened:

Android Studio will start syncing Gradle files automatically

Wait until the Gradle build process is completed

If the sync does not start automatically, click Sync Project with Gradle Files from the toolbar

This step downloads all required dependencies and prepares the project for execution.

4. Set Up a Device to Run the App

You can run the application using either an emulator or a real Android device.

Using an Emulator:

Open Device Manager in Android Studio

Create a new Android Virtual Device (AVD) if you don’t already have one

Start the emulator

Using a Physical Device:

Enable Developer Options and USB Debugging on your Android phone

Connect your phone to the computer via USB

Allow USB debugging permission when prompted

5. Run the Application

To launch the application:

Click the Run ▶️ button in Android Studio

Select your emulator or connected device

Wait for the build process to finish

The EvenTopia application should now start on your device.

System Requirements

Android Studio (latest stable version recommended)

Java Development Kit (JDK) 11 or higher

Android SDK

Internet connection for downloading Gradle dependencies

Troubleshooting

If you encounter any problems:

Try Build → Clean Project

Then Build → Rebuild Project

Or reset Android Studio using File → Invalidate Caches / Restart

These steps usually resolve common build and dependency issues.
## 📘 Usage

After launching the application:

1. Browse the list of available events  
2. Select an event to view details  
3. Generate a digital ticket  
4. Use the generated QR code for event entry  

The application provides a simple and user-friendly interface for managing event tickets.

## ⚙ How It Works

- The application uses a fake data source to simulate user authentication  
- After successful login, event details are displayed  
- Users can generate a QR code ticket for the selected event  
- QR codes are generated using the ZXing library  
- All data is currently stored locally for demo purposes
```bash
git clone https://github.com/BilgeAtes/EvenTopiaApplication.git
