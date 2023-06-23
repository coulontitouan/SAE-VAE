#!/bin/bash                                                                     

#Ce script permet d'ouvrir le pendu                                             
javac -d bin --module-path /usr/share/openjfx/lib/ --add-modules javafx.controls,javafx.swing src/*.java src/Exceptions/*.java
java -cp bin:img:/usr/share/java/mariadb-java-client.jar --module-path /usr/share/openjfx/lib/ --add-modules javafx.controls,javafx.swing VAE
