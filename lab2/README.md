## LAB 3
![img.png](img.png)

## Kompilacja z konsoli
```
javac -cp sciezka/do/jade.jar HelloWorldAgent.java
```
## Odpalanie skompilowanych plikow w konsoli
```
java -cp sciezka/do/jade.jar jade.Boot -gui NazwaAgentaWKontenerze:NazwaKlasyKtoraSkompilowalismy
```
## Przykład gdy mamy wszystkie pliki w jednym folderze
```
javac -cp jade.jar HelloWorldAgent.java
java -cp jade.jar jade.Boot -gui Agent1:HelloWorldAgent
```
