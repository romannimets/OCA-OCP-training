package designPatternsAndPrinciples;

import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

import designPatternsAndPrinciples.classes.AllenatoreLama;
import designPatternsAndPrinciples.classes.Animale2;
import designPatternsAndPrinciples.classes.AnimaleImmutabile;
import designPatternsAndPrinciples.classes.Aquila;
import designPatternsAndPrinciples.classes.Balena;
import designPatternsAndPrinciples.classes.Delfino;
import designPatternsAndPrinciples.classes.DepositoFienoSingleton;
import designPatternsAndPrinciples.classes.Lemure;
import designPatternsAndPrinciples.classes.Leone;
import designPatternsAndPrinciples.classes.Oceanografo;
import designPatternsAndPrinciples.classes.Primate;
import designPatternsAndPrinciples.classes.Rana;
import designPatternsAndPrinciples.classes.Tigre;
import designPatternsAndPrinciples.interfaces.CheckCaratteristica;
import designPatternsAndPrinciples.interfaces.HaLaCoda;
import designPatternsAndPrinciples.interfaces.Volo;
import utils.Colors;

public class RUN_DesignPatternAndPrinciples {
	public static void main(String[] args) {
		// Design Patterns and Principles
		System.out.println("	" + Colors.BLUE_BACKGROUND_BRIGHT.get() + Colors.BLACK_UNDERLINED.get()
				+ Colors.BLACK_BOLD.get() + "Design Patterns and Principles" + Colors.RESET.get());
		// Using Variables in Lambdas
		System.out.println("\n" + Colors.WHITE_BACKGROUND_BRIGHT.get() + Colors.BLACK_BOLD.get()
				+ "Designing an Interface" + Colors.RESET.get());

		// Creazione di un'istanza di Aquila e chiamata dei suoi metodi
		Aquila aquila = new Aquila(); // vedi impl.
		try {
			int aperturaAlareAquila = aquila.getAperturaAlare();
			System.out.println("Apertura alare dell'aquila: " + aperturaAlareAquila);

			aquila.atterra();
			//
		} catch (Exception e) {
			System.err.println("Errore durante la chiamata del metodo getAperturaAlare: " + e.getMessage());
		}

		// Creazione di un'istanza di Leone e chiamata dei suoi metodi
		Leone leone = new Leone(); // vedi impl.
		boolean quadrupedeLeone = leone.isQuadrupede();
		boolean cacciareCorrendoLeone = leone.puoCacciareCorrendo();
		double maxVelocitaLeone = leone.getMaxVelocita();

		System.out.println("Il leone è quadrupede? " + quadrupedeLeone);
		System.out.println("Il leone può cacciare correndo? " + cacciareCorrendoLeone);
		System.out.println("Velocità massima del leone: " + maxVelocitaLeone);

		// Chiamata del metodo statico calcolaVelocita direttamente dall'interfaccia
		float spazio = 500;
		double tempo = 5;
		double velocitaCalcolata = Volo.calcolaVelocita(spazio, tempo);

		System.out.println("Velocità calcolata: " + velocitaCalcolata);

		// Una classe può anche implementare più interfacce:
		Rana rana = new Rana(); // vedi impl.
		rana.salta();
		rana.nuota();
		System.out.println("Velocità massima della rana: " + rana.getMaxVelocita());
		System.out.println("La rana è un quadrupede: " + rana.isQuadrupede());

		// Defining a Functional Interface
		System.out.println("\n" + Colors.WHITE_BACKGROUND_BRIGHT.get() + Colors.BLACK_BOLD.get()
				+ "Defining a Functional Interface" + Colors.RESET.get());

		Tigre tigre = new Tigre(); // v.impl
		tigre.scatta(new Rana());
		tigre.scatta(new Aquila());

		// Implementing Functional Interfaces with Lambdas
		System.out.println("\n" + Colors.WHITE_BACKGROUND_BRIGHT.get() + Colors.BLACK_BOLD.get()
				+ "Implementing Functional Interfaces with Lambdas" + Colors.RESET.get());

		// v.impl di Animale 2 e del metodo stampa

		// Nel secondo parametro, l'interfaccia funzionale viene implementata con una
		// lambda.
		// 'a' rappresenta l'oggetto Animale su cui, dopo la freccia (->), verrà
		// applicata la logica.
		// In sostanza, a->a.puoVolare indica che Java deve chiamare un metodo con un
		// parametro Animale,
		// che deve ritornare il risultato del metodo puoVolare() sull'oggetto 'a'.

		// Nell'esempio successivo, la lambda viene utilizzata per testare diverse
		// caratteristiche degli animali.

		stampa(new Animale2("Pesce", false, true, false), a -> a.puoSaltare());
		stampa(new Animale2("Canguro", true, false, false), a -> a.puoSaltare());

		stampa(new Animale2("Pesce", false, true, false), a -> a.puoVolare());
		stampa(new Animale2("Aquila", false, false, true), a -> a.puoVolare());

		stampa(new Animale2("Aquila", false, false, true), a -> a.puoNuotare());
		stampa(new Animale2("Pesce", false, true, false), a -> a.puoNuotare());

		Animale2 pesce = new Animale2("Pesce", false, true, false);

		// SINTASSI DELLA LAMBDA

		// A SINISTRA DELLA FRECCIA vanno i parametri di input della lambda, che possono
		// essere consumati da un'interfaccia funzionale il cui metodo astratto ha lo
		// stesso numero di parametri del metodo astratto al suo interno, e i tipi sono
		// compatibili
		// A DESTRA DELLA FRECCIA c'è il corpo della lambda expression. può essere
		// consumato da un'interfaccia funzionale il cui metodo astratto ha un tipo
		// diritorno compatibile

		System.out.println("sintassi 1: ");
		stampa(pesce, a -> a.puoNuotare());

		// EQUIVALENTE A:

		// Specificando un singolo parametro con il nome a e dichiarando che il tipo è
		// Animal2, avvolgendo i parametri di input tra parentesi ().
		// L'operatore freccia -> separa il parametro dal corpo.
		// Il corpo contiene una o più linee di codice, inclusi parentesi graffe {}, un
		// punto e virgola ; e una dichiarazione di return.

		// Le parentesi intorno ai parametri di ingresso possono essere omesse se il
		// parametro è solo uno(come nell'esempio sopra)
		// Il tipo del paramentro è opzionale

		System.out.println("equivalente a sintassi 2: ");
		stampa(pesce, (Animale2 a) -> {
			return a.puoNuotare();
		});

		// Predicate Inteface
		System.out.println("\n" + Colors.WHITE_BACKGROUND_BRIGHT.get() + Colors.BLACK_BOLD.get()
				+ "The Predicate Functional Interface" + Colors.RESET.get());

		// NON E' NECESSARIO CREARE A MANO INTERFACCE FUNZIONALI COME
		// CheckCaratteristica. Ne esistono già pronte, come l'interfaccia PREDICATE

		// usiamola direttamente qui sotto in una lambda (vedi impl. del metodo
		// stampa2):
		stampa2(pesce, p -> p.puoNuotare());
		// oppures così con method reference
		stampa2(pesce, Animale2::puoNuotare);

		// sintassi con definizione del predicate direttamente qui
		stampa2(pesce, new Predicate<Animale2>() {
			public boolean test(Animale2 a) {
				return a.puoNuotare();
			}
		});

		// Implementing Polymorphism
		System.out.println("\n" + Colors.GREEN_BACKGROUND_BRIGHT.get() + Colors.BLACK_BOLD.get()
				+ "Implementing Polymorphism" + Colors.RESET.get());
		// Capacità di una singola interfaccia di supportare forme multiple sottostanti.
		// In Java possiamo quindi passare vari tipi di oggetti a un singolo metodo o
		// classe. ESEMPIO

		Balena balena = new Balena(); // v. impl
		Delfino delfino = new Delfino(); // v.impl
		Oceanografo o = new Oceanografo(); // v.impl
		o.ascoltaSuono(balena);
		o.ascoltaSuono(delfino);

		Lemure lemure = new Lemure();
		System.out.println(lemure.age);

		// trattiamo lemure come l'istanza dell'interfaccia che implemente (HaLaCoda)
		HaLaCoda haLaCoda = lemure;
		System.out.println(haLaCoda.laCodaEAStrisce());

		// NON COMPILA:
		// System.out.println(haLaCoda.age);

		// haLaCoda ha acceSso solo ai metodi
		// dell'interfaccia HaLaCoda, non sa che la
		// variabile age è parte dell'oggetto

		// trattiamo lemure come l'istanza di una sua superclasse (primate)
		Primate primate = lemure;
		System.out.println(primate.haIPeli());

		// NON COMPILA:
		// System.out.println(primate.laCodaEAStrisce());

		// primate ha accesso solo hai metodi definiti nella classe Primate, non ha
		// accesso diretto al metodo laCodaEAStrisce()

		// Object vs Reference
		System.out.println("\n" + Colors.WHITE_BACKGROUND_BRIGHT.get() + Colors.BLACK_BOLD.get() + "Object vs Reference"
				+ Colors.RESET.get());

		// Anche se abbiamo assegnato lemure a un riferimento con un tipo diverso
		// (Object),
		// Il lemure continua a esistere in memoria come oggetto Lemure
		Lemure lemure2 = new Lemure();
		Object lemure2Object = lemure2;

		// infatti conserva la sua proprietà age
		System.out.println("Proprietà dell'oggetto lemure2: age");
		System.out.println(lemure2.age);
		System.out.println("Metodo della classe primate (Superclasse di Lemure): haIPeli()");
		System.out.println(lemure2.haIPeli());
		System.out.println("Metodo della classe Lemure: laCodaEAStrisce()");
		System.out.println(lemure2.laCodaEAStrisce());

		System.out.println("metodo toString() visibile sia per lemure2 che per lemure2Object ");
		System.out.println(lemure2.toString());
		System.out.println(lemure2Object.toString());
		// QUESTO INVECE NON COMPILA
		// System.out.println(lemure2Object.age);
		// in lemure2Object non sono più visibili haIPeli() nè laCodaEAStrisce()

		// Perchè essendo il lemure referenziato come Object, non abbiamo più accesso
		// alle sue proprietà

		// IN SOSTANZA:
		// 1: Il tipo dell'oggetto definisce quali proprietà esistono
		// nell'oggetto in memoria
		// 2: Il tipo del riferimento all'oggetto (Object nell'esempio), definisce quali
		// metodi e variabili sono accessibili da Java per quell'oggetto

		// Casting Object References
		System.out.println("\n" + Colors.WHITE_BACKGROUND_BRIGHT.get() + Colors.BLACK_BOLD.get()
				+ "Casting Object References" + Colors.RESET.get());

		// Regole di base per il casting di variabili:
		// 1. Il casting di un oggetto da una sottoclasse a una superclasse non richiede
		// un cast esplicito.
		// 2. Il casting di un oggetto da una superclasse a una sottoclasse richiede un
		// cast esplicito.
		// 3. Il compilatore non consentirà il casting a tipi non correlati.
		// 4. Anche quando il codice viene compilato senza problemi, potrebbe essere
		// lanciata un'eccezione a runtime
		// se l'oggetto che si sta cercando di castare non è effettivamente un'istanza
		// di quella classe.

		Primate prim = lemure;
		// Il casting da una sottoclasse (Lemure) a una superclasse (Primate) non
		// richiede un cast esplicito.
		// Quindi, prim è ora un riferimento a un oggetto Lemure.

		// Il seguente codice non compila perché prim è ancora considerato un
		// riferimento a Primate e non ha accesso
		// alle proprietà specifiche di Lemure, come "age".

		// System.out.println(prim.age);

		// Tentativo di riconvertire il riferimento, ma senza un cast esplicito non
		// compila.

		// Lemure lemure3 = prim;

		// Con un cast esplicito, è possibile tornare ad accedere alle proprietà
		// specifiche di Lemure, come "age".
		Lemure lemure4 = (Lemure) prim;
		System.out.println(lemure4.age);

		// Singleton Pattern
		System.out.println("\n" + Colors.WHITE_BACKGROUND_BRIGHT.get() + Colors.BLACK_BOLD.get() + "Singleton Pattern"
				+ Colors.RESET.get());

		System.err.println("\nEsempio implementazione Singleton:\n");

		// Implementazione del pattern Singleton per la gestione dell'approvvigionamento
		// di fieno

		// Il pattern Singleton garantisce che esista una sola istanza del
		// DepositoFieno in tutta l'applicazione. Questo è utile quando vogliamo
		// centralizzare la gestione dell'approvvigionamento di fieno, evitando la
		// creazione di multiple istanze e assicurando che tutti i componenti
		// dell'applicazione si riferiscano allo stesso deposito. In questo modo,
		// ottimizziamo l'accesso e la condivisione delle risorse, migliorando
		// la coerenza dei dati e riducendo la complessità della gestione del fieno.

		DepositoFienoSingleton depositoFienoSingleton = DepositoFienoSingleton.getInstance(); // v.impl
																								// DepositoFienoSingleton

		// Verifica della quantità di fieno prima dell'alimentazione dei lama
		int quantitaPrimaAlimentazione = depositoFienoSingleton.getQuantitaFieno();
		System.out.println("Quantità di fieno prima dell'alimentazione dei lama: " + quantitaPrimaAlimentazione);

		// Alimentazione dei lama tramite il Singleton DepositoFieno
		AllenatoreLama allenatoreLama = new AllenatoreLama(); // v.impl.
		boolean alimentatiConSuccesso = allenatoreLama.alimentaLama(3);

		// Verifica della quantità di fieno dopo l'alimentazione dei lama
		int quantitaDopoAlimentazione = depositoFienoSingleton.getQuantitaFieno();
		System.out.println("Quantità di fieno dopo l'alimentazione dei lama: " + quantitaDopoAlimentazione);

		if (alimentatiConSuccesso) {
			System.out.println("I lama sono stati alimentati con successo!");
		} else {
			System.out.println("Impossibile alimentare i lama, quantità di fieno insufficiente.");
		}

		/*
		 * Nel nostro esempio con DepositoFieno, abbiamo istanziato l'oggetto singleton
		 * direttamente nella definizione della variabile di istanza. Possiamo anche
		 * istanziare un singleton in due altri modi. L'esempio seguente crea un
		 * singleton utilizzando un blocco di inizializzazione statica quando la classe
		 * viene caricata. Per semplicità, omettiamo la definizione dei metodi di dati
		 * su queste classi e presentiamo solo la logica di creazione e recupero
		 * dell'istanza:
		 */

		System.err.println("\nSingleton con blocco di inizializzazione statica:\n");

		// Esempio di istanziazione di un Singleton tramite blocco di inizializzazione
		// statica
		class StaffRegisterExample {
			private static final StaffRegisterExample instance;

			// Blocco di inizializzazione statica
			static {
				// Creazione dell'istanza del Singleton nel blocco di inizializzazione statica
				instance = new StaffRegisterExample();
				System.out.println("Singleton istanziato tramite blocco di inizializzazione statica.");
				// Eseguire eventuali passaggi aggiuntivi di configurazione del singleton
			}

			private StaffRegisterExample() {
				// Costruttore privato
			}

			// Metodo pubblico per ottenere l'istanza del Singleton
			public static StaffRegisterExample getInstance() {
				// Stampa per indicare quando viene richiesto l'oggetto Singleton
				System.out.println("Richiesta di ottenere l'istanza del Singleton.");
				return instance;
			}

			// Metodi di accesso ai dati
			// ...

		}

		// Utilizzo del Singleton StaffRegisterExample
		StaffRegisterExample staffRegister = StaffRegisterExample.getInstance();
		System.out.println("Oggetto Singleton ottenuto con successo.");

		// Ora puoi chiamare i metodi sulla tua istanza staffRegister se ce ne sono
		// System.out.println(staffRegister.metodo());

		// A differenza della classe DepositoFieno, la classe StaffRegister istanzia il
		// singleton come parte
		// di un blocco di inizializzazione statica. Concettualmente, queste due
		// implementazioni sono equivalenti,
		// poiché entrambe creano il singleton quando la classe viene caricata.
		// Tuttavia, il blocco di inizializzazione
		// statica consente di eseguire passaggi aggiuntivi per configurare il singleton
		// dopo la creazione.
		// Inoltre, consente di gestire i casi in cui il costruttore di StaffRegister
		// genera un'eccezione.
		// Poiché il singleton viene creato quando la classe viene caricata, possiamo
		// marcare il riferimentocome final, garantendo che venga creata solo un'istanza
		// all'interno della nostra applicazione.

		// I singletons sono utilizzati in situazioni in cui è necessario accedere a un
		// singolo insieme di dati
		// in tutta l'applicazione. Ad esempio, i dati di configurazione
		// dell'applicazione e le cache di dati
		// riutilizzabili sono comunemente implementati utilizzando i singletons. I
		// singletons possono anche essere
		// utilizzati per coordinare l'accesso a risorse condivise, come coordinare
		// l'accesso in scrittura a un file.

		System.err.println("\nSingleton Lazy Inizialization:\n");

		// Singleton Lazy: istanza creata solo alla prima richiesta.
		// La lazy instantiation riduce il consumo di memoria e migliora le prestazioni
		// all'avvio dell'applicazione.

		// La lazy instantiation consente di creare un'istanza riutilizzabile solo
		// quando è richiesta,ottimizzando l'uso della memoria e migliorando le
		// prestazioni all'avvio.

		// Lazy instantiation
		class SingletonLazy {
			private static SingletonLazy instance;

			// Costruttore privato
			private SingletonLazy() {
			}

			// Metodo pubblico per ottenere l'istanza del Singleton

			// (aggiungendo synchronized qui sarebbe stato thread safe)
			public static SingletonLazy getInstance() {
				if (instance == null) {
					System.out.println("Richiesta di ottenere l'istanza del Singleton Lazy.");
					// Creazione dell'istanza del Singleton solo al momento della richiesta
					instance = new SingletonLazy(); // NOT THREAD-SAFE! (senza sysynchronized)
					// Eseguire eventuali passaggi aggiuntivi di configurazione del singleton
					System.out.println("Singleton Lazy istanziato con successo.");
				}
				return instance;
			}

			// Metodi di accesso ai dati
			// ...
		}

		// Utilizzo del SingletonLazy
		SingletonLazy singletonLazyInstance = SingletonLazy.getInstance();
		System.out.println("Oggetto Singleton Lazy ottenuto con successo.");

		// Lo svantaggio è un possibile ritardo per gli utenti alla prima richiesta di
		// una risorsa specifica.
		// Ad esempio, Eclipse mostra un leggero ritardo solo la prima volta che apri un
		// file Java,
		// ottimizzando successivamente le prestazioni.

		// Immutable Objects
		System.out.println("\n" + Colors.WHITE_BACKGROUND_BRIGHT.get() + Colors.BLACK_BOLD.get() + "Immutable Objects"
				+ Colors.RESET.get());

		System.err.println("\nEsempio di oggetto immutabile:\n");

		try {
			// Creazione di un'istanza di AnimaleImmutabile
			AnimaleImmutabile animaleImmutabile = new AnimaleImmutabile("Leone", 5, List.of("Carne", "Acqua"));// (v.impl
																												// AnimaleImmutabile)

			// Stampare le proprietà dell'animale immutabile
			System.out.println("Specie: " + animaleImmutabile.getSpecie());
			System.out.println("Età: " + animaleImmutabile.getEta());
			System.out.print(animaleImmutabile.getConteggioCibiPreferiti() + " Cibi preferiti: ");
			System.out.print(" [ ");
			for (int i = 0; i < animaleImmutabile.getConteggioCibiPreferiti(); i++) {
				System.out.print(animaleImmutabile.getCiboPreferito(i)+" ");
			}
			System.out.print("] ");

			// Tentativo di modificare lo stato immutabile - NON COMPILA
			// animaleImmutabile.setSpecie("Tigre");

			  // Tentativo di passare una lista nulla - Genererà un'eccezione
		    AnimaleImmutabile animaleiImmutabile2 = new AnimaleImmutabile("Tigre", 3, null);
		
		} catch (Exception e) {
			System.err.println("\nErrore durante la creazione dell'AnimaleImmutabile: " + e.getMessage());
		}
	}
	
	

	// V. impl di CheckCaratteristica (@FunctionalInterface)
	// Implementazione del metodo 'stampa' che accetta un oggetto Animale2 e un
	// oggetto CheckCaratteristica.
	// CheckCaratteristica è un'interfaccia funzionale e viene implementata mediante
	// la lambda fornita come parametro.
	// Il metodo test della lambda viene chiamato, passando l'oggetto Animale2, e
	// viene verificata la caratteristica specificata.
	private static void stampa(Animale2 animale, CheckCaratteristica caratteristica) {
		if (caratteristica.test(animale))
			System.out.println(animale + " possiede la caratteristca cercata");
	}

	private static void stampa2(Animale2 animale, Predicate<Animale2> caratteristica) {
		if (caratteristica.test(animale))
			System.out.println("(USANDO PREDICATE)" + animale + " possiede la caratteristca cercata");
	}

}
