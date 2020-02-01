package com.coleman.randomizer.utils;

import org.springframework.stereotype.Component;
import java.util.Random;

@Component
public class RandomUtils {

    Random r = new Random();
    private final String characters="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final int charactersLength = characters.length();
    private final String[] stateAbv={"AL","AK","AZ","AR","CA","CO","CT","DE","FL","GA","HI","ID","IL","IN","IA","KS","KY","LA","ME","MD","MA","MI","MN","MS","MO","MT","NE","NV","NH","NJ","NM","NY","NC","ND","OH","OK","OR","PA","RI","SC","SD","TN","TX","UT","VT","VA","WA","WV","WI","WY"};
    private final int stateAbvLength = stateAbv.length;
    private final String[] cityNames={"Alexander City","Andalusia","Anniston","Athens","Atmore","Auburn","Bessemer","Birmingham","Chickasaw","Clanton","Cullman","Decatur","Demopolis","Dothan","Enterprise","Eufaula","Florence","Fort Payne","Gadsden","Greenville","Guntersville","Huntsville","Jasper","Marion","Mobile","Montgomery","Opelika","Ozark","Phenix City","Prichard","Scottsboro","Selma","Sheffield","Sylacauga","Talladega","Troy","Tuscaloosa","Tuscumbia","Tuskegee","Anchorage","Cordova","Fairbanks","Haines","Homer","Juneau","Ketchikan","Kodiak","Kotzebue","Nome","Palmer","Seward","Sitka","Skagway","Valdez","Ajo","Avondale","Bisbee","Casa Grande","Chandler","Clifton","Douglas","Flagstaff","Florence","Gila Bend","Glendale","Globe","Kingman","Lake Havasu City","Mesa","Nogales","Oraibi","Phoenix","Prescott","Scottsdale","Sierra Vista","Tempe","Tombstone","Tucson","Walpi","Window Rock","Winslow","Yuma","Arkadelphia","Arkansas Post","Batesville","Benton","Blytheville","Camden","Conway","Crossett","El Dorado","Fayetteville","Forrest City","Fort Smith","Harrison","Helena","Hope","Hot Springs","Jacksonville","Jonesboro","Little Rock","Magnolia","Morrilton","Newport","North Little Rock","Osceola","Pine Bluff","Rogers","Searcy","Stuttgart","Van Buren","West Memphis","Alameda","Alhambra","Anaheim","Antioch","Arcadia","Bakersfield","Barstow","Belmont","Berkeley","Beverly Hills","Brea","Buena Park","Burbank","Calexico","Calistoga","Carlsbad","Carmel","Chico","Chula Vista","Claremont","Compton","Concord","Corona","Coronado","Costa Mesa","Culver City","Daly City","Davis","Downey","El Centro","El Cerrito","El Monte","Escondido","Eureka","Fairfield","Fontana","Fremont","Fresno","Fullerton","Garden Grove","Glendale","Hayward","Hollywood","Huntington Beach","Indio","Inglewood","Irvine","La Habra","Laguna Beach","Lancaster","Livermore","Lodi","Lompoc","Long Beach","Los Angeles","Malibu","Martinez","Marysville","Menlo Park","Merced","Modesto","Monterey","Mountain View","Napa","Needles","Newport Beach","Norwalk","Novato","Oakland","Oceanside","Ojai","Ontario","Orange","Oroville","Oxnard","Pacific Grove","Palm Springs","Palmdale","Palo Alto","Pasadena","Petaluma","Pomona","Port Hueneme","Rancho Cucamonga","Red Bluff","Redding","Redlands","Redondo Beach","Redwood City","Richmond","Riverside","Roseville","Sacramento","Salinas","San Bernardino","San Clemente","San Diego","San Fernando","San Francisco","San Gabriel","San Jose","San Juan Capistrano","San Leandro","San Luis Obispo","San Marino","San Mateo","San Pedro","San Rafael","San Simeon","Santa Ana","Santa Barbara","Santa Clara","Santa Clarita","Santa Cruz","Santa Monica","Santa Rosa","Sausalito","Simi Valley","Sonoma","South San Francisco","Stockton","Sunnyvale","Susanville","Thousand Oaks","Torrance","Turlock","Ukiah","Vallejo","Ventura","Victorville","Visalia","Walnut Creek","Watts","West Covina","Whittier","Woodland","Yorba Linda","Yuba City","Alamosa","Aspen","Aurora","Boulder","Breckenridge","Brighton","Canon City","Central City","Climax","Colorado Springs","Cortez","Cripple Creek","Denver","Durango","Englewood","Estes Park","Fort Collins","Fort Morgan","Georgetown","Glenwood Springs","Golden","Grand Junction","Greeley","Gunnison","La Junta","Leadville","Littleton","Longmont","Loveland","Montrose","Ouray","Pagosa Springs","Pueblo","Silverton","Steamboat Springs","Sterling","Telluride","Trinidad","Vail","Walsenburg","Westminster","Ansonia","Berlin","Bloomfield","Branford","Bridgeport","Bristol","Coventry","Danbury","Darien","Derby","East Hartford","East Haven","Enfield","Fairfield","Farmington","Greenwich","Groton","Guilford","Hamden","Hartford","Lebanon","Litchfield","Manchester","Mansfield","Meriden","Middletown","Milford","Mystic","Naugatuck","New Britain","New Haven","New London","North Haven","Norwalk","Norwich","Old Saybrook","Orange","Seymour","Shelton","Simsbury","Southington","Stamford","Stonington","Stratford","Torrington","Wallingford","Waterbury","Waterford","Watertown","West Hartford","West Haven","Westport","Wethersfield","Willimantic","Windham","Windsor","Windsor Locks","Winsted","Apalachicola","Bartow","Belle Glade","Boca Raton","Bradenton","Cape Coral","Clearwater","Cocoa Beach","Cocoa-Rockledge","Coral Gables","Daytona Beach","De Land","Deerfield Beach","Delray Beach","Fernandina Beach","Fort Lauderdale","Fort Myers","Fort Pierce","Fort Walton Beach","Gainesville","Hallandale Beach","Hialeah","Hollywood","Homestead","Jacksonville","Key West","Lake City","Lake Wales","Lakeland","Largo","Melbourne","Miami","Miami Beach","Naples","New Smyrna Beach","Ocala","Orlando","Ormond Beach","Palatka","Palm Bay","Palm Beach","Panama City","Pensacola","Pompano Beach","Saint Augustine","Saint Petersburg","Sanford","Sarasota","Sebring","Tallahassee","Tampa","Tarpon Springs","Titusville","Venice","West Palm Beach","White Springs","Winter Haven","Winter Park"};
    private final int cityNamesLength = cityNames.length;
    private final String[] streetNames={"1st Road","1st Street","2nd Road","2nd Street","Abner Avenue","Adams Court","Addison Court","Addison Road","Alex Court","Allison Circle","Alta Vista Court","Alta Vista Drive","Altura Court","Amnesty Place","Anderson Avenue","Andes Court","Andes Drive","Andover Drive","Andrew Lane","Ann Street","Anna River Court","Annamohr Drive","Antietam Avenue","Antler Court","Antler Point Trail","Anvil Court","Appleby Way","Appling Valley Road","Ardmore Place","Aristotle Court","Aristotle Drive","Armory Court","Armstrong Street","Arniel Place","Arrowhead Circle","Arrowhead Drive","Arrowhead Park Drive","Artery Drive","Ashby Place","Ashford Green Drive","Ashleigh Court","Ashleigh Road","Ashton Oaks Court","Ashton Oaks Drive","Aspen Willow Drive","Assembly Drive","Atlanta Street","Austrian Pine Court","Autumn Court","Autumn Willow Drive","Avondale Drive","Ballynahown Circle","Ballynahown Place","Bannockburn Court","Bantry Terrace","Barbour Drive","Barringer Place","Battenburg Lane","Bea-Mar Court","Beaumont Court","Beaumont Street","Beech Ridge Court","Beech Ridge Drive","Beech Tree Court","Bellavia Lane","Bellmont Drive","Bentonbrook Drive","Berkshire Woods Drive","Berritt Street","Berry Street","Berwynd Court","Berwynd Road","Bevan Drive","Bideford Square","Billingham Street","Birkdale Way","Black Ironwood Drive","Blackthorn Court","Blue Coat Drive","Blue Topaz Lane","Blythewood Drive","Bob Court","Bobs Ford Road","Boxford Court","Braddock Knoll Way","Braddock Road","Bradfield Place","Brandermill Court","Breckinridge Lane","Brentwood Farm Drive","Bridgend Run","Brigade Drive","Briggs Court","Briggs Road","Broadview Drive","Brookline Drive","Brookridge Place","Brookwood Drive","Buckhorn Ridge","Buckleys Gate Drive","Bunche Road","Burrows Avenue","Byrd Court","Byrd Drive","Cahoon Court","Caisson Road","Caldicot Lane","Camborne Terrace","Cambridge Court","Cambridge Lane","Cambryar Street","Canfield Street","Cannonball Road","Capeway Court","Capt John Smith Court","Captain John Smith Court","Cardoness Lane","Carisbrooke Lane","Carol Street","Caronia Way","Carriage Gate Court","Carrisbrooke Lane","Castlecary Lane","Castner Court","Catesby Row","Cavalier Court","Cavalier Landing Court","Cavalry Drive","Cedar Avenue","Cedar Forest Drive","Center Street","Cerromar Place","Chain Bridge Road","Chalkstone Court","Chalkstone Way","Chancery Court","Chancery Park Drive","Chariot Court","Charles Drive","Charles M Bailey Road","Chartres Way","Chesapeake Lane","Chesapeake River Way","Chestermill Court","Chestermill Drive","Chestnut Street","Christie Jane Lane","Chronical Drive","Church Street","Cleveland Street","Clovet Drive","Cobb Drive","Colchester Hunt Drive","Colchester Meadow Lane","Colchester Road","Collier Road","Collin Chase Place","Colony Road","Confederate Lane","Copper Lane","Cornell Road","Cornerstone Court","Cornwall Court","Cornwall Road","Cortez Court","Cortez Drive","Country Hill Drive","County Road 612","County Road 655","Courthouse Drive","Courtney Drive","Cover Place","Crescent Drive","Crest Street","Crewshore Drive","Crouch Drive","Crupper Place","Cupp Drive","Dale Drive","Daniels Run Court","Daniels Run Way","Darby Street","Decatur Court","Decatur Drive","Decour Court","del Mar Court","del Rio Drive","Delegate Court","Delsignore Drive","Democracy Lane","Derring Lane","Devilwood Court","Devin Green Lane","Dixie Hill Road","Dranes Tavern Drive","Dudley Court","Dudley Heights Court","Dungannon Road","Dunhill Drive","Dunster Court","East Street","Easter Lane","Eaton Place","Edenderry Drive","Egan Drive","Elm Forest Way","Elmont Court","Elsa Court","Embassy Lane","Englemeade Drive","English Holly Drive","English Maple Lane","Estate Court","Ethels Pond Court","Evesham Lane","Excelsior Place","Fairchester Drive","Fairfax Boulevard","Fairfax Estates Drive","Fairfax Hills Way","Fairfax Hunt Road","Fairfax Meadows Circle","Fairfax Ridge Road","Fairfax Street","Fairfax Village Drive","Fairfax Woods Way","Fairhaven Court","Fairview Drive","Farmington Drive","Farr Avenue","Farr Drive","Farr Oak Circle","Farr Oak Place","Farrcroft Drive","Farrcroft Green","Featherfield Court","Federalist Way","Fern Street","Fieldwood Court","Fieldwood Drive","Finchem Court","Firethorne Court","Flintlock Road","Flower Box Court","Ford Road","Forest Avenue","Forest Drive","Forest Hill Court","Forest Hill Drive","Forsgate Place","Fountainside Lane","Fox Chapel Road","Fox Hunter Place","Fox Run","Freeland Court","Gagne Court","Gagne Drive","Gainsborough Court","Galliec Street","Garden Grove Circle","Garden Path Lane","Garden Ridge Lane","Gary Hill Drive","George Mason Boulevard","George McKay Court","George McKay Lane","Ginger Tree Court","Glen Alden Road","Glen Mist Lane","Glostonbury Way","Goodwood Drive","Goolsby Way","Goth Street","Governor Yeardley Lane","Grand Commons Avenue","Great Oaks Drive","Great Oaks Way","Green Cap Place","Grenshaw Drive","Grey Finch Drive","Grover Glen Court","Groves Lane","Gunpowder Road","Hackney Coach Lane","Hallman Street","Hamlet Hill Court","Hamlet Hill Way","Hampton Forest Court","Hampton Forest Way","Hampton Lane","Harper Drive","Harrow Court","Harrow Lane","Harvest Place","Harvey Drive","Hazelwood Court","Heart Leaf Court","Heatherford Court","Heatherford Place","Heatherstone Court","Hemlock Way","Heritage Lane","Heron Ridge Drive","Hexagon Place","Highland Terrace","Hill Drive, North","Hill Street","Holiday Lane","Hollow Tree Lane","Holly Avenue","Holly Street","Holston Street","Homewood Way","Honey Brook Court","Hope Park Road","Howerton Avenue","Howsen Avenue","Hoylake Lane","Huntwood Manor Drive","Inglenook Drive","Innisvale Drive","James Swart Circle","James Wren Way","Jancie Road","Jean Street","Jenny Lynne Lane","Jermantown Road","Jessie Court","John Mason Place","John Trammell Court","Jones Street","Joyce Drive","Judicial Drive","Keith Avenue","Kelley Drive","Kenmore Drive","Kentmere Square","Kentshire Way","Kentstone Way","Kenwood Terrace","Kieland Ridge Road","Kings Color Drive","Kitty Pozer Drive","Knight Arch Court","Knight Arch Road","Kristina Court","la Messa Drive","Ladue Lane","Ladues End Lane","Lafferty Lane","Lake Normandy Court","Lake Normandy Lane","Lamarre Drive","Larry Road","Laurel Lake Square","Layton Hall Drive","Lee Highway","Lee Jackson Memorial Highway","Lee Street","Leehigh Court","Leehigh Drive","Legato Road","Leonard Drive","Lewisham Road","Lexington Court","Lincoln Drive","Lincoln Lake Way","Linden Street","Littlebrook Lane","Lochleven Trail","Locust Lane","Locust Street","Lord Culpeper Lane","Lower Park Drive","Lynford Lane","Mactavish Hts","Main Street","Maple Forest Court","Maple Street","Marengo Court","Marilta Court","Marlstone Lane","Marquis Court","Marymead Drive","Mason Oaks Court","Mason Street","Massey Drive","Mattie Moore Court","Mavis Court","Mayde Court","McCarty Crest Court","McDuffie Lane","McKenzie Avenue","McLean Avenue","McLearen Court","Meadow Bridge Lane","Meadow Estates Drive","Meath Court","Meath Drive","Megan Drive","Melissa Court","Mendell Street","Meredith Drive","Merion Lane","Metcalf Circle","Milburn Street","Mill Rock Drive","Milroy Crest Street","Milroy Way","Minoso Drive","Mobile Court","Mobile Drive","Monica Court","Monmouth Street","Monroe Court","Monteith Lane","Monument Corner Drive","Monument Hill Way","Monument Wall Way","Moore Street","Morningside Court","Mosby Woods Court","Mosby Woods Drive","Muddler Way","Musket Court","Myrtle Leaf Drive","N Hill Drive","Nancy Drive","Nancyann Way","Naoma Court","Newbury Road","Newman Road","Nomes Court","Norman Avenue","North Street","Novak Lane","Oak Hill Way","Oak Place","Oak Place Court","Oak Street","Oakcrest Court","Oakcrest Drive","Oakwood Drive","Octagon Court","Odie Court","O'Faly Road","Old Lee Highway","Old Post Road","Old Sawmill Road","Oliver Street","Olivia Drive","Orchard Street","Overbridge Lane","Owens Glen Drive","Ox Road","Ox Road, West","Oxford Lane","Page Avenue","Park Chase Drive","Park Drive","Park Green Court","Park Green Drive","Park Hill Place","Park Road","Park Vista Boulevard","Parklane Road","Patriot Circle","Peach Leaf Place","Peep Toad Court","Pelham Lane","Pender Drive","Perry Street","Pheasant Ridge Road","Phoenix Drive","Pine Forest Circle","Pine Park Court","Pine Street","Pinehurst Avenue","Piney Branch Road","Plantation Pkwy","Plaza Drive","Plow Court","Pohick Lane","Popes Head Road","Popes Head View Lane","Poplar Street","Potomac Crossing Way","Presidents Park Drive","Prestwick Drive","Price Club Plaza","Providence Way","Pumpkin Place","Queen Anne Drive","Queens Brigade Court","Queens Brigade Drive","Quiet Brook Road","Raider Lane","Railroad Avenue","Railroad Court","Ramona Drive","Ramrod Court","Randolph Street","Random Hills Road","Ranger Road","Ratcliffe Manor Drive","Redford Court","Redwood Court","Regent Park Court","Ren Road","Renfrew Street","Revercomb Court","Rhett Lane","Richardson Place","Ridge Avenue","Ridge Top Road","Ridge View Drive, West","Rivanna Lane","Rivanna River Lane","Robertson Farm Circle","Robeys Meadow Lane","Rochester Drive","Rock Garden Drive","Rockaway Lane","Rodgers Road","Roma Street","Rose Thicket Lane","Rosehaven Street","Rothbury Square","Rowan Tree Drive","Royal Wolf Place","Ruby Drive","Ruffin Court","Ruffin Drive","Runabout Lane","Rust Hill Place","Rust Road","Sabastian Drive","Saber Circle","Sablewood Court","Saddle Horn Drive","Saddle Horse Place","Sager Avenue","Saint Andrews Drive","Saint Edwards Place","Saint Johns Place","Salina Court","Sammy Joe Drive","San Carlos Drive","San Juan Drive","San Marcos Court","San Marcos Drive","Sandra Lane","Santa Clara Court","Santa Clara Drive","Sasher Lane","Scarlet Circle","School Street","Scooter Lane","Scott Drive","Scout Drive","Sedgefield Road","Senatorial Lane","Sessions Court","Sewickley Place","Shadow Valley Drive","Sharpes Meadow Lane","Shaughnessy Court","Shenandoah Lane","Sherman Street","Sherwood Forest Way","Sherwood Street","Shiloh Circle","Shiloh Street","Shirley Gate Court","Shirley Gate Road","Sideburn Road","Silver Cypress Terrace","Simpson Mews Lane","Singleton Circle","Slatestone Court","Snughaven Lane","Sperrin Circle","Spring Lake Court","Spring Lake Terrace","Springmann Drive","Spruce Avenue","Spruce Street","Stackler Drive","Staffordshire Drive","Stallion Chase Court","Stanrich Court","State Route 123","State Route 236","State Route 608","State Route 614","State Route 620","State Route 645","Stevenson Street","Stockton Tees Lane","Stonehenge Way","Stratford Avenue","Stringfellow Road","Summit Corner Drive","Summit Drive","Summit Heights Way","Sunflower Lane","Sunrise Gr","Swarts Drive","Swedes Street","Taba Cove Court","Tall Pines Court","Tecumseh Lane","Tenbury Terrace","Thayer Court","Thoreau Lane","Thornaby Way","Thornbury Drive","Tiger Lily Lane","Timber Log Way","Timber Meadow Drive","Towlston Road","Tractor Lane","Traveler Street","Trowbridge Court","Trowbridge Street","Trumpet Vine Drive","Truro Lane","Tumbrel Court","Tusico Place","Tydfil Court","University Drive","Upper Park Drive","US Highway 29","US Highway 50","Vail Ridge Lane","Vanderbilt Court","Vawter Terrace","Verde Vista Drive","Verret Drive","Via Drive","Viera Lane","Village Drive","Vineyard Lane","W Ox Road","W Ridge View Drive","Walcott Avenue","Walnut Cove Circle","Walnut Street","Walters Court","Waples Mill Road","Waples Mobile Home Ests","Warren Lane","Warwick Avenue","Warwick Circle","Washington Street","Water Elm Way","Weatherington Lane","Werthers Court","West Drive","West Street","Westbrook Drive","Westbrook Mill Lane","Western Street","Westmore Drive","Whisper Willow Drive","White Drive","White Oak Court","Whitehead Street","Whittemore Place","Wilburn Drive","Willard Way","William Place","Willow Crescent Drive","Willow Springs School Road","Willowmeade Drive","Wilson Street","Windsor Gate Lane","Winfield Road","Winscombe Terrace","Winston Place","Winter Willow Circle","Winter Willow Drive","Wood Road","Woodhaven Court","Woodhaven Drive","Woodland Drive","Wyndham Creek Court","Yellow Brick Road","York River Road","Yorktown Court","Yorktown Drive","Zinnia Lane"};
    private final int streetNamesLength = streetNames.length;
    private final String[] firstNames = {"Emma","Liam","Benjamin","Charlotte","Amelia","James","Harper","Noah","William","Olivia","Sophia","Elijah","Ava","Logan","Mia","Lucas","Evelyn","Oliver","Mason","Isabella","Aria","Grayson","Riley","Caden","Aaliyah","Muhammad","Kairo","Elian","Meghan","Luka","Kailani","Everleigh","Hayes","Emory","Mathias","Alani","Ember","Kade","Walker","Emersyn","Lawson","Demi","Milo","Aspen","Daxton","Lia","Gael","Zuri","Jack","Walker","Saylor","Jensen","Journee","Arlo","Ryker","Eliza","Jameson","Jax","Leilani","Weston","Josie","Adalynn","Wesley","Delilah","Beau","Hadley","Archie","Birdie","Jacob","Ruthie","Alexander","Benjamin","Violet","Charlie","Wyatt","Adeya","Timothée","Ariana","Shawn","Normani","Adam","Rihanna","Travis","Stefani","Jennifer","Bryce","Taylor","Brie","Chris","Billie","Tarton","Daisy","Izzy","Ricky","Archie","Eli","Leo","Freddy","Tony","Randy","Frank","Rudy","Luca","Mateo","Elijah","Ezekiel","Genesis","Muhammad","Axel","Leif","Miles","Asher","Liam","Noah","William","James","Oliver","Benjamin","Elijah","Lucas","Mason","Logan","Alexander","Ethan","Jacob","Michael","Daniel","Henry","Jackson","Sebastian","Aiden","Matthew","Samuel","David","Joseph","Carter","Owen","Wyatt","John","Jack","Luke","Jayden","Dylan","Grayson","Levi","Isaac","Gabriel","Julian","Mateo","Anthony","Jaxon","Lincoln","Joshua","Christopher","Andrew","Theodore","Caleb","Ryan","Asher","Nathan","Thomas","Leo","Isaiah","Charles","Josiah","Hudson","Christian","Hunter","Connor","Eli","Ezra","Aaron","Landon","Adrian","Jonathan","Nolan","Jeremiah","Easton","Elias","Colton","Cameron","Carson","Robert","Angel","Maverick","Nicholas","Dominic","Jaxson","Greyson","Adam","Ian","Austin","Santiago","Jordan","Cooper","Brayden","Roman","Evan","Ezekiel","Xavier","Jose","Jace","Jameson","Leonardo","Bryson","Axel","Everett","Parker","Kayden","Miles","Sawyer","Jason","Genesis","Saint","Bake","Kairo","Watson","Kenzo","Jaxtyn","Kylo","Dakari","Karsyn","Mordechai","Bowie","Kamdyn","Bode","Ashton","Zaid","Onyx","Benicio","Wells","Archie","Krew","Santana","Zakai","Elian","Aries","Koda","Kabir","Deshawn","Denver","Wallace","Benedict","Crew","Kamryn","Ledger","Korbyn","Marcellus","Imran","Cairo","Huxley","Ralph","Koa","Kaiser","Luka","Harlem","Elon","Sonny","Gatlin","Memphis","Gianni","Brixton"};
    private final int firstNamesLength = firstNames.length;
    private final String[] lastNames = {"Smith","Johnson","Williams","Jones","Brown","Davis","Miller","Wilson","Moore","Taylor","Anderson","Thomas","Jackson","White","Harris","Martin","Thompson","Garcia","Martinez","Robinson","Clark","Rodriguez","Lewis","Lee","Walker","Hall","Allen","Young","Hernandez","King","Wright","Lopez","Hill","Scott","Green","Adams","Baker","Gonzalez","Nelson","Carter","Mitchell","Perez","Roberts","Turner","Phillips","Campbell","Parker","Evans","Edwards","Collins","Stewart","Sanchez","Morris","Rogers","Reed","Cook","Morgan","Bell","Murphy","Bailey","Rivera","Cooper","Richardson","Cox","Howard","Ward","Torres","Peterson","Gray","Ramirez","James","Watson","Brooks","Kelly","Sanders","Price","Bennett","Wood","Barnes","Ross","Henderson","Coleman","Jenkins","Perry","Powell","Long","Patterson","Hughes","Flores","Washington","Butler","Simmons","Foster","Gonzales","Bryant","Alexander","Russell","Griffin","Diaz","Hayes","Myers","Ford","Hamilton","Graham","Sullivan","Wallace","Woods","Cole","West","Jordan","Owens","Reynolds","Fisher","Ellis","Harrison","Gibson","Mcdonald","Cruz","Marshall","Ortiz","Gomez","Murray","Freeman","Wells","Webb","Simpson","Stevens","Tucker","Porter","Hunter","Hicks","Crawford","Henry","Boyd","Mason","Morales","Kennedy","Warren","Dixon","Ramos","Reyes","Burns","Gordon","Shaw","Holmes","Rice","Robertson","Hunt","Black","Daniels","Palmer","Mills","Nichols","Grant","Knight","Ferguson","Rose","Stone","Hawkins","Dunn","Perkins","Hudson","Spencer","Gardner","Stephens","Payne","Pierce","Berry","Matthews","Arnold","Wagner","Willis","Ray","Watkins","Olson","Carroll","Duncan","Snyder","Hart","Cunningham","Bradley","Lane","Andrews","Ruiz","Harper","Fox","Riley","Armstrong","Carpenter","Weaver","Greene","Lawrence","Elliott","Chavez","Sims","Austin","Peters","Kelley","Franklin","Lawson","Fields","Gutierrez","Ryan","Schmidt","Carr","Vasquez","Castillo","Wheeler","Chapman","Oliver","Montgomery","Richards","Williamson","Johnston","Banks","Meyer","Bishop","Mccoy","Howell","Alvarez","Morrison","Hansen","Fernandez","Garza","Harvey","Little","Burton","Stanley","Nguyen","George","Jacobs","Reid","Kim","Fuller","Lynch","Dean","Gilbert","Garrett","Romero","Welch","Larson","Frazier","Burke","Hanson","Day","Mendoza","Moreno","Bowman","Medina","Fowler","Brewer","Hoffman","Carlson","Silva","Pearson","Holland","Douglas","Fleming","Jensen","Vargas","Byrd","Davidson","Hopkins","May","Terry","Herrera","Wade","Soto","Walters","Curtis","Neal","Caldwell","Lowe","Jennings","Barnett","Graves","Jimenez","Horton","Shelton","Barrett","Obrien","Castro","Sutton","Gregory","Mckinney","Lucas","Miles","Craig","Rodriquez","Chambers","Holt","Lambert","Fletcher","Watts","Bates","Hale","Rhodes","Pena","Beck","Newman","Haynes","Mcdaniel","Mendez","Bush","Vaughn","Parks","Dawson","Santiago","Norris","Hardy","Love","Steele","Curry","Powers","Schultz","Barker","Guzman","Page","Munoz","Ball","Keller","Chandler","Weber","Leonard","Walsh","Lyons","Ramsey","Wolfe","Schneider","Mullins","Benson","Sharp","Bowen","Daniel","Barber","Cummings","Hines","Baldwin","Griffith","Valdez","Hubbard","Salazar","Reeves","Warner","Stevenson","Burgess","Santos","Tate","Cross","Garner","Mann","Mack"};
    private final int lastNamesLength = lastNames.length;
    private final String[] words = {"data","set","file","start","full","at","the","chat","record","log","bot","analytic","jan","feb","mar","apr","may","jun","jul","aug","sep","oct","nov","dec","Library","Liquid","Magnet","Man","Map","Maze","Meat","Meteor","Microscope","Milk","Milkshake","Mist","Onion","PaintBrush","Pants","Parachute","Passport","Pebble","Pendulum","Pepper","Perfume","Pillow","Plane","Planet","Pocket","Spectrum","Sphere","Spice","Spiral","Spoon","buff","grind","hone","rasp","rub","sand","echelon","rank","row","tier","chain","progression","sequence","succession","array","plane","scrape","sandblast","scour","burnish","dress","gloss","polish","shine","smooth","edge","sharpen","strop","whet","regrind","assess","diagnose","evaluate","examine","inspect","investigate","scrutinize","arrange","assort","catalog","categorize","classify","codify","diagram","enumerate","index","order","schematize","sort","tabulate","divide","reduce","segment","separate","subdivide","agglomerate","aggregate","amalgamate","assimilate","coalesce","conglomerate","consolidate","integrate","synthesize","unify","delineate","describe","document","render","outline","silhouette","sketch","illustrate","show","diagram"};
    private final int wordsLength = words.length;
    private final String[] dataset = {"flutter","rockeset","flighty","yellowbook","yelp-plus"};
    private final int datasetLength = dataset.length;


