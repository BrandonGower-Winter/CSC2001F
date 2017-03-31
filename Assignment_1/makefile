JC = javac
JFLAGS = -g
JCLASSDIR = bin

.SUFFIXES: .java .class
.java.class:
	$(JC) -d $(JCLASSDIR)/. $(JFLAGS) $*.java

CLASSES = src/BinarySearchTree.java src/Person.java src/PrintIt.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) $(JCLASSDIR)/*.class