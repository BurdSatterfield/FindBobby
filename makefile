default: Driver.java AdventureMap.java Room.java BackPack.java
	javac Driver.java AdventureMap.java Room.java BackPack.java

run: Driver.class AdventureMap.class Room.class BackPack.class
	java Driver

clean:
	rm -f *.class