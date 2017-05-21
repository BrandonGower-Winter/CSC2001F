JC = javac
JFLAGS = -g
JCLASSDIR = bin/
SRC = src/
DOCPATH = docs/
PACKAGE = ../packages/BG/

.SUFFIXES: .java .class
.java.class:
						$(JC) -cp .:./bin:../packages/ -d $(JCLASSDIR) $(JFLAGS) $*.java

CLASSES = $(SRC)Person.java\
					$(SRC)RunHashFunctions.java

PACKAGEFILES = $(PACKAGE)DataStructures/Hashes/ConstantReturnHash.java\
							 $(PACKAGE)DataStructures/Hashes/HashFunction.java\
							 $(PACKAGE)DataStructures/Hashes/LinearStringASCIIHash.java\
							 $(PACKAGE)DataStructures/Hashes/ShiftedStringASCIIHash.java\
							 $(PACKAGE)DataStructures/Hashes/UniversalStringHash.java\
							 $(PACKAGE)Util/HashEntropy.java

default: classes doc

classes: $(CLASSES:.java=.class)

execute:
				java -cp ./bin:../packages/ RunHashFunctions

doc:
		javadoc -cp ./bin:../packages/ -d ./docs/ $(CLASSES)
		javadoc -cp ./bin:../packages/ -d ./docs/ $(PACKAGEFILES)

clean:
			$(RM)r $(JCLASSDIR)*
			$(RM)r $(DOCPATH)*
