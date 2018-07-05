package lac.plugin.admin

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.text.SimpleDateFormat
import java.util.*

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
        pushToDb(CITIES, code).setValue(city)
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
        Admin.addCity("80162", "Брест")
        Admin.addCity("80163", "Барановичи")
        Admin.addCity("801643", "Береза")
        Admin.addCity("801646", "Ганцевичи")
        Admin.addCity("801644", "Дрогичин")
        Admin.addCity("801641", "Жабинка")
        Admin.addCity("801652", "Иваново")
        Admin.addCity("801645", "Ивацевичи")
        Admin.addCity("801631", "Каменец")
        Admin.addCity("801642", "Кобрин")
        Admin.addCity("801647", "Лунинец")
        Admin.addCity("801633", "Ляховичи")
        Admin.addCity("801651", "Малорита")
        Admin.addCity("8016", "Пинск")
        Admin.addCity("801632", "Пружаны")
        Admin.addCity("80165", "Столин")
        Admin.addCity("80212", "Витебск")
        Admin.addCity("802131", "Бешенковичи")
        Admin.addCity("802153", "Браслав")
        Admin.addCity("802151", "Верхнедвинск")
        Admin.addCity("802156", "Глубокое")
        Admin.addCity("802139", "Городок")
        Admin.addCity("802157", "Докшицы")
        Admin.addCity("802137", "Дуброва")
        Admin.addCity("802132", "Лепель")
        Admin.addCity("802138", "Лиозно")
        Admin.addCity("802152", "Миоры")
        Admin.addCity("8021", "Новополоцк")
        Admin.addCity("802161", "Орша")
        Admin.addCity("8021", "Полоцк")
        Admin.addCity("802155", "Поставы")
        Admin.addCity("802159", "Россоны")
        Admin.addCity("802135", "Сенно")
        Admin.addCity("802136", "Толочин")
        Admin.addCity("802158", "Ушачи")
        Admin.addCity("802133", "Чашники")
        Admin.addCity("802154", "Шарковщина")
        Admin.addCity("80213", "Шумилино")
        Admin.addCity("80232", "Гомель")
        Admin.addCity("802322", "Гомель")
        Admin.addCity("802336", "Буда- Кошелево")
        Admin.addCity("802344", "Брагин")
        Admin.addCity("802330", "Ветка")
        Admin.addCity("802333", "Добруш")
        Admin.addCity("802354", "Ельск")
        Admin.addCity("802353", "Житковичи")
        Admin.addCity("802334", "Жлобин")
        Admin.addCity("802345", "Калинковичи")
        Admin.addCity("802337", "Корма")
        Admin.addCity("802356", "Лельчицы")
        Admin.addCity("802347", "Лоев")
        Admin.addCity("802351", "Мозырь")
        Admin.addCity("802355", "Наровля")
        Admin.addCity("802357", "Октябрьский")
        Admin.addCity("802350", "Петриков")
        Admin.addCity("802340", "Речица")
        Admin.addCity("802339", "Рогачев")
        Admin.addCity("802342", "Светлогорск")
        Admin.addCity("802346", "Хойники")
        Admin.addCity("80233", "Чечерск")
        Admin.addCity("80152", "Гродно")
        Admin.addCity("801511", "Берестовица")
        Admin.addCity("801512", "Волковыск")
        Admin.addCity("801594", "Вороново")
        Admin.addCity("801563", "Дятлово")
        Admin.addCity("801564", "Зельва")
        Admin.addCity("801595", "Ивье")
        Admin.addCity("801596", "Кореличи")
        Admin.addCity("801561", "Лида")
        Admin.addCity("801515", "Мосты")
        Admin.addCity("801597", "Новогрудок")
        Admin.addCity("801591", "Островец")
        Admin.addCity("801593", "Ошмяны")
        Admin.addCity("801513", "Свислочь")
        Admin.addCity("801562", "Слоним")
        Admin.addCity("801592", "Сморгонь")
        Admin.addCity("80151", "Щучин")
        Admin.addCity("8017", "Минск")
        Admin.addCity("801715", "Березино")
        Admin.addCity("801777", "Борисов")
        Admin.addCity("801771", "Вилейка")
        Admin.addCity("801772", "Воложин")
        Admin.addCity("801716", "Дзержинск")
        Admin.addCity("801775", "Жодино")
        Admin.addCity("801793", "Клецк")
        Admin.addCity("801719", "Копыль")
        Admin.addCity("801796", "Крупки")
        Admin.addCity("801774", "Логойск")
        Admin.addCity("801794", "Любань")
        Admin.addCity("801713", "Марьина Горка")
        Admin.addCity("801773", "Молодечно")
        Admin.addCity("801797", "Мядель")
        Admin.addCity("801797", "Нарочь")
        Admin.addCity("801770", "Несвиж")
        Admin.addCity("801779", "Плещеницы")
        Admin.addCity("801713", "Пуховичи")
        Admin.addCity("801795", "Слуцк")
        Admin.addCity("801776", "Смолевичи")
        Admin.addCity("801710", "Солигорск")
        Admin.addCity("801792", "Ст. Дороги")
        Admin.addCity("801717", "Столбцы")
        Admin.addCity("801718", "Узда")
        Admin.addCity("80171", "Червень")
        Admin.addCity("80222", "Могилев")
        Admin.addCity("802232", "Белыничи")
        Admin.addCity("802251", "Бобруйск")
        Admin.addCity("8022", "Бобруйск")
        Admin.addCity("802231", "Быхов")
        Admin.addCity("802230", "Глуск")
        Admin.addCity("802233", "Горки")
        Admin.addCity("802248", "Дрибин")
        Admin.addCity("802237", "Кировск")
        Admin.addCity("802244", "Климовичи")
        Admin.addCity("802236", "Кличев")
        Admin.addCity("802245", "Костюковичи")
        Admin.addCity("802238", "Краснополье")
        Admin.addCity("802241", "Кричев")
        Admin.addCity("802234", "Круглое")
        Admin.addCity("802240", "Мстиславль")
        Admin.addCity("802235", "Осиповичи")
        Admin.addCity("802246", "Славгород")
        Admin.addCity("802247", "Хотимск")
        Admin.addCity("802242", "Чаусы")
        Admin.addCity("802243", "Чериков")
        Admin.addCity("802239", "Шклов")
    }

    fun fill() {
        addCities()
        addProviders()
        addFeeds()
    }
}