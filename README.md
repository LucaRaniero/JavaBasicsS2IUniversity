<h1 align="center">
  Progetto “Java Basics” Start2impact University
  <br>
</h1>

<h4 align="center">Software per un servizio di car pooling inventato di nome PoolingAround.</h4>

## Contesto

Il servizio PoolingAround è nato per facilitare gli spostamenti di viaggiatori leggeri, studenti fuori sede e professionisti. Il servizio permette di risparmiare denaro ed emissioni, permettendo di dividere i costi del viaggio e di riempire i posti di una macchina che sarebbe altrimenti rimasta semivuota.

Attenzione: l'azienda sopracitata è ipotetica.

## Features Principali

Vengono dati 3 file csv di partenza che verranno importati: utenti.csv, viaggi.csv e prenotazioni.csv.
Il software permetterà di effettuare le seguenti azioni:

1. Visualizzare tutti i viaggi dell'interno del sistema
2. Prenotare un viaggio esistente
3. Disdire la prenotazione di un viaggio
4. Aggiungere un nuovo utente
5. Esportare un file con i viaggi disponibili
6. Con il comando 0, uscire dal programma

## Struttura tecnica del progetto


Si basa su 5 package: Controller, Service, FilesUploaded, Model, Utilities.


* Controller: contiene la classe Controller che a sua volta contiene il metodo principale di start(), il cuore del software, basato su un do-while-loop, dal quale si esce quando l’utente immette l’input 0. In pratica qui si chiede all’utente di immettere un input per poter scegliere cosa fare. Vengono gestite le diverse eccezioni come inserimento di stringhe (in questa fase si accettano solo numeri interi) o numeri interi non compresi tra lo 0 e il 5.


* Service: contiene la classe Service che, quando istanziata dal Controller, istanzia a sua volta per la prima volta i 3 file csv, caricandoli dalle rispettive classi (Utente, Viaggi, Prenotazioni). Contiene 2 metodi principali:
	* InstanceofCommands(): restituisce un datatype di tipo Map<Integer, Runnable>, dove in pratica viene associato ad ogni numero il metodo corretto da chiamare per poter eseguire il comando. 
	* executeCommand(): quando chiamato, viene passato in input il Map<Integer, Runnable> creato dal metodo precedente e l’input che viene passato dall’utente. Quest’ultimo viene utilizzato come chiave per eseguire il corrispondente comando istanziato in precedenza. Nel caso in cui l’input non dovesse essere compreso tra 0 e 5, stamperà a schermo che accetta solo numeri interi compresi tra 0 e 5.

* FilesUploaded: contiente la classe padre Uploader e le tre classi figlie, una per ogni file csv da caricare (Utente, Viaggi, Prenotazioni):
	* Uploader: il costruttore, gestisce il caricamento del file chiamando la classe utilities CSVReaderInJava e passandogli in input il nome del file e il delimitatore. Le caratteristiche di questo costruttore ovviamente verranno ereditate dalle figlie e implementate.
Inoltre contiene il metodo toString che permette di stampare a schermo il contenuto del file csv caricato in formato tabella. Per permettere ciò viene utilizzata la classe CommandLineTable, siccome richiede in input i dati specifici dei file, ho creato anche il metodo astratto ListOfValueRecord che ogni classe figlia implementa. Lascio uno screen di esempio del risultato se lo si dovesse chiamare:
	* Utente: contiene una serie di metodi setter e getter utili per la risoluzione ottimale dei diversi comandi;
	* Prenotazioni: come Utente;
	* Viaggi: come Utente.


* Model: contiene tante classi tanti quanti sono i comandi disponibili
	* Comando1: il metodo displayTuttiIViaggi stampa a schermo tutti i viaggi, disponibili e non, con alcuni dati utili richiesti. La logica che segue è molto semplice, tramite un loop entra nel Map di Viaggi ed estrae i dati che servono. Se il viaggio è prenotato, allora entra in un altro loop sul Map di Prenotazioni per estrarre il nome dell’utente che l’ha prenotato. Lascio screen di esempio:
	* Comando2: tramite il metodo prenotaViaggio permette ad un utente di prenotare un viaggio ma solo se disponibile. Anche qui ci sono 2 do-while-loop che gestiscono gli input da parte dell’utente. Per non ripetere porzioni di codice simile, ho deciso che i loop e le relative eccezioni vengono gestite dal metodo doWhileLoopInteger, in quanto entrambi richiedono un numero intero in input dall’utente. A prenotazione avvenuta, vado ad aggiornare il campo Disponibilità dell’istanza prenotazioni.
	* Comando3: permette di disdire una prenotazione. A disdetta avvenuta, aggiorno l’istanza prenotazioni rimuovendo la riga.
	* Comando4: permette di aggiungere un nuovo utente all’istanza utenti. Come nel Comando3, anche qui la gestione di tutti i do-while-loop richiesti è affidata ad un metodo apposito chiamato doWhileLoopString in modo da non dover ripetere troppo codice. A operazione conclusa, il metodo aggiungiNuovoUtente andrà ad aggiornare l’istanza utenti aggiungendo la nuova riga e assegnando automaticamente l’ID del nuovo utente, stampandolo a schermo;
	* Comando5: creare un file csv in output riportando tutti i viaggi disponibili e assegnandogli il nome “viaggi_” + la data odierna formatta in “dd_MM_yyy”


* Utilities: contiene 2 classi di utilità che vengono sfruttate dalle altre classi.
	* CSVReaderInJava: permette di leggere ed estrarre i dati da un file csv. Nello specifico ho deciso di estrarli con il datatype HashMap<Integer, String[]> in quanto ho notato che la prima colonna dei 3 csv funge sempre da chiave (ragionando in termini di database) semplificando quindi la ricerca del record desiderato. 
Contiene anche il metodo loadCsvFirstRow che legge solo l’header del file csv, utile per i toString della classe genitore Uploader.
	* CommandLineTable: cercavo una soluzione plug-and-play per stampare a terminale in maniera più ordinata i dati contenuti nel csv e cercando online ho trovato questa classe stand alone che faceva al caso mio e quindi l’ho utilizzata. Lascio la [fonte](https://www.logicbig.com/how-to/code-snippets/jcode-java-cmd-command-line-table.html)

## How To Use

Per clonare e provare il software avrai bisogno di Apache Maven.
Apri il terminale, posizionati nella cartella che preferisci e segui questi step:

```bash
# Clone this repository
$ git clone https://github.com/LucaRaniero/JavaBasicsS2IUniversity

# Go into the repository
$ cd JavaBasicsS2IUniversity

# Clean and compile
$ mvn clean compile

# Creation package
$ mvn package

# Run the app
$ java -jar target/application.jar
```
