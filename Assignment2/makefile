JC = javac
JFLAGS = -g
JCLASSDIR = bin/
SRC = src/
TEST = test/
JUNITPATH = ./bin/:../lib/junit/junit.jar:../lib/junit/hamcrest_core.jar:../packages
DOCPATH = doc/

.SUFFIXES: .java .class
.java.class:
						$(JC) -cp .:./bin:../packages/ -d $(JCLASSDIR) $(JFLAGS) $*.java

CLASSES = $(SRC)Person.java\
					$(SRC)SearchIt.java\
					$(SRC)SearchAVL.java



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

generatedocuments:
		javadoc -d ./doc/ $(CLASSES)

clean:
			$(RM)r $(JCLASSDIR)*
			$(RM) $(DOCPATH)*