    public Integer randomNumber(int places) {
        int low = 1;
        int high = 10;
        String numberBuilder = "";
        for(int i = 0; i < places; i++) {
            String result = Integer.toString(r.nextInt(high - low) + low);
            numberBuilder += result;
        }
        return Integer.valueOf(numberBuilder);
    }

    public String randomCharacters(int places) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < places; i++) {
            sb.append(characters.charAt(r.nextInt(charactersLength)));
        }
        return sb.toString();
    }

    public String randomStateAbv() {
        return stateAbv[r.nextInt(stateAbvLength)];
    }

    public String randomCity() {
        return cityNames[r.nextInt(cityNamesLength)];
    }

    public String randomStreet() {
        return streetNames[r.nextInt(streetNamesLength)];
    }

    public String randomFirstName() {
        return firstNames[r.nextInt(firstNamesLength)];
    }

    public String randomLastName() {
        return lastNames[r.nextInt(lastNamesLength)];
    }

    public String randomWords() {
        return words[r.nextInt(wordsLength)];
    }

    public String randomDataset() {
        return dataset[r.nextInt(datasetLength)];
    }

    public String randomAddress() {
        int low = 2;
        int high = 8;
        int places = r.nextInt(high - low) + low;
        int address = randomNumber(places);
        String street = randomStreet();
        String city = randomCity();
        String state = randomStateAbv();
        int zip = randomNumber(6);

        return address+" "+street+", "+city+", "+state+" "+zip;
    }

    public Boolean randomBoolean() {
        int low = 1;
        int high = 4;
        int result = r.nextInt(high - low) + low;
        switch (result){
            case 1:
                return true;
            case 2:
                return false;
            case 3:
                return null;
        }
        return null;
    }

    public int randomYear() {
        int currentYear = 2020;
        int high = 35;
        int low = 0;
        return currentYear - r.nextInt(high - low) + low;
    }

    public int randomMonth() {
        int currentMonth = 12;
        int high = 12;
        int low = 0;
        return currentMonth - r.nextInt(high - low) + low;
    }

    public int randomDay() {
        int currentDay = 28;
        int high = 26;
        int low = 0;
        return currentDay - r.nextInt(high - low) + low;
    }

    public String randomTime() {
        int currentMinute = 60;
        int highMinute = 59;
        int currentTime = 24;
        int high = 23;
        int low = 0;
        int cHour =  currentTime - r.nextInt(high - low) + low;
        int cMinute = currentMinute - r.nextInt(highMinute - low) + low;
        int cSecond = currentMinute - r.nextInt(highMinute - low) + low;

        String tHour;
        String tMinute;
        String tSecond;
        if(cHour < 10) {
            tHour = "0"+cHour;
        } else {
            tHour = String.valueOf(cHour);
        }
        if(cMinute < 10) {
            tMinute = "0"+cMinute;
        } else {
            tMinute = String.valueOf(cMinute);
        }
        if(cSecond < 10) {
            tSecond = "0"+cSecond;
        } else {
            tSecond = String.valueOf(cSecond);
        }

        return tHour+":"+tMinute+":"+tSecond;
    }

    public String randomDate() {
        int cYear = randomYear();
        int cMonth = randomMonth();
        int cDay = randomDay();
        String time = randomTime();
        String tMonth;
        String tDay;

        if(cMonth < 10){
            tMonth = "0"+cMonth;
        } else {
            tMonth = String.valueOf(cMonth);
        }
        if(cDay < 10){
            tDay = "0"+cDay;
        } else {
            tDay = String.valueOf(cDay);
        }

        return cYear+"-"+tMonth+"-"+tDay+"T"+time+"Z";
    }

    public String randomFileName() {
        return randomDataset()+"_"+randomWords()+"_"+randomWords()+"_"+randomWords()+"_"+randomYear()+randomMonth()+randomDay()+".txt";
    }


}
