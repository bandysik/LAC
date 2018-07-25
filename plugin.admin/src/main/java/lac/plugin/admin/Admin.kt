package lac.plugin.admin

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

const val VERSION = "v1_0"
const val CITIES = VERSION + "/cities"
const val PROVIDERS = VERSION + "/providers"
const val FEEDS = VERSION + "/feeds"

object Admin {
    private val dateFormat = SimpleDateFormat("yyyyMMdd")
    fun addToDb(path: String, value: Any) {
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference(path)

        myRef.setValue(value)
    }

    fun pushToDb(path: String): DatabaseReference {
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference(path)

        return myRef.push()
    }

    fun pushToDb(path: String, key: String): DatabaseReference {
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference(path)

        return myRef.child(key)
    }

    fun addCity(code: String, name: String) {
        val city = City(code, name)
        addToDb(CITIES, city)
    }

    fun addProvider(id: String, name: String) {
        val provider = Provider(id, name)
        pushToDb(PROVIDERS, id).setValue(provider)
    }

    fun addFeed(city: String,
                description: String,
                provider: String,
                providerLink: String,
                created: String) {
        val ref = pushToDb(FEEDS)
        val feed = Feed(ref.key!!, city, description, provider, providerLink, created)
        ref.setValue(feed)
    }

    fun addFeeds() {
        Admin.addFeed("80152",
                      "Ищу девушку для совместной аренды жилья !!!Работаю(не студентка )!!!Все подробности в ЛС !!!",
                      "vk",
                      "https://new.vk.com/wall-66179230_16703",
                      dateFormat.format(Date()))
        Admin.addFeed("80152", "тест1", "vk", "https://google.com", dateFormat.format(Date()))
        Admin.addFeed("80152", "тест2", "vk", "https://google.com", dateFormat.format(Date()))
    }

    fun addProviders() {
        Admin.addProvider("kufar", "Куфар")
        Admin.addProvider("irr", "Из рук в руки")
        Admin.addProvider("onliner", "Онлайнер")
        Admin.addProvider("vk", "Вконтакте")
    }

