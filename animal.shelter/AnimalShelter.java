import java.util.*;

public class AnimalShelter {
	public static void main(String[] args) {
		AdoptionQueue queue = new AdoptionQueue();
		int rank = 0;
		queue.enqueue(getCat(rank++));
		queue.enqueue(getDog(rank++));
		queue.enqueue(getCat(rank++));
		queue.enqueue(getDog(rank++));
		queue.enqueue(getDog(rank++));
		queue.enqueue(getCat(rank++));
		queue.enqueue(getCat(rank++));
		queue.print();
		System.out.println("dequeueAny: " + queue.dequeueAny().type);
		System.out.println("dequeueCat: " + queue.dequeueCat().type);
		System.out.println("dequeueAny: " + queue.dequeueAny().type);
		System.out.println("dequeueAny: " + queue.dequeueAny().type);
		System.out.println("dequeueCat: " + queue.dequeueCat().type);
		System.out.println("dequeueDog: " + queue.dequeueDog().type);
		
	}
	
	static Animal getCat(int rank) {
		return new Animal(AnimalType.CAT, rank);
	}
	
	static Animal getDog(int rank) {
		return new Animal(AnimalType.DOG, rank);
	}
}

class AdoptionQueue {
	LinkedList<Animal> catQueue = new LinkedList<>();
	LinkedList<Animal> dogQueue = new LinkedList<>();
	
	void enqueue(Animal animal) {
		if(animal.type == AnimalType.CAT) {
			catQueue.addFirst(animal);
		} else if (animal.type == AnimalType.DOG) {
			dogQueue.addFirst(animal);
		}
	}
	
	Animal dequeueAny() {
		return dogQueue.peekLast().rank < catQueue.peekLast().rank ? dogQueue.removeLast() : catQueue.removeLast();
	}
	
	Animal dequeueDog() {
		return dogQueue.removeLast();
	}
	
	Animal dequeueCat() {
		return catQueue.removeLast();
	}
	
	void print() {
		System.out.println("======= Q U E U E =====");
		Animal[] dogs = dogQueue.toArray(new Animal[0]);
		Animal[] cats = catQueue.toArray(new Animal[0]);
		
		int d = dogs.length - 1, c = cats.length - 1;
		while(d >= 0 && c >= 0) {
			//System.out.println("dogs[" + d +"].rank: " + dogs[d].rank);
			//System.out.println("cats[" + c +"].rank: " + cats[c].rank);
			if(dogs[d].rank < cats[c].rank) {
				System.out.println(dogs[d].type + " with rank: " + dogs[d].rank);
				d--;
			}
			else {
				System.out.println(cats[c].type + " with rank: " + cats[c].rank);
				c--;
			}
		}
		
		while(d >= 0) {
			System.out.println(dogs[d].type + " with rank: " + dogs[d].rank);
			d--;
		}
		
		while(c >= 0) {
			System.out.println(cats[c].type + " with rank: " + cats[c].rank);
			c--;
		}
		System.out.println("=======================");
	}
}

class Animal {
	AnimalType type;
	int rank;
	
	Animal(AnimalType type, int rank) {
		this.type = type;
		this.rank = rank;
	}
}

enum AnimalType {
	CAT, DOG
}