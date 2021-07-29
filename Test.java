
public class Test {
	static Queue player1 = new Queue(1000);
	static Queue player2 = new Queue(1000);
	static int player1yahtzeeCounter1 = 0; // player1 icin yahtzee ve secutive sayaclari.
	static int player1yahtzeeCounter2 = 0;
	static int player1yahtzeeCounter3 = 0;
	static int player1yahtzeeCounter4 = 0;
	static int player1yahtzeeCounter5 = 0;
	static int player1yahtzeeCounter6 = 0;
	static int player2yahtzeeCounter1 = 0; // player2 icin yahtzee ve secutive sayaclari.
	static int player2yahtzeeCounter2 = 0;
	static int player2yahtzeeCounter3 = 0;
	static int player2yahtzeeCounter4 = 0;
	static int player2yahtzeeCounter5 = 0;
	static int player2yahtzeeCounter6 = 0;
	static int points1 = 0; // player1 puanlar.
	static int points2 = 0; // player2 puanlar.

	public static void main(String[] args) {
		System.out.print("        -o-o-o-  YAHTZEE GAME  -o-o-o-");
		System.out.println("");
		System.out.print("------------------------------------------------o");
		for(int i = 0; i < 15; i++) { // oyunun 15 tur tekrarlanmasi.
		System.out.println("");
		Player1();
		Player2();
		System.out.println("");
		}
		System.out.println("");
		System.out.print("------------------------------------------------o");
		System.out.println("");
		System.out.print("Game is over.");
		if(points1 > points2) // kazanma durum kontrolleri.
		{
			System.out.println("");
			System.out.print("The winner is Player1.");
		}
		else if(points2 > points1)
		{
			System.out.println("");
			System.out.print("The winner is Player2.");
		}
		else if(points1 == points2)
		{
			System.out.println("");
			System.out.print("No one is winner. Tie.");
		}
	}
	public static void Player1() {
		int player1dice1 = (int) (Math.random() * 6 + 1); // player1e random 3 zar attirma.
		int player1dice2 = (int) (Math.random() * 6 + 1);
		int player1dice3 = (int) (Math.random() * 6 + 1);
		player1.enqueue(player1dice1);
		player1.enqueue(player1dice2);
		player1.enqueue(player1dice3);
				System.out.print("Player1 : ");
				Print(player1);
				yahtzeeCounter1(player1dice1,player1dice2,player1dice3); // zardaki sayýilarin esitligini kontrol eden fonksiyonun çagrilmasi.
				calculateYahtzeePoint1(player1); // yahtzee kosulunda queuedaki esit olan sayilarin silinme fonksiyonunun cagrilmasi.
				calculateSecutivePoint1(player1); // selective kosulunda 1 ve 6 arasindaki sayilarin silinme fonksiyonunun cagrilmasi.
	}
	public static void Player2() {
		int player2dice1 = (int) (Math.random() * 6 + 1); // player2ye random 3 zar attirma.
		int player2dice2 = (int) (Math.random() * 6 + 1);
		int player2dice3 = (int) (Math.random() * 6 + 1);
		player2.enqueue(player2dice1);
		player2.enqueue(player2dice2);
		player2.enqueue(player2dice3);
				System.out.print("Player2 : ");
				Print(player2);
				yahtzeeCounter2(player2dice1,player2dice2,player2dice3); // zardaki sayýilarin esitligini kontrol eden fonksiyonun çagrilmasi.
				calculateYahtzeePoint2(player2); // yahtzee kosulunda queuedaki esit olan sayilarin silinme fonksiyonunun cagrilmasi.
				calculateSecutivePoint2(player2); // selective kosulunda 1 ve 6 arasindaki sayilarin silinme fonksiyonunun cagrilmasi.
	}
	public static void yahtzeeCounter1(int dice1, int dice2, int dice3) { // player1 icin yahtzee sayac arttirma.
		if(dice1 == 1 || dice2 == 1 || dice3 == 1) {
			player1yahtzeeCounter1++; // eger atilan zarin herhangi birindeki sayi 1e esit olursa sayaci 1 arttirma.
			if(dice1 == dice2 && dice2 != dice3 && dice1 == 1) { // ikinci bir esitlik daha varsa 1 daha ekleme.
				player1yahtzeeCounter1 = player1yahtzeeCounter1 + 1;
			}
			else if(dice1 == dice3 && dice2 != dice3 && dice3 == 1) { // ikinci bir esitlik daha varsa 1 daha ekleme.
				player1yahtzeeCounter1 = player1yahtzeeCounter1 + 1;
			}
			else if(dice1 != dice2 && dice2 == dice3 && dice2 == 1 ) { // ikinci bir esitlik daha varsa 1 daha ekleme.
				player1yahtzeeCounter1 = player1yahtzeeCounter1 + 1;
			}
			else if (dice1 == dice2 && dice2 == dice3){ // hepsi esitse sayaca 2 daha ekleme.
				player1yahtzeeCounter1 = player1yahtzeeCounter1 + 2;
			}
			//System.out.print("count of number 1: " + player1yahtzeeCounter1 + "  "); // sayaclarin kacar saydigini gorebilmek icin.
		}
		
		// diger tum sayilar icin ayni islemler.
		if(dice1 == 2 || dice2 == 2 || dice3 == 2) {
			player1yahtzeeCounter2++;
			if(dice1 == dice2 && dice2 != dice3 && dice1 == 2) {
				player1yahtzeeCounter2 = player1yahtzeeCounter2 + 1;
			}
			else if(dice1 == dice3 && dice2 != dice3 && dice3 == 2) {
				player1yahtzeeCounter2 = player1yahtzeeCounter2 + 1;
			}
			else if(dice1 != dice2 && dice2 == dice3 && dice2 == 2 ) {
				player1yahtzeeCounter2 = player1yahtzeeCounter2 + 1;
			}
			else if (dice1 == dice2 && dice2 == dice3){
				player1yahtzeeCounter2 = player1yahtzeeCounter2 + 2;
			}
			//System.out.print("count of number 2: " + player1yahtzeeCounter2 + "  ");
		}
		if(dice1 == 3 || dice2 == 3 || dice3 == 3) {
			player1yahtzeeCounter3++;
			if(dice1 == dice2 && dice2 != dice3 && dice1 == 3) {
				player1yahtzeeCounter3 = player1yahtzeeCounter3 + 1;
			}
			else if(dice1 == dice3 && dice2 != dice3 && dice3 == 3) {
				player1yahtzeeCounter3 = player1yahtzeeCounter3 + 1;
			}
			else if(dice1 != dice2 && dice2 == dice3 && dice2 == 3 ) {
				player1yahtzeeCounter3 = player1yahtzeeCounter3 + 1;
			}
			else if (dice1 == dice2 && dice2 == dice3){
				player1yahtzeeCounter3 = player1yahtzeeCounter3 + 2;
			}
			//System.out.print("count of number 3: " + player1yahtzeeCounter3 + "  ");
		}
		if(dice1 == 4 || dice2 == 4 || dice3 == 4) {
			player1yahtzeeCounter4++;
			if(dice1 == dice2 && dice2 != dice3 && dice1 == 4) {
				player1yahtzeeCounter4 = player1yahtzeeCounter4 + 1;
			}
			else if(dice1 == dice3 && dice2 != dice3 && dice3 == 4) {
				player1yahtzeeCounter4 = player1yahtzeeCounter4 + 1;
			}
			else if(dice1 != dice2 && dice2 == dice3 && dice2 == 4 ) {
				player1yahtzeeCounter4 = player1yahtzeeCounter4 + 1;
			}
			else if (dice1 == dice2 && dice2 == dice3){
				player1yahtzeeCounter4 = player1yahtzeeCounter4 + 2;
			}
			//System.out.print("count of number 4: " + player1yahtzeeCounter4 + "  ");
		}
		if(dice1 == 5 || dice2 == 5 || dice3 == 5) {
			player1yahtzeeCounter5++;
			if(dice1 == dice2 && dice2 != dice3 && dice1 == 5) {
				player1yahtzeeCounter5 = player1yahtzeeCounter5 + 1;
			}
			else if(dice1 == dice3 && dice2 != dice3 && dice3 == 5) {
				player1yahtzeeCounter5 = player1yahtzeeCounter5 + 1;
			}
			else if(dice1 != dice2 && dice2 == dice3 && dice2 == 5) {
				player1yahtzeeCounter5 = player1yahtzeeCounter5 + 1;
			}
			else if (dice1 == dice2 && dice2 == dice3){
				player1yahtzeeCounter5 = player1yahtzeeCounter5 + 2;
			}
			//System.out.print("count of number 5: " + player1yahtzeeCounter5 + "  ");
		}
		if(dice1 == 6 || dice2 == 6 || dice3 == 6) {
			player1yahtzeeCounter6++;
			if(dice1 == dice2 && dice2 != dice3 && dice1 == 6) {
				player1yahtzeeCounter6 = player1yahtzeeCounter6 + 1;
			}
			else if(dice1 == dice3 && dice2 != dice3 && dice3 == 6) {
				player1yahtzeeCounter6 = player1yahtzeeCounter6 + 1;
			}
			else if(dice1 != dice2 && dice2 == dice3 && dice2 == 6 ) {
				player1yahtzeeCounter6 = player1yahtzeeCounter6 + 1;
			}
			else if (dice1 == dice2 && dice2 == dice3){
				player1yahtzeeCounter6 = player1yahtzeeCounter6 + 2;
			}
			//System.out.print("count of number 6: " + player1yahtzeeCounter6 + "  ");
		}
	}
	public static void yahtzeeCounter2(int dice1, int dice2, int dice3) { // player2 icin yahtzee sayac arttirma.
		if(dice1 == 1 || dice2 == 1 || dice3 == 1) {  // eger atilan zarin herhangi birindeki sayi 1e esit olursa sayaci 1 arttirma.
			player2yahtzeeCounter1++;
			if(dice1 == dice2 && dice2 != dice3 && dice1 == 1) { // ikinci bir esitlik daha varsa 1 daha ekleme.
				player2yahtzeeCounter1 = player2yahtzeeCounter1 + 1;
			}
			else if(dice1 == dice3 && dice2 != dice3 && dice3 == 1) { // ikinci bir esitlik daha varsa 1 daha ekleme.
				player2yahtzeeCounter1 = player2yahtzeeCounter1 + 1;
			}
			else if(dice1 != dice2 && dice2 == dice3 && dice2 == 1 ) { // ikinci bir esitlik daha varsa 1 daha ekleme.
				player2yahtzeeCounter1 = player2yahtzeeCounter1 + 1;
			}
			else if (dice1 == dice2 && dice2 == dice3){ // hepsi esitse sayaca 2 daha ekleme.
				player2yahtzeeCounter1 = player2yahtzeeCounter1 + 2;
			}
			//System.out.print("count of number 1: " + player2yahtzeeCounter1 + "  "); // sayaclarin kacar saydigini gorebilmek icin.
		}

		// diger tum sayilar icin ayni islemler.
		if(dice1 == 2 || dice2 == 2 || dice3 == 2) {
			player2yahtzeeCounter2++;
			if(dice1 == dice2 && dice2 != dice3 && dice1 == 2) {
				player2yahtzeeCounter2 = player2yahtzeeCounter2 + 1;
			}
			else if(dice1 == dice3 && dice2 != dice3 && dice3 == 2) {
				player2yahtzeeCounter2 = player2yahtzeeCounter2 + 1;
			}
			else if(dice1 != dice2 && dice2 == dice3 && dice2 == 2 ) {
				player2yahtzeeCounter2 = player2yahtzeeCounter2 + 1;
			}
			else if (dice1 == dice2 && dice2 == dice3){
				player2yahtzeeCounter2 = player2yahtzeeCounter2 + 2;
			}
			//System.out.print("count of number 2: " + player2yahtzeeCounter2 + "  ");
		}
		if(dice1 == 3 || dice2 == 3 || dice3 == 3) {
			player2yahtzeeCounter3++;
			if(dice1 == dice2 && dice2 != dice3 && dice1 == 3) {
				player2yahtzeeCounter3 = player2yahtzeeCounter3 + 1;
			}
			else if(dice1 == dice3 && dice2 != dice3 && dice3 == 3) {
				player2yahtzeeCounter3 = player2yahtzeeCounter3 + 1;
			}
			else if(dice1 != dice2 && dice2 == dice3 && dice2 == 3 ) {
				player2yahtzeeCounter3 = player2yahtzeeCounter3 + 1;
			}
			else if (dice1 == dice2 && dice2 == dice3){
				player2yahtzeeCounter3 = player2yahtzeeCounter3 + 2;
			}
			//System.out.print("count of number 3: " + player2yahtzeeCounter3 + " ");
		}
		if(dice1 == 4 || dice2 == 4 || dice3 == 4) {
			player2yahtzeeCounter4++;
			if(dice1 == dice2 && dice2 != dice3 && dice1 == 4) {
				player2yahtzeeCounter4 = player2yahtzeeCounter4 + 1;
			}
			else if(dice1 == dice3 && dice2 != dice3 && dice3 == 4) {
				player2yahtzeeCounter4 = player2yahtzeeCounter4 + 1;
			}
			else if(dice1 != dice2 && dice2 == dice3 && dice2 == 4 ) {
				player2yahtzeeCounter4 = player2yahtzeeCounter4 + 1;
			}
			else if (dice1 == dice2 && dice2 == dice3){
				player2yahtzeeCounter4 = player2yahtzeeCounter4 + 2;
			}
			//System.out.print("count of number 4: " + player2yahtzeeCounter4+ "  ");
		}
		if(dice1 == 5 || dice2 == 5 || dice3 == 5) {
			player2yahtzeeCounter5++;
			if(dice1 == dice2 && dice2 != dice3 && dice1 == 5) {
				player2yahtzeeCounter5 = player2yahtzeeCounter5 + 1;
			}
			else if(dice1 == dice3 && dice2 != dice3 && dice3 == 5) {
				player2yahtzeeCounter5 = player2yahtzeeCounter5 + 1;
			}
			else if(dice1 != dice2 && dice2 == dice3 && dice2 == 5) {
				player2yahtzeeCounter5 = player2yahtzeeCounter5 + 1;
			}
			else if (dice1 == dice2 && dice2 == dice3){
				player2yahtzeeCounter5 = player2yahtzeeCounter5 + 2;
			}
			//System.out.print("count of number 5: " + player2yahtzeeCounter5 + "  ");
		}
		if(dice1 == 6 || dice2 == 6 || dice3 == 6) {
			player2yahtzeeCounter6++;
			if(dice1 == dice2 && dice2 != dice3 && dice1 == 6) {
				player2yahtzeeCounter6 = player2yahtzeeCounter6 + 1;
			}
			else if(dice1 == dice3 && dice2 != dice3 && dice3 == 6) {
				player2yahtzeeCounter6 = player2yahtzeeCounter6 + 1;
			}
			else if(dice1 != dice2 && dice2 == dice3 && dice2 == 6 ) {
				player2yahtzeeCounter6 = player2yahtzeeCounter6 + 1;
			}
			else if (dice1 == dice2 && dice2 == dice3){
				player2yahtzeeCounter6 = player2yahtzeeCounter6 + 2;
			}
		
			//System.out.print("count of number 6: " + player2yahtzeeCounter6 + "  ");
		}
	}
	public static void calculateSecutivePoint1(Queue q) { // player1 icin sirali gelen sayilar fonksiyonu.
		boolean flag1 = true;
		if(player1yahtzeeCounter1 >= 1 && player1yahtzeeCounter2 >= 1 && player1yahtzeeCounter3 >= 1 && player1yahtzeeCounter4 >= 1 &&
				player1yahtzeeCounter5 >= 1 && player1yahtzeeCounter6 >= 1) { // tum sayilardan en az bir tane varsa.
			int size = q.size(); // size surekli degistigi icin sabitlendi.
			for(int i = 0; i < size; i++) {
				if((int)q.peek() == 1) { // sadece 1 icin kontrol.
					while(flag1 == true) { // 1 kez silme islemi icin flag kontrolu.
						q.dequeue();
						player1yahtzeeCounter1--; // silme islemi sonrasi sayac azaltimi.
						flag1 = false;
					}
				}
				else
					q.enqueue(q.dequeue()); // geri kalanlari queueya ekleme islemi.
			}
			
			// ayni islemler diger sayilar icin.
		boolean flag2 = true;
			for(int i = 0; i < size; i++) {
				if((int)q.peek() == 2) {
					while(flag2 == true) {
						q.dequeue();
						player1yahtzeeCounter2--;
						flag2 = false;
					}
				}
				else
					q.enqueue(q.dequeue());
			}
		boolean flag3 = true;
			for(int i = 0; i < size; i++) {
				if((int)q.peek() == 3) {
					while(flag3 == true) {
						q.dequeue();
						player1yahtzeeCounter3--;
						flag3 = false;
					}
				}
				else
					q.enqueue(q.dequeue());
			}
		boolean flag4 = true;
			for(int i = 0; i < size; i++) {
				if((int)q.peek() == 4) {
					while(flag4 == true) {
						q.dequeue();
						player1yahtzeeCounter4--;
						flag4 = false;
					}
				}
				else
					q.enqueue(q.dequeue());
			}
		boolean flag5 = true;
			for(int i = 0; i < size; i++) {
				if((int)q.peek() == 5) {
					while(flag5 == true) {
						q.dequeue();
						player1yahtzeeCounter5--;
						flag5 = false;
					}
				}
				else
					q.enqueue(q.dequeue());
			}
		boolean flag6 = true;
			for(int i = 0; i < size; i++) {
				if((int)q.peek() == 6) {
					while(flag6 == true) {
						q.dequeue();
						player1yahtzeeCounter6--;
						flag6 = false;
					}
				}
				else
					q.enqueue(q.dequeue());
			}
			points1 += 10; // puan arttirimi.
		}
	}
	public static void calculateSecutivePoint2(Queue q) { // player2 icin sirali gelen sayilar fonksiyonu.
		boolean flag1 = true;
		if(player2yahtzeeCounter1 >= 1 && player2yahtzeeCounter2 >= 1 && player2yahtzeeCounter3 >= 1 && player2yahtzeeCounter4 >= 1 &&
				player2yahtzeeCounter5 >= 1 && player2yahtzeeCounter6 >= 1) { // tum sayilardan en az bir tane varsa.
			int size = q.size(); // size surekli degistigi icin sabitlendi.
			for(int i = 0; i < size; i++) {
				if((int)q.peek() == 1) { // sadece 1 icin kontrol.
					while(flag1 == true) { // 1 kez silme islemi icin flag kontrolu.
						q.dequeue();
						player2yahtzeeCounter1--; // silme islemi sonrasi sayac azaltimi.
						flag1 = false;
					}
				}
				else
					q.enqueue(q.dequeue()); // geri kalanlari queueya ekleme islemi.
			}
			
			// ayni islemler diger sayilar icin.
		boolean flag2 = true;
			for(int i = 0; i < size; i++) {
				if((int)q.peek() == 2) {
					while(flag2 == true) {
						q.dequeue();
						player2yahtzeeCounter2--;
						flag2 = false;
					}
				}
				else
					q.enqueue(q.dequeue());
			}
		boolean flag3 = true;
			for(int i = 0; i < size; i++) {
				if((int)q.peek() == 3) {
					while(flag3 == true) {
						q.dequeue();
						player2yahtzeeCounter3--;
						flag3 = false;
					}
				}
				else
					q.enqueue(q.dequeue());
			}
		boolean flag4 = true;
			for(int i = 0; i < size; i++) {
				if((int)q.peek() == 4) {
					while(flag4 == true) {
						q.dequeue();
						player2yahtzeeCounter4--;
						flag4 = false;
					}
				}
				else
					q.enqueue(q.dequeue());
			}
		boolean flag5 = true;
			for(int i = 0; i < size; i++) {
				if((int)q.peek() == 5) {
					while(flag5 == true) {
						q.dequeue();
						player2yahtzeeCounter5--;
						flag5 = false;
					}
				}
				else
					q.enqueue(q.dequeue());
			}
		boolean flag6 = true;
			for(int i = 0; i < size; i++) {
				if((int)q.peek() == 6) {
					while(flag6 == true) {
						q.dequeue();
						player2yahtzeeCounter6--;
						flag6 = false;
					}
				}
				else
					q.enqueue(q.dequeue());
			}
			points2 += 10;
		}
	}
	public static void calculateYahtzeePoint1(Queue q) { // player1 icin yahtzee durumu saglandiginda queuedan esit olan sayilari silme fonksiyonu.
		if(player1yahtzeeCounter1 >= 4) { // eger 1 sayaci 4e esit veya 4ten buyukse;
			points1 += 20; // puaný 20 arttýr.
			int size = q.size(); // size surekli degistigi icin sabitlendi.
			for(int i = 0; i < size; i++) {
				if((int)q.peek() == 1) { // queuedaki sayi 1e esitse;
					q.dequeue(); // queuedan cikarma islemi.
				}
				else
				q.enqueue(q.dequeue()); // esit degilse queueya geri ekleyerek eski haline cevirme.
			}
			player1yahtzeeCounter1=0; // silme islemi tamamlandigida yahtzee sayacinin sifirlanmasi.
		}
		
		// ayni islemler diger sayilar icin.
		if(player1yahtzeeCounter2 >= 4) {
			points1 += 20;
			int size = q.size();
			for(int i = 0; i < size; i++) {
				if((int)q.peek() == 2) {
					q.dequeue();
				}
				else
				q.enqueue(q.dequeue());
			}
			player1yahtzeeCounter2=0;
		}
		if(player1yahtzeeCounter3 >= 4) {
			points1 += 20;
			int size = q.size();
			for(int i = 0; i < size; i++) {
				if((int)q.peek() == 3) {
					q.dequeue();
				}
				else
				q.enqueue(q.dequeue());
			}
			player1yahtzeeCounter3=0;
		}
		if(player1yahtzeeCounter4 >= 4) {
			points1 += 20;
			int size = q.size();
			for(int i = 0; i < size; i++) {
				if((int)q.peek() == 4) {
					q.dequeue();
				}
				else
				q.enqueue(q.dequeue());
			}
			player1yahtzeeCounter4=0;
		}
		if(player1yahtzeeCounter5 >= 4) {
			points1 += 20;
			int size = q.size();
			for(int i = 0; i < size; i++) {
				if((int)q.peek() == 5) {
					q.dequeue();
				}
				else
				q.enqueue(q.dequeue());
			}
			player1yahtzeeCounter5=0;
		}
		if(player1yahtzeeCounter6 >= 4) {
			points1 += 20;
			int size = q.size();
			for(int i = 0; i < size; i++) {
				if(q.peek() != null && (int)q.peek() == 6) {
					q.dequeue();
				}
				else
				q.enqueue(q.dequeue());
			}
			player1yahtzeeCounter6=0;
		}
		System.out.println("          Player1 score: " + points1);
	}
	public static void calculateYahtzeePoint2(Queue q) { // player2 icin yahtzee durumu saglandiginda queuedan esit olan sayilari silme fonksiyonu.
		if(player2yahtzeeCounter1 >= 4) { // eger 1 sayaci 4e esit veya 4ten buyukse;
			points2 += 20; // puaný 20 arttýr.
			int size = q.size(); // size surekli degistigi icin sabitlendi.
			for(int i = 0; i < size; i++) {
				if((int)q.peek() == 1) {  // queuedaki sayi 1e esitse;
					q.dequeue();  // queuedan cikarma islemi.
				}
				else
				q.enqueue(q.dequeue()); // esit degilse queueya geri ekleyerek eski haline cevirme.
			}
			player2yahtzeeCounter1=0; // silme islemi tamamlandigida yahtzee sayacinin sifirlanmasi.
		}
		
		// ayni islemler diger sayilar icin.
		if(player2yahtzeeCounter2 >= 4) {
			points2 += 20;
			int size = q.size();
			for(int i = 0; i < size; i++) {
				if((int)q.peek() == 2) {
					q.dequeue();
				}
				else
				q.enqueue(q.dequeue());
			}
			player2yahtzeeCounter2=0;
		}
		if(player2yahtzeeCounter3 >= 4) {
			points2 += 20;
			int size = q.size();
			for(int i = 0; i < size; i++) {
				if((int)q.peek() == 3) {
					q.dequeue();
				}
				else
				q.enqueue(q.dequeue());
			}
			player2yahtzeeCounter3=0;
		}
		if(player2yahtzeeCounter4 >= 4) {
			points2 += 20;
			int size = q.size();
			for(int i = 0; i < size; i++) {
				if((int)q.peek() == 4) {
					q.dequeue();
				}
				else
				q.enqueue(q.dequeue());
			}
			player2yahtzeeCounter4=0;
		}
		if(player2yahtzeeCounter5 >= 4) {
			points2 += 20;
			int size = q.size();
			for(int i = 0; i < size; i++) {
				if((int)q.peek() == 5) {
					q.dequeue();
				}
				else
				q.enqueue(q.dequeue());
			}
			player2yahtzeeCounter5=0;
		}
		if(player2yahtzeeCounter6 >= 4) {
			points2 += 20;
			int size = q.size();
			for(int i = 0; i < size; i++) {
				if((int)q.peek() == 6) {
					q.dequeue();
				}
				else
				q.enqueue(q.dequeue());
			}
			player2yahtzeeCounter6=0;
		}
		System.out.print("          Player2 score: " + points2);
	}
	public static void Print(Queue q) { // yazdirma fonksiyonu.
		for (int i = 0; i < q.size(); i++) {
			System.out.print(q.peek() + " ");
			q.enqueue(q.dequeue());
		}
	}
}
