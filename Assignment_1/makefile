JC = javac
JFLAGS = -g
JCLASSDIR = bin/
SRC = src/
TEST = test/
JUNITPATH = ./bin/:../lib/junit/junit.jar:../lib/junit/hamcrest_core.jar
DOCPATH = doc/

.SUFFIXES: .java .class
.java.class:
						$(JC) -cp .:./bin -d $(JCLASSDIR) $(JFLAGS) $*.java

CLASSES = $(SRC)BinarySearchTree.java\
					$(SRC)Person.java src/PrintIt.java\
					$(SRC)SearchIt.java\
					$(SRC)SearchItLinear.java

TESTFILES = $(TEST)TestBinarySearchTree.java\
						$(TEST)TestRunner.java\
						$(TEST)TestPerson.java

default: classes compiletests

classes: $(CLASSES:.java=.class)

compiletests:
						$(JC) -cp $(JUNITPATH) -d $(JCLASSDIR) $(TESTFILES)

runtests:
		java -cp $(JUNITPATH) TestRunner

generatedocuments:
		javadoc -d ./doc/ $(CLASSES)

clean:
			$(RM) $(JCLASSDIR)*.class
			$(RM) $(DOCPATH)*