    fun addCities() {
        val cities = ArrayList<City>()
        cities.add(City("80162", "Брест"))
        cities.add(City("80163", "Барановичи"))
        cities.add(City("801643", "Береза"))
        cities.add(City("801646", "Ганцевичи"))
        cities.add(City("801644", "Дрогичин"))
        cities.add(City("801641", "Жабинка"))
        cities.add(City("801652", "Иваново"))
        cities.add(City("801645", "Ивацевичи"))
        cities.add(City("801631", "Каменец"))
        cities.add(City("801642", "Кобрин"))
        cities.add(City("801647", "Лунинец"))
        cities.add(City("801633", "Ляховичи"))
        cities.add(City("801651", "Малорита"))
        cities.add(City("8016", "Пинск"))
        cities.add(City("801632", "Пружаны"))
        cities.add(City("80165", "Столин"))
        cities.add(City("80212", "Витебск"))
        cities.add(City("802131", "Бешенковичи"))
        cities.add(City("802153", "Браслав"))
        cities.add(City("802151", "Верхнедвинск"))
        cities.add(City("802156", "Глубокое"))
        cities.add(City("802139", "Городок"))
        cities.add(City("802157", "Докшицы"))
        cities.add(City("802137", "Дуброва"))
        cities.add(City("802132", "Лепель"))
        cities.add(City("802138", "Лиозно"))
        cities.add(City("802152", "Миоры"))
        cities.add(City("8021", "Новополоцк"))
        cities.add(City("802161", "Орша"))
        cities.add(City("8021", "Полоцк"))
        cities.add(City("802155", "Поставы"))
        cities.add(City("802159", "Россоны"))
        cities.add(City("802135", "Сенно"))
        cities.add(City("802136", "Толочин"))
        cities.add(City("802158", "Ушачи"))
        cities.add(City("802133", "Чашники"))
        cities.add(City("802154", "Шарковщина"))
        cities.add(City("80213", "Шумилино"))
        cities.add(City("80232", "Гомель"))
        cities.add(City("802322", "Гомель"))
        cities.add(City("802336", "Буда- Кошелево"))
        cities.add(City("802344", "Брагин"))
        cities.add(City("802330", "Ветка"))
        cities.add(City("802333", "Добруш"))
        cities.add(City("802354", "Ельск"))
        cities.add(City("802353", "Житковичи"))
        cities.add(City("802334", "Жлобин"))
        cities.add(City("802345", "Калинковичи"))
        cities.add(City("802337", "Корма"))
        cities.add(City("802356", "Лельчицы"))
        cities.add(City("802347", "Лоев"))
        cities.add(City("802351", "Мозырь"))
        cities.add(City("802355", "Наровля"))
        cities.add(City("802357", "Октябрьский"))
        cities.add(City("802350", "Петриков"))
        cities.add(City("802340", "Речица"))
        cities.add(City("802339", "Рогачев"))
        cities.add(City("802342", "Светлогорск"))
        cities.add(City("802346", "Хойники"))
        cities.add(City("80233", "Чечерск"))
        cities.add(City("80152", "Гродно"))
        cities.add(City("801511", "Берестовица"))
        cities.add(City("801512", "Волковыск"))
        cities.add(City("801594", "Вороново"))
        cities.add(City("801563", "Дятлово"))
        cities.add(City("801564", "Зельва"))
        cities.add(City("801595", "Ивье"))
        cities.add(City("801596", "Кореличи"))
        cities.add(City("801561", "Лида"))
        cities.add(City("801515", "Мосты"))
        cities.add(City("801597", "Новогрудок"))
        cities.add(City("801591", "Островец"))
        cities.add(City("801593", "Ошмяны"))
        cities.add(City("801513", "Свислочь"))
        cities.add(City("801562", "Слоним"))
        cities.add(City("801592", "Сморгонь"))
        cities.add(City("80151", "Щучин"))
        cities.add(City("8017", "Минск"))
        cities.add(City("801715", "Березино"))
        cities.add(City("801777", "Борисов"))
        cities.add(City("801771", "Вилейка"))
        cities.add(City("801772", "Воложин"))
        cities.add(City("801716", "Дзержинск"))
        cities.add(City("801775", "Жодино"))
        cities.add(City("801793", "Клецк"))
        cities.add(City("801719", "Копыль"))
        cities.add(City("801796", "Крупки"))
        cities.add(City("801774", "Логойск"))
        cities.add(City("801794", "Любань"))
        cities.add(City("801713", "Марьина Горка"))
        cities.add(City("801773", "Молодечно"))
        cities.add(City("801797", "Мядель"))
        cities.add(City("801797", "Нарочь"))
        cities.add(City("801770", "Несвиж"))
        cities.add(City("801779", "Плещеницы"))
        cities.add(City("801713", "Пуховичи"))
        cities.add(City("801795", "Слуцк"))
        cities.add(City("801776", "Смолевичи"))
        cities.add(City("801710", "Солигорск"))
        cities.add(City("801792", "Ст. Дороги"))
        cities.add(City("801717", "Столбцы"))
        cities.add(City("801718", "Узда"))
        cities.add(City("80171", "Червень"))
        cities.add(City("80222", "Могилев"))
        cities.add(City("802232", "Белыничи"))
        cities.add(City("802251", "Бобруйск"))
        cities.add(City("8022", "Бобруйск"))
        cities.add(City("802231", "Быхов"))
        cities.add(City("802230", "Глуск"))
        cities.add(City("802233", "Горки"))
        cities.add(City("802248", "Дрибин"))
        cities.add(City("802237", "Кировск"))
        cities.add(City("802244", "Климовичи"))
        cities.add(City("802236", "Кличев"))
        cities.add(City("802245", "Костюковичи"))
        cities.add(City("802238", "Краснополье"))
        cities.add(City("802241", "Кричев"))
        cities.add(City("802234", "Круглое"))
        cities.add(City("802240", "Мстиславль"))
        cities.add(City("802235", "Осиповичи"))
        cities.add(City("802246", "Славгород"))
        cities.add(City("802247", "Хотимск"))
        cities.add(City("802242", "Чаусы"))
        cities.add(City("802243", "Чериков"))
        cities.add(City("802239", "Шклов"))
        addToDb(CITIES, cities)
    }

    fun fill() {
        addCities()
        addProviders()
        addFeeds()
    }
}