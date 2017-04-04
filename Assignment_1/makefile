JC = javac
JFLAGS = -g
JCLASSDIR = bin

.SUFFIXES: .java .class
.java.class:
	$(JC) -cp .:./bin -d $(JCLASSDIR)/. $(JFLAGS) $*.java

CLASSES = src/BinarySearchTree.java src/Person.java src/PrintIt.java src/SearchIt.java src/SearchItLinear.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
			$(RM) $(JCLASSDIR)/*.class
