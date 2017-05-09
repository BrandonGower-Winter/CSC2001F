JC = javac
JFLAGS = -g
JCLASSDIR = bin/
SRC = src/
DOCPATH = docs/
PACKAGE = ../packages/BG/DataStructures/Hashes

.SUFFIXES: .java .class
.java.class:
						$(JC) -cp .:./bin:../packages/ -d $(JCLASSDIR) $(JFLAGS) $*.java

CLASSES = $(SRC)Person.java\
					$(SRC)RunHashFunctions.java

PACKAGEFILES = $(PACKAGE)ConstantReturnHash.java\
							 $(PACKAGE)HashFuntion.java\
							 $(PACKAGE)LinearStringASCIIHash.java\
							 $(PACKAGE)ShiftedStringASCIIHash.java\
							 $(PACKAGE)UniversalStringHash.java

default: classes

classes: $(CLASSES:.java=.class)

execute:
				java -cp ./bin:../packages/ RunHashFunctions

doc:
		javadoc -d ./docs/ $(CLASSES)
		javadoc -d ./docs/ $(PACKAGEFILES)

clean:
			$(RM)r $(JCLASSDIR)*
			$(RM)r $(DOCPATH)*
