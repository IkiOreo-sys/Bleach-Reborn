# Bleach-Reborn
Hello, I am new to modding, I am also not the best at java, still somewhat new. I have been coding for a year now in general though, not all of it was java. I picked up Bleach Reborn development from a friend who no longer has time, I am still learning and haven't added a whole lot to the mod. So I decided to open source the mods so people can read source code and pick out the bugs I can't and also make contributions!

I am also new to github, so if things are badly organized or whatever it may be, I will glady take the criticism.

Want to learn how to commit? 
Follow the instructions below!

Windows:
1. Download JDK 8. 
    https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html
2. Set path variables, go to windows search bar, type path. Click on the result "Edit the system environment variables"
    Click Environment Variables, on the Environment Variables window, on the bottom section under "System variables" click new.
     Set Variable name to Path.
      find your java directory, should look something like this "C:\Program Files\Java\jdk1.8.0_281\bin" put that path in your system variables
3. Download Eclipse.
    https://www.eclipse.org/downloads
4. Create a directory for Bleach Reborn wherever you decide you want to use for your Eclipse workspace.
5. Download zip from Github and exctract the contents from that into your Bleach Reborn folder you just created.
6. Open Command Prompt and run the following commands
    Enter directory:
    cd C:\Users\User\Desktop\<Eclipse Workspace>\Bleach
    
    Setup Gradle:
     gradlew setupDecompWorkspace
    
     gradlew eclipse
     
7. Open Project in Eclipse by clicking File at the top right and clicking "Open Projects from File System" and then select the directory of the mod and that should open it.

Don't know much about minecraft modding? Well reading documentation and looking at example mods helps tremendously, knowing basic coding already also really helps.
You can run minecraft by typing "Gradlew runClient" in command prompt 

Wanna join the anarchy server? Well, you can join it by downloading the mod off of curseforge and joining this IP 66.248.192.151:25565
