package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
	
	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;

	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		Publisher nature = new Publisher("Nature Publishing Group", "One New York Plaza, Suite 4500", "New York City", "New York", "100041562");
		Author eric = new Author("Eric", "Evans");
		Book ddd = new Book("Domain-Driven Design", "9780321125217");
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		nature.getBooks().add(ddd);
		
		authorRepository.save(eric);
		bookRepository.save(ddd);
		
		Author rod = new Author("Rod", "Johnson");
		Book noEJB = new Book("J2EE Development without EJB", "9780470332962");
		rod.getBooks().add(noEJB);
		noEJB.getAuthors().add(rod);
		nature.getBooks().add(noEJB);
		
		authorRepository.save(rod);
		bookRepository.save(noEJB);
		publisherRepository.save(nature);
		
		System.out.println("Started in Bootstrap");
		System.out.println("Number of Publishers: " + publisherRepository.count());
		System.out.println("Number of Books: " + bookRepository.count());
		System.out.println("Number of books published by Nature Publishing Group: " + nature.getBooks().size());
		
	}
}
