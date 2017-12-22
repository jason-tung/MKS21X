# MKS21X -- formerly "javadog"
javadog is my apcs repo written in java!


feel free to look through my (really bad) labs

### regarding my "notes"
~~my notes written on a blank txt file -- feel free to look through them~~

my notes are a historical archive of a time when I wrote about three lines of "notes" for a full lecture -- i use a notebook now


## **Lab Overview**

### 00n/a
there was no lab 0 -- this just relieves my 0-index anxiety

### 01SuperArray
* basic reconstruction of ArrayList<String>
* binary search algo

### 02OrderedSuperArray
* blueprint for an alphabetized SuperArray
* extends SuperArray.java from lab01
* throw exception
* used binary search insertionSort to add strings into the right place

### 03WordSearch
* made a wordsearch in the terminal using text from another file
* taking arguments from terminal
* file scanning and reading
* try except blocks -- i absolutely abused these to avoid hard coding cases
* Math.random()
* random.nextInt()
* consistency in random-seeds

### 04ReverseCharSequence
* String methods, but treated the String as if it were reversed
* implementation of interfaces(CharSequence)

### 05Library
* system by which books in a library can be classified and checked out by people, as well as display information on the book
* implements Comparable
* extending different types of books from each other

### 06SuperArrayIterator
* makes SuperArray from lab01 an Iterable object
* made an Iterator
* implements Iterator, Iterable

### 07Barcode
* converts a zip into a barcode & has static methods to convert the zips and barcodes into each other
* implements Comparable

### 08Sorts
* variety of sorting algos
* selectionSort
  * finds min value and swaps it to the first unsorted spot
* insertionSort
  * sorts the next element of the set into the previously sorted set (starting from ary[0] as sorted)
* bubbleSort
  * takes each element and moves it until it reaches the last sorted element or a number greater than itself
### 09GUI
* gui window converting between celcius and farenheit
* extends JFrame
* implements EventsListener
* uses swing and awt

