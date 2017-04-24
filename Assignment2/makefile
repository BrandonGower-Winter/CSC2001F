JC = javac
JFLAGS = -g
JCLASSDIR = bin/
SRC = src/
TEST = tests/
JUNITPATH = ./bin/:../lib/junit/junit.jar:../lib/junit/hamcrest_core.jar:../packages
DOCPATH = docs/
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
						$(TEST)TestSuite.java\
						$(TEST)TestPerson.java\
						$(TEST)TestAVLTree.java\
						$(TEST)TestBinaryNode.java\
						$(TEST)TestSearchIt.java\
						$(TEST)TestSearchAVL.java

default: classes compiletests

classes: $(CLASSES:.java=.class)

compiletests:
						$(JC) -cp $(JUNITPATH) -d $(JCLASSDIR) $(TESTFILES)

test:
		 java -cp $(JUNITPATH) TestRunner

report:
		java -javaagent:../lib/jacocoagent.jar -cp $(JUNITPATH) TestRunner
		java -cp ../lib/org.jacoco.core-0.7.9.201702052155.jar:../lib/org.jacoco.report-0.7.9.201702052155.jar:../lib/asm-5.0.4.jar:../lib/asm-commons-5.0.4.jar:../lib/asm-tree-5.0.4.jar:../lib/commons-cli-1.3.1.jar:../lib Report --reporttype html -c ./bin -s ./src:./test .

runSearchIt:
		java -cp $(JUNITPATH) SearchIt

runSearchAVL:
		java -cp $(JUNITPATH) SearchAVL

doc:
		javadoc -d ./docs/ $(CLASSES)
		javadoc -d ./docs/ $(PACKAGEFILES)

clean:
			$(RM)r $(JCLASSDIR)*
			$(RM)r $(DOCPATH)*
			$(RM) jacoco.exec
			$(RM)r ./coveragereport/
