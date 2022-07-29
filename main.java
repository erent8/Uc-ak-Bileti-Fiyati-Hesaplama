import java.util.Scanner;
request.setCharacterEncoding("utf-8");
public class UcakBiletiFiyatiHesaplama {
    /*  Java ile mesafeye ve şartlara göre uçak bileti fiyatı hesaplayan programı yapın. Kullanıcıdan Mesafe (KM), yaşı
        ve yolculuk tipi (Tek Yön, Gidiş-Dönüş) bilgilerini alın. Mesafe başına ücret 0,10 TL / km olarak alın.
        İlk olarak uçuşun toplam fiyatını hesaplayın ve sonrasında ki koşullara göre müşteriye aşağıdaki indirimleri
        uygulayın ;

         - Kullanıcıdan alınan değerler geçerli (mesafe ve yaş değerleri pozitif sayı, yolculuk tipi ise 1 veya 2)
        olmalıdır. Aksi takdirde kullanıcıya "Hatalı Veri Girdiniz !" şeklinde bir uyarı verilmelidir.
         - Kişi 12 yaşından küçükse bilet fiyatı üzerinden %50 indirim uygulanır.
         - Kişi 12-24 yaşları arasında ise bilet fiyatı üzerinden %10 indirim uygulanır.
         - Kişi 65 yaşından büyük ise bilet fiyatı üzerinden %30 indirim uygulanır.
         - Kişi "Yolculuk Tipini" gidiş dönüş seçmiş ise bilet fiyatı üzerinden %20 indirim uygulanır.
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int distance;
        int age;
        int journeyType;
        double price;
        double costByPerDistance = 0.10d;

        System.out.print("\nGideceğiniz mesafeyi kilometre olarak giriniz: ");
        distance = input.nextInt();

        System.out.print("Yaşınızı giriniz: ");
        age = input.nextInt();

        System.out.print("Yolculuk tipini belirtiniz (1 - Tek Yön 2 - Gidiş-Dönüş): ");
        journeyType = input.nextInt();

        if (distance < 0 || age < 0 || journeyType != 1 && journeyType != 2) {
            System.out.println("\nHatalı veri girdiniz !");
            System.exit(0);
        }

        price = costByPerDistance * distance;

        if (age < 12) {
            price = price / 2;
        } else if (age < 24) {
            price = price - (price * 0.1);
        } else if (age > 65) {
            price = price - (price * 0.3);
        }

        if (journeyType == 2) {
            price = price - (price * 0.2);
            price = price * 2;
        }

        System.out.println("\nToplam Tutar: " + (price));
    }
}
