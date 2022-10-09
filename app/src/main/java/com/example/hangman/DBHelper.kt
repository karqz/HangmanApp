package com.example.hangman

import android.content.ContentValues
import android.content.Context

import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.hangman.models.*
import java.util.*

class DBHelper(context: Context)
    : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(db : SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE $CATEGORY_TABLE(" +
                            "$CATEGORY_ID_COL INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                            "$CATEGORY_NAME_COL TEXT NOT NULL" +
                        ")")
        db?.execSQL("CREATE TABLE $PASSWORD_TABLE(" +
                            "$PASSWORD_ID_COL INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                            "$PASSWORD_WORD_COL TEXT NOT NULL," +
                            "$PASSWORD_CATEGORY_COL INTEGER NOT NULL," +
                            "FOREIGN KEY($PASSWORD_CATEGORY_COL) REFERENCES $CATEGORY_TABLE($CATEGORY_ID_COL)" +
                        ");")
        db?.execSQL("CREATE TABLE $GAME_RESULT_TABLE(" +
                            "$GAME_RESULT_STATUS_COL BOOLEAN NOT NULL," +
                            "$GAME_RESULT_DATE_COL DATE NOT NULL" +
                        ")")
        populateDatabase(db)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $PASSWORD_TABLE")
        db?.execSQL("DROP TABLE IF EXISTS $CATEGORY_TABLE")
        db?.execSQL("DROP TABLE IF EXISTS $GAME_RESULT_TABLE")
        onCreate(db)
    }

    private fun populateDatabase(db: SQLiteDatabase?) {
        val geography = Category(0, "GEOGRAPHY")
        setDefaultCategory(db, geography)
        setDefaultPassword(db, Password(10, "MEXICO", geography))
        setDefaultPassword(db, Password(11, "GERMANY", geography))
        setDefaultPassword(db, Password(12, "RUSSIA", geography))
        setDefaultPassword(db, Password(13, "CZECH REPUBLIC", geography))
        setDefaultPassword(db, Password(14, "CHINA", geography))
        setDefaultPassword(db, Password(15, "LIBYA", geography))
        setDefaultPassword(db, Password(16, "QUEBEC", geography))
        setDefaultPassword(db, Password(17, "CANBERRA", geography))
        setDefaultPassword(db, Password(18, "PANGAEA", geography))
        setDefaultPassword(db, Password(19, "EQUATOR", geography))
        setDefaultPassword(db, Password(20, "ECUADOR", geography))
        setDefaultPassword(db, Password(21, "FINLAND", geography))
        setDefaultPassword(db, Password(22, "NORTH MACEDONIA", geography))
        setDefaultPassword(db, Password(23, "MONTENEGRO", geography))
        setDefaultPassword(db, Password(24, "VATICAN CITY", geography))
        setDefaultPassword(db, Password(25, "FLORIDA", geography))
        setDefaultPassword(db, Password(26, "MONTEVIDEO", geography))
        setDefaultPassword(db, Password(27, "BEIJING", geography))
        setDefaultPassword(db, Password(28, "SHANGHAI", geography))
        setDefaultPassword(db, Password(29, "SEOUL", geography))
        setDefaultPassword(db, Password(30, "JAPAN", geography))
        setDefaultPassword(db, Password(31, "MADAGASCAR", geography))
        setDefaultPassword(db, Password(32, "LESOTHO", geography))
        setDefaultPassword(db, Password(33, "MAURITANIA", geography))
        setDefaultPassword(db, Password(34, "MAURITIUS", geography))
        setDefaultPassword(db, Password(35, "COTE D'IVOIRE", geography))
        setDefaultPassword(db, Password(36, "MARIANA TRENCH", geography))
        setDefaultPassword(db, Password(37, "URAL", geography))
        setDefaultPassword(db, Password(38, "HIMALAYAS", geography))
        setDefaultPassword(db, Password(39, "PYRENEES", geography))
        setDefaultPassword(db, Password(40, "ULAANBAATAR", geography))
        setDefaultPassword(db, Password(41, "NEPAL", geography))
        setDefaultPassword(db, Password(42, "PHILIPPINES", geography))
        setDefaultPassword(db, Password(43, "PAPUA NEW GUINEA", geography))
        setDefaultPassword(db, Password(44, "BALTIC SEA", geography))
        setDefaultPassword(db, Password(45, "CASPIAN SEA", geography))
        setDefaultPassword(db, Password(46, "THAMES", geography))
        setDefaultPassword(db, Password(47, "SEKWANA", geography))
        setDefaultPassword(db, Password(48, "MOROCCO", geography))
        setDefaultPassword(db, Password(49, "NILE", geography))

        val food = Category(1, "FOOD")
        setDefaultCategory(db, food)
        setDefaultPassword(db, Password(50, "PIZZA", food))
        setDefaultPassword(db, Password(51, "SPAGHETTI", food))
        setDefaultPassword(db, Password(52, "TOMATO", food))
        setDefaultPassword(db, Password(53, "POTATO", food))
        setDefaultPassword(db, Password(54, "HORSERADISH", food))
        setDefaultPassword(db, Password(55, "COTTAGE CHEESE", food))
        setDefaultPassword(db, Password(56, "ROAST CHICKEN", food))
        setDefaultPassword(db, Password(57, "CUCUMBER", food))
        setDefaultPassword(db, Password(58, "CAESAR SALAD", food))
        setDefaultPassword(db, Password(59, "SANDWICH", food))
        setDefaultPassword(db, Password(60, "DUMPLINGS", food))
        setDefaultPassword(db, Password(61, "SUSHI", food))
        setDefaultPassword(db, Password(62, "PAD THAI", food))
        setDefaultPassword(db, Password(63, "KEBAB", food))
        setDefaultPassword(db, Password(64, "COCA COLA", food))
        setDefaultPassword(db, Password(65, "ENERGY DRINK", food))
        setDefaultPassword(db, Password(66, "TEA", food))
        setDefaultPassword(db, Password(67, "COFFEE", food))
        setDefaultPassword(db, Password(68, "MILK", food))
        setDefaultPassword(db, Password(69, "BRUNCH", food))
        setDefaultPassword(db, Password(70, "BRIOCHE", food))
        setDefaultPassword(db, Password(71, "BAGUETTE", food))
        setDefaultPassword(db, Password(72, "CUPCAKE", food))
        setDefaultPassword(db, Password(73, "CRACKERS", food))
        setDefaultPassword(db, Password(74, "GLUTEN-FREE BREAD", food))
        setDefaultPassword(db, Password(75, "TORTILLA", food))
        setDefaultPassword(db, Password(76, "SALT", food))
        setDefaultPassword(db, Password(77, "PEPPER", food))
        setDefaultPassword(db, Password(78, "CHILLI POWDER", food))
        setDefaultPassword(db, Password(79, "HOT POCKETS", food))
        setDefaultPassword(db, Password(80, "TWINKIES", food))
        setDefaultPassword(db, Password(81, "CORNFLAKES", food))
        setDefaultPassword(db, Password(82, "TEQUILA", food))
        setDefaultPassword(db, Password(83, "BEER", food))
        setDefaultPassword(db, Password(84, "BREAD SOUP", food))
        setDefaultPassword(db, Password(85, "STRAWBERRY", food))
        setDefaultPassword(db, Password(86, "BLUEBERRY", food))
        setDefaultPassword(db, Password(87, "GARLIC", food))
        setDefaultPassword(db, Password(88, "BEEF WELLINGTON", food))
        setDefaultPassword(db, Password(89, "FISH AND CHIPS", food))
        setDefaultPassword(db, Password(90, "CARROT", food))
        setDefaultPassword(db, Password(91, "CARROT CAKE", food))
        setDefaultPassword(db, Password(92, "ONION", food))
        setDefaultPassword(db, Password(93, "CABBAGE", food))
        setDefaultPassword(db, Password(94, "BURRATA", food))
        setDefaultPassword(db, Password(95, "MOZZARELLA", food))
        setDefaultPassword(db, Password(96, "PANCETTA", food))
        setDefaultPassword(db, Password(97, "FRUTTI DI MARE", food))
        setDefaultPassword(db, Password(98, "BACON", food))
        setDefaultPassword(db, Password(99, "OLIVE", food))

        val cinema = Category(2, "CINEMA")
        setDefaultCategory(db, cinema)
        setDefaultPassword(db, Password(100, "MEMENTO", cinema))
        setDefaultPassword(db, Password(101, "THE DARK KNIGHT", cinema))
        setDefaultPassword(db, Password(102, "FIGHT CLUB", cinema))
        setDefaultPassword(db, Password(103, "THE HOUSE THAT JACK BUILT", cinema))
        setDefaultPassword(db, Password(104, "DAVID LYNCH", cinema))
        setDefaultPassword(db, Password(105, "ERASERHEAD", cinema))
        setDefaultPassword(db, Password(106, "CASABLANCA", cinema))
        setDefaultPassword(db, Password(107, "MODERN TIMES", cinema))
        setDefaultPassword(db, Password(108, "THE SOCIAL NETWORK", cinema))
        setDefaultPassword(db, Password(109, "MANCHESTER BY THE SEA", cinema))
        setDefaultPassword(db, Password(110, "TAXI DRIVER", cinema))
        setDefaultPassword(db, Password(111, "THE GODFATHER", cinema))
        setDefaultPassword(db, Password(112, "PULP FICTION", cinema))
        setDefaultPassword(db, Password(113, "ONE FLEW OVER THE CUCKOO'S NEST", cinema))
        setDefaultPassword(db, Password(114, "THE SILENCE OF THE LAMBS", cinema))
        setDefaultPassword(db, Password(115, "SAVING PRIVATE RYAN", cinema))
        setDefaultPassword(db, Password(116, "STAR WARS", cinema))
        setDefaultPassword(db, Password(117, "MARVEL CINEMATIC UNIVERSE", cinema))
        setDefaultPassword(db, Password(118, "PSYCHO", cinema))
        setDefaultPassword(db, Password(119, "PARASITE", cinema))
        setDefaultPassword(db, Password(120, "AMERICAN HISTORY X", cinema))
        setDefaultPassword(db, Password(121, "WHIPLASH", cinema))
        setDefaultPassword(db, Password(122, "THE GRAND BUDAPEST HOTEL", cinema))
        setDefaultPassword(db, Password(123, "KILL BILL", cinema))
        setDefaultPassword(db, Password(124, "O BROTHER, WHERE ART THOU?", cinema))
        setDefaultPassword(db, Password(125, "KNIFE IN THE WATER", cinema))
        setDefaultPassword(db, Password(126, "AKIRA KUROSAWA", cinema))
        setDefaultPassword(db, Password(127, "STANLEY KUBRICK", cinema))
        setDefaultPassword(db, Password(128, "MARTIN SCORSESE", cinema))
        setDefaultPassword(db, Password(129, "FRANCIS FORD COPPOLA", cinema))
        setDefaultPassword(db, Password(130, "CLINT EASTWOOD", cinema))
        setDefaultPassword(db, Password(131, "MERYL STREEP", cinema))
        setDefaultPassword(db, Password(132, "KATHRYN BIGELOW", cinema))
        setDefaultPassword(db, Password(133, "LEONARDO DICAPRIO", cinema))
        setDefaultPassword(db, Password(134, "OLIVIA COLMAN", cinema))
        setDefaultPassword(db, Password(135, "BETTY WHITE", cinema))
        setDefaultPassword(db, Password(136, "THE SHINING", cinema))
        setDefaultPassword(db, Password(137, "AMERICAN BEAUTY", cinema))
        setDefaultPassword(db, Password(138, "INGLOURIOUS BASTERDS", cinema))
        setDefaultPassword(db, Password(139, "COCO", cinema))
        setDefaultPassword(db, Password(140, "GOOD WILL HUNTING", cinema))
        setDefaultPassword(db, Password(141, "ETERNAL SUNSHINE OF THE SPOTLESS MIND", cinema))
        setDefaultPassword(db, Password(142, "GONE WITH THE WIND", cinema))
        setDefaultPassword(db, Password(143, "WIZARD OF OZ", cinema))
        setDefaultPassword(db, Password(144, "VERTIGO", cinema))
        setDefaultPassword(db, Password(145, "WEST SIDE STORY", cinema))
        setDefaultPassword(db, Password(146, "THE BRIDGE ON THE RIVER KWAI", cinema))
        setDefaultPassword(db, Password(147, "APOCALYPSE NOW", cinema))
        setDefaultPassword(db, Password(148, "MILOS FORMAN", cinema))
        setDefaultPassword(db, Password(149, "ROCKY", cinema))

        val sport = Category(3, "SPORT")
        setDefaultCategory(db, sport)
        setDefaultPassword(db, Password(150, "BUNDESLIGA", sport))
        setDefaultPassword(db, Password(151, "SERIE A", sport))
        setDefaultPassword(db, Password(152, "FC BAYERN MUNICH", sport))
        setDefaultPassword(db, Password(153, "FC BARCELONA", sport))
        setDefaultPassword(db, Password(154, "REAL MADRID CF", sport))
        setDefaultPassword(db, Password(155, "JUVENTUS F.C.", sport))
        setDefaultPassword(db, Password(156, "A.C. MILAN", sport))
        setDefaultPassword(db, Password(157, "CHELSEA F.C.", sport))
        setDefaultPassword(db, Password(158, "TENNIS", sport))
        setDefaultPassword(db, Password(159, "TRIATHLON", sport))
        setDefaultPassword(db, Password(160, "SERENA WILLIAMS", sport))
        setDefaultPassword(db, Password(161, "BADMINTON", sport))
        setDefaultPassword(db, Password(162, "HOCKEY", sport))
        setDefaultPassword(db, Password(163, "YOGA", sport))
        setDefaultPassword(db, Password(164, "CRICKET", sport))
        setDefaultPassword(db, Password(165, "POOL", sport))
        setDefaultPassword(db, Password(166, "OLYMPIC GAMES", sport))
        setDefaultPassword(db, Password(167, "ROGER FEDERER", sport))
        setDefaultPassword(db, Password(168, "NEYMAR", sport))
        setDefaultPassword(db, Password(169, "LEBRON JAMES", sport))
        setDefaultPassword(db, Password(170, "USAIN BOLT", sport))
        setDefaultPassword(db, Password(171, "MARIA SHARAPOVA", sport))
        setDefaultPassword(db, Password(172, "MICHAEL PHELPS", sport))
        setDefaultPassword(db, Password(173, "MICHAEL JORDAN", sport))
        setDefaultPassword(db, Password(174, "VOLLEYBALL", sport))
        setDefaultPassword(db, Password(175, "BASKETBALL", sport))
        setDefaultPassword(db, Password(176, "GOLF", sport))
        setDefaultPassword(db, Password(177, "MUHAMMAD ALI", sport))
        setDefaultPassword(db, Password(178, "FITNESS", sport))
        setDefaultPassword(db, Password(179, "PILATES", sport))
        setDefaultPassword(db, Password(180, "LOS ANGELES LAKERS", sport))
        setDefaultPassword(db, Password(181, "CHICAGO BULLS", sport))
        setDefaultPassword(db, Password(182, "NEW YORK YANKEES", sport))
        setDefaultPassword(db, Password(183, "BOSTON RED SOCKS", sport))
        setDefaultPassword(db, Password(184, "NEW YORK METS", sport))
        setDefaultPassword(db, Password(185, "LIVERPOOL F.C.", sport))
        setDefaultPassword(db, Password(186, "RUGBY", sport))
        setDefaultPassword(db, Password(187, "BOXING", sport))
        setDefaultPassword(db, Password(188, "ARCHERY", sport))
        setDefaultPassword(db, Password(189, "LIONEL MESSI", sport))
        setDefaultPassword(db, Password(190, "CRISTIANO RONALDO", sport))
        setDefaultPassword(db, Password(191, "MO FARAH", sport))
        setDefaultPassword(db, Password(192, "ROBERT LEWANDOWSKI", sport))
        setDefaultPassword(db, Password(193, "JOGGING", sport))
        setDefaultPassword(db, Password(194, "GYMNASTICS", sport))
        setDefaultPassword(db, Password(195, "PARKOUR", sport))
        setDefaultPassword(db, Password(196, "ACROBATICS", sport))
        setDefaultPassword(db, Password(197, "SIMONA HALEP", sport))
        setDefaultPassword(db, Password(198, "BUZKASHI", sport))
        setDefaultPassword(db, Password(199, "SEPAK TAKRAW", sport))

        val music = Category(4, "MUSIC")
        setDefaultCategory(db, music)
        setDefaultPassword(db, Password(200, "KATE BUSH", music))
        setDefaultPassword(db, Password(201, "PINK FLOYD", music))
        setDefaultPassword(db, Password(202, "LED ZEPPELIN", music))
        setDefaultPassword(db, Password(203, "LUDWIG VAN BEETHOVEN", music))
        setDefaultPassword(db, Password(204, "INDIE ROCK", music))
        setDefaultPassword(db, Password(205, "BLACK METAL", music))
        setDefaultPassword(db, Password(206, "BRITNEY SPEARS", music))
        setDefaultPassword(db, Password(207, "DUA LIPA", music))
        setDefaultPassword(db, Password(208, "BLACK SABBATH", music))
        setDefaultPassword(db, Password(209, "FLEETWOOD MAC", music))
        setDefaultPassword(db, Password(210, "THE BEATLES", music))
        setDefaultPassword(db, Password(211, "NIRVANA", music))
        setDefaultPassword(db, Password(212, "RED HOT CHILLI PEPPERS", music))
        setDefaultPassword(db, Password(213, "LEONARD COHEN", music))
        setDefaultPassword(db, Password(214, "DAVID BOWIE", music))
        setDefaultPassword(db, Password(215, "QUEEN", music))
        setDefaultPassword(db, Password(216, "RADIOHEAD", music))
        setDefaultPassword(db, Password(217, "THOM YORKE", music))
        setDefaultPassword(db, Password(218, "HANS ZIMMER", music))
        setDefaultPassword(db, Password(219, "ANGELO BADALAMENTI", music))
        setDefaultPassword(db, Password(220, "ERIC CLAPTON", music))
        setDefaultPassword(db, Password(221, "ELTON JOHN", music))
        setDefaultPassword(db, Password(222, "GORILLAZ", music))
        setDefaultPassword(db, Password(223, "INTERPOL", music))
        setDefaultPassword(db, Password(224, "BAUHAUS", music))
        setDefaultPassword(db, Password(225, "JEFFERSON AIRPLANE", music))
        setDefaultPassword(db, Password(226, "IGGY POP", music))
        setDefaultPassword(db, Password(227, "KENDRICK LAMAR", music))
        setDefaultPassword(db, Password(228, "KANYE WEST", music))
        setDefaultPassword(db, Password(229, "SOUL", music))
        setDefaultPassword(db, Password(230, "RAP", music))
        setDefaultPassword(db, Password(231, "HIP-HOP", music))
        setDefaultPassword(db, Password(232, "THE VELVET UNDERGROUND", music))
        setDefaultPassword(db, Password(233, "PIXIES", music))
        setDefaultPassword(db, Password(234, "BJORK", music))
        setDefaultPassword(db, Password(235, "TOM WAITS", music))
        setDefaultPassword(db, Password(236, "THE CLASH", music))
        setDefaultPassword(db, Password(237, "RAMONES", music))
        setDefaultPassword(db, Password(238, "THE WHITE STRIPES", music))
        setDefaultPassword(db, Password(239, "KING GIZZARD & THE LIZARD WIZARD", music))
        setDefaultPassword(db, Password(240, "TALK TALK", music))
        setDefaultPassword(db, Password(241, "MODEST MOUSE", music))
        setDefaultPassword(db, Password(242, "FLEET FOXES", music))
        setDefaultPassword(db, Password(243, "WEEZER", music))
        setDefaultPassword(db, Password(244, "THE KINKS", music))
        setDefaultPassword(db, Password(245, "BOB DYLAN", music))
        setDefaultPassword(db, Password(246, "VANGELIS", music))
        setDefaultPassword(db, Password(247, "TYLER, THE CREATOR", music))
        setDefaultPassword(db, Password(248, "THE ROLLING STONES", music))
        setDefaultPassword(db, Password(249, "THE SMITHS", music))

        val animals = Category(5, "ANIMALS")
        setDefaultCategory(db, animals)
        setDefaultPassword(db, Password(250, "GIRAFFE", animals))
        setDefaultPassword(db, Password(251, "CHIMPANZEE", animals))
        setDefaultPassword(db, Password(252, "CAT", animals))
        setDefaultPassword(db, Password(253, "ENGLISH COCKER SPANIEL", animals))
        setDefaultPassword(db, Password(254, "ROTTWEILER", animals))
        setDefaultPassword(db, Password(255, "SPARROW", animals))
        setDefaultPassword(db, Password(256, "SEVEN-SPOT LADYBIRD", animals))
        setDefaultPassword(db, Password(257, "SIBERIAN HUSKY", animals))
        setDefaultPassword(db, Password(258, "BISON", animals))
        setDefaultPassword(db, Password(259, "MOOSE", animals))
        setDefaultPassword(db, Password(260, "REINDEER", animals))
        setDefaultPassword(db, Password(261, "ELEPHANT", animals))
        setDefaultPassword(db, Password(262, "GRIZZLY BEAR", animals))
        setDefaultPassword(db, Password(263, "YORKSHIRE TERRIER", animals))
        setDefaultPassword(db, Password(264, "CROCODILE", animals))
        setDefaultPassword(db, Password(265, "DINGO", animals))
        setDefaultPassword(db, Password(266, "BEAVER", animals))
        setDefaultPassword(db, Password(267, "BUFFALO", animals))
        setDefaultPassword(db, Password(268, "MAMMAL", animals))
        setDefaultPassword(db, Password(269, "PYTHON", animals))
        setDefaultPassword(db, Password(270, "COBRA", animals))
        setDefaultPassword(db, Password(271, "KANGAROO", animals))
        setDefaultPassword(db, Password(272, "TASMANIAN DEVIL", animals))
        setDefaultPassword(db, Password(273, "GIANT PANDA", animals))
        setDefaultPassword(db, Password(274, "SEAL", animals))
        setDefaultPassword(db, Password(275, "HAWK", animals))
        setDefaultPassword(db, Password(276, "HEDGEHOG", animals))
        setDefaultPassword(db, Password(277, "PORCUPINE", animals))
        setDefaultPassword(db, Password(278, "CHEVROTAIN", animals))
        setDefaultPassword(db, Password(279, "CAPYBARA", animals))
        setDefaultPassword(db, Password(280, "OKAPI", animals))
        setDefaultPassword(db, Password(281, "BINTORUNG", animals))
        setDefaultPassword(db, Password(282, "HONEY BADGER", animals))
        setDefaultPassword(db, Password(283, "ALBATROSS", animals))
        setDefaultPassword(db, Password(284, "SWAN", animals))
        setDefaultPassword(db, Password(285, "RHINOCEROS", animals))
        setDefaultPassword(db, Password(286, "DALMADOODLE", animals))
        setDefaultPassword(db, Password(287, "POMERANIAN", animals))
        setDefaultPassword(db, Password(288, "BEAGLE", animals))
        setDefaultPassword(db, Password(289, "PUG", animals))
        setDefaultPassword(db, Password(290, "CHIHUAHUA", animals))
        setDefaultPassword(db, Password(291, "CHOW CHOW", animals))
        setDefaultPassword(db, Password(292, "EARTHWORM", animals))
        setDefaultPassword(db, Password(293, "SHIH TZU", animals))
        setDefaultPassword(db, Password(294, "SEAHORSE", animals))
        setDefaultPassword(db, Password(295, "TUNA", animals))
        setDefaultPassword(db, Password(296, "BLOWFISH", animals))
        setDefaultPassword(db, Password(297, "TROUT", animals))
        setDefaultPassword(db, Password(298, "SALMON", animals))
        setDefaultPassword(db, Password(299, "HORSESHOE CRAB", animals))
    }

    private fun setDefaultCategory(db: SQLiteDatabase?, category: Category) {
        val values = ContentValues()
        values.put(CATEGORY_ID_COL, category.id)
        values.put(CATEGORY_NAME_COL, category.name)

        db?.insert(CATEGORY_TABLE,null, values)
    }

    private fun setDefaultPassword(db : SQLiteDatabase?, password: Password) {
        val values = ContentValues()
        values.put(PASSWORD_ID_COL, password.id)
        values.put(PASSWORD_WORD_COL, password.word)
        values.put(PASSWORD_CATEGORY_COL, password.category.id)

        db?.insert(PASSWORD_TABLE, null, values)
    }

    fun addGame(gameResult : GameResult) {
        val values = ContentValues()
        values.put(GAME_RESULT_STATUS_COL, gameResult.status)
        values.put(GAME_RESULT_DATE_COL, gameResult.date.time)

        writableDatabase.insert(GAME_RESULT_TABLE, null, values)
    }

    fun getPlayedGamesCount(): Int {
        val cursor = readableDatabase.rawQuery("SELECT * FROM $GAME_RESULT_TABLE", null)
        val result = cursor.count
        cursor.close()
        return result
    }

    fun getWonGamesCount(): Int {
        val cursor = readableDatabase.rawQuery("SELECT * FROM $GAME_RESULT_TABLE WHERE $GAME_RESULT_STATUS_COL = true", null)
        val result = cursor.count
        cursor.close()
        return result
    }

    fun clearGameResults(from : Date, to : Date) {
        writableDatabase.delete(GAME_RESULT_TABLE, "$GAME_RESULT_DATE_COL >= ${from.time} AND $GAME_RESULT_DATE_COL <= ${to.time}", null)
    }

    fun getRandomPassword() : Password? {
        val cursor = readableDatabase.rawQuery(
            "SELECT " +
                    "$PASSWORD_TABLE.$PASSWORD_ID_COL," +
                    "$PASSWORD_TABLE.$PASSWORD_WORD_COL," +
                    "$CATEGORY_TABLE.$CATEGORY_ID_COL," +
                    "$CATEGORY_TABLE.$CATEGORY_NAME_COL " +
                "FROM $PASSWORD_TABLE " +
                "JOIN $CATEGORY_TABLE " +
                "ON $PASSWORD_TABLE.$PASSWORD_CATEGORY_COL = $CATEGORY_TABLE.$CATEGORY_ID_COL " +
                "ORDER BY RANDOM() LIMIT 1"
            , null)
        var value: Password? = null
        if (cursor.moveToFirst()) {
            value = Password(cursor.getInt(0), cursor.getString(1), Category(cursor.getInt(2), cursor.getString(3)))
        }
        cursor.close()
        return value
    }

    companion object {
        private const val DATABASE_NAME = "HANGMAN"
        private const val DATABASE_VERSION = 1

        private const val CATEGORY_TABLE = "CATEGORY"
        private const val CATEGORY_ID_COL = "CATEGORY_ID"
        private const val CATEGORY_NAME_COL = "CATEGORY_NAME"

        private const val PASSWORD_TABLE = "PASSWORD"
        private const val PASSWORD_ID_COL = "PASSWORD_ID"
        private const val PASSWORD_WORD_COL = "PASSWORD_WORD"
        private const val PASSWORD_CATEGORY_COL = "PASSWORD_CATEGORY"

        private const val GAME_RESULT_TABLE = "GAME_RESULT"
        private const val GAME_RESULT_STATUS_COL = "GAME_RESULT_STATUS"
        private const val GAME_RESULT_DATE_COL = "GAME_RESULT_DATE"
    }
}