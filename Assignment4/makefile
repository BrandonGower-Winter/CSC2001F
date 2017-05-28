JC = javac
JFLAGS = -g
JCLASSDIR = bin/
SRC = src/
TEST = tests/
JUNITPATH = ./bin/:../lib/junit/junit.jar:../lib/junit/hamcrest_core.jar:../packages
DOCPATH = docs/

.SUFFIXES: .java .class
.java.class:
						$(JC) -cp .:./bin:../packages/ -d $(JCLASSDIR) $(JFLAGS) $*.java

CLASSES = $(SRC)AdvancedGraphNode.java\
					$(SRC)Hospital.java\
					$(SRC)Ambulance.java\
					$(SRC)Victim.java\
					$(SRC)TrafficIncident.java\
					$(SRC)AdvancedPathSet.java\
					$(SRC)AdvancedHospitalGraph.java\
					$(SRC)SimulatorTwo.java

default: classes

classes: $(CLASSES:.java=.class)

runTwo:
			java -cp ./bin/ SimulatorTwo

clean:
			$(RM)r $(JCLASSDIR)*
