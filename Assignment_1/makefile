JC = javac
JFLAGS = -g
JCLASSDIR = bin/
SRC = src/
JUNITPATH = .:../lib/junit/junit.jar

.SUFFIXES: .java .class
.java.class:
	$(JC) -cp .:./bin -d $(JCLASSDIR). $(JFLAGS) $*.java

CLASSES = $(SRC)BinarySearchTree.java\
					$(SRC)Person.java src/PrintIt.java\
					$(SRC)SearchIt.java\
					$(SRC)SearchItLinear.java

TESTS = test.java

default: classes

classes: $(CLASSES:.java=.class)

test: java -cp $(JUNITPATH) org.junit.runner.JUnitCore $(TESTS)

clean:
			$(RM) $(JCLASSDIR)/*.class
