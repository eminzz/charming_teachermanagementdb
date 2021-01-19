/*database-melumatlarin(datalarin) toplandigi yerdir.Melumatlarin strukturu mektebdeki jurnal sistemi kimidir.
Nomrler , bunlarin onunde ad soyad falan. Bunun yuxari ortasinda table yerinde -student (islediyimiz appi) yazirig,
nece faylda yazib saxlayirdigsa, hemen appi indi databeyze kocururuk.Kompumuza sql programini yukleyirik, bu program
komp acilan kimi daimi isleyir, bu c diskinde bir yer tutur(app data- program files da falan) ve sql senin qurdugun
tablelari baslayir hansisa fayllarda saxlamaga. Ve bu fayllarda saxlanilan struktur ferqli ola biler mes:
banner ile(birbasa 0, 1 lerle).Tutalim bu proqramda mueyyen datalar saxlanilib ve biz bunu goturub insert(qosmaq)
etmek isteyirik gelirik bu proqramin icinde komanda veririk. Burda bir hisse var ki komandalar yazilir mehz
ozune geden. neyse yazirig [ insert into student(name, age) values("Emin", 25) ] student table-in  adidir, sonra
istediyimiz deyisenleri yazdig meselen surname-i goturmedik hec, sonra deyerleri name Emin , age 25 yazdig ve bunlar
gelir database oturur(bayag dediyimiz jurnal strukturuna). Update etmek isteyende ise [ update student set
name="EMIN" where name="Emin" ] daha deyisenler yazmadig table adi, set, sonra name boyuk herflerle yazilmis EMIN et
haradaki name-e Emin yazilib dedik.Her bir setr oturanda onun id-side oturur, istesek bayagki update komandasini
id-ye gore de ede bilerik meselen bayagkina where id=1 seklinde yaza bilerik.Silmek komandasinda [ delete from
student where id=1 ] seklinde yazirig, where yazmasag butun student-i silecek, burda name-e gore de sile bilerik
baxir isteye sadece studen appmizde id gore silirdik. Id 1 silindise 2 ci setrde olanin id deyisib 1 olmur eyni qayda
da qalir meselen 4-u sildik , siralama 2,3,5 bele gedir.Yuxarda insert komandasina id-de elave ede bilerdik yeni
(id, name, age) values (1, "Emin" , 25) ancag bu yaxsi hal deyil ist.de olunmur cunki meselen emin mueyyen derslerden
il erzinde qiymetler alib ve biz gelib ora serxani yerlesdirsek orda olan qiymetler serxanin olmasa da onun adinda
gorunecek, real olmayacag . Id silindise ise o id bir daha istifade olunmaz.Select komandasi readfile kimidir
butun student gotur desek select * yazirig bura where de yaza bilerik mes: where age>=18, veya ulduz yerine
name, age yazarag ancag bu deyisenleri ceke bilerik ve s.
[ select * from student ] , [ select * from student where age>=18 ], [ select name, age from student where age>=18 ]
ve s.Where-ni artira da bilerik mes wehere age>=18 and name="Emin" or surname= "Sultanov"; bu sekilde.
Sql deyende ele baza dili- temel dil varki o butun databaselerde kecir ancag ele queryler var ki bazalarin ozune
xas olur.Bunu ancag bazanin ozu basa dusur yeni hemin baza tipi basa dusur.Bunlar MySql, PostgreSql, Oracleda ikisi
var PlSql, OracleSql, ves. basqa datebase serverlerde(diller) var.Bunlarin ortaq dili sql.dir. Plsql-de selcet lower
funksiyasi var yeni lower name deyib adlari balacaynan yazirsan. Nu mysql de to.upper seklindedi. Hazir funksiyalardi
java string.valeueof ve s. kimi.Server ona gore deyilir ki musteriynen elaqe girib xidmet eliyir.Yalniz ozu ucun
isleyen , musteri ile elaqeye girmeyen proqrama server deyilmir, buna job ve ya cron app deyilir.Servere daimi olaraq
kiminse(musteri) eli catir.Serverin bir standarti olur ve bu komandalar vasitesiyle xidmet edir.Bizde bele(server)
proqram qura bilerik.

Bir proteky qurdug- maven secdik, create from archetype xanasina qus, asagida maven-archetype-quickstart secib
next, proyetktin secilme yerinde bir folder acdig(TeacherManagement) bunun da icinde bir folder de acdig
(teachermanagentdb) ve ele proyektin adi da bu olur yeni proyekt bunun icinde qurulacag.Sonra groupId valuesuna
az.charming yazdig, artifactId- proyektin(jarin adi) adiyla uste dusur, versiya 1.0-Snapshot. Snapshot olmasi
test olan lahiyeoldugu ucundur, tam istifadeye cixanda 1.0 la buraxa bilerik.Ve finish proyekt quruldu.
Pom.xml bir standartla quruldu icinde dependency-ler, kodlar falan var eger web archetype secseydik web ucun olan
kodlar falan geleceydi.Bu bir arhetype-dir.Archetype sadece pomdaki kodlar deyil , bizim proyektin strukturuna
da tesir ede biler, meselen elave folderler acar, orda hazir clas ola biler, controller olar. Bir defe archetype
qurursan novbeti defe archetype quranda ona esasen senin proyektin strukturu formalasir.Bezi kitabxanalari
repository-den gotururuk.
GroupId- bu proyektin structure- ile eynidi ancag hokmen deyil bu bele olmalidi sadece convention-dir.
Bir qrupda appler yerlesir, meselen maven repoda mysql qrupda bir cox applar var ,connector ve s. applerde
artifactId lerdi biz teachermanagementdb-dir, web desktop,ape ve s lahiyeler ola biler.Artifact -proyektin jari
gedir.Jar compile olanda sonra comment icinde appin adi, versiya ve noqte jar yazilir.
<groupId>az.charming</groupId>
  <artifactId>teachermanagementdb</artifactId>
  <version>1.0-SNAPSHOT</version>

name lahiyenin adi yazilir, url-proyektin sayti yazilir. Properties-de utf -8 falan shriftlerdir, sonra
  1.7 compiler var deyisib 1.8 de etmek olar ves.
   <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <maven.compiler.source>1.7</maven.compiler.source>
    <maven.compiler.target>1.7</maven.compiler.target>
  </properties>

 <dependencies>
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.11</version>
      <scope>test</scope>
    </dependency>
  </dependencies>
isin cani dependencies-dir proyekt ilk defe junitle qurulub, grup junit icinde artifact junit ve bununda
icinde artifactversiya, versiyaninda icinde scope test deyir yeni test merhelesinde istifade olunur sonra
lazim deyil.Bunlari maven repo saytinda girib goreceyik ki eyni dependency yazilib.Pom da yazilmagi odurki
ele gelib bu saytdan yukleyir.Bu jarinda adi junit-411.jar dir googleda birbasa yazsag cixacag ele.Intellijde
solda external libraries baxsag goreceyik ele yukleyib Maven: junit:junit:4.11 . Bunun altinda da 1.3 proyekti
de var yeqinki junit icerde basqa jarlar istifade edib onuda ozuyle getirib.Sonra build hissesi var burda
pluginler istifade olunub mesele clean ucun bir plugin, complier ucun basqa bir, jar ucun ve s. pluginler
istifade olunub. Install plugin ise goturur proyekti clean, build, edir, jari duzeldir kompda bir yer var ora
atir.Pluginler bir jardir ancag proyektin icinde getmir, neceki junit kimi , junit de test merhelesinde lazim
olur sonra proyetktin icinde olmur. Sagda maven-e vursag gorerik icinde plugins var eyni pomun icindekilerdir.
Ve uzerine vurub clean, compile falan ede bilerik.Compiler:compile etdik target folderini qurdu.Eger clean
etsek target gedecek.Compile dena sonra jar edirik ve jari targetin icine atir.Install edende xeta atdi ve gedib
lifecycle-dan install edirik ve install olur.Bizim kompunda local reposu var neceki biz mavendan gradledan
yuklediyimiz dependencyler gelir oturur bura.Bu users de username de hidden file olur. .m2/repositroy burda
yerlesir. sonra cd group adi, cd artifact adi, cd versiya daxil olanda bizi jara apardi.Bu lahiyenin ozunu
basqa bir lahiyede dependency olaraq istifade ede bilerik.Cunki bu ozude bir jardir.Bu zaman senin kompun
repository rolunu oynayacag ve hemen lahiye senin bu lahiyevi (teachermanagementdb jarini) gedecek o repodan
tapacag.Bunu desktop appa gelende edeceyik ozumuze bunu dependency olaraq qosacayig.Burda ele juniti qosmusug
repository yerinde cd junit, cd 4.11 e girsek gorerik. demeli ilk once mavenden jar goturur oz localina elave
edir sonra burdan qosur.my connector jari qosurug ve icinde goreceyik ki bir cox versiya var ve bu versiyani
istifade eden lahiyelerin sayi yazilib onunde.Meselen burda hukari var eger o mysql-in 1.2 versiyasini istifade
edir ve sen ise 1.3 istifade edirsense tutmayacag , bele partlamalar olur onuncun 1 ci kitabxanan hansi
kitabxananin hansi versiyasini axtarirsa mutleq sekilde onu istifade etmelisen.connectorun dependecynin goturub
pomda dependencies arasina yazib M duymesine vurursan.yuxarinda da commente yazib ki burdan cekirem. sonra gedib
terminalda baxa bilerik repository-de cd mysql, cd mysql-connector-java, cd 8.0.22 edenden sonra jarini gorerik.
pom.xml mavenin faylidir proyekt uzerinde neler edeceyimizi teyin edir ve maven burda isleyir.ya kompa yuklenir
ya da intellig ustunde gelir.maven proyektin jara qurulana qeder olan prosesi idare edir buna da deyirler
lifecycle deyirler.Onceki dersde dediyimiz kimi maven de lifecycle mudaxile ede bilmirik, meselen 2 lahiye var
db ve console isteyirik ki deyek ilk get console build ele sonra gotur db-de istifade ele ancag bunu ede
maven deye bilmirik ancag ant-da dependsOn variydi elle yazib deyirdik, ancag maven dependecyleri avtomatik
yukleyirsen(kitabxanalari) ancag antda elle yazirsan.maven de pluginler var bu deyir ki men bu isleri gore
bilirem ve maven ozu cagirir, ancag antda target var bu gormeli oldugu isin ozudur.antda meselen compile
yazib src fayli goturur atir classes, sonra jarda depends compile var yeni jar dan once bunu etmelisen, buda
lifecycle mudaxile etmekdir.gradle de tasklar falan var xml deyil kod seklinde yazilir.
connector dependecynin yazdig ki(pomda dependenciesler arasinda) mysql elaqe saxlasin ve bununcunde
az.charming paketinde bir connect paketi acirig icinde bir clasig, bir metodda kodu yazirig bu kodu
stackoverflowdan(java toconnect mysql yazarag) goturduk:
 public static void connect(){
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("show databases;");
            System.out.println("Connected");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
Driver yukledi bunu sagda connector folderinden yukleyir com.mysql falan yerlesdiyi yerleri gosterir.
Yeni mavenle mysql-e bayag qosuldug indi de bir clasla kodu yazib driver yukledik ki elaqe qurag.
Driverin icine baxsag gorerik ki ise driveri load edirsen, static blok ise dusur ve driveri register
edir bu blokda.Register etmek driveri massive yuklemek demekdi.DriverManager.getConnection bu metod
gedir massivin icine baxir ki mysqlden gelen driverdi? ve gelir drivere deyir bura connect ol.Ve driverde
buna conncetion obyekti qaytarir.
"jdbc:mysql://127.0.0.1:3306/localhost","root","11111111"); demeli deyisib bele etdik hostu(127..) yazdig,
databasename(localhost), username(root), ve parol(1111..) yazdig.
 Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("show databases;"); bunu sildik bu gelecek dersimizdi.
bura yazdigimiz username, database ler falan sehviydi freemysqlhosting.net ssytindan kecib ordan goturdum
muellim kimi kodda email-e geldi. ve kodlari stringlerle seliqeye saldim:
public static void connect(){
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String host = "sql7.freemysqlhosting.net";
            String port = "3306";
            String db = "sql7387887";
            String username = "sql7387887";
            String password = "sgyKgwscUu";
            String conUrl = String.format("jdbc:mysql://%s:%s/%s",host,port,db);
            Connection con= DriverManager.getConnection(conUrl,username,password);
            System.out.println("Connected");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

    }

ve app-de main metodunda  MySQLConnect.connect(); deyib run egtdik capa- Connected verildi yeni qosuldu.
Ve githuba oturmek ucun bu proyekti charming_teachermanagementdb depo acib kompda TeacherManagement-e
atdig ve burdaki proyekyimi olan teachermanagementdb girib icindekileri charming_.. folderine kocurduk,
teachermanagementdb bunu sildik ve intellijde charmingi acdig. git bash-da touch .gitignore yazib
gitignore fayli acdig ve targeti bura elave etdik(yeni bunu push etme), ve bunlari mastere push etdik, gitignore
faylinda /target
         /target/** yazirig yeni targeti ve icindekileri push etme.
git checkout - b usercrud
yazdig yeni usercrud adli branch ac. git push sonra da git push --set-upstream origin usercrud
yazanda localda acdigin branch gedir oturur githuba,git branch yazanda
localinda movcud olan branchlari gosterir.Branchlar arasinda kecid edende kodlar deyisir.(Eger iml file itse , problem
olsa sagda maven vurub dongu -kruq isaresine vurursan gelir),git checkout master yazanda kecir mastere, "idea faylini
push edirik cunki bezen problemler aca bilir, meselen muellimde oldu brancha kecende dedi idea da workspace.xml var
onu push et". usercrud branchinda System.out.println("usercrud"); app-main de bele kod yazdig masterden ferqlendirmek
ucun ve kecid edende goreceyik ki masterde bu kod yoxdur, tebii ki etdiyin elaveleri gerek git add, commit falan edesen.
add commit localdaki gite aiddir, push edende gedir servere.serverde branch qurub locala cekende git pull(git fetch)
deyirik.serverde de test branchi acdig ve pull edib locala cekdik. terminalda git checkout origin/test yazanda birbasa
serverdeki brancha kecid edir ve burda etdiyin deyisikleri local test gormur. git push origin HEAD:test
bele bir sey verir headin dalina branch adini biz yazirig.ve bize teklif edirki 1 commit dalasan serverden pull edib
locala cek onu. git branch -D test -localdan silir, git push origin --delete test - ise serverden silir.
 */