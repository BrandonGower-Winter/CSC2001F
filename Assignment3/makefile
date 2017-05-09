JC = javac
JFLAGS = -g
JCLASSDIR = bin/
SRC = src/
TEST = tests/
JUNITPATH = ./bin/:../lib/junit/junit.jar:../lib/junit/hamcrest_core.jar:../packages
DOCPATH = docs/
PACKAGE = ../packages/BG/DataStructures/Hashes

.SUFFIXES: .java .class
.java.class:
						$(JC) -cp .:./bin:../packages/ -d $(JCLASSDIR) $(JFLAGS) $*.java

CLASSES = $(SRC)Person.java\
					$(SRC)SearchIt.java\
					$(SRC)SearchAVL.java

PACKAGEFILES = $(PACKAGE)ConstantReturnHash.java\
							 $(PACKAGE)HashFuntion.java\
							 $(PACKAGE)LinearStringASCIIHash.java\
							 $(PACKAGE)ShiftedStringASCIIHash.java\
							 $(PACKAGE)UniversalStringHash.java

default: classes doc

classes: $(CLASSES:.java=.class)

doc:
		javadoc -d ./docs/ $(CLASSES)
		javadoc -d ./docs/ $(PACKAGEFILES)

clean:
			$(RM)r $(JCLASSDIR)*
			$(RM)r $(DOCPATH)*
