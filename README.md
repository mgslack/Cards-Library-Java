# Cards-Library-Java
Cards library framework, includes implementation of Playing Cards

Library was created back in 2001 using Java 1.3, last compiled using Java 6 (may
have been Java 7).  Pulled out and dusted off, updated Ant and compiled using
Java 17 (no source code changes).  Repository includes FindBugs profile and Ant
build script.  If need documentation, will need to generate the javadoc using the
Ant build script.

This library was based off of a library (DLL) created by me for OS/2 and uses the
same images (converted to gif) as was in that DLL.  The Java library was created
to be more of a generic framework and was designed to implement other cards and
card decks in addition to playing cards, which it has an implementation of.  The
C# Playing Card assembly created by me was based off of this library, though made
less generic and only implemented the playing cards portion.

From original readme:

The cards.jar contains several classes and lots of images that emulate playing
cards, card decks and card hands.  Included is a class that will load the images
from the jar and cache them for later use.  The classes/jar was developed and
compiled using java 1.3.  It may not work with earlier versions.

The help is standard javadoc help generated using the Java javadoc tool.

Changes:

--------

2001-08-10 > Added a card value enumeration class (CardEnum) and modified the
             other classes to take advantage of it.  As a consequence, several
             of the statics (constants) defined in the classes were moved or
             removed.
             
2001-08-12 > Changed comparison mode default value in CardHand.

2001-08-13 > Added 'compressHand()' method to CardHand.

2001-09-15 > Added image size constants to the CardImageCache class.

2001-10-10 > Removed 'CardDeckIterator' class and instead converted the CardDeck
             iterator method to return an anonymous inner class.
             
2001-10-11 > Removed no-longer needed protected methods from CardDeck class.

2002-06-23 > Updated the CardImageCache class with a fix if the cache is not
             preload at startup.
             
2004-08-20 > Updated to a new architecture which should allow the creation of other
             types of card decks (for instance UNO, Bridge, etc.).  Includes an
             implementation of regular playing cards.  Updated the card cache
             instance (when loading playing card images) to include a method to
             force the full load of the images.  In addition, updated the build
             to use an ant script.
             
2005-01-05 > Fixed a minor error in card deck and some minor documentation fixes.

2005-03-22 > Added a BSD style license to the cards library for those who need
             a license to use.
             
2005-05-03 > Added a Pinochle deck (based on playingcards) to the library.

2005-05-04 > Added some new images, fixed up Pinochle deck somewhat.

2007-10-14 > Added a new card-back image (Java Duke).

2012-08-08 > Updated the one class that popped up a Findbugs hint.

2014-01-02 > Fixed a bug in the CardHand class.

2021-12-08 > Compiled and built using Java 17 and latest Ant version.  No source
             changes made.
