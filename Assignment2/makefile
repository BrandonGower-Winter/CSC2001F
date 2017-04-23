JC = javac
JFLAGS = -g
JCLASSDIR = bin/
SRC = src/
TEST = test/
JUNITPATH = ./bin/:../lib/junit/junit.jar:../lib/junit/hamcrest_core.jar:../packages
DOCPATH = doc/
PACKAGE = ../packages/BG/DataStructures/

.SUFFIXES: .java .class
.java.class:
						$(JC) -cp .:./bin:../packages/ -d $(JCLASSDIR) $(JFLAGS) $*.java

CLASSES = $(SRC)Person.java\
					$(SRC)SearchIt.java\
					$(SRC)SearchAVL.java

PACKAGEFILES = $(PACKAGE)AVLTree.java\
							 $(PACKAGE)BinarySearchTree.java\
							 $(PACKAGE)BinaryNode.java

TESTFILES = $(TEST)TestBinarySearchTree.java\
						$(TEST)TestRunner.java\
						$(TEST)TestPerson.java\
						$(TEST)TestAVLTree.java

default: classes compiletests

classes: $(CLASSES:.java=.class)

compiletests:
						$(JC) -cp $(JUNITPATH) -d $(JCLASSDIR) $(TESTFILES)

runtests:
		java -cp $(JUNITPATH) TestRunner

runSearchIt:
		java -cp $(JUNITPATH) SearchIt

runSearchAVL:
		java -cp $(JUNITPATH) SearchAVL

generatedocuments:
		javadoc -d ./doc/ $(CLASSES)
		javadoc -d ./doc/ $(PACKAGEFILES)

clean:
			$(RM)r $(JCLASSDIR)*
			$(RM)r $(DOCPATH)*
