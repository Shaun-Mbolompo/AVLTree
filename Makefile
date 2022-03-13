JAVAC=/usr/bin/javac
.SUFFIXES: .java .class
SRCDIR=src
BINDIR=bin

$(BINDIR)/%.class:$(SRCDIR)/%.java
	$(JAVAC) -d $(BINDIR)/ -cp $(BINDIR) $<

CLASSES= Vaccine.class BinaryTreeNode.class BinaryTree.class BTQueueNode.class BTQueue.class AVLTree.class AVLExperiment.class 
CLASS_FILES=$(CLASSES:%.class=$(BINDIR)/%.class)

default: $(CLASS_FILES)

clean:
	rm $(BINDIR)/*.class

run-experiment: $(CLASS_FILES)
	java -cp bin AVLExperiment 

